package com.universidad.primerapractica

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.MediaController
import android.widget.Toast
import android.widget.VideoView
import com.universidad.primerapractica.graficos.CantidadGraficas
import com.universidad.primerapractica.graficos.Grafica
import com.universidad.primerapractica.tokens.ErrorTexto
import com.universidad.primerapractica.tokens.Operacion
import java.net.URI
var errores : ArrayList<ErrorTexto> = arrayListOf()
var graficas : ArrayList<Grafica> = arrayListOf()
var graficasSeleccionadas : ArrayList<Grafica> = arrayListOf()
var operations: ArrayList<Operacion> = arrayListOf()
var contGraficos: CantidadGraficas?=null
var listGraficasEjecutar: ArrayList<String> = arrayListOf()
class AnalisisExitoso : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_analisis_exitoso)
        var videoView = findViewById<VideoView>(R.id.videoView)
        var mcLocal = MediaController(this)
        var path = "android.resource://"+packageName+"/"+R.raw.videoexito
        videoView.setVideoURI(Uri.parse(path))
        videoView.setMediaController(mcLocal)
        videoView.start()
        val bun = intent.extras
        errores = bun?.get("errores") as ArrayList<ErrorTexto>
        operations = bun?.get("operations") as ArrayList<Operacion>
        graficas = bun?.get("graficas") as ArrayList<Grafica>
        contGraficos = bun?.get("contGraficos") as CantidadGraficas
        errores = bun?.get("errores")  as ArrayList<ErrorTexto>
        listGraficasEjecutar = bun?.get("listGraficasEjecutar") as ArrayList<String>
    }

    fun regresarExito(view:View){
        val regresar = Intent(this, MainActivity::class.java)
        startActivity(regresar)
        Toast.makeText(this, "Regresando...", Toast.LENGTH_LONG).show()
    }

    fun reportesExito(view:View){
        val ejecutar = Intent(this, reporte_cantidad_graficas::class.java)
        ejecutar.putExtra("contGraficos", contGraficos as CantidadGraficas)
        startActivity(ejecutar)
    }

    fun verReportes(view:View){
        var listTitulosReit: ArrayList<String> = arrayListOf()
        graficas.forEach(){
            if (listGraficasEjecutar.contains(it.titulo) && listTitulosReit.isEmpty()){
                graficasSeleccionadas.add(it)
                listTitulosReit.add(it.titulo.toString())
            }else if (listGraficasEjecutar.contains(it.titulo) && !listTitulosReit.contains(it.titulo)){
                graficasSeleccionadas.add(it)
                listTitulosReit.add(it.titulo.toString())
            }
        }
        val lanzar = Intent(this, GraficosVista::class.java)
        lanzar.putExtra("graficas", graficasSeleccionadas as java.util.ArrayList<Grafica>?)
        startActivity(lanzar)
    }


}