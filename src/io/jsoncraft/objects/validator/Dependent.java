package io.jsoncraft.objects.validator;

import io.jsoncraft.objects.JsonObjct;
import io.jsoncraft.objects.Proprty;

public class Dependent<OwnerType> implements JsonObjct {

    private Proprty property;
    private Object value;

    @SuppressWarnings("unchecked")
    public boolean on(OwnerType owner) {
        if (owner == null) {
            return false;
        }

        Object actualValue = property.getFromOwner(owner);

        if (value == actualValue) {
            return true;
        }

        if (value != null) {
            return value.equals(actualValue);
        }

        return false;
    }

}
