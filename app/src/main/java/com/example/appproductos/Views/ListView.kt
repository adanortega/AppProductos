package com.example.appproductos.Views

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.appproductos.Navigation.NavDestinations

class ListView : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            // Aquí puedes configurar el NavController si es necesario
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ListViewScreen(navController: NavHostController) {
    val colorFondo = Color(0xFFF2F2F2)
    val colorTitulo = Color(0xFF336699)
    val colorCaja = Color(0xFFFFFFFF)
    val colorLinea = Color(0xFFCCCCCC)
    val colorTextPrimary = Color(0xFF333333)
    val colorTextSecondary = Color(0xFF666666)

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        text = "List View       ",
                        color = colorTitulo,
                        modifier = Modifier.fillMaxWidth(),
                        textAlign = TextAlign.Center,
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Bold
                    )
                },
                navigationIcon = {
                    IconButton(onClick = { navController.navigate(NavDestinations.Home.route) }) {
                        Icon(
                            imageVector = Icons.Default.ArrowBack,
                            contentDescription = "Retroceder",
                            tint = colorTitulo
                        )
                    }
                },
                colors = TopAppBarDefaults.largeTopAppBarColors(containerColor = colorFondo)
            )
        },
        floatingActionButton = {
            FloatingActionButton(
                onClick = { navController.navigate(NavDestinations.Formulario.route) },
                containerColor = Color(0xFF336699),
                contentColor = Color.White
            ) {
                Icon(
                    imageVector = Icons.Default.Add,
                    contentDescription = "Añadir producto"
                )
            }
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(colorFondo)
                .padding(innerPadding)
                .padding(16.dp)
        ) {
            // Título "Productos"
            Text(
                text = "Productos",
                color = colorTitulo,
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 16.dp),
                textAlign = TextAlign.Center
            )

            ProductItem(
                productName = "Waka Triple Mango 8k",
                productDescription = "Cigarrillo Electrico",
                productPrice = "$320",
                productDate = "09/04/2024",
                colorPrimary = colorTextPrimary,
                colorSecondary = colorTextSecondary,
                colorBackground = colorCaja,
                colorBorder = colorLinea
            )

            Spacer(modifier = Modifier.height(8.dp))

            ProductItem(
                productName = "Waka Triple Mango 10K",
                productDescription = "Cigarrillo Electrico",
                productPrice = "$340",
                productDate = "09/05/2024",
                colorPrimary = colorTextPrimary,
                colorSecondary = colorTextSecondary,
                colorBackground = colorCaja,
                colorBorder = colorLinea
            )
        }
    }
}

@Composable
fun ProductItem(
    productName: String,
    productDescription: String,
    productPrice: String,
    productDate: String,
    colorPrimary: Color,
    colorSecondary: Color,
    colorBackground: Color,
    colorBorder: Color
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(colorBackground, shape = RoundedCornerShape(8.dp))
            .border(1.dp, colorBorder, shape = RoundedCornerShape(8.dp))
            .padding(16.dp)
    ) {
        Text(
            text = productName,
            color = colorPrimary,
            fontWeight = FontWeight.Bold,
            fontSize = 18.sp
        )
        Spacer(modifier = Modifier.height(4.dp))
        Text(
            text = productDescription,
            color = colorSecondary,
            fontSize = 16.sp
        )
        Spacer(modifier = Modifier.height(4.dp))
        Text(
            text = productPrice,
            color = colorPrimary,
            fontSize = 16.sp
        )
        Spacer(modifier = Modifier.height(4.dp))
        Text(
            text = productDate,
            color = colorSecondary,
            fontSize = 14.sp
        )
    }
}
