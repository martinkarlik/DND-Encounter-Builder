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

    private LinePanel line;
    //private BackgroundPanel background;

    public MonsterGUI(int numberOfMonsters, String name, String description, String[] generalInfo, String[] attributes, ArrayList<String> savingThrows, ArrayList<String> otherInfo, ArrayList<String> monsterActions, float accuracy) throws IOException {

        JFrame frame = new JFrame("Monster encounter");
        setTitle("Monster Encounter");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        frame.getContentPane().add(panel);

        //setContentPane(new JLabel(new ImageIcon("src/Images/image.png")));
        panel.add(new JLabel(new ImageIcon("src/Images/image.png")));

        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        panel.add(new JLabel(name)).setForeground(Color.RED);
        panel.add(new JLabel(description));

        line = new LinePanel();
        panel.add(line);


        for (int i = 0; i < generalInfo.length; i++) {
            panel.add(new JLabel(generalInfo[i]));
        }
        panel.add(new JLabel(""));

        for (int i = 0; i < attributes.length; i++) {
            panel.add(new JLabel(attributes[i]));
        }
        panel.add(new JLabel(""));

        for (String e: savingThrows) {
            panel.add(new JLabel(e));
        }
        panel.add(new JLabel(""));

        for (String e: otherInfo) {
            panel.add(new JLabel(e));
        }
        panel.add(new JLabel(""));

        for (String e: monsterActions) {
            panel.add(new JLabel(e));
        }

        //setSize(400,400);

        frame.pack();
        frame.setVisible(true);


        //setContentPane(new JLabel(new ImageIcon("../Images/Image.png")));
        //setSize(399,399);
        //setSize(400,400);


    }


}
