package com.dojo.unlm.dojo

class MetrosCuadrados(val metrosCuadrados: Int) {

    fun tieneLugar(metrosSolicitados: MetrosCuadrados, siTiene: Any, siNoTiene: Any) : Any {
        return if (this.metrosCuadrados >= metrosSolicitados.metrosCuadrados) siTiene else siNoTiene
    }

    fun tieneLugar(metrosSolicitados: MetrosCuadrados) : Boolean {
        return this.metrosCuadrados >= metrosSolicitados.metrosCuadrados
    }
}
