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
public class DescifrarMensajes {    //Guardamos los mensjes como constantes públicas... Esto no es necesario, pero así los tenemos a mano

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

        System.out.println("Descifrando mensaje...");

        String resultado = "";  //String vacío para almacenar el código descifrado
        String alfabeto = "abcdefghijklmnñopqrstuvwxyz";    //String auxiliar con las letras del alfabeto

        for (int i = 0; i < mensaje.length(); i++) {
            char letra = mensaje.charAt(i);
            boolean esMayuscula = Character.isUpperCase(letra); //Esta variable booleana, así tal como está implementada, devuelve automáticamente true si una letra es mayúscula
            letra = Character.toLowerCase(letra); //Convierte las letras a minúscula

            int index = alfabeto.indexOf(letra);    //Creamos un índice que implementa indexOf de la clase String, para guardar las letras del alfabeto

            if (index != -1) { //Usamos esta variable para ver si la letra está en el alfabeto
                int nuevoIndex = (index + desplazamiento) % alfabeto.length(); //Cambia el lugar de las letras del mensaje en función del desplazamiento
                char nuevaLetra = alfabeto.charAt(nuevoIndex); //Usa charAt para transformar las letras en una nueva variable nuevaLetra

                if (esMayuscula) {  //Este if hace que si se cumple el booleano esMayuscula en la variable letra, se aplique también en NuevaLetra
                    nuevaLetra = Character.toUpperCase(nuevaLetra);
                }
                resultado += nuevaLetra;    //Va llenando el resultado
            } else {
                resultado += letra; //Mantener caracteres especiales y espacios sin cambios
            }
        }

        return resultado;
    }

    public static void main(String[] args) { //Creamos método main para clase DescifrarMensajes y ejecutamos el método aquí mediante impresión
        System.out.println(descifrar());
    }

}
