package com.example.lgarbarini.trucodojo.cartas;

import com.example.lgarbarini.trucodojo.envido.Tanto;

/**
 * Created by lgarbarini on 31/08/2018.
 */
public abstract class Carta {

    protected final int puntos;

    protected Carta(int puntos) {
        this.puntos = puntos;
    }

    public abstract Tanto envido(Carta otraCarta);

    protected Tanto sumarTanto(Basto cartaDeBasto) {
        return new Tanto(Math.max(this.puntos, cartaDeBasto.puntos));
    }

    protected Tanto sumarTanto(Espada cartaDeEspada) {
        return new Tanto(Math.max(this.puntos, cartaDeEspada.puntos));
    }

    protected Tanto sumarTanto(Oro cartaDeOro) {
        return new Tanto(Math.max(this.puntos, cartaDeOro.puntos));
    }

    protected Tanto sumarTanto(Copa cartaDeCopa) {
        return new Tanto(Math.max(this.puntos, cartaDeCopa.puntos));
    }
}
