package com.adl.ujianretrofit.service

import com.adl.ujianretrofit.model.PostAbsen
import retrofit2.Call
import retrofit2.http.*

interface IAbsen {

    @Headers("X-Api-Key:5DDFDB24A33EFA8718153CD092B3173D")
    @GET("api/absen/all")
    fun getAllAbsen(): Call<PostAbsen>

    @FormUrlEncoded
    @Headers("X-Api-Key:5DDFDB24A33EFA8718153CD092B3173D")
    @POST("api/absen/add")
    fun addDataAbsen(
        @Field("username") username: String,
        @Field("password") password: String,
        @Field("tanggalMasuk") tanggalMasuk:String,
        @Field("tanggalKeluar") tanggalKeluar:String,
        @Field("lokasi") lokasi:String

        ): Call<PostAbsen>

}