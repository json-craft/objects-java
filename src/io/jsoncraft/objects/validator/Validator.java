package io.jsoncraft.objects.validator;

public abstract class Validator<OwnerType, T> {

    public abstract Misfit validate(T value, OwnerType owner, Object context);

    protected Misfit misfit(String message) {
        return new Misfit(getClass().getSimpleName(), message);
    }

}
