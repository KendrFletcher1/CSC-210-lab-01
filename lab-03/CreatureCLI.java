import java.util.*;

public class CreatureCLI {

    public static void main(String[] args) {

        List<Creature> creatures = ProcessCreatureFile.readCreaturesFromFile("creature-data.csv");

        CreatureRegistry registry = new CreatureRegistry();

        registry.addCreatures(creatures);

        registry.displayCreatures();
    }
}
