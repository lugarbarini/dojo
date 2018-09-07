package com.example.lgarbarini.trucodojo.cartas;

import com.example.lgarbarini.trucodojo.envido.Tanto;

/**
 * Created by lgarbarini on 07/09/2018.
 */
public class Basto extends Carta {
    protected Basto(int puntos) {
        super(puntos);
    }

    @Override
    public Tanto envido(Carta otraCarta) {
        return otraCarta.sumarTanto(this);
    }

    @Override
    protected Tanto sumarTanto(Basto cartaDeBasto) {
        return new Tanto(20 + cartaDeBasto.puntos + this.puntos);
    }


}
