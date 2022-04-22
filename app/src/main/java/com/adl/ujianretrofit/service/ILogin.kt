package com.adl.ujianretrofit.service

import com.adl.ujianretrofit.model.PostLogin
import okhttp3.RequestBody
import retrofit2.Call
import retrofit2.http.*

interface ILogin {
    @Headers("X-Api-Key:5DDFDB24A33EFA8718153CD092B3173D")
    @GET("api/login/all")
    fun getAlllogin(): Call<PostLogin>

    @FormUrlEncoded
    @Headers("X-Api-Key:5DDFDB24A33EFA8718153CD092B3173D")
    @POST("api/login/add")
    fun addDataLogin(
        @Field("username") username: String,
        @Field("password") password: String,

    ): Call<PostLogin>


    @Multipart
    @Headers("X-Api-Key:5DDFDB24A33EFA8718153CD092B3173D")
    @POST("api/login/add")
    fun addData(@Part("id_user") id_user: RequestBody,
                        @Part("latitude") latitude: RequestBody,
                        @Part("longitude") longitude: RequestBody,
                        @Part("timestamp") timestamp: RequestBody,
    ): Call<PostLogin>
}