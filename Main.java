import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random rand = new Random();

        // Habilidades jogador
        Ability chamas = new DamageAbility("Chamas", 20, 2, Type.FIRE);
        Ability burn = new BurnAbility("Brasas", 5, Type.FIRE);
        Ability arranhar = new DamageAbility("Arranhar", 10, 1, Type.FIRE);

        // Habilidades inimigo
        Ability jato = new DamageAbility("Jato de Água", 20, 2, Type.WATER);
        Ability freeze = new FreezeAbility("Chuva Fria", 5, Type.WATER);
        Ability mordida = new DamageAbility("Mordida", 15, 3, Type.WATER);

        Pokemon pyron = new Pokemon("Pyron", 100, Type.FIRE,
                Arrays.asList(chamas, burn, arranhar));

        Pokemon aquary = new Pokemon("Aquary", 110, Type.WATER,
                Arrays.asList(jato, freeze, mordida));

        System.out.println("=== BATALHA EM TEMPO REAL ===");

        while (pyron.isAlive() && aquary.isAlive()) {

            // Atualiza efeitos
            pyron.updateEffects();
            aquary.updateEffects();

            System.out.println("\n--- STATUS ---");
            pyron.showStatus();
            aquary.showStatus();

            System.out.println("\nHabilidades:");
            for (int i = 0; i < pyron.getAbilities().size(); i++) {
                Ability a = pyron.getAbilities().get(i);
                System.out.println(i + " - " + a.getName() +
                        (a.isReady() ? " (PRONTO)" : " (COOLDOWN)"));
            }

            // Jogador
            if (!pyron.isFrozen() && sc.hasNextInt()) {
                int escolha = sc.nextInt();

                if (escolha >= 0 && escolha < pyron.getAbilities().size()) {
                    Ability habilidade = pyron.getAbilities().get(escolha);

                    if (habilidade.isReady()) {
                        habilidade.use(pyron, aquary);
                    }
                }
            } else if (pyron.isFrozen()) {
                System.out.println("Você está congelado!");
            }

            // Inimigo
            if (!aquary.isFrozen()) {
                for (Ability a : aquary.getAbilities()) {
                    if (a.isReady()) {
                        a.use(aquary, pyron);
                        break;
                    }
                }
            }

            try {
                Thread.sleep(1000);
            } catch (Exception e) {}
        }

        System.out.println("\n=== FIM ===");
        System.out.println(pyron.isAlive() ? "Você venceu!" : "Você perdeu!");

        sc.close();
    }
}