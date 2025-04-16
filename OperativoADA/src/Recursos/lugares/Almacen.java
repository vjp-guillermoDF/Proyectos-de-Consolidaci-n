/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Recursos.lugares;

import General.Constantes;
import Operaciones.MenuPrincipal;
import Recursos.armas.Arma;
import Recursos.armas.ArmaCortoAlcance;
import Recursos.armas.ArmaLargoAlcance;
import Recursos.armas.Bala;
import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;

/**
 *
 * @author guill
 */
public class Almacen {

    private Map<String, Arma> armas;

    public Almacen() {
        this.armas = new HashMap();
    }

    public Almacen(Map<String, Arma> armas) {
        this.armas = armas;
    }

    public Map<String, Arma> getArmas() {
        return armas;
    }

    public void setArmas(Map<String, Arma> armas) {
        this.armas = armas;
    }

    @Override
    public String toString() {
        return "Almacen{" + "armas=" + armas + '}';
    }

    public void elegirArma() {

        Scanner entrada = new Scanner(System.in);
        boolean enc = false;

        if (armas.isEmpty()) {
            System.out.println(Constantes.FONDO_ROJO + "[x] No hay armas en el almacen." + Constantes.BORRAR);
        } else {

            System.out.println("Escribe el identificador del arma: ");
            String respuesta = entrada.next();
            Iterator it = armas.keySet().iterator();

            while (!enc && it.hasNext()) {
                String clave = (String) it.next();
                Arma aux = armas.get(clave);

                if (respuesta.equalsIgnoreCase(aux.getIdentificador())) {
                    System.out.println(Constantes.FONDO_VERDE + "[v] Arma encontrada" + Constantes.BORRAR);
                    MenuPrincipal.jugador.setArma(aux);
                    System.out.println(Constantes.FONDO_VERDE + "[v] ¡Hecho! Tu jugador lleva el arma con el identificador " + aux.getIdentificador() + Constantes.BORRAR);
                    enc = true;

                }

            }

            if (!enc) {
                System.out.println("Arma no encontrada");
            }
        }
    }

    public void eliminarArma() {
        Scanner entrada = new Scanner(System.in);
        boolean enc = false;
        System.out.println(Constantes.FONDO_ROJO + "[*] [*] [*] Eliminando arma... [*] [*] [*] " + Constantes.BORRAR);
        if (armas.isEmpty()) {
            System.out.println(Constantes.FONDO_ROJO + "[x] No hay armas en el almacen." + Constantes.BORRAR);
        } else {

            System.out.println("Escribe el identificador del arma: ");
            String respuesta = entrada.next();
            Iterator it = armas.keySet().iterator();

            while (!enc && it.hasNext()) {
                String clave = (String) it.next();
                Arma aux = armas.get(clave);

                if (respuesta.equalsIgnoreCase(aux.getIdentificador())) {
                    System.out.println(Constantes.FONDO_VERDE + "[v] Arma encontrada" + Constantes.BORRAR);
                    System.out.println(Constantes.FONDO_VERDE + "[v] Arma eliminada" + Constantes.BORRAR);
                    armas.remove(aux.getIdentificador(), aux);
                    enc = true;

                }

            }

            if (!enc) {
                System.out.println("Arma no encontrada");
            }
        }
    }

    public void buscarArma() {
        Scanner entrada = new Scanner(System.in);
        boolean enc = false;

        if (armas.isEmpty()) {
            System.out.println(Constantes.FONDO_ROJO + "[x] No hay armas en el almacen." + Constantes.BORRAR);
        } else {

            System.out.println("Escribe el identificador del arma: ");
            String respuesta = entrada.next();
            Iterator it = armas.keySet().iterator();

            while (!enc && it.hasNext()) {
                String clave = (String) it.next();
                Arma aux = armas.get(clave);

                if (respuesta.equalsIgnoreCase(aux.getIdentificador())) {
                    enc = true;
                    System.out.println("[v] Arma encontrada");

                    if (aux instanceof ArmaCortoAlcance) {
                        System.out.println("Arma de corto alcance - ID:" + aux.getIdentificador());
                    } else if (aux instanceof ArmaLargoAlcance) {
                        System.out.println("Arma de largo alcance - ID:" + aux.getIdentificador());
                    }

                    System.out.println("Daño: " + aux.getDaño());
                    System.out.println("Diámetro bala: " + aux.getDiametro());
                    System.out.println("Tamaño cargador: " + aux.getCargador().length);

                    int contador = 0;
                    int i;

                    for (i = 0; i < aux.getCargador().length; i++) {
                        if (aux.getCargador()[i] != null) {
                            contador++;
                        }
                        i++;
                    }

                    System.out.println("Nº balas: " + contador);

                    if (aux instanceof ArmaCortoAlcance) {
                        System.out.println("Alcance:" + ((ArmaCortoAlcance) aux).getAlcance());
                    } else if (aux instanceof ArmaLargoAlcance) {
                        System.out.println("Velocidad: " + ((ArmaLargoAlcance) aux).getVelocidad());
                    }

                }
                if (!enc) {
                    System.out.println("Arma no encontrada");
                }

            }
        }
    }

