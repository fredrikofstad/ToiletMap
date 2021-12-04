package com.fredrikofstad.toiletmap.models

import java.io.Serializable

data class UserMap(val title: String, val toilets: List<ToiletInfo>) : Serializable