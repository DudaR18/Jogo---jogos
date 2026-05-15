public enum Type {
    FIRE,
    WATER,
    GRASS;

    public double getMultiplier(Type target) {
        if (this == FIRE && target == GRASS) return 1.5;
        if (this == WATER && target == FIRE) return 1.5;
        if (this == GRASS && target == WATER) return 1.5;

        return 1.0;
    }
}