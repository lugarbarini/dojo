package com.dojo.unlm

/**
 * Created by lgarbarini on 15/06/2018.
 */
class Zombie(nombre: String) : Persona(nombre) {

    override fun fusionar(otra: Persona): Persona {
       return Zombie(otra.nombre + " " + nombre)
    }

    override fun fusionWith(otra: Persona): Persona {
        return Zombie(nombre + " " + otra.nombre)
    }

    override fun toString(): String {
        return super.toString() + " (zombie)"
    }
}