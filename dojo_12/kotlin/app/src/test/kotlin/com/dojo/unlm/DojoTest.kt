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
            val aulaB = AulaLabB()
            val aulaA = AulaLabA()
            
            it("Dada una solicitud debe devolverse un aula y una etiqueta que indique que el " +
                    "aula fue asignada"){

                val solicitud = Solicitud(AulaLabB())

                val asignacion = solicitud.asignar()

                assertEquals(Etiqueta("Aula: Lab B"), asignacion.etiqueta())
            }

            it("Dado un conjunto de Aulas disponibles, se solicita una de ellas con capacidad para al menos 10 personas") {
                val aulasDisponibles = listOf(aulaA, aulaB)
               // val aulasDisponibles = listOf(aulaA, aulaB, Aula(Etiqueta(), Capacidad(50)), Aula(Etiqueta(), Capacidad(2)))
                val solicitud = SolicitudConCapacidad(aulasDisponibles, Capacidad(10))

                val asignacion = solicitud.asignar()

                assertEquals(Etiqueta("Aula: Lab B"), asignacion.etiqueta())
            }

            it("Dado el mismo listado, se solicita un aula para 30 personas. Se espera como " +
                    "respuesta: “No hay aula disponible”") {
               // val aulasDisponibles = listOf(aulaA, aulaB, Aula(Etiqueta(), Capacidad(50)), Aula(Etiqueta(), Capacidad(2)))
                val aulasDisponibles = listOf(aulaA, aulaB)
                val solicitud = SolicitudConCapacidad(aulasDisponibles, Capacidad(30))

                val asignacion = solicitud.asignar()

                assertEquals(Etiqueta("No hay aula disponible"), asignacion.etiqueta())
            }

            it("La gente de arquitectura necesita además de capacidad en el aula, que la misma cumpla con cierta cantidad de metros cuadrados para poder exponer sus maquetas") {

            }
        }
    }

})