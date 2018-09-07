package com.example.lgarbarini.trucodojo.cartas;

import com.example.lgarbarini.trucodojo.envido.Tanto;

/**
 * Created by lgarbarini on 07/09/2018.
 */
public class Copa extends Carta {

    protected Copa(int puntos) {
        super(puntos);
    }

    @Override
    public Tanto envido(Carta otraCarta) {
        return otraCarta.sumarTanto(this);
    }

    @Override
    protected Tanto sumarTanto(Copa cartaDeCopa) {
        return new Tanto(20 + cartaDeCopa.puntos + this.puntos);
    }
}
