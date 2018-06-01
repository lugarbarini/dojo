package com.dojo.unlm.dojo

class AulaLabA : Aula {
    private val capacidad = Capacidad(5)

    override fun etiqueta() : Etiqueta {
        return Etiqueta("Aula: Lab A")
    }

    override fun tieneCapacidad(capacidad: Capacidad): Boolean {
        return this.capacidad.tieneCapacidad(capacidad)
    }
}
