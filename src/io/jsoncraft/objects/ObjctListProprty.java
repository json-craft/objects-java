package io.jsoncraft.objects;

import java.util.List;

public class ObjctListProprty<OwnerType, T> extends Proprty<OwnerType, List> {

    private Objct<T> objct;

    public ObjctListProprty(Objct<OwnerType> owner, String name, Objct<T> objct) {
        super(owner, name, List.class);

        this.objct = objct;
    }

    public Objct<T> getObjct() {
        return objct;
    }
}
