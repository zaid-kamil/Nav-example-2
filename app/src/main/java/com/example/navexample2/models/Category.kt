package com.example.navexample2.models

import androidx.annotation.StringRes
import com.example.navexample2.R

data class Category(
    @StringRes val title: Int
)

class DataSources {
    fun getCategories() = listOf<Category>(
        Category(R.string.cat1),
        Category(R.string.cat2),
        Category(R.string.cat3),
        Category(R.string.cat4),
        Category(R.string.cat5),
        Category(R.string.cat6),
    )
}