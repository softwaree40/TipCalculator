package com.example.tipcalculator.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp

@Composable
fun InputText(
    valueState: MutableState<String>,
    isSingle: Boolean,
    isEnable: Boolean,
    labelId: String,
    keyboardType: KeyboardType = KeyboardType.Number,
    imeAction: ImeAction = ImeAction.Next,
    onAction: KeyboardActions = KeyboardActions.Default

) {
    Column(
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        OutlinedTextField(
            modifier = Modifier.padding(16.dp),
            value = valueState.value,
            onValueChange = { valueState.value = it },
            label = { Text(text = labelId) },
            enabled = isEnable,
            leadingIcon = {Icons.Default.AccountBox},
            singleLine = isSingle,
            keyboardOptions = KeyboardOptions(keyboardType=keyboardType, imeAction = imeAction),
            keyboardActions = onAction)
    }

}