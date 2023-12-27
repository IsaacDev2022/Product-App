package com.productapp.view.category

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.productapp.R
import com.productapp.databinding.FragmentCartBinding
import com.productapp.databinding.FragmentCategoryBinding
import com.productapp.view.adapters.productAdapter.ProductAdapter
import com.productapp.viewModel.CategoryViewModel
import com.productapp.viewModel.MainViewModel

class CategoryFragment : Fragment() {

    private var _binding: FragmentCategoryBinding?= null
    private val binding get() = _binding!!

    private lateinit var viewModel: CategoryViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentCategoryBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel = ViewModelProvider(this).get(CategoryViewModel::class.java)

        var category = arguments?.getString("category").toString()
        viewModel.listCategory(category)

        if (category == "smartphones") {
            (activity as AppCompatActivity).supportActionBar?.title = "Smartphones"
        } else if (category == "laptops") {
            (activity as AppCompatActivity).supportActionBar?.title = "Laptops"
        } else if (category == "furniture") {
            (activity as AppCompatActivity).supportActionBar?.title = "Mobília"
        }

        observeEvents()
    }

    private fun observeEvents() {
        viewModel.product.observe(viewLifecycleOwner) { productList ->
            val productCategoryAdapter = ProductAdapter(requireContext(), productList)
            with(binding.rvProductCategory) {
                setHasFixedSize(true)
                adapter = productCategoryAdapter
            }
        }
    }
}