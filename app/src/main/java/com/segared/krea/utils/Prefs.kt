package com.segared.krea.utils

import android.content.Context

class Prefs(val context: Context) {
    val SHARED_DB = "MyDb"
    val SHARED_USER_ID = "username"
    val SHARED_USER_ROL = "rol"

    val storage = context.getSharedPreferences(SHARED_DB,0)

    fun saveId(id:Int) {
        storage.edit().putInt(SHARED_USER_ID, id).apply()
    }

    fun getId():Int{
        return storage.getInt(SHARED_USER_ID, -1)
    }

    fun saveRol(id:Int) {
        storage.edit().putInt(SHARED_USER_ROL, id).apply()
    }

    fun getRol():Int{
        return storage.getInt(SHARED_USER_ROL, -1)
    }

    fun deleteShared() {
        storage.edit().clear().apply()
    }

}