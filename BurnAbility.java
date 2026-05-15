public class BurnAbility extends Ability {

    public BurnAbility(String name, int cooldown, Type type) {
        super(name, cooldown, type);
    }

    @Override
    protected void applyEffect(Pokemon user, Pokemon target) {
        target.addEffect(new BurnEffect(4, 2));
        System.out.println(user.getName() + " aplicou burn!");
    }
}