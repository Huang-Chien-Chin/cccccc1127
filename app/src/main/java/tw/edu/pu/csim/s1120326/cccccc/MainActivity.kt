package tw.edu.pu.csim.s1120326.cccccc

import android.content.pm.ActivityInfo
import android.media.MediaPlayer
import android.os.Bundle
import android.webkit.WebSettings.TextSize
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.animation.AnimatedContentTransitionScope.SlideDirection.Companion.Start
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material3.ButtonDefaults.buttonColors
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.IntOffset
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
                    Start(m =Modifier.padding(innerPadding))
                    Greeting(
                        name ="Android",
                        modifier = Modifier.padding(innerPadding)
                    )

                }
            }
        }
    }

    }


@Composable
fun Start(m: Modifier) {
    var expanded by remember { mutableStateOf(false) }  // 控制背景是否延展

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.LightGray) // 預設背景色
    ) {
        // 滿版背景圖
        Image(
            painter = painterResource(id = R.drawable.cnmb), // 替換為你的背景資源
            contentDescription = "背景圖",
            contentScale = if (expanded) ContentScale.Crop else ContentScale.FillBounds, // 滿版顯示模式
            modifier = Modifier.fillMaxSize() // 填滿整個畫面
        )

    }
}




@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    // 水果圖片和對應的聲音資源
    val fruit = listOf(
        Triple(R.drawable.durian, listOf(R.raw.durianc,R.raw.duriane,R.raw.duriant), "榴蓮"),
        Triple(R.drawable.apple, listOf(R.raw.applec,R.raw.applee,R.raw.applet),"蘋果"),
        Triple(R.drawable.banana, listOf(R.raw.bananac,R.raw.bananae,R.raw.bananat),"香蕉"),
        Triple(R.drawable.pineapple, listOf(R.raw.pineapplec,R.raw.pineapplee,R.raw.pineapplet),"鳳梨"),
        Triple(R.drawable.watermelon, listOf(R.raw.watermelonc,R.raw.watermelone,R.raw.watermelont),"西瓜"),
        Triple(R.drawable.grape, listOf(R.raw.grapec,R.raw.grapee,R.raw.grapet),"葡萄"),
        Triple(R.drawable.persimmon, listOf(R.raw.persimmonc,R.raw.persimmone,R.raw.persimmont),"柿子"),
        Triple(R.drawable.orange, listOf(R.raw.orangec,R.raw.orangee,R.raw.oranget),"橘子"),
        Triple(R.drawable.lemon, listOf(R.raw.lemonc,R.raw.lemone,R.raw.lemont),"檸檬"),
        Triple(R.drawable.tomato, listOf(R.raw.tomatoc,R.raw.tomatoe,R.raw.tomatot),"番茄"),
        Triple(R.drawable.avocado, listOf(R.raw.avocadoc,R.raw.avocadoe,R.raw.avocadot),"酪梨"),
        Triple(R.drawable.cantaloupe, listOf(R.raw.cantaloupec,R.raw.cantaloupee,R.raw.cantaloupet),"哈密瓜"),
        Triple(R.drawable.strawberry, listOf(R.raw.strawberryc,R.raw.strawberrye,R.raw.strawberryt),"草莓"),
        Triple(R.drawable.dragon, listOf(R.raw.dragonc,R.raw.dragone,R.raw.dragont),"火龍果"),
        Triple(R.drawable.passion, listOf(R.raw.passionc,R.raw.passione,R.raw.passiont),"百香果"),
        Triple(R.drawable.cherries, listOf(R.raw.cherriesc,R.raw.cherriese,R.raw.cherriest),"櫻桃"),
        Triple(R.drawable.mango, listOf(R.raw.mangoc,R.raw.mangoe,R.raw.mangot),"芒果"),
        Triple(R.drawable.peach, listOf(R.raw.peachc,R.raw.peache,R.raw.peacht),"水蜜桃"),
        Triple(R.drawable.papaya, listOf(R.raw.papayac,R.raw.papayae,R.raw.papayat),"木瓜"),
        Triple(R.drawable.grapefruit, listOf(R.raw.pomeloc,R.raw.pomeloe,R.raw.pomelot),"柚子")
    )
    val success = Triple(R.drawable.success, listOf(R.raw.success), "完成") // 單獨處理 success
    val context = LocalContext.current
    val allItems = fruit + success
    var currentIndex by remember { mutableStateOf(0) } // 當前顯示的頁面索引



    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Column1(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
            modifier = Modifier.padding(16.dp)
        ) {
            // 當前頁面資料
            val currentFruit = allItems[currentIndex]
            val languages = if (currentFruit == success) listOf("完成") else listOf("中文", "英文", "台語")

            // 按鈕區域
            languages.forEachIndexed { langIndex, language ->
                Button(
                    onClick = {
                        val mediaPlayer = MediaPlayer.create(
                            context,
                            currentFruit.second.getOrElse(langIndex) { currentFruit.second[0] }
                        )
                        mediaPlayer.start()
                        mediaPlayer.setOnCompletionListener { mediaPlayer.release() }
                    },
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(8.dp)
                ) {
                    Text(
                        text = if (language == "完成") language else "$language ${currentIndex + 1}",
                        style = TextStyle(
                            fontSize = 24.sp,
                            fontWeight = FontWeight.Bold
                        )
                    )
                }
            }

            // 圖片
            Image(
                painter = painterResource(id = currentFruit.first),
                contentDescription = "${currentFruit.third} 圖片",
                modifier = Modifier
                    .size(200.dp)
                    .padding(top = 20.dp)
            )
        }

        // 翻頁按鈕
        Row(
            modifier = Modifier.align(Alignment.BottomCenter).padding(16.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Button(
                onClick = {
                    if (currentIndex > 0) currentIndex--
                },
                enabled = currentIndex > 0
            ) {
                Text("上一個")
            }

            Spacer(modifier = Modifier.width(16.dp))

            Button(
                onClick = {
                    if (currentIndex < allItems.size - 1) currentIndex++
                },
                enabled = currentIndex < allItems.size - 1
            ) {
                Text("下一個")
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