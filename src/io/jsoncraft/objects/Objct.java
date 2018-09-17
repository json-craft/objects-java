package io.jsoncraft.objects;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public abstract class Objct<T> {

    private Class<T> cls;

    public Class<T> getCls() {
        return cls;
    }

    public String getName() {
        return cls.getSimpleName();
    }

    public abstract String getDisplayName();

    public T createEmptyObject() {
        try {
            return cls.newInstance();
        } catch (InstantiationException | IllegalAccessException e) {
            throw new ObjectsException(e);
        }
    }

    public List<Proprty> getProperties() {
        List<Proprty> properties = new ArrayList<>();

        for (Field field : getClass().getDeclaredFields()) {
            if (Proprty.class.isAssignableFrom(field.getType())) {
                Proprty property = null;

                try {
                    property = (Proprty) field.get(this);
                } catch (IllegalAccessException e) {
                    throw new ObjectsException(e);
                }

                if (property != null) {
                    properties.add(property);
                }
            }
        }

        return properties;
    }

    public Proprty getPropertyByName(String name) {
        for (Proprty property : getProperties()) {
            if (property.getName().equals(name)) {
                return property;
            }
        }

        return null;
    }

    public List<T> getPossibleValues(Object context) {
        return Collections.emptyList();
    }
}
