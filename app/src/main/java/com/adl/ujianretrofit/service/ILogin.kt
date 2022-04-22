package com.adl.ujianretrofit.service

import com.adl.ujianretrofit.model.GetAbsen
import retrofit2.Call
import retrofit2.http.*

interface ILogin {
    @Headers("X-Api-Key:5DDFDB24A33EFA8718153CD092B3173D")
    @GET("api/login/all")
    fun getAlllogin(@Query("filter")query: String): Call<GetAbsen>

}