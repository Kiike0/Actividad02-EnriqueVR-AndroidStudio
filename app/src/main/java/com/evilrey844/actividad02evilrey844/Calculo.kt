package com.evilrey844.actividad02evilrey844

import android.widget.Toast

class Calculo (var num1: Int, var num2: Int, var resultado: Int, var operacion: Char) {


    fun calcular() {
        when (operacion) {
            '+' -> suma()
            '-' -> resta()
            '*' -> multiplicacion()
            '/' -> division()
            else -> {
                // Aquí puedes manejar el caso en que la operación no sea válida
            }
        }
    }

    fun suma() {
        resultado = num1 + num2
    }

    fun resta() {
        resultado = num1 - num2
    }

    fun multiplicacion() {
        resultado = num1 * num2
    }

    fun division() {
        if(num2 != 0)
            resultado = num1 / num2
        else {
            resultado = 0
            operacion = ' '
        }
    }


}