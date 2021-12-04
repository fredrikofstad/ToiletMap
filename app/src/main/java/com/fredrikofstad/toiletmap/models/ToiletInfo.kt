package com.fredrikofstad.toiletmap.models

import java.io.Serializable

class ToiletInfo(
    val title: String,
    val description: String,
    val latitude: Double,
    val longitude: Double) : Serializable