package src.MartinAndVictorMP;

import javax.swing.*;
import javax.swing.text.NumberFormatter;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.IOException;
import java.text.NumberFormat;
import java.util.ArrayList;

public class GUI extends JFrame {
    private JLabel numOfPlayersL = new JLabel("Number of players:");
    private JLabel levelOfPlayersL = new JLabel("Level of players:");
    private JLabel minMonstersL = new JLabel("Min monsters:");
    private JLabel maxMonstersL = new JLabel("Max monsters:");
    private JLabel difficultyL = new JLabel("Difficulty:");
    private JComboBox difficultyBox;
    private JButton buildEncounter = new JButton("Build Encounter");
    private JLabel chosenMonster = new JLabel("");
    private JLabel stats = new JLabel("");

    NumberFormat format = NumberFormat.getInstance();
    NumberFormatter formatter = new NumberFormatter(format);

    MonsterGUI monsterGUI;


    public GUI() {
        // To make sure that the user can only input ints and the minimum is 1
        formatter.setValueClass(Integer.class);
        formatter.setMinimum(1);
        formatter.setMaximum(20);
        formatter.setAllowsInvalid(true);
        JFormattedTextField minMonstersT = new JFormattedTextField(formatter);
        JFormattedTextField maxMonstersT = new JFormattedTextField(formatter);
        JFormattedTextField numOfPlayersT = new JFormattedTextField(formatter);
        JFormattedTextField levelOfPlayersT = new JFormattedTextField(formatter);

        monsterGUI = null;

        String[] difficulties = {"Easy", "Medium", "Hard", "Deadly"};
        JComboBox difficultyBox = new JComboBox(difficulties);
        difficultyBox.setSelectedIndex(1);

        setTitle("D&D Encounter Builder");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setContentPane(new JLabel(new ImageIcon("src/Images/image.png")));

        System.out.println(getWidth());
        System.out.println(getHeight());
        setSize(new Dimension(getWidth(), getHeight()));

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
                                .addComponent(chosenMonster)
                                .addComponent(stats))
                                .addComponent(buildEncounter));

        setSize(500,150);
        setVisible(true);


        buildEncounter.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {



                if (minMonstersT.getText().length() > 0 &&
                        maxMonstersT.getText().length() > 0 &&
                        numOfPlayersT.getText().length() > 0 &&
                        levelOfPlayersT.getText().length() > 0) {

                    if(Integer.parseInt(minMonstersT.getText()) > Integer.parseInt(maxMonstersT.getText())){ //if min > max, switch
                        String tempMax = maxMonstersT.getText();
                        maxMonstersT.setText(minMonstersT.getText());
                        minMonstersT.setText(tempMax);
                    }

                    EncounterBuilder encounterBuilder = new EncounterBuilder(new Encounter(
                            Integer.parseInt(numOfPlayersT.getText()),
                            Integer.parseInt(levelOfPlayersT.getText()),
                            Integer.parseInt(minMonstersT.getText()),
                            Integer.parseInt(maxMonstersT.getText()),
                            String.valueOf(difficultyBox.getSelectedItem()).toLowerCase()
                    ));

                    encounterBuilder.start();


                    try {
                        encounterBuilder.join();

                        Monster chosenMonster = encounterBuilder.getEncounter().getMonster();
                        int numberOfMonsters = encounterBuilder.getEncounter().getNumberOfMonsters();
                        float accuracy = encounterBuilder.getEncounter().getAccuracy();

                        monsterGUI = new MonsterGUI(numberOfMonsters,
                                                    chosenMonster.getName(),
                                                    chosenMonster.getDescription(),
                                                    chosenMonster.getGeneralInfo(),
                                                    chosenMonster.getAttributes(),
                                                    chosenMonster.getSavingThrows(),
                                                    chosenMonster.getOtherInfo(),
                                                    chosenMonster.getMonsterActions(),
                                                    accuracy);



                    } catch (InterruptedException | IOException ex) {
                        ex.printStackTrace();
                    }
                }
            }
        });

    }
}

/*
Need to make the input fields foolproof (only integers in number of players, minMonsters has to be lower that maxMonsters, etc.)
Maybe instead of making the user input correct min and max monsters, we can just interchange the values if they're wrong.
Also, would be nice if the UI would be nice. I'll get to that.
*/
