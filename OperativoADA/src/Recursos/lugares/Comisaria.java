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

    public Policia elegirPolicia() {        //Método para elegir un policía, devolverlo y asignárselo al jugador principal

        Policia policiaElegido = MenuPrincipal.jugador;     //Inicializamos un policía con el que esté asignado al jugador principal. Incluso si este estuviera vacío, no importa ya que el control pertinente ya está programado en el método buscar

        Policia aux = buscarPolicias();      //Inicializamos una variable auxiliar con lo que nos devuelva buscarPolicuas()

        if (aux != null) {         //Si buscarPolicias() nos devuelve un objeto y no un null, sobreescribimos al policiaBuscado con aux

            policiaElegido = aux;
            System.out.println(Constantes.FONDO_VERDE + "[v] ¡Hecho! Ahora controlas a " + policiaElegido.getNombre() + "." + Constantes.BORRAR);

        }

        return policiaElegido;  //Devolveremos un objeto vacío si se ha encontrado, o al policía que hemos buscado si la búsqueda ha tenido éxito

    }

    public void eliminarPolicia() {     //Método para eliminar un arma del mapa

        if (!policias.isEmpty()) {   //Si hay policías en el Array, inicializamos una variable auxiliar con lo que nos devuelva el método buscarPolicias()

            System.out.println(Constantes.FONDO_ROJO + "[*] [*] [*] Eliminando policia... [*] [*] [*] " + Constantes.BORRAR);

            Policia aux = buscarPolicias();

            if (aux != null) {  //Si buscarPolicias() nos devuelve un objeto y no un null, lo eliminamos de la lista. De lo contrario, nada sucederá y el propio método buscar nos dirá que el policía no ha sido encontrado
                policias.remove(aux);

                System.out.println(Constantes.FONDO_VERDE + "[v] Policia eliminado." + Constantes.BORRAR);
            }

        } else {        //Si la lista está vacía, nos cuidamos de nullPointerException imprimiendo este mensaje
            System.out.println(Constantes.FONDO_ROJO + "[x] No hay policias en la unidad." + Constantes.BORRAR);

        }
    }

    public void modificarPolicia() {        //Método para modificar un policía de la lista

        Scanner entrada = new Scanner(System.in);

        if (!policias.isEmpty()) {    //Si hay policías en el Array, inicializamos una variable auxiliar con lo que nos devuelva el método buscarPolicias()

            Policia aux = buscarPolicias();

            if (aux != null) {  //Si el objeto devuelto no es nulo, se inicia el menú de modificación 

                System.out.println(Constantes.AZUL + "[*] [*] [*] Modificando policia... [*] [*] [*] " + Constantes.BORRAR);

                System.out.println("¿Que atributo quieres modificar?");
                System.out.println("[1] Nombre");
                System.out.println("[2] Departamento");
                System.out.println("[3] Permiso de armas");
                System.out.println("[4] Rango");

                switch (entrada.nextInt()) {        //Se inicia el menú con las opciones de modificación
                    case 1:
                        aux.setNombre(pedirNombre());   //Llamamos al setter del policía almacenado en aux, ahora devuelto desde buscarPolicia()
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

            }
        } else {    //Si hay policías en el Array, inicializamos una variable auxiliar con lo que nos devuelva el método buscarPolicias()
            System.out.println(Constantes.FONDO_ROJO + "[x] No hay policias en la unidad." + Constantes.BORRAR);

        }

    }

    public Policia buscarPolicias() {       //Método para buscar un policía y devolverlo. Este método se utilizará para ejecutar los demás de esta clase
        Scanner entrada = new Scanner(System.in);       //Inicializamos el escáner
        boolean enc = false;        //Variable booleana para detener la búsqueda cuando encontremos el objeto que necesitamos
        Policia policiaBuscado = null;      //Inicializamos el policía que vamos a buscar en null

        if (policias.isEmpty()) { //Si la lista está vacía, nos cuidamos de nullPointerException imprimiendo este mensaje

            System.out.println(Constantes.FONDO_ROJO + "[x] No hay policias en la unidad." + Constantes.BORRAR);

        } else {

            System.out.println("Escribe el nº de placa del policia: ");
            try {
                int respuesta = entrada.nextInt();      //Buscamos un número de placa a través del escáner
                Iterator it = policias.iterator();  //Creamos un iterador que utilizaremos para recorrer el Array

                while (!enc && it.hasNext()) {      //Las condiciones son que enc permanezca en falso y que siga habiendo objetos en el iterador

                    Policia actual = (Policia) it.next();   //Inicializamos una variable auxiliar para almacenar en ella el policía actual en la lista

                    if (respuesta == actual.getNumeroPlaca()) {     //Si el número buscado coincide con el número de placa del policía actual en la lista, este sobreescribe al policíaBuscado (que estaba en null)
                        policiaBuscado = actual;
                        System.out.println(Constantes.FONDO_VERDE + "[v] Policia encontrado." + Constantes.BORRAR);
                        enc = true;     //Enc cambia a true y el bucle se cierra

                    }

                }

                if (!enc) {     //Si llegamos al final de la lista sin encontrar el objeto, enc nunca cambiará a true y este mensaje aparecerá.
                    System.out.println(Constantes.FONDO_ROJO + "Policia no encontrado." + Constantes.BORRAR);

                }

            } catch (InputMismatchException e) {
                System.out.println(Constantes.FONDO_ROJO + "ERROR. Debe introducir un numero." + Constantes.BORRAR);
            }
        }
        return policiaBuscado;      //El objeto devuelto seguirá en null si no se ha encontrado nada, o será el que tenga el número de placa buscado

    }

    public void mostrarPolicias() {     //Método para ir mostrando todos los policías de la lista. Por cuestiones de comodidad, configuramos la presentación en este método en lugar de hacerlo en toString(), ya que tendríamos que combinar el toString() de la superclase con el de la subclase

        System.out.println(Constantes.AZUL + "[*] [*] [*] Mostrando policias... [*] [*] [*] " + Constantes.BORRAR);

        if (!policias.isEmpty()) {      //Lo primero es asegurar que el Array no esté vacío
            Iterator it = policias.iterator();      //Creamos el iterador que usaremos para recorrer el Array
            while (it.hasNext()) {      //La condición es que haya más objetos en el Array

                Policia aux = (Policia) it.next();      //Inicializamos una variable auxiliar en la que almacenamos el siguiente objeto del Array, casteado a objeto Policía
                Arma armaux = aux.getArma();        //Almacenamos el arma de la variable auxiliar que pertenece a la superclase Arma. Más tarde usaremos el polimorfismo en función de lo que necesitemos mostrar
                System.out.println("* * * * * POLICÍA * * * * *");      //Comenzamos a imprimir los datos en un formato adecuado a como se nos pidió en el supuesto
                System.out.println(aux.getNombre() + " | " + aux.getVida());
                System.out.println("Id: " + aux.getIdentificador());

                if (armaux instanceof ArmaCortoAlcance) { //Imprimimos un mensaje u otro en función del tipo de arma asignada
                    System.out.println("Arma: Arma de corto alcance - ID: " + armaux.getIdentificador());
                } else if (armaux instanceof ArmaLargoAlcance) {
                    System.out.println("Arma: Arma de largo alcance - ID: " + armaux.getIdentificador());
                }

                System.out.println("Daño: " + armaux.getDaño());        //Se nos advierte de un posible nullPointer, pero por la naturaleza del proyecto, no se va a dar el caso de que el personaje no tenga arma equipada
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
                if (armaux instanceof ArmaCortoAlcance) {       //En función de si el arma es de un tipo u otro, utilizamos el polimofrismo para mostrar el atributo particular de cada tipo de arma (alcance o velocidad)

                    System.out.println("Alcance: " + (((ArmaCortoAlcance) armaux).getAlcance()));
                } else if (armaux instanceof ArmaLargoAlcance) {
                    System.out.println("Velocidad: " + ((ArmaLargoAlcance) armaux).getVelocidad());
                }

                System.out.println("Marca: " + aux.getMarca());     //Imprimimos el resto de datos
                System.out.println("Coordenada X: " + aux.getCoordenadaX());
                System.out.println("Coordenada Y: " + aux.getCoordenadaY());
                System.out.println("Nº de placa: " + aux.getNumeroPlaca());
                System.out.println("Rango: " + aux.getRango());
                System.out.println("Permiso de armas: " + aux.getPermisoArma());
                System.out.println("Dpto: " + aux.getDepartamento());
                System.out.println("* * * * * * * * * * * * * *");
                System.out.println("");

            }
        } else {        //Si la lista está vacía, nos cuidamos de nullPointerException imprimiendo este mensaje
            System.out.println(Constantes.FONDO_ROJO + "[x] No hay policias en la unidad." + Constantes.BORRAR);
        }

    }

    public void crearPolicia() {        //Método para crear un objeto Policía y añadirlo al Array

        Constantes ubicaciones = new Constantes();      //Creamos una variable de tipo Constantes de la que usaremos las ubicaciones
        Policia nuevoPolicia;       //Creamos un policía usando el constructor por defecto

        String nombre = pedirNombre();
        String departamento = pedirDepartamento();
        String permiso = pedirPermisoArma();
        String rango = pedirRango();
        Arma arma = new ArmaCortoAlcance();     //Tal como se nos pide en el enunciado, le asignamos un arma de corto alcance
        char marca = nombre.charAt(0);       //Usamos la primera posición charAt(0) del nombre para asignar el alias del policía
        int coordenadaX = ubicaciones.getUBICACION_COMISARIA_FILA();         //Usamos las variables almacenadas en el objeto de tipo Constantes para asignarlas en las coordenadas del policía
        int coordenadaY = ubicaciones.getUBICACION_COMISARIA_COLUMNA();

        nuevoPolicia = new Policia(departamento, permiso, rango, nombre, marca, coordenadaX, coordenadaY, arma);

        this.policias.add(nuevoPolicia);        //Finalmente, añadimos al policía al Array

        System.out.println(Constantes.AZUL + "[*] [*] [*] Creando policia... [*] [*] [*] " + Constantes.BORRAR);    //Imprimimos los datos del policía
        System.out.println("Nombre: " + nuevoPolicia.getNombre());
        System.out.println("Departamento (Inteligencia, Operaciones o Investigacion): " + nuevoPolicia.getDepartamento());
        System.out.println("Permiso de armas (Corto alcance o Largo Alcance): " + nuevoPolicia.getPermisoArma());
        System.out.println("Rango (Agente, Inspector/a, Comisario/a): " + nuevoPolicia.getRango());
        System.out.println(Constantes.FONDO_VERDE + "[v]" + "Policia integrado en la unidad." + Constantes.BORRAR);
        System.out.println("");

    }

    public static String pedirNombre() {        //Método String que devuelve un nombre introducido por escáner
        Scanner entrada = new Scanner(System.in);
        System.out.println("Introduzca el nombre del policia: ");
        String nombre = entrada.next();
        return nombre;

    }

    public static String pedirDepartamento() {   //Método String que devuelve un String modificado a través de un menú
        String departamento = "";       //El String se inicializa vacío, en función de las opciones que elijamos cambiará a una u otra palabra
        boolean cerrar = false;
        Scanner entrada = new Scanner(System.in);
        int respuesta;

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
                System.out.println(Constantes.FONDO_ROJO + "ERROR. Debe introducir un numero." + Constantes.BORRAR);
                entrada.next();

            }
        } while (!cerrar);

        return departamento;        //Devolvemos el String alterado

    }

    public static String pedirPermisoArma() {        //Método String que devuelve un String modificado a través de un menú
        String permiso = "";            //El String se inicializa vacío, en función de las opciones que elijamos cambiará a una u otra palabra
        boolean cerrar = false;
        Scanner entrada = new Scanner(System.in);
        do {
            try {
                System.out.println("Introduzca el permiso de armas: Escriba 1 para Corto Alcance. 2 para Largo Alcance.");
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
                System.out.println(Constantes.FONDO_ROJO + "ERROR. Debe introducir un numero." + Constantes.BORRAR);
                entrada.next();

            }

        } while (!cerrar);
        return permiso;     //Devolvemos el String alterado

    }

    public static String pedirRango() {           //Método String que devuelve un String modificado a través de un menú
        String rango = "";                             //El String se inicializa vacío, en función de las opciones que elijamos cambiará a una u otra palabra
        boolean cerrar = false;
        Scanner entrada = new Scanner(System.in);

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
                System.out.println(Constantes.FONDO_ROJO + "ERROR. Debe introducir un numero." + Constantes.BORRAR);
                entrada.next();

            }

        } while (!cerrar);

        return rango;        //Devolvemos el String alterado
    }
}
