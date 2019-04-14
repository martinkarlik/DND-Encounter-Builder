package src.MarinAndVictorMP;

import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class GUI extends JFrame {
    private JLabel numOfPlayersL = new JLabel("Number of players:");
    private JLabel levelOfPlayersL = new JLabel("Level of players:");
    private JLabel minMonstersL = new JLabel("Min monsters:");
    private JLabel maxMonstersL = new JLabel("Max monsters:");
    private JLabel challengeRatingL = new JLabel("Challenge Rating:");
    private JLabel monsterTypeL = new JLabel("Monster Type:");
    private JLabel difficultyL = new JLabel("Difficulty:");

    private JTextField numOfPlayersT = new JTextField("");
    private JTextField levelOfPlayersT = new JTextField("");
    private JTextField minMonstersT = new JTextField("");
    private JTextField maxMonstersT = new JTextField("");
    private JTextField challengeRatingT = new JTextField("");
    private JTextField monsterTypeT = new JTextField("");
    private JTextField difficultyT = new JTextField("");

    private JButton buildEncounter = new JButton("Build Encounter");


    public GUI() {
        setTitle("D&D Encounter Builder");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);

        layout.setAutoCreateContainerGaps(true);
        layout.setAutoCreateGaps(true);

        layout.setHorizontalGroup(layout.createSequentialGroup()
                .addGroup(
                        layout.createParallelGroup(
                                GroupLayout.Alignment.LEADING)
                                .addComponent(numOfPlayersL)
                                .addComponent(numOfPlayersT)
                                .addComponent(minMonstersL)
                                .addComponent(minMonstersT)).addGroup(
                        layout.createParallelGroup(
                                GroupLayout.Alignment.LEADING)
                                .addComponent(levelOfPlayersL)
                                .addComponent(levelOfPlayersT)
                                .addComponent(maxMonstersL)
                                .addComponent(maxMonstersT)).addGroup(
                        layout.createParallelGroup(
                                GroupLayout.Alignment.LEADING)
                                .addComponent(challengeRatingL)
                                .addComponent(challengeRatingT)
                                .addComponent(monsterTypeL)
                                .addComponent(monsterTypeT)).addGroup(
                        layout.createParallelGroup(
                                GroupLayout.Alignment.LEADING)
                                .addComponent(difficultyL)
                                .addComponent(difficultyT)
                                .addComponent(buildEncounter)));

        layout.setVerticalGroup(layout.createSequentialGroup()
                .addGroup(
                        layout.createParallelGroup(
                                GroupLayout.Alignment.BASELINE)
                                .addComponent(numOfPlayersL)
                                .addComponent(levelOfPlayersL)
                                .addComponent(challengeRatingL)
                                .addComponent(difficultyL)).addGroup(
                        layout.createParallelGroup(
                                GroupLayout.Alignment.BASELINE)
                                .addComponent(numOfPlayersT)
                                .addComponent(levelOfPlayersT)
                                .addComponent(challengeRatingT)
                                .addComponent(difficultyT)).addGroup(
                        layout.createParallelGroup(
                                GroupLayout.Alignment.BASELINE)
                                .addComponent(minMonstersL)
                                .addComponent(maxMonstersL)
                                .addComponent(monsterTypeL)).addGroup(
                        layout.createParallelGroup(
                                GroupLayout.Alignment.BASELINE)
                                .addComponent(minMonstersT)
                                .addComponent(maxMonstersT)
                                .addComponent(monsterTypeT)
                                .addComponent(buildEncounter)));
        pack();
        setVisible(true);
    }
}
    /*
    @Override
    public void actionPerformed(ActionEvent actionEvent) {

    }
    */
