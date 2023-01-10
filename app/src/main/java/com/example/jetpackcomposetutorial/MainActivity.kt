package com.example.jetpackcomposetutorial

import android.content.res.Configuration
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
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

class MainActivity : ComponentActivity() {
 override fun onCreate(savedInstanceState: Bundle?) {
  super.onCreate(savedInstanceState)
  setContent {
   JetpackComposeTutorialTheme() {
    MyComponent();
   }
  }
 }
}

@Composable
fun MyComponent() {
 Row(modifier = Modifier
  .background(MaterialTheme.colors.background)
  .padding(8.dp)
 ) {
  MyImage();
  MyTexts();
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
fun MyTexts() {
 Column(modifier = Modifier.padding(start = 8.dp)) {
  MyText(
   text = "Hola Jetpack Compose",
   color = MaterialTheme.colors.primary,
   style = MaterialTheme.typography.subtitle1
  );
  Spacer(modifier = Modifier.height(16.dp))
  MyText(
   text = "¿Preparado?",
   color = MaterialTheme.colors.onBackground,
   style = MaterialTheme.typography.subtitle2
  );
 }
}

@Composable
fun MyText(text: String, color: Color, style: TextStyle) {
 Text(text = text, color = color, style = style)
}

@Preview()
@Preview(uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
fun PreviewComponent() {
 JetpackComposeTutorialTheme() {
  MyComponent();
 }
}
