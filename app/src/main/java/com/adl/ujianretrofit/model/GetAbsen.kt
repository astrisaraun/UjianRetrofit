package com.adl.ujianretrofit.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class GetAbsen(

	@field:SerializedName("total")
	val total: Int? = null,

	@field:SerializedName("data")
	val data: Data? = null,

	@field:SerializedName("message")
	val message: String? = null,

	@field:SerializedName("status")
	val status: Boolean? = null
) : Parcelable

@Parcelize
data class Data(

	@field:SerializedName("absen")
	val absen: List<AbsenItem?>? = null
) : Parcelable

@Parcelize
data class AbsenItem(

	@field:SerializedName("tanggalMasuk")
	val tanggalMasuk: String? = null,

	@field:SerializedName("dataFoto")
	val dataFoto: String? = null,

	@field:SerializedName("lokasi")
	val lokasi: String? = null,

	@field:SerializedName("tanggalKeluar")
	val tanggalKeluar: String? = null,

	@field:SerializedName("id")
	val id: String? = null,

	@field:SerializedName("username")
	val username: String? = null
) : Parcelable
