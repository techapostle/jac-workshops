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

package ca.jac444.ws6;

import ca.jac444.ws6.task1.LoanCompareTest;
import ca.jac444.ws6.task2.GuessTest;
import javafx.fxml.FXML;

public class WelcomeController {
    @FXML
    protected void onT1ButtonClick() {
        GuessTest.main(null);
    }

    @FXML
    protected void onT2ButtonClick() {
        LoanCompareTest.main(null);
    }
}