//Autor: Cedeño Salazar Juan Rodolfo
//Materia Aplicaciones Móviles
//Curso: 7mo Nivel "A"

package com.example.diceroller

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.diceroller.R


class MainActivity : AppCompatActivity() {

    /**
     * Este metodo es llamado con la actividad es iniciada.
     */
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Encontramos el boton en el diseño
        val rollButton: Button = findViewById(R.id.button)

        // Configuramos el boton para tirar los dados cuando el usuario toca el boton
        rollButton.setOnClickListener { rollDice() }
    }

    /**
     * Tiramos el dado y actualizamos con el resultado
     */
    private fun rollDice() {
        // Creamos un nuevo objeto Dado con 6 lados y tíralo.
        val dice = Dice(6)
        val diceRoll = dice.roll()

        // Actualizamos la pantalla con el resultado de la tirada de dados.
        val resultTextView: TextView = findViewById(R.id.textView)
        resultTextView.text = diceRoll.toString()
    }
}

/**
 * Dado con un numero fijo de lados.
 */
class Dice(private val numSides: Int) {

    /**
     * Tiramos el dado al azar y muestra el reultado.
     */
    fun roll(): Int {
        return (1..numSides).random()
    }
}