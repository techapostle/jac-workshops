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

public class CommissionEmployee extends Employee {
    private double grossSales, commissionRate;

    CommissionEmployee(String fName, String lName, String SSN, double gSales, double cRate) {
        super(fName, lName, SSN);
        try {
            setGrossSales(gSales);
            setCommissionRate(cRate);
        } catch(Exception ex) {
            System.out.print("Exception occurred.");
        }
    }

    public void setGrossSales(double s) throws Exception {
        if (s <= 0.0) {
            throw new Exception("grossSales 0.0 or less.");
        } else {
            grossSales = s;
        }
    }

    public void setCommissionRate(double r) throws Exception {
        if (r < 0.0 || r > 1.0) {
            throw new Exception("commissionRate not between 0.0 and 1.0.");
        } else {
            commissionRate = r;
        }
    }

    public double getGrossSales() { return grossSales; }

    public double getCommissionRate() { return commissionRate; }

    public double getPaymentAmount() {
        return getGrossSales() * getCommissionRate();
    }

    public String toString() {
        return String.format("Commission Employee: %s\n%s: $%,.2f",
                super.toString(), "commission salary", getPaymentAmount());
    }
}