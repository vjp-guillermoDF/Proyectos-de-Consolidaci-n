/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package caracteres;

/**
 * Javadoc de autor
 *
 * @author guillermo
 */
public class Caracteres {

    /**
     * Este método recibe un nombre por parámetro y cuenta los caracteres 'e' o
     * 'E'
     *
     * @param nombre es el parámetro String que recibirá este método
     * @return devuelve la cantidad de caracteres 'e' o 'E', almacenados en la
     * variable "total"
     */
    public int Contadore(String nombre) {
        int total = 0;

        int i = 0;

        while (i < nombre.length()) {
            if ((nombre.charAt(i) == 'e') || (nombre.charAt(i) == 'E')) {

                total++;

            }

            i++;

        }

        return total;

    }

    /**
     * Este método recibe un nombre por parámetro y cuenta las vocales
     *
     * @param nombre es el parámetro String que recibirá este método
     * @return devuelve la cantidad de vocales, almacenados en la variable
     * "total"
     */
    public int contvocales(String nombre) {

        int total = 0;

        int i = 0;

        while (i < nombre.length()) {
            if ((nombre.charAt(i) == 'e') || (nombre.charAt(i) == 'E') || (nombre.charAt(i) == 'a') || (nombre.charAt(i) == 'A') || (nombre.charAt(i) == 'i') || (nombre.charAt(i) == 'I') || (nombre.charAt(i) == 'U') || (nombre.charAt(i) == 'u') || (nombre.charAt(i) == 'O') || (nombre.charAt(i) == 'o')) {

                total++;

            }

            i++;

        }

        return total;

    }

    /**
     * Este método recibe un nombre por parámetro y cuenta las consonantes
     * restándole las vocales (calculadas llamando al método "contVocales") y
     * restándoselas a la longitud en caracteres del nombre
     *
     * @param nombre es el parámetro String que recibirá este método
     * @return devuelve la cantidad de caracteres restantes una vez descontadas
     * las vocales, almacenada en la variable total
     */
    public int contCon(String nombre) {

        int total = 0;

        total = nombre.length() - contvocales(nombre);

        return total;

    }

    /**
     * El método main imprime en la variable n el número de vocales "e" o "E" en
     * la frase que le damos como parámetro
     *
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here

        Caracteres c = new Caracteres();

        int n = c.Contadore("La casa es de uno nuevo");

        System.out.println(n);

    }

}
