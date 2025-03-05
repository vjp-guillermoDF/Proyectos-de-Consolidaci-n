/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package General;

import java.util.Scanner;

/**
 *
 * @author guill
 */
public class DescifrarMensajes {

    public static final String MENSAJE1 = "Tzñt. ¿Xmnág ebmnim eim oxaívñeim wx xmvtjx? Gxvxmbntfim tmxzñltlgim wx nxgxl ñgt oít wx mtebwt lájbwt";

    public static final String MENSAJE2 = "Tzñt. Etm fñgbvbigxm xmnág utctm. ¿Tezñbxg jñxwx nltxl tezñgtm fám?";

    public static final String MENSAJE3 = "Tzñt. ¿Xmná niwi xe xkñbji wx vifñgbvtvbóg ijxltnboi? Nxgxfim kñx ftgnxgxlgim vigxvntwim xg niwi fifxgni.";

    public static final String MENSAJE4 = "Tzñt. Gxvxmbntfim fám xqjeimboim. ¿Tezñbxg jñxwx vigmxzñbl tezñgim fám?";

    public static final String MENSAJE5 = "Tzñt. Xmni gi otex jtlt gtwt, ¿wógwx v*** ei atm vifjltwi, Eiztg?";


    public static String descifrar() {

        Scanner entrada = new Scanner(System.in);

        System.out.println("¿Qué mensaje desea descifrar?");

        String mensaje = entrada.nextLine();

        System.out.println("¿Cuál es el desplazamiento?");

        int desplazamiento = entrada.nextInt();

        String resultado = "";
        String alfabeto = "abcdefghijklmnñopqrstuvwxyz";

        for (int i = 0; i < mensaje.length(); i++) {
            char letra = mensaje.charAt(i);
            boolean esMayuscula = Character.isUpperCase(letra);
            letra = Character.toLowerCase(letra);

            int index = alfabeto.indexOf(letra);

            if (index != -1) { // Usamos esta variable para ver si la letra está en el alfabeto
                int nuevoIndex = (index + desplazamiento) % alfabeto.length();
                char nuevaLetra = alfabeto.charAt(nuevoIndex);

                if (esMayuscula) {
                    nuevaLetra = Character.toUpperCase(nuevaLetra);
                }
                resultado += nuevaLetra;
            } else {
                resultado += letra; // Mantener caracteres especiales y espacios sin cambios
            }
        }

        return resultado;
    }

}
