package com.example.ugadayka.API.responses

class ProductsResponse(
    val id: Int,
    val title: String,
    val cost: Int,
    val desc: String,
    val photos: Array<String>,
    val created_at: String,
    val updated_at: String,
)