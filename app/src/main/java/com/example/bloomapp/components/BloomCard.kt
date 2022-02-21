package com.example.bloomapp.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.magnifier
import androidx.compose.material.*
import androidx.compose.material.SnackbarDefaults.backgroundColor
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import coil.compose.rememberImagePainter
import com.example.bloomapp.data.Plants
import com.example.bloomapp.data.Themes

@Composable
fun BloomCard(
    modifier: Modifier = Modifier,
    content: @Composable ()-> Unit,
    ){
    Card(
        modifier = modifier,
        elevation = 1.dp,
        shape = MaterialTheme.shapes.small,
        backgroundColor = MaterialTheme.colors.background,
        content=content,
    )
}

@Composable
fun ThemeCard(
    themes: Themes
) {
    BloomCard(modifier = Modifier.size(136.dp)) {
        Column{
            Image(
                painter = rememberImagePainter(themes.url),
                contentDescription = themes.name,
                Modifier
                    .fillMaxWidth()
                    .size(96.dp)
                    .clip(MaterialTheme.shapes.small),
                contentScale = ContentScale.Crop
            )

            BloomText(
                text = themes.name,
                modifier = Modifier.padding(8.dp)
            )
        }
    }
}

@Composable
fun PlantCard(
    plants: Plants
) {
    BloomCard(
        modifier = Modifier
            .fillMaxWidth()
            .height(64.dp)
            .padding(end = 16.dp)) {
        ConstraintLayout{

            val (checkBox, column,image, text) = createRefs()

            Image(
                painter = rememberImagePainter(plants.url),
                contentDescription = plants.name,
                Modifier
                    .fillMaxHeight()
                    .width(64.dp)
                    .clip(MaterialTheme.shapes.small)
                    .constrainAs(image){
                        start.linkTo(parent.start,0.dp)
                        top.linkTo(parent.top)
                        bottom.linkTo(parent.bottom)
                },
                contentScale = ContentScale.Crop

            )
            Column(modifier = Modifier
                .constrainAs(column){
                    start.linkTo(image.end)
                    top.linkTo(parent.top)
                    bottom.linkTo(parent.bottom)
            }) {

                BloomText(
                    text = plants.name,
                    modifier = Modifier
                        .paddingFromBaseline(top = 24.dp)
                        .padding(start = 16.dp)
                )


                Text(
                    text = plants.description,
                    style = MaterialTheme.typography.body1,
                    color = MaterialTheme.colors.onBackground,
                    modifier = Modifier
                        .padding(start = 16.dp))

                Divider(
                    color = MaterialTheme.colors.onBackground,
                    thickness = 1.dp,
                    modifier = Modifier
                        .paddingFromBaseline(top = 24.dp)
                        .padding(start = 8.dp, end = 8.dp)
                )
            }

            Checkbox(
                checked = false,
                onCheckedChange ={},
                modifier = Modifier.constrainAs(checkBox){
                    end.linkTo(parent.end)
                    top.linkTo(parent.top)
                    bottom.linkTo(parent.bottom)
                })
        }
    }
}