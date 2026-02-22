import java.io.File;
import java.io.PrintWriter;
import java.util.Random;
import java.util.Scanner;

public class SlotMachine {

    private char slot1;
    private char slot2;
    private char slot3;
    private double moneyPot;

    // Constructor 1 (default)
    public SlotMachine() {
        moneyPot = 1000000.00;
    }

    // Constructor 2 (load from file)
    public SlotMachine(String filename) {
        try {
            Scanner fileScanner = new Scanner(new File(filename));
            moneyPot = fileScanner.nextDouble();
            fileScanner.close();
        } catch (Exception e) {
            moneyPot = 1000000.00;
        }
    }

    public double pullLever(double amount) {
        Random rand = new Random();
        char[] symbols = {'\u263A', '\u2764', '7'};

        slot1 = symbols[rand.nextInt(3)];
        slot2 = symbols[rand.nextInt(3)];
        slot3 = symbols[rand.nextInt(3)];

        if (slot1 == slot2 && slot2 == slot3) {
            double winnings = amount * 10;
            moneyPot -= winnings;
            return winnings;
        }

        return 0;
    }

    public String toString() {
        return "" + slot1 + " " + slot2 + " " + slot3;
    }

    public double getMoneyPot() {
        return moneyPot;
    }

    public void save(String filename) {
        try {
            PrintWriter writer = new PrintWriter(filename);
            writer.println(moneyPot);
            writer.close();
        } catch (Exception e) {
            System.out.println("Error saving file.");
        }
    }
}
