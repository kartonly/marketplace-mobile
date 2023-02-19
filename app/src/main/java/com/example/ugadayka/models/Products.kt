package com.example.ugadayka.models

data class Products(
    val id: Int,
    val title: String,
    val cost: Int,
    val desc: String,
    val photos: Array<String>,
)