package com.example.lgarbarini.trucodojo.apuesta;

import com.example.lgarbarini.trucodojo.cartas.Carta;
import com.example.lgarbarini.trucodojo.envido.Tanto;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by lgarbarini on 31/08/2018.
 */
public class Envido extends Apuesta {

    private final List<Carta> cartas;

    public Envido() {
        cartas = new ArrayList<>();
    }

    public Envido(Carta carta1, Carta carta2, Carta carta3) {
        super();
        cartas = Arrays.asList(carta1, carta2, carta3);
    }


    public Tanto tanto() {
        Tanto tanto1 = cartas.get(0).envido(cartas.get(1));
        Tanto tanto2 = cartas.get(1).envido(cartas.get(2));
        Tanto tanto3 = cartas.get(2).envido(cartas.get(0));

        return tanto1.contra(tanto2).contra(tanto3);
    }


}
