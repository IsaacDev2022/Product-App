package com.productapp.view.flowPaymentFragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.productapp.R
import com.productapp.databinding.FragmentCartBinding
import com.productapp.view.DetailedProductFragmentArgs
import com.productapp.view.adapters.sliderAdapter.SliderAdapter

class CartFragment : Fragment() {

    private var _binding: FragmentCartBinding? = null
    private val binding get() = _binding!!

    private val args: CartFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentCartBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnCheckout.setOnClickListener {
            findNavController().navigate(R.id.action_cartFragment_to_personalDataFragment)
        }

        loadProduct()
    }

    private fun loadProduct() {
        args.product?.let {
            binding.tvNameProduct.setText(it.title)
            binding.tvDescriptionProduct.setText(it.description)
            binding.tvPriceProduct.setText(it.price.toString())
        }
    }
}