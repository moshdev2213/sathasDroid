package com.example.sathasdroid

import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.annotation.RequiresApi
import com.example.sathasdroid.Entity.Holiday

class ViewHoliday : AppCompatActivity() {
    private lateinit var holiday:Holiday
    private lateinit var tvViewType:TextView
    private lateinit var tvViewName:TextView
    private lateinit var tvViewDay:TextView
    private lateinit var imgBackBtn:ImageView

    @RequiresApi(Build.VERSION_CODES.TIRAMISU)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_view_holiday)

        tvViewType = findViewById(R.id.tvViewType)
        tvViewName = findViewById(R.id.tvViewName)
        tvViewDay = findViewById(R.id.tvViewDay)
        imgBackBtn = findViewById(R.id.imgBackBtn)

        imgBackBtn.setOnClickListener {
            finish()
        }

        val bundle = intent.extras
        holiday = bundle?.getSerializable("holiday",Holiday::class.java)!!

        tvViewType.text = holiday.type
        tvViewDay.text = holiday.date
        tvViewName.text = holiday.name
    }
}