package com.example.ugadayka.ui

import android.app.Application
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.ugadayka.API.MainHolder
import com.example.ugadayka.API.responses.CategoryResponse
import com.example.ugadayka.models.Categories
import com.example.ugadayka.models.Products
import com.example.ugadayka.models.Subcategories
import java.util.*

class MainViewModel(application: Application) : ViewModel() {

    ///data from api
    suspend fun getCategories(gender: Int): MutableList<Categories> {
        val catsList: MutableList<Categories> = mutableListOf()
        val categories= MainHolder.getCats()
        if (gender == 1){
            for (i in categories){
                if (i.not_for_men.toString() == "0"){
                    catsList.add(Categories(i.id, i.title))
                }
            }
        } else {
            for (i in categories){
                catsList.add(Categories(i.id, i.title))
            }
        }
        return catsList
    }

    suspend fun getSubcategories(category: Int): MutableList<Subcategories> {
        val subcatsList: MutableList<Subcategories> = mutableListOf()
        val subcategories= MainHolder.getSubcats()
        for (i in subcategories){
            if (i.category_id == category){
                subcatsList.add(Subcategories(i.id, i.title, i.category_id, i.trans))
            }
        }
        return subcatsList
    }

    suspend fun getProductsBySubcat(subcategory: String, gender: String): MutableList<Products> {
        val productsList: MutableList<Products> = mutableListOf()
        val prods= MainHolder.getProductsBySubcategory(subcategory, gender)
        for (i in prods){
            productsList.add(Products(i.id, i.title, i.cost, i.desc, i.photos))
        }
        return productsList
    }

}