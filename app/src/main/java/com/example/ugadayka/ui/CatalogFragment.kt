package com.example.ugadayka.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.ugadayka.R
import com.example.ugadayka.databinding.CatalogFragmentBinding
import com.example.ugadayka.databinding.CategoriesFragmentBinding
import com.example.ugadayka.models.Categories
import com.example.ugadayka.ui.adapters.CategoriesAdapter
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

class CatalogFragment(private var viewModel: MainViewModel): Fragment() {
    private lateinit var binding: CatalogFragmentBinding

    private val verticalLinearLayoutManager: LinearLayoutManager =
        LinearLayoutManager(activity, RecyclerView.VERTICAL, false)

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = CatalogFragmentBinding.inflate(layoutInflater, container,false)

        binding.female.setOnClickListener {
            fragmentManager?.beginTransaction()?.replace(R.id.main_container, CategoriesFragment(viewModel, "female"), CategoriesFragment::class.java.simpleName)
                ?.commit()
        }

        binding.girl.setOnClickListener {
            fragmentManager?.beginTransaction()?.replace(R.id.main_container, CategoriesFragment(viewModel, "girl"), CategoriesFragment::class.java.simpleName)
                ?.commit()
        }

        binding.male.setOnClickListener {
            fragmentManager?.beginTransaction()?.replace(R.id.main_container, CategoriesFragment(viewModel, "male"), CategoriesFragment::class.java.simpleName)
                ?.commit()
        }

        binding.boy.setOnClickListener {
            fragmentManager?.beginTransaction()?.replace(R.id.main_container, CategoriesFragment(viewModel, "boy"), CategoriesFragment::class.java.simpleName)
                ?.commit()
        }
        return binding.root
    }

}