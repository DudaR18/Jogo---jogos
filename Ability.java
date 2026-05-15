public abstract class Ability {

    protected String name;
    protected int cooldown;
    protected Type type;
    protected long lastUsedTime = 0;

    public Ability(String name, int cooldown, Type type) {
        this.name = name;
        this.cooldown = cooldown;
        this.type = type;
    }

    public boolean isReady() {
        long currentTime = System.currentTimeMillis();
        return (currentTime - lastUsedTime) >= cooldown * 1000;
    }

    public void use(Pokemon user, Pokemon target) {
        lastUsedTime = System.currentTimeMillis();
        applyEffect(user, target);
    }

    protected abstract void applyEffect(Pokemon user, Pokemon target);

    public String getName() {
        return name;
    }
}