package com.dojo.unlm

import com.dojo.unlm.dojo.AulaLabB
import com.dojo.unlm.dojo.Etiqueta
import com.dojo.unlm.dojo.Solicitud
import org.jetbrains.spek.api.Spek
import org.jetbrains.spek.api.dsl.given
import org.jetbrains.spek.api.dsl.it
import org.jetbrains.spek.api.dsl.on
import kotlin.test.assertEquals

/**
 * Tests for the dojo.
 */
class DojoTest : Spek({

    given("") {
        on("") {
            it("Dada una solicitud debe devolverse un aula y una etiqueta que indique que el " +
                    "aula fue asignada"){

                val solicitud = Solicitud(AulaLabB())

                val asignacion = solicitud.asignar()

                assertEquals(Etiqueta("Aula: Lab B"), asignacion.etiqueta())
            }
        }
    }

})