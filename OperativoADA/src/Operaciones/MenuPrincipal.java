/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Operaciones;

import General.Constantes;
import General.DescifrarMensajes;
import Recursos.armas.Arma;
import Recursos.armas.ArmaCortoAlcance;
import Recursos.armas.ArmaLargoAlcance;
import Recursos.lugares.Almacen;
import Recursos.lugares.Comisaria;
import Recursos.personajes.Cyborg;
import Recursos.personajes.Policia;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author guill
 */
public class MenuPrincipal {

    public static Policia jugador;
    //Variable global jugador, que almacena al Personaje de subclase Policía LunaCastillo, con sus atributos inicializados y un objeto ArmaLargoAlcance con velocidad, daño y diámetro inicializados. Este objeto ha sido creado e inicializado directamente en el constructor del personaje.
    public static Comisaria comisaria;
    public static Arma armaJugador;
    public static Almacen almacen;

    public static void submenuComisaria() {
        boolean cerrar = false;
        int var3 = 0;
        do {
            System.out.println("Pulse 1 para elegir policia. \nPulse 2 para crear policia. \nPulse 3 para mostrar los policias existentes. \nPulse 4 para modificar policias existentes. \nPulse 5 para eliminar alguno de los policias. \nPulse 6 para ubicar un personaje en el plano. \nPulse 7 para descifrar mensaje. \nPulse 8 para acceder a los pasatiempos. \nPulse 9 para registrar policias. \nPulse 10 para mostrar el registro de policias. \nPulse 11 para regresar al menu principal");

            try {
                switch (llamarEscaner(var3)) {
                    case 1:
                        comisaria.elegirPolicia();
                        break;
                    case 2:
                        comisaria.crearPolicia();
                        break;
                    case 3:
                        comisaria.mostrarPolicias();
                        break;
                    case 4:
                        comisaria.modificarPolicia();
                        break;
                    case 5:
                        comisaria.eliminarPolicia();
                        break;
                    case 6:
                        comisaria.buscarPolicias();
                        break;
                    case 7:
                        System.out.println(DescifrarMensajes.descifrar());
                        break;
                    case 8:

                        break;
                    case 9:

                        break;
                    case 10:

                        break;
                    case 11:
                        cerrar = true;
                        System.out.println("Regresando al menu principal");
                        menuPrincipal();
                        break;

                    default:
                        System.out.println("El numero introducido debe ser entre 1 y 11.");

                        break;
                }
            } catch (InputMismatchException e) {

                System.out.println("ERROR. Debe introducir un numero, y debe ser entre 1 y 11.");

            }

        } while (!cerrar);
    }

    public static void submenuAlmacen() {
        boolean cerrar = false;
        int var2 = 0;
        do {
            System.out.println("Pulse 1 para elegir arma. \nPulse 2 para crear arma. \nPulse 3 para mostrar las armas existentes. \nPulse 4 para modificar las armas. \nPulse 5 para eliminar alguna de las armas. \nPulse 6 para registrar un arma. \nPulse 7 para mostrar el registro de armas. \nPulse 8 para regresar al menu principal.");

            try {

                switch (llamarEscaner(var2)) {
                    case 1:
                        almacen.elegirArma();
                        break;
                    case 2:
                        almacen.crearArma();
                        break;
                    case 3:
                        almacen.mostrarArmas();
                        break;

                    case 4:
                        almacen.modificarArma();
                        break;
                    case 5:
                        almacen.eliminarArma();
                        break;
                    case 6:

                        break;
                    case 7:

                        break;
                    case 8:
                        cerrar = true;
                        System.out.println("Regresando al menu principal");
                        menuPrincipal();
                        break;
                    default:
                        System.out.println("El numero introducido debe ser entre 1 y 8.");

                        break;
                }
            } catch (Exception e) {

                System.out.println("ERROR. Debe introducir un numero, y debe ser entre el 1  y el 8.");

            }

        } while (!cerrar);
    }

    public static void menuPrincipal() {
        boolean cerrar = false;
        int var = 0;

        do {
            System.out.println("Pulse 1 para entrar al almacen. \nPulse 2 para entrar en comisaria. \nPulse 3 para intervenir en el refugio. \nPulse 4 para salir del menu.");

            try {
                switch (llamarEscaner(var)) {
                    case 1:

                        pedirPassword();
                        break;
                    case 2:

                        submenuComisaria();
                        break;
                    case 3:

                        break;
                    case 4:
                        cerrar = true;
                        System.out.println("Sistema finalizado");
                        break;
                    default:
                        System.out.println("El numero introducido debe ser entre 1 y 4.");

                        break;
                }
            } catch (InputMismatchException e) {
                System.out.println("ERROR. Debe introducir un numero.");

            }

        } while (!cerrar);

    }

