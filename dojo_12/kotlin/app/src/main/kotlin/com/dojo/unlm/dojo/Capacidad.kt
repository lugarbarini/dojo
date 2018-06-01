package com.dojo.unlm.dojo

class Capacidad(private val capacidad: Int) {

    fun tieneCapacidad(otraCapacidad : Capacidad) : Boolean {
        return this.capacidad >= otraCapacidad.capacidad
    }
}
