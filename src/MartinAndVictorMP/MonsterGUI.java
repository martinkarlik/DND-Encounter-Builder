package src.MartinAndVictorMP;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.util.ArrayList;

public class MonsterGUI extends JFrame {
    private JLabel monsterName, type, allignment, ac, hp, speed, strength, dexterity,
            constitution, intelligence, wisdom, charisma, skills, senses, languages, challeng, actions;

    private JLabel
            STR = new JLabel("STR"),
            DEX = new JLabel("DEX"),
            CON = new JLabel("CON"),
            INT = new JLabel("INT"),
            WIS = new JLabel("WIS"),
            CHA = new JLabel("CHA");

    public MonsterGUI(String name, String description, String[] generalInfo, String[] attributes, String[] otherInfo, ArrayList<String> monsterActions) throws IOException {

        JFrame jFrame = new JFrame();
        jFrame.getContentPane().add(new JPanelWithBackground("Image.png"));

        // Sets the color of the Text
        monsterName.setForeground(Color.RED);
        ac.setForeground(Color.RED);
        hp.setForeground(Color.RED);
        speed.setForeground(Color.RED);
        strength.setForeground(Color.RED);
        dexterity.setForeground(Color.RED);
        constitution.setForeground(Color.RED);
        intelligence.setForeground(Color.RED);
        wisdom.setForeground(Color.RED);
        charisma.setForeground(Color.RED);
        skills.setForeground(Color.RED);
        languages.setForeground(Color.RED);
        challeng.setForeground(Color.RED);
        actions.setForeground(Color.RED);

        setTitle("Monster Encounter");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);


        layout.setAutoCreateContainerGaps(true);
        layout.setAutoCreateGaps(true);

        pack();
        setVisible(true);

    }


}
