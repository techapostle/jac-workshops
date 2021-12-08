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

public class SalariedEmployee extends Employee {
    private double weeklySalary;

    public SalariedEmployee(String fName, String lName, String SSN, double salary) {
        super(fName, lName, SSN);
        try {
            setWeeklySalary(salary);
        } catch (Exception ex) {
            System.out.print("Exception occurred.");
        }
    }

    public void setWeeklySalary(double s) throws Exception {
        if (s <= 0.0) {
            throw new Exception("grossSales 0.0 or less.");
        } else {
            weeklySalary = s;
        }
    }

    public double getWeeklySalary() {
        return weeklySalary;
    }

    public double getPaymentAmount() {
        return getWeeklySalary();
    }

    public String toString() {
        return String.format("Salaried Employee: %s\n%s: $%,.2f",
                super.toString(), "amount due", getWeeklySalary());
    }
}