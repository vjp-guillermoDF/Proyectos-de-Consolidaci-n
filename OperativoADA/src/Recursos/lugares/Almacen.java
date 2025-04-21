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

    private Map<String, Arma> armas;        //Declaramos el atributo como un mapa

    public Almacen() {      //En el constructor por defecto, usamos el polimorfismo para inicializarlo como un HashMap
        this.armas = new HashMap();
    }

    public Almacen(Map<String, Arma> armas) {       //Constructor parametrizado
        this.armas = armas;
    }

    public Map<String, Arma> getArmas() {       //Getter y setter
        return armas;
    }

    public void setArmas(Map<String, Arma> armas) {
        this.armas = armas;
    }

    @Override
    public String toString() {      //M�todo toString()
        return "Almacen{" + "armas=" + armas + '}';
    }

    public Arma elegirArma() {       //M�todo para elegir un arma, devolverlo y asign�rselo al jugador principal
        Arma armaElegida = null;    //Inicializamos un objeto vac�o en la superclase arma. IMPORTANTE: La �nica raz�n de devolver un objeto null es por mejorar el control que hemos establecido m�s tarde en el men� del almac�n, para que no salte el mensaje "el jugador ya lleva ese arma" en caso de no encontrar ninguna

        Arma aux = buscarArma();        //Inicializamos una variable auxiliar en lo que nos aparezca en buscarArma

        if (aux != null) {      //Si buscarArma() nos devuelve un objeto y no un null, sobreescribimos el arma elegida con aux

            armaElegida = aux;

        }

        return armaElegida;     //Si no hemos encontrado el arma, devolvemos el objeto vac�o
    }

    public void eliminarArma() {        //M�todo para eliminar un arma del mapa

        if (armas.isEmpty()) {   //Si el mapa est� vac�o, nos cuidamos de nullPointerException imprimiendo este mensaje
            System.out.println(Constantes.FONDO_ROJO + "[x] No hay armas en el almacen." + Constantes.BORRAR);
        } else {    //Si hay armas en el mapa, inicializamos una variable auxiliar con lo que nos devuelva el m�todo buscarArma() y otra con su �ndice en el mapa

            System.out.println(Constantes.FONDO_ROJO + "[*] [*] [*] Eliminando arma... [*] [*] [*] " + Constantes.BORRAR);

            Arma aux = buscarArma();

            if (aux != null) {  //Si buscarArma() nos devuelve un objeto y no un null, lo eliminamos de la lista. De lo contrario, nada suceder� y el propio m�todo buscar nos dir� que el arma no ha sido encontrado
                String idaux = aux.getIdentificador();      //Necesitamos asignar el �ndice del arma aux DESPU�S de asegurarnos que no es null
                armas.remove(idaux);
                System.out.println(Constantes.FONDO_VERDE + "[v] Arma eliminada." + Constantes.BORRAR);
            }
        }
    }

    public Arma buscarArma() {       //M�todo para buscar un arma y devolverla. Este m�todo se utilizar� para ejecutar los dem�s de esta clase
        Scanner entrada = new Scanner(System.in);
        boolean enc = false;
        Arma armaBuscada = null;         //Inicializamos el arma que vamos a buscar en null

        Iterator<String> it = armas.keySet().iterator();            //Creamos el iterador que usaremos para recorrer el mapa con el �ndice (keySet()) de los objetos en el mapa
        System.out.println("Escribe el identificador del arma: ");
        String respuesta = entrada.next();      //Buscamos el ID de un arma a trav�s del esc�ner

        while (!enc && it.hasNext()) {      //Las condiciones son que enc permanezca en falso y que siga habiendo objetos en el mapa
            String clave = it.next();      //Almacenamos el �ndice del siguiente objeto en el mapa en una variable String 
            Arma actual = armas.get(clave);     //Inicializamos un objeto arma para almacenar el arma actual del mapa seg�n lo vamos recorriendo

            if (respuesta.equalsIgnoreCase(actual.getIdentificador())) {    //Si el id buscado coincide con el n�mero de placa del polic�a actual en la lista, este sobreescribe al armaBuscado (que estaba en null)
                armaBuscada = actual;
                enc = true;     //Enc cambia a true y el bucle se cierra

                System.out.println(Constantes.FONDO_VERDE + "[v] Arma encontrada" + Constantes.BORRAR);

            }

        }

        if (!enc) {     //Si llegamos al final de la lista sin encontrar el objeto, enc nunca cambiar� a true y este mensaje aparecer�.
            System.out.println(Constantes.FONDO_ROJO + "Arma no encontrada." + Constantes.BORRAR);
        }

        return armaBuscada;     //El objeto devuelto seguir� en null si no se ha encontrado nada, o ser� el que tenga el ID buscado

    }

    public void modificarArma() {        //M�todo para modificar un arma del mapa

        if (armas.isEmpty()) {      //Si el mapa est� vac�o, nos cuidamos de nullPointerException imprimiendo este mensaje
            System.out.println(Constantes.FONDO_ROJO + "[x] No hay armas en el almacen." + Constantes.BORRAR);
        } else {          //Si hay armas en el mapa, inicializamos una variable auxiliar con lo que nos devuelva el m�todo buscarArma()
            Arma aux = buscarArma();

            if (aux != null && aux instanceof ArmaCortoAlcance) {       //Asegurando que el arma aux no es un objeto null, y en funci�n del tipo de arma llamamos a un m�todo u otro para modificar aux
                modificarArmaCortoAlcance(aux);
            } else if (aux != null && aux instanceof ArmaLargoAlcance) {
                modificarArmaLargoAlcance(aux);
            }

        }

    }

    public void modificarArmaLargoAlcance(Arma arma) {      //M�todo que recibe por par�metro un objeto de tipo arma para modificar sus atributos
        Scanner entrada = new Scanner(System.in);
        System.out.println(Constantes.CELESTE + "[*] [*] [*] Modificando arma... [*] [*] [*]" + Constantes.BORRAR);
        System.out.println("�Qu� atributo quieres modificar?");
        System.out.println("[1] Numero de balas del cartucho");
        System.out.println("[2] Diametro de bala");
        System.out.println("[3] Velocidad");
        try {
            switch (entrada.nextInt()) {        //Se inicia un men� para preguntar por el atributo a modificar. En cada opci�n llamaremos al setter correspondiente para modificar el atributo deseado
                case 1:
                    arma.setCargador(pedirTama�oCargador());        //El setter llama al m�todo que devuelve el tama�o del cargador
                    System.out.println(Constantes.FONDO_VERDE + "[v] Arma modificada" + Constantes.BORRAR);

                    break;
                case 2:
                    arma.setDiametro(pedirDiametro());      //El setter llama al m�todo que devuelve el di�metro
                    System.out.println(Constantes.FONDO_VERDE + "[v] Arma modificada" + Constantes.BORRAR);

                    break;

                case 3:
                    ((ArmaLargoAlcance) arma).setVelocidad(pedirVelocidad());           //Mediante polimorfismo, el setter llama al m�todo que devuelve la velocidad
                    System.out.println(Constantes.FONDO_VERDE + "[v] Arma modificada" + Constantes.BORRAR);

                    break;
                default:
                    System.out.println(Constantes.AMARILLO + "Opcion no permitida" + Constantes.BORRAR);
            }

        } catch (InputMismatchException e) {
            System.out.println(Constantes.FONDO_ROJO + "Error. Debes introducir un numero." + Constantes.BORRAR);
        }
    }

    public void modificarArmaCortoAlcance(Arma arma) {      //M�todo que recibe por par�metro un objeto de tipo arma para modificar sus atributos
        Scanner entrada = new Scanner(System.in);
        System.out.println(Constantes.CELESTE + "[*] [*] [*] Modificando arma... [*] [*] [*]" + Constantes.BORRAR);
        System.out.println("�Qu� atributo quieres modificar?");
        System.out.println("[1] Numero de balas del cartucho");
        System.out.println("[2] Diametro de bala");
        System.out.println("[3] Alcance");
        try {
            switch (entrada.nextInt()) {        //Se inicia un men� para preguntar por el atributo a modificar. En cada opci�n llamaremos al setter correspondiente para modificar el atributo deseado
                case 1:
                    arma.setCargador(pedirTama�oCargador());         //El setter llama al m�todo que devuelve el tama�o del cargador
                    System.out.println(Constantes.FONDO_VERDE + "[v] Arma modificada" + Constantes.BORRAR);

                    break;
                case 2:
                    arma.setDiametro(pedirDiametro());           //El setter llama al m�todo que devuelve el di�metro
                    System.out.println(Constantes.FONDO_VERDE + "[v] Arma modificada" + Constantes.BORRAR);

                    break;

                case 3:
                    ((ArmaCortoAlcance) arma).setAlcance(pedirAlcance());       //Mediante polimorfismo, el setter llama al m�todo que devuelve el alcance
                    System.out.println(Constantes.FONDO_VERDE + "[v] Arma modificada" + Constantes.BORRAR);

                    break;
                default:
                    System.out.println(Constantes.AMARILLO + "Opcion no permitida" + Constantes.BORRAR);
            }

        } catch (InputMismatchException e) {
            System.out.println(Constantes.FONDO_ROJO + "Error. Debes introducir un numero." + Constantes.BORRAR);
        }
    }

    public void mostrarArmas() {          //M�todo para ir mostrando todas las armas de la lista. Por cuestiones de comodidad, configuramos la presentaci�n en este m�todo en lugar de hacerlo en toString(), ya que tendr�amos que combinar el toString() de la superclase con el de la subclase

        System.out.println(Constantes.CELESTE + "[*] [*] [*] Mostrando armas... [*] [*] [*]" + Constantes.BORRAR);

        if (armas.isEmpty()) {           //Si el mapa est� vac�o, nos cuidamos de nullPointerException imprimiendo este mensaje
            System.out.println(Constantes.FONDO_ROJO + "[x] No hay armas en el almacen." + Constantes.BORRAR);
        } else {
            Iterator<String> it = armas.keySet().iterator();            //Creamos el iterador que usaremos para recorrer el mapa con el �ndice (keySet()) de los objetos en el mapa
            while (it.hasNext()) {      //La condici�n es que haya m�s objetos en el mapa
                String clave = it.next();      //Almacenamos el �ndice del objeto en un String
                Arma aux = armas.get(clave);        //Inicializamos una variable auxiliar en la que almacenamos el siguiente objeto del mapa, usando la el ID almacenado en clave como �ndice

                if (aux instanceof ArmaCortoAlcance) {          //En funci�n del tipo de arma, mostramos un mensaje u otro
                    System.out.println("Arma de corto alcance - ID: " + aux.getIdentificador());
                } else if (aux instanceof ArmaLargoAlcance) {       //Aunque no es necesario usar un else if porque solo hay dos opciones, nos aseguramos de cubrir la contigencia espec�fica y evitamos un warning
                    System.out.println("Arma de largo alcance - ID: " + aux.getIdentificador());
                }

                System.out.println("Da�o: " + aux.getDa�o());
                System.out.println("Di�metro bala: " + aux.getDiametro());
                System.out.println("Tama�o cargador: " + aux.getCargador().length);

                int contador = 0;
                int i;

                for (i = 0; i < aux.getCargador().length; i++) {        // Recorremos el array mientras no lleguemos al final
                    if (aux.getCargador()[i] != null) {     //Por cada bala que encontremos (not null), se aumenta el cargador en uno
                        contador++;
                    }
                    i++;        // Incrementamos el �ndice en cada iteraci�n. Esto OPTIMIZA LA UTILIZACI�N DE RECURSOS ya que el array no seguir� recorri�ndose aunque ya no queden Balas
                }

                System.out.println("N� balas: " + contador);

                if (aux instanceof ArmaCortoAlcance) {      //En funci�n de si el arma es de un tipo u otro, utilizamos el polimofrismo para mostrar el atributo particular de cada tipo de arma (alcance o velocidad)
                    System.out.println("Alcance: " + ((ArmaCortoAlcance) aux).getAlcance());
                } else if (aux instanceof ArmaLargoAlcance) {
                    System.out.println("Velocidad: " + ((ArmaLargoAlcance) aux).getVelocidad());
                }
                System.out.println("");

            }

        }
    }

    public void crearArma() {   //M�todo para crear un objeto Arma y a�adirlo al mapa
        Scanner entrada = new Scanner(System.in);
        Arma aux;       //Declaramos una variable de tipo arma sin inicializar
        String idaux;   //Hacemos lo mismo con un String que guardar� el ID de dicho arma
        System.out.println(Constantes.CELESTE + "[*] [*] [*] Creando arma... [*] [*] [*]" + Constantes.BORRAR);

        System.out.println("�Que tipo de arma quieres crear?");
        System.out.println("[1] Corto Alcance");
        System.out.println("[2] Largo Alcance");
        try {
            switch (entrada.nextInt()) {            //Iniciamos un men� con dos opciones para crear un arma de corto o de largo alcance
                case 1:
                    aux = new ArmaCortoAlcance();       //Si se elige la primera opci�n, la variable aux se inicializa en la subclase ArmaCortoAlcance
                    idaux = aux.getIdentificador();     //La variable idaux se inicializa con el identificador de aux
                    aux.setDiametro(pedirDiametro());
                    ((ArmaCortoAlcance) aux).setAlcance(pedirAlcance());            //Usamos el polimorfismo para asignarle el valor Alcance a aux
                    armas.put(idaux, aux);               //A�adimos aux al mapa
                    System.out.println(Constantes.FONDO_VERDE + "[v] Arma creada en el almacen" + Constantes.BORRAR);

                    break;
                case 2:
                    aux = new ArmaLargoAlcance();         //Si se elige la segunda opci�n, la variable aux se inicializa en la subclase ArmaLargoAlcance
                    idaux = aux.getIdentificador();         //La variable idaux se inicializa con el identificador de aux
                    aux.setDiametro(pedirDiametro());
                    ((ArmaLargoAlcance) aux).setVelocidad(pedirVelocidad());            //Usamos el polimorfismo para asignarle el valor Velocidad a aux
                    armas.put(idaux, aux);      //A�adimos aux al mapa
                    System.out.println(Constantes.FONDO_VERDE + "[v] Arma creada en el almacen" + Constantes.BORRAR);

                    break;
                default:
                    System.out.println(Constantes.AMARILLO + "No se pueden crear armas del tipo seleccionado." + Constantes.BORRAR);
            }
        } catch (InputMismatchException e) {
            System.out.println(Constantes.FONDO_ROJO + "Error. Se debe introducir un numero." + Constantes.BORRAR);
        }
    }

    public Bala[] pedirTama�oCargador() {       //M�todo Bala[] que devuelve un Array de objetos de tipo bala, cuya longitud es introducida a trav�s del esc�ner
        Scanner entrada = new Scanner(System.in);
        boolean cerrar = false;
        Bala[] cargador = new Bala[10];     //Hemos inicializado el cargador para poder implementar el try/ catch. Aunque no tenga relevancia mayor, la variable se ha inicializado en diez, que es el valor por defecto que asignamos en el constructor de las armas despu�s se alterar� a trav�s del esc�ner

        do {          //El bucle se cerrar� cuando el usuario introduzca un n�mero
            try {
                System.out.println("Introduzca nuevo tama�o del cargador: ");
                cargador = new Bala[entrada.nextInt()];           //Pedimos el tama�o del cargador a trav�s de un esc�ner
                cerrar = true;
            } catch (InputMismatchException e) {
                System.out.println(Constantes.FONDO_ROJO + "Error. Se debe introducir un numero." + Constantes.BORRAR);
                entrada.next();

            }
        } while (!cerrar);

        return cargador;    //Devolvemos el Array de objetos Bala con la longitud que le hemos asignado

    }

    public int pedirDiametro() {        //M�todo int que devuelve una variable introducida por esc�ner
        Scanner entrada = new Scanner(System.in);
        boolean cerrar = false;
        int diametro = 0;            //La variable se inicializa en cero, despu�s se alterar� a trav�s del esc�ner

        do {                 //El bucle se cerrar� cuando el usuario introduzca un n�mero
            try {
                System.out.println("Diametro de bala: ");           //Pedimos el di�metro a trav�s de un esc�ner
                diametro = entrada.nextInt();
                cerrar = true;
            } catch (InputMismatchException e) {
                System.out.println(Constantes.FONDO_ROJO + "Error. Se debe introducir un numero." + Constantes.BORRAR);
                entrada.next();

            }
        } while (!cerrar);
        return diametro;        //Devolvemos el int di�metro alterado

    }

    public int pedirAlcance() {     //M�todo int que devuelve una variable introducida por esc�ner
        Scanner entrada = new Scanner(System.in);
        boolean cerrar = false;
        int alcance = 0;                //La variable se inicializa en cero, despu�s se alterar� a trav�s del esc�ner

        do {                //El bucle se cerrar� cuando el usuario introduzca un n�mero
            try {
                System.out.println("Alcance de bala: ");        //Pedimos el alcance a trav�s de un esc�ner
                alcance = entrada.nextInt();
                cerrar = true;
            } catch (InputMismatchException e) {
                System.out.println(Constantes.FONDO_ROJO + "Error. Se debe introducir un numero." + Constantes.BORRAR);
                entrada.next();

            }
        } while (!cerrar);
        return alcance;         //Devolvemos el int alcance alterado

    }

    public double pedirVelocidad() {        //M�todo double que devuelve una variable introducida por esc�ner
        Scanner entrada = new Scanner(System.in);
        boolean cerrar = false;
        double velocidad = 0;       //La variable se inicializa en cero, despu�s se alterar� a trav�s del esc�ner

        do {        //El bucle se cerrar� cuando el usuario introduzca un n�mero
            try {
                System.out.println("Velocidad de bala: ");      //Pedimos la velocidad a trav�s de un esc�ner
                velocidad = entrada.nextDouble();
                cerrar = true;
            } catch (InputMismatchException e) {
                System.out.println(Constantes.FONDO_ROJO + "Error. Se debe introducir un numero." + Constantes.BORRAR);
                entrada.next();

            }
        } while (!cerrar);

        return velocidad;        //Devolvemos el doube velocidad alterado

    }

}
