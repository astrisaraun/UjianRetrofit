package com.adl.ujianretrofit
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.adl.ujianretrofit.model.GetAbsen
import com.adl.ujianretrofit.model.PostAbsen
import com.adl.ujianretrofit.service.RetrofitConfig
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_main_menu.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class MainMenu : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_menu)

        setupUI2()
    }

    private fun setupUI2() {
        btnChekIn.setOnClickListener {
            intent = Intent(this, Absen::class.java)
            startActivity(intent)
        }
        btnHistory.setOnClickListener{
            intent = Intent(this, history::class.java)
            startActivity(intent)

        }
        btnLogOut.setOnClickListener ({
            RetrofitConfig().getDataAbsen().addDataAbsenLO(inputUsername.text.toString()).enqueue(object : Callback<PostAbsen> {
                    override fun onResponse(
                        call: Call<PostAbsen>,
                        response: Response<PostAbsen>
                    ) {
                        Log.d("Response",response.body().toString())
                    }

                    override fun onFailure(call: Call<PostAbsen>, t: Throwable) {
                        Log.e("error request", t.localizedMessage.toString())
                    }

                })

            intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        })


    }
}
