public class FreezeAbility extends Ability {

    public FreezeAbility(String name, int cooldown, Type type) {
        super(name, cooldown, type);
    }

    @Override
    protected void applyEffect(Pokemon user, Pokemon target) {
        target.addEffect(new FreezeEffect(3));
        System.out.println(user.getName() + " congelou o inimigo!");
    }
}