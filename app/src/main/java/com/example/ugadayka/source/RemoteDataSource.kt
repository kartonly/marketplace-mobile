package com.example.ugadayka.source

import com.example.ugadayka.API.responses.CategoryResponse
import com.example.ugadayka.API.responses.SubcategoryResponse
import com.example.ugadayka.DependencyInjection

class RemoteDataSource {
    suspend fun getCategories(): MutableList<CategoryResponse> {
        val categories = DependencyInjection.service.getCategories()
        return categories
    }

    suspend fun getSubcategories(): MutableList<SubcategoryResponse> {
        val subcategories = DependencyInjection.service.getSubcategories()
        return subcategories
    }
}