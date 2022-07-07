package com.segared.krea.model.kreapi.response

import com.google.gson.annotations.SerializedName

data class SignUpResponse(
    @SerializedName("codigo") val responseCode: String,
    @SerializedName("mensaje") val responseMessage: String,
    @SerializedName("objetoRespuesta") val responseObject: SignUpObject?
)

data class SignUpObject(
    @SerializedName("id_user") val userId:Int
)
