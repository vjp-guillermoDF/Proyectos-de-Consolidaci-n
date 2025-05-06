/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package tema12ej5;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author guill
 */
public class Tema12ej5 {

    public static void mostrarDocumento() {
        File archivo = new File("C:\\Users\\guill\\Desktop\\1DAM\\Programación\\agenda.txt");

        if (!archivo.exists()) {
            System.out.println("No hay contactos guardados aún.");
            return;
        }

        System.out.println("\n--- Contactos guardados ---");
        System.out.println("");

        try (BufferedReader br = new BufferedReader(new FileReader(archivo))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                System.out.println(linea);
            }
        } catch (IOException e) {
            System.out.println("Error al leer el archivo: " + e.getMessage());
        }
    }

    public static void anadirContacto() {
        Scanner entrada = new Scanner(System.in);

        System.out.println("Nombre del contacto: ");
        String nombre = entrada.nextLine();

        System.out.println("Edad: ");
        int edad = entrada.nextInt();
        entrada.nextLine();

        System.out.println("Número de teléfono: ");
        String telefono = entrada.nextLine();

        try (FileWriter fw = new FileWriter("C:\\Users\\guill\\Desktop\\1DAM\\Programación\\agenda.txt", true);
            PrintWriter pw = new PrintWriter(fw)) {

            pw.println(nombre + " | Edad: " + edad + " | Tel: " + telefono);
            System.out.println("Contacto añadido con éxito.");

        } catch (IOException e) {
            System.out.println("Error de entrada/salida al guardar el contacto.");
            System.out.println(e.getMessage());
        }
    }

    public static void menu() {

        Scanner entrada = new Scanner(System.in);
        boolean cerrar = false;

        do {
            try {
                System.out.println("1 para añadir un contacto a un fichero de texto.");
                System.out.println("2 para mostrar el contenido del fichero.");
                System.out.println("3 para salir del sistema.");

                switch (entrada.nextInt()) {
                    case 1:
                        anadirContacto();
                        break;
                    case 2:
                        mostrarDocumento();
                        break;
                    case 3:
                        System.out.println("Saliendo del sistema.");

                        cerrar = true;
                        break;
                    default:
                        System.out.println("Opcion no permitida.");
                }

            } catch (InputMismatchException e) {
                System.out.println("Se debe introducir un número.");
                entrada.nextLine();
            }

        } while (!cerrar);

    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        menu();

    }

}
