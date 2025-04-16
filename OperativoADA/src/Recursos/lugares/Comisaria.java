/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Recursos.lugares;

import General.Constantes;
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
    
    public void elegirPolicia(){
        
        
        Scanner entrada = new Scanner(System.in);
        boolean enc = false;
        Constantes constantes = new Constantes();
        System.out.println("Escribe el nº de placa del policia: ");
        try {
            int respuesta = entrada.nextInt();
            Iterator it = policias.iterator();

            while (!enc && it.hasNext()) {

                Policia aux = (Policia) it.next();

                if (respuesta == aux.getNumeroPlaca()) {
                    System.out.println(constantes.FONDO_VERDE + "[v] Policia encontrado." + constantes.BORRAR);
                    System.out.println(constantes.FONDO_VERDE + "[v] ¡Hecho! Ahora controlas a " + aux.getNombre() + "." + constantes.BORRAR);
                 
                    enc = true;
                }

                if (!enc) {
                    System.out.println("Policia no encontrado.");
                }

            }

        } catch (InputMismatchException e) {
            System.out.println("ERROR. Debe introducir un numero.");
        }

        
    }

    public void eliminarPolicia() {

        Scanner entrada = new Scanner(System.in);
        boolean enc = false;
        Constantes constantes = new Constantes();
        System.out.println(constantes.FONDO_ROJO + "[*] [*] [*] Eliminando policia... [*] [*] [*] " + constantes.BORRAR);
        System.out.println("Escribe el nº de placa del policia: ");
        try {
            int respuesta = entrada.nextInt();
            Iterator it = policias.iterator();

            while (!enc && it.hasNext()) {

                Policia aux = (Policia) it.next();

                if (respuesta == aux.getNumeroPlaca()) {
                    System.out.println(constantes.FONDO_VERDE + "[v] Policia encontrado." + constantes.BORRAR);
                    System.out.println(constantes.FONDO_VERDE + "[v] Policia eliminado." + constantes.BORRAR);
                    policias.remove(aux);
                    enc = true;
                }

                if (!enc) {
                    System.out.println("Policia no encontrado.");
                }

            }

        } catch (InputMismatchException e) {
            System.out.println("ERROR. Debe introducir un numero.");
        }

    }

    public void buscarPolicias() {
        Scanner entrada = new Scanner(System.in);
        boolean enc = false;
        Constantes constantes = new Constantes();
        System.out.println("Escribe el nº de placa del policia: ");
        try {
            int respuesta = entrada.nextInt();
            Iterator it = policias.iterator();

            while (!enc && it.hasNext()) {

                Policia aux = (Policia) it.next();

                if (respuesta == aux.getNumeroPlaca()) {
                    System.out.println(constantes.FONDO_VERDE + "[v] Policia encontrado." + constantes.BORRAR);
                    enc = true;
                }

                if (!enc) {
                    System.out.println("Policia no encontrado.");
                }

            }

        } catch (InputMismatchException e) {
            System.out.println("ERROR. Debe introducir un numero.");
        }
    }

    public void mostrarPolicias() {
        Iterator it = policias.iterator();
        Constantes constantes = new Constantes();
        System.out.println(constantes.AZUL + "[*] [*] [*] Mostrando policias... [*] [*] [*] " + constantes.BORRAR);

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
            System.out.println(constantes.FONDO_ROJO + "[x] No hay policias en la unidad." + constantes.BORRAR);
        }

    }

    public void crearPolicia() {

        Constantes constantes = new Constantes();
        Policia nuevoPolicia = new Policia();

        nuevoPolicia.setNombre(pedirNombre());

        nuevoPolicia.setDepartamento(pedirDepartamento());
        nuevoPolicia.setPermisoArma(pedirPermisoArma());

        if (nuevoPolicia.getPermisoArma().equalsIgnoreCase("Corto Alcance")) { //Por coherencia, el arma le es asignada al policía en función de su permiso
            nuevoPolicia.setArma(new ArmaCortoAlcance());
        } else {            //La razón por la que añado else es porque al llegar aquí, se ha implementado el método pedirPermisoArma y por tanto solo hay dos opciones posibles en el getter
            nuevoPolicia.setArma(new ArmaLargoAlcance());
        }

        nuevoPolicia.setRango(pedirRango());
        nuevoPolicia.setMarca(nuevoPolicia.getNombre().charAt(0));

        nuevoPolicia.setCoordenadaX(constantes.getUBICACION_COMISARIA_FILA());
        nuevoPolicia.setCoordenadaY(constantes.getUBICACION_COMISARIA_COLUMNA());

        this.policias.add(nuevoPolicia);

        if (this.policias.contains(nuevoPolicia)) {
            System.out.println(constantes.AZUL + "[*] [*] [*] Creando policia... [*] [*] [*] " + constantes.BORRAR);
            System.out.println("Nombre: " + nuevoPolicia.getNombre());
            System.out.println("Departamento (Inteligencia, Operaciones o Investigacion): " + nuevoPolicia.getDepartamento());
            System.out.println("Permiso de armas (Corto alcance o Largo Alcance): " + nuevoPolicia.getPermisoArma());
            System.out.println("Rango (Agente, Inspector/a, Comisario/a): " + nuevoPolicia.getRango());
            System.out.println(constantes.FONDO_VERDE + "[v]" + "Policia integrado en la unidad." + constantes.BORRAR);
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
                        System.out.println("Error. Las tres opciones posibles son 'Inteligencia', 'Operaciones' o 'Investigacion'.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Error. Las tres opciones posibles son 'Inteligencia', 'Operaciones' o 'Investigacion'.");
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
                System.out.println("Introduzca el permiso de armas: Escriba 1 para Corto Alcance, 2 para Largo Alcance: ");
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
                        System.out.println("Error. Las opciones posibles son: 1 para Corto Alcance o 2 para Largo Alcance.");
                        break;
                }

            } catch (InputMismatchException e) {
                System.out.println("Error. Las opciones posibles son: 1 para Corto Alcance o 2 para Largo Alcance.");
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
                        System.out.println("Error. Las posibles opciones son: 1 para Agente. 2 para Inspector. 3 para Comisario.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Error. Las posibles opciones son: 1 para Agente. 2 para Inspector. 3 para Comisario.");
                entrada.next();

            }

        } while (!cerrar);

        return rango;
    }
}
