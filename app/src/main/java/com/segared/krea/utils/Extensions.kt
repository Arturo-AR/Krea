package com.segared.krea.utils

import com.google.gson.Gson
import java.math.BigInteger
import java.security.MessageDigest

fun String.toMD5(): String {
    val md = MessageDigest.getInstance("MD5")
    return BigInteger(1, md.digest(this.toByteArray())).toString(16).padStart(32, '0')
}

fun Any.toJsonString(): String {
    val gson = Gson()
    return gson.toJson(this)
}