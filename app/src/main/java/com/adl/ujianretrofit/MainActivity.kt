package com.adl.ujianretrofit

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.adl.ujianretrofit.model.PostLogin
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

        fun setupUI() {


            btnLogin.setOnClickListener({
                intent = Intent(this, MainMenu::class.java)
                startActivity(intent)
                RetrofitConfig().getLogin()
                    .addDataLogin(inputUsername.text.toString(), inputPaswword.text.toString())
                    .enqueue(object : Callback<PostLogin> {
                        override fun onResponse(
                            call: Call<PostLogin>,
                            response: Response<PostLogin>
                        ) {
                            Log.d("Response",response.body().toString())
                        }

                        override fun onFailure(call: Call<PostLogin>, t: Throwable) {
                            Log.e("error request", t.localizedMessage.toString())
                        }

                    })
            })
        }
    }

