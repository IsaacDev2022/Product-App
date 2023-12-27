package com.productapp.view.flowPaymentFragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.productapp.R
import com.productapp.databinding.FragmentConfirmedPaymentBinding
import com.productapp.databinding.FragmentPaymentBinding

class ConfirmedPaymentFragment : Fragment() {

    private var _binding: FragmentConfirmedPaymentBinding?= null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentConfirmedPaymentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnContinue.setOnClickListener {
            findNavController().navigate(R.id.action_confirmedPaymentFragment2_to_homeFragment)
        }
    }
}