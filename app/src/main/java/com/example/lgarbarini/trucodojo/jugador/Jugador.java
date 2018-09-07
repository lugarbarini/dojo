package com.example.lgarbarini.trucodojo.jugador;

import com.example.lgarbarini.trucodojo.cartas.Carta;
import com.example.lgarbarini.trucodojo.mano.Mano;

import java.util.Arrays;
import java.util.List;

/**
 * Created by lgarbarini on 31/08/2018.
 */
public class Jugador {

    private final String name;
    private final List<Carta> cartas;


    public Jugador(Carta carta1, Carta carta2, Carta carta3) {
        this.name = getClass().getSimpleName();
        cartas = Arrays.asList(carta1, carta2, carta3);
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
