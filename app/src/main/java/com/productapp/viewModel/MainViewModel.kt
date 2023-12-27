package com.productapp.viewModel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.productapp.service.Model.ProductModel
import com.productapp.service.Model.Products
import com.productapp.service.listener.APIListener
import com.productapp.service.repository.ProductRepository
import com.productapp.service.repository.SecurityPreferences

class MainViewModel(application: Application): AndroidViewModel(application) {

    private val productRepository = ProductRepository(application.applicationContext)
    private val securityPreferences = SecurityPreferences(application.applicationContext)

    private val _product = MutableLiveData<List<Products>>()
    val product: LiveData<List<Products>> = _product

    private val _name = MutableLiveData<String>()
    val name: LiveData<String> = _name

    private val _image = MutableLiveData<String>()
    val image: LiveData<String> = _image

    fun list() {
        val listener = object : APIListener<List<Products>> {
            override fun onSuccess(result: List<Products>) {
                _product.value = result
            }

            override fun onFailure(message: String) {}
        }

        productRepository.list(listener)
    }

    fun logout() {
        securityPreferences.remove("token")
    }

    fun loadUserName() {
        _name.value = securityPreferences.get("firstName")
        _image.value = securityPreferences.get("image")
    }
}