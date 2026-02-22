import java.util.Scanner;

public class GoodCasino {

    public static double play(Customer customer, SlotMachine machine, double amount) {
        double spent = customer.spend(amount);
        double winnings = machine.pullLever(spent);
        return winnings;
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        Customer customer = new Customer("customer.txt");
        SlotMachine machine = new SlotMachine("slot-machine.txt");

        while (true) {

            if (customer.checkWallet() <= 0) {
                System.out.println("Customer is out of money!");
                break;
            }

            if (machine.getMoneyPot() <= 0) {
                System.out.println("Casino is out of money!");
                break;
            }

            System.out.println("You have $" + customer.checkWallet());
            System.out.println("Enter amount to play or type -1 to quit:");

            double amount = scanner.nextDouble();

            if (amount == -1) {
                break;
            }

            double winnings = play(customer, machine, amount);

            System.out.println("Slot Result: " + machine.toString());
            System.out.println("You won: $" + winnings);

            customer.receive(winnings);
        }

        customer.save("customer.txt");
        machine.save("slot-machine.txt");

        scanner.close();
    }
}
