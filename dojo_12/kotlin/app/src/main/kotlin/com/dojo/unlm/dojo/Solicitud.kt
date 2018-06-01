package com.dojo.unlm.dojo

class Solicitud(val aulaSolicitada: Aula) {

    fun asignar(): Asignacion {
        return Asignacion(aulaSolicitada)
    }

}
