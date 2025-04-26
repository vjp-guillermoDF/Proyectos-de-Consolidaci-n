/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package tema12ej3;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;

/**
 *
 * @author guill
 */
public class Tema12ej3 {

    /**
     * @param args the command line arguments
     * @throws java.io.IOException
     */
    public static void main(String[] args) throws IOException {
        // TODO code application logic here

        File diasSemana = new File("C:\\Users\\guill\\Desktop\\1DAM\\Programación\\DiasSemana");
        diasSemana.mkdir();

        if (diasSemana.exists()) {

            System.out.println(diasSemana.getName() + " creado con exito.");

            File lunes = new File(diasSemana, "Lunes.txt");
            File martes = new File(diasSemana, "Martes.txt");
            File miercoles = new File(diasSemana, "Miercoles.txt");
            File jueves = new File(diasSemana, "Jueves.txt");
            File viernes = new File(diasSemana, "Viernes.txt");
            File sabado = new File(diasSemana, "Sabado.txt");
            File domingo = new File(diasSemana, "Domingo.txt");

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

    }

}
