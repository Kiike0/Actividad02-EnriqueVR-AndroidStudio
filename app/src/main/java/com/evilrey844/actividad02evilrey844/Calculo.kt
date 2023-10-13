package com.evilrey844.actividad02evilrey844

class Calculo (var num1: Int, var num2: Int, var resultado: Int, var operacion: Char) {


    /**
     * Llamo a todos los métodos según el char que lea pasado con un when
     */
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

    /**
     * El metodo suma hace la suma de num1 y num2
     */
    fun suma() {
        resultado = num1 + num2
    }

    /**
     * El metodo resta hace la resta de num1 y num2
     */
    fun resta() {
        resultado = num1 - num2
    }

    /**
     * El metodo multiplicacion hace la multiplicación de num1 y num2
     */
    fun multiplicacion() {
        resultado = num1 * num2
    }

    /**
     * El metodo division hace la division de num1 y num2
     * mientras sea distinto de 0 porque no se puede dividir por 0
     * si se divide por 0 yo he puesto que el resultado sea 0
     */
    fun division() {
        if(num2 != 0)
            resultado = num1 / num2
        else {
            resultado = 0
            operacion = ' '
        }
    }


}