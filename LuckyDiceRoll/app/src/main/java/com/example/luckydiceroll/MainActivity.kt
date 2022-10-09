//Autor: Cedeño Salazar Juan Rodolfo
//Materia Aplicaciones Móviles
//Curso: 7mo Nivel "A"

package com.example.luckydiceroll

fun main() {
    val myFirstDice = Dice(6)
    val rollResult = myFirstDice.roll()
    val luckyNumber = 4

    when (rollResult) {
        luckyNumber -> println("You won!")
        1 -> println("¡Lo siento mucho! Sacaste un 1. ¡Inténtalo de nuevo!")
        2 -> println("Lamentablemente, sacaste un 2. ¡Inténtalo de nuevo!")
        3 -> println("Desafortunadamente, sacaste un 3. ¡Inténtalo de nuevo!")
        5 -> println("¡No llores! Sacaste un 5. ¡Inténtalo de nuevo!")
        6 -> println("¡Disculpas! Obtuviste un 6. ¡Inténtalo de nuevo!")
    }
}

class Dice(val numSides: Int) {
    fun roll(): Int {
        return (1..numSides).random()
    }
}