package io.jsoncraft.objects.accessor;

import java.lang.reflect.Method;

public interface IReflectiveAccessor<OwnerType, T> extends IAccessor<OwnerType, T> {

    String getName();

    Class<T> getCls();

    default String getGetterName() {
        Class<T> clazz = getCls();

        String verb = "get";

        if (clazz.isAssignableFrom(Boolean.class) || clazz.isAssignableFrom(boolean.class)) {
            verb = "is";
        }

        return verb + getName().substring(0, 1).toUpperCase() + getName().substring(1);
    }

    default String getSetterName() {
        return "set" + getName().substring(0, 1).toUpperCase() + getName().substring(1);
    }

    default Method getGetter(OwnerType owner) {
        try {
            return owner.getClass().getMethod(getGetterName());
        } catch (NoSuchMethodException e) {
            throw new RuntimeException(e);
        }
    }

    default Method getSetter(OwnerType owner) {
        try {
            return owner.getClass().getMethod(getSetterName(), getCls());
        } catch (NoSuchMethodException e) {
            throw new RuntimeException(e);
        }
    }

    @SuppressWarnings("unchecked")
    default T get(OwnerType owner) {
        if (owner == null) {
            return null;
        }

        Method getter = getGetter(owner);

        try {
            return (T) getter.invoke(owner);
        } catch (Exception e) {
            throw new RuntimeException("Getting value failed: " + owner.getClass().getName() + "." + getter.getName() + "()", e);
        }
    }

    default void set(OwnerType owner, T value) {
        if (owner == null) {
            return ;
        }

        if (getCls().isPrimitive() && value == null) {
            return ;
        }

        Method setter = getSetter(owner);

        try {
            setter.invoke(owner, value);
        } catch (Exception e) {
            throw new RuntimeException("Setting value failed: " + owner.getClass().getName() + "." + setter.getName() + "(" + getCls().getName() + ")", e);
        }
    }

}
