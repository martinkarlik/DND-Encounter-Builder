package src.MartinAndVictorMP;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.util.ArrayList;

public class MonsterGUI extends JFrame {

    private JLabel
            STR = new JLabel("STR"),
            DEX = new JLabel("DEX"),
            CON = new JLabel("CON"),
            INT = new JLabel("INT"),
            WIS = new JLabel("WIS"),
            CHA = new JLabel("CHA");

    private Font font = new Font("Arial", Font.BOLD, 26);
    private Font fontSmall = new Font("Arial", Font.PLAIN, 16);

    /**
     * @param numberOfMonsters
     * @param name
     * @param description
     * @param generalInfo
     * @param attributes
     * @param savingThrows
     * @param otherInfo
     * @param monsterActions
     * @param accuracy
     * @throws IOException
     */
    public MonsterGUI(int numberOfMonsters, String name, String description, String[] generalInfo, String[] attributes, ArrayList<String> savingThrows, ArrayList<String> otherInfo, ArrayList<String> monsterActions, float accuracy) throws IOException {

        // all the JLabels
        JLabel nameL, desctiptionL, generalInfoL, attributesL, savingThrowsL, otherInfoL, actionsL;

        JFrame frame = new JFrame("Monster encounter");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        frame.getContentPane().add(panel);

        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        setContentPane(new JLabel(new ImageIcon("/Users/victorbuch/Documents/GitHub/TheOne/src/Images/Image.png")));

        panel.add(nameL = new JLabel(name + " x " + numberOfMonsters));
        nameL.setFont(font);
        nameL.setForeground(Color.RED);
        panel.add(desctiptionL = new JLabel(description));
        desctiptionL.setFont(fontSmall);

        // Adding the red arrow to split the UI
        panel.add(new JLabel(new ImageIcon("/Users/victorbuch/Documents/GitHub/TheOne/src/Images/Split.png")));


        for (int i = 0; i < generalInfo.length; i++) {
            panel.add(generalInfoL = new JLabel(generalInfo[i])).setForeground(Color.RED);
            generalInfoL.setFont(fontSmall);
        }

        panel.add(new JLabel(new ImageIcon("/Users/victorbuch/Documents/GitHub/TheOne/src/Images/Split.png")));

        for (int i = 0; i < attributes.length; i++) {
            panel.add(attributesL = new JLabel(attributes[i]));
            attributesL.setFont(fontSmall);
            attributesL.setForeground(Color.RED);
        }

        panel.add(new JLabel(new ImageIcon("/Users/victorbuch/Documents/GitHub/TheOne/src/Images/Split.png")));

        for (String e: savingThrows) {
                panel.add(savingThrowsL = new JLabel("Saving throw " + e));
                savingThrowsL.setFont(fontSmall);
                savingThrowsL.setForeground(Color.RED);
        }

        panel.add(new JLabel(new ImageIcon("/Users/victorbuch/Documents/GitHub/TheOne/src/Images/Split.png")));

        for (String e: otherInfo) {
                panel.add(otherInfoL = new JLabel(e));
                otherInfoL.setFont(fontSmall);
        }

        panel.add(new JLabel(new ImageIcon("/Users/victorbuch/Documents/GitHub/TheOne/src/Images/Split.png")));

        for (String e: monsterActions) {
            panel.add(actionsL = new JLabel(e));
            actionsL.setFont(fontSmall);
        }
        frame.pack();
        frame.setVisible(true);


    }


}
