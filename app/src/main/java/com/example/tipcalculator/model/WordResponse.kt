package com.example.tipcalculator.model

import com.example.tipcalculator.dto.LicenseDto


data class WordResponse(
    val license: License,
    val meanings: List<Meaning>,
    val phonetic: String,
    val sourceUrls: List<String>,
    val word: String
)
