import java.util.*;

public class CreatureRegistry {

    private List<Creature> creatures;

    public CreatureRegistry() {
        creatures = new ArrayList<>();
    }

    public void addCreature(Creature creature) {
        creatures.add(creature);
    }

    public void addCreatures(List<Creature> newCreatures) {
        creatures.addAll(newCreatures);
    }

    public void displayCreatures() {
        for (Creature c : creatures) {
            System.out.println(c);
        }
    }
}
