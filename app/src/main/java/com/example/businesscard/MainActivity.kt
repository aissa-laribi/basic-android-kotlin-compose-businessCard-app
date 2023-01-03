package com.example.businesscard

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ExperimentalGraphicsApi
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.max
import androidx.compose.ui.unit.sp
import com.example.businesscard.ui.theme.BusinessCardTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BusinessCardTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    MainCard()
                }
            }
        }
    }
}

@OptIn(ExperimentalGraphicsApi::class)
@Composable
fun MainCard() {
    val logoImage = painterResource(id = R.drawable.avatar)
    Column(Modifier
        .background(color = Color.Cyan)) {
        Row(Modifier.weight(weight = 18f)) {
            Column(
                Modifier
                    .background(color = Color.Cyan)
                    .fillMaxWidth()
                    .fillMaxHeight(),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center,) {
                Image(
                    painter = logoImage,
                    contentDescription = null,
                )
                Text(
                    text = stringResource(R.string.fullName),
                    fontSize = 36.sp,
                    color = Color.Black
                    

                )
                Text(
                    text = stringResource(R.string.title),
                    fontSize = 18.sp,
                    color = Color.DarkGray,
                )
            }
        }
        Row(
            Modifier
                .weight(1f)
                .border(width = 0.02.dp, color = Color.Black),
            horizontalArrangement = Arrangement.End,
        ) {
            linksCard(
                logo = painterResource(id = R.drawable.github),
                link = stringResource(id = R.string.githubLink))
        }
        Row(
            Modifier
                .weight(1f)
                .border(width = 0.02.dp, color = Color.Black),
            horizontalArrangement = Arrangement.End,
        ) {
            linksCard(
                logo = painterResource(id = R.drawable.leetcode_logo_black),
                link = stringResource(id = R.string.leetcodeLink))
        }
        Row(
            Modifier
                .weight(1f),
            horizontalArrangement = Arrangement.End,
        ) {
            linksCard(
                logo = painterResource(id = R.drawable.linkedinsvg),
                link = stringResource(id = R.string.linkedinLink))
        }
        Spacer(
            Modifier
                .height(height = 2.dp))
        }
    }

@Composable
fun linksCard(
    logo: Painter,
    link: String,
) {
    Row(
        Modifier
            .fillMaxWidth()
            .fillMaxHeight()
            .background(color = Color.Cyan)
    ) {
        Image(
            painter = logo,
            contentDescription = null,
            modifier = Modifier.padding(start = 75.dp, top = 5.dp)
            )
        Text(text = link,
            color = Color.Black,
            modifier = Modifier.padding(start = 30.dp, top = 10.dp)
        )
    }
}


@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    BusinessCardTheme {
        MainCard()
    }
}