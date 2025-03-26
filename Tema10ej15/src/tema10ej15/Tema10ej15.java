/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package tema10ej15;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author alumno
 */
public class Tema10ej15 {
    
    public static void registrarEmpresa(ArrayList<Empresa> lista){
        
        
        
    }

    public static void menu(ArrayList<Empresa> lista) {
        Scanner entrada = new Scanner(System.in);
        boolean cerrar = false;
        do {
            try {

                System.out.println("1 para registrar empresa con sus empleados.");
                System.out.println("2 para mostrar las empresas registradas junto con sus empleados.");
                System.out.println("3 para mastrar a tadas las amplaadas.");
                System.out.println("4 para mostrar los empleados ordenados en funcion de su sueldo.");
                System.out.println("5 para salir del sistema.");

                switch (entrada.nextInt()) {
                    case 1:
                        registrarEmpresa(lista);
                        break;
                    case 2:

                        break;
                    case 3:
                        break;
                    case 4:
                        break;
                    case 5:
                        System.out.println("Saliendo del sistema.");
                        break;
                    default:
                        System.out.println("Opcion no permitida.");
                }

            } catch (InputMismatchException e) {
                System.out.println("Debe introducir un numero.");
            }
        } while (!cerrar);
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        ArrayList<Empresa> lista = new ArrayList();
        menu(lista);
    }

}
