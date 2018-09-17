package io.jsoncraft.objects;

public interface JsonObjct {

    default String getType() {
        return getClass().getSimpleName();
    }

}
