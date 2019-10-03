package com.mona.basemvp.retrofit

import com.mona.basemvp.base.RemoteDataSource.Companion.POPULAR_PEOPLE_URL
import com.mona.basemvp.base.RemoteDataSource.Companion.SEARCH_URL
import com.mona.basemvp.pojo.PopularList
import com.mona.basemvp.pojo.PopularProfile
import io.reactivex.Single
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface RetrofitApi {
    @GET(POPULAR_PEOPLE_URL)
    fun getPopularData(@Query ("page") page: Int): Single<PopularList>

    @GET(SEARCH_URL)
    fun searching(@Query ("query") searchStr: String, @Query ("page") page: Int): Single<PopularList>

    @GET("person/{popularId}/images?")
    fun getProfiles(@Path ("popularId") popularId: String): Call<PopularProfile>
}