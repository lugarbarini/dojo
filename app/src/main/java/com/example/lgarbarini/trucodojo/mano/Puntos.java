package com.example.lgarbarini.trucodojo.mano;

import com.example.lgarbarini.trucodojo.apuesta.Apuesta;
import com.example.lgarbarini.trucodojo.jugador.Jugador;

/**
 * Created by lgarbarini on 31/08/2018.
 */
public class Puntos {
    private final Jugador jugador;
    private final Apuesta apuesta;

    public Puntos(Jugador jugador, Apuesta apuesta) {
        this.jugador = jugador;
        this.apuesta = apuesta;
    }

    @Override
    public boolean equals(Object obj) {
        Puntos other = (Puntos) obj;
        return other.jugador.equals(this.jugador) && other.apuesta.equals(this.apuesta);
    }
}
