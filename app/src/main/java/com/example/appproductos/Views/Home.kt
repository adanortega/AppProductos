package com.example.appproductos.Views

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.appproductos.Navigation.NavDestinations
import com.example.appproductos.R

class Home : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val navController = rememberNavController() // Inicializa NavController
            HomeViewScreen(navController = navController)
        }
    }
}

@Composable
fun HomeViewScreen(navController: NavHostController) {
    val backgroundColor = Color(0xFFF9F9F9)
    val headerColor = Color(0xFF062743)
    val buttonColor = Color(0xFF113A5D)
    val textColor = Color(0xFFC4FFDD)
    val titleColor = Color(0xFF062743)

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(backgroundColor)
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceBetween
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .background(headerColor)
                .padding(8.dp),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = "HOME VIEW",
                fontSize = 24.sp,
                color = textColor,
                fontWeight = FontWeight.Bold
            )
        }

        Image(
            painter = painterResource(id = R.drawable.adan_gomez),
            contentDescription = "Imagen de la empresa",
            modifier = Modifier
                .size(350.dp)
                .padding(8.dp),
            contentScale = ContentScale.Crop
        )

        Text(
            text = "Asterik Store",
            fontSize = 32.sp,
            fontWeight = FontWeight.Bold,
            color = titleColor
        )
        Button(
            onClick = { navController.navigate(NavDestinations.ListView.route) },
            modifier = Modifier
                .fillMaxWidth(0.7f)
                .padding(vertical = 8.dp),
            shape = RoundedCornerShape(20.dp),
            colors = ButtonDefaults.buttonColors(containerColor = buttonColor)
        ) {
            Text(text = "Productos", fontSize = 18.sp, color = Color.White)
        }

        Button(
            onClick = { navController.navigate(NavDestinations.PresentationView.route) },
            modifier = Modifier
                .fillMaxWidth(0.7f)
                .padding(vertical = 8.dp),
            shape = RoundedCornerShape(20.dp),
            colors = ButtonDefaults.buttonColors(containerColor = buttonColor)
        ) {
            Text(text = "Presentación", fontSize = 18.sp, color = Color.White)
        }

        Text(
            text = "Ortega Gómez Adán Paúl",
            fontSize = 16.sp,
            fontWeight = FontWeight.Medium,
            color = titleColor
        )
    }
}

@Preview(showBackground = true)
@Composable
fun HomeViewScreenPreview() {
    // Preview no necesita navController
    HomeViewScreen(navController = rememberNavController())
}