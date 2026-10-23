package com.example.ud05cp01

import android.app.DatePickerDialog
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import java.time.LocalDate
import java.time.Period
import java.time.temporal.ChronoUnit

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val botonFecha = findViewById<Button>(R.id.botonFecha)
        val textoFecha = findViewById<TextView>(R.id.textoFecha)
        val textoAnios = findViewById<TextView>(R.id.textoAnios)
        val textoDias = findViewById<TextView>(R.id.textoDias)

        botonFecha.setOnClickListener {

            val hoy = LocalDate.now()

            val dialogo = DatePickerDialog(
                this,
                { _, anio, mes, dia ->

                    val nacimiento = LocalDate.of(anio, mes + 1, dia)

                    val anios = Period.between(nacimiento, hoy).years

                    val dias = ChronoUnit.DAYS.between(nacimiento, hoy)

                    textoFecha.text =
                        "Fecha de nacimiento: $dia/${mes + 1}/$anio"

                    textoAnios.text = "Años cumplidos: $anios"
                    textoDias.text = "Días totales vividos: $dias"
                },
                hoy.year,
                hoy.monthValue - 1,
                hoy.dayOfMonth
            )

            dialogo.datePicker.maxDate = System.currentTimeMillis()

            dialogo.show()
        }
    }
}
