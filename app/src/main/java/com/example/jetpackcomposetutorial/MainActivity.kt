package com.example.jetpackcomposetutorial

import android.content.res.Configuration
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.jetpackcomposetutorial.ui.theme.JetpackComposeTutorialTheme

private val messages: List<MyMessage> = listOf(
 MyMessage("Hola Jetpack Compose 1", "¿Preparado?"),
 MyMessage("Hola Jetpack Compose 2", "¿Preparado?"),
 MyMessage("Hola Jetpack Compose 3", "¿Preparado?"),
 MyMessage("Hola Jetpack Compose 4", "¿Preparado?"),
 MyMessage("Hola Jetpack Compose 5", "¿Preparado?"),
 MyMessage("Hola Jetpack Compose 6", "¿Preparado?"),
 MyMessage("Hola Jetpack Compose 7", "¿Preparado?"),
 MyMessage("Hola Jetpack Compose 8", "¿Preparado?"),
 MyMessage("Hola Jetpack Compose 9", "¿Preparado?"),
 MyMessage("Hola Jetpack Compose 10", "¿Preparado?"),
 MyMessage("Hola Jetpack Compose 11", "¿Preparado?"),
 MyMessage("Hola Jetpack Compose 12", "¿Preparado?"),
 MyMessage("Hola Jetpack Compose 13", "¿Preparado?"),
 MyMessage("Hola Jetpack Compose 14", "¿Preparado?"),
 MyMessage("Hola Jetpack Compose 15", "¿Preparado?"),
 MyMessage("Hola Jetpack Compose 16", "¿Preparado?"),
 MyMessage("Hola Jetpack Compose 17", "¿Preparado?"),
 MyMessage("Hola Jetpack Compose 18", "¿Preparado?"),
 MyMessage("Hola Jetpack Compose 19", "¿Preparado?"),
 MyMessage("Hola Jetpack Compose 20", "¿Preparado?"),
);

class MainActivity : ComponentActivity() {
 override fun onCreate(savedInstanceState: Bundle?) {
  super.onCreate(savedInstanceState)
  setContent {
   JetpackComposeTutorialTheme {
    MyMessages(messages);
   }
  }
 }
}

data class MyMessage(val title: String, val body: String)

@Composable
fun MyMessages( messages: List<MyMessage>) {
 LazyColumn {
  items(messages) { message ->
   MyComponent(message = message)
  }
 }
}

@Composable
fun MyComponent(message: MyMessage) {
 Row(modifier = Modifier
  .background(MaterialTheme.colors.background)
  .padding(8.dp)
 ) {
  MyImage();
  MyTexts(message);
 }
}

@Composable
fun MyImage() {
 Image(
  painter = painterResource(id = R.drawable.ic_launcher_foreground),
  contentDescription = "Mi imagen de prueba",
  modifier = Modifier
   .clip(CircleShape)
   .background(MaterialTheme.colors.primary)
   .size(64.dp)
 )
}

@Composable
fun MyTexts( message: MyMessage) {
 Column(modifier = Modifier.padding(start = 8.dp)) {
  MyText(
   text = message.title,
   color = MaterialTheme.colors.primary,
   style = MaterialTheme.typography.subtitle1
  );
  Spacer(modifier = Modifier.height(16.dp))
  MyText(
   text = message.body,
   color = MaterialTheme.colors.onBackground,
   style = MaterialTheme.typography.subtitle2
  );
 }
}

@Composable
fun MyText(text: String, color: Color, style: TextStyle) {
 Text(text = text, color = color, style = style)
}

@Preview(showSystemUi = true)
@Preview(uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
fun PreviewComponent() {
 JetpackComposeTutorialTheme {
  MyMessages(messages = messages);
 }
}
