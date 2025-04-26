/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package tema12ej4;

import java.io.File;
import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author guill
 */
public class Tema12ej4 {

    public static File crearDirectorio() throws IOException {
        Scanner entrada = new Scanner(System.in);
        boolean cerrar = false;
        File diasSemana = new File("C:\\Users\\guill\\Desktop\\1DAM\\Programación\\DiasSemana");

        diasSemana.mkdir();

        if (diasSemana.exists()) {

            System.out.println(diasSemana.getName() + " creado con exito.");

            File lunes = null;
            File martes = null;
            File miercoles = null;
            File jueves = null;
            File viernes = null;
            File sabado = null;
            File domingo = null;

            do {
                try {
                    System.out.println("Pulse 1 para crear los archivos en formato txt.");
                    System.out.println("Pulse 2 para crear los archivos en formato dat.");
                    System.out.println("Pulse 3 para crear los archivos en formato bin.");
                    System.out.println("Pulse 4 para crear los archivos en formato mp3.");

                    switch (entrada.nextInt()) {
                        case 1:

                            lunes = new File(diasSemana, "Lunes.txt");
                            martes = new File(diasSemana, "Martes.txt");
                            miercoles = new File(diasSemana, "Miercoles.txt");
                            jueves = new File(diasSemana, "Jueves.txt");
                            viernes = new File(diasSemana, "Viernes.txt");
                            sabado = new File(diasSemana, "Sabado.txt");
                            domingo = new File(diasSemana, "Domingo.txt");
                            cerrar = true;

                            break;
                        case 2:
                            lunes = new File(diasSemana, "Lunes.dat");
                            martes = new File(diasSemana, "Martes.dat");
                            miercoles = new File(diasSemana, "Miercoles.dat");
                            jueves = new File(diasSemana, "Jueves.dat");
                            viernes = new File(diasSemana, "Viernes.dat");
                            sabado = new File(diasSemana, "Sabado.dat");
                            domingo = new File(diasSemana, "Domingo.dat");
                            cerrar = true;

                            break;
                        case 3:

                            lunes = new File(diasSemana, "Lunes.bin");
                            martes = new File(diasSemana, "Martes.bin");
                            miercoles = new File(diasSemana, "Miercoles.bin");
                            jueves = new File(diasSemana, "Jueves.bin");
                            viernes = new File(diasSemana, "Viernes.bin");
                            sabado = new File(diasSemana, "Sabado.bin");
                            domingo = new File(diasSemana, "Domingo.bin");
                            cerrar = true;

                            break;
                        case 4:

                            lunes = new File(diasSemana, "Lunes.mp3");
                            martes = new File(diasSemana, "Martes.mp3");
                            miercoles = new File(diasSemana, "Miercoles.mp3");
                            jueves = new File(diasSemana, "Jueves.mp3");
                            viernes = new File(diasSemana, "Viernes.mp3");
                            sabado = new File(diasSemana, "Sabado.mp3");
                            domingo = new File(diasSemana, "Domingo.mp3");
                            cerrar = true;

                            break;

                        default:
                            System.out.println("Opcion no permitida.");

                    }
                } catch (InputMismatchException e) {
                    System.out.println("Error. Debe introducir un numero.");
                    entrada.next();

                }

            } while (!cerrar);

            if (lunes.createNewFile()) {
                System.out.println(lunes.getName() + " creado con exito.");
            } else {
                throw new IOException("No se ha podido crear el archivo " + lunes.getName() + ".");

            }
            if (martes.createNewFile()) {
                System.out.println(martes.getName() + " creado con exito.");
            } else {
                throw new IOException("No se ha podido crear el archivo " + martes.getName() + ".");

            }
            if (miercoles.createNewFile()) {
                System.out.println(miercoles.getName() + " creado con exito.");
            } else {
                throw new IOException("No se ha podido crear el archivo " + miercoles.getName() + ".");

            }
            if (jueves.createNewFile()) {
                System.out.println(jueves.getName() + " creado con exito.");
            } else {
                throw new IOException("No se ha podido crear el archivo " + jueves.getName() + ".");

            }
            if (viernes.createNewFile()) {
                System.out.println(viernes.getName() + " creado con exito.");
            } else {
                throw new IOException("No se ha podido crear el archivo " + viernes.getName() + ".");

            }
            if (sabado.createNewFile()) {
                System.out.println(sabado.getName() + " creado con exito.");
            } else {
                throw new IOException("No se ha podido crear el archivo " + sabado.getName() + ".");

            }
            if (domingo.createNewFile()) {
                System.out.println(domingo.getName() + " creado con exito.");
            } else {
                throw new IOException("No se ha podido crear el archivo " + domingo.getName() + ".");

            }

            File[] archivos = diasSemana.listFiles();

            System.out.println("Numero de archivos en el directorio " + diasSemana.getName() + ": " + archivos.length + ".");

            System.out.println(lunes.toString());

            System.out.println(martes.toString());

            System.out.println(miercoles.toString());

            System.out.println(jueves.toString());

            System.out.println(viernes.toString());

            System.out.println(sabado.toString());

            System.out.println(domingo.toString());

        } else {
            throw new IOException("No se ha podido crear el directorio " + diasSemana.getName() + ".");
        }

        return diasSemana;
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        // TODO code application logic here
        File diasSemana = crearDirectorio();
    }

}
