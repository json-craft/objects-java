package io.jsoncraft.objects.accessor;

public interface IAccessor<OwnerType, T> {

    T get(OwnerType owner);
    void set(OwnerType owner, T value);

}
