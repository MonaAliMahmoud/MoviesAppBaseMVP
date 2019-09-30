package com.mona.basemvp.details_mvp

import android.util.Log
import com.mona.basemvp.base.BaseRepository
import com.mona.basemvp.pojo.PopularProfile
import com.mona.basemvp.pojo.Profiles
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class DetailsRepository : BaseRepository(), DetailsContract.DetailsIRepository{
    var profileList: ArrayList<Profiles>? = null

    override fun getPopProfiles(popularId: String, loadProfile: (profile: Profiles?) -> Unit) {
        remoteDataSource.service.getProfiles(popularId)
            .enqueue(object :Callback<PopularProfile>{
                override fun onFailure(call: Call<PopularProfile>, t: Throwable) {
                    Log.i("","Failed to add item")
                }

                override fun onResponse(call: Call<PopularProfile>, response: Response<PopularProfile>) {
                    if(response.isSuccessful) {
                        profileList = response.body()!!.profiles
                        for (i in 0 until profileList!!.size) {
                            loadProfile(profileList!![i])
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