    public void modificarArma() {

        Scanner entrada = new Scanner(System.in);
        boolean enc = false;
        if (armas.isEmpty()) {
            System.out.println(Constantes.FONDO_ROJO + "[x] No hay armas en el almacen." + Constantes.BORRAR);
        } else {

            System.out.println("Escribe el identificador del arma: ");
            String respuesta = entrada.next();
            Iterator it = armas.keySet().iterator();

            while (!enc && it.hasNext()) {
                String clave = (String) it.next();
                Arma aux = armas.get(clave);

                if (respuesta.equalsIgnoreCase(aux.getIdentificador())) {
                    enc = true;
                    System.out.println(Constantes.FONDO_VERDE + "[v] Arma encontrada" + Constantes.BORRAR);

                    if (aux instanceof ArmaCortoAlcance) {
                        modificarArmaCortoAlcance(aux);
                    } else {
                        modificarArmaLargoAlcance(aux);
                    }

                }
                if (!enc) {
                    System.out.println("Arma no encontrada");
                }

            }
        }

    }

    public void modificarArmaLargoAlcance(Arma arma) {
        Scanner entrada = new Scanner(System.in);
        System.out.println("¿Qué atributo quieres modificar?");
        System.out.println("[1] Numero de balas del cartucho");
        System.out.println("[2] Diametro de bala");
        System.out.println("[3] Alcance");
        try {
            switch (entrada.nextInt()) {
                case 1:
                    arma.setCargador(pedirTamañoCargador());
                    System.out.println(Constantes.FONDO_VERDE + "[v] Arma modificada" + Constantes.BORRAR);

                    break;
                case 2:
                    arma.setDiametro(pedirDiametro());
                    System.out.println(Constantes.FONDO_VERDE + "[v] Arma modificada" + Constantes.BORRAR);

                    break;

                case 3:
                    ((ArmaLargoAlcance) arma).setVelocidad(pedirVelocidad());
                    System.out.println(Constantes.FONDO_VERDE + "[v] Arma modificada" + Constantes.BORRAR);

                    break;
                default:
                    System.out.println("Opcion no permitida");
            }

        } catch (InputMismatchException e) {
            System.out.println("Error. Debes introducir un numero.");
        }
    }

    public void modificarArmaCortoAlcance(Arma arma) {
        Scanner entrada = new Scanner(System.in);
        System.out.println("¿Qué atributo quieres modificar?");
        System.out.println("[1] Numero de balas del cartucho");
        System.out.println("[2] Diametro de bala");
        System.out.println("[3] Alcance");
        try {
            switch (entrada.nextInt()) {
                case 1:
                    arma.setCargador(pedirTamañoCargador());
                    System.out.println(Constantes.FONDO_VERDE + "[v] Arma modificada" + Constantes.BORRAR);

                    break;
                case 2:
                    arma.setDiametro(pedirDiametro());
                    System.out.println(Constantes.FONDO_VERDE + "[v] Arma modificada" + Constantes.BORRAR);

                    break;

                case 3:
                    ((ArmaCortoAlcance) arma).setAlcance(pedirAlcance());
                    System.out.println(Constantes.FONDO_VERDE + "[v] Arma modificada" + Constantes.BORRAR);

                    break;
                default:
                    System.out.println("Opcion no permitida");
            }

        } catch (InputMismatchException e) {
            System.out.println("Error. Debes introducir un numero.");
        }
    }

    public void mostrarArmas() {
        Iterator it = armas.keySet().iterator();

        System.out.println(Constantes.CELESTE + "[*] [*] [*] Mostrando armas... [*] [*] [*]" + Constantes.BORRAR);

        if (armas.isEmpty()) {
            System.out.println(Constantes.FONDO_ROJO + "[x] No hay armas en el almacen." + Constantes.BORRAR);
        } else {

            while (it.hasNext()) {
                String clave = (String) it.next();
                Arma aux = armas.get(clave);

                if (aux instanceof ArmaCortoAlcance) {
                    System.out.println("Arma de corto alcance - ID: " + aux.getIdentificador());
                } else if (aux instanceof ArmaLargoAlcance) {
                    System.out.println("Arma de largo alcance - ID: " + aux.getIdentificador());
                }

                System.out.println("Daño: " + aux.getDaño());
                System.out.println("Diámetro bala: " + aux.getDiametro());
                System.out.println("Tamaño cargador: " + aux.getCargador().length);

                int contador = 0;
                int i;

                for (i = 0; i < aux.getCargador().length; i++) {
                    if (aux.getCargador()[i] != null) {
                        contador++;
                    }
                    i++;
                }

                System.out.println("Nº balas: " + contador);

                if (aux instanceof ArmaCortoAlcance) {
                    System.out.println("Alcance:" + ((ArmaCortoAlcance) aux).getAlcance());
                } else if (aux instanceof ArmaLargoAlcance) {
                    System.out.println("Velocidad: " + ((ArmaLargoAlcance) aux).getVelocidad());
                }
                System.out.println("");

            }

        }
    }

    public void crearArma() {
        Scanner entrada = new Scanner(System.in);

        Arma aux;
        System.out.println(Constantes.CELESTE + "[*] [*] [*] Creando arma... [*] [*] [*]" + Constantes.BORRAR);

        System.out.println("¿Que tipo de arma quieres crear?");
        System.out.println("[1] Corto Alcance");
        System.out.println("[2] Largo Alcance");
        try {
            switch (entrada.nextInt()) {
                case 1:
                    aux = new ArmaCortoAlcance();
                    aux.setDiametro(pedirDiametro());
                    ((ArmaCortoAlcance) aux).setAlcance(pedirAlcance());
                    armas.put(aux.getIdentificador(), aux);
                    System.out.println(Constantes.FONDO_VERDE + "[v] Arma creada en el almacen" + Constantes.BORRAR);

                    break;
                case 2:
                    aux = new ArmaLargoAlcance();
                    aux.setDiametro(pedirDiametro());
                    ((ArmaLargoAlcance) aux).setVelocidad(pedirVelocidad());
                    armas.put(aux.getIdentificador(), aux);
                    System.out.println(Constantes.FONDO_VERDE + "[v] Arma creada en el almacen" + Constantes.BORRAR);

                    break;
                default:
                    System.out.println("No se pueden crear armas del tipo seleccionado.");
            }

        } catch (InputMismatchException e) {
            System.out.println("Error. Se debe introducir un numero.");
        }

    }

    public Bala[] pedirTamañoCargador() {
        Scanner entrada = new Scanner(System.in);
        boolean cerrar = false;
        Bala[] cargador = new Bala[10];

        do {
            try {
                System.out.println("Introduzca nuevo tamaño del cargador: ");
                cargador = new Bala[entrada.nextInt()];
                cerrar = true;
            } catch (InputMismatchException e) {
                System.out.println("Error. Debe introducir un numero.");
            }
        } while (!cerrar);

        return cargador;

    }

    public int pedirDiametro() {
        Scanner entrada = new Scanner(System.in);
        boolean cerrar = false;
        int diametro = 0;

        do {
            try {
                System.out.println("Diametro de bala: ");
                diametro = entrada.nextInt();
                cerrar = true;
            } catch (InputMismatchException e) {
                System.out.println("Error. Debe introducir un numero.");
            }
        } while (!cerrar);
        return diametro;

    }

    public int pedirAlcance() {
        Scanner entrada = new Scanner(System.in);
        boolean cerrar = false;
        int alcance = 0;

        do {
            try {
                System.out.println("Alcance de bala: ");
                alcance = entrada.nextInt();
                cerrar = true;
            } catch (InputMismatchException e) {
                System.out.println("Error. Debe introducir un numero.");
            }
        } while (!cerrar);
        return alcance;

    }

    public double pedirVelocidad() {
        Scanner entrada = new Scanner(System.in);
        boolean cerrar = false;
        double velocidad = 0;

        do {
            try {
                System.out.println("Velocidad de bala: ");
                velocidad = entrada.nextDouble();
                cerrar = true;
            } catch (InputMismatchException e) {
                System.out.println("Error. Debe introducir un numero.");
            }
        } while (!cerrar);

        return velocidad;

    }

}
