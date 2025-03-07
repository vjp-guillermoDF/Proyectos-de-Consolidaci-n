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
public class DescifrarMensajes {    //Guardamos los mensjes como constantes p�blicas... Esto no es necesario, pero as� los tenemos a mano

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

        System.out.println("Descifrando mensaje...");

        String resultado = "";  //String vac�o para almacenar el c�digo descifrado
        String alfabeto = "abcdefghijklmn�opqrstuvwxyz";    //String auxiliar con las letras del alfabeto

        for (int i = 0; i < mensaje.length(); i++) {
            char letra = mensaje.charAt(i);
            boolean esMayuscula = Character.isUpperCase(letra); //Esta variable booleana, as� tal como est� implementada, devuelve autom�ticamente true si una letra es may�scula
            letra = Character.toLowerCase(letra); //Convierte las letras a min�scula

            int index = alfabeto.indexOf(letra);    //Creamos un �ndice que implementa indexOf de la clase String, para guardar las letras del alfabeto

            if (index != -1) { //Usamos esta variable para ver si la letra est� en el alfabeto
                int nuevoIndex = (index + desplazamiento) % alfabeto.length(); //Cambia el lugar de las letras del mensaje en funci�n del desplazamiento
                char nuevaLetra = alfabeto.charAt(nuevoIndex); //Usa charAt para transformar las letras en una nueva variable nuevaLetra

                if (esMayuscula) {  //Este if hace que si se cumple el booleano esMayuscula en la variable letra, se aplique tambi�n en NuevaLetra
                    nuevaLetra = Character.toUpperCase(nuevaLetra);
                }
                resultado += nuevaLetra;    //Va llenando el resultado
            } else {
                resultado += letra; //Mantener caracteres especiales y espacios sin cambios
            }
        }

        return resultado;
    }

    public static void main(String[] args) { //Creamos m�todo main para clase DescifrarMensajes y ejecutamos el m�todo aqu� mediante impresi�n
        System.out.println(descifrar());
    }

}
