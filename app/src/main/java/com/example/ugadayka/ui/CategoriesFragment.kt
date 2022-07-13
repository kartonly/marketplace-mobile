package com.example.ugadayka.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.ugadayka.R
import com.example.ugadayka.databinding.CategoriesFragmentBinding
import com.example.ugadayka.models.Categories
import com.example.ugadayka.ui.adapters.CategoriesAdapter
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

class CategoriesFragment(private var viewModel: MainViewModel, private val gender: String): Fragment() {
    private lateinit var binding: CategoriesFragmentBinding

    private val verticalLinearLayoutManager: LinearLayoutManager =
        LinearLayoutManager(activity, RecyclerView.VERTICAL, false)

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = CategoriesFragmentBinding.inflate(layoutInflater, container,false)
        fun main() = runBlocking {
            launch {
                setupRecycleView()
            }
        }
        main()
        return binding.root
    }

    suspend fun setupRecycleView() {
        binding.catalogList.layoutManager = verticalLinearLayoutManager
        var categories: MutableList<Categories> = mutableListOf()
        when {
            gender == "female" -> {
                categories = viewModel.getCategories(0)
            }
            gender == "girl" -> {
                categories = viewModel.getCategories(0)
            }
            gender == "male" -> {
                categories = viewModel.getCategories(1)
            }
            gender == "boy" -> {
                categories = viewModel.getCategories(1)
            }
        }


        binding.catalogList.adapter = CategoriesAdapter(categories, ::showSubcat)
    }

    private fun showSubcat(cat: Categories): Unit{
        fragmentManager?.beginTransaction()?.replace(R.id.main_container, SubcategoriesFragment(viewModel, cat, gender), SubcategoriesFragment::class.java.simpleName)
            ?.commit()
    }
}