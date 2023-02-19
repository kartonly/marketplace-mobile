package com.example.ugadayka.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.ugadayka.API.responses.CategoryResponse
import com.example.ugadayka.databinding.ItemCatalogBinding
import com.example.ugadayka.models.Categories
import com.example.ugadayka.models.Subcategories
import java.util.*

class SubcategoriesAdapter(private val subcategories: MutableList<Subcategories>, private val clickSubcat: (Subcategories) -> Unit):  RecyclerView.Adapter<SubcategoriesAdapter.SubcategoriesHolder>(){

    inner class SubcategoriesHolder internal constructor(
        private val binding: ItemCatalogBinding,
        private val clickSubcat: (Subcategories) -> Unit
    ): RecyclerView.ViewHolder(binding.root)
    {
        fun bind(subcat: Subcategories) = binding.run{
            name.text = subcat.title

            binding.name.setOnClickListener {
                clickSubcat(subcat)
            }
        }
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SubcategoriesAdapter.SubcategoriesHolder {
        val binding = ItemCatalogBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return SubcategoriesHolder(binding, clickSubcat)
    }

    override fun getItemCount(): Int {
        return subcategories.size
    }

    override fun onBindViewHolder(holder: SubcategoriesHolder, position: Int) {
        val cats: MutableList<Subcategories> = subcategories
        val cat = cats[position]
        holder.bind(cat)
    }
}