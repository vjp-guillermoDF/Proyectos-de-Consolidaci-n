/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package tema11ej3;

import java.util.InputMismatchException;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;

/**
 *
 * @author guill
 */
public class Tema11ej3 {

    public static final int MAX = 6;

    public static String masConductores(Autobus[] estacion) {
        int i = 0;
        Autobus aux = new Autobus();
        String masLleno = "";
        while (i < estacion.length) {
            if (estacion[i] != null && estacion[i].getConductor().size() > aux.getConductor().size()) {
                aux = estacion[i];
                masLleno = aux.getMatricula() + ". " + aux.getConductor();
            } else if (estacion[i] != null && estacion[i].getConductor().size() == aux.getConductor().size()) {
                masLleno += estacion[i].getMatricula() + ". " + estacion[i].getConductor();
            }
            i++;
        }
        return "El autobus o autobuses con mas conductores son: " + masLleno;

    }

    public static void buscarConductor(Autobus[] estacion) {
        Scanner entrada = new Scanner(System.in);
        boolean enc = false;
        int i = 0;
        Conductor aux = new Conductor();
        System.out.println("Escriba el DNI del conductor que desee encontrar: ");
        String dni = entrada.next();
        while (!enc && i < estacion.length) {

            if (estacion[i] != null) {
                Iterator it = estacion[i].getConductor().keySet().iterator();

                while (it.hasNext()) {
                    String clave = (String) it.next();
                    aux = estacion[i].getConductor().get(clave);
                    if (dni.equalsIgnoreCase(aux.getDNI())) {
                        enc = true;

                    }
                }

            }
            if (!enc) {
                i++;
            }
        }

        if (enc) {
            System.out.println(aux.toString() + " Autobús asignado: " + estacion[i].getMatricula() + ". Aparcado en la estacion: " + i + ".");
        } else {
            System.out.println("No se ha encontrado ningún conductor con ese DNI.");
        }
    }

    public static void buscarAutobus(Autobus[] estacion) {
        Scanner entrada = new Scanner(System.in);
        boolean enc = false;
        int i = 0;
        System.out.println("Escriba la matrícula del autobus que desee encontrar: ");
        String mat = entrada.next();
        while (!enc) {
            if (estacion[i] != null && mat.contains(estacion[i].getMatricula())) {

                enc = true;

            } else {
                i++;
            }

        }
        if (enc) {
            System.out.println("Autobus " + estacion[i].getMatricula() + " se encuentra en la plaza " + i + ". Conductores: " + estacion[i].getConductor());
        } else {
            System.out.println("No exiten autobuses con esa matricula.");
        }

    }

    public static void darsenasLibres(Autobus[] estacion) {
        int i = 0;
        System.out.println("Darsenas disponibles: ");
        while (i < estacion.length) {
            if (estacion[i] == null) {
                System.out.println("Darsena " + i + ".");

            }
            i++;
        }

    }

    public static void aparcar(Autobus[] estacion) {
        Scanner entrada = new Scanner(System.in);
        boolean cerrar = false;
        do {

            System.out.println("Elija la plaza en que desee aparcar, del 0 al 5: ");
            int plaza = (entrada.nextInt());
            if (plaza >= 0 && plaza <= 5) {
                if (estacion[plaza] != null) {
                    System.out.println("Esa plaza ya está ocupada.");
                } else {
                    estacion[plaza] = new Autobus(pedirMatricula());
                    System.out.println("Autobus " + estacion[plaza].getMatricula() + " registrado con exito en la plaza " + plaza + ". Conductores: " + estacion[plaza].getConductor());
                    cerrar = true;
                }

            } else {
                System.out.println("Opcion no disponible.");

            }

        } while (!cerrar);
    }

    public static void menu(Autobus[] estacion) {
        Scanner entrada = new Scanner(System.in);
        boolean cerrar = false;
        do {

            System.out.println("1 para aparcar un autobus.");
            System.out.println("2 para mostrar las darsenas libres.");
            System.out.println("3 para buscar un autobus.");
            System.out.println("4 para buscar un conductor.");
            System.out.println("5 para localizar al autobus con mayor cantidad de conductores.");
            System.out.println("6 para salir del programa.");

            try {

                switch (entrada.nextInt()) {
                    case 1:
                        aparcar(estacion);
                        break;

                    case 2:
                        darsenasLibres(estacion);
                        break;

                    case 3:
                        buscarAutobus(estacion);
                        break;

                    case 4:
                        buscarConductor(estacion);
                        break;

                    case 5:
                        System.out.println(masConductores(estacion));
                        break;
                    case 6:
                        System.out.println("Saliendo del sistema.");
                        cerrar = true;
                        break;

                    default:
                        System.out.println("Opcion incorrecta.");

                }

            } catch (InputMismatchException e) {

                System.out.println("Introduzca un numero.");
                entrada.next();

            }

        } while (!cerrar);
    }

    public static String pedirMatricula() {
        Scanner entrada = new Scanner(System.in);
        System.out.println("Introduzca la matricula del autobus: ");
        String matricula = entrada.next();
        return matricula;

    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Autobus[] estacion = new Autobus[MAX];
        menu(estacion);

    }

}
