package com.dojo.unlm.dojo

/**
 * Created by lgarbarini on 01/06/2018.
 */
open class Aula(protected val etiqueta: Etiqueta, protected val capacidad: Capacidad) {

    fun etiqueta(): Etiqueta {
        return etiqueta
    }

    fun conCapacidad(capacidadSolicitada: Capacidad, otraAula: Aula) : Aula {
        return if (this.capacidad.tieneCapacidad(capacidadSolicitada)) this else otraAula
    }
}