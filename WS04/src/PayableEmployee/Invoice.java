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

public class Invoice implements Payable {
    private String partNumber, partDescription;
    private int quantity;
    private double pricePerItem;

    public Invoice(String pNum, String pDesc, int q, double p) {
        setPartNumber(pNum);
        setPartDescription(pDesc);
        setQuantity(q);
        setPricePerItem(p);
    }

    public void setPartNumber(String p) {
        partNumber = (p.length() != 0) ? p : "";
    }

    public void setPartDescription(String p) {
        partDescription = (p.length() != 0) ? p : "";
    }

    public void setQuantity(int q) {
        quantity = (q < 1) ? 0 : q;
    }

    public void setPricePerItem(double p) {
        pricePerItem = Math.max(p, 0.0);
    }

    public String getPartNumber() {
        return partNumber;
    }

    public String getPartDescription() {
        return partDescription;
    }

    public int getQuantity() {
        return quantity;
    }

    public double getPricePerItem() {
        return pricePerItem;
    }

    public String toString() {
        return String.format("%s: \n%s: %s (%s) \n%s: %d \n%s: $%,.2f", "Invoice", "Part Number", getPartNumber(), getPartDescription(), "Quantity", getQuantity(), "Price Per Item", getPricePerItem());
    }

    public double getPaymentAmount() {
        return getQuantity() * getPricePerItem();
    }
}