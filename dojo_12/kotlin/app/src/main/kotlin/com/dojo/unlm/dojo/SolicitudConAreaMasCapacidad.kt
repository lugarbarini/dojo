package com.dojo.unlm.dojo

class SolicitudConAreaMasCapacidad(val aulasDisponibles: List<Aula>, val capacidadSolicitada: Capacidad, val metrosCuadradosSolicitados: MetrosCuadrados) {


    fun asignar(): Asignacion {
        val aulaElegida = aulasDisponibles.reduce{ noAula, aula -> aula.conCapacidad(capacidadSolicitada, metrosCuadradosSolicitados, noAula)}
        return Asignacion(aulaElegida)
    }

}
