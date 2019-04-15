package src.MartinAndVictorMP;

import org.json.JSONException;
import java.util.ArrayList;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.IOException;

public class GUI extends JFrame {
    private JLabel numOfPlayersL = new JLabel("Number of players:");
    private JLabel levelOfPlayersL = new JLabel("Level of players:");
    private JLabel minMonstersL = new JLabel("Min monsters:");
    private JLabel maxMonstersL = new JLabel("Max monsters:");
    private JLabel difficultyL = new JLabel("Difficulty:");

    private JTextField numOfPlayersT = new JTextField("");
    private JTextField levelOfPlayersT = new JTextField("");
    private JTextField minMonstersT = new JTextField("");
    private JTextField maxMonstersT = new JTextField("");

    private JButton buildEncounter = new JButton("Build Encounter");

    private JLabel prompt = new JLabel("PLAYERS VS.");
    String[] monsters = new String[5]; //max 5 different types of monsters
    private JLabel stats = new JLabel("Stats and maybe image of the selected monster");


    public GUI() {
        numOfPlayersL.setPreferredSize(new Dimension(100, 30));
        levelOfPlayersL.setPreferredSize(new Dimension(100, 30));
        minMonstersL.setPreferredSize(new Dimension(100, 30));
        maxMonstersL.setPreferredSize(new Dimension(100, 30));
        difficultyL.setPreferredSize(new Dimension(100, 30));
        minMonstersL.setPreferredSize(new Dimension(100, 30));

        numOfPlayersT.setPreferredSize(new Dimension(100, 30));
        levelOfPlayersT.setPreferredSize(new Dimension(100, 30));
        minMonstersT.setPreferredSize(new Dimension(100, 30));
        maxMonstersT.setPreferredSize(new Dimension(100, 30));
        minMonstersT.setPreferredSize(new Dimension(100, 30));
        prompt.setPreferredSize(new Dimension(200, 50));
        stats.setPreferredSize(new Dimension(200, 50));

        buildEncounter.setPreferredSize(new Dimension(400, 400));

        String[] difficulties = {"Easy", "Medium", "Hard", "Deadly"};
        JComboBox difficultyBox = new JComboBox(difficulties);
        difficultyBox.setSelectedIndex(0);

        for (int i = 0; i < monsters.length; i++) {
            monsters[i] = "";
        }

        //just to showcase
        monsters[0] = "3x Red Dragon";
        monsters[1] = "2x Kobold";

        JList monsterList = new JList(monsters);

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
                                .addComponent(minMonstersT)
                                .addComponent(prompt)).addGroup(
                        layout.createParallelGroup(
                                GroupLayout.Alignment.LEADING)
                                .addComponent(levelOfPlayersL)
                                .addComponent(levelOfPlayersT)
                                .addComponent(maxMonstersL)
                                .addComponent(maxMonstersT)
                                .addComponent(monsterList)).addGroup(
                        layout.createParallelGroup(
                                GroupLayout.Alignment.LEADING)
                                .addComponent(difficultyL)
                                .addComponent(difficultyBox)
                                .addComponent(buildEncounter)
                                .addComponent(stats)));

        layout.setVerticalGroup(layout.createSequentialGroup()
                .addGroup(
                        layout.createParallelGroup(
                                GroupLayout.Alignment.BASELINE)
                                .addComponent(numOfPlayersL)
                                .addComponent(levelOfPlayersL)
                                .addComponent(difficultyL)).addGroup(
                        layout.createParallelGroup(
                                GroupLayout.Alignment.BASELINE)
                                .addComponent(numOfPlayersT)
                                .addComponent(levelOfPlayersT)
                                .addComponent(difficultyBox)).addGroup(
                        layout.createParallelGroup(
                                GroupLayout.Alignment.BASELINE)
                                .addComponent(minMonstersL)
                                .addComponent(maxMonstersL)).addGroup(
                        layout.createParallelGroup(
                                GroupLayout.Alignment.BASELINE)
                                .addComponent(minMonstersT)
                                .addComponent(maxMonstersT)
                                .addComponent(buildEncounter)).addGroup(
                        layout.createParallelGroup(
                                GroupLayout.Alignment.BASELINE)
                                .addComponent(prompt)
                                .addComponent(monsterList)
                                .addComponent(stats))
                                .addComponent(buildEncounter));


        // This works but only if the enter button on the keyboard is being hit.
        buildEncounter.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                EncounterBuilder.setNumberOfPlayers(Integer.parseInt(numOfPlayersT.getText()));
                EncounterBuilder.setLevelOfPlayers(Integer.parseInt(levelOfPlayersT.getText()));
                EncounterBuilder.setMinMonsters(Integer.parseInt(minMonstersT.getText()));
                EncounterBuilder.setMaxMonsters(Integer.parseInt(maxMonstersT.getText()));
                EncounterBuilder.setDifficulty(difficultyBox.toString().toLowerCase());
                try {
                    EncounterBuilder.BuildEncounter();
                } catch (IOException ex) {
                    ex.printStackTrace();
                } catch (JSONException ex) {
                    ex.printStackTrace();
                }


                // For debugging
                /*System.out.println("Number of players: " + EncounterBuilder.getNumberOfPlayers());
                System.out.println("Level of players: " + EncounterBuilder.getLevelOfPlayers());
                System.out.println("Random number of monsters: " + EncounterBuilder.getNumberOfMonsters());
                System.out.println("Difficulty: " + EncounterBuilder.getDifficulty());*/

            }
        });
        pack();
        setVisible(true);
    }
}
    /*
    @Override
    public void actionPerformed(ActionEvent actionEvent) {

    }
    */
