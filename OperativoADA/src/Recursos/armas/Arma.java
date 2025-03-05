/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Recursos.armas;

import General.Disparable; //Interfaz Disparable importada desde el paquete General.
import Recursos.personajes.Personajes; //Clase Personajes importada desde el paquete Recursos.personajes.
import java.util.UUID; //�til UUID para generar el ID.

/**
 *
 * @author guill
 */
public abstract class Arma implements Disparable { //La clase implemente la interfaz Disparable.

    private String identificador;    //Atributos de la clase.

    private int da�o;

    private int diametro;

    private Bala[] cargador;

    public Arma(int da�o, int diametro) { //Constructor parametrizado.
        this.identificador = generarID(); //Este atributo se inicializa siempre llamando al m�todo generarID(), por lo que no se mete en los par�metros.
        this.da�o = da�o;
        this.diametro = diametro;
        this.cargador = new Bala[10];
    }

    public Arma() { //Constructor por defecto.
        this.identificador = generarID(); //Se inicializa por defecto llamando al m�todo generarID().
        this.da�o = 0;
        this.diametro = 0;
        this.cargador = new Bala[10];

    }
    //Getters, setters y toString().

    public String getIdentificador() {
        return identificador;
    }

    public void setIdentificador(String identificador) {
        this.identificador = identificador;
    }

    public int getDa�o() {
        return da�o;
    }

    public void setDa�o(int da�o) {
        this.da�o = da�o;
    }

    public int getDiametro() {
        return diametro;
    }

    public void setDiametro(int diametro) {
        this.diametro = diametro;
    }

    public Bala[] getCargador() {
        return cargador;
    }

    public void setCargador(Bala[] cargador) {
        this.cargador = cargador;
    }

    @Override
    public String toString() {
        return "Arma{" + "identificador = " + identificador + ", da\u00f1o = " + da�o + ", diametro = " + diametro + ", cargador = " + cargador.length + ", numero de balas = " + obtenerNumeroBalas() + '}';
    }

    public static String generarID() { //M�todo que utiliza UUID para generar un ID al azar y lo devuelve.
        String identificador = UUID.randomUUID().toString();
        return identificador;
    }

    public abstract void disparar(Personajes enemigo); //M�todo abstracto que recibe un objeto de tipo Personajes.

    @Override
    public void apuntar(Personajes enemigo) { //M�todo apuntar implementado desde la interfaz Disparable.
        if (enemigo == null) { //Si el enemigo es igual a null, es decir, si no hay enemigo, se muestra un mensaje.
            System.out.println("No hay enemigo al que apuntar.");
        } else { //De lo contrario, se muestra el ID del arma y se muestra un mensaje que incluye el nombre del enemigo, sus cooordenadas y el da�o del arma.
            System.out.println("El arma con ID [" + identificador + "] esta apuntando al enemigo: [" + enemigo.getNombre() + "].");
            System.out.println("\nCoordenadas del enemigo: ([" + enemigo.getCoordenadaX() + "],[" + enemigo.getCoordenadaY() + "]).");
            System.out.println("\nEl da�o potencial de este disparo es: [" + da�o + "].");
            if (diametro < 5) { //Si el valor di�metro es menor a 5, se muestra un mensaje.
                System.out.println("\nDiametro de bala peque�o: {" + getDiametro() + "] mm. El disparo tiene una probabilidad de acierto baja.\n");
            } else if (diametro < 15) { //Pero si es igual o mayor a 5, pero menor a 15, se muestra otro.
                System.out.println("\nDiametro de bala normal: [" + getDiametro() + "] mm. El disparo tiene una probabilidad de acierto media.\n");
            } else { //De lo contrario (es decir, si es mayor que 15), se mostrar� otro mensaje.
                System.out.println("\nDiametro de bala grande: [" + getDiametro() + "] mm. El disparo sera mas preciso.\n");
            }
        }
    }

    @Override
    public void cargarArma() {
        System.out.println("Cargando arma...\n");

        for (int i = 0; i < cargador.length; i++) {
            cargador[i] = new Bala(); // Se asigna un nuevo objeto Bala en cada posici�n para recargarla
        }
        System.out.println("El arma est� cargada.\n");
    }

    @Override
    public int obtenerNumeroBalas() {
        System.out.println("Obteniendo numero de balas...\n");
        int contador = 0;
        for (Bala i : cargador) {
            if (i != null) {
                contador++;
            }
        }
        return contador;
    }

    @Override
    public void eliminarBala() {
        boolean balaEliminada = false; //Creamos una variable de control inicializada en false
        boolean cargadorVacio = true; //Otra variable de control para comprobar que el cargador est� vac�o
        System.out.println("Eliminando bala del arma...\n");

        for (int i = cargador.length - 1; i >= 0; i--) {//Recorremos el array al rev�s
            if (cargador[i] != null && !balaEliminada) {//Las condiciones son que el objeto del cargador no sea null y que la variable de control est� en false
                cargador[i] = null;
                cargadorVacio = false;
                balaEliminada = true;//Al cambiar la variable a true, el bucle for se detiene.

            }

        }
        if (cargadorVacio) {
            System.out.println("�Ojo! El cargador est� vac�o.");
        }
    }
}
