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

import javax.swing.JFrame;

public class GuessTest {
    public static void main(String[] args) {
        GuessController guessGame = new GuessController();
        guessGame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        guessGame.setSize(650, 200);
        guessGame.setVisible(true);
    }
}