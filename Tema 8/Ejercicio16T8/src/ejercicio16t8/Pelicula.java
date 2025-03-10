/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicio16t8;

import java.util.Scanner;

/**
 *
 * @author Quique Pineda
 */
public class Pelicula {
    private String titulo;
    private float costeLicencia;
    private Socio[] vSocios;

    public Pelicula() {
        this.titulo = "";
        this.costeLicencia = 0;
        this.vSocios = new Socio[4];
        for(int i = 0;i < this.vSocios.length;i++){
            this.vSocios[i] = new Socio();
        }
    }
    
    public Pelicula(String titulo, float costeLicencia, Socio[] vSocios) {
        this.titulo = titulo;
        this.costeLicencia = costeLicencia;
        this.vSocios = vSocios;
    }
    
    public Pelicula(String titulo, float costeLicencia) {
        this.titulo = titulo;
        this.costeLicencia = costeLicencia;
        this.vSocios = new Socio[4];
        for(int i = 0;i < this.vSocios.length;i++){
            this.vSocios[i] = new Socio();
        }
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public float getCosteLicencia() {
        return costeLicencia;
    }

    public void setCosteLicencia(float costeLicencia) {
        this.costeLicencia = costeLicencia;
    }

    public Socio[] getvSocios() {
        return vSocios;
    }

    public void setvSocios(Socio[] vSocios) {
        this.vSocios = vSocios;
    }

    private static String pedirNombre(){
        Scanner tecladoS = new Scanner(System.in);
        String nombre;
        System.out.print("Nombre Socio: ");
        nombre = tecladoS.nextLine();
        return nombre;
    }
    
    private static float pedirPrecio(){
        Scanner tecladoF = new Scanner(System.in);
        float precio;
        System.out.print("Precio abonado: ");
        precio = tecladoF.nextFloat();
        return precio;
    }
    
    public void rellenarSocios(){
        String nombre;
        float precioAbonado;
        for(int i = 0;i < this.vSocios.length;i++){
            nombre = pedirNombre();
            precioAbonado = pedirPrecio();
            this.vSocios[i] = new Socio(nombre, precioAbonado);
        }
    }
    
    public void mostrarPelicula(){
        System.out.println("Titulo: "+this.titulo);
        System.out.println("Coste licencia: "+this.costeLicencia);
        for(int i = 0; i < this.vSocios.length;i++){
            this.vSocios[i].mostrarSocio();
        }
    }
    
    public float getRentabilidad(){
        float rentabilidad, suma = 0;
        for(int i = 0; i < this.vSocios.length;i++){
            suma = suma + this.vSocios[i].getPrecio();
        }
        rentabilidad = suma - this.costeLicencia;
        return rentabilidad;
    }
    
    public void mostrarbeneficioYSocios(){
        System.out.println("beneficio: "+getRentabilidad());
        for(int i = 0; i < this.vSocios.length;i++){
            this.vSocios[i].mostrarSocio();
        }
    }
    
    public int getNumeroSociosPorCantidad(float cantidad){
        int cont = 0;
        for(int i = 0; i < this.vSocios.length;i++){
            if  (this.vSocios[i].getPrecio() > cantidad){
                cont++;
            }
        }
        return cont;
    }
    
    public void mostrarSociosPorLetraEnPelicula(char letra){
        for(int i = 0; i < this.vSocios.length;i++){
            if  (this.vSocios[i].getNombre().charAt(0) == letra){
                System.out.println(this.vSocios[i].getNombre());
            }
        }
    }
}
