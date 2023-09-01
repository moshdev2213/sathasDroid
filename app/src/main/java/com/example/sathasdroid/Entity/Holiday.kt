package com.example.sathasdroid.Entity

import java.io.Serializable

data class Holiday(
    val date: String,
    val localName: String,
    val name: String,
    val countryCode: String,
    val fixed: Boolean,
    val global: Boolean,
    val counties: ArrayList<String>,
    val launchYear: String,
    val type: String
):Serializable
