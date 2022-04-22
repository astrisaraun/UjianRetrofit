package com.adl.ujianretrofit

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.adl.ujianretrofit.model.GetAbsen
import com.adl.ujianretrofit.service.RetrofitConfig
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

            setupUI()
    }
    fun setupUI(){
        btnLogin.setOnClickListener({
            RetrofitConfig().getLogin().getAlllogin(inputUsername.text.toString()).enqueue(object : Callback<GetAbsen> {
                    override fun onResponse(call: Call<GetAbsen>, response: Response<GetAbsen>) {
                        var data = response.body()?.data?.login
                        if (response.isSuccessful) {
                            Log.d("data", "${data}")
                            if (data?.size == 0) {

                            } else {

                                var currentUser = response.body()?.data?.login?.get(0)
                                if (currentUser?.password == inputPaswword.text.toString()) {
                                    val intent = Intent(this@MainActivity, MainMenu::class.java)
                                    intent.putExtra("data", currentUser)
                                    startActivity(intent)
                                }
                            }
                        }
                    }
                override fun onFailure(call: Call<GetAbsen>, t: Throwable) {
                }
            })
        })
    }
}








