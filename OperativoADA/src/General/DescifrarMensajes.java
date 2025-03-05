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

    public static final String MENSAJE1 = "Tz�t. �Xmn�g ebmnim eim oxa�v�eim wx xmvtjx? Gxvxmbntfim tmxz�ltlgim wx nxgxl �gt o�t wx mtebwt l�jbwt";

    public static final String MENSAJE2 = "Tz�t. Etm f�gbvbigxm xmn�g utctm. �Tez�bxg j�xwx nltxl tez�gtm f�m?";

    public static final String MENSAJE3 = "Tz�t. �Xmn� niwi xe xk�bji wx vif�gbvtvb�g ijxltnboi? Nxgxfim k�x ftgnxgxlgim vigxvntwim xg niwi fifxgni.";

    public static final String MENSAJE4 = "Tz�t. Gxvxmbntfim f�m xqjeimboim. �Tez�bxg j�xwx vigmxz�bl tez�gim f�m?";

    public static final String MENSAJE5 = "Tz�t. Xmni gi otex jtlt gtwt, �w�gwx v*** ei atm vifjltwi, Eiztg?";


    public static String descifrar() {

        Scanner entrada = new Scanner(System.in);

        System.out.println("�Qu� mensaje desea descifrar?");

        String mensaje = entrada.nextLine();

        System.out.println("�Cu�l es el desplazamiento?");

        int desplazamiento = entrada.nextInt();

        String resultado = "";
        String alfabeto = "abcdefghijklmn�opqrstuvwxyz";

        for (int i = 0; i < mensaje.length(); i++) {
            char letra = mensaje.charAt(i);
            boolean esMayuscula = Character.isUpperCase(letra);
            letra = Character.toLowerCase(letra);

            int index = alfabeto.indexOf(letra);

            if (index != -1) { // Usamos esta variable para ver si la letra est� en el alfabeto
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
