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
    public String toString() {      //Método toString()
        return "Almacen{" + "armas=" + armas + '}';
    }

    public Arma elegirArma() {       //Método para elegir un arma, devolverlo y asignárselo al jugador principal
        Arma armaElegida = null;    //Inicializamos un objeto vacío en la superclase arma. IMPORTANTE: La única razón de devolver un objeto null es por mejorar el control que hemos establecido más tarde en el menú del almacén, para que no salte el mensaje "el jugador ya lleva ese arma" en caso de no encontrar ninguna

        Arma aux = buscarArma();        //Inicializamos una variable auxiliar en lo que nos aparezca en buscarArma

        if (aux != null) {      //Si buscarArma() nos devuelve un objeto y no un null, sobreescribimos el arma elegida con aux

            armaElegida = aux;

        }

        return armaElegida;     //Si no hemos encontrado el arma, devolvemos el objeto vacío
    }

    public void eliminarArma() {        //Método para eliminar un arma del mapa

        if (armas.isEmpty()) {   //Si el mapa está vacío, nos cuidamos de nullPointerException imprimiendo este mensaje
            System.out.println(Constantes.FONDO_ROJO + "[x] No hay armas en el almacen." + Constantes.BORRAR);
        } else {    //Si hay armas en el mapa, inicializamos una variable auxiliar con lo que nos devuelva el método buscarArma() y otra con su índice en el mapa

            System.out.println(Constantes.FONDO_ROJO + "[*] [*] [*] Eliminando arma... [*] [*] [*] " + Constantes.BORRAR);

            Arma aux = buscarArma();

            if (aux != null) {  //Si buscarArma() nos devuelve un objeto y no un null, lo eliminamos de la lista. De lo contrario, nada sucederá y el propio método buscar nos dirá que el arma no ha sido encontrado
                String idaux = aux.getIdentificador();      //Necesitamos asignar el índice del arma aux DESPUÉS de asegurarnos que no es null
                armas.remove(idaux);
                System.out.println(Constantes.FONDO_VERDE + "[v] Arma eliminada." + Constantes.BORRAR);
            }
        }
    }

    public Arma buscarArma() {       //Método para buscar un arma y devolverla. Este método se utilizará para ejecutar los demás de esta clase
        Scanner entrada = new Scanner(System.in);
        boolean enc = false;
        Arma armaBuscada = null;         //Inicializamos el arma que vamos a buscar en null

        Iterator<String> it = armas.keySet().iterator();            //Creamos el iterador que usaremos para recorrer el mapa con el índice (keySet()) de los objetos en el mapa
        System.out.println("Escribe el identificador del arma: ");
        String respuesta = entrada.next();      //Buscamos el ID de un arma a través del escáner

        while (!enc && it.hasNext()) {      //Las condiciones son que enc permanezca en falso y que siga habiendo objetos en el mapa
            String clave = it.next();      //Almacenamos el índice del siguiente objeto en el mapa en una variable String 
            Arma actual = armas.get(clave);     //Inicializamos un objeto arma para almacenar el arma actual del mapa según lo vamos recorriendo

            if (respuesta.equalsIgnoreCase(actual.getIdentificador())) {    //Si el id buscado coincide con el número de placa del policía actual en la lista, este sobreescribe al armaBuscado (que estaba en null)
                armaBuscada = actual;
                enc = true;     //Enc cambia a true y el bucle se cierra

                System.out.println(Constantes.FONDO_VERDE + "[v] Arma encontrada" + Constantes.BORRAR);

            }

        }

        if (!enc) {     //Si llegamos al final de la lista sin encontrar el objeto, enc nunca cambiará a true y este mensaje aparecerá.
            System.out.println(Constantes.FONDO_ROJO + "Arma no encontrada." + Constantes.BORRAR);
        }

        return armaBuscada;     //El objeto devuelto seguirá en null si no se ha encontrado nada, o será el que tenga el ID buscado

    }

    public void modificarArma() {        //Método para modificar un arma del mapa

        if (armas.isEmpty()) {      //Si el mapa está vacío, nos cuidamos de nullPointerException imprimiendo este mensaje
            System.out.println(Constantes.FONDO_ROJO + "[x] No hay armas en el almacen." + Constantes.BORRAR);
        } else {          //Si hay armas en el mapa, inicializamos una variable auxiliar con lo que nos devuelva el método buscarArma()
            Arma aux = buscarArma();

            if (aux != null && aux instanceof ArmaCortoAlcance) {       //Asegurando que el arma aux no es un objeto null, y en función del tipo de arma llamamos a un método u otro para modificar aux
                modificarArmaCortoAlcance(aux);
            } else if (aux != null && aux instanceof ArmaLargoAlcance) {
                modificarArmaLargoAlcance(aux);
            }

        }

    }

    public void modificarArmaLargoAlcance(Arma arma) {      //Método que recibe por parámetro un objeto de tipo arma para modificar sus atributos
        Scanner entrada = new Scanner(System.in);
        System.out.println(Constantes.CELESTE + "[*] [*] [*] Modificando arma... [*] [*] [*]" + Constantes.BORRAR);
        System.out.println("¿Qué atributo quieres modificar?");
        System.out.println("[1] Numero de balas del cartucho");
        System.out.println("[2] Diametro de bala");
        System.out.println("[3] Velocidad");
        try {
            switch (entrada.nextInt()) {        //Se inicia un menú para preguntar por el atributo a modificar. En cada opción llamaremos al setter correspondiente para modificar el atributo deseado
                case 1:
                    arma.setCargador(pedirTamañoCargador());        //El setter llama al método que devuelve el tamaño del cargador
                    System.out.println(Constantes.FONDO_VERDE + "[v] Arma modificada" + Constantes.BORRAR);

                    break;
                case 2:
                    arma.setDiametro(pedirDiametro());      //El setter llama al método que devuelve el diámetro
                    System.out.println(Constantes.FONDO_VERDE + "[v] Arma modificada" + Constantes.BORRAR);

                    break;

                case 3:
                    ((ArmaLargoAlcance) arma).setVelocidad(pedirVelocidad());           //Mediante polimorfismo, el setter llama al método que devuelve la velocidad
                    System.out.println(Constantes.FONDO_VERDE + "[v] Arma modificada" + Constantes.BORRAR);

                    break;
                default:
                    System.out.println(Constantes.AMARILLO + "Opcion no permitida" + Constantes.BORRAR);
            }

        } catch (InputMismatchException e) {
            System.out.println(Constantes.FONDO_ROJO + "Error. Debes introducir un numero." + Constantes.BORRAR);
        }
    }

    public void modificarArmaCortoAlcance(Arma arma) {      //Método que recibe por parámetro un objeto de tipo arma para modificar sus atributos
        Scanner entrada = new Scanner(System.in);
        System.out.println(Constantes.CELESTE + "[*] [*] [*] Modificando arma... [*] [*] [*]" + Constantes.BORRAR);
        System.out.println("¿Qué atributo quieres modificar?");
        System.out.println("[1] Numero de balas del cartucho");
        System.out.println("[2] Diametro de bala");
        System.out.println("[3] Alcance");
        try {
            switch (entrada.nextInt()) {        //Se inicia un menú para preguntar por el atributo a modificar. En cada opción llamaremos al setter correspondiente para modificar el atributo deseado
                case 1:
                    arma.setCargador(pedirTamañoCargador());         //El setter llama al método que devuelve el tamaño del cargador
                    System.out.println(Constantes.FONDO_VERDE + "[v] Arma modificada" + Constantes.BORRAR);

                    break;
                case 2:
                    arma.setDiametro(pedirDiametro());           //El setter llama al método que devuelve el diámetro
                    System.out.println(Constantes.FONDO_VERDE + "[v] Arma modificada" + Constantes.BORRAR);

                    break;

                case 3:
                    ((ArmaCortoAlcance) arma).setAlcance(pedirAlcance());       //Mediante polimorfismo, el setter llama al método que devuelve el alcance
                    System.out.println(Constantes.FONDO_VERDE + "[v] Arma modificada" + Constantes.BORRAR);

                    break;
                default:
                    System.out.println(Constantes.AMARILLO + "Opcion no permitida" + Constantes.BORRAR);
            }

        } catch (InputMismatchException e) {
            System.out.println(Constantes.FONDO_ROJO + "Error. Debes introducir un numero." + Constantes.BORRAR);
        }
    }

    public void mostrarArmas() {          //Método para ir mostrando todas las armas de la lista. Por cuestiones de comodidad, configuramos la presentación en este método en lugar de hacerlo en toString(), ya que tendríamos que combinar el toString() de la superclase con el de la subclase

        System.out.println(Constantes.CELESTE + "[*] [*] [*] Mostrando armas... [*] [*] [*]" + Constantes.BORRAR);

        if (armas.isEmpty()) {           //Si el mapa está vacío, nos cuidamos de nullPointerException imprimiendo este mensaje
            System.out.println(Constantes.FONDO_ROJO + "[x] No hay armas en el almacen." + Constantes.BORRAR);
        } else {
            Iterator<String> it = armas.keySet().iterator();            //Creamos el iterador que usaremos para recorrer el mapa con el índice (keySet()) de los objetos en el mapa
            while (it.hasNext()) {      //La condición es que haya más objetos en el mapa
                String clave = it.next();      //Almacenamos el índice del objeto en un String
                Arma aux = armas.get(clave);        //Inicializamos una variable auxiliar en la que almacenamos el siguiente objeto del mapa, usando la el ID almacenado en clave como índice

                if (aux instanceof ArmaCortoAlcance) {          //En función del tipo de arma, mostramos un mensaje u otro
                    System.out.println("Arma de corto alcance - ID: " + aux.getIdentificador());
                } else if (aux instanceof ArmaLargoAlcance) {       //Aunque no es necesario usar un else if porque solo hay dos opciones, nos aseguramos de cubrir la contigencia específica y evitamos un warning
                    System.out.println("Arma de largo alcance - ID: " + aux.getIdentificador());
                }

                System.out.println("Daño: " + aux.getDaño());
                System.out.println("Diámetro bala: " + aux.getDiametro());
                System.out.println("Tamaño cargador: " + aux.getCargador().length);

                int contador = 0;
                int i;

                for (i = 0; i < aux.getCargador().length; i++) {        // Recorremos el array mientras no lleguemos al final
                    if (aux.getCargador()[i] != null) {     //Por cada bala que encontremos (not null), se aumenta el cargador en uno
                        contador++;
                    }
                    i++;        // Incrementamos el índice en cada iteración. Esto OPTIMIZA LA UTILIZACIÓN DE RECURSOS ya que el array no seguirá recorriéndose aunque ya no queden Balas
                }

                System.out.println("Nº balas: " + contador);

                if (aux instanceof ArmaCortoAlcance) {      //En función de si el arma es de un tipo u otro, utilizamos el polimofrismo para mostrar el atributo particular de cada tipo de arma (alcance o velocidad)
                    System.out.println("Alcance: " + ((ArmaCortoAlcance) aux).getAlcance());
                } else if (aux instanceof ArmaLargoAlcance) {
                    System.out.println("Velocidad: " + ((ArmaLargoAlcance) aux).getVelocidad());
                }
                System.out.println("");

            }

        }
    }

    public void crearArma() {   //Método para crear un objeto Arma y añadirlo al mapa
        Scanner entrada = new Scanner(System.in);
        Arma aux;       //Declaramos una variable de tipo arma sin inicializar
        String idaux;   //Hacemos lo mismo con un String que guardará el ID de dicho arma
        System.out.println(Constantes.CELESTE + "[*] [*] [*] Creando arma... [*] [*] [*]" + Constantes.BORRAR);

        System.out.println("¿Que tipo de arma quieres crear?");
        System.out.println("[1] Corto Alcance");
        System.out.println("[2] Largo Alcance");
        try {
            switch (entrada.nextInt()) {            //Iniciamos un menú con dos opciones para crear un arma de corto o de largo alcance
                case 1:
                    aux = new ArmaCortoAlcance();       //Si se elige la primera opción, la variable aux se inicializa en la subclase ArmaCortoAlcance
                    idaux = aux.getIdentificador();     //La variable idaux se inicializa con el identificador de aux
                    aux.setDiametro(pedirDiametro());
                    ((ArmaCortoAlcance) aux).setAlcance(pedirAlcance());            //Usamos el polimorfismo para asignarle el valor Alcance a aux
                    armas.put(idaux, aux);               //Añadimos aux al mapa
                    System.out.println(Constantes.FONDO_VERDE + "[v] Arma creada en el almacen" + Constantes.BORRAR);

                    break;
                case 2:
                    aux = new ArmaLargoAlcance();         //Si se elige la segunda opción, la variable aux se inicializa en la subclase ArmaLargoAlcance
                    idaux = aux.getIdentificador();         //La variable idaux se inicializa con el identificador de aux
                    aux.setDiametro(pedirDiametro());
                    ((ArmaLargoAlcance) aux).setVelocidad(pedirVelocidad());            //Usamos el polimorfismo para asignarle el valor Velocidad a aux
                    armas.put(idaux, aux);      //Añadimos aux al mapa
                    System.out.println(Constantes.FONDO_VERDE + "[v] Arma creada en el almacen" + Constantes.BORRAR);

                    break;
                default:
                    System.out.println(Constantes.AMARILLO + "No se pueden crear armas del tipo seleccionado." + Constantes.BORRAR);
            }
        } catch (InputMismatchException e) {
            System.out.println(Constantes.FONDO_ROJO + "Error. Se debe introducir un numero." + Constantes.BORRAR);
        }
    }

    public Bala[] pedirTamañoCargador() {       //Método Bala[] que devuelve un Array de objetos de tipo bala, cuya longitud es introducida a través del escáner
        Scanner entrada = new Scanner(System.in);
        boolean cerrar = false;
        Bala[] cargador = new Bala[10];     //Hemos inicializado el cargador para poder implementar el try/ catch. Aunque no tenga relevancia mayor, la variable se ha inicializado en diez, que es el valor por defecto que asignamos en el constructor de las armas después se alterará a través del escáner

        do {          //El bucle se cerrará cuando el usuario introduzca un número
            try {
                System.out.println("Introduzca nuevo tamaño del cargador: ");
                cargador = new Bala[entrada.nextInt()];           //Pedimos el tamaño del cargador a través de un escáner
                cerrar = true;
            } catch (InputMismatchException e) {
                System.out.println(Constantes.FONDO_ROJO + "Error. Se debe introducir un numero." + Constantes.BORRAR);
                entrada.next();

            }
        } while (!cerrar);

        return cargador;    //Devolvemos el Array de objetos Bala con la longitud que le hemos asignado

    }

    public int pedirDiametro() {        //Método int que devuelve una variable introducida por escáner
        Scanner entrada = new Scanner(System.in);
        boolean cerrar = false;
        int diametro = 0;            //La variable se inicializa en cero, después se alterará a través del escáner

        do {                 //El bucle se cerrará cuando el usuario introduzca un número
            try {
                System.out.println("Diametro de bala: ");           //Pedimos el diámetro a través de un escáner
                diametro = entrada.nextInt();
                cerrar = true;
            } catch (InputMismatchException e) {
                System.out.println(Constantes.FONDO_ROJO + "Error. Se debe introducir un numero." + Constantes.BORRAR);
                entrada.next();

            }
        } while (!cerrar);
        return diametro;        //Devolvemos el int diámetro alterado

    }

    public int pedirAlcance() {     //Método int que devuelve una variable introducida por escáner
        Scanner entrada = new Scanner(System.in);
        boolean cerrar = false;
        int alcance = 0;                //La variable se inicializa en cero, después se alterará a través del escáner

        do {                //El bucle se cerrará cuando el usuario introduzca un número
            try {
                System.out.println("Alcance de bala: ");        //Pedimos el alcance a través de un escáner
                alcance = entrada.nextInt();
                cerrar = true;
            } catch (InputMismatchException e) {
                System.out.println(Constantes.FONDO_ROJO + "Error. Se debe introducir un numero." + Constantes.BORRAR);
                entrada.next();

            }
        } while (!cerrar);
        return alcance;         //Devolvemos el int alcance alterado

    }

    public double pedirVelocidad() {        //Método double que devuelve una variable introducida por escáner
        Scanner entrada = new Scanner(System.in);
        boolean cerrar = false;
        double velocidad = 0;       //La variable se inicializa en cero, después se alterará a través del escáner

        do {        //El bucle se cerrará cuando el usuario introduzca un número
            try {
                System.out.println("Velocidad de bala: ");      //Pedimos la velocidad a través de un escáner
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
