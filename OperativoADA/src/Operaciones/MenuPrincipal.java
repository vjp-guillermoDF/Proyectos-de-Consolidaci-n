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
    public static Comisaria comisaria;      //Variable global de tipo Comisaria  que inicializaremos más tarde
    public static Almacen almacen;  //Variable global de tipo Almacen que inicializaremos más tarde

    public static void submenuComisaria() {
        Scanner entrada = new Scanner(System.in);
        boolean cerrar = false;

        do {
            System.out.println(Constantes.AZUL + "* * * * * * * * * * * * *");
            System.out.println(Constantes.AZUL + "*       COMISARIA       *");
            System.out.println(Constantes.AZUL + "* * * * * * * * * * * * *" + Constantes.BORRAR);
            System.out.println();
            System.out.println("Pulse 1 para elegir policia. \nPulse 2 para crear policia. \nPulse 3 para mostrar los policias existentes. \nPulse 4 para modificar policias existentes. \nPulse 5 para eliminar alguno de los policias. \nPulse 6 para ubicar un personaje en el plano. \nPulse 7 para descifrar mensaje. \nPulse 8 para acceder a los pasatiempos. \nPulse 9 para registrar policias. \nPulse 10 para mostrar el registro de policias. \nPulse 11 para regresar al menu principal");

            try {
                switch (entrada.nextInt()) {
                    case 1:
                        jugador = comisaria.elegirPolicia();
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
                        System.out.println(Constantes.AMARILLO + "El numero introducido debe ser entre 1 y 11." + Constantes.BORRAR);

                        break;
                }
            } catch (InputMismatchException e) {

                System.out.println(Constantes.ROJO + "ERROR. Debe introducir un numero." + Constantes.BORRAR);

            }

        } while (!cerrar);
    }

    public static void submenuAlmacen() {
        Scanner entrada = new Scanner(System.in);
        boolean cerrar = false;
        do {
            System.out.println(Constantes.CELESTE + "* * * * * * * * * * * * *");
            System.out.println(Constantes.CELESTE + "*        ALMACEN        *");
            System.out.println(Constantes.CELESTE + "* * * * * * * * * * * * *" + Constantes.BORRAR);
            System.out.println("");
            System.out.println("Pulse 1 para elegir arma. \nPulse 2 para crear arma. \nPulse 3 para mostrar las armas existentes. \nPulse 4 para modificar las armas. \nPulse 5 para eliminar alguna de las armas. \nPulse 6 para registrar un arma. \nPulse 7 para mostrar el registro de armas. \nPulse 8 para regresar al menu principal.");

            try {

                switch (entrada.nextInt()) {
                    case 1:     //Hemos añadido un control especial para poder asignar solamente un arma que coincida con el permiso de armas del jugador
                        if (jugador != null) {      //Si hay algún policía almacenado en la variable global jugador, comenzamos el proceso de selección de arma
                            Arma armaJugador = almacen.elegirArma();        //Inicializamos una variable de tipo arma con el objeto que nos devuelva el método elegirArma() en la variable global almacem

                            String permisoJug = jugador.getPermisoArma();   //Inicializamos una variable String con el permiso del jugador actual

                            boolean armaAdecuada = (armaJugador instanceof ArmaCortoAlcance && permisoJug.equals("Corto Alcance") || armaJugador instanceof ArmaLargoAlcance && permisoJug.equals("Largo Alcance"));
                            //Valor booleano que almacena como condiciones que el permiso de arma del jugador coincida con el arma elegida anteriormente.
                            
                            if (!almacen.getArmas().isEmpty() && armaAdecuada) {        //Si el permiso de arma coincide con el tipo de arma elegida, se la asignamos al jugador.

                                System.out.println(Constantes.FONDO_VERDE + "[v] ¡Hecho! Tu jugador lleva el arma con el identificador " + armaJugador.getIdentificador() + "." + Constantes.BORRAR);
                                jugador.setArma(armaJugador);

                            } else if (almacen.getArmas().isEmpty() && !armaAdecuada) {     //Si el permiso de arma no coincide con el tipo de arma elegida, no se la asignamos e imprimimos una advetencia.
                                System.out.println(Constantes.AMARILLO + "Advertencia: Tu jugador tiene un permiso de armas de " + permisoJug + " y no es compatible con ese arma. Cambie su permiso o elija otra.");
                            }
                        } else {        //Nos guardamos de NullPointerException en el caso de tratar de elegir armas cuando aún no controlamos a ningún personaje
                            System.out.println(Constantes.FONDO_ROJO + "[x] No hay policias en la unidad a los que asignar arma." + Constantes.BORRAR);
                        }

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
                        System.out.println(Constantes.AMARILLO + "El numero introducido debe ser entre 1 y 8." + Constantes.BORRAR);

                        break;
                }

            } catch (InputMismatchException e) {

                System.out.println(Constantes.ROJO + "ERROR. Debe introducir un numero." + Constantes.BORRAR);

            }

        } while (!cerrar);
    }

    public static void menuPrincipal() {
        Scanner entrada = new Scanner(System.in);
        boolean cerrar = false;

        do {

            System.out.println(Constantes.MAGENTA + "Pulse 1 para entrar al almacen." + Constantes.BORRAR);
            System.out.println(Constantes.MAGENTA + "Pulse 2 para entrar en comisaria." + Constantes.BORRAR);
            System.out.println(Constantes.MAGENTA + "Pulse 3 para intervenir en el refugio." + Constantes.BORRAR);
            System.out.println(Constantes.MAGENTA + "Pulse 4 para salir del menu." + Constantes.BORRAR);

            try {
                switch (entrada.nextInt()) {
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
                        System.out.println(Constantes.AMARILLO + "El numero introducido debe ser entre 1 y 4." + Constantes.BORRAR);

                        break;
                }
            } catch (InputMismatchException e) {
                System.out.println(Constantes.ROJO + "ERROR. Debe introducir un numero." + Constantes.BORRAR);

            }

        } while (!cerrar);

    }

    public static void pedirPassword() {
        Scanner entrada = new Scanner(System.in);
        int intentos = 3;
        int numero;
        boolean cerrarBucle = false;
        Constantes contrasena = new Constantes();
        System.out.println("Introduzca la contrasena. Tiene " + intentos + " intentos.");
        do {
            try {
                numero = entrada.nextInt();

                if (numero == contrasena.getPassword()) {
                    cerrarBucle = true;
                    System.out.println("Contrasena correcta. Puede acceder al almacen.");

                    submenuAlmacen();

                } else {

                    intentos--;
                    if (intentos >= 1) {
                        System.out.println(Constantes.FONDO_AMARILLO + "Contrasena incorrecta. Quedan " + intentos + " intentos." + Constantes.BORRAR);

                    } else {

                        cerrarBucle = true;
                        System.out.println(Constantes.FONDO_ROJO + "Se han agotado los intentos." + Constantes.BORRAR);

                    }
                }

            } catch (InputMismatchException e) {
                System.out.println(Constantes.ROJO + "ERROR. Debe introducir un numero." + Constantes.BORRAR);
            }
        } while (!cerrarBucle);
    }

    public static void main(String[] args) {

        Arma armaLiberacion = new ArmaCortoAlcance(10, 6);  //Arma de subclase ArmaCortoAlcance "ArmaLiberacion" creada en el anterior ejercicio para simular el arma terrorista, aunque no se usa.
        Arma armaLiberacion1 = new ArmaCortoAlcance(10, 12);    //Arma de subclase ArmaCortoAlcance de Kai Patel, creada con diez de alcance y doce de diámetro.
        Arma armaLiberacion2 = new ArmaCortoAlcance(10, 12);    //Arma de subclase ArmaCortoAlcance de Siren, creada con diez de alcance y doce de diámetro.
        Cyborg Kai = new Cyborg("Liderazgo", "Francia", "Kai Patel (Nexus)", 'N', 5, 5, armaLiberacion1);   //Personaje de subclase Cyborg Kai Patel, con sus atributos inicializados y su objeto ArmaCortoAlcance asignado.
        Cyborg Siren = new Cyborg("Logistica", "Francia", "??? (Siren)", 'S', 5, 6, armaLiberacion2);   //Personaje de subclase Cyborg Siren, con sus atributos inicializados y su objeto ArmaCortoAlcance asignado.
        Cyborg Logan = new Cyborg("Explosivos y Armas", "Francia", "Logan", 'V', 5, 5, new ArmaCortoAlcance()); //Creamos al personaje Logan tal como vimos en los mensajes cifrados, le asignamos un arma por defecto

        comisaria = new Comisaria();        //Inicializamos la variable global comisaria en el main
        almacen = new Almacen();          //Inicializamos la variable global almacen en el main

        menuPrincipal();

        /* Dejamos la simulación anterior como comentario para esta entrega 
                //Policia Luna = new Policia("Operaciones", "Largo Alcance", "Comisaria", "Luna Castillo", 'L', 8, 6, new ArmaLargoAlcance(2000, 10, 20)); //Personaje de subclase Policía LunaCastillo, almacenado en la variable global jugador.

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
