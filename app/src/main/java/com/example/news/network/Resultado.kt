package com.example.news.network

data class Datos(val resultados: List<Resultado>)

data class Resultado(
    val id: Int,
    val overview: String,
    val poster_path: String,
    val release_date: String,
    val title: String,
    val vote_average: Double,
    val vote_count: Int
)
