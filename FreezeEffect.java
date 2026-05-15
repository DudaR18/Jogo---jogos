public class FreezeEffect implements StatusEffect {

    private long endTime;

    public FreezeEffect(int durationSeconds) {
        this.endTime = System.currentTimeMillis() + (durationSeconds * 1000);
    }

    @Override
    public void apply(Pokemon target) {
        // efeito passivo
    }

    @Override
    public boolean isExpired() {
        return System.currentTimeMillis() > endTime;
    }

    @Override
    public String getName() {
        return "Freeze";
    }
}