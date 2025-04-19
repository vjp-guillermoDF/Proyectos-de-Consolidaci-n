/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Recursos.lugares;

import General.Constantes;
import Operaciones.MenuPrincipal;
import static Operaciones.MenuPrincipal.jugador;
import Recursos.armas.Arma;
import Recursos.armas.ArmaCortoAlcance;
import Recursos.armas.ArmaLargoAlcance;
import Recursos.personajes.Policia;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Iterator;
import java.util.Scanner;

/**
 *
 * @author guill
 */
public class Comisaria {

    private ArrayList<Policia> policias;

    public Comisaria(ArrayList<Policia> policias) {
        this.policias = policias;
    }

    public Comisaria() {
        this.policias = new ArrayList();
    }

    public ArrayList<Policia> getPolicias() {
        return policias;
    }

    public void setPolicias(ArrayList<Policia> policias) {
        this.policias = policias;
    }

    @Override
    public String toString() {
        return "Comisaria{" + "policias=" + policias + '}';
    }

    public Policia elegirPolicia() {
        Policia policiaBuscado = MenuPrincipal.jugador;       //Inicializamos el policía que vamos a buscar.
        Scanner entrada = new Scanner(System.in);
        boolean enc = false;
        if (!policias.isEmpty()) {
            System.out.println(Constantes.AZUL + "[*] [*] [*] Seleccionando policia... [*] [*] [*]" + Constantes.BORRAR);
            System.out.println("Escribe el nº de placa del policia: ");
            try {
                int respuesta = entrada.nextInt();
                Iterator it = policias.iterator();

                while (!enc && it.hasNext()) {
                    Policia policia = (Policia) it.next();

                    if (respuesta == policia.getNumeroPlaca()) {
                        policiaBuscado = policia;
                        System.out.println(Constantes.FONDO_VERDE + "[v] Policia encontrado." + Constantes.BORRAR);
                        System.out.println(Constantes.FONDO_VERDE + "[v] ¡Hecho! Ahora controlas a " + policiaBuscado.getNombre() + "." + Constantes.BORRAR);
                        enc = true;

                    }

                    if (!enc) {
                        System.out.println(Constantes.ROJO + "Policia no encontrado." + Constantes.BORRAR);
                    }

                }

            } catch (InputMismatchException e) {
                System.out.println(Constantes.ROJO + "ERROR. Debe introducir un numero." + Constantes.BORRAR);

            }

        } else {
            System.out.println(Constantes.FONDO_ROJO + "[x] No hay policias en la unidad." + Constantes.BORRAR);

        }
        return policiaBuscado;
    }

    public void eliminarPolicia() {

        Scanner entrada = new Scanner(System.in);
        boolean enc = false;

        if (!policias.isEmpty()) {

            System.out.println(Constantes.FONDO_ROJO + "[*] [*] [*] Eliminando policia... [*] [*] [*] " + Constantes.BORRAR);
            System.out.println("Escribe el nº de placa del policia: ");
            try {
                int respuesta = entrada.nextInt();
                Iterator it = policias.iterator();

                while (!enc && it.hasNext()) {

                    Policia aux = (Policia) it.next();

                    if (respuesta == aux.getNumeroPlaca()) {
                        System.out.println(Constantes.FONDO_VERDE + "[v] Policia encontrado." + Constantes.BORRAR);
                        System.out.println(Constantes.FONDO_VERDE + "[v] Policia eliminado." + Constantes.BORRAR);
                        policias.remove(aux);
                        enc = true;
                    }

                }
                if (!enc) {
                    System.out.println(Constantes.ROJO + "Policia no encontrado." + Constantes.BORRAR);
                }

            } catch (InputMismatchException e) {
                System.out.println(Constantes.ROJO + "ERROR. Debe introducir un numero." + Constantes.BORRAR);
            }

        } else {
            System.out.println(Constantes.FONDO_ROJO + "[x] No hay policias en la unidad." + Constantes.BORRAR);

        }
    }

