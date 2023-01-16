package com.example.therapy.models

data class therapyModel(
    val `data`: List<Data>,
    val message: String,
    val status: Int,
    val success: Boolean,
    val token: String
)