package utilities;

import java.util.HashMap;
import java.util.Map;

public class Strings {

    public static Map<String, String> parseCaracteristicProducts(String caracteristicsList) {
        Map<String, String> caracteristicasMap = new HashMap<>();
        String[] caracteristicArray = caracteristicsList.split(",");


        for (String caracteristica : caracteristicArray) {
            String[] partes = caracteristica.trim().split(":");
            if (partes.length == 2) {
                String clave = partes[0].trim();
                String valor = partes[1].trim();
                caracteristicasMap.put(clave, valor);
            }
        }

        return caracteristicasMap;
    }
}
