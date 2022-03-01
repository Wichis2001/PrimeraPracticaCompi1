package com.universidad.primerapractica.graficos
import com.universidad.primerapractica.analizadores.LexerAnalyzer
import com.universidad.primerapractica.tokens.ErrorTexto
import java.io.Serializable

open class Grafica : Serializable {

    var titulo: String?=null
    var ejecutar = false
    var hayCantidad = false
    var total: Double?= null
    var extra: String?= null
    var tuplas : ArrayList<Tupla> = arrayListOf()
    var items : ArrayList<String> = arrayListOf()
    var valores : ArrayList<Double> = arrayListOf()
    var contadorDeProduciones: Int=0
    var yaTipo = false

    constructor(
        titulo: String?,
        hayCantidad: Boolean,
        total: Double?,
        extra: String?,
        tuplas: ArrayList<Tupla>,
        items: ArrayList<String>,
        valores: ArrayList<Double>
    ) {
        this.titulo = titulo
        this.ejecutar = ejecutar
        this.hayCantidad = hayCantidad
        this.total = total
        this.extra = extra
        this.tuplas = tuplas
        this.items = items
        this.valores = valores
    }
    /*constructores*/
    constructor()
    constructor(
        titulo: String?,
        tuplas: ArrayList<Tupla>,
        items: ArrayList<String>,
        valores: ArrayList<Double>
    ) {
        this.titulo = titulo
        this.tuplas = tuplas
        this.items = items
        this.valores = valores
    }
    /*funciones de ayuda, verificando elementos faltantes*/
    fun controTitle(): Boolean{
        contadorDeProduciones++
        return this.titulo == null
    }
    fun controValores(): Boolean{
        contadorDeProduciones++
        return this.titulo == null
    }
    fun controItems(): Boolean{
        contadorDeProduciones++
        return this.titulo == null
    }
    fun controTuplas(): Boolean{

        contadorDeProduciones++
        return this.titulo == null
    }
    fun controExtra(): Boolean{
        contadorDeProduciones++
        return this.titulo == null
    }
    fun controlTotal(): Boolean{
        contadorDeProduciones++
        return hayCantidad && total == null
    }
    fun controlTipo(): Boolean{
        contadorDeProduciones++
        return yaTipo
    }
    fun veriricaionElementosBarra(): Boolean{
        return contadorDeProduciones == 4;
    }
    fun veriricaionElementosPie(): Boolean{
        if(contadorDeProduciones == 7 && hayCantidad)
            return true
        else if (contadorDeProduciones == 6 && !hayCantidad)
            return true;
        else
            return false
    }

    /**
     * convirte esta misma grafica a barra o pie
     */
    fun convertGrafica(esBarra:Boolean): Grafica{
        if (esBarra)
            return Barra(this.titulo,this.tuplas,this.items,this.valores)
        else
            return Pie(this.titulo,this.hayCantidad,this.total,this.extra,this.tuplas,this.items,this.valores)
    }

    fun completoBarra(): Boolean{
        return this.titulo!=null && !this.tuplas.isEmpty() && !this.items.isEmpty() && !this.valores.isEmpty()
    }




    /**
     * reinicia los valores de la grafica para capturar otras especificaciones
     */
    fun limpiarGrafica(){
        this.titulo= null
        this.ejecutar = false
        this.hayCantidad = false
        this.total= null
        this.extra= null
        this.tuplas  = arrayListOf()
        this.items  = arrayListOf()
        this.valores  = arrayListOf()
        this.contadorDeProduciones=0
        this.yaTipo = false
    }


    /**
     * une los errores sintaxicos con los errores lexicos
     */



    companion object {
        @JvmStatic
        fun unionErroresLexiconConSintacticos(lexicanError: ArrayList<ErrorTexto>, sintacError: ArrayList<ErrorTexto>){
            lexicanError.forEach(){
                sintacError.add(it)
            }
            LexerAnalyzer.erroresTextoEntrada.clear()

        }
    }

    override fun toString(): String {
        return "Grafica(titulo=$titulo, ejecutar=$ejecutar, esCantidad=$hayCantidad, total=$total, extra=$extra, tuplas=$tuplas, items=$items, valores=$valores, contadorDeProduciones=$contadorDeProduciones, yaTipo=$yaTipo)"
    }
}