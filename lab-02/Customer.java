import java.io.File;
import java.io.PrintWriter;
import java.util.Scanner;

public class Customer {

    private double wallet;

    // Constructor 1 (default)
    public Customer() {
        wallet = 500.00;
    }

    // Constructor 2 (load from file)
    public Customer(String filename) {
        try {
            Scanner fileScanner = new Scanner(new File(filename));
            wallet = fileScanner.nextDouble();
            fileScanner.close();
        } catch (Exception e) {
            wallet = 500.00;
        }
    }

    public double spend(double amount) {
        if (amount > wallet) {
            double remaining = wallet;
            wallet = 0;
            return remaining;
        } else {
            wallet -= amount;
            return amount;
        }
    }

    public void receive(double amount) {
        wallet += amount;
    }

    public double checkWallet() {
        return wallet;
    }

    public void save(String filename) {
        try {
            PrintWriter writer = new PrintWriter(filename);
            writer.println(wallet);
            writer.close();
        } catch (Exception e) {
            System.out.println("Error saving file.");
        }
    }
}
