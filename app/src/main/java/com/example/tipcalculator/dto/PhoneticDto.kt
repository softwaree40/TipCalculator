package com.example.tipcalculator.dto

import com.example.tipcalculator.model.Phonetic

data class PhoneticDto(
    val audio: String,
    val sourceUrl: String,
    val text: String
){
    fun toPhonetic():Phonetic{
        return Phonetic(
            audio = audio,
            sourceUrl = sourceUrl,
            text = text
        )
    }
}