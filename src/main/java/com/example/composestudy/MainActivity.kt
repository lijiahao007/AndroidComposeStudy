package com.example.composestudy

import android.content.res.Configuration
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.composestudy.ui.theme.ComposeStudyTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Content()
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Row(modifier = modifier) {
        Box(modifier = Modifier
            .size(50.dp)
            .padding(3.dp)
        ) {
            Image(
                painter = painterResource(id = R.drawable.adddevice_type_icon_qrcode),
                contentDescription = "QrCode icon",
                modifier = Modifier
                    .size(30.dp)
                    .align(Alignment.Center),
            )
        }

        Spacer(modifier = Modifier.width(5.dp))

        Column(
            modifier = Modifier.align(Alignment.CenterVertically)
        ) {
            Text(
                text = "Hello $name!",
            )
            Text(
                text = "What the Hell $name!",
            )
        }
    }
}

@Composable
fun Content() {
    ComposeStudyTheme {
        Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
            Column {
                Greeting(
                    name = "Android",
                    modifier = Modifier.padding(innerPadding)
                )

                MessageCard(Message("Android", R.drawable.adddevice_type_icon_qrcode))
            }

        }
    }
}

@Composable
fun MessageCard(msg:Message) {
    Row {
        Box(modifier = Modifier
            .size(50.dp)
            .padding(3.dp)
            .border(1.5.dp, MaterialTheme.colorScheme.primary)
        ) {
            Image(
                painter = painterResource(id = msg.iconId),
                contentDescription = "QrCode icon",
                modifier = Modifier
                    .size(30.dp)
                    .align(Alignment.Center),
            )
        }
        Spacer(modifier = Modifier.width(5.dp))
        Surface(
            shadowElevation = 1.dp,
            modifier = Modifier
                .align(Alignment.CenterVertically)
                .clip(MaterialTheme.shapes.medium)
            ) {

            Row(modifier = Modifier.background(MaterialTheme.colorScheme.primaryContainer)) {
                Spacer(modifier = Modifier.width(5.dp))
                Text(
                    text = "Hello ${msg.msg}!",
                    color = MaterialTheme.colorScheme.secondary,

                    modifier = Modifier
                        .align(Alignment.CenterVertically),
                    style = MaterialTheme.typography.titleSmall
                )
                Spacer(modifier = Modifier.width(5.dp))
            }

        }
    }

}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    Greeting("Android")
}

@Preview(name="Light Mode")
@Preview(
    uiMode = Configuration.UI_MODE_NIGHT_YES,
    showBackground = true,
    name = "Dark Mode"
)
@Composable
fun PreviewMessageCard() {
    ComposeStudyTheme {
        Surface {
            MessageCard(msg = Message("Andorid", R.drawable.adddevice_type_icon_qrcode))
        }
    }
}