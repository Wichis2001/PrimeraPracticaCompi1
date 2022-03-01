package com.universidad.primerapractica.tokens

import com.universidad.primerapractica.enums.TipoError

class ErrorTexto:java.io.Serializable {
    var lexema: String?=null;
    var linea: Int?=null;
    var columna:Int?=null;
    var descripcion:String?=null;
    var errSintactico= false;

    constructor(lexema: String?, linea: Int?, columna: Int?, descripcion: String?) {
        this.lexema = lexema
        this.linea = linea
        this.columna = columna
        this.descripcion = descripcion
    }


    constructor(lexema: String?, linea: Int?, columna: Int?, descripcion: String?, errSintactico: Boolean) {
        this.lexema = lexema
        this.linea = linea
        this.columna = columna
        this.descripcion = descripcion
        this.errSintactico = errSintactico
    }
}