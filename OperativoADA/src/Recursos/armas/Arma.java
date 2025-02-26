/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Recursos.armas;

import General.Disparable; //Interfaz Disparable importada desde el paquete General.
import Recursos.personajes.Personajes; //Clase Personajes importada desde el paquete Recursos.personajes.
import java.util.UUID; //Útil UUID para generar el ID.

/**
 *
 * @author guill
 */
public abstract class Arma implements Disparable { //La clase implemente la interfaz Disparable.

    private String identificador;    //Atributos de la clase.

    private int daño;

    private int diametro;

    public Arma(int daño, int diametro) { //Constructor parametrizado.
        this.identificador = generarID(); //Este atributo se inicializa siempre llamando al método generarID(), por lo que no se mete en los parámetros.
        this.daño = daño;
        this.diametro = diametro;
    }

    public Arma() { //Constructor por defecto.
        this.identificador = generarID(); //Se inicializa por defecto llamando al método generarID().
        this.daño = 0;
        this.diametro = 0;

    }
    //Getters, setters y toString().

    public String getIdentificador() {
        return identificador;
    }

    public void setIdentificador(String identificador) {
        this.identificador = identificador;
    }

    public int getDaño() {
        return daño;
    }

    public void setDaño(int daño) {
        this.daño = daño;
    }

    public int getDiametro() {
        return diametro;
    }

    public void setDiametro(int diametro) {
        this.diametro = diametro;
    }

    @Override
    public String toString() {
        return "Arma{" + "identificador=" + identificador + ", da\u00f1o=" + daño + ", diametro=" + diametro + '}';
    }

    public static String generarID() { //Método que utiliza UUID para generar un ID al azar y lo devuelve.
        String identificador = UUID.randomUUID().toString();
        return identificador;
    }

    public abstract void disparar(Personajes enemigo); //Método abstracto que recibe un objeto de tipo Personajes.

    @Override
    public void apuntar(Personajes enemigo) { //Método apuntar implementado desde la interfaz Disparable.
        if (enemigo == null) { //Si el enemigo es igual a null, es decir, si no hay enemigo, se muestra un mensaje.
            System.out.println("No hay enemigo al que apuntar.");
        } else { //De lo contrario, se muestra el ID del arma y se muestra un mensaje que incluye el nombre del enemigo, sus cooordenadas y el daño del arma.
            System.out.println("El arma con ID [" + identificador + "] esta apuntando al enemigo: [" + enemigo.getNombre() + "].");
            System.out.println("\nCoordenadas del enemigo: ([" + enemigo.getCoordenadaX() + "],[" + enemigo.getCoordenadaY() + "]).");
            System.out.println("\nEl daño potencial de este disparo es: [" + daño + "].");
            if (diametro < 5) { //Si el valor diámetro es menor a 5, se muestra un mensaje.
                System.out.println("\nDiametro de bala pequeño: {" + getDiametro() + "] mm. El disparo tiene una probabilidad de acierto baja.\n");
            } else if (diametro < 15) { //Pero si es igual o mayor a 5, pero menor a 15, se muestra otro.
                System.out.println("\nDiametro de bala normal: [" + getDiametro() + "] mm. El disparo tiene una probabilidad de acierto media.\n");
            } else { //De lo contrario (es decir, si es mayor que 15), se mostrará otro mensaje.
                System.out.println("\nDiametro de bala grande: [" + getDiametro() + "] mm. El disparo sera mas preciso.\n");
            }
        }
    }

    @Override
    public void cargarArma() {
        System.out.println("Cargando arma...");
    }

    @Override
    public int obtenerNumeroBlas() {
        System.out.println("Obteniendo numero de balas...");
        return 0;
    }

    @Override
    public void eliminarBala() {
        System.out.println("Eliminando bala del arma...");
    }

}
