/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package Tema8ej7;

import java.util.Scanner;

/**
 *
 * @author guill
 */
public class Tema8ej7 {

    public static final Dia[] DiasMes = new Dia[30];

    public static void crearTablaDias(Dia[] tablaDias) {

        String[] nombreDia = {"Lunes", "Martes", "Miercoles", "Jueves", "Viernes", "Sabado", "Domingo"};

        int diaAleatorio = (int) (Math.random() * 7) + 1;

        int temperaturaAleatoria;

        for (int i = 0; i < tablaDias.length; i++) {

            tablaDias[i] = new Dia();

        }

        for (int i = 0; i < tablaDias.length; i++) {
            temperaturaAleatoria = (int) (Math.random() * 40) + 1;
            tablaDias[i].setNombreDia(nombreDia[(diaAleatorio + i) % 7]);
            tablaDias[i].setTemperatura(temperaturaAleatoria);

        }

    }

    public static void mostrarTemperaturas(Dia[] tablaDias) {

        for (int i = 0; i < tablaDias.length; i++) {
            System.out.println(tablaDias[i].getNombreDia() + " " + (i + 1) + ": " + tablaDias[i].getTemperatura() + "�");
        }

    }

    public static void temperaturaMedia(Dia[] tablaDias) {
        int suma = 0;
        for (int i = 0; i < tablaDias.length; i++) {

            suma += tablaDias[i].getTemperatura();
        }
        
        double media = Math.floor((suma / tablaDias.length) * 100) / 100;

        System.out.println("La temperatura media del mes es de " + media + "�.");

    }

    public static void diasMasCalurosos(Dia[] tablaDias) {
        int tempMax = tablaDias[0].getTemperatura();
        System.out.println("Los dias mas calurosos del mes han sido:\n");

        for (int i = 0; i < tablaDias.length - 1; i++) {

            if (tablaDias[i].getTemperatura() > tempMax) {

                tempMax = tablaDias[i].getTemperatura();

            }
        }
        for (int i = 0; i < tablaDias.length; i++) {
            if (tablaDias[i].getTemperatura() == tempMax) {
                System.out.println(tablaDias[i].getNombreDia() + " " + (i + 1) + " con una temperatura de " + tablaDias[i].getTemperatura() + "�.");
            }
        }

    }

    public static void menu() {

        System.out.println("Pulse 1 para llenar un mes con temperaturas al azar.\nPulse 2 para mostrarlas.\nPulse 3 para visualizar la temperatura media del mes.\nPulse 4 para ver los dias mas calurosos.\nPulse 5 para salir del programa.");
        boolean cerrarBucle;
        do {
            try {

                switch (escaner()) {
                    case 1:
                        System.out.println("Pulse 2 para mostrarlas.\nPulse 3 para visualizar la temperatura media del mes.\nPulse 4 para ver los dias mas calurosos.\nPulse 5 para salir del programa.");
                        crearTablaDias(DiasMes);
                        cerrarBucle = false;
                        break;

                    case 2:
                        mostrarTemperaturas(DiasMes);
                        System.out.println("Pulse 3 para visualizar la temperatura media del mes.\nPulse 4 para ver los dias mas calurosos.\nPulse 5 para salir del programa.");
                        cerrarBucle = false;
                        break;

                    case 3:
                        temperaturaMedia(DiasMes);
                        System.out.println("Pulse 4 para ver los dias mas calurosos.\nPulse 5 para salir del programa.");
                        cerrarBucle = false;
                        break;

                    case 4:
                        diasMasCalurosos(DiasMes);
                        System.out.println("Pulse 5 para salir del programa.");

                        cerrarBucle = false;

                        break;

                    case 5:
                        cerrarBucle = true;
                        System.out.println("Ha salido del programa.");
                        break;
                    default:
                        cerrarBucle = false;
                        System.out.println("Opcion incorrecta. Debe ser un numero del 1 al 5.");
                        break;
                }
            } catch (Exception e) {
                cerrarBucle = false;

                System.out.println("Debe introducir un numero del 1 al 5.");
            }

        } while (!cerrarBucle);
    }

    public static int escaner() {
        Scanner entrada = new Scanner(System.in);
        return entrada.nextInt();

    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        menu();
    }

}
