/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicio17t8;

/**
 *
 * @author admin
 */
public class Tablero {
    private Casilla[][] M;  //Matriz del tablero. Aquí almacenaremos, en cada celda, un objeto de Casilla.
    
    /* Constructor por defecto. Crea un tablero vacío */
    public Tablero(){
        M = new Casilla[3][3];
        
        for(int i = 0;i < M.length;i++){
            for(int j = 0;j < M[i].length;j++){
                M[i][j] = new Casilla();
            }
        }
    }

    public Tablero(Casilla[][] M) {
        this.M = M;
    }

    public Casilla[][] getM() {
        return M;
    }

    public void setM(Casilla[][] M) {
        this.M = M;
    }
    
    
    /*  fichas O para el jugador - fichas X para la máquina */
    public static void pintarCelda(Casilla celda){
        if  (celda.getOcupada() == false) {  //Si la celda está vacía
            System.out.print("|   ");
        }
        else{
            if  (celda.getFicha().equals("O")) {  //Si la celda tiene una ficha O
                System.out.print("| O ");
            }
            else{
                System.out.print("| X ");
            }
        }
    }
    
    /* Dibuja el tablero, donde se refleja la situación actual del juego */
    public void dibujarTablero(){
        int i, j;
        System.out.println("\n-------------");
        for(i = 0;i < M.length;i++){ //Recorre las filas
            for(j = 0;j < M[i].length;j++){  //Recorre las columnas
                pintarCelda(M[i][j]);
            }
            //Pintamos el final de la fila del talero
            System.out.print("|");
            System.out.println("\n-------------");
        }
    }
    
    /* Comprueba si el que lleva fichas del tipo fichaJugador ha ganado la partida */
    public boolean comprobarGanador(String fichaJugador){
        boolean ganador = false;
        //Compuebo las filas (Si la fila 0 tiene todas las fichas O la fila 1 tiene todas las fichas O la fila 2 tiene todas las fichas... entonces fihaJugador es el ganador)
        if  (((M[0][0].getFicha().equals(fichaJugador))&&(M[0][1].getFicha().equals(fichaJugador))&&(M[0][2].getFicha().equals(fichaJugador))) || //Fila 0
             ((M[1][0].getFicha().equals(fichaJugador))&&(M[1][1].getFicha().equals(fichaJugador))&&(M[1][2].getFicha().equals(fichaJugador))) || //Fila 1
             ((M[2][0].getFicha().equals(fichaJugador))&&(M[2][1].getFicha().equals(fichaJugador))&&(M[2][2].getFicha().equals(fichaJugador)))){  //Fila 2
            ganador = true;
        }
        else{  //Compruebo las columnas
            if  (((M[0][0].getFicha().equals(fichaJugador))&&(M[1][0].getFicha().equals(fichaJugador))&&(M[2][0].getFicha().equals(fichaJugador))) || //Columna 0
                 ((M[0][1].getFicha().equals(fichaJugador))&&(M[1][1].getFicha().equals(fichaJugador))&&(M[2][1].getFicha().equals(fichaJugador))) || //Columna 1
                 ((M[0][2].getFicha().equals(fichaJugador))&&(M[1][2].getFicha().equals(fichaJugador))&&(M[2][2].getFicha().equals(fichaJugador)))){  //Columna 2
                ganador = true;
            }
            else{  //Compruebo las diagonales
                if  (((M[0][0].getFicha().equals(fichaJugador))&&(M[1][1].getFicha().equals(fichaJugador))&&(M[2][2].getFicha().equals(fichaJugador))) || //Diagonal Sup-Izq a Inf-Dcha
                    ((M[0][2].getFicha().equals(fichaJugador))&&(M[1][1].getFicha().equals(fichaJugador))&&(M[2][0].getFicha().equals(fichaJugador)))) { //Diagonal Sup-Dcha a Inf-Izq
                   ganador = true;
               }
            }
        }
        return ganador;
    }
    
    /* Sabemos que hay empate si ya no se pueden poner más fichas (Si todas las celdas de la matriz están ocupadas */
    public boolean comprobarEmpate(){
        boolean empate = true;
        int i, j; 
        i = 0;
        while((i < M.length)&&(empate == true)){  //Recorro las filas
            j = 0;
            while((j < M[i].length)&&(empate == true)){  //Recorro las columnas
                if  (M[i][j].getOcupada() == false){
                    empate = false;
                }
                j++;
            }
            i++;
        }
        return empate;
    }
    
    /* Retorna si está o ocupada la celda que le indican las posiciones de los parámetros */
    public boolean estaOcupada(int fila, int columna){
        return (M[fila][columna].getOcupada());
    }
    
    /* Colocamos la ficha en la posición indicada */
    public void ponerFicha(String ficha, int fila, int columna){
        M[fila][columna].setFicha(ficha);
        M[fila][columna].setOcupada(true);
    }
}
