/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicio07t8;

import java.util.Scanner;

/**
 *
 * @author admin
 */
public class Ejercicio07T8 {

    public final static int MAX = 30;
    
    public static void rellenarTemperaturas(Dia vMes[], String vDias[]){
        int i, temp;
        int diaSemana = (int) (Math.random() * 7);  //Número aleatorio entre 0 y 6
        for(i = 0;i < vMes.length;i++){
            temp = (int) (Math.random() * 45);
            vMes[i] = new Dia(vDias[diaSemana], temp);
            if  (diaSemana == 6){
                diaSemana = 0;
            }
            else{
                diaSemana++;
            }
        }
    }
    
    public static void mostrarTemperaturas(Dia vMes[]){
        int i;
        System.out.println("TEMPERATURAS MES");
        for(i = 0;i < vMes.length;i++){
            System.out.println(vMes[i].getNombreDia()+" "+(i+1)+": "+vMes[i].getTemperatura()+"º");
        }
    }
    
    public static void calcularTemperaturaMedia(Dia vMes[]){
        int i, suma = 0;
        float media;
        for(i = 0;i < vMes.length;i++){
            suma = suma + vMes[i].getTemperatura();
        }
        media = suma / 30;
        System.out.println("Media: "+media);
    }
    
    //Calcula el día o día más caluroso
    public static void calcularDiasCalurosos(Dia vMes[]){
        int i, gradosMax = 0;
        //Calculamos el máximo de grados en el mes
        for(Dia dia:vMes){
            if  (dia.getTemperatura() > gradosMax){
                gradosMax = dia.getTemperatura();
            }
        }
        //Mostramos los días que tienen el máximo de grados
        for(i = 0;i < vMes.length;i++){
            if  (vMes[i].getTemperatura() == gradosMax){
                System.out.println("El "+vMes[i].getNombreDia()+" día "+(i+1)+" con "+gradosMax+" grados.");
            }
        }
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        //Creamos vector del mes
        Dia[] vMes = new Dia[MAX];
        //Creamos vector de días de la semana
        String[] vDias = {"Lunes", "Martes", "Miércoles", "Jueves", "Viernes", "Sábado", "Domingo"};
        
        int opc;
        do{
            System.out.println("MENU");
            System.out.println("1. Rellenar temperaturas. ");
            System.out.println("2. Mostrar temperaturas. ");
            System.out.println("3. Temperatura media. ");
            System.out.println("4. Día o día más caluroso. ");
            System.out.println("5. Salir. ");
            System.out.print("   Opción: ");
            opc = teclado.nextInt();
            switch(opc){
                case 1:
                    rellenarTemperaturas(vMes, vDias);
                    break;
                case 2:
                    mostrarTemperaturas(vMes);
                    break;
                case 3:
                    calcularTemperaturaMedia(vMes);
                    break;
                case 4:
                    calcularDiasCalurosos(vMes);
                    break;
                case 5:
                    System.out.println("¡Hasta pronto!");
                    break;
                default:
                    System.out.println("Opción incorrecta");
            }
        }while(opc != 5);
    }
    
}
