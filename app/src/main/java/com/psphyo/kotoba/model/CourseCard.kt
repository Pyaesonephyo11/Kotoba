package com.psphyo.kotoba.model

data class CourseCard(
    val id:Int,
    val image:Int,
    val title:String,
    val qty:String
){
    constructor():this(1,1,"","")
}
