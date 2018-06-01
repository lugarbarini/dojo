package com.dojo.unlm.dojo

class Solicitud(private val aulaSolicitada: AulaLabB) {

    fun asignar(): Asignacion {
        return Asignacion(aulaSolicitada)
    }

}
