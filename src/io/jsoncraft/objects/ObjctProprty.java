package io.jsoncraft.objects;

public class ObjctProprty<OwnerType, T> extends Proprty<OwnerType, T> {

    public Objct<T> objct;

    public ObjctProprty(Objct<OwnerType> owner, String name, Objct<T> objct) {
        super(owner, name, objct.getCls());

        this.objct = objct;
    }

    public Objct<T> getObjct() {
        return objct;
    }
}
