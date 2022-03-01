package com.universidad.primerapractica

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import android.widget.Toast
import com.universidad.primerapractica.graficos.CantidadGraficas

class reporte_cantidad_graficas : AppCompatActivity() {
    var contG: CantidadGraficas?=null
    var textPie: TextView?=null;
    var textBarras: TextView?=null;
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_reporte_cantidad_graficas)
        val bun = intent.extras
        contG = bun?.get("contGraficos") as CantidadGraficas
        textBarras=findViewById(R.id.textView10) as TextView ;
        textPie=findViewById(R.id.textView11) as TextView;
        textBarras!!.setText("Grafica de Barras: "+contG?.graficosBarras.toString());
        textPie!!.setText("Grafica de  Pies: "+contG?.graficosPie.toString());
    }

    fun onClickReporte(view:View){
        val regresar = Intent(this, MainActivity::class.java)
        startActivity(regresar)
        Toast.makeText(this, "Regresando...", Toast.LENGTH_LONG).show()
    }
}