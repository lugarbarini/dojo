package com.dojo.unlm.dojo

class AulaLabB : Aula {

    override fun tieneCapacidad(capacidad: Capacidad): Boolean {
        return this.capacidad.tieneCapacidad(capacidad)
    }

    private val capacidad = Capacidad(15)

    override fun etiqueta(): Etiqueta {
        return Etiqueta("Aula: Lab B")
    }
}
