package com.segared.krea.screens.signup

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.segared.krea.KreaApplication.Companion.prefs
import com.segared.krea.model.kreapi.request.SignUpRequest
import com.segared.krea.repository.KreaRepository
import com.segared.krea.utils.toJsonString
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SignupScreenViewModel @Inject constructor(private val repository: KreaRepository) :
    ViewModel() {

    fun signUp(userInfo: String, onSuccess: () -> Unit, onError: () -> Unit) {
        viewModelScope.launch {
            try {
                val response = repository.signUp(userInfo).body()
                if (response?.responseCode == "exito") {
                    //prefs.saveId(response.responseObject?.userId!!)
                    onSuccess()
                } else {
                    onError()
                }
            } catch (ex: Exception) {
                Log.d("Error signUp", "Error at signUp: ${ex.message}")
            }
        }
    }

    fun createInfo(
        name: String,
        lastName: String,
        phone: String,
        street: String,
        outdoorNumber: String,
        email: String,
        password: String
    ): String {
        return SignUpRequest(
            name = name,
            lastName = lastName,
            phone = phone,
            street = street,
            outdoorNumber = outdoorNumber,
            email = email,
            password = password
        ).toJsonString()
    }
}