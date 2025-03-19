/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package examenej2;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author Guillermo Domínguez de la Fuente
 */
public class ExamenEj2 {

    public static final int MAX = 10;       //Constante que sirve para indicar la longitud del array de objetos

    public static void buscarMatricula(Coche[] coches) {        //Método para buscar el coche en función de su matrícula (asumiendo que estas NO PUEDEN ESTAR REPETIDAS)
        Scanner entrada = new Scanner(System.in);

        boolean encontrado = false; //Booleano para controlar el flujo
        int i = 0;          //Variable para evitar ArrayOutofBoundsException

        System.out.println("Introduzca la matricula de un coche: ");
        String matricula = entrada.next();
        while (!encontrado) {       //Mientras el coche no sea encontrado, el while seguirá recorriendo el array hasta que encuentre uno y se detendrá ahí
            if (coches[i] != null && matricula.equalsIgnoreCase(coches[i].getMatricula())) {        //Estas condiciones controlan que el coche no sea null y la matricula introducida sea igual que la del vehiculo encontrado (ignorando mayúsculas y minúsculas)
                System.out.println("El coche con numero de matricula " + matricula + " se encuentra en la plaza " + i + ".");
                encontrado = true;      //Esto hace que se detenga la búsqueda, dado que solamente puede haber un coche con la misma matrícula.

            } else {
                System.out.println("No existe ningun coche con tal matricula.");
                i++;        //i sube para pasar al siguiente si no se encuentra un coche.
            }
        }

    }

    public static void concatenarTexto(Coche[] coches) {        //Método para concatenar los nombres de los titulares que coincidan con el texto introducido
        Scanner entrada = new Scanner(System.in);
        String textoConca = "";  //Inicializamos un String auxiliar que usaremos para concatenar con los nombres de los titulares

        int i = 0;                  //Variable i para controlar el flujo

        System.out.println("Introduzca un texto (a ser posible las primeras letras de algun nombre):");
        String texto = entrada.next();

        while (i < coches.length) {

            if (coches[i] != null && coches[i].getTitular().contains(texto.substring(0, texto.length()))) { //Controlamos que el coche no sea null y que el titular contengan el texto o parte del texto (desde el valor 0 hasta el último del String introducido)

                textoConca += (coches[i].getTitular() + "#");       //También podemos usar concat
                i++;

            } else {        //El bucle pasa a la siguiente posición
                i++;
            }

        }
        System.out.println(textoConca);
    }

    public static void cochesAparcados(Coche[] coches) {        //Método para ver los coches aparcados

        System.out.println("Informacion sobre los coches aparcados : ");
        int i = 0;
        while (i < coches.length) {     //Otro modo para mostrar podría ser un for each (for Coche i : coches) Aquí controlamos que i no se pase del final del array
            if (coches[i] != null) {    //Controlamos que el coche no sea null
                System.out.print("[" + "Plaza " + i + ": " + coches[i].toString() + "] ");

                i++;
            } else {            //Se pasa al siguiente valor del array
                i++;
            }

        }

    }

    public static void plazasLibres(Coche[] coches) {
        System.out.println("Plazas de garaje libres: ");
        int i = 0;
        while (i < coches.length) { //Otro modo para mostrar podría ser un for each (for Coche i : coches) Aquí controlamos que i no se pase del final del array
            if (coches[i] == null) { //Controlamos que el coche no sea null para ver solo las plazas libres
                System.out.print("[" + i + "] ");

                i++;
            } else {        //Se pasa al siguiente valor del array
                i++;
            }

        }

    }

    public static void aparcharCoche(Coche[] coches) {
        boolean aparcado = false;       //booleano para controlar que la plaza esté libre
        Scanner entrada = new Scanner(System.in);

        System.out.println("Elija una plaza en la que desee aparcar: ");

        while (!aparcado) {     //Controlamos que la plaza esté libre
            int plaza = entrada.nextInt();
            if (plaza >= 0 && plaza <= 9) {     //Lo primero es controlar que el número almacenado en plaza sea entre 0 y 9 en el array.
                if (coches[plaza] == null) {    //Dentro del primer if, controlamos que la plaza esté libre
                    coches[plaza] = new Coche();        //Si lo está creamos el coche, en cuyo método por defecto hemos introducido los métodos necesarios para inicializar sus valores
                    System.out.println("El coche ha sido aparcado en la plaza " + plaza + ".");
                    aparcado = true;        //El booleano cambia a true, rompiendo el bucle.

                } else {        //Si la plaza no es null, vuelve a repetirse el bucle.
                    System.out.println("Esa plaza ya esta ocupada. Por favor, elija otra.");
                }

            } else {    //El else del primer if, repite el bucle hasta que se introduzca un valor correcto.
                System.out.println("Debe introducir un valor entre 0 y 9.");
            }
        }
    }

    public static void menu(Coche[] coches) {       //Menú con las distintas opciones.
        Scanner entrada = new Scanner(System.in);
        boolean cerrar = false;

        do {
            try {

                System.out.println("1 para aparcar coches.");
                System.out.println("2 para mostrar las plazas de garaje libres.");
                System.out.println("3 para mostrar los coches aparcados.");
                System.out.println("4 para concatenar los nombres de los titulares.");
                System.out.println("5 para buscar coche por matricula.");
                System.out.println("6 para salir del programa.");

                switch (entrada.nextInt()) {
                    case 1:
                        aparcharCoche(coches);
                        break;

                    case 2:
                        plazasLibres(coches);
                        break;

                    case 3:
                        cochesAparcados(coches);
                        break;

                    case 4:
                        concatenarTexto(coches);
                        break;

                    case 5:
                        buscarMatricula(coches);
                        break;

                    case 6:
                        System.out.println("Saliendo del sistema.");
                        cerrar = true;
                        break;
                    default:
                        System.out.println("Opcion incorrecta.");
                        entrada.nextLine();
                }

            } catch (InputMismatchException e) {                    //Atrapamos la excepción para impedir que se introduzcan letras
                System.out.println("ERROR. No se deben introducir letras.");
                entrada.nextLine();
            }
        } while (!cerrar);  //El bucle se ejecutará mientras el booleano sea falso
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here

        Coche[] coches = new Coche[MAX];    //Creamos el array de coches y le asignamos la longitud almacenada en MAX
        menu(coches);   //Implementamos el menu

    }

}
