/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package operaciones;

import java.util.InputMismatchException; // Herramienta para proteger al programa de que el usuario introduzca una letra
import java.util.Scanner;

import static recursos.armas.Arma.generarIDarma;
import recursos.armas.ArmaCortoAlcance;
import recursos.armas.ArmaLargoAlcance;
import recursos.personajes.Policia;
import recursos.personajes.cyborg;

public class menu {

    public static int llamarEscaner() {
        Scanner entrada = new Scanner(System.in);
        return entrada.nextInt();
    }

    /**
     *
     * @author Guillermo Domínguez de la Fuente
     */
    public static void mostrarSubmenuAlmacen() {

        boolean cerrarBucle = true;
        System.out.println("Elija su opcion");
        System.out.println("Pulse 1 para elegir arma");
        System.out.println("Pulse 2 para crear arma");
        System.out.println("Pulse 3 para mostrar arma");
        System.out.println("Pulse 4 para modificar arma");
        System.out.println("Pulse 5 para eliminar arma");
        System.out.println("Pulse 6 para registrar arma");
        System.out.println("Pulse 7 para mostrar el registro de aramas");
        System.out.println("Pulse 8 para regresar al menu principal");

        do {
            switch (llamarEscaner()) {
                case 1:
                    System.out.println("Elegir Arma");
                    break;
                case 2:
                    System.out.println("Crear Arma");

                    break;
                case 3:
                    System.out.println("Mostrar Armas");
                    break;
                case 4:
                    System.out.println("Modificar Arma");
                    break;
                case 5:
                    System.out.println("Eliminar Arma");
                    break;
                case 6:
                    System.out.println("Registrar Arma");
                    break;
                case 7:
                    System.out.println("Mostrar Registro de Armas");
                    break;
                case 8:
                    System.out.println("Volver al menu principal");
                    break;
                default:
                    cerrarBucle = false;

            }
        } while (!cerrarBucle);
    }

    public static void mostrarSubmenuComisaria() {
        System.out.println("Elija su opcion");
        System.out.println("Pulse 1 para elegir policia");
        System.out.println("Pulse 2 para crear policia");
        System.out.println("Pulse 3 para mostrar policia");
        System.out.println("Pulse 4 para modificar policia");
        System.out.println("Pulse 5 para eliminar policia");
        System.out.println("Pulse 6 para ubicar personaje en el plano");
        System.out.println("Pulse 7 para descifrar mensaje");
        System.out.println("Pulse 8 para acceder a los pasatiempos");
        System.out.println("Pulse 9 para registrar policias");
        System.out.println("Pulse 10 para mostrar el registro de policias");
        System.out.println("Pulse 11 para volver al menu principal");
        int opcion = 0;
        switch (opcion) {
            case 1:
                System.out.println("Elegir policía");
                break;
            case 2:
                System.out.println("Crear policía");
                break;
            case 3:
                System.out.println("Mostrar policía");
                break;
            case 4:
                System.out.println("Modificar policía");
                break;
            case 5:
                System.out.println("Eliminar policía");
                break;
            case 6:
                System.out.println("Ubicar personaje en el plano");
                break;
            case 7:
                System.out.println("Descifrar mensaje");
                break;
            case 8:
                System.out.println("Pasatiempos");
                break;
            case 9:
                System.out.println("Registrar policías");
                break;
            case 10:
                System.out.println("Mostrar registro de policías");
                break;
            case 11:
                System.out.println("Volver al menú principal");
                break;
        }
    }

    public static boolean pedirContrasena(boolean acceso) {
       
        acceso = true;
        int contrasena;
        int intento = 3; //Contador de intentos disponibles
        System.out.println("Introduzca la contrasena para el almacen: ");
        do {
            contrasena = 0;
            if (contrasena != password) {
                acceso = false;
                intento--;
                System.out.println("Contrasena incorrecta. Le quedan " + intento + " intento(s)");
                if (intento < 1) {
                    System.out.println("Ha agotado sus intentos");

                }
            } else {
                acceso = true;
                System.out.println("Contrasena correcta. Puede acceder al almacen");
                mostrarSubmenuAlmacen();
            }
        } while (!acceso && intento >= 1);

        return acceso;

    }

    public static void menu() {
        int opcion = 0;
        boolean cerrarBucle = true;

        try {

            do {
                System.out.println("Pulse 1 para entrar al almacen");
                System.out.println("Pulse 2 para entrar a la comisaria");
                System.out.println("Pulse 3 para intervenir en el refugio");
                System.out.println("Pulse 4 para salir");
                switch (llamarEscaner()){
                    case 1:
                        System.out.println("Entrar al Almacen");
                        boolean acceso = true;
                        pedirContrasena(acceso);
                        break;
                    case 2:
                        System.out.println("Entrar a la Comisaria");
                        mostrarSubmenuComisaria();
                        break;
                    case 3:
                        System.out.println("Intervenir en el Refugio");
                        break;
                    case 4:
                        System.out.println("Salir");
                        break;
                    default:
                        cerrarBucle=false;
                }

            } while (!cerrarBucle);
        } catch (InputMismatchException e) {
            System.out.print("Error. Por favor introduzce un numero ");
        }
    }

    static Policia jugador = new Policia((int) (Math.random() * 5000) + 1, "Operaciones", "Armas de largo alcance", "Comisaria", "", "Luna Castillo", 100, 'L', 0, 0, new ArmaLargoAlcance(generarIDarma(), 10, 20, 2000));
    //public static Scanner entrada = new Scanner (System.in);

    public static void main(String[] args) {
        // TODO code application logic here
        menu();
        
        
        ArmaCortoAlcance armaLiberacion = new ArmaCortoAlcance(generarIDarma(), 15, 16, 10);

        cyborg cyborg1 = new cyborg(cyborg.generarID(), "Kai Patel, alias Nexus", 100, 'N', 0, 0, armaLiberacion, "Liderazgo", "Francia");

       

        cyborg cyborg2 = new cyborg(cyborg.generarID(), "Desconocido, alias Siren", 100, 'S', 0, 0, armaLiberacion, "Logistica", "Francia");

       

    }

}
