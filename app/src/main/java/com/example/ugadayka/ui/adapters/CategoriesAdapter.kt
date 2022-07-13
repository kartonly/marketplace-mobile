package com.example.ugadayka.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.ugadayka.API.responses.CategoryResponse
import com.example.ugadayka.databinding.ItemCatalogBinding
import com.example.ugadayka.models.Categories
import java.util.*

class CategoriesAdapter(private val categories: MutableList<Categories>, private val clickCat: (Categories) -> Unit):  RecyclerView.Adapter<CategoriesAdapter.CategoriesHolder>(){

    inner class CategoriesHolder internal constructor(
        private val binding: ItemCatalogBinding,
        private val clickCat: (Categories) -> Unit
    ): RecyclerView.ViewHolder(binding.root)
    {
        fun bind(cat: Categories) = binding.run{
            name.text = cat.title

            binding.name.setOnClickListener {
                clickCat.invoke(cat)
            }
        }
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoriesAdapter.CategoriesHolder {
        val binding = ItemCatalogBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return CategoriesHolder(binding, clickCat)
    }

    override fun getItemCount(): Int {
        return categories.size
    }

    override fun onBindViewHolder(holder: CategoriesHolder, position: Int) {
        val cats: MutableList<Categories> = categories
        val cat = cats[position]
        holder.bind(cat)
    }
}