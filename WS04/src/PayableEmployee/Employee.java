/**********************************************
 Workshop #
 Course: JAC444 - Semester
 Last Name: Dadkhah Shokrollahi
 First Name: Kian
 ID: 119369205
 Section: NDD
 This assignment represents my own work in accordance with Seneca Academic Policy.
 Signature
 Date: 2021-10-18
 **********************************************/

package PayableEmployee;

public abstract class Employee implements Payable {
    private String firstName, lastName, socialSecurityNumber;

    public Employee(String fName, String lName, String SSNum) {
        setFirstName(fName);
        setLastName(lName);
        setSocialSecurityNumber(SSNum);
    }

    public void setFirstName(String f) {
        firstName = (f.length() != 0) ? f : "";
    }

    public void setLastName(String l) {
        lastName = (l.length() != 0) ? l : "";
    }

    public void setSocialSecurityNumber(String s) {
        socialSecurityNumber = (s.length() != 0) ? s : "";
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getSocialSecurityNumber() {
        return socialSecurityNumber;
    }

    public String toString() {
        return String.format("%s %s\nSSN: %s", getFirstName(), getLastName(), getSocialSecurityNumber());
    }
}