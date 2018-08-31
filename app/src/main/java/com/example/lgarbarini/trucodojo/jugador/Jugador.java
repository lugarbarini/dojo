package com.example.lgarbarini.trucodojo.jugador;

import com.example.lgarbarini.trucodojo.cartas.Carta;
import com.example.lgarbarini.trucodojo.mano.Mano;

/**
 * Created by lgarbarini on 31/08/2018.
 */
public class Jugador {

    private final String name;

    public Jugador() {
        this.name = getClass().getSimpleName();
    }

    public Jugador(Carta carta1, Carta carta2, Carta carta3) {
        this();
    }

    @Override
    public boolean equals(Object obj) {
        return ((Jugador) obj).name.equals(name);
    }

    public Mano envido(Mano mano) {
        return mano;
    }

    public Mano quiero(Mano mano) {
        return mano;
    }

    public Mano diceSuEnvido(Mano mano) {
        return mano;
    }
}
