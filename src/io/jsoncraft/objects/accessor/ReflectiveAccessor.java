package io.jsoncraft.objects.accessor;

public class ReflectiveAccessor<OwnerType, T> implements IReflectiveAccessor<OwnerType, T> {

    private final String name;
    private final Class<T> cls;

    public ReflectiveAccessor(String name, Class<T> cls) {
        this.name = name;
        this.cls = cls;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public Class<T> getCls() {
        return cls;
    }

}
