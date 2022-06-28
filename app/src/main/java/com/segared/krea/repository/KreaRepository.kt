package com.segared.krea.repository

import com.segared.krea.network.KreaApi
import retrofit2.Response
import javax.inject.Inject

class KreaRepository @Inject constructor(private val api: KreaApi) {

    suspend fun login(email: String, password: String): /*Response<String>*/String {
        //return api.login(email, password)
        return ""
    }
}