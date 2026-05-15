import java.util.*;

public class Pokemon {

    private String name;
    private int hp;
    private Type type;
    private List<Ability> abilities;
    private List<StatusEffect> effects = new ArrayList<>();

    public Pokemon(String name, int hp, Type type, List<Ability> abilities) {
        this.name = name;
        this.hp = hp;
        this.type = type;
        this.abilities = abilities;
    }

    public void receiveDamage(int damage) {
        hp -= damage;
        if (hp < 0) hp = 0;
    }

    public void addEffect(StatusEffect effect) {
        effects.add(effect);
        System.out.println(name + " recebeu efeito: " + effect.getName());
    }

    public void updateEffects() {
        Iterator<StatusEffect> it = effects.iterator();

        while (it.hasNext()) {
            StatusEffect effect = it.next();
            effect.apply(this);

            if (effect.isExpired()) {
                System.out.println(effect.getName() + " acabou!");
                it.remove();
            }
        }
    }

    public boolean isFrozen() {
        return effects.stream().anyMatch(e -> e instanceof FreezeEffect);
    }

    public boolean isAlive() {
        return hp > 0;
    }

    public void showStatus() {
        System.out.println(name + " HP: " + hp);
    }

    public String getName() {
        return name;
    }

    public Type getType() {
        return type;
    }

    public List<Ability> getAbilities() {
        return abilities;
    }
}