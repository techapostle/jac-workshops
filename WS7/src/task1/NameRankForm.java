/**********************************************
 Workshop 7
 Course: JAC444 - Semester
 Last Name: Dadkhah Shokrollahi
 First Name: Kian
 ID: 119369205
 Section: NDD
 This assignment represents my own work in accordance with Seneca Academic Policy.
 Signature
 Date: 2021-11-18
 **********************************************/

package task1;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.Scanner;

public class NameRankForm extends JFrame {
    private JPanel NameRankPanel;
    private JButton exitButton;
    private JButton submitQueryButton;
    private JTextField enterYearTextField;
    private JTextField enterGenderTextField;
    private JTextField enterNameTextField;
    private JLabel genderLabel;
    private JLabel yearLabel;
    private JLabel namePanel;

    public NameRankForm() {
        super("Search Name Ranking Application");
        setLayout(new GridLayout());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(650, 200);
        setVisible(true);
        NameRankFormApp();
    }

    private void NameRankFormApp() {
        JLabel[] labelList = {yearLabel, genderLabel, namePanel};
        JTextField[] textFieldList = {enterYearTextField, enterGenderTextField, enterNameTextField};
        for (int i = 0; i < labelList.length; i++) {
            add(labelList[i]);
            add(textFieldList[i]);
        }
        add(submitQueryButton);
        add(exitButton);

        submitQueryButton.addActionListener(e -> {
            // validate input, get String
            boolean nameFound = false, fileFound = true;
            int rank = 0;
            String year = enterYearTextField.getText();
            String name = enterNameTextField.getText();
            String gender = "";
            switch (enterGenderTextField.getText()) {
                case "M" -> gender = "Boy";
                case "F" -> gender = "Girl";
            }

            try { // open file
                File file = new File("babynamesranking" + year + ".txt");
                if (!file.exists()) {
                    fileFound = false;
                    MessageWindow errorMsg = new MessageWindow("No file exists for the year: " + year);
                }
                else { // read file
                    Scanner read = new Scanner(file);
                    while (read.hasNext()) {
                        String line = read.nextLine();
                        String[] record = line.split("\\t+");

                        if (gender.equals("Boy") && record[1].equalsIgnoreCase(name)) {
                            nameFound = true;
                            rank = Integer.parseInt(record[0].trim());
                            read.close();
                            break;
                        } else if (gender.equals("Girl") && record[3].trim().equalsIgnoreCase(name)) {
                            nameFound = true;
                            rank = Integer.parseInt(record[0].trim());
                            read.close();
                            break;
                        }
                    }
                }
            } catch (FileNotFoundException exception) {
                exception.printStackTrace();
            }

            if (nameFound && fileFound)
                displayNameRank(gender + " name " + name + " was ranked #" + rank + " in " + year);
            else if (!nameFound && fileFound)
                displayNameRank(gender + " name " + name + " was not ranked in " + year);
        });

        exitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(1);
            }
        });
    }

    private void displayNameRank(String rankOfName) {
        MessageWindow rankWindow = new MessageWindow(rankOfName);
    }

    public static void main(String[] args) {
        NameRankForm nameRankObj = new NameRankForm();
    }

    // inner class for window showing name rank
    static class MessageWindow extends JFrame {
        MessageWindow() {
            this("such empty");
        }

        MessageWindow(String message) {
            setLayout(new FlowLayout());
            setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            setSize(450, 100);
            setVisible(true);
            displayMessage(message);
        }

        public void displayMessage(String message) {
            add(new JLabel(message));
        }
    }
}