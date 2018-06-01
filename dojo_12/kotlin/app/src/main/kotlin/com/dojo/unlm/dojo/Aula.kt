package com.dojo.unlm.dojo

/**
 * Created by lgarbarini on 01/06/2018.
 */
interface Aula {
    fun etiqueta(): Etiqueta

    fun tieneCapacidad(capacidad: Capacidad): Boolean
}