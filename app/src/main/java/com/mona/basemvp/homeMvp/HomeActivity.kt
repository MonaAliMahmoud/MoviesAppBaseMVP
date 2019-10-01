package com.mona.basemvp.homeMvp

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import com.mona.basemvp.R
import com.mona.basemvp.base.BaseActivity
import com.mona.basemvp.details_mvp.DetailsActivity
import com.mona.basemvp.pojo.PopularInfo
import java.util.ArrayList

class HomeActivity : BaseActivity<HomePresenter>(), HomeContract.HomeIView {

    private lateinit var swipeRefresh: SwipeRefreshLayout
    private lateinit var recyclerView: RecyclerView
    private lateinit var listLayoutManager: LinearLayoutManager

    private lateinit var listAdapter: MyListAdapter
    private var popularInfos = ArrayList<PopularInfo>()

    override val presenter: HomePresenter = HomePresenter(this, HomeRepository())

    override fun getLayoutResourceId() = R.layout.activity_home

    override fun onViewReady(bundle: Bundle?) {
        swipeRefresh = findViewById(R.id.swipe_refresh)
        recyclerView = findViewById(R.id.my_recycler_view)

        listLayoutManager = LinearLayoutManager(this)
        configRecycleView(popularInfos)

        recyclerView.addOnScrollListener(object : RecyclerView.OnScrollListener() {
            override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                super.onScrolled(recyclerView, dx, dy)
                val currentItems = listLayoutManager.childCount
                val scrolledItems = listLayoutManager.findFirstCompletelyVisibleItemPosition()
                val totalItems = listLayoutManager.itemCount
                if (currentItems + scrolledItems == totalItems) {
                    presenter.loadNextPage()
                }
            }
        })

        swipeRefresh.setOnRefreshListener {
            Handler().postDelayed({
                swipeRefresh.isRefreshing = false
                presenter.refresh(popularInfos)
            }, 1000)
        }
    }

    override fun configRecycleView(popularInfos: ArrayList<PopularInfo>) {
        listAdapter = MyListAdapter(popularInfos, this@HomeActivity)
        recyclerView.adapter = listAdapter
        recyclerView.setHasFixedSize(true)
        recyclerView.setItemViewCacheSize(20)
        recyclerView.isDrawingCacheEnabled = true
        recyclerView.layoutManager = listLayoutManager
    }

    override fun changeList() {
        recyclerView.setHasFixedSize(true)
        recyclerView.setItemViewCacheSize(20)
        recyclerView.isDrawingCacheEnabled = true
        listAdapter.notifyDataSetChanged()
        recyclerView.layoutManager = listLayoutManager
    }

    override fun addPopularList(popularInfo: PopularInfo) {
        popularInfos.add(popularInfo)
    }

    override fun goToDetailsScreen(imgPath: String, popularInf: PopularInfo) {
        val intent = Intent(this, DetailsActivity::class.java)
        val arg = Bundle()
        arg.putString("popName", popularInf.name)
        arg.putString("popeDepart", popularInf.known_for_department)
        arg.putString("profile", imgPath + popularInf.profile_path)
        arg.putInt("id", popularInf.id)
        intent.putExtra("data", arg)
        startActivity(intent)
    }
}
