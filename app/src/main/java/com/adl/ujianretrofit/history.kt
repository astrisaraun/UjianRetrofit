package com.adl.ujianretrofit

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.adl.ujianretrofit.history
import com.adl.ujianretrofit.model.GetAbsen
import com.adl.ujianretrofit.service.RetrofitConfig
import kotlinx.android.synthetic.main.activity_history.*
import kotlinx.android.synthetic.main.activity_main_menu.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit

class history : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_history)}}

//        setupUI()
//    }
//
//        fun setupUI() {
//            history.setOnClickListener {
//                RetrofitConfig().getDataAbsen().getAllAbsen().enqueue(object : Callback<GetAbsen> {
//                    override fun onResponse(
//                        call: Call<GetAbsen>,
//                        response: Response<GetAbsen>
//                    ) {
//                        Log.d("Response",response.body().toString())
//                    }
//
//                    override fun onFailure(call: Call<GetAbsen>, t: Throwable) {
//                        Log.e("error request",t.localizedMessage.toString())
//                    }
//
//
//                })
//            }
//        }
//
//
//}
