package com.productapp.viewModel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.productapp.service.Model.Products
import com.productapp.service.listener.APILoader
import com.productapp.service.repository.ProductRepository

class DetailedProductViewModel(application: Application): AndroidViewModel(application) {

    private val productRepository = ProductRepository(application.applicationContext)

    private val _product = MutableLiveData<Products>()
    val product: LiveData<Products> = _product

    fun load(id: Int) {
        productRepository.listProduct(id, object : APILoader<Products> {
            override fun onSuccess(result: Products) {
                _product.value = result
            }

            override fun onFailure(message: String) {}
        })
    }
}