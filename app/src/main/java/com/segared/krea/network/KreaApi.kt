package com.segared.krea.network

import retrofit2.Response
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

interface KreaApi {

    @FormUrlEncoded
    @POST("")
    suspend fun login(
        @Field("email") email: String,
        @Field("password") password: String

    ): Response<String>
}