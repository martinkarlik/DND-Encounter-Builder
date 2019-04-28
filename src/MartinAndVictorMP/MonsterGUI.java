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

    JLabel picLabel = new JLabel(new ImageIcon("/Users/victorbuch/Documents/GitHub/TheOne/src/Images/Split.png"));

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

        JFrame frame = new JFrame("Monster encounter");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        setContentPane(new JLabel(new ImageIcon("/Users/victorbuch/Documents/GitHub/TheOne/src/Images/Image.png")));

        JPanel panel = new JPanel();
        frame.getContentPane().add(panel);

        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        panel.add(new JLabel(numberOfMonsters + " X " + name)).setForeground(Color.RED);
        panel.add(new JLabel(description));

        panel.add(picLabel);


        for (int i = 0; i < generalInfo.length; i++) {
            panel.add(new JLabel(generalInfo[i])).setForeground(Color.RED);
        }

        panel.add(picLabel);

        for (int i = 0; i < attributes.length; i++) {
            panel.add(new JLabel(attributes[i]));
        }

        panel.add(picLabel);

        for (String e: savingThrows) {
            panel.add(new JLabel("Saving throw " + e));
        }

        panel.add(picLabel);

        for (String e: otherInfo) {
            panel.add(new JLabel(e));
        }

        panel.add(picLabel);

        for (String e: monsterActions) {
            panel.add(new JLabel(e));
        }
        frame.pack();
        frame.setVisible(true);


    }


}
