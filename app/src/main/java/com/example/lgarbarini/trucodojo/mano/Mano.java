package com.example.lgarbarini.trucodojo.mano;

import com.example.lgarbarini.trucodojo.apuesta.Envido;
import com.example.lgarbarini.trucodojo.apuesta.SinApuesta;
import com.example.lgarbarini.trucodojo.jugador.Cris;
import com.example.lgarbarini.trucodojo.jugador.Jugador;

/**
 * Created by lgarbarini on 31/08/2018.
 */
public class Mano {

    public Puntos puntos(Jugador jugador) {
        return  (jugador instanceof Cris) ? new Puntos(jugador, new Envido()) : new Puntos
                (jugador, new SinApuesta());
    }
}
