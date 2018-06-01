package com.dojo.unlm.dojo

class NoAula : Aula {

    override fun tieneCapacidad(capacidad: Capacidad): Boolean {
        return true
    }

    override fun etiqueta(): Etiqueta {
        return Etiqueta("No hay aula disponible")
    }

}
