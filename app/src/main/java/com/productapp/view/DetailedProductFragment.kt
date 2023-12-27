package com.productapp.view

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.productapp.R
import com.productapp.databinding.FragmentDetailedProductBinding
import com.productapp.view.flowPaymentFragments.CartFragment
import com.productapp.view.adapters.sliderAdapter.SliderAdapter
import com.productapp.viewModel.DetailedProductViewModel

class DetailedProductFragment : Fragment() {

    private lateinit var viewModel: DetailedProductViewModel
    private var _binding: FragmentDetailedProductBinding?= null
    private val binding get() = _binding!!

    private lateinit var sliderAdapter: SliderAdapter

    private val args: DetailedProductFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentDetailedProductBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        loadProduct()
    }

    private fun loadProduct() {
        args.product?.let {
            binding.tvTitle.setText(it.title)
            binding.tvPrice.setText(it.price.toString())
            binding.tvRating.setText(it.rating.toString())
            binding.tvDescription.setText(it.description)

            binding.btnAddCart.setOnClickListener {
                findNavController().navigate(R.id.action_detailedProductFragment_to_cartFragment)
            }

            sliderAdapter = SliderAdapter(it.images)
            binding.imageSlider.setSliderAdapter(sliderAdapter)
            binding.imageSlider.scrollTimeInSec = 3
        }
    }
}