package com.psphyo.kotoba.model

import com.google.firebase.database.IgnoreExtraProperties

@IgnoreExtraProperties
data class GoiData(
    val level:String?=null,
    val week:String?=null,
    val day:String?=null,
    val jp:String?=null,
    val en:String?=null,
    val mm:String?=null
)