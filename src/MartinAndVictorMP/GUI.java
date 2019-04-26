package src.MartinAndVictorMP;

import org.json.JSONException;
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
    private JLabel chosenMonster = new JLabel("");
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
        chosenMonster.setPreferredSize(new Dimension(200, 50));
        stats.setPreferredSize(new Dimension(200, 50));

        buildEncounter.setPreferredSize(new Dimension(400, 100));

        setResizable(false);

        String[] difficulties = {"Easy", "Medium", "Hard", "Deadly"};
        JComboBox difficultyBox = new JComboBox(difficulties);
        difficultyBox.setSelectedIndex(0);

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
                                .addComponent(chosenMonster)).addGroup(
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
                                .addComponent(chosenMonster)
                                .addComponent(stats))
                                .addComponent(buildEncounter));



        buildEncounter.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Encounter encounter = new Encounter(Integer.parseInt(numOfPlayersT.getText()),
                                                    Integer.parseInt(levelOfPlayersT.getText()),
                                                    Integer.parseInt(minMonstersT.getText()),
                                                    Integer.parseInt(maxMonstersT.getText()),
                                                    String.valueOf(difficultyBox.getSelectedItem()).toLowerCase()
                );

                try {
                    Monster monster = encounter.buildEncounter();
                    if (monster != null) {
                        chosenMonster.setText(encounter.getMonstersInEncounter() + "x " + monster.getName());
                        System.out.println("Accuracy of the match: "+ encounter.getAccuracy()*100 + "%");
                    } else {
                        System.out.println("Monster not found.");
                    }
                } catch (IOException ex) {
                    ex.printStackTrace();
                } catch (JSONException ex) {
                    ex.printStackTrace();
                }
            }
        });
        pack();
        setVisible(true);
    }
}

/*
Need to make the input fields foolproof (only integers in number of players, minMonsters has to be lower that maxMonsters, etc.)
Maybe instead of making the user input correct min and max monsters, we can just interchange the values if they're wrong.
Also, would be nice if the UI would be nice. I'll get to that.
*/