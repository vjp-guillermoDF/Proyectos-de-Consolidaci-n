/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package examenej2;

import java.util.Scanner;

/**
 *
 * @author Guillermo Domínguez de la Fuente
 */
public class Coche {

    private String titular;

    private String matricula;

    public Coche(String titular, String matricula) {    //Constructor por parámetros
        this.titular = titular;
        this.matricula = matricula;
    }

    public Coche() {  //Constructor por defecto, donde inicializamos los valores con los métodos apropiados
        this.titular = pedirNombre();
        this.matricula = pedirMatricula();
    }

    public String getTitular() {
        return titular;
    }

    public void setTitular(String titular) {
        this.titular = titular;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    @Override
    public String toString() {  //Método toString() más presentable
        return "Titular: " + titular + ". Matricula: " + matricula;
    }

    public String pedirNombre() {   //Método para inicializar el atributo titular pidiéndole un valor al usuario

        Scanner entrada = new Scanner(System.in);

        System.out.println("Introduzca el nombre del titular: ");

        setTitular(entrada.next());
        return this.titular;

    }

    public String pedirMatricula() { //Método para inicializar el atributo matrícula pidiéndole un valor al usuario
        Scanner entrada = new Scanner(System.in);

        System.out.println("Introduzca la matricula: ");

        setMatricula(entrada.next());
        return this.matricula;

    }

}
