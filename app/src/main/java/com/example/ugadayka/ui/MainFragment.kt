package com.example.ugadayka.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.graphics.drawable.DrawableCompat
import androidx.fragment.app.Fragment
import com.example.ugadayka.R
import com.example.ugadayka.databinding.MainFragmentBinding

class MainFragment(private var viewModel: MainViewModel) : Fragment() {

    companion object {
        fun newInstance(viewModel: MainViewModel) = MainFragment(viewModel)
    }

    private lateinit var binding: MainFragmentBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = MainFragmentBinding.inflate(layoutInflater, container, false)

        binding.catalog.setOnClickListener{
            fragmentManager?.beginTransaction()?.replace(R.id.main_container, CatalogFragment(viewModel), CatalogFragment::class.java.simpleName)
                ?.commit()
        }

        return binding.root
    }
}
