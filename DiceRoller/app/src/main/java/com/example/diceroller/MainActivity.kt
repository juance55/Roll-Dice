package com.example.diceroller

import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Encuentra el botón en el diseño
        val rollButton: Button = findViewById(R.id.button)

        // Establecer un detector de clics en el botón para tirar los dados cuando el usuario toque el botón
        rollButton.setOnClickListener { rollDice() }

        // Realiza una tirada de dados cuando se inicia la aplicacion
        rollDice()
    }

    /**
     * Tira los dados y actualiza la pantalla con el resultado.
     */
    private fun rollDice() {
        // Creamos el dado con 6 lado y lo tiramos
        val dice = Dice(6)
        val diceRoll = dice.roll()

        // Encuetra la imagen en le diseño
        val diceImage: ImageView = findViewById(R.id.imageView)

        // Determina la imagen en funcion al resultado del dado
        val drawableResource = when (diceRoll) {
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> R.drawable.dice_6
        }

        // Actualiza la imagen con el id correspondiente
        diceImage.setImageResource(drawableResource)

        // Actualiza la descripcion
        diceImage.contentDescription = diceRoll.toString()
    }
}

/**
 * Dado con un numero fijo de lados
 */
class Dice(private val numSides: Int) {

    /**
     * Tira lo dados al azar y mustra el resultado.
     */
    fun roll(): Int {
        return (1..numSides).random()
    }
}