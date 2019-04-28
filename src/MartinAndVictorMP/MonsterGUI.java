package src.MartinAndVictorMP;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.util.ArrayList;

public class MonsterGUI extends JFrame {
    private JLabel numberOfMonstersL, monsterNameL, describtionL, acL, hpL, speedL, strengthL, dexterityL,
            constitutionL, intelligenceL, wisdomL, charismaL, savingThrowsL, otherInfoL, monsterActionsL, accuracyL;

    private JLabel
            STR = new JLabel("STR"),
            DEX = new JLabel("DEX"),
            CON = new JLabel("CON"),
            INT = new JLabel("INT"),
            WIS = new JLabel("WIS"),
            CHA = new JLabel("CHA");

    public MonsterGUI(int numberOfMonsters, String name, String description, String[] generalInfo, String[] attributes, ArrayList<String> savingThrows, ArrayList<String> otherInfo, ArrayList<String> monsterActions, float accuracy) throws IOException {

        JFrame frame = new JFrame("Monster encounter");

        numberOfMonstersL.setText(Integer.toString(numberOfMonsters));
        monsterNameL.setText(name);
        describtionL.setText(description);
        acL.setText(generalInfo[0]);
        hpL.setText(generalInfo[1]);
        speedL.setText(generalInfo[2]);
        strengthL.setText(attributes[0]);
        dexterityL.setText(attributes[1]);
        constitutionL.setText(attributes[2]);
        intelligenceL.setText(attributes[3]);
        wisdomL.setText(attributes[4]);
        charismaL.setText(attributes[5]);
        savingThrowsL.setText(savingThrows.toString());
        otherInfoL.setText(otherInfo.toString());
        monsterActionsL.setText(monsterActions.toString());
        accuracyL.setText(Float.toString(accuracy));


        // Sets the color of the Text
        monsterNameL.setForeground(Color.RED);
        acL.setForeground(Color.RED);
        hpL.setForeground(Color.RED);
        speedL.setForeground(Color.RED);
        strengthL.setForeground(Color.RED);
        dexterityL.setForeground(Color.RED);
        constitutionL.setForeground(Color.RED);
        intelligenceL.setForeground(Color.RED);
        wisdomL.setForeground(Color.RED);
        charismaL.setForeground(Color.RED);
        otherInfoL.setForeground(Color.RED);
        monsterActionsL.setForeground(Color.RED);

        setTitle("Monster Encounter");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        BoxLayout layout = new BoxLayout(this, BoxLayout.Y_AXIS);
        getContentPane().setLayout(layout);

        setSize(400,400);
        setVisible(true);

        setContentPane(new JLabel(new ImageIcon("Images/Image.png")));
        setSize(399,399);
        setSize(400,400);

    }


}