    public void modificarPolicia() {

        Scanner entrada = new Scanner(System.in);
        boolean enc = false;

        if (!policias.isEmpty()) {

            System.out.println("Escribe el nº de placa del policia: ");
            try {
                int respuesta = entrada.nextInt();
                Iterator it = policias.iterator();

                while (!enc && it.hasNext()) {

                    Policia aux = (Policia) it.next();

                    if (respuesta == aux.getNumeroPlaca()) {
                        System.out.println(Constantes.FONDO_VERDE + "[v] Policia encontrado." + Constantes.BORRAR);
                        System.out.println(Constantes.AZUL + "[*] [*] [*] Modificando policia... [*] [*] [*] " + Constantes.BORRAR);

                        System.out.println("¿Que atributo quieres modificar?");
                        System.out.println("[1] Nombre");
                        System.out.println("[2] Departamento");
                        System.out.println("[3] Permiso de armas");
                        System.out.println("[4] Rango");

                        switch (entrada.nextInt()) {
                            case 1:
                                aux.setNombre(pedirNombre());
                                System.out.println(Constantes.FONDO_VERDE + "[v] Policia modidificado" + Constantes.BORRAR);
                                break;

                            case 2:
                                aux.setDepartamento(pedirDepartamento());
                                System.out.println(Constantes.FONDO_VERDE + "[v] Policia modidificado" + Constantes.BORRAR);
                                break;

                            case 3:
                                aux.setPermisoArma(pedirPermisoArma());
                                System.out.println(Constantes.FONDO_VERDE + "[v] Policia modidificado" + Constantes.BORRAR);
                                break;

                            case 4:
                                aux.setRango(pedirRango());
                                System.out.println(Constantes.FONDO_VERDE + "[v] Policia modidificado" + Constantes.BORRAR);
                                break;
                            default:
                                System.out.println(Constantes.AMARILLO + "Opcion no permitida" + Constantes.BORRAR);
                        }

                        enc = true;
                    }

                }
                if (!enc) {
                    System.out.println(Constantes.ROJO + "Policia no encontrado." + Constantes.BORRAR);
                }

            } catch (InputMismatchException e) {
                System.out.println(Constantes.ROJO + "ERROR. Debe introducir un numero." + Constantes.BORRAR);
            }

        } else {
            System.out.println(Constantes.FONDO_ROJO + "[x] No hay policias en la unidad." + Constantes.BORRAR);

        }
    }

    public Policia buscarPolicias() {
        Scanner entrada = new Scanner(System.in);
        boolean enc = false;
        Policia policiaBuscado = null;
        if (!policias.isEmpty()) {

            System.out.println("Escribe el nº de placa del policia: ");
            try {
                int respuesta = entrada.nextInt();
                Iterator it = policias.iterator();

                while (!enc && it.hasNext()) {

                    policiaBuscado = (Policia) it.next();
                    Arma armaux = policiaBuscado.getArma();

                    if (respuesta == policiaBuscado.getNumeroPlaca()) {
                        System.out.println(Constantes.FONDO_VERDE + "[v] Policia encontrado." + Constantes.BORRAR);

                        System.out.println("* * * * * POLICÍA * * * * *");
                        System.out.println(policiaBuscado.getNombre() + " | " + policiaBuscado.getVida());
                        System.out.println("Id: " + policiaBuscado.getIdentificador());
                        if (policiaBuscado.getPermisoArma().equalsIgnoreCase("Corto Alcance")) { //Imprimimos un mensaje u otro en función del tipo de arma asignada
                            System.out.println("Arma: Arma de corto alcance - ID: " + armaux.getIdentificador());
                        } else {
                            System.out.println("Arma: Arma de largo alcance - ID: " + armaux.getIdentificador());
                        }
                        System.out.println("Daño: " + armaux.getDaño());
                        System.out.println("Diámetro bala: " + armaux.getDiametro());
                        System.out.println("Tamaño del cargador: " + armaux.getCargador().length);
                        int contador = 0;

                        for (int i = 0; i < armaux.getCargador().length; i++) { // Recorremos el array mientras no lleguemos al final
                            if (armaux.getCargador()[i] != null) {  //Por cada bala que encontremos (not null), se aumenta el cargador en uno
                                contador++;
                            }
                            i++; // Incrementamos el índice en cada iteración. Esto OPTIMIZA LA UTILIZACIÓN DE RECURSOS ya que el array no seguirá recorriéndose aunque ya no queden Balas
                        }
                        System.out.println("Número de balas: " + contador);
                        if (armaux instanceof ArmaCortoAlcance) {

                            System.out.println("Alcance: " + (((ArmaCortoAlcance) armaux).getAlcance()));
                        } else if (armaux instanceof ArmaLargoAlcance) {
                            System.out.println("Velocidad: " + ((ArmaLargoAlcance) armaux).getVelocidad());
                        }
                        System.out.println("Marca: " + policiaBuscado.getMarca());
                        System.out.println("Coordenada X: " + policiaBuscado.getCoordenadaX());
                        System.out.println("Coordenada Y: " + policiaBuscado.getCoordenadaY());
                        System.out.println("Nº de placa: " + policiaBuscado.getNumeroPlaca());
                        System.out.println("Rango: " + policiaBuscado.getRango());
                        System.out.println("Permiso de armas: " + policiaBuscado.getPermisoArma());
                        System.out.println("Dpto: " + policiaBuscado.getDepartamento());
                        System.out.println("* * * * * * * * * * * * * *");
                        System.out.println("");

                        enc = true;

                    }

                }

                if (!enc) {
                    System.out.println(Constantes.ROJO + "Policia no encontrado." + Constantes.BORRAR);

                }

            } catch (InputMismatchException e) {
                System.out.println(Constantes.ROJO + "ERROR. Debe introducir un numero." + Constantes.BORRAR);
            }
        } else {
            System.out.println(Constantes.FONDO_ROJO + "[x] No hay policias en la unidad." + Constantes.BORRAR);

        }

        return policiaBuscado;

    }

    public void mostrarPolicias() {
        Iterator it = policias.iterator();
        System.out.println(Constantes.AZUL + "[*] [*] [*] Mostrando policias... [*] [*] [*] " + Constantes.BORRAR);

        if (!policias.isEmpty()) {
            while (it.hasNext()) {

                Policia aux = (Policia) it.next();
                Arma armaux = aux.getArma();
                System.out.println("* * * * * POLICÍA * * * * *");
                System.out.println(aux.getNombre() + " | " + aux.getVida());
                System.out.println("Id: " + aux.getIdentificador());

                if (aux.getPermisoArma().equalsIgnoreCase("Corto Alcance")) { //Imprimimos un mensaje u otro en función del tipo de arma asignada
                    System.out.println("Arma: Arma de corto alcance - ID: " + armaux.getIdentificador());
                } else {
                    System.out.println("Arma: Arma de largo alcance - ID: " + armaux.getIdentificador());
                }

                System.out.println("Daño: " + armaux.getDaño());
                System.out.println("Diámetro bala: " + armaux.getDiametro());
                System.out.println("Tamaño del cargador: " + armaux.getCargador().length);
                int contador = 0;

                for (int i = 0; i < armaux.getCargador().length; i++) { // Recorremos el array mientras no lleguemos al final
                    if (armaux.getCargador()[i] != null) {  //Por cada bala que encontremos (not null), se aumenta el cargador en uno
                        contador++;
                    }
                    i++; // Incrementamos el índice en cada iteración. Esto OPTIMIZA LA UTILIZACIÓN DE RECURSOS ya que el array no seguirá recorriéndose aunque ya no queden Balas
                }
                System.out.println("Número de balas: " + contador);
                if (armaux instanceof ArmaCortoAlcance) {

                    System.out.println("Alcance: " + (((ArmaCortoAlcance) armaux).getAlcance()));
                } else if (armaux instanceof ArmaLargoAlcance) {
                    System.out.println("Velocidad: " + ((ArmaLargoAlcance) armaux).getVelocidad());
                }

                System.out.println("Marca: " + aux.getMarca());
                System.out.println("Coordenada X: " + aux.getCoordenadaX());
                System.out.println("Coordenada Y: " + aux.getCoordenadaY());
                System.out.println("Nº de placa: " + aux.getNumeroPlaca());
                System.out.println("Rango: " + aux.getRango());
                System.out.println("Permiso de armas: " + aux.getPermisoArma());
                System.out.println("Dpto: " + aux.getDepartamento());
                System.out.println("* * * * * * * * * * * * * *");
                System.out.println("");

            }
        } else {
            System.out.println(Constantes.FONDO_ROJO + "[x] No hay policias en la unidad." + Constantes.BORRAR);
        }

    }

