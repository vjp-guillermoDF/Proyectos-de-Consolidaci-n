/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicio07t8;

import java.util.Scanner;

/**
 *
 * @author Usuario
 */
public class Ejercicio07T8 {

    //Rellena los días del mes
    public static void rellenarTemperaturas(Dia[] vDias){
        String[] vNombres = {"Lunes", "Martes", "Miercoles", "Jueves", "Viernes", "Sabado", "Domingo"};
        int temperatura;
        int j = (int)(Math.random()*7);  //Generamos aleatorio entre 0 y 6
        for(int i = 0;i < vDias.length;i++){
            temperatura = (int)(Math.random()*50);  //Generamos una temperatura aleatorio entre 0º y 49º
            vDias[i] = new Dia(vNombres[j], temperatura);
            j++; //Incrementamos el índice para que pase al siguiente nombre del día de la semana
            if  (j == 7){  //Si se pasa del domingo, volvemos a empezar en el 0 (el lunes)
                j = 0;
            }
        }
    }
    
    //Muestra todos los días de la semana y sus temperaturas
    public static void mostrarTemperaturas(Dia[] vDias){
        for(int i = 0;i < vDias.length;i++){
            System.out.println(vDias[i].getNombreDia()+" dia "+(i+1)+": "+vDias[i].getTemperatura()+" grados");
        }
    }
    
    //Calcula y muestra la temperatura media del mes
    public static void mostrarTemperaturaMedia(Dia[] vDias){
        float suma = 0;
        //Utilizamos un bucle for each para recorrer el vector vDias
        for(Dia d:vDias){
            suma = suma + d.getTemperatura();
        }
        System.out.println("La temperatura media del mes es de "+suma/vDias.length);
    }
    
    //Calcula el/los dia/s mas caluroso/s
    public static void calcularDiasMasCalurosos(Dia[] vDias){
        //Buscamos la temperatura más alta del mes
        int i, tempMax = vDias[0].getTemperatura();
        for(i = 1;i < vDias.length;i++){
            //Si encontramos una temperatura mayor en la celda "i", actualizamos tempMax
            if  (vDias[i].getTemperatura() > tempMax){
                tempMax = vDias[i].getTemperatura();
            }
        }
        //Mostramos todos aquellos días cuya temperatura coincide con tempMax
        for(i = 0;i < vDias.length;i++){
            //Si la temperatura del día coincide con la máxima encontrada, mostramos el día
            if  (vDias[i].getTemperatura() == tempMax){
                System.out.println("    El "+vDias[i].getNombreDia()+" dia "+(i+1)+" con "+tempMax+" grados");
            }
        }
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        Dia[] vDias = new Dia[30];  //Declaramos vector de Dias de 30 celdas
        int opc;
        do{
            System.out.println("1. Rellenar temperaturas");
            System.out.println("2. Mostrar temperaturas");
            System.out.println("3. Mostrar temperatura media");
            System.out.println("4. Día o días más calurosos");
            System.out.println("5. Salir");
            System.out.print("   Opcion: ");
            opc = teclado.nextInt();
            switch(opc){
                case 1:
                    rellenarTemperaturas(vDias);
                    break;
                case 2:
                    mostrarTemperaturas(vDias);
                    break;
                case 3:
                    mostrarTemperaturaMedia(vDias);
                    break;
                case 4:
                    calcularDiasMasCalurosos(vDias);
                    break;
                case 5:
                    System.out.println("¡Hasta la próxima!");
                    break;
            }
        }while(opc != 5);
    }
    
}
