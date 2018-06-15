package com.dojo.unlm.dojo

class Etiqueta(private val etiqueta: String = "") {

    override fun equals(other: Any?): Boolean {
        return (other as Etiqueta).etiqueta == this.etiqueta
    }

    override fun hashCode(): Int {
        return etiqueta.hashCode()
    }

    override fun toString(): String {
        return etiqueta
    }
}
