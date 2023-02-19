package com.example.ugadayka.API.repo

import com.example.ugadayka.API.responses.CategoryResponse
import com.example.ugadayka.API.responses.ProductsResponse
import com.example.ugadayka.API.responses.SubcategoryResponse
import com.example.ugadayka.source.RemoteDataSource

class GetRepository(private val remoteData: RemoteDataSource = RemoteDataSource()) {

    suspend fun getCategories(): MutableList<CategoryResponse> {
        return remoteData.getCategories()
    }

    suspend fun getSubcategories(): MutableList<SubcategoryResponse> {
        return remoteData.getSubcategories()
    }

    suspend fun getProductsBySubcategory(subcategory: String, gender: String): MutableList<ProductsResponse> {
        return remoteData.getProductsBySubcategory(subcategory, gender)
    }
}