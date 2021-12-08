package task2;

import javax.swing.JFrame;

public class GuessNumberTest
{
    public static void main(String[] args) throws Exception
    {
        GuessNumber guessGame = new GuessNumber();
        guessGame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        guessGame.setSize(550, 150);
        guessGame.setVisible(true);
    }
}