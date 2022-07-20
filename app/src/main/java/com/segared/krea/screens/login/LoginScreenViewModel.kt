package com.segared.krea.screens.login

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.segared.krea.KreaApplication.Companion.prefs
import com.segared.krea.repository.KreaRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LoginScreenViewModel @Inject constructor(private val repository: KreaRepository) :
    ViewModel() {

    fun login(email: String, password: String, onSuccess: () -> Unit, onError: () -> Unit, unValidate: () -> Unit) {
        viewModelScope.launch {
            try {
                val response = repository.login(email, password).body()
                if (response?.responseCode == "exito") {
                    if (response.responseMessage == "Aun no verificada"){
                        unValidate()
                    }else{
                        prefs.saveId(response.responseObject?.userId!!)
                        prefs.saveRol(response.responseObject.rol)
                        onSuccess()
                    }
                } else {
                    onError()
                }
            } catch (ex: Exception) {
                Log.d("Error Login", "Error at login: ${ex.message}")
            }
        }
    }
}

