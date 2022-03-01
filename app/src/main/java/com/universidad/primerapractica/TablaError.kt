package com.universidad.primerapractica

import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TableLayout
import android.widget.TableRow
import android.widget.TextView
import androidx.annotation.RequiresApi
import com.universidad.primerapractica.manejadores.ManejadorMain
import com.universidad.primerapractica.manejadores.ManejadorReporteError
import com.universidad.primerapractica.tokens.ErrorTexto

class TablaError : AppCompatActivity() {
    var errores : ArrayList<ErrorTexto> = arrayListOf()
    var textView: TextView?=null
    var tabla: TableLayout?=null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tabla_error)
        val bun = intent.extras
        errores = bun?.get("errores") as ArrayList<ErrorTexto>
        textView =findViewById(R.id.textRow) as TextView
        tabla=findViewById(R.id.TablasError) as TableLayout;
        textView!!.setText("");

        errores.forEach(){
            var lexema = TextView(this);
            var linea = TextView(this);
            var columna = TextView(this);
            var tipo = TextView(this);
            var descripcion = TextView(this);
            var row= TableRow(this);
            lexema.setText(it.lexema+" ");
            linea.setText(" ${it.linea} ")
            columna.setText(" ${it.columna} ");
            tipo.setText(tipo(it.errSintactico));
            descripcion.setText(it.descripcion)
            row.addView(lexema);
            row.addView(linea);
            row.addView(columna);
            row.addView(tipo);
            row.addView(descripcion);
            tabla!!.addView(row);
        }
    }

    fun tipo(esSintactico:Boolean):String{
        if (esSintactico) {
            return "SINTACTICO"
        }else{
            return "LEXICO"
        }

    }
}