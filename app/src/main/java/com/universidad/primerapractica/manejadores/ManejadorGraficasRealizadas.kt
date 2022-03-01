package com.universidad.primerapractica.manejadores

import com.universidad.primerapractica.graficos.Grafica

class ManejadorGraficasRealizadas {
    constructor()


    fun AsignarGraficosArray(graficoPila: Grafica, graficas: MutableList<Grafica>, esBarra: Boolean){
        if (esBarra && graficoPila.completoBarra()){
            graficas.add(graficoPila.convertGrafica(true))
        }
        if (!esBarra && graficoPila.veriricaionElementosPie()){
            graficas.add(graficoPila.convertGrafica(false))
        }
    }
}