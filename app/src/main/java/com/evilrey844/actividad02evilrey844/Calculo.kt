package com.evilrey844.actividad02evilrey844

class Calculo {

    var num1: String = ""
    var num2: String = ""
    var resultado: Float = 0F
    var operacion: Char = ' '
    var boolOperacion : Boolean = false //true -> existe una operacion en vigor / false -> se ha borrado
    var boolResultado : Boolean = false //true -> se ha pulsado igual / false -> no
    var reseteoPantalla : Boolean = true //true porque no hay nada escrito / false-> cuando lo haya

    /**
     * Llamo a todos los métodos según el char que lea pasado con un when
     * @param --> ponerlo en los métodos
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
        resultado = num1.toString().toFloat() + num2.toString().toFloat()
    }

    /**
     * El metodo resta hace la resta de num1 y num2
     */
    fun resta() {
        resultado = num1.toString().toFloat() - num2.toString().toFloat()
    }

    /**
     * El metodo multiplicacion hace la multiplicación de num1 y num2
     */
    fun multiplicacion() {
        resultado = num1.toString().toFloat() * num2.toString().toFloat()
    }

    /**
     * El metodo division hace la division de num1 y num2
     * mientras sea distinto de 0 porque no se puede dividir por 0
     * si se divide por 0 yo he puesto que el resultado sea 0
     */
    fun division() {
        if(num2.toString().toInt() != 0)
            resultado = num1.toString().toFloat() / num2.toString().toFloat()
        else {
            resultado = 0F
            operacion = ' '
        }
    }

    fun setDigito(numero: Int){
        //Si es menor que 10, se trata de un dígito del 0 al 9.
        //Sino, es el punto decimal.
        if (numero < 10){
            if (this.reseteoPantalla)
                this.num1 += numero.toString()
            else
                this.num2 += numero.toString()
        }
        else {
            if (this.reseteoPantalla) {
                //Agregamos el decimal a la cadena
                if (this.num1.contains('.')||this.num1.isEmpty())
                    this.num1 +=""
                else
                    this.num1 +="."
            }
            else {
                //Y con el número 2
                if (this.num2.contains('.')||this.num2.isEmpty())
                    this.num2 += ""
                else
                    this.num2 += "."
            }

        }

    }


}