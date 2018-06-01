package com.dojo.unlm.dojo

class Asignacion(private val aulaSolicitada: Aula) {
    fun etiqueta(): Etiqueta {
        return aulaSolicitada.etiqueta()
    }


}