    public static void pedirPassword() {
        int intentos = 3;
        int numero = 0;
        boolean cerrarBucle = false;
        Constantes contrasena = new Constantes();
        System.out.println("Introduzca la contrasena. Tiene " + intentos + " intentos.");
        do {
            try {

                if (llamarEscaner(numero) == contrasena.getPassword()) {
                    cerrarBucle = true;
                    System.out.println("Contrasena correcta. Puede acceder al almacen");
                    submenuAlmacen();

                } else {

                    intentos--;
                    System.out.println("Contrasena incorrecta. Te quedan " + intentos + " intentos.");
                    if (intentos == 0) {
                        cerrarBucle = true;
                        System.out.println("Se le han agotado los intentos");
                    }

                }
            } catch (Exception e) {
                cerrarBucle = false;
                System.out.println("Debe introducir un numero.");
            }
        } while (!cerrarBucle);
    }

    public static int llamarEscaner(int num) {

        Scanner entrada = new Scanner(System.in);
        num = entrada.nextInt();
        return num;

    }

    public static void main(String[] args) {

        Arma armaLiberacion = new ArmaCortoAlcance(10, 6);  //Arma de subclase ArmaCortoAlcance "ArmaLiberacion" creada en el anterior ejercicio para simular el arma terrorista, aunque no se usa.
        Arma armaLiberacion1 = new ArmaCortoAlcance(10, 12);    //Arma de subclase ArmaCortoAlcance de Kai Patel, creada con diez de alcance y doce de diámetro.
        Arma armaLiberacion2 = new ArmaCortoAlcance(10, 12);    //Arma de subclase ArmaCortoAlcance de Siren, creada con diez de alcance y doce de diámetro.
        Cyborg Kai = new Cyborg("Liderazgo", "Francia", "Kai Patel (Nexus)", 'N', 5, 5, armaLiberacion1);   //Personaje de subclase Cyborg Kai Patel, con sus atributos inicializados y su objeto ArmaCortoAlcance asignado.
        Cyborg Siren = new Cyborg("Logistica", "Francia", "??? (Siren)", 'S', 5, 6, armaLiberacion2);   //Personaje de subclase Cyborg Siren, con sus atributos inicializados y su objeto ArmaCortoAlcance asignado.
        Cyborg Logan = new Cyborg("Explosivos y Armas", "Francia", "Logan", 'V', 5, 5, new ArmaCortoAlcance()); //Creamos al personaje Logan tal como vimos en los mensajes cifrados, le asignamos un arma por defecto
        jugador = new Policia("Operaciones", "Armas Largo Alcance", "Comisaria", "Luna Castillo", 'L', 8, 6, new ArmaLargoAlcance(2000, 10, 20)); //Personaje de subclase Policía LunaCastillo, almacenado en la variable global jugador.
        comisaria = new Comisaria();
        almacen = new Almacen();

        menuPrincipal();

        /* Dejamos la simulación anterior como comentario para esta entrega 
        
        Kai.getArma().apuntar(jugador);    //Llamamos al método apuntar desde el getter del arma de Kai, y le damos por parámetro al personaje LunaCastillo.
        for (int i = 0; i < 3; i++) {   //Usamos un bucle for para llamar al método disparar tres veces a Luna Castillo.
            Kai.getArma().disparar(jugador);
        }

        jugador.esquivar();    
        jugador.defender();

        jugador.getArma().apuntar(Kai);    //Llamamos al método apuntar desde el getter del arma de LunaCastillo, y le damos por parámetro al personaje Kai.
        for (int i = 0; i < 10; i++) {  //Usamos un bucle for para llamar 10 veces al método disparar desde el getter del arma para LunaCastillo y le damos por parámetro al personaje Kai.
            jugador.getArma().disparar(Kai);
        }
        jugador.getArma().apuntar(Siren);      //Llamamos al método apuntar desde el getter del arma de LunaCastillo, y le damos por parámetro al personaje Siren.
        for (int i = 0; i < 3; i++) {   //Usamos un bucle for para llamar 3 veces al método disparar desde el getter del arma para LunaCastillo y le damos por parámetro al personaje Siren.
            jugador.getArma().disparar(Siren);
        }
        Siren.esquivar();     
        Siren.defender();
         
        Kai.atacar(jugador); //Implementamos los métodos tal como se nos pide en el enunciado.
        jugador.esquivar();
        jugador.defender();

        for (int i = 0; i < 4; i++) {
            jugador.atacar(Kai);
        }

        jugador.atacar(Siren);
        Siren.esquivar();
        Siren.defender();

        LA CLASE DESCIFRAR MENSAJES TIENE SU PROPIO MAIN, POR ESO NO LA LLAMAMOS AQUÍ
         */
    }
}
