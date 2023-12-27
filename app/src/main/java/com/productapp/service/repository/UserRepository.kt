package com.productapp.service.repository

import android.content.Context
import com.productapp.service.Model.User
import com.productapp.service.listener.UserLoader
import com.productapp.service.repository.remote.RetrofitClient
import com.productapp.service.repository.remote.UserService

class UserRepository(context: Context): BaseRepository(context) {

    private val remote = RetrofitClient.createService(UserService::class.java)

    fun login(username: String, password: String, listener: UserLoader<User>) {
        executeLogin(remote.login(username, password), listener)
    }
}