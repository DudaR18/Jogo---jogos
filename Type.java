public enum Type {
    FIRE,
    WATER,
    GRASS;

    public double getMultiplier(Type target) {
        if (this == FIRE && target == GRASS) return 2.0;
        if (this == WATER && target == FIRE) return 2.0;
        if (this == GRASS && target == WATER) return 2.0;

        return 1.0;
    }
}