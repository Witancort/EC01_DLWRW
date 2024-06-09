package pe.edu.idat.ec01_dlrw


import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun PromedioPracticas() {
    var practica1 by rememberSaveable { mutableStateOf("") }
    var practica2 by rememberSaveable { mutableStateOf("") }
    var practica3 by rememberSaveable { mutableStateOf("") }
    var practica4 by rememberSaveable { mutableStateOf("") }
    var resultado by rememberSaveable { mutableStateOf("") }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(top = 25.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp)
        ) {
            Text(
                text = "Promedio Prácticas",
                textAlign = TextAlign.Center,
                modifier = Modifier.fillMaxWidth().padding(vertical = 16.dp),
                style = TextStyle(
                    fontFamily = FontFamily.Cursive,
                    fontWeight = FontWeight.Bold,
                    fontSize = 30.sp
                )
            )
            OutlinedTextField(
                value = practica1,
                onValueChange = { practica1 = it },
                modifier = Modifier.fillMaxWidth(),
                label = { Text("Ingrese Práctica 1") },
                maxLines = 1,
                singleLine = true,
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
            )
            MySpace(16)
            OutlinedTextField(
                value = practica2,
                onValueChange = { practica2 = it },
                modifier = Modifier.fillMaxWidth(),
                label = { Text("Ingrese Práctica 2") },
                maxLines = 1,
                singleLine = true,
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
            )
            MySpace(16)
            OutlinedTextField(
                value = practica3,
                onValueChange = { practica3 = it },
                modifier = Modifier.fillMaxWidth(),
                label = { Text("Ingrese Práctica 3") },
                maxLines = 1,
                singleLine = true,
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
            )
            MySpace(16)
            OutlinedTextField(
                value = practica4,
                onValueChange = { practica4 = it },
                modifier = Modifier.fillMaxWidth(),
                label = { Text("Ingrese Práctica 4") },
                maxLines = 1,
                singleLine = true,
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
            )
            MySpace(16)
            Button(
                onClick = {
                    var promedio = calcularPromedioPracticas(practica1.toInt(), practica2.toInt(), practica3.toInt(), practica4.toInt())
                    resultado = "Promedio: ${promedio.first}, Nota eliminada: ${promedio.second}"
                },
                modifier = Modifier.fillMaxWidth()
            ) {
                Text("Calcular")
            }
            MySpace(16)
            Text(
                text = resultado,
                style = TextStyle(fontWeight = FontWeight.Bold, color = Color.DarkGray)
            )
        }
    }
}



fun calcularPromedioPracticas(practica1: Int, practica2: Int, practica3: Int, practica4: Int): Pair<Int, Int> {
    var notas = mutableListOf(practica1, practica2, practica3, practica4)
    var notaEliminada = notas.minOrNull() ?: 0
    notas.remove(notaEliminada)
    var promedio = notas.average().toInt() // Redondear el promedio al entero más cercano
    return Pair(promedio, notaEliminada)
}
