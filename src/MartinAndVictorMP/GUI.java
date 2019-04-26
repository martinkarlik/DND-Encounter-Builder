package src.MartinAndVictorMP;

import org.json.JSONException;
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

    GUI monsterGUI;


    public GUI() {

        // To make sure that the user can only input ints and the minimum is 1
        formatter.setValueClass(Integer.class);
        formatter.setMinimum(0);
        formatter.setMaximum(100);
        formatter.setAllowsInvalid(true);
        JFormattedTextField minMonstersT = new JFormattedTextField(formatter);
        JFormattedTextField maxMonstersT = new JFormattedTextField(formatter);
        JFormattedTextField numOfPlayersT = new JFormattedTextField(formatter);
        JFormattedTextField levelOfPlayersT = new JFormattedTextField(formatter);

        monsterGUI = null;

        setResizable(false);

        String[] difficulties = {"Easy", "Medium", "Hard", "Deadly"};
        JComboBox difficultyBox = new JComboBox(difficulties);
        difficultyBox.setSelectedIndex(1);

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

        pack();
        setVisible(true);


        buildEncounter.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                if(Integer.parseInt(minMonstersT.getText()) > Integer.parseInt(maxMonstersT.getText())){
                    String tempMax = maxMonstersT.getText();
                    maxMonstersT.setText(minMonstersT.getText());
                    minMonstersT.setText(tempMax);
                }

                if (minMonstersT.getText().length() > 0 &&
                        maxMonstersT.getText().length() > 0 &&
                        numOfPlayersT.getText().length() > 0 &&
                        levelOfPlayersT.getText().length() > 0) {

                    EncounterBuilder encounterBuilder = new EncounterBuilder(new Encounter(
                            Integer.parseInt(numOfPlayersT.getText()),
                            Integer.parseInt(levelOfPlayersT.getText()),
                            Integer.parseInt(minMonstersT.getText()),
                            Integer.parseInt(maxMonstersT.getText()),
                            String.valueOf(difficultyBox.getSelectedItem()).toLowerCase()
                    ));

                    /*
                    if (monsterGUI == null) { delete current monsterGUI if creating a new one.. currently always deletes the new GUI :{
                        monsterGUI.dispose();
                    }
                    */

                    encounterBuilder.start();


                    try {
                        encounterBuilder.join();

                        monsterGUI = new MonsterGUI(name, description, generalInfo, attributes, actions);

                        /*
                        name


                        */

                        ArrayList<String> attributes = encounterBuilder.getEncounter().getMonster().getAttributes();
                        ArrayList<String> savingThrows = encounterBuilder.getEncounter().getMonster().getSavingThrows();

                    } catch (InterruptedException ex) {
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