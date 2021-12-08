/**********************************************
 Workshop 8
 Course: JAC444 - Semester
 Last Name: Dadkhah Shokrollahi
 First Name: Kian
 ID: 119369205
 Section: NDD
 This assignment represents my own work in accordance with Seneca Academic Policy.
 Signature
 Date: 2021-11-18
 **********************************************/

package task3;

import java.util.*;

/**
 * This class takes a list of 25 countries and
 * maps each of them to their corrosponding capital city.
 * Additionally, it may accept a query to display
 * the corrosponding capital city of a country defined via
 * user input.
 */
public class CountryCapital {
    Map<String, String> countriesCapitals;

    CountryCapital() {
        populateData();
    }

    private void populateData() {
        countriesCapitals = new LinkedHashMap<>();
        String[][] data = {
                {"AFGHANISTAN", "KABUL"}, {"ALBANIA", "TIRANA"}, {"ALGERIA", "ALGIERS"},
                {"ANDORRA", "ANDORRA LA VELLA"}, {"ANGOLA", "LUANDA"}, {"ANTIGUA & BARBUDA", "SAINT JOHN'S"},
                {"ARGENTINA", "BUENOS AIRES"}, {"ARMENIA", "YEREVAN"}, {"AUSTRALIA", "CANBERRA"},
                {"AUSTRIA", "VIENNA"}, {"AZERBAIJAN", "BAKU"}, {"BAHAMAS", "NASSAU"},
                {"BAHRAIN", "MANAMA"}, {"BANGLADESH", "DHAKA"}, {"BARBADOS", "BRIDGETOWN"},
                {"BELARUS", "MINSK"}, {"BELGIUM", "BRUSSELS"}, {"BELIZE", "BELMOPAN"},
                {"BENIN", "PORTO-NOVO"}, {"BHUTAN", "THIMPHU"}, {"BOLIVIA", "SUCRE"},
                {"BOSNIA & HERZEGOVINA", "SARAJEVO"}, {"BOTSWANA", "GABORONE"}, {"BRAZIL", "BRASILIA"},
                {"BRUNEI", "BANDAR SERI BEGAWAN"}
        };
        for (String[] d : data)
            countriesCapitals.put(d[0], d[1]);
    }

    public static void main(String[] args) {
        CountryCapital countryCapital = new CountryCapital();
        System.out.println("Displaying names of countries available for query...");
        for (Map.Entry<String, String> entry : countryCapital.countriesCapitals.entrySet()) {
            System.out.println(entry.getKey());
        }
        System.out.print("Enter a country: ");
        Scanner scanner = new Scanner(System.in);
        String country = scanner.nextLine();
        if (countryCapital.countriesCapitals.get(country.toUpperCase()) != null) {
            System.out.println("The capital city of " + country.toUpperCase() + " is " +
                    countryCapital.countriesCapitals.get(country.toUpperCase()));
        }
    }
}