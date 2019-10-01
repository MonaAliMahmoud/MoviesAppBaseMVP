package com.mona.basemvp.home_mvp

import android.util.Log
import com.mona.basemvp.base.BaseRepository
import com.mona.basemvp.pojo.PopularInfo
import com.mona.basemvp.pojo.PopularList
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class HomeRepository: BaseRepository(), HomeContract.HomeIRepository {

    var popularInfo: ArrayList<PopularInfo>? = null

    override fun getUrl(pageNum: Int, loadData: (popularInfo: PopularInfo?) -> Unit) {
        remoteDataSource.service.callJson(pageNum)
            .enqueue(object : Callback<PopularList> {
                override fun onFailure(call: Call<PopularList>, t: Throwable) {
                    Log.i("","Failed to add item")
                }

                override fun onResponse(call: Call<PopularList>, response: Response<PopularList>) {
                    if(response.isSuccessful){
                        popularInfo = response.body()!!.results
                        for (i in 0 until popularInfo!!.size) {
                            loadData(popularInfo!![i])
                            Log.i("", "Successfully Added")
                        }
                    }
                    else{
                        Log.i("","Failed to connect server")
                    }
                }
            })
    }

    override fun getSearchList(searchStr: String, pageNum: Int, loadData: (popularInfo: PopularInfo?) -> Unit) {
        remoteDataSource.service.searching(searchStr, pageNum)
            .enqueue(object : Callback<PopularList> {
                override fun onFailure(call: Call<PopularList>, t: Throwable) {
                    Log.i("","Failed to add item")
                }

                override fun onResponse(call: Call<PopularList>, response: Response<PopularList>) {
                    if(response.isSuccessful){
                        popularInfo = response.body()!!.results
                        for (i in 0 until popularInfo!!.size) {
                            loadData(popularInfo!![i])
                            Log.i("", "Successfully Added")
                        }
                    }
                    else{
                        Log.i("","Failed to connect server")
                    }
                }
            })
    }
}