/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package tema12ej6;

/**
 *
 * @author guill
 */
import java.io.*;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Tema12ej6 {

    public static void main(String[] args) {
        menu();
    }

    public static void menu() {
        Scanner entrada = new Scanner(System.in);
        String nombreFichero = null;
        boolean salir = false;

        while (!salir) {
            try {
                System.out.println("\n--- MENÚ ---");
                System.out.println("1. Crear fichero con 100 primeros números pares");
                System.out.println("2. Mostrar contenido del fichero");
                System.out.println("3. Salir");
                int opcion = entrada.nextInt();
                entrada.nextLine();

                switch (opcion) {
                    case 1:
                        System.out.print("Introduce el nombre del fichero (sin extensión): ");
                        nombreFichero = "C:\\Users\\guill\\Desktop\\" + entrada.nextLine().trim() + ".txt";
                        escribirNumerosPares(nombreFichero);
                        break;
                    case 2:
                        if (nombreFichero == null) {
                            System.out.println("Primero debes crear el fichero en la opción 1.");
                        } else {
                            mostrarContenidoFichero(nombreFichero);
                        }
                        break;
                    case 3:
                        System.out.println("Saliendo del programa...");
                        salir = true;
                        break;
                    default:
                        System.out.println("Opción no válida. Elige 1, 2 o 3.");
                }

            } catch (InputMismatchException e) {
                System.out.println("Error: Debes introducir un número.");
                entrada.nextLine();
            }
        }
    }

    public static void escribirNumerosPares(String nombreFichero) {
        try (PrintWriter pw = new PrintWriter(new FileWriter(nombreFichero))) {
            for (int i = 0; i < 100; i++) {
                pw.println(i * 2);
            }
            System.out.println("Fichero '" + nombreFichero + "' creado con éxito.");
        } catch (IOException e) {
            System.out.println("Error al escribir en el fichero: " + e.getMessage());
        }
    }

    public static void mostrarContenidoFichero(String nombreFichero) {
        File archivo = new File(nombreFichero);

        if (!archivo.exists()) {
            System.out.println("El fichero no existe.");
            return;
        }

        System.out.println("\n--- Contenido de " + nombreFichero + " ---");

        try (BufferedReader br = new BufferedReader(new FileReader(archivo))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                System.out.println(linea);
            }
        } catch (IOException e) {
            System.out.println("Error al leer el fichero: " + e.getMessage());
        }
    }
}
