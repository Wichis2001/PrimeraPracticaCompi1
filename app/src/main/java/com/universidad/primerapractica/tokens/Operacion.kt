package com.universidad.primerapractica.tokens

open class Operacion:java.io.Serializable {
    private var tipoOperacion: String?;
    var linea: Int?;
    var columna: Int?;
    var ocurrencia: String?= null

    constructor(tipoOperacion: String?, linea: Int?, columna: Int?, ocurrencia: String?) {
        this.tipoOperacion = tipoOperacion
        this.linea = linea
        this.columna = columna
        this.ocurrencia = ocurrencia
    }
}