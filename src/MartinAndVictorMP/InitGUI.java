package src.MartinAndVictorMP;

import javax.swing.*;
import javax.swing.text.NumberFormatter;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.IOException;
import java.text.NumberFormat;
import java.util.ArrayList;

public class InitGUI extends JFrame {
    private JLabel numOfPlayersL = new JLabel("Number of players (1-30):");
    private JLabel levelOfPlayersL = new JLabel("Level of players (1-30):");
    private JLabel minMonstersL = new JLabel("Min monsters (1-30):");
    private JLabel maxMonstersL = new JLabel("Max monsters (1-30):");
    private JLabel difficultyL = new JLabel("Difficulty:");
    private JComboBox difficultyBox;
    private JButton buildEncounter = new JButton("Build Encounter");
    private JLabel prompt = new JLabel("");

    NumberFormat format = NumberFormat.getInstance();
    NumberFormatter formatter = new NumberFormatter(format);


    public InitGUI() {

        //We need to make sure that the user inputs correct values

        formatter.setValueClass(Integer.class);
        formatter.setMinimum(1);
        formatter.setMaximum(30);
        formatter.setAllowsInvalid(true);
        JFormattedTextField minMonstersT = new JFormattedTextField(formatter);
        JFormattedTextField maxMonstersT = new JFormattedTextField(formatter);
        JFormattedTextField numOfPlayersT = new JFormattedTextField(formatter);
        JFormattedTextField levelOfPlayersT = new JFormattedTextField(formatter);

        String[] difficulties = {"Easy", "Medium", "Hard", "Deadly"};
        JComboBox difficultyBox = new JComboBox(difficulties);
        difficultyBox.setSelectedIndex(1);

        setTitle("D&D Encounter Builder");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setContentPane(new JLabel(new ImageIcon("src/Images/Image.png")));

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
                                .addComponent(prompt)).addGroup(
                        layout.createParallelGroup(
                                GroupLayout.Alignment.LEADING)
                                .addComponent(difficultyL)
                                .addComponent(difficultyBox)
                                .addComponent(buildEncounter)
                                .addComponent(prompt)));

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
                                .addComponent(prompt))
                                .addComponent(buildEncounter));

        setSize(500,150);
        setVisible(true);


        buildEncounter.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                //check if all the inputs are filled in
                if (minMonstersT.getText().length() > 0 &&
                        maxMonstersT.getText().length() > 0 &&
                        numOfPlayersT.getText().length() > 0 &&
                        levelOfPlayersT.getText().length() > 0) {

                    if(Integer.parseInt(minMonstersT.getText()) > Integer.parseInt(maxMonstersT.getText())){ //if min > max, switch
                        String tempMax = maxMonstersT.getText();
                        maxMonstersT.setText(minMonstersT.getText());
                        minMonstersT.setText(tempMax);
                    }

                    System.out.println("Building the encounter...");

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

                        if (chosenMonster != null) { //if the monster is found
                            int numberOfMonsters = encounterBuilder.getEncounter().getNumberOfMonsters();
                            float accuracy = encounterBuilder.getEncounter().getAccuracy();

                            //display the information about the encounter in a jlabel, and information about the monster on a new interface
                            prompt.setText(numberOfMonsters + "x " + chosenMonster.getName() + " (" + accuracy * 100 + "% accuracy)");

                            new MonsterGUI(chosenMonster.getName(),
                                    chosenMonster.getDescription(),
                                    chosenMonster.getGeneralInfo(),
                                    chosenMonster.getAttributes(),
                                    chosenMonster.getSavingThrows(),
                                    chosenMonster.getOtherInfo(),
                                    chosenMonster.getMonsterActions());

                            System.out.println("Encounter build.");

                        } else {
                            prompt.setText("Monster not found.");
                        }

                    } catch (InterruptedException | IOException ex) {
                        ex.printStackTrace();
                    }
                } else {
                    prompt.setText("Please fill in appropriate values.");
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
