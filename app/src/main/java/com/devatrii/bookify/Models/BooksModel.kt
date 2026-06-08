package com.devatrii.bookify.Models

import java.io.Serializable

data class BooksModel(
    val image: Int,
    val title: String,
    val description: String,
    val bookPDF: String,
) : Serializable