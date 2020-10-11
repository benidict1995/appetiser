package com.benidict.core.util

import java.text.SimpleDateFormat
import java.util.*

fun currentDateTime(): String{
    val sdf = SimpleDateFormat("yyyy-MM-dd hh:mm:ss a", Locale.getDefault())
    return sdf.format(Date())
}