package com.dojo.unlm

/**
 * Created by lgarbarini on 15/06/2018.
 */
open class Persona(internal val nombre: String) {

    open fun fusionar(otra : Persona) : Persona {
        return otra.fusionWith(this)
    }

    open protected fun fusionWith(otra: Persona) : Persona {
        return Persona(nombre + " " + otra.nombre)
    }

    internal fun fusionWith(otra: Zombie) : Persona {
        return Zombie(nombre + " " + otra.nombre)
    }

    override fun equals(other: Any?): Boolean {
        return other is Persona && other.javaClass == this.javaClass && other.nombre == nombre
    }

    override fun hashCode(): Int {
        return nombre.hashCode()
    }

    override fun toString(): String {
        return nombre
    }

}