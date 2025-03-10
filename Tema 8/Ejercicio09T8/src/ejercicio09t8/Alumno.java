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
public class Alumno {
    
    private String nombre;
    private Asignatura[] vAsignaturas;

    public Alumno() {
        this.nombre = "";
        //Modificar tamaño
        vAsignaturas = new Asignatura[4];
        for(int i = 0;i < vAsignaturas.length;i++){
            vAsignaturas[i] = new Asignatura();
        }
    }
    
    public Alumno(String nombre, Asignatura[] vAsignaturas) {
        this.nombre = nombre;
        this.vAsignaturas = vAsignaturas;
    }
    
    public Alumno(String nombre) {
        this.nombre = nombre;
        //Modificar tamaño
        vAsignaturas = new Asignatura[4];
        for(int i = 0;i < vAsignaturas.length;i++){
            vAsignaturas[i] = new Asignatura();
        }
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Asignatura[] getvAsignaturas() {
        return vAsignaturas;
    }

    public void setvAsignaturas(Asignatura[] vAsignaturas) {
        this.vAsignaturas = vAsignaturas;
    }
    
    //Rellena el vector de Asigaturas con los nombres de las asignaturas y las notas del alumno
    public void rellenarAsignaturas(){
        String[] vNombresAsignaturas = {"Lengua", "Mates", "Historia", "Física"};
        Scanner teclado = new Scanner(System.in);
        int i, nota;
        System.out.println("INTRODUZCA NOTAS DE "+nombre);
        System.out.println("--------------------");
        for(i = 0;i < vAsignaturas.length;i++){
            System.out.print("    "+vNombresAsignaturas[i]+": ");
            nota = teclado.nextInt();
            vAsignaturas[i].setNombre(vNombresAsignaturas[i]);
            vAsignaturas[i].setNota(nota);
        }
    }
    
    public int calcularMedia(){
        int i, suma = 0;
        for(i = 0;i < vAsignaturas.length;i++){
            suma = suma + (int)(vAsignaturas[i].getNota());
        }
        return suma;
    }
    
    public void mostrarAsignaturas(){
        int i;
        for (i = 0;i < vAsignaturas.length;i++){
            System.out.println("    "+vAsignaturas[i].getNombre()+": "+vAsignaturas[i].getNota());
        }
    }
    
    public int getNotaAsignatura(String nomAsignatura){
        int i = 0;
        boolean enc = false;
        //Mientras no llegue al final de las asignaturas y no la encuentre, sigo buscando
        while((i < vAsignaturas.length)&&(!enc)){
            //Si encuentro la asignatura que estoy buscando
            if  (nomAsignatura.equals(vAsignaturas[i].getNombre())){
                enc = true;
            }
            else{  //Si no la encuentro, paso a la siguiente asignatura
                i++;
            }
        }
        //Si he encontrado la asignatura, devuelvo su nota
        if  (enc){
            return vAsignaturas[i].getNota();
        }
        else{  //Si no la ecuentro, devuelvo -1
            return -1;
        }
    }
    
    public int getNotaPorPosicion(int pos){
        return this.vAsignaturas[pos].getNota();
    }
   
}
