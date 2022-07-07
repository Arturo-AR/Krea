package com.segared.krea.network

import com.segared.krea.model.kreapi.response.LoginResponse
import com.segared.krea.model.kreapi.response.SignUpResponse
import retrofit2.Response
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST
import retrofit2.http.Query

interface KreaApi {

    @FormUrlEncoded
    @POST("ws.php")
    suspend fun login(
        @Query("opc") opc: Int,
        @Field("correo") email: String,
        @Field("password") password: String
    ): Response<LoginResponse>

    @FormUrlEncoded
    @POST("ws.php")
    suspend fun signUp(
        @Query("opc") opc: Int,
        @Field("usuario_info") userInfo: String
    ): Response<SignUpResponse>
}