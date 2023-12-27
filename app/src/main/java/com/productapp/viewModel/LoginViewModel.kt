package com.productapp.viewModel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.productapp.service.Model.Products
import com.productapp.service.Model.User
import com.productapp.service.Model.ValidationModel
import com.productapp.service.listener.UserLoader
import com.productapp.service.repository.SecurityPreferences
import com.productapp.service.repository.UserRepository
import com.productapp.service.repository.remote.RetrofitClient

class LoginViewModel(application: Application): AndroidViewModel(application) {

    private val userRepository = UserRepository(application.applicationContext)
    private val securityPreferences = SecurityPreferences(application.applicationContext)

    private val _login = MutableLiveData<ValidationModel>()
    val login: LiveData<ValidationModel> = _login

    private val _loggedUser = MutableLiveData<Boolean>()
    val loggedUser: LiveData<Boolean> = _loggedUser

    fun doLogin(userName: String, password: String) {
        userRepository.login(userName, password, object: UserLoader<User> {
            override fun onSuccess(result: User) {
                securityPreferences.store("token", result.token)
                securityPreferences.store("firstName", result.firstName)
                securityPreferences.store("lastName", result.lastName)
                securityPreferences.store("email", result.email)
                securityPreferences.store("image", result.image)

                RetrofitClient.addHeader(result.token)
                _login.value = ValidationModel()
            }

            override fun onFailure(message: String) {
                _login.value = ValidationModel(message)
            }
        })
    }

    fun verifyLoggedUser() {
        val token = securityPreferences.get("token")

        RetrofitClient.addHeader(token)

        val logged = (token != "")
        _loggedUser.value = logged
    }
}