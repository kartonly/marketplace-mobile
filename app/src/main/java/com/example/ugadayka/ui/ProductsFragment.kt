package com.example.ugadayka.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.activity.OnBackPressedCallback
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.ugadayka.R
import com.example.ugadayka.databinding.CategoriesFragmentBinding
import com.example.ugadayka.databinding.ProductsFragmentBinding
import com.example.ugadayka.models.Categories
import com.example.ugadayka.models.Subcategories
import com.example.ugadayka.ui.adapters.CategoriesAdapter
import com.example.ugadayka.ui.adapters.ProductsAdapter
import com.example.ugadayka.ui.adapters.SubcategoriesAdapter
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

class ProductsFragment(private var viewModel: MainViewModel, private val subcategory: Subcategories, private val gender: String): Fragment() {
    private lateinit var binding: ProductsFragmentBinding

    private val verticalLinearLayoutManager: LinearLayoutManager =
        LinearLayoutManager(activity, RecyclerView.VERTICAL, false)

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = ProductsFragmentBinding.inflate(layoutInflater, container,false)
        binding.name.text = subcategory.title

        fun main() = runBlocking {
            launch {
                setupRecycleView()
            }
        }
        main()

        return binding.root
    }

    suspend fun setupRecycleView() {
        binding.catalogList.layoutManager = GridLayoutManager(requireContext(), 2)
        val products = viewModel.getProductsBySubcat(subcategory.trans, gender)

        binding.catalogList.adapter = ProductsAdapter(products, ::showProducts)
    }

    private fun showProducts(id: Int): Unit{
//        fragmentManager?.beginTransaction()?.replace(R.id.main_container, SubcategoriesFragment(viewModel, id, title), SubcategoriesFragment::class.java.simpleName)
//            ?.commit()
    }

}