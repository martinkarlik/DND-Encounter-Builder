package src.MartinAndVictorMP;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
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

    public MonsterGUI(String name, String description, String[] generalInfo, String[] attributes, ArrayList<String> otherInfo, ArrayList<String> monsterActions) throws IOException {

        JFrame frame = new JFrame("Monster encounter");

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

        setSize(400,400);
        setVisible(true);

        setContentPane(new JLabel(new ImageIcon("/Users/victorbuch/Documents/GitHub/TheOne/src/Images/Image.png")));
        setSize(399,399);
        setSize(400,400);

    }


}
