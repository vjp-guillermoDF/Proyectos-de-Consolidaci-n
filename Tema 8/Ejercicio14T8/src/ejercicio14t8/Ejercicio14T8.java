/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicio14t8;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author Quique Pineda
 */
public class Ejercicio14T8 {

    //Inicializamos el vector de alumnos, para evitar los problemas derivados de tener las celdas con valores null.
    public static void inicializarVectorAlumnos(Alumno[] vAlumnos){
        for(int i = 0;i < vAlumnos.length;i++){
            vAlumnos[i] = new Alumno();
        }
    }
    
    public static int mostrarMenu(){
        Scanner teclado = new Scanner(System.in);
        int opc;
        System.out.println("1. Insertar alumno");
        System.out.println("2. Mostrar alumnos");
        System.out.println("3. Mostrar alumnos por encima de una media dada");
        System.out.println("4. Mostrar número alumnos con media suspensa");
        System.out.println("5. Buscar alumno");
        System.out.println("6. Salir");
        System.out.print("   Opcion: ");
        try{
            opc = teclado.nextInt();
        }
        catch(InputMismatchException e){
            System.out.println("Debe introducir un número.");
            opc = -1;
        }
        return opc;
    }
    
    public static int pedirPosicion(){
        Scanner teclado = new Scanner(System.in);
        int posicion;
        System.out.print("Introduzca posicion: ");
        posicion = teclado.nextInt();
        posicion--;  //Tener en cuenta que para el usuario las posiciones NO empiezan en cero.
        return posicion;
    }
    
    public static String pedirNombre(){
        Scanner teclado = new Scanner(System.in);
        String nombre;
        System.out.print("Nombre: ");
        nombre = teclado.nextLine();
        return nombre;
    }
    
    public static int pedirEdad(){
        Scanner teclado = new Scanner(System.in);
        int edad;
        System.out.print("Edad: ");
        edad = teclado.nextInt();
        return edad;
    }
    
    public static float pedirMedia(){
        Scanner teclado = new Scanner(System.in);
        float media;
        System.out.print("Nota media: ");
        media = teclado.nextFloat();
        return media;
    }
    
    //Inserta un alumno en una posicion introducida por el usuairo.
    //Si lap osición está ocupada, mostramos un mensaje y NO insertamos
    public static void insertarUnAlumno(Alumno[] vAlumnos){
        String nombre;
        int edad, posicion;
        float notaMedia;
        boolean posicionVacia;
        
        do{
            posicionVacia = true;
            posicion = pedirPosicion();
            try{
                if  (vAlumnos[posicion] != null){
                    posicionVacia = false;
                    System.out.println("Celda ocupada por el alumno "+vAlumnos[posicion].getNombre());
                }
            }
            catch(ArrayIndexOutOfBoundsException e){
                posicionVacia = false;
                System.out.println("La posición debe estar comprendida entre 1 y "+vAlumnos.length);
            }
        }while(!posicionVacia);  //es lo mismo que poner (posicionVacia == false)
        
        nombre = pedirNombre();
        edad = pedirEdad();
        notaMedia = pedirMedia();
        vAlumnos[posicion] = new Alumno(nombre, edad, notaMedia);
        System.out.println("Alumno insertado correctamente.");
    }
    
    //Mostramos la información de las celdas que están ocupadas.
    public static void mostrarAlumnos(Alumno[] vAlumnos){
        for(int i = 0;i < vAlumnos.length;i++){
            if  (vAlumnos[i] != null){  //Si la celda está ocupada, la mostramos
                vAlumnos[i].mostrarAlumno();
            }
        }
    }
    
    //Mostramos la información de los alumnos con media mayor que "mediaDada"
    public static void mostrarAlumnosPorEncimaMediaDada(Alumno[] vAlumnos, float mediaDada){
        for(int i = 0;i < vAlumnos.length;i++){
            if  (vAlumnos[i].getNotaMedia() > mediaDada){  //Si la celda está ocupada, la mostramos
                vAlumnos[i].mostrarAlumno();
            }
        }
    }
    
    //Calcula el número de alumnos con la nota media suspensa. Retorna el valor calculado.
    public static int getNumAlumnosConMediaSuspensa(Alumno[] vAlumnos){
        int cont = 0;
        for(int i = 0;i < vAlumnos.length;i++){
            if  (vAlumnos[i].getNotaMedia() < 5){
                cont++;
            }
        }
        return cont;
    }
    
    //Busca el alumno con nombre "nombre". Retorna true si lo encuentra. False en caso contrario.
    public static boolean buscarAlumno(Alumno[] vAlumnos, String nombre){
        int i = 0;
        boolean enc = false;
        while((i < vAlumnos.length)&&(!enc)){
            if  (nombre.equalsIgnoreCase(vAlumnos[i].getNombre())){
                enc = true;
            }
            else{
                i++;
            }
        }
        return enc;
    }
            
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Alumno[] vAlumnos = new Alumno[5];
        String nombre;
        int opc;
        float media;
        inicializarVectorAlumnos(vAlumnos);
        do{
            opc = mostrarMenu();
            switch(opc){
                case 1:
                    insertarUnAlumno(vAlumnos);
                    break;
                case 2:
                    mostrarAlumnos(vAlumnos);
                    break;
                case 3:
                    media = pedirMedia();
                    mostrarAlumnosPorEncimaMediaDada(vAlumnos, media);
                    break;
                case 4:
                    System.out.println("Hay "+getNumAlumnosConMediaSuspensa(vAlumnos)+" alumnos con media suspensa.");
                    break;
                case 5:
                    nombre = pedirNombre();
                    if  (buscarAlumno(vAlumnos, nombre)){
                        System.out.println("Alumno matriculado");
                    }
                    else{
                        System.out.println("Alumno no matriculado");
                    }
                    break;
            }
        }while(opc != 6);
    }
    
}
