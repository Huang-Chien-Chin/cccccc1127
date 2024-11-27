package tw.edu.pu.csim.s1120326.cccccc

import android.media.MediaPlayer
import android.os.Bundle
import android.webkit.WebSettings.TextSize
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material3.ButtonDefaults.buttonColors
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import tw.edu.pu.csim.s1120326.cccccc.ui.theme.Cccccc1127Theme
import androidx.compose.foundation.layout.Column as Column1
import androidx.compose.material3.Button as Button


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Cccccc1127Theme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Greeting(
                        name = "Android",
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    // 水果圖片和對應的聲音資源
    val fruit = listOf(
        Pair(R.drawable.durian, R.raw.durian),
        Pair(R.drawable.apple, R.raw.apple),
        Pair(R.drawable.banana, R.raw.banana),
        Pair(R.drawable.pineapple, R.raw.pineapple),
        Pair(R.drawable.watermelon, R.raw.watermelon),
        Pair(R.drawable.grape, R.raw.grape),
        Pair(R.drawable.persimmon, R.raw.persimmon),
        Pair(R.drawable.orange, R.raw.orange),
        Pair(R.drawable.lemon, R.raw.lemon),
        Pair(R.drawable.tomato, R.raw.tomato),
        Pair(R.drawable.avocado, R.raw.avocado),
        Pair(R.drawable.cantaloupe, R.raw.cantaloupe),
        Pair(R.drawable.strawberry, R.raw.strawberry),
        Pair(R.drawable.dragon, R.raw.dragon),
        Pair(R.drawable.passion, R.raw.passion),
        Pair(R.drawable.cherries, R.raw.cherries),
        Pair(R.drawable.mango, R.raw.mango),
        Pair(R.drawable.peach, R.raw.peach),
        Pair(R.drawable.papaya, R.raw.papaya),
        Pair(R.drawable.grapefruit, R.raw.pomelo),
        Pair(R.drawable.success, R.raw.success)
    )

    val context = LocalContext.current



    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        LazyRow {
            items(fruit.size) { index ->
                Column1(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = Modifier.padding(8.dp)
                ) {
                    // 每個水果的按鈕
                    Button(onClick = {
                        // 播放對應的聲音
                        val mediaPlayer = MediaPlayer.create(context, fruit[index].second)
                        mediaPlayer.start()
                        mediaPlayer.setOnCompletionListener {
                            // 播放完成後釋放資源
                            mediaPlayer.release()
                        }
                    },
                        modifier = Modifier.size(150.dp, 60.dp) // 設置按鈕的大小
                        ) {
                        Text(text = "點我 ${index + 1}",
                            style = TextStyle(
                                fontSize = 24.sp, // 使用 sp 設定字體大小
                                fontWeight = FontWeight.Bold// 設置文字大小
                            )
                        )
                    }

                    // 水果圖片
                    Image(
                        painter = painterResource(id = fruit[index].first),
                        contentDescription = "水果圖片",
                        modifier = Modifier
                            .graphicsLayer(scaleX = 1.2f, scaleY = 1.2f)
                            .fillParentMaxWidth(0.8f)
                            .padding(top = 20.dp)
                    )
                }
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    Cccccc1127Theme {
        Greeting("Android")
    }
}