package com.example.cartapresentacion

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.drawWithContent
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.cartapresentacion.ui.theme.CartaPresentacionTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            CartaPresentacionTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    App(
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun App(modifier: Modifier = Modifier) {
    Column(modifier = modifier
        .fillMaxSize()
        .background(colorResource(R.color.morado_fuerte)), horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.Center) {
        InformacionPrincipal(modifier = Modifier.weight(1f))
        InformacionContacto()
    }
}

@Preview
@Composable
fun AppPreview(modifier: Modifier = Modifier) {
    App()
}

@Composable
fun Nombre(nombre: String, modifier: Modifier = Modifier) {
    Text(text = nombre, textAlign = TextAlign.Center, fontSize = 32.sp, color = colorResource(id = R.color.morado_muy_ligero))
}

@Composable
fun Puesto(puesto: String, modifier: Modifier = Modifier) {
    Text(text = puesto, textAlign = TextAlign.Center, fontSize = 26.sp, color = colorResource(id = R.color.morado_muy_ligero), modifier = modifier.drawWithContent {
        drawContent()
        drawLine(
            color = Color(173, 73, 225),
            start = Offset(0f, size.height),
            end = Offset(size.width, size.height),
            strokeWidth = 6f
        )
    })
}

@Composable
fun InformacionPrincipal(modifier: Modifier = Modifier) {
    Column(horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.spacedBy(12.dp, Alignment.CenterVertically), modifier = modifier) {
        Image(painter = painterResource(id = R.drawable.imagen_perfil), contentDescription = "Imagen perfil", modifier = Modifier
            .clip(
                RoundedCornerShape(8.dp)
            )
            .width(180.dp))
        Nombre(nombre = "Luis Daniel Quiroz Osuna")
        Puesto(puesto = "Desarrolador Backend")
    }
}

@Composable
fun InformacionContacto(modifier: Modifier = Modifier) {
    Column(modifier = modifier
        .background(colorResource(id = R.color.morado_ligero))
        .fillMaxWidth(), horizontalAlignment = Alignment.CenterHorizontally) {
        Column {
            FilaInformacionContacto(idIcono = R.drawable.icono_telefono, tipoIcono = "Celular", valor = "6623997555")
            FilaInformacionContacto(idIcono = R.drawable.icono_github, tipoIcono = "GitHub", valor = "Quirozdev")
            FilaInformacionContacto(idIcono = R.drawable.icono_correo, tipoIcono = "Correo", valor = "luisdevv232@gmail.com")
        }
    }
}

@Composable
fun IconoContacto(idIcono: Int, tipoIcono: String, modifier: Modifier = Modifier) {
    Image(painter = painterResource(id = idIcono), contentDescription = tipoIcono, modifier = modifier
        .width(50.dp)
        .height(50.dp))
}

@Composable
fun FilaInformacionContacto(idIcono: Int, tipoIcono: String, valor: String, modifier: Modifier = Modifier) {
    Row(verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.spacedBy(8.dp), modifier = modifier) {
        IconoContacto(idIcono = idIcono, tipoIcono = tipoIcono)
        Text(text = valor, textAlign = TextAlign.Center, color = colorResource(id = R.color.morado_muy_ligero), fontSize = 18.sp)
    }
}