package com.productapp.viewModel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.productapp.service.repository.SecurityPreferences

class ProfileViewModel(application: Application): AndroidViewModel(application) {

    private val securityPreferences = SecurityPreferences(application.applicationContext)

    private val _firstName = MutableLiveData<String>()
    val firstName: LiveData<String> = _firstName

    private val _lastName = MutableLiveData<String>()
    val lastName: LiveData<String> = _lastName

    private val _email = MutableLiveData<String>()
    val email: LiveData<String> = _email

    private val _image = MutableLiveData<String>()
    val image: LiveData<String> = _image

    fun loadProfileDataUser() {
        _firstName.value = securityPreferences.get("firstName")
        _lastName.value = securityPreferences.get("lastName")
        _email.value = securityPreferences.get("email")
        _image.value = securityPreferences.get("image")
    }
}