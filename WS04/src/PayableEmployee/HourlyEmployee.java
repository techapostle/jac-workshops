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

public class HourlyEmployee extends Employee {
    private double wage, hours;

    public HourlyEmployee(String fName, String lName, String SSN, double w, double h) {
        super(fName, lName, SSN);
        try {
            setWage(w);
            setHours(h);
        } catch(Exception ex) {
            System.out.print("Exception occurred.");
        }
    }

    public void setWage(double w) throws Exception {
        if (w <= 0.0) {
            throw new Exception("wage 0.0 or less.");
        } else {
            wage = w;
        }
    }

    public void setHours(double h) throws Exception {
        if (h < 0.0 || h > 168.0) {
            throw new Exception("commissionRate not between 0.0 and 1.0.");
        } else {
            hours = h;
        }
    }

    public double getWage() { return wage; }

    public double getHours() { return hours; }

    public double getPaymentAmount() {
        return getWage() * getHours();
    }

    public String toString() {
        return String.format("Hourly Employee: %s\n%s: $%,.2f \n%s: $%,.2f",
                super.toString(), "hourly salary", getWage(), "amount due", getPaymentAmount());
    }
}