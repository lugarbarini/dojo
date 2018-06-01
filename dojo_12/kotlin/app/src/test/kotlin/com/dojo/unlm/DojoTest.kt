package com.dojo.unlm

import com.dojo.unlm.dojo.*
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

            it("Dado un conjunto de Aulas disponibles, se solicita una de ellas con capacidad para al menos 10 personas") {
                val aulaB = AulaLabB()
                val aulaA = AulaLabA()
                val aulasDisponibles = listOf(aulaA, aulaB)
                val solicitud = SolicitudConCapacidad(aulasDisponibles, Capacidad(10))

                val asignacion = solicitud.asignar()

                assertEquals(Etiqueta("Aula: Lab B"), asignacion.etiqueta())
            }

            it("Dado el mismo listado, se solicita un aula para 30 personas. Se espera como " +
                    "respuesta: “No hay aula disponible”") {
                val aulaB = AulaLabB()
                val aulaA = AulaLabA()
                val aulasDisponibles = listOf(aulaA, aulaB)
                val solicitud = SolicitudConCapacidad(aulasDisponibles, Capacidad(30))

                val asignacion = solicitud.asignar()

                assertEquals(Etiqueta("No hay aula disponible"), asignacion.etiqueta())
            }
        }
    }

})