package com.mercadolibre.dojos;

/**
 * Created by dsanchez on 11/10/17.
 */
public class NoneInconsitencia extends Inconsistency {

    public NoneInconsitencia(CheckoutOptions checkoutOptions) {
        super(checkoutOptions);
    }

    public Inconsistency happens() {
        return this;
    }

    @Override
    public Inconsistency challenge(Inconsistency other) {
        return other;
    }

    @Override
    public int getNumber() {
        return IInconsistency.NONE;
    }

}
