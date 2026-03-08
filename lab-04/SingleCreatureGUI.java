import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class SingleCreatureGUI {

    private Creature creature;
    private JTextArea outputArea;
    private JTextField nameField;
    private JTextField typeField;
    private JTextField powerField;

    public SingleCreatureGUI() {

        creature = new Creature("Dragon", "Fire", 100);

        JFrame frame = new JFrame("Single Creature GUI");
        frame.setSize(600,300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());

        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new GridLayout(3,2));

        inputPanel.add(new JLabel("Name:"));
        nameField = new JTextField(creature.getName());
        inputPanel.add(nameField);

        inputPanel.add(new JLabel("Type:"));
        typeField = new JTextField(creature.getType());
        inputPanel.add(typeField);

        inputPanel.add(new JLabel("Power:"));
        powerField = new JTextField(String.valueOf(creature.getPower()));
        inputPanel.add(powerField);

        frame.add(inputPanel, BorderLayout.CENTER);

        outputArea = new JTextArea();
        outputArea.setText(creature.toString());
        frame.add(outputArea, BorderLayout.EAST);

        JButton saveButton = new JButton("Save");

        saveButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                creature = new Creature(
                    nameField.getText(),
                    typeField.getText(),
                    Integer.parseInt(powerField.getText())
                );

                outputArea.setText(creature.toString());
            }
        });

        frame.add(saveButton, BorderLayout.SOUTH);

        frame.setVisible(true);
    }

    public static void main(String[] args) {
        new SingleCreatureGUI();
    }
}