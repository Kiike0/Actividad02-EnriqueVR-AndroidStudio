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
            realizarOperacion('+')
        }
        buttonmenos.setOnClickListener {
            realizarOperacion('-')
        }
        buttonmultiplicar.setOnClickListener {
            realizarOperacion('*')
        }
        buttondividir.setOnClickListener {
            realizarOperacion('/')
        }
        buttonigual.setOnClickListener {
            if (operacion != null && textView.text.isNotEmpty()) {
                /*
                Antes de haber pulsado el igual, habremos insertado una operacion antes
                y también la condicion de que no esté vacío el texto en pantalla
                 */
                calculo.num2 = textView.text.toString().toInt() //El numero Actual que sale en pantalla
                calculo.operacion = operacion ?: ' ' // Si operacion es nulo, asignamos un valor predeterminado
                calculo.calcular() //Llamamos al metodo calcular porque ya tendremos num1, num2 y la operacion
                textView.text = calculo.resultado.toString() //Mostramos el resultado
                operacion = null //Reseteamos que la operacion sea null
                reseteoPantalla = true //Limpiamos la pantalla de los numeros anteriores
            } else {
                Toast.makeText(
                    applicationContext,
                    "Debe introducir 2 números y una operación antes de calcular",
                    Toast.LENGTH_SHORT
                ).show()
            }
        }
        buttonce.setOnClickListener {
            reiniciarCalculadora()
        }

    }

    private fun setNumClicked(numero: Int) {
        if (reseteoPantalla) { //Si es true..
            textView.text = ""
            reseteoPantalla = false
        }

        val numActual = textView.text.toString()
        val nuevoNum = "$numActual$numero"
        textView.text = nuevoNum //Vamos añadiendo el numero hasta que se resete la pantalla al pulsar una operación
        //La cual la realizamos con el metodo realizarOperación
    }

    private fun realizarOperacion(op: Char) {
        operacion = op //Cambiamos el valor del char
        reseteoPantalla = true //reseteamos la pantalla para que funcione setNumClicked correctamente y se vea mejor también
        calculo.num1 = textView.text.toString().toInt() // Actualiza num1 con los números que hemos ido insertando hasta pulsar la operación
        //También vale para guardar lo que se vea en pantalla para más operaciones

    }

    private fun reiniciarCalculadora() { //Todos los valores se vuelven a 0 y la pantalla se limpia
        textView.text = ""
        operacion = ' '
        reseteoPantalla = true
        calculo = Calculo(0, 0, 0, ' ')
    }



}