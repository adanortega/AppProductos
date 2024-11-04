package com.example.appos.Views

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Phone
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.appproductos.Navigation.NavDestinations
import com.example.appproductos.R

class PresentationView : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val navController = rememberNavController() // Inicializa el NavController
            UserProfileScreen(navController = navController)
        }
    }
}

// Paleta de colores personalizada
val colorFondo = Color(0xFFE8EAF6) // Azul muy claro o gris
val colorTitulo = Color(0xFF3E4A59) // Gris más oscuro para contraste
val colorTexto = Color(0xFF37474F)  // Gris oscuro neutro para el texto

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun UserProfileScreen(navController: NavHostController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(colorFondo) // Fondo personalizado
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceBetween
    ) {
        // Fila superior con el botón de retroceso y título
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center // Centra horizontalmente
        ) {
            IconButton(
                onClick = { navController.navigate(NavDestinations.Home.route) },
                modifier = Modifier.align(Alignment.CenterVertically) // Centrado vertical
            ) {
                Icon(
                    imageVector = Icons.Default.ArrowBack,
                    contentDescription = "Retroceder",
                    tint = colorTitulo
                )
            }
            Spacer(modifier = Modifier.width(8.dp))
            Text(
                text = "Card view      ",
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold,
                color = colorTitulo,
                textAlign = TextAlign.Center,
                modifier = Modifier.weight(1f) // Centra el texto ocupando todo el ancho
            )
        }


        // Imagen de perfil
        Image(
            painter = painterResource(id = R.drawable.yo),
            contentDescription = "Imagen de perfil",
            modifier = Modifier
                .size(300.dp) // Tamaño reducido
                .padding(bottom = 16.dp),
            contentScale = ContentScale.Crop
        )


        // Información del usuario
        Column(
            modifier = Modifier.padding(bottom = 16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(text = "Adán Paúl Ortega Gómez", fontSize = 25.sp, color = colorTitulo)
            Text(text = "Diseño de front-end", fontSize = 20.sp, color = colorTitulo)
        }

        // Información de contacto
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Bottom
        ) {
            ContactInfoRow(Icons.Filled.Phone, "Cel. 6621118337", colorTexto)
            ContactInfoRowImage(painterResource(id = R.drawable.`in`), "Adán Ortega", colorTexto)
            ContactInfoRow(Icons.Filled.Email, "a221204964@unison.mx", colorTexto)
        }
    }
}

// Componente de información de contacto con ícono vectorial
@Composable
fun ContactInfoRow(icon: androidx.compose.ui.graphics.vector.ImageVector, info: String, textColor: Color) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 4.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center
    ) {
        Icon(
            imageVector = icon,
            contentDescription = null,
            modifier = Modifier.size(20.dp), // Tamaño uniforme
            tint = colorTexto
        )

        Spacer(modifier = Modifier.width(8.dp))
        Text(
            text = info,
            fontSize = 18.sp,  // Tamaño de fuente más grande
            color = textColor.copy(alpha = 0.87F) // Color un poco más oscuro para mejor legibilidad
        )

    }
}

// Componente de información de contacto con ícono de imagen
@Composable
fun ContactInfoRowImage(iconPainter: androidx.compose.ui.graphics.painter.Painter, info: String, textColor: Color) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 4.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center
    ) {
        Image(
            painter = iconPainter,
            contentDescription = null,
            modifier = Modifier.size(24.dp)
        )
        Spacer(modifier = Modifier.width(8.dp))
        Text(text = info, fontSize = 16.sp, color = textColor)
    }
}

@Composable
fun PresentationViewScreen(navController: NavHostController) {
    // Tu código para PresentationViewScreen aquí
    UserProfileScreen(navController = navController) // O puedes implementar una vista diferente
}

@Preview(showBackground = true)
@Composable
fun UserProfileScreenPreview() {
    // Preview no necesita un navController
    UserProfileScreen(navController = rememberNavController())
}