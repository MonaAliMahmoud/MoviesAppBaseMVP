package com.mona.basemvp.details_mvp

import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.mona.basemvp.R
import com.mona.basemvp.base.BaseActivity
import com.mona.basemvp.pojo.Profiles
import java.util.ArrayList

class DetailsActivity: BaseActivity<DetailsPresenter>(), DetailsContract.DetailsIView {

    private var name: TextView? = null
    private var depart: TextView? = null
    private var gender: TextView? = null
    private var popularity: TextView? = null
    private var adult: TextView? = null
    private var profile: ImageView? = null
    private var gridPhotos: RecyclerView? = null
    private lateinit var detailsAdapter: ImagesAdapter
    private var gridLayoutManager: GridLayoutManager? = null

    private var popularPictures = ArrayList<Profiles>()

    private var detailsIntent: Intent? = null
    private var detailsBundle: Bundle? = null

    private var popName: String? = null
    private var popDepart: String? = null
    private var popProfile: String? = null
    private var popAdult: Boolean? = null
    private var popGender: Int = 0
    private var popId: Int = 0
    private var popPopular: Float = 0.toFloat()

    override val presenter: DetailsPresenter = DetailsPresenter(this, DetailsRepository())

    override fun getLayoutResourceId(): Int = R.layout.activity_details

    override fun onViewReady(bundle: Bundle?) {
        name = findViewById(R.id.txt_name)
        depart = findViewById(R.id.txt_depart)
        gender = findViewById(R.id.txt_gender)
        popularity = findViewById(R.id.txt_popularity)
        adult = findViewById(R.id.txt_adult)
        profile = findViewById(R.id.profile_img)
        gridPhotos = findViewById(R.id.photos)

        gridLayoutManager = GridLayoutManager(this@DetailsActivity, 2)

        configGridRecycleView(popularPictures)
        detailsIntent = intent
        detailsBundle = detailsIntent!!.getBundleExtra("data")

        if (!detailsBundle!!.isEmpty) {
            popName = detailsBundle!!.getString("popName")
            popDepart = detailsBundle!!.getString("popeDepart")
            popAdult = detailsBundle!!.getBoolean("popAdult")
            popGender = detailsBundle!!.getInt("popGender")
            popPopular = detailsBundle!!.getFloat("popPopular")
            popProfile = detailsBundle!!.getString("profile")
            popId = detailsBundle!!.getInt("id")
        }

        name!!.text = popName
        depart!!.text = popDepart
        adult!!.text = "Adult: " + popAdult!!
        gender!!.text = "Gender: $popGender"
        popularity!!.text = "Popularity: $popPopular"

        presenter.popularId = popId

        Glide.with(this)
            .load(popProfile)
            .into(profile!!)
    }

    override fun configGridRecycleView(profiles: ArrayList<Profiles>) {
        detailsAdapter = ImagesAdapter(profiles, this@DetailsActivity)
        gridPhotos!!.adapter = detailsAdapter
        gridPhotos!!.setHasFixedSize(true)
        gridPhotos!!.setItemViewCacheSize(20)
        gridPhotos!!.isDrawingCacheEnabled = true
        gridPhotos!!.layoutManager = gridLayoutManager
    }

    override fun changeGrid() {
        gridPhotos!!.setHasFixedSize(true)
        gridPhotos!!.setItemViewCacheSize(20)
        gridPhotos!!.isDrawingCacheEnabled = true
        detailsAdapter.notifyDataSetChanged()
        gridPhotos!!.layoutManager = gridLayoutManager
    }

    override fun addPopularDetails(profiles: Profiles) {
        popularPictures.add(profiles)
    }

    override fun goToFullImageScreen(imgPath: String, prof: Profiles) {
        val intent = Intent(this, FullImageActivity::class.java)
        val arg = Bundle()
        arg.putString("picture_path", imgPath + prof.file_path)
        intent.putExtra("data", arg)
        startActivity(intent)
    }
}