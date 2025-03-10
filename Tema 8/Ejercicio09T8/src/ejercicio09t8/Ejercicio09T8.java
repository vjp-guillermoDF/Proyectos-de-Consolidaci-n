/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicio09t8;

import java.util.Scanner;

/**
 *
 * @author admin
 */
public class Ejercicio09T8 {

    public final static int MAXALUMNOS = 3;
    
    public static void rellenarAlumnos(Alumno vAlumnos[]){
        //Vectores de nombres
        String[] vNombres = {"Pepe", "Juan", "Marta"};
        int i;
        for(i = 0;i < vAlumnos.length;i++){
            vAlumnos[i] = new Alumno(vNombres[i]);
            vAlumnos[i].rellenarAsignaturas();
        }
    }
    
    public static void mostrarNotasAlumnos(Alumno vAlumnos[]){
        int i;
        System.out.println("NOTAS ALUMNOS");
        System.out.println("-------------");
        for(i = 0;i < vAlumnos.length;i++){
            System.out.println("Alumno: "+vAlumnos[i].getNombre());
            //Llamamos al método que muestra las asignaturas de un alumno
            vAlumnos[i].mostrarAsignaturas();
        }
    }
    
    //Retorna el Alumno (almacenado en una celda del vector de alumnos) con mejor nota media
    public static Alumno mejorNotaMedia(Alumno vAlumnos[]){
        int i, mayorMedia = 0;
        Alumno mejorAlumno = null;
        for(i = 0;i < vAlumnos.length;i++){
            if  (vAlumnos[i].calcularMedia() > mayorMedia){
                mayorMedia = vAlumnos[i].calcularMedia();
                mejorAlumno = vAlumnos[i];
            }
        }
        return mejorAlumno;
    }
    
    public static Alumno peorNotaMedia(Alumno vAlumnos[]){
        int i, peorMedia = 999;
        Alumno peorAlumno = null;
        for(i = 0;i < vAlumnos.length;i++){
            /*Mejor ejecutar "vAlumnos[i].calcularMedia()" una vez y almacenar el valor en una variable, para 
            no llamarlo dos veces (que dentro hace un recorrido del vector de asignaturas)*/
            if  (vAlumnos[i].calcularMedia() < peorMedia){
                peorMedia = vAlumnos[i].calcularMedia();
                peorAlumno = vAlumnos[i];
            }
        }
        return peorAlumno;
    }
    
    public static void asignaturaMasDificil(Alumno vAlumnos[], String[] vNombresAsignaturas){
        int suma, menorNotaAsignatura = 999, asigMasDificil = 0;
        for(int j = 0;j < vNombresAsignaturas.length;j++){
            suma = 0;
            for(int i = 0;i < vAlumnos.length;i++){
                suma = suma + vAlumnos[i].getNotaPorPosicion(j);
            }
            if  (suma < menorNotaAsignatura){
                menorNotaAsignatura = suma;
                asigMasDificil = j;
            }
        }
        System.out.println("La asignatura más dificil es "+vNombresAsignaturas[asigMasDificil]);
    }
    
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        
        String[] vNombresAsignaturas = {"Lengua", "Mates", "Historia", "Física"};
        Alumno[] vAlumnos = new Alumno[MAXALUMNOS];
        int opc;
        do{
            System.out.println("    MENÚ");
            System.out.println("1. Rellenar notas. ");
            System.out.println("2. Mostrar notas. ");
            System.out.println("3. Mejor nota media. ");
            System.out.println("4. Peor nota media. ");
            System.out.println("5. Asignatura más difícil. ");
            System.out.println("6. Salir. ");
            System.out.print("   Opción: ");
            opc = teclado.nextInt();
            switch(opc){
                case 1:
                    rellenarAlumnos(vAlumnos);   
                    break;
                case 2:
                    mostrarNotasAlumnos(vAlumnos);
                    break;
                case 3:
                    System.out.println("Mejor nota media: "+mejorNotaMedia(vAlumnos).getNombre());
                    break;
                case 4:
                    System.out.println("Peor nota media: "+peorNotaMedia(vAlumnos).getNombre());
                    break;    
                case 5:
                    asignaturaMasDificil(vAlumnos, vNombresAsignaturas);   
                    break;
                case 6:
                    System.out.println("¡Hasta la próxima!");
                    break;
                default:
                    System.out.println("Opción incorrecta");
            }
        }while(opc != 6);
    }    
}
