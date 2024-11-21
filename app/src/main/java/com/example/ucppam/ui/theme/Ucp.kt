package com.example.ucppam.ui.theme

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.ucppam.R

@Preview(showBackground = true)

@Composable
fun UcpInput(modifier: Modifier = Modifier){
    Isi()
    Box(
        modifier = Modifier.fillMaxWidth().background(Color.Blue)
    ){
        Row(modifier = Modifier.fillMaxWidth().padding(16.dp)) {
            Text(text = "Halo, ")
            Text(text = "")
        }
    }
}

@Composable
fun Isi(){
    var email by remember { mutableStateOf("") }
    var notelp by remember { mutableStateOf("") }
    var alamat by remember { mutableStateOf("") }
    var tahun by remember { mutableStateOf("") }

    var dataTahun = listOf("2021", "2022", "2023")
    var konfirmEmail by remember { mutableStateOf("") }
    var konfirmAlamat by remember { mutableStateOf("") }
    var konfirmNotelp by remember { mutableStateOf("") }
    var konfirmTahun by remember { mutableStateOf("") }

    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        TextField(
            value = email,
            onValueChange = {email = it},
            label ={
                Text(text = "Masukkan email anda")
            },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
            modifier =Modifier.fillMaxWidth().padding(20.dp)
        )

        TextField(
            value = notelp,
            onValueChange = {notelp = it},
            label = {
                Text(text = "Masukkan nomor telpon anda")
            },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            modifier = Modifier.fillMaxWidth().padding(16.dp)
        )

        TextField(
            value =  alamat,
            onValueChange = {alamat = it},
            label = {
                Text(text = "Masukkan alamat anda")
            },
            modifier = Modifier.fillMaxWidth().padding(16.dp)
        )

        Row(modifier = Modifier.fillMaxWidth()) {
            dataTahun.forEach{selectedTahun->
                Row(verticalAlignment = Alignment.CenterVertically) {
                    RadioButton(
                        selected = tahun == selectedTahun,
                        onClick ={ tahun = selectedTahun}
                    )
                    Text(text = selectedTahun)
                }
            }
        }

        Button(onClick = {
            konfirmEmail = email
            konfirmAlamat = alamat
            konfirmNotelp = notelp
            konfirmTahun = tahun
        }) {
            Text(text = "Simpan")
        }
        TampilData(
            param = "Email",
            argu = konfirmEmail)
        TampilData(
            param = "Alamat",
            argu = konfirmAlamat)
        TampilData(
            param = "No telpon",
            argu = konfirmNotelp)
        TampilData(
            param = "Tahun",
            argu = konfirmTahun)
    }
}



@Composable
fun TampilData(
    param: String, argu:String
){
    Column(
        modifier = Modifier.padding(16.dp)
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(text = param, modifier = Modifier.weight(0.8f))
            Text(text = ": ", modifier = Modifier.weight(0.2f))
            Text(text = argu, modifier = Modifier.weight(2f))
        }
    }
}
