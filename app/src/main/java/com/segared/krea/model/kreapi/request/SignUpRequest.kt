package com.segared.krea.model.kreapi.request

data class SignUpRequest(
    val name: String,
    val lastName: String,
    val phone: String,
    val street: String,
    val outdoorNumber: String,
    val email: String,
    val password: String
)