/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package tema12ej2;

import java.io.File;
import java.io.IOException;

/**
 *
 * @author guill
 */
public class Tema12ej2 {

    public static void renombrarYEliminar(File ejemplo, File practica1, File practica2) {

        if (ejemplo.exists()) {

            if (practica1.exists()) {
                System.out.println("Se procedera a renombrar el archivo " + practica1.getName() + ".");
                String nuevoNombre = "renombrado.txt";
                if (practica1.renameTo(new File(ejemplo, nuevoNombre))) {
                    System.out.println("Archivo renombrado con exito. Nuevo nombre: " + nuevoNombre + ".");
                } else {

                    System.out.println("No se ha podido renombrar el archivo " + practica1.getName() + ".");

                }

            } else {
                System.out.println("No existe el archivo practica1");
            }

            if (practica2.exists()) {
                System.out.println("Se procedera a eliminar el archivo " + practica2.getName() + ".");
                if (practica2.delete()) {

                    System.out.println("Archivo eliminado con exito.");
                } else {
                    System.out.println("No se ha podido eliminar el archivo.");
                }

            } else {
                System.out.println("No existe el archivo practica2");
            }

        } else {
            System.out.println("No existe ningún directorio.");
        }
    }

    public static File crearPractica2(File ejemplo) {

        File practica2 = null;

        if (ejemplo.exists()) {

            practica2 = new File(ejemplo, "practica2.txt");

            try {
                if (practica2.createNewFile()) {
                    System.out.println(practica2.getName() + " creado con exito.");

                    System.out.println("Ruta relativa: " + practica2.getPath());
                    System.out.println("Ruta absoluta: " + practica2.getAbsolutePath());
                    System.out.println("Se puede escribir: " + practica2.canWrite());
                    System.out.println("Se puede leer: " + practica2.canRead());
                    System.out.println("Tamaño: " + practica2.length());
                    System.out.println("Es un fichero: " + practica2.isFile());

                } else {
                    System.out.println("Error. No se ha podido crear el archivo " + practica2.getName() + ".");
                }

            } catch (IOException e) {
                System.out.println(e.getMessage());

            }

        } else {
            System.out.println("No existe ningún directorio.");

        }
        return practica2;

    }

    public static File crearPractica1(File ejemplo) throws IOException {
        File practica1 = null;

        if (ejemplo.exists()) {

            practica1 = new File(ejemplo, "practica1.txt");

            if (practica1.createNewFile()) {
                System.out.println(practica1.getName() + " creado con exito.");

                System.out.println("Ruta relativa: " + practica1.getPath());
                System.out.println("Ruta absoluta: " + practica1.getAbsolutePath());
                System.out.println("Se puede escribir: " + practica1.canWrite());
                System.out.println("Se puede leer: " + practica1.canRead());
                System.out.println("Tamaño: " + practica1.length());
                System.out.println("Es un fichero: " + practica1.isFile());

            } else {
                throw new IOException("Error. No se ha podido crear el archivo " + practica1.getName() + ".");
            }

        } else {
            System.out.println("No existe ningún directorio.");

        }
        return practica1;
    }

    public static File crearDirectorio() throws IOException {

        File ejemplo = new File("C:\\Users\\guill\\Desktop\\1DAM\\Programación\\ejemplo");
        ejemplo.mkdir();

        if (ejemplo.exists()) {

            System.out.println("Directorio " + ejemplo.getName() + " creado con exito.");

            System.out.println("Ruta relativa: " + ejemplo.getPath());
            System.out.println("Ruta absoluta: " + ejemplo.getAbsolutePath());
            System.out.println("Se puede escribir: " + ejemplo.canWrite());
            System.out.println("Se puede leer: " + ejemplo.canRead());
            System.out.println("Tamaño: " + ejemplo.length());
            System.out.println("Es un directorio: " + ejemplo.isDirectory());

        } else {
            throw new IOException("Error. No se ha podido crear el directorio.");
        }

        return ejemplo;

    }

    /**
     * @param args the command line arguments
     * @throws java.io.IOException
     */
    public static void main(String[] args) throws IOException {
        // TODO code application logic here
        File ejemplo = crearDirectorio();
        File practica1 = crearPractica1(ejemplo);
        File practica2 = crearPractica2(ejemplo);
        renombrarYEliminar(ejemplo, practica1, practica2);

    }

}
