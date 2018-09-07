package com.example.lgarbarini.trucodojo.envido;

/**
 * Created by lgarbarini on 07/09/2018.
 */
public class Tanto {
    private final int tanto;

    public Tanto(int tanto) {
        this.tanto = tanto;
    }

    @Override
    public boolean equals(Object obj) {
        return obj instanceof Tanto && ((Tanto) obj).tanto == this.tanto;
    }

    public Tanto contra(Tanto otro) {
        return tanto >= otro.tanto ? this : otro;
    }
}
