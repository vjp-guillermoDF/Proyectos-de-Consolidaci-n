/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package tema10ej15;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.InputMismatchException;
import java.util.Iterator;
import java.util.Scanner;

/**
 *
 * @author alumno
 */
public class Tema10ej15 {

    public static void menorAmayorSueldo(ArrayList<Empresa> lista) {
        ArrayList<Empleado> listaux = new ArrayList();
        System.out.println("Lista de empleados ordenados por sueldo de menor a mayor.");
        for (Empresa i : lista) {
            listaux.addAll(i.getEmpleados());
        }
        listaux.sort(Comparator.comparingInt(Empleado::getSueldo));

        for (Empleado j : listaux) {
            System.out.println(j.toString());

        }

    }

    public static void mastrarAmplaadas(ArrayList<Empresa> lista) {
        Iterator<Empresa> it = lista.iterator();

        while (it.hasNext()) {
            Empresa aux = it.next();
            int i = 0;
            while (i < aux.getEmpleados().size()) {
                if (aux.getEmpleados().get(i).getNombre().contains("A") || aux.getEmpleados().get(i).getNombre().contains("a")) {
                    System.out.println(aux.getEmpleados().get(i).toString());

                }
                i++;
            }

        }

    }

    public static void mostrarEmpresas(ArrayList<Empresa> lista) {
        Iterator<Empresa> it = lista.iterator();

        while (it.hasNext()) {
            Empresa aux = it.next();
            System.out.println(aux.toString());

        }

    }

    public static void registrarEmpresa(ArrayList<Empresa> lista) {
        Scanner entrada = new Scanner(System.in);
        boolean cerrar = false;

        System.out.println("Registrando empresa...");
        lista.add(new Empresa());
        System.out.println("Empresa " + lista.getLast().getNombreEmpresa() + " registrado con exito.");
        do {

            System.out.println("¿Desea continuar?");
            String respuesta = entrada.next();
            if (respuesta.equalsIgnoreCase("No")) {
                System.out.println("Saliendo del registro de empresas.");
                cerrar = true;
            } else if (!respuesta.equalsIgnoreCase("No") && !respuesta.equalsIgnoreCase("Si")) {
                System.out.println("La respuesta debe ser si o no.");

            } else if (respuesta.equalsIgnoreCase("Si")) {
                System.out.println("Registrando empresa...");
                lista.add(new Empresa());
            }

        } while (!cerrar);
    }

    public static void menu(ArrayList<Empresa> lista) {
        Scanner entrada = new Scanner(System.in);
        boolean cerrar = false;
        do {
            try {

                System.out.println("1 para registrar empresa con sus empleados.");
                System.out.println("2 para mostrar las empresas registradas junto con sus empleados.");
                System.out.println("3 para mastrar a tadas las amplaadas.");
                System.out.println("4 para mostrar los empleados ordenados en funcion de su sueldo.");
                System.out.println("5 para salir del sistema.");

                switch (entrada.nextInt()) {
                    case 1:
                        registrarEmpresa(lista);
                        break;
                    case 2:
                        mostrarEmpresas(lista);
                        break;
                    case 3:
                        mastrarAmplaadas(lista);
                        break;
                    case 4:
                        menorAmayorSueldo(lista);
                        break;
                    case 5:
                        System.out.println("Saliendo del sistema.");
                        cerrar = true;
                        break;
                    default:
                        System.out.println("Opcion no permitida.");
                }

            } catch (InputMismatchException e) {
                System.out.println("Debe introducir un numero.");
            }
        } while (!cerrar);
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        ArrayList<Empresa> lista = new ArrayList();
        menu(lista);
    }

}
