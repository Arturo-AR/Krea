package com.segared.krea.screens.login

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.segared.krea.repository.KreaRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LoginScreenViewModel @Inject constructor(private val repository: KreaRepository) :
    ViewModel() {

    fun login(email: String, password: String, home: () -> Unit) {
        viewModelScope.launch {
            try {
                if (repository.login(email, password) == "") {
                    home()
                } else {
                    Log.d("Error", "An error in login")
                }
            } catch (ex: Exception) {
                Log.d("Error Login", "Error at login: ${ex.message}")
            }
        }
    }
}

