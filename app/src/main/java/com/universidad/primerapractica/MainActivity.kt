package com.universidad.primerapractica

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.Toast
import com.universidad.primerapractica.graficos.CantidadGraficas
import com.universidad.primerapractica.graficos.Grafica
import com.universidad.primerapractica.manejadores.ManejadorGraficasRealizadas
import com.universidad.primerapractica.manejadores.ManejadorMain
import com.universidad.primerapractica.tokens.ErrorTexto
import com.universidad.primerapractica.tokens.Operacion
import java.util.ArrayList

class MainActivity : AppCompatActivity() {

    lateinit var texArea: EditText


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun onClick(view: View){
        var manejador = ManejadorMain()
        texArea = findViewById(R.id.areaText)
        var texto = texArea.text.toString()
        manejador.analizar(texto, this)
    }

    public fun ejecucarVentantaError(errores : ArrayList<ErrorTexto>){
        val ejecutarVentanta = Intent(this, AnalisisError::class.java)
        ejecutarVentanta.putExtra("errores", errores as ArrayList<ErrorTexto>?)
        startActivity(ejecutarVentanta)
    }

    fun ejecutarVentanaExito(graficas : ArrayList<Grafica>, operaciones: ArrayList<Operacion>, listaGraficasMaquetar: ArrayList<String>, cantidadGraficas: CantidadGraficas, errores : ArrayList<ErrorTexto>){
        val ejecutarCodigo = Intent(this, AnalisisExitoso::class.java)
        ejecutarCodigo.putExtra("graficas", graficas as ArrayList<Grafica>?)
        ejecutarCodigo.putExtra("operations", operaciones as ArrayList<Operacion>?)
        ejecutarCodigo.putExtra("contGraficos", cantidadGraficas)
        ejecutarCodigo.putExtra("listGraficasEjecutar", listaGraficasMaquetar as ArrayList<String>?)
        ejecutarCodigo.putExtra("errores", errores as ArrayList<ErrorTexto>?)
        startActivity(ejecutarCodigo)
    }
}