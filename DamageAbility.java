public class DamageAbility extends Ability {

    private int damage;

    public DamageAbility(String name, int damage, int cooldown, Type type) {
        super(name, cooldown, type);
        this.damage = damage;
    }

    @Override
    protected void applyEffect(Pokemon user, Pokemon target) {
        double multiplier = type.getMultiplier(target.getType());
        int finalDamage = (int) (damage * multiplier);

        target.receiveDamage(finalDamage);

        System.out.println(user.getName() + " usou " + name +
                " causando " + finalDamage + " de dano!");
    }
}