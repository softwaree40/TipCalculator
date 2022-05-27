package com.example.tipcalculator.components


import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp


val thenChangeSizeOfButton = Modifier.size(40.dp)
@Composable
fun RoundedCircle(
    modifier: Modifier = Modifier,
    imageVector: ImageVector,
    shape: Shape = CircleShape,
    onClick:()->Unit,
    tint: Color = Color.Black.copy(alpha = 0.5f),
    backgroundColor: Color = MaterialTheme.colors.background,
    elevation: Dp = 4.dp
){
    Card(modifier = modifier
        .padding(all = 6.dp)
        .clickable { onClick.invoke() }
        .then(thenChangeSizeOfButton),
        shape = shape,
        backgroundColor = backgroundColor,
        elevation = elevation
        )
    {
     Icon(imageVector = imageVector, contentDescription = "Plus or Minus Icon",tint = tint )

    }





}