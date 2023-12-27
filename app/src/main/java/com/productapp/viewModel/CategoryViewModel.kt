package com.productapp.viewModel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.productapp.service.Model.Products
import com.productapp.service.listener.APIListener
import com.productapp.service.listener.APILoader
import com.productapp.service.repository.ProductRepository
import com.productapp.service.repository.SecurityPreferences

class CategoryViewModel(application: Application): AndroidViewModel(application) {

    private val productRepository = ProductRepository(application.applicationContext)
    private val securityPreferences = SecurityPreferences(application.applicationContext)

    private val _product = MutableLiveData<List<Products>>()
    val product: LiveData<List<Products>> = _product

    fun listCategory(category: String) {
        productRepository.getCategory(category, object : APIListener<List<Products>> {
            override fun onSuccess(result: List<Products>) {
                _product.value = result
            }

            override fun onFailure(message: String) {}
        })
    }
}