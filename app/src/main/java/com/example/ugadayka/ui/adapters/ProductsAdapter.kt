package com.example.ugadayka.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.ugadayka.API.responses.CategoryResponse
import com.example.ugadayka.databinding.ItemCatalogBinding
import com.example.ugadayka.databinding.ItemProductBinding
import com.example.ugadayka.models.Categories
import com.example.ugadayka.models.Products
import com.example.ugadayka.models.Subcategories
import com.squareup.picasso.Picasso
import java.util.*

class ProductsAdapter(private val products: MutableList<Products>, private val clickSubcat: (Int) -> Unit):  RecyclerView.Adapter<ProductsAdapter.ProductsHolder>(){

    inner class ProductsHolder internal constructor(
        private val binding: ItemProductBinding,
        private val clickProduct: (Int) -> Unit
    ): RecyclerView.ViewHolder(binding.root)
    {
        fun bind(product: Products) = binding.run{
            name.text = product.title
            price.text = product.cost.toString()+" р."
            Picasso.get().load("http://marketplace.std-941.ist.mospolytech.ru/"+product.photos[0]).into(photo);

            binding.name.setOnClickListener {
                clickProduct(product.id)
            }
        }
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductsAdapter.ProductsHolder {
        val binding = ItemProductBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ProductsHolder(binding, clickSubcat)
    }

    override fun getItemCount(): Int {
        return products.size
    }

    override fun onBindViewHolder(holder: ProductsHolder, position: Int) {
        val prods: MutableList<Products> = products
        val prod = prods[position]
        holder.bind(prod)
    }
}