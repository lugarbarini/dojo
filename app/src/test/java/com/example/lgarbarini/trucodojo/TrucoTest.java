package com.example.lgarbarini.trucodojo;

import com.example.lgarbarini.trucodojo.apuesta.Envido;
import com.example.lgarbarini.trucodojo.apuesta.SinApuesta;
import com.example.lgarbarini.trucodojo.cartas.AnchoDeBasto;
import com.example.lgarbarini.trucodojo.cartas.AnchoDeEspadas;
import com.example.lgarbarini.trucodojo.cartas.DiezDeBasto;
import com.example.lgarbarini.trucodojo.cartas.DiezDeCopas;
import com.example.lgarbarini.trucodojo.cartas.DosDeCopas;
import com.example.lgarbarini.trucodojo.cartas.TresDeCopas;
import com.example.lgarbarini.trucodojo.jugador.Cris;
import com.example.lgarbarini.trucodojo.jugador.Nelson;
import com.example.lgarbarini.trucodojo.mano.Mano;
import com.example.lgarbarini.trucodojo.mano.Puntos;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TrucoTest {

    @Test
    public void envido_querido_gana_el_que_dice_quiero() {
        Nelson nelson = new Nelson(new AnchoDeBasto(), new DiezDeBasto(), new DiezDeCopas());
        Cris cris = new Cris(new DosDeCopas(), new TresDeCopas(), new AnchoDeEspadas());

        Mano mano = new Mano();

        mano = nelson.envido(mano);
        mano = cris.quiero(mano);

        mano = nelson.diceSuEnvido(mano);
        mano = cris.diceSuEnvido(mano);

        assertEquals(new Puntos(cris, new Envido()), mano.puntos(cris));
        assertEquals(new Puntos(nelson, new SinApuesta()), mano.puntos(nelson));
    }
}