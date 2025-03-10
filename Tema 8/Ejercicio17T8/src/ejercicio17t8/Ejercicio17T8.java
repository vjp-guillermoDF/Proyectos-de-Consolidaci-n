/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicio17t8;

import java.util.Scanner;

/**
 *
 * @author admin
 */
public class Ejercicio17T8 {

    /* Pide la celda a ocupar por el jugador. Para ello, necesitamos pedir fila y columna y comprobar que está vacía esa celda */
    public static void pedirPosicion(Tablero T){
        Scanner teclado = new Scanner(System.in);
        int fila, columna;
        boolean fueraRango, ocupada;
        do{
            fueraRango = false;
            ocupada = false;
            System.out.print("FILA: ");
            fila = teclado.nextInt();
            System.out.print("COLUMNA: ");
            columna = teclado.nextInt();
            if  (((fila < 0)||(fila > 2))||((columna < 0)||(columna > 2))){
                fueraRango = true;
            }
            if  (!fueraRango){
                if  (T.estaOcupada(fila, columna)){
                    ocupada = true;
                }
            }
            //Volvemos a pedir si nos salimos del rango del tablero o 
            //si la celda ya tiene una ficha
        }while((fueraRango)||(ocupada));
        T.ponerFicha("O", fila, columna);  //Colocamos una ficha "O"
    }

    /* Coloca una ficha la máquina al azar */
    public static void colocarFichaAzar(Tablero T){
        int fila, columna;
        do{
            fila = (int)(Math.floor(Math.random() * 3)); //Genera aleatorio entre 0 y 2
            columna = (int)(Math.floor(Math.random() * 3)); //Genera aleatorio entre 0 y 2
        }while(T.estaOcupada(fila, columna));  //Repetimos miestras la celda esté ocupada
        T.ponerFicha("X", fila, columna);  //Colocamos una ficha "X"
    }
    
    //"Limpia" la pantalla
    public static void limpiarPantalla(){
        int i;
        for(i = 0;i < 10;i++){
            System.out.println("");
        }
    }
    
    /* Muestra el resultado final de la partida */
    public static void mostrarMensajeGanador(boolean ganaJug, boolean ganaMaq, boolean empate){
        if  ((ganaJug)||(ganaMaq)||(empate)){
            if  (ganaJug){
                System.out.println("¡Has ganado!!");
            }
            else{
                if  (ganaMaq){
                    System.out.println("¡Has perdido!");
                }
                else{
                    System.out.println("¡Empate!");
                }
            }
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Tablero T = new Tablero();  //Creamos el talero para empezar a jugar.
        boolean ganaJug = false, ganaMaq = false, empate = false;
        do{
            limpiarPantalla();
            T.dibujarTablero();
            pedirPosicion(T);  //Turno para jugador
            ganaJug = T.comprobarGanador("O");
            empate = T.comprobarEmpate();
            if  ((!ganaJug)&&(!empate)){
                colocarFichaAzar(T);  //Turno para la máquina
                ganaMaq = T.comprobarGanador("X");
                empate = T.comprobarEmpate();
            }
        }while((!ganaJug)&&(!ganaMaq)&&(!empate));
        //Mostramos una vez más el tablero, para que se vea cómo queda la partida finalmente
        limpiarPantalla();
        T.dibujarTablero();
        mostrarMensajeGanador(ganaJug, ganaMaq, empate);
    }
    
}
