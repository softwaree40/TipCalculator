package com.example.tipcalculator.dto

import com.example.tipcalculator.model.License

data class LicenseDto(
    val name: String,
    val url: String
){
    fun toLicense(): License {
        return License(
            name = name,
            url = url
        )
    }
}