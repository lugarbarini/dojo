package com.example.lgarbarini.trucodojo.cartas;

import com.example.lgarbarini.trucodojo.envido.Tanto;

/**
 * Created by lgarbarini on 31/08/2018.
 */
public abstract class Carta {

    private final String palo;
    private final int puntos;

    protected Carta(String palo, int puntos) {
        this.palo = palo;
        this.puntos = puntos;
    }

    public Tanto envido(Carta otraCarta) {
        if (this.palo.equals(otraCarta.palo)) {
            return new Tanto(20 + this.puntos + otraCarta.puntos);
        } else {
            return new Tanto(Math.max(this.puntos, otraCarta.puntos));
        }
    }

}
