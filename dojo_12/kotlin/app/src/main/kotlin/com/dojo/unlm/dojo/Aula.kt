package com.dojo.unlm.dojo

/**
 * Created by lgarbarini on 01/06/2018.
 */
open class Aula(protected val etiqueta: Etiqueta, protected val capacidad: Capacidad, protected val metrosCuadrados: MetrosCuadrados) {

    fun etiqueta(): Etiqueta {
        return etiqueta
    }

    open fun conCapacidad(capacidadSolicitada: Capacidad, otraAula: Aula) : Aula {
        return if (this.capacidad.tieneCapacidad(capacidadSolicitada)) this else otraAula
    }
    // tal vez podemos convertir esto en condiciones y evaluarlas con mis parametros
    open fun conCapacidad(capacidadSolicitada: Capacidad, metrosSolicitados: MetrosCuadrados,
                           otraAula: Aula) : Aula {
        return if (this.capacidad.tieneCapacidad(capacidadSolicitada) && metrosCuadrados.tieneLugar(metrosSolicitados)) this else otraAula
    }
}