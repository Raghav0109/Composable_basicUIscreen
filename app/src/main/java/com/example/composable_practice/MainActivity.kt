package com.example.composable_practice

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Pages
import androidx.compose.material.icons.filled.SkipNext
import androidx.compose.material.icons.filled.SkipPrevious
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
//import androidx.compose.ui.modifier.modifierLocalOf
//import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MainScreen()
        }
    }
}

@Composable
fun MainScreen() {

    //modifier
    //colorResource(id =)
    //val color:Color
    var icColor by remember {
        // Color(black = Float.MAX_VALUE)
        mutableStateOf(Color.Black)
    }
    var bgColor by remember {

        mutableStateOf(Color.White)
    }
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Row(
            horizontalArrangement = Arrangement.Start,
            verticalAlignment = Alignment.CenterVertically
        ) {
            HorizontalColoredBar(Color.Red)
            HorizontalColoredBar(Color.Magenta)
            HorizontalColoredBar(Color.Cyan)
            HorizontalColoredBar(Color.Blue)
            HorizontalColoredBar(Color.Yellow)
        }
        Row(
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 10.dp, vertical = 40.dp)
                    .background(color = bgColor),
                contentAlignment = Alignment.TopStart
            ) {
                Button(modifier = Modifier.padding(10.dp), onClick = {
                    if (bgColor == Color.White) {
                        icColor = Color.White
                        bgColor = Color.Black
                    } else {
                        //bgColor=Color.icColor
                        icColor = Color.Black
                        bgColor = Color.White
                    }
                    //modifierLocalOf {  }

                }) {
                    Icon(
                        imageVector = Icons.Default.SkipPrevious,
                        contentDescription = "previous",
                        modifier = Modifier
                            .size(30.dp),
                        tint = icColor
                    )

                }

                Icon(
                    imageVector = Icons.Default.Pages,
                    contentDescription = "Pages",
                    modifier = Modifier
                        .padding(70.dp)
                        .size(100.dp)
                        .offset(x = 70.dp)
                        .background(color = Color.Yellow)
                )

                Button(modifier = Modifier
                    .offset(x = 290.dp)
                    .offset(y = 180.dp), onClick = {
                    if (bgColor == Color.White) {
                        icColor = Color.White
                        bgColor = Color.Black

                    } else {
                        icColor = Color.Black
                        bgColor = Color.White
                    }
                }) {
                    Icon(
                        imageVector = Icons.Default.SkipNext, contentDescription = "next",
                        modifier = Modifier
                            .size(30.dp), tint = icColor
                    )

                }
            }
        }
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(color = Color.Yellow)
        ) {
            Row(
                modifier = Modifier
                    .padding(40.dp)
                    .clip(shape = RoundedCornerShape(20.dp, 20.dp, 20.dp, 20.dp))
            ) {
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(color = Color.Red)
                        .padding(10.dp),
                    contentAlignment = Alignment.CenterStart
                ) {
                    Text(
                        text = "Box Color is Red", fontSize = 20.sp, fontFamily = FontFamily.Serif,
                        textAlign = TextAlign.Left
                    )
                }
            }

            Row(
                modifier = Modifier
                    .padding(start = 40.dp, top = 130.dp, end = 40.dp)
                    .clip(shape = RoundedCornerShape(20.dp, 20.dp, 20.dp, 20.dp))
            ) {

                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(color = Color.Green)
                        .padding(10.dp),
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        text = "Box Color is Green", textAlign = TextAlign.Center, fontSize = 20.sp,
                        fontFamily = FontFamily.Serif
                    )
                }
            }
            Row(
                modifier = Modifier
                    .padding(start = 40.dp, top = 220.dp, end = 40.dp)
                    .clip(shape = RoundedCornerShape(20.dp, 20.dp, 20.dp, 20.dp))
            ) {

                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(color = Color.Blue)
                        .padding(10.dp),
                    contentAlignment = Alignment.CenterEnd
                ) {
                    Text(
                        textAlign = TextAlign.Right, text = "Box Color is Blue",
                        color = Color.White, fontSize = 20.sp, fontFamily = FontFamily.Serif
                    )
                }
            }
        }


    }

}


@Composable
fun HorizontalColoredBar(color: Color) {

    Surface(
        color = color,
        modifier = Modifier
            .height(200.dp)
            .width(85.dp)

    ) {}
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    MainScreen()


}