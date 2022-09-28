package mx.edu.utez

import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val edtValor = findViewById<EditText>(R.id.edtValor)
        val spTipo1 = findViewById<Spinner>(R.id.spTipo1)
        val spTipo2 = findViewById<Spinner>(R.id.spTipo2)
        val btnCalcular = findViewById<Button>(R.id.btnCalcular)
        val txtResultado = findViewById<TextView>(R.id.txtResultado)

        val tipos = listOf("°C", "°F", "°K", "°R")

        val adaptador = ArrayAdapter(this@MainActivity,
            android.R.layout.simple_list_item_1, tipos
        )

        spTipo1.adapter = adaptador
        spTipo2.adapter = adaptador

        btnCalcular.setOnClickListener {
            var resultado = 0.0

            val valorGrados = edtValor.text.toString().toDouble()
            val valorOrigen = spTipo1.selectedItem.toString()
            val valorDestino = spTipo2.selectedItem.toString()

            if (valorOrigen == "°C" && valorDestino == "°C") resultado = valorGrados
            if (valorOrigen == "°C" && valorDestino == "°F") resultado = (valorGrados * 9/5) + 32
            if (valorOrigen == "°C" && valorDestino == "°K") resultado = valorGrados + 273.15
            if (valorOrigen == "°C" && valorDestino == "°R") resultado = (valorGrados * 9/5) + 491.67

            if (valorOrigen == "°F" && valorDestino == "°F") resultado = valorGrados
            if (valorOrigen == "°F" && valorDestino == "°C") resultado = (valorGrados - 32) * 5/9
            if (valorOrigen == "°F" && valorDestino == "°K") resultado = ((valorGrados - 32) * 5/9) + 273.15
            if (valorOrigen == "°F" && valorDestino == "°R") resultado = valorGrados + 459.67

            if (valorOrigen == "°K" && valorDestino == "°K") resultado = valorGrados
            if (valorOrigen == "°K" && valorDestino == "°C") resultado = valorGrados - 273.15
            if (valorOrigen == "°K" && valorDestino == "°F") resultado = ((valorGrados - 273.15) * 9/5) + 32
            if (valorOrigen == "°K" && valorDestino == "°R") resultado = valorGrados * 1.8

            if (valorOrigen == "°R" && valorDestino == "°R") resultado = valorGrados
            if (valorOrigen == "°R" && valorDestino == "°C") resultado = (valorGrados - 491.67) * 5/9
            if (valorOrigen == "°R" && valorDestino == "°F") resultado = valorGrados - 459.67
            if (valorOrigen == "°R" && valorDestino == "°K") resultado = valorGrados * 5/9

            txtResultado.text = resultado.toString()

        }
    }
}