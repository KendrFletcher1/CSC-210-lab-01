import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.List;

public class CreaturesFromFileGUI {

    private JTextArea outputArea;
    private List<Creature> creatures;

    public CreaturesFromFileGUI() {

        creatures = ProcessCreatureFile.readCreaturesFromFile("creature-data.csv");

        JFrame frame = new JFrame("Creatures From File");
        frame.setSize(500, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());

        outputArea = new JTextArea();
        JScrollPane scrollPane = new JScrollPane(outputArea);
        frame.add(scrollPane, BorderLayout.CENTER);

        JButton loadButton = new JButton("Load Creatures");

        loadButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                outputArea.setText("");

                for (Creature c : creatures) {
                    outputArea.append(c.toString() + "\n");
                }
            }
        });

        frame.add(loadButton, BorderLayout.SOUTH);

        frame.setVisible(true);
    }

    public static void main(String[] args) {
        new CreaturesFromFileGUI();
    }
}