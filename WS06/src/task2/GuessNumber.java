package task2;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.Random;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.SwingUtilities;

public class GuessNumber extends JFrame
{
    private int number;
    private int numGuesses = 1, oldGuess = 0;
    private JTextField guessInputTextField;
    private JLabel promptLabel1;
    private JLabel promptLabel2;
    private JLabel messageLabel1;
    private JLabel messageLabel2;
    private JLabel randomLabel = new JLabel("");
    private JButton newGameButton;
    private Color background;

    public GuessNumber()
    {
        this(1, 0);
    }

    private GuessNumber(int num, int old) {
        super("Guessing Game");
        numGuesses = num;
        oldGuess = old;
    }

    private void GuessGame() {
        setLayout(new FlowLayout());
        background = Color.LIGHT_GRAY;
        promptLabel1 = new JLabel("Guess a number between 1 and 1000.");
        add(promptLabel1);
        promptLabel2 = new JLabel("Type your guess below and hit Enter.");
        add(promptLabel2);
        guessInputTextField = new JTextField(5);
        guessInputTextField.addActionListener(new GuessHandler());
        add(guessInputTextField);
        messageLabel1 = new JLabel("");
        add(messageLabel1);
        messageLabel2 = new JLabel("");
        add(messageLabel2);
        newGameButton = new JButton("New Game");
        add(newGameButton);

        Random generator = new Random();
        number = generator.nextInt(1001);

        newGameButton.addActionListener(
                new ActionListener()
                {
                    public void actionPerformed(ActionEvent e)
                    {
                        guessInputTextField.setText("");
                        Random generator = new Random();
                        number = generator.nextInt(1001);
                        randomLabel.setText("" + number);
                        SwingUtilities.updateComponentTreeUI(randomLabel);
                        messageLabel1.setText("");
                        guessInputTextField.setEditable(true);
                        numGuesses = 0;
                        messageLabel2.setText("Number of Guesses: " + numGuesses);
                        numGuesses++;
                    }
                }
        );
    }

    class GuessHandler implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            int Guess;
            Guess = Integer.parseInt(guessInputTextField.getText());
            if (Math.abs(number - Guess) < Math.abs(number - oldGuess))
            {
                getContentPane().setBackground(Color.RED);
            }
            else
            {
                getContentPane().setBackground(Color.BLUE);
            }
            oldGuess = Guess;
            if (Guess > number)
            {
                messageLabel1.setText("Too High.");
                SwingUtilities.updateComponentTreeUI(messageLabel1);
            }
            if (Guess < number)
            {
                messageLabel1.setText("Too Low.");
                SwingUtilities.updateComponentTreeUI(messageLabel1);
            }
            if (Guess == number)
            {
                messageLabel1.setText("Correct!");
                SwingUtilities.updateComponentTreeUI(messageLabel1);
                guessInputTextField.setEditable(false);
            }
            messageLabel2.setText("Number of Guesses: " + numGuesses++);
        }
    }
}