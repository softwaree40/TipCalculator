package com.example.tipcalculator.model

import com.example.tipcalculator.dto.DefinitionDto

data class Meaning(
    val antonyms: List<String>,
    val definitions: List<Definition>,
    val partOfSpeech: String,
    val synonyms: List<String>
)
