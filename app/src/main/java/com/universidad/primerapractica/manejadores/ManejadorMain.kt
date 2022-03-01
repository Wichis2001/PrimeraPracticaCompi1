package com.universidad.primerapractica.manejadores

import android.content.Intent
import android.widget.Toast
import com.universidad.primerapractica.MainActivity
import com.universidad.primerapractica.analizadores.LexerAnalyzer
import com.universidad.primerapractica.analizadores.ParserAnalyzer
import com.universidad.primerapractica.graficos.CantidadGraficas
import com.universidad.primerapractica.graficos.Grafica
import com.universidad.primerapractica.tokens.ErrorTexto
import com.universidad.primerapractica.tokens.Operacion
import java.io.Reader
import java.io.StringReader
import java.util.ArrayList

class ManejadorMain {
    var graficas : ArrayList<Grafica> = arrayListOf()
    var operations: ArrayList<Operacion> = arrayListOf()
    var listaGraficasMaquetar: ArrayList<String> = arrayListOf()
    var cantidadGraficas:CantidadGraficas = CantidadGraficas(0,5)
    var errores : ArrayList<ErrorTexto> = arrayListOf()

    constructor() {
    };

    public fun analizar(areaTexto: String, ventana: MainActivity){
        val reader: Reader = StringReader(areaTexto)
        val lexerAnalyzer: LexerAnalyzer = LexerAnalyzer(reader)
        val parserAnalyzer: ParserAnalyzer = ParserAnalyzer(lexerAnalyzer)
        if(areaTexto  == ""){
            Toast.makeText(ventana,"El area de texto se encuentra vacio!, Ingrese Texto para poder contunuar", Toast.LENGTH_LONG).show()
        }else {
            try {
                parserAnalyzer.parse()
                graficas = parserAnalyzer.graficas
                operations = parserAnalyzer.operaciones
                cantidadGraficas = parserAnalyzer.contGraficos
                errores = parserAnalyzer.errores
                Grafica.unionErroresLexiconConSintacticos(LexerAnalyzer.erroresTextoEntrada, errores)
                listaGraficasMaquetar = parserAnalyzer.listaGraficasEjecucion
                Toast.makeText(ventana, "El texto ingresado no contiene errores", Toast.LENGTH_LONG).show()
                ventana.ejecutarVentanaExito(graficas, operations, listaGraficasMaquetar, cantidadGraficas, errores)
            } catch (ex: Exception){
                errores = parserAnalyzer.errores
                Grafica.unionErroresLexiconConSintacticos(LexerAnalyzer.erroresTextoEntrada, errores)
                ex.printStackTrace()
                ventana.ejecucarVentantaError(errores)
                Toast.makeText(ventana, "El texto ingresado no es capaz de generar ningun tipo de graficas designadas en la gramatica", Toast.LENGTH_LONG).show()
            }

        }
    }

    private fun startActivity(ejecutarCodigo: Intent) {

    }
}