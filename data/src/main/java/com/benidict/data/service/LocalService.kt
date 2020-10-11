package com.benidict.data.service

import android.content.SharedPreferences

class LocalService (private val sharedPreferences: SharedPreferences){
    fun write(key: String?, value: String?) {
        sharedPreferences.edit().putString(key, value).apply()
    }

    fun deleteCache(key: String?){
        sharedPreferences.edit().remove(key).apply()
    }

    fun write(key: String?, value: Boolean){
        sharedPreferences.edit().putBoolean(key, value).apply()
    }

    fun readString(key: String?): String? = sharedPreferences.getString(key, "")

    fun readBool(key: String): Boolean = sharedPreferences.getBoolean(key, false)
}