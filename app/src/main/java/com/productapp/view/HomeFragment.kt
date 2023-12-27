package com.productapp.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.SearchView
import android.widget.Toast
import androidx.core.os.bundleOf
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.productapp.R
import com.productapp.databinding.FragmentHomeBinding
import com.productapp.view.adapters.productAdapter.ProductAdapter
import com.productapp.view.adapters.sliderHomeAdapter.SliderHomeAdapter
import com.productapp.view.category.CategoryFragment
import com.productapp.viewModel.MainViewModel
import java.util.Locale

class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    private lateinit var viewModel: MainViewModel
    private lateinit var searchProducts: SearchView
    // private lateinit var sliderHomeAdapter: SliderHomeAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)
        observeEvents()
        selectCategory()
    }

    override fun onResume() {
        super.onResume()
        viewModel.list()
    }

    private fun selectCategory() {
        var category = ""

        binding.ivSmartphone.setOnClickListener {
            category = "smartphones"

            val bundle = bundleOf("category" to category)
            findNavController().navigate(R.id.categoryFragment, bundle)
        }
        binding.ivLaptop.setOnClickListener {
            category = "laptops"

            val bundle = bundleOf("category" to category)
            findNavController().navigate(R.id.categoryFragment, bundle)
        }
        binding.ivMobilia.setOnClickListener {
            category = "furniture"

            val bundle = bundleOf("category" to category)
            findNavController().navigate(R.id.categoryFragment, bundle)
        }
    }

    private fun observeEvents() {
        /* var images: List<Int> = listOf(
            R.drawable.slide01,
            R.drawable.slide02,
            R.drawable.slide03,
        )

        sliderHomeAdapter = SliderHomeAdapter(images)
        binding.sliderTopProducts.setSliderAdapter(sliderHomeAdapter)
        binding.sliderTopProducts.scrollTimeInSec = 3 */

        viewModel.product.observe(viewLifecycleOwner) { productList ->
            val productAdapter = ProductAdapter(requireContext(), productList).apply {
                onItemClick = { product ->
                    onItemClick = { product ->
                        val direction = HomeFragmentDirections
                            .actionHomeFragmentToDetailedProductFragment(product)
                        findNavController().navigate(direction)
                    }
                }
            }
            with(binding.rvProduct) {
                setHasFixedSize(true)
                adapter = productAdapter
            }
        }
    }
}