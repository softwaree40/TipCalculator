package com.example.tipcalculator.dto

import com.example.tipcalculator.model.WordResponse

data class WordResponseDtoItem(
    val license: LicenseDto,
    val meanings: List<MeaningDto>,
    val phonetic: String,
    val sourceUrls: List<String>,
    val word: String
){
    fun toWordResponse(): WordResponse {
        return WordResponse(
            license = license.toLicense(),
            meanings = meanings.map { it.toMeaning() },
            phonetic = phonetic,
            sourceUrls = sourceUrls,
            word = word
        )
    }
}