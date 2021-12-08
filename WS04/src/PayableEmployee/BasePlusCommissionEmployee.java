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

public class BasePlusCommissionEmployee extends CommissionEmployee {
    private double baseSalary;

    public BasePlusCommissionEmployee(String fName, String lName, String SSN, double gSales, double cRate, double bSalary) {
        super(fName, lName, SSN, gSales, cRate);
        try {
            setBaseSalary(bSalary);
        } catch (Exception ex) {
            System.out.print("Exception occurred.");
        }
    }

    private void setBaseSalary(double s) throws Exception {
        if (s <= 0.0) {
            throw new Exception("grossSales 0.0 or less.");
        } else {
            baseSalary = s;
        }
    }

    public double getBaseSalary() {
        return baseSalary;
    }

    public double getPaymentAmount() {
        return super.getPaymentAmount();
    }

    public String toString() {
        return String.format("Base + %s\n%s: $%,.2f \n%s: $%,.2f",
                super.toString(), "base salary", getBaseSalary(), "amount due", getPaymentAmount() + getBaseSalary());
    }
}