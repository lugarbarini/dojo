package com.dojo.unlm.dojo

class SolicitudConCapacidad(private val aulasDisponibles: List<Aula>, private val
capacidadSolicitada: Capacidad) {

    fun asignar(): Asignacion {
        val aulaElegida = aulasDisponibles.reduce{ noAula, aula -> aula.conCapacidad(capacidadSolicitada, NoAula())}
        return Asignacion(aulaElegida)
    }


}
