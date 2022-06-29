package com.segared.krea.model.kreapi.response

import com.google.gson.annotations.SerializedName

data class LoginResponse(
    @SerializedName("codigo") val responseCode: String,
    @SerializedName("mensaje") val responseMessage: String,
    @SerializedName("objetoRespuesta") val responseObject: LoginObject?
)

data class LoginObject(
    @SerializedName("activa") val active: Boolean,
    @SerializedName("correo") val email: String,
    @SerializedName("id_usuario") val userId: Int,
    @SerializedName("nombreUsuario") val userName: String,
    @SerializedName("apellidoUsuario") val userLastName: String,
)