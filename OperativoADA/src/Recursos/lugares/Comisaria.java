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

    public Policia elegirPolicia() {        //M�todo para elegir un polic�a, devolverlo y asign�rselo al jugador principal

        Policia policiaElegido = MenuPrincipal.jugador;     //Inicializamos un polic�a con el que est� asignado al jugador principal. Incluso si este estuviera vac�o, no importa ya que el control pertinente ya est� programado en el m�todo buscar

        Policia aux = buscarPolicias();      //Inicializamos una variable auxiliar con lo que nos devuelva buscarPolicuas()

        if (aux != null) {         //Si buscarPolicias() nos devuelve un objeto y no un null, sobreescribimos al policiaBuscado con aux

            policiaElegido = aux;
            System.out.println(Constantes.FONDO_VERDE + "[v] �Hecho! Ahora controlas a " + policiaElegido.getNombre() + "." + Constantes.BORRAR);

        }

        return policiaElegido;  //Devolveremos un objeto vac�o si se ha encontrado, o al polic�a que hemos buscado si la b�squeda ha tenido �xito

    }

    public void eliminarPolicia() {     //M�todo para eliminar un arma del mapa

        if (!policias.isEmpty()) {   //Si hay polic�as en el Array, inicializamos una variable auxiliar con lo que nos devuelva el m�todo buscarPolicias()

            System.out.println(Constantes.FONDO_ROJO + "[*] [*] [*] Eliminando policia... [*] [*] [*] " + Constantes.BORRAR);

            Policia aux = buscarPolicias();

            if (aux != null) {  //Si buscarPolicias() nos devuelve un objeto y no un null, lo eliminamos de la lista. De lo contrario, nada suceder� y el propio m�todo buscar nos dir� que el polic�a no ha sido encontrado
                policias.remove(aux);

                System.out.println(Constantes.FONDO_VERDE + "[v] Policia eliminado." + Constantes.BORRAR);
            }

        } else {        //Si la lista est� vac�a, nos cuidamos de nullPointerException imprimiendo este mensaje
            System.out.println(Constantes.FONDO_ROJO + "[x] No hay policias en la unidad." + Constantes.BORRAR);

        }
    }

    public void modificarPolicia() {        //M�todo para modificar un polic�a de la lista

        Scanner entrada = new Scanner(System.in);

        if (!policias.isEmpty()) {    //Si hay polic�as en el Array, inicializamos una variable auxiliar con lo que nos devuelva el m�todo buscarPolicias()

            Policia aux = buscarPolicias();

            if (aux != null) {  //Si el objeto devuelto no es nulo, se inicia el men� de modificaci�n 

                System.out.println(Constantes.AZUL + "[*] [*] [*] Modificando policia... [*] [*] [*] " + Constantes.BORRAR);

                System.out.println("�Que atributo quieres modificar?");
                System.out.println("[1] Nombre");
                System.out.println("[2] Departamento");
                System.out.println("[3] Permiso de armas");
                System.out.println("[4] Rango");

                switch (entrada.nextInt()) {        //Se inicia el men� con las opciones de modificaci�n
                    case 1:
                        aux.setNombre(pedirNombre());   //Llamamos al setter del polic�a almacenado en aux, ahora devuelto desde buscarPolicia()
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
        } else {    //Si hay polic�as en el Array, inicializamos una variable auxiliar con lo que nos devuelva el m�todo buscarPolicias()
            System.out.println(Constantes.FONDO_ROJO + "[x] No hay policias en la unidad." + Constantes.BORRAR);

        }

    }

    public Policia buscarPolicias() {       //M�todo para buscar un polic�a y devolverlo. Este m�todo se utilizar� para ejecutar los dem�s de esta clase
        Scanner entrada = new Scanner(System.in);       //Inicializamos el esc�ner
        boolean enc = false;        //Variable booleana para detener la b�squeda cuando encontremos el objeto que necesitamos
        Policia policiaBuscado = null;      //Inicializamos el polic�a que vamos a buscar en null

        if (policias.isEmpty()) { //Si la lista est� vac�a, nos cuidamos de nullPointerException imprimiendo este mensaje

            System.out.println(Constantes.FONDO_ROJO + "[x] No hay policias en la unidad." + Constantes.BORRAR);

        } else {

            System.out.println("Escribe el n� de placa del policia: ");
            try {
                int respuesta = entrada.nextInt();      //Buscamos un n�mero de placa a trav�s del esc�ner
                Iterator it = policias.iterator();  //Creamos un iterador que utilizaremos para recorrer el Array

                while (!enc && it.hasNext()) {      //Las condiciones son que enc permanezca en falso y que siga habiendo objetos en el iterador

                    Policia actual = (Policia) it.next();   //Inicializamos una variable auxiliar para almacenar en ella el polic�a actual en la lista

                    if (respuesta == actual.getNumeroPlaca()) {     //Si el n�mero buscado coincide con el n�mero de placa del polic�a actual en la lista, este sobreescribe al polic�aBuscado (que estaba en null)
                        policiaBuscado = actual;
                        System.out.println(Constantes.FONDO_VERDE + "[v] Policia encontrado." + Constantes.BORRAR);
                        enc = true;     //Enc cambia a true y el bucle se cierra

                    }

                }

                if (!enc) {     //Si llegamos al final de la lista sin encontrar el objeto, enc nunca cambiar� a true y este mensaje aparecer�.
                    System.out.println(Constantes.FONDO_ROJO + "Policia no encontrado." + Constantes.BORRAR);

                }

            } catch (InputMismatchException e) {
                System.out.println(Constantes.FONDO_ROJO + "ERROR. Debe introducir un numero." + Constantes.BORRAR);
            }
        }
        return policiaBuscado;      //El objeto devuelto seguir� en null si no se ha encontrado nada, o ser� el que tenga el n�mero de placa buscado

    }

    public void mostrarPolicias() {     //M�todo para ir mostrando todos los polic�as de la lista. Por cuestiones de comodidad, configuramos la presentaci�n en este m�todo en lugar de hacerlo en toString(), ya que tendr�amos que combinar el toString() de la superclase con el de la subclase

        System.out.println(Constantes.AZUL + "[*] [*] [*] Mostrando policias... [*] [*] [*] " + Constantes.BORRAR);

        if (!policias.isEmpty()) {      //Lo primero es asegurar que el Array no est� vac�o
            Iterator it = policias.iterator();      //Creamos el iterador que usaremos para recorrer el Array
            while (it.hasNext()) {      //La condici�n es que haya m�s objetos en el Array

                Policia aux = (Policia) it.next();      //Inicializamos una variable auxiliar en la que almacenamos el siguiente objeto del Array, casteado a objeto Polic�a
                Arma armaux = aux.getArma();        //Almacenamos el arma de la variable auxiliar que pertenece a la superclase Arma. M�s tarde usaremos el polimorfismo en funci�n de lo que necesitemos mostrar
                System.out.println("* * * * * POLIC�A * * * * *");      //Comenzamos a imprimir los datos en un formato adecuado a como se nos pidi� en el supuesto
                System.out.println(aux.getNombre() + " | " + aux.getVida());
                System.out.println("Id: " + aux.getIdentificador());

                if (armaux instanceof ArmaCortoAlcance) { //Imprimimos un mensaje u otro en funci�n del tipo de arma asignada
                    System.out.println("Arma: Arma de corto alcance - ID: " + armaux.getIdentificador());
                } else if (armaux instanceof ArmaLargoAlcance) {
                    System.out.println("Arma: Arma de largo alcance - ID: " + armaux.getIdentificador());
                }

                System.out.println("Da�o: " + armaux.getDa�o());        //Se nos advierte de un posible nullPointer, pero por la naturaleza del proyecto, no se va a dar el caso de que el personaje no tenga arma equipada
                System.out.println("Di�metro bala: " + armaux.getDiametro());
                System.out.println("Tama�o del cargador: " + armaux.getCargador().length);
                int contador = 0;

                for (int i = 0; i < armaux.getCargador().length; i++) { // Recorremos el array mientras no lleguemos al final
                    if (armaux.getCargador()[i] != null) {  //Por cada bala que encontremos (not null), se aumenta el cargador en uno
                        contador++;
                    }
                    i++; // Incrementamos el �ndice en cada iteraci�n. Esto OPTIMIZA LA UTILIZACI�N DE RECURSOS ya que el array no seguir� recorri�ndose aunque ya no queden Balas
                }
                System.out.println("N�mero de balas: " + contador);
                if (armaux instanceof ArmaCortoAlcance) {       //En funci�n de si el arma es de un tipo u otro, utilizamos el polimofrismo para mostrar el atributo particular de cada tipo de arma (alcance o velocidad)

                    System.out.println("Alcance: " + (((ArmaCortoAlcance) armaux).getAlcance()));
                } else if (armaux instanceof ArmaLargoAlcance) {
                    System.out.println("Velocidad: " + ((ArmaLargoAlcance) armaux).getVelocidad());
                }

                System.out.println("Marca: " + aux.getMarca());     //Imprimimos el resto de datos
                System.out.println("Coordenada X: " + aux.getCoordenadaX());
                System.out.println("Coordenada Y: " + aux.getCoordenadaY());
                System.out.println("N� de placa: " + aux.getNumeroPlaca());
                System.out.println("Rango: " + aux.getRango());
                System.out.println("Permiso de armas: " + aux.getPermisoArma());
                System.out.println("Dpto: " + aux.getDepartamento());
                System.out.println("* * * * * * * * * * * * * *");
                System.out.println("");

            }
        } else {        //Si la lista est� vac�a, nos cuidamos de nullPointerException imprimiendo este mensaje
            System.out.println(Constantes.FONDO_ROJO + "[x] No hay policias en la unidad." + Constantes.BORRAR);
        }

    }

    public void crearPolicia() {        //M�todo para crear un objeto Polic�a y a�adirlo al Array

        Constantes ubicaciones = new Constantes();      //Creamos una variable de tipo Constantes de la que usaremos las ubicaciones
        Policia nuevoPolicia;       //Creamos un polic�a usando el constructor por defecto

        String nombre = pedirNombre();
        String departamento = pedirDepartamento();
        String permiso = pedirPermisoArma();
        String rango = pedirRango();
        Arma arma = new ArmaCortoAlcance();     //Tal como se nos pide en el enunciado, le asignamos un arma de corto alcance
        char marca = nombre.charAt(0);       //Usamos la primera posici�n charAt(0) del nombre para asignar el alias del polic�a
        int coordenadaX = ubicaciones.getUBICACION_COMISARIA_FILA();         //Usamos las variables almacenadas en el objeto de tipo Constantes para asignarlas en las coordenadas del polic�a
        int coordenadaY = ubicaciones.getUBICACION_COMISARIA_COLUMNA();

        nuevoPolicia = new Policia(departamento, permiso, rango, nombre, marca, coordenadaX, coordenadaY, arma);

        this.policias.add(nuevoPolicia);        //Finalmente, a�adimos al polic�a al Array

        System.out.println(Constantes.AZUL + "[*] [*] [*] Creando policia... [*] [*] [*] " + Constantes.BORRAR);    //Imprimimos los datos del polic�a
        System.out.println("Nombre: " + nuevoPolicia.getNombre());
        System.out.println("Departamento (Inteligencia, Operaciones o Investigacion): " + nuevoPolicia.getDepartamento());
        System.out.println("Permiso de armas (Corto alcance o Largo Alcance): " + nuevoPolicia.getPermisoArma());
        System.out.println("Rango (Agente, Inspector/a, Comisario/a): " + nuevoPolicia.getRango());
        System.out.println(Constantes.FONDO_VERDE + "[v]" + "Policia integrado en la unidad." + Constantes.BORRAR);
        System.out.println("");

    }

    public static String pedirNombre() {        //M�todo String que devuelve un nombre introducido por esc�ner
        Scanner entrada = new Scanner(System.in);
        System.out.println("Introduzca el nombre del policia: ");
        String nombre = entrada.next();
        return nombre;

    }

    public static String pedirDepartamento() {   //M�todo String que devuelve un String modificado a trav�s de un men�
        String departamento = "";       //El String se inicializa vac�o, en funci�n de las opciones que elijamos cambiar� a una u otra palabra
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

    public static String pedirPermisoArma() {        //M�todo String que devuelve un String modificado a trav�s de un men�
        String permiso = "";            //El String se inicializa vac�o, en funci�n de las opciones que elijamos cambiar� a una u otra palabra
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

    public static String pedirRango() {           //M�todo String que devuelve un String modificado a trav�s de un men�
        String rango = "";                             //El String se inicializa vac�o, en funci�n de las opciones que elijamos cambiar� a una u otra palabra
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
