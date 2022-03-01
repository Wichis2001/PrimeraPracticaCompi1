package com.universidad.primerapractica.manejadores

import android.os.Build
import android.widget.TableLayout
import android.widget.TableRow
import android.widget.TextView
import androidx.annotation.RequiresApi
import com.universidad.primerapractica.R
import com.universidad.primerapractica.TablaError
import com.universidad.primerapractica.tokens.ErrorTexto

class ManejadorReporteError {
    var errores : ArrayList<ErrorTexto> = arrayListOf()
    var textView: TextView?=null
    var tabla: TableLayout?=null

    constructor()

    @RequiresApi(Build.VERSION_CODES.N)
    fun asignarErrores(ventana:TablaError){
        val bun = ventana.intent.extras
        errores = bun?.get("errores") as ArrayList<ErrorTexto>
        textView =ventana.findViewById(R.id.textRow) as TextView
        tabla=ventana.findViewById(R.id.TablasError) as TableLayout;
        textView!!.setText("");

        errores.forEach(){
            var lexema = TextView(ventana);
            var linea = TextView(ventana);
            var columna = TextView(ventana);
            var tipo = TextView(ventana);
            var descripcion = TextView(ventana);
            var row= TableRow(ventana);
            lexema.setText(it.lexema+" ");
            linea.setText(" ${it.linea} ")
            columna.setText(" ${it.columna} ");
            tipo.setText(it.lexema+" ");
            descripcion.setText(it.descripcion)
            row.addView(lexema);
            row.addView(linea);
            row.addView(columna);
            row.addView(tipo);
            row.addView(descripcion);
            tabla!!.addView(row);
        }
    }
}