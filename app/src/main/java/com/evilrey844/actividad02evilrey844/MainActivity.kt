package com.evilrey844.actividad02evilrey844

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    private lateinit var textView: TextView //Este parámetro servirá para modificar lo que aparece en textView
    private lateinit var button0: Button //Este parámetro sirve para modificar la acción del botón
    private lateinit var button1: Button
    private lateinit var button2: Button
    private lateinit var button3: Button
    private lateinit var button4: Button
    private lateinit var button5: Button
    private lateinit var button6: Button
    private lateinit var button7: Button
    private lateinit var button8: Button
    private lateinit var button9: Button
    private lateinit var buttonplus: Button
    private lateinit var buttonmenos: Button
    private lateinit var buttonmultiplicar: Button
    private lateinit var buttondividir: Button
    private lateinit var buttonigual: Button
    private lateinit var buttonce: Button
    private var numCompleto: Int = 0
    private var numCondicion: Int = 0
    private var operacion: Char? = null
    private var reseteoPantalla = false // Para saber si se debe resetear de la operación
    private var calculo = Calculo(0, 0, 0, ' ') //Objeto calculo vacío

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        textView = findViewById(R.id.textView)
        button0 = findViewById(R.id.button0)
        button1 = findViewById(R.id.button1)
        button2 = findViewById(R.id.button2)
        button3 = findViewById(R.id.button3)
        button4 = findViewById(R.id.button4)
        button5 = findViewById(R.id.button5)
        button6 = findViewById(R.id.button6)
        button7 = findViewById(R.id.button7)
        button8 = findViewById(R.id.button8)
        button9 = findViewById(R.id.button9)
        buttonplus = findViewById(R.id.buttonplus)
        buttonmenos = findViewById(R.id.buttonmenos)
        buttonmultiplicar = findViewById(R.id.buttonmultiplicar)
        buttondividir = findViewById(R.id.buttondividir)
        buttonigual = findViewById(R.id.buttonigual)
        buttonce = findViewById(R.id.buttonce)


        /**
         * Cada vez que pulsemos los botones se realiza una acción
         */
        button1.setOnClickListener {
            setNumClicked(1); //Llamamos al metodo que hemos creado
        }
        button2.setOnClickListener {
            setNumClicked(2);
        }
        button3.setOnClickListener {
            setNumClicked(3);
        }
        button4.setOnClickListener {
            setNumClicked(4);
        }
        button5.setOnClickListener {
            setNumClicked(5);
        }
        button6.setOnClickListener {
            setNumClicked(6);
        }
        button7.setOnClickListener {
            setNumClicked(7);
        }
        button8.setOnClickListener {
            setNumClicked(8);
        }
        button9.setOnClickListener {
            setNumClicked(9);
        }
        button0.setOnClickListener {
            setNumClicked(0);
        }
        buttonplus.setOnClickListener {
            asignarNum1(numCompleto)
            asignarOperacion('+')
        }
        buttonmenos.setOnClickListener {
            asignarNum1(numCompleto)
            asignarOperacion('-')
        }
        buttonmultiplicar.setOnClickListener {
            asignarNum1(numCompleto)
            asignarOperacion('*')
        }
        buttondividir.setOnClickListener {
            asignarNum1(numCompleto)
            asignarOperacion('/')
        }
        /**
         * El botón igual es el más complejo ya que realiza toda la operacion si se cumplen las condiciones correctas
         */
        buttonigual.setOnClickListener {
            if (numCompleto == 0 || numCondicion ==textView.text.toString().toInt()) {
                mostrarmensaje()
            } else {
                if (numCondicion!=textView.text.toString().toInt()){ //Lo tenemos que volver a poner porque si no da problemas el programa
                    asignarNum2(numCompleto) //El numero Actual que sale en pantalla
                    calculo.operacion = operacion
                        ?: ' ' // Te obliga el programa para que no de errores: si operacion es nulo, asignamos un valor predeterminado
                    calculo.calcular() //Llamamos al metodo calcular porque ya tendremos num1, num2 y la operacion
                    textView.text = calculo.resultado.toString() //Mostramos el resultado
                    operacion = null //Reseteamos que la operacion sea null
                    reseteoPantalla = true //Limpiamos la pantalla
                    numCompleto = calculo.resultado //Por si queremos hacer mas operaciones lo guardamos en numResultado
                    numCondicion=textView.text.toString().toInt() //Este codigo está escrito para que si pulsamos un * y luego un =
                                                                    //sin pasar un número no de problemas la calculadora.
                }


            }
        }
        /**
         * Al pulsar CE volvemos a reiniciar la calculadora
         */
        buttonce.setOnClickListener {
            reiniciarCalculadora()
        }

    }

    /**
     * En este método insertamos los numeros según pulsemos los botones
     */
    private fun setNumClicked(numero: Int) {
        if (reseteoPantalla) { //Si es true..
            textView.text = ""
            reseteoPantalla = false
        }

        val numActual = textView.text.toString()
        val nuevoNum = "$numActual$numero"
        textView.text = nuevoNum
        //Vamos añadiendo el numero hasta que se resete la pantalla al pulsar una operación
        //La cual la realizamos con el metodo realizarOperación
        numCompleto = nuevoNum.toInt() //Y lo añadimos en numResultado
    }

    /**
     * En este método asignamos la operacion al char que hemos creado
     */
    private fun asignarOperacion(op: Char) {
        operacion = op //Cambiamos el valor del char
        reseteoPantalla =
            true //reseteamos la pantalla para que funcione setNumClicked correctamente y se vea mejor también
    }

    /**
     * En este método asignamos el primer numero que vamos a utilizar en el cálculo
     */
    private fun asignarNum1(numero: Int) {
        calculo.num1 =
            numero // Actualiza num1 con los números que hemos ido insertando hasta pulsar la operación
    }

    /**
     * En este método asignamos el segundo numero que vamos a utilizar en el cálculo
     */
    private fun asignarNum2(numero: Int) {
        calculo.num2 =
            numero // Actualiza num1 con los números que hemos ido insertando hasta pulsar la operación
    }

    /**
     * Reiniciamos la calculadora y ponemos todos sus valores a 0 en este método
     */
    private fun reiniciarCalculadora() { //Todos los valores se vuelven a 0 y la pantalla se limpia
        textView.text = ""
        operacion = ' '
        reseteoPantalla = true
        numCompleto = 0
        calculo = Calculo(0, 0, 0, ' ')
    }

    /**
     * Mostramos el mensaje TOAST (emergente) si cumple la condición que le hemos pasado antes
     */
    private fun mostrarmensaje(){
        Toast.makeText(
            applicationContext,
            "Debe introducir 2 números y una operación antes de calcular",
            Toast.LENGTH_SHORT
        ).show()
    }

}