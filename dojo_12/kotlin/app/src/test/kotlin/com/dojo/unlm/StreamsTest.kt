package com.dojo.unlm

import org.jetbrains.spek.api.Spek
import org.jetbrains.spek.api.dsl.given
import org.jetbrains.spek.api.dsl.it
import org.jetbrains.spek.api.dsl.on
import kotlin.test.assertEquals

/**
 * Created by lgarbarini on 15/06/2018.
 */
class StreamsTest : Spek({

    given("") {
        on("") {
            it("Map: transforms each individual element using a lambda") {
                val nombres = listOf("Lu", "Jola", "JuliC")
                val largos = nombres.map { nombre -> nombre.length }

                assertEquals(listOf(2, 4, 5), largos)
            }

            it("Filter: applies a lambda returning a boolean to determine which elements stay") {
                val nombres = listOf("Lu", "Jola", "JuliC")
                val nombresLargos = nombres.filter { nombre -> nombre.length >= 4 }

                assertEquals(listOf("Jola", "JuliC"), nombresLargos)
            }

            it("Reduce: computes a result using all the elements in the list. ") {
                val nombres = listOf("Lu", "Jola", "JuliC")
                val sentence = nombres.reduce { acc, nombre -> "$acc, $nombre" }

                assertEquals("Lu, Jola, JuliC", sentence)
            }

            it("Reduce: with objects") {
                val personas = listOf(Persona("Lucia"), Persona("Carolina"), Persona
                ("Garbarini"))
                val fusionada = personas.reduce { acc: Persona, persona: Persona ->
                    persona.fusionar(acc)
                }

                assertEquals( Persona("Lucia Carolina Garbarini"), fusionada)
            }

            it("Reduce: with zombies") {
                val personas = listOf(Zombie("Lucia"), Zombie("Carolina"), Zombie
                ("Garbarini"))
                val fusionada = personas.reduce { acc: Persona, persona: Persona ->
                    persona.fusionar(acc)
                }

                assertEquals(Zombie("Lucia Carolina Garbarini"), fusionada)
            }

            it("Reduce: with zombies text") {
                val personas = listOf(Zombie("Lucia"), Zombie("Carolina"), Zombie
                ("Garbarini"))
                val fusionada = personas.reduce { acc: Persona, persona: Persona ->
                    persona.fusionar(acc)
                }

                assertEquals("Lucia Carolina Garbarini (zombie)", fusionada.toString())
            }

            it("Reduce: with one zombie turns everyone into zombies text") {
                val personas = listOf(Persona("Lucia"), Zombie("Carolina"), Persona
                ("Garbarini"))
                val fusionada = personas.reduce { acc: Persona, persona: Persona ->
                    persona.fusionar(acc)
                }

                assertEquals("Lucia Carolina Garbarini (zombie)", fusionada.toString())
            }
        }
    }
})