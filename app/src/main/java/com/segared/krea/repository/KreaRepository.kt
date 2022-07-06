package com.segared.krea.repository

import com.segared.krea.model.kreapi.response.LoginResponse
import com.segared.krea.network.KreaApi
import retrofit2.Response
import javax.inject.Inject

class KreaRepository @Inject constructor(private val api: KreaApi) {
    suspend fun login(email: String, password: String): Response<LoginResponse> {
        return api.login(0, email, password)
    }
}