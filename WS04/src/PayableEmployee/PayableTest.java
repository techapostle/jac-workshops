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

public class PayableTest {
    public static void main(String[] args) {
        Payable[] interfaceObj = new Payable[5];

        interfaceObj[0] = new Invoice("12345", "GPU", 3, 929.99);
        interfaceObj[1] = new SalariedEmployee("Kian", "Dadkhah", "111-22-6969", 1600.00);
        interfaceObj[2] = new HourlyEmployee("Jeff", "Bezos", "197-88-1964", 14.00, 69);
        interfaceObj[3] = new CommissionEmployee("Jordan", "Belfort", "123-12-1234", 690, 0.4);
        interfaceObj[4] = new BasePlusCommissionEmployee("Michael", "Scott", "321-21-4321", 999, 0.8, 2400.00);

        System.out.println("Testing each Payable object...\n");
        for (Payable obj : interfaceObj) {
            System.out.printf("%s\n\n", obj.toString());
        }

        Payable exceptionObj = new HourlyEmployee("Not", "Valid", "111-22-3333", 14.0, 200.0);
    }
}