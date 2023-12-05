package com.mexiti.articlecompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.mexiti.articlecompose.ui.theme.ArticleComposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ArticleComposeTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    HeadingImage(title = stringResource(R.string.jetpack_compose_tutorial), intro = stringResource(
                        R.string.intro
                    ), content = stringResource(R.string.content) )
                }
            }
        }
    }
}

@Composable
fun TutorialText(title: String, intro: String, content: String ,modifier: Modifier = Modifier) {
    Column {
        Text(
            text = title,
            fontSize = 24.sp,
            modifier = Modifier
                .padding(16.dp)
        )
        Text(
            text = intro,
            textAlign = TextAlign.Justify,
            modifier = modifier
                .padding(start = 16.dp, end = 16.dp)
        )
        Text(
            text = content,
            textAlign = TextAlign.Justify,
            modifier = modifier
                .padding(16.dp)
        )
    }
}

@Composable
fun HeadingImage(title: String, intro: String, content: String ,modifier: Modifier = Modifier){
    val image = painterResource(id = R.drawable.bg_compose_background)

    Column {
        Image(
            painter = image,
            contentScale = ContentScale.FillWidth,
            contentDescription = null
        )
        TutorialText(title = title, intro = intro , content = content ,
            modifier = modifier

        )

    }


}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    ArticleComposeTheme {
            HeadingImage(title = stringResource(R.string.jetpack_compose_tutorial), intro = stringResource(
                R.string.intro
            ), content = stringResource(R.string.content) )
    }
}