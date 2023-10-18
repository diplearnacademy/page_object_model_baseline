package co.dlacademy.utilities;

import java.text.DateFormatSymbols;
import java.util.Locale;

public class Dates {

    public static String getNumberMonth(String month){

        Locale location = new Locale("es","ES");

        //obtener los  nombres de los meses
        DateFormatSymbols symbols  = new DateFormatSymbols(location);
        String[] nameMonths = symbols.getMonths();

        for (int i = 0; i <nameMonths.length ; i++) {
            if(month.equalsIgnoreCase(nameMonths[i])){
                return  String.format("%02d",i+1);
            }
        }

        return "mes no valido";

    }

}
