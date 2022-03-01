package com.universidad.primerapractica.graficos

class Pie( titulo: String?,
           esCantidad: Boolean,
           total: Double?,
           extra: String?,
           tuplas: ArrayList<Tupla>,
           items: ArrayList<String>,
           valores: ArrayList<Double>):Grafica( titulo, esCantidad , total, extra, tuplas, items, valores) {
}