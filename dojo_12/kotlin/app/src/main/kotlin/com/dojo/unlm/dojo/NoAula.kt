package com.dojo.unlm.dojo

class NoAula : Aula(Etiqueta("No hay aula disponible"), Capacidad(0), MetrosCuadrados(0)) {

    override fun conCapacidad(capacidadSolicitada: Capacidad, otraAula: Aula): Aula {
        return otraAula
    }

    override fun conCapacidad(capacidadSolicitada: Capacidad, metrosSolicitados: MetrosCuadrados, otraAula: Aula): Aula {
        return otraAula
    }
}
