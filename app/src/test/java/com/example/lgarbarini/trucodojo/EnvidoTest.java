package com.example.lgarbarini.trucodojo;

import com.example.lgarbarini.trucodojo.apuesta.Envido;
import com.example.lgarbarini.trucodojo.cartas.AnchoDeBasto;
import com.example.lgarbarini.trucodojo.cartas.AnchoDeEspadas;
import com.example.lgarbarini.trucodojo.cartas.DiezDeBasto;
import com.example.lgarbarini.trucodojo.cartas.DiezDeCopas;
import com.example.lgarbarini.trucodojo.cartas.DosDeCopas;
import com.example.lgarbarini.trucodojo.cartas.SieteDeBasto;
import com.example.lgarbarini.trucodojo.cartas.TresDeCopas;
import com.example.lgarbarini.trucodojo.envido.Tanto;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by lgarbarini on 07/09/2018.
 */
public class EnvidoTest {

    @Test
    public void envido_devuelve_21() {
        Envido envido = new Envido(new AnchoDeBasto(), new DiezDeBasto(), new DiezDeCopas());

        assertEquals(new Tanto(21), envido.tanto());
    }

    @Test
    public void envido_devuelve_25() {
        Envido envido = new Envido(new DosDeCopas(), new TresDeCopas(), new AnchoDeEspadas());

        assertEquals(new Tanto(25), envido.tanto());
    }

    @Test
    public void envido_devuelve_28() {
        Envido envido = new Envido(new AnchoDeBasto(), new SieteDeBasto(), new DiezDeCopas());

        assertEquals(new Tanto(28), envido.tanto());
    }

    @Test
    public void envido_devuelve_carta_unica() {
        Envido envido = new Envido(new AnchoDeBasto(), new AnchoDeEspadas(), new DosDeCopas());

        assertEquals(new Tanto(2), envido.tanto());
    }

}
