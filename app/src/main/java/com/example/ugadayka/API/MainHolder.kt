package com.example.ugadayka.API

import com.example.ugadayka.API.responses.CategoryResponse
import com.example.ugadayka.API.responses.SubcategoryResponse
import com.example.ugadayka.DependencyInjection
import com.example.ugadayka.models.Categories

object MainHolder {
    suspend fun getCats(): MutableList<CategoryResponse> {
        val cat = DependencyInjection.repository.getCategories()
        return cat
    }

    suspend fun getSubcats(): MutableList<SubcategoryResponse> {
        val subcat = DependencyInjection.repository.getSubcategories()
        return subcat
    }
}