public interface StatusEffect {
    void apply(Pokemon target);
    boolean isExpired();
    String getName();
}