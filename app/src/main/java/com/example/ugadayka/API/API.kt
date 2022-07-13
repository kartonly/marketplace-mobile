package com.example.ugadayka.API

import com.example.ugadayka.API.responses.CategoryResponse
import com.example.ugadayka.API.responses.SubcategoryResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface  API {
    @GET("categories")
    suspend fun getCategories(): MutableList<CategoryResponse>

    @GET("subcategories")
    suspend fun getSubcategories(): MutableList<SubcategoryResponse>

    @GET("products/subcategory/{subcategory}/{gender}")
    suspend fun getProductsBySubcategory(@Query("subcategory") subcategory: String, @Query("gender") gender: String): MutableList<SubcategoryResponse>

}

