package com.dojo.unlm.dojo

class SolicitudConCapacidad(private val aulasDisponibles: List<Aula>, private val
capacidadSolicitada: Capacidad) {

    fun asignar(): Asignacion {
        val aulaElegida = aulasDisponibles.find { aula -> aula.tieneCapacidad(capacidadSolicitada) }

        return Asignacion(aulaElegida ?: NoAula())
    }


}
