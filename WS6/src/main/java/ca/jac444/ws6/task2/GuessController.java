/**********************************************
 Workshop 6
 Course: JAC444 - Semester
 Last Name: Dadkhah Shokrollahi
 First Name: Kian
 ID: 119369205
 Section: NDD
 This assignment represents my own work in accordance with Seneca Academic Policy.
 Signature
 Date: 2021-10-18
 **********************************************/

package ca.jac444.ws6.task2;

import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.*;
import java.util.Random;

public class GuessController extends JFrame
{
    private int number, oldGuess;
    private TextField guessInputTextField;
    private JLabel messageLabel; // JLabel blends with backgrond

    public GuessController() {
        this(0, "");
    }

    private GuessController(int old, String random) {
        super("Guessing Game");
        oldGuess = old;
        GuessGame();
    }

    private void GuessGame() {
        setLayout(new FlowLayout());
        Label randomLabel = new Label("");
        number = new Random().nextInt(1001);

        JLabel label1 = new JLabel("Guess a number between 1 and 1000.");
        JLabel label2 = new JLabel("The background color will indicate whether you're getting warmer (RED), or colder (BLUE).");
        JLabel label3 = new JLabel("Type your guess and hit Enter ");
        add(label1);
        add(label2);
        add(label3);

        guessInputTextField = new TextField(6);
        guessInputTextField.addActionListener(new GuessHandler());
        add(guessInputTextField);

        messageLabel = new JLabel("");
        add(messageLabel);

        JButton newGameButton = new JButton("New Game");
        add(newGameButton);

        newGameButton.addActionListener(
                e -> {
                    number = new Random().nextInt(1001);
                    guessInputTextField.setText("");
                    randomLabel.setText("" + number);
                    SwingUtilities.updateComponentTreeUI(randomLabel);
                    messageLabel.setText("");
                    guessInputTextField.setEditable(true);
                }
        );
    }

    class GuessHandler implements ActionListener {
        public void actionPerformed(ActionEvent e)
        {
            int guess;
            guess = Integer.parseInt(guessInputTextField.getText());
            if (Math.abs(number - guess) < Math.abs(number - oldGuess)) // new guess is closer than old guess
                getContentPane().setBackground(Color.RED);
            else // new guess is farther off than old guess
                getContentPane().setBackground(Color.BLUE);

            if (guess < number) {
                messageLabel.setText("Too Low.");
                SwingUtilities.updateComponentTreeUI(messageLabel);
            }
            if (guess > number) {
                messageLabel.setText("Too High.");
                SwingUtilities.updateComponentTreeUI(messageLabel);
            }
            if (guess == number) {
                guessInputTextField.setEditable(false);
                messageLabel.setText("Correct!");
                SwingUtilities.updateComponentTreeUI(messageLabel);
            }

            oldGuess = guess; // update old guess
        }
    }
}