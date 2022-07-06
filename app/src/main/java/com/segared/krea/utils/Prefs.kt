package com.segared.krea.utils

import android.content.Context

class Prefs(val context: Context) {
    val SHARED_DB = "MyDb"
    val SHARED_USER_ID = "username"

    val storage = context.getSharedPreferences(SHARED_DB,0)

    fun saveId(id:Int) {
        storage.edit().putInt(SHARED_USER_ID, id).apply()
    }

    fun getId():Int{
        return storage.getInt(SHARED_USER_ID, -1)
    }

    fun deleteId() {
        storage.edit().clear().apply()
    }
}