package io.jsoncraft.objects.validator;

import io.jsoncraft.objects.JsonObjct;

public abstract class Validator<OwnerType, T> implements JsonObjct {

    private Dependent dependent;

    public Misfit validate(T value, OwnerType owner, Object context) {
        if (dependent == null || dependent.on(owner)) {
            return validateImpl(value, owner, context);
        }

        return null;
    }

    public abstract Misfit validateImpl(T value, OwnerType owner, Object context);

    protected Misfit misfit(String message) {
        return new Misfit(getType(), message);
    }

}
