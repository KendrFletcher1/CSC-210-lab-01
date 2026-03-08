import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;

public class HelloGUI {

    public static void main(String[] args) {

        JFrame frame = new JFrame("Hello GUI");
        frame.setSize(300, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new FlowLayout());

        JLabel label = new JLabel("");

        JButton button = new JButton("Greet");

        String[] greetings = {
            "Hello!",
            "Hi there!",
            "Greetings!",
            "Welcome!",
            "Good to see you!"
        };

        Random rand = new Random();

        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int index = rand.nextInt(greetings.length);
                label.setText(greetings[index]);
            }
        });

        frame.add(label);
        frame.add(button);

        frame.setVisible(true);
    }
}