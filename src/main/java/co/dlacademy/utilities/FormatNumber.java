package co.dlacademy.utilities;

import java.text.DecimalFormat;

public class FormatNumber {

    public static double converStrinDouble(String moneyString){
        String cleanString = moneyString.replace("$","").replace(",","").replace("COP","");

        double moneyDouble = Double.parseDouble(cleanString);

        DecimalFormat decimalFormat  = new DecimalFormat("#.00");
        String formatString = decimalFormat.format(moneyDouble);
        double formatDouble = Double.parseDouble(formatString);
        return  formatDouble;
    }
}
