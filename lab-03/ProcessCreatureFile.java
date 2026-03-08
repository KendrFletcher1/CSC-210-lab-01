import java.io.*;
import java.util.*;

public class ProcessCreatureFile {

    public static List<Creature> readCreaturesFromFile(String filename) {
        List<Creature> creatures = new ArrayList<>();

        try {
            BufferedReader reader = new BufferedReader(new FileReader(filename));
            String line;

            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");

                String name = parts[0];
                String type = parts[1];
                int power = Integer.parseInt(parts[2]);

                Creature creature = new Creature(name, type, power);
                creatures.add(creature);
            }

            reader.close();

        } catch (IOException e) {
            System.out.println("Error reading file.");
        }

        return creatures;
    }
}