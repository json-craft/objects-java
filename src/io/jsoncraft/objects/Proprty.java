package io.jsoncraft.objects;

import io.jsoncraft.objects.accessor.IAccessor;
import io.jsoncraft.objects.accessor.ReflectiveAccessor;
import io.jsoncraft.objects.validator.Validators;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Proprty<OwnerType, T> {

    private Objct<OwnerType> owner;
    private String name;
    private Class<T> cls;
    private boolean readOnly = false;

    private Validators<OwnerType, T> validators = new Validators<>();
    private IAccessor<OwnerType, T> accessor;

    public Proprty(Objct<OwnerType> owner, String name, Class<T> cls) {
        this.owner = owner;
        this.name = name;
        this.cls = cls;
        this.accessor = new ReflectiveAccessor<>(this.name, this.cls);
    }

    public Objct<OwnerType> getOwner() {
        return owner;
    }

    public String getName() {
        return name;
    }

    public String getQualifiedName() {
        return this.owner.getName() + "." + name;
    }

    public Class<T> getCls() {
        return cls;
    }

    public boolean isReadOnly() {
        return readOnly;
    }

    public Validators<OwnerType, T> getValidators() {
        return validators;
    }

    public IAccessor<OwnerType, T> getAccessor() {
        return accessor;
    }

    public List<T> getPossibleValues() {
        if (Enum.class.isAssignableFrom(cls)) {
            return Arrays.asList(cls.getEnumConstants());
        }

        return Collections.emptyList();
    }

    public T getFromOwner(OwnerType owner) {
        return accessor.get(owner);
    }
}
