package com.example.sathasdroid

import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.annotation.RequiresApi
import com.example.sathasdroid.Entity.Holiday

/*
* The Activity Class Is Used For ViewHoliday
* */
class ViewHoliday : AppCompatActivity() {
    // Declare UI elements
    private lateinit var holiday:Holiday
    private lateinit var tvViewType:TextView
    private lateinit var tvViewName:TextView
    private lateinit var tvViewDay:TextView
    private lateinit var imgBackBtn:ImageView

    @RequiresApi(Build.VERSION_CODES.TIRAMISU)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_view_holiday)
        // Initialize UI elements
        initializeUIElements()

        // Set up the back button click listener
        setUpBackButtonListener()

        // Retrieve holiday object from the intent's extras
        retrieveHolidayFromIntent()

        // Display holiday information in TextViews
        displayHolidayInfo()
    }

    // Initialize UI elements
    private fun initializeUIElements() {
        tvViewType = findViewById(R.id.tvViewType)
        tvViewName = findViewById(R.id.tvViewName)
        tvViewDay = findViewById(R.id.tvViewDay)
        imgBackBtn = findViewById(R.id.imgBackBtn)
    }
    // Set up the back button click listener
    private fun setUpBackButtonListener() {
        imgBackBtn.setOnClickListener {
            finish() // Close the current activity and go back
        }
    }
    // Retrieve holiday object from the intent's extras
    @RequiresApi(Build.VERSION_CODES.TIRAMISU)
    private fun retrieveHolidayFromIntent() {
        val bundle = intent.extras
        holiday = bundle?.getSerializable("holiday", Holiday::class.java)!!
    }

    // Display holiday information in TextViews
    private fun displayHolidayInfo() {
        tvViewType.text = holiday.type
        tvViewDay.text = holiday.date
        tvViewName.text = holiday.name
    }

}