package com.example.lgarbarini.trucodojo.cartas;

import com.example.lgarbarini.trucodojo.envido.Tanto;

/**
 * Created by lgarbarini on 07/09/2018.
 */
public class Espada extends Carta {

    protected Espada(int puntos) {
        super(puntos);
    }

    @Override
    public Tanto envido(Carta otraCarta) {
        return otraCarta.sumarTanto(this);
    }

    @Override
    protected Tanto sumarTanto(Espada cartaDeEspada) {
        return new Tanto(20 + cartaDeEspada.puntos + this.puntos);
    }
}