    public void crearPolicia() {

        Constantes ubicaciones = new Constantes();
        Policia nuevoPolicia = new Policia();

        nuevoPolicia.setNombre(pedirNombre());

        nuevoPolicia.setDepartamento(pedirDepartamento());
        nuevoPolicia.setPermisoArma(pedirPermisoArma());

        nuevoPolicia.setArma(new ArmaCortoAlcance());

        nuevoPolicia.setRango(pedirRango());
        nuevoPolicia.setMarca(nuevoPolicia.getNombre().charAt(0));

        nuevoPolicia.setCoordenadaX(ubicaciones.getUBICACION_COMISARIA_FILA());
        nuevoPolicia.setCoordenadaY(ubicaciones.getUBICACION_COMISARIA_COLUMNA());

        this.policias.add(nuevoPolicia);

        if (this.policias.contains(nuevoPolicia)) {
            System.out.println(Constantes.AZUL + "[*] [*] [*] Creando policia... [*] [*] [*] " + Constantes.BORRAR);
            System.out.println("Nombre: " + nuevoPolicia.getNombre());
            System.out.println("Departamento (Inteligencia, Operaciones o Investigacion): " + nuevoPolicia.getDepartamento());
            System.out.println("Permiso de armas (Corto alcance o Largo Alcance): " + nuevoPolicia.getPermisoArma());
            System.out.println("Rango (Agente, Inspector/a, Comisario/a): " + nuevoPolicia.getRango());
            System.out.println(Constantes.FONDO_VERDE + "[v]" + "Policia integrado en la unidad." + Constantes.BORRAR);
            System.out.println("");
        }

    }

    public static String pedirNombre() {
        Scanner entrada = new Scanner(System.in);
        System.out.println("Introduzca el nombre del policia: ");
        String nombre = entrada.next();
        return nombre;

    }

    public static String pedirDepartamento() {
        String departamento = "";

        boolean cerrar = false;
        int respuesta;
        Scanner entrada = new Scanner(System.in);

        do {
            try {
                System.out.println("Introduzca el departamento: 1 para Inteligencia. 2 para Operaciones. 3 para Investigacion.");

                respuesta = entrada.nextInt();
                switch (respuesta) {
                    case 1:
                        departamento = "Inteligencia";
                        cerrar = true;
                        break;
                    case 2:
                        departamento = "Operaciones";
                        cerrar = true;
                        break;
                    case 3:
                        departamento = "Investigacion";
                        cerrar = true;
                        break;
                    default:
                        System.out.println(Constantes.AMARILLO + "Las tres opciones posibles son 'Inteligencia', 'Operaciones' o 'Investigacion'." + Constantes.BORRAR);
                }
            } catch (InputMismatchException e) {
                System.out.println(Constantes.ROJO + "ERROR. Debe introducir un numero." + Constantes.BORRAR);
                entrada.next();

            }
        } while (!cerrar);

        return departamento;

    }

    public static String pedirPermisoArma() {
        String permiso = "";
        boolean cerrar = false;
        Scanner entrada = new Scanner(System.in);
        do {
            try {
                System.out.println("Introduzca el permiso de armas: Escriba 1 para Corto Alcance, 2 para Largo Alcance.");
                int respuesta = entrada.nextInt();

                switch (respuesta) {
                    case 1:
                        permiso = "Corto Alcance";
                        cerrar = true;
                        break;
                    case 2:
                        permiso = "Largo Alcance";
                        cerrar = true;
                        break;
                    default:
                        System.out.println(Constantes.AMARILLO + "Las opciones posibles son: 1 para Corto Alcance o 2 para Largo Alcance." + Constantes.BORRAR);
                        break;
                }

            } catch (InputMismatchException e) {
                System.out.println(Constantes.ROJO + "ERROR. Debe introducir un numero." + Constantes.BORRAR);
                entrada.next();

            }

        } while (!cerrar);
        return permiso;

    }

    public static String pedirRango() {
        Scanner entrada = new Scanner(System.in);
        boolean cerrar = false;
        String rango = "";
        do {
            try {
                System.out.println("Introduzca el rango: 1 para Agente. 2 para Inspector. 3 para Comisario.");
                int respuesta = entrada.nextInt();

                switch (respuesta) {
                    case 1:
                        rango = "Agente";
                        cerrar = true;
                        break;
                    case 2:
                        rango = "Inspector";
                        cerrar = true;
                        break;

                    case 3:
                        rango = "Comisario";
                        cerrar = true;
                        break;
                    default:
                        System.out.println(Constantes.AMARILLO + "Las posibles opciones son: 1 para Agente. 2 para Inspector. 3 para Comisario." + Constantes.BORRAR);
                }
            } catch (InputMismatchException e) {
                System.out.println(Constantes.ROJO + "ERROR. Debe introducir un numero." + Constantes.BORRAR);
                entrada.next();

            }

        } while (!cerrar);

        return rango;
    }
}
