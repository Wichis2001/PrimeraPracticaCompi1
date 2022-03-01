package com.universidad.primerapractica.graficos

class CantidadGraficas:java.io.Serializable {
    var graficosBarras: Int = 0
    var graficosPie: Int = 0

    constructor()
    constructor(graficosBarras: Int, graficosPie: Int) {
        this.graficosBarras = graficosBarras
        this.graficosPie = graficosPie
    }
}