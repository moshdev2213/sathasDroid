package com.example.sathasdroid

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Adapter
import android.widget.Toast
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.sathasdroid.APIService.HolidayService
import com.example.sathasdroid.Adapter.ViewHomeAdapter
import com.example.sathasdroid.Entity.Holiday
import com.example.sathasdroid.RetrofitService.RetrofitService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    private lateinit var rvHoliday:RecyclerView
    private lateinit var adapter: ViewHomeAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Thread.sleep(3000)
        installSplashScreen()
        setContentView(R.layout.activity_main)


        initRecyclerView()
    }
    private fun initRecyclerView(){
        rvHoliday = findViewById(R.id.rvHoliday)
        rvHoliday.layoutManager = LinearLayoutManager(this@MainActivity)
        adapter =ViewHomeAdapter { holiday: Holiday -> holidayCardClicked(holiday) }

        rvHoliday.adapter = adapter
        callAPI()
    }

    private fun callAPI(){
        val retrofitService=RetrofitService()
        val getList =retrofitService.getRetrofit().create(HolidayService::class.java)

        val call: Call<List<Holiday>> =getList.getHolidayDetails()
        call.enqueue(object :Callback<List<Holiday>>{
            override fun onResponse(call: Call<List<Holiday>>, response: Response<List<Holiday>>) {
                if(response.isSuccessful){
                    if (response.body()!=null){
                        adapter.setList(response.body()!!)
                    }
                }else{
                    Toast.makeText(this@MainActivity,"Invalid response", Toast.LENGTH_SHORT).show()
                }
            }

            override fun onFailure(call: Call<List<Holiday>>, t: Throwable) {
                Toast.makeText(this@MainActivity,"Server Error", Toast.LENGTH_SHORT).show()
            }
        })
    }
    private fun holidayCardClicked(holiday: Holiday) {
        val bundle = Bundle()
        bundle.putSerializable("holiday", holiday)

        val intent = Intent(this@MainActivity,ViewHoliday::class.java)
        intent.putExtras(bundle)
        startActivity(intent)
    }

}