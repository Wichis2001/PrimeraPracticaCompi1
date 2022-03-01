package com.universidad.primerapractica

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.MediaController
import android.widget.Toast
import android.widget.VideoView
import com.google.android.material.tabs.TabLayout.Tab
import com.universidad.primerapractica.R
import com.universidad.primerapractica.tokens.ErrorTexto

class AnalisisError : AppCompatActivity() {

    var errores : ArrayList<ErrorTexto> = arrayListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_analisis_error)
        var videoView = findViewById<VideoView>(R.id.videoView2)
        var mcLocal = MediaController(this)
        var path = "android.resource://"+packageName+"/"+R.raw.videoerror
        videoView.setVideoURI(Uri.parse(path))
        videoView.setMediaController(mcLocal)
        videoView.start()
        val bun = intent.extras
        errores = bun?.get("errores") as ArrayList<ErrorTexto>
    }

    fun onClickReportError(view: View){
        val ejecutarVentana = Intent(this, TablaError::class.java)
        ejecutarVentana.putExtra("errores", errores as java.util.ArrayList<ErrorTexto>?)
        startActivity(ejecutarVentana)
    }

    fun regresar(view: View){
        val regresar = Intent(this, MainActivity::class.java)
        startActivity(regresar)
        Toast.makeText(this, "Regresando...", Toast.LENGTH_LONG).show()
    }
}