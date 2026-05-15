public class BurnEffect implements StatusEffect {

    private int duration;
    private int damagePerSecond;
    private long lastTick;

    public BurnEffect(int duration, int damagePerSecond) {
        this.duration = duration;
        this.damagePerSecond = damagePerSecond;
        this.lastTick = System.currentTimeMillis();
    }

    @Override
    public void apply(Pokemon target) {
        long now = System.currentTimeMillis();

        if (now - lastTick >= 1000) {
            target.receiveDamage(damagePerSecond);
            duration--;
            lastTick = now;

            System.out.println(target.getName() + " sofreu " + damagePerSecond + " de dano por burn!");
        }
    }

    @Override
    public boolean isExpired() {
        return duration <= 0;
    }

    @Override
    public String getName() {
        return "Burn";
    }
}