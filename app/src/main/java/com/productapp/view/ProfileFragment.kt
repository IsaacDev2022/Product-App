package com.productapp.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.navArgs
import com.bumptech.glide.Glide
import com.productapp.R
import com.productapp.databinding.FragmentProfileBinding
import com.productapp.service.repository.SecurityPreferences
import com.productapp.viewModel.ProfileViewModel

class ProfileFragment : Fragment() {

    private var _binding: FragmentProfileBinding?= null
    private val binding get() = _binding!!

    private lateinit var viewModel: ProfileViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentProfileBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel = ViewModelProvider(this).get(ProfileViewModel::class.java)

        viewModel.loadProfileDataUser()
        observeEvents()
    }

    private fun observeEvents() {
        viewModel.firstName.observe(viewLifecycleOwner) {
            binding.tvName.setText(it)
            binding.tvFirstName.setText(it)
        }
        viewModel.lastName.observe(viewLifecycleOwner) {
            binding.tvLastName.setText(it)
        }
        viewModel.email.observe(viewLifecycleOwner) {
            binding.tvEmail.setText(it)
        }
        viewModel.image.observe(viewLifecycleOwner) {
            Glide.with(this).load(it).into(binding.imgProfile)
        }
    }
}