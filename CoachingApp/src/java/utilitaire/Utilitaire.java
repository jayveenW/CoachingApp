/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utilitaire;

/**
 *
 * @author NG71392
 */
public class Utilitaire {

    /**
     * Méthode qui permet de convertir un String en camel case
     * @param entry mot que l'on souhaite convertir
     * @return 
     */
    public String convertCamelCase(String entry) {
        String result = "";
        char firstChar = entry.charAt(0);
        result = result + Character.toUpperCase(firstChar);
        for (int i = 1; i < entry.length(); i++) {
            char currentChar = entry.charAt(i);
            result = result + Character.toUpperCase(currentChar);
        }
        return result;
    }
}
