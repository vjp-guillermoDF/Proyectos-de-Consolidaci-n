/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicio15t8;

import java.util.Scanner;

/**
 *
 * @author Usuario
 */
public class Ejercicio15T8 {

    //Inicializa el vector de películas (para evitar que las celdas contengan "null")
    public static void inicializarPeliculas(Pelicula[] vPeliculas){
        for(int i = 0;i < vPeliculas.length;i++){
            vPeliculas[i] = new Pelicula();
        }
    }
    
    //Pide el título de una película y lo retorna
    private static String pedirTitulo(){
        Scanner tecladoF = new Scanner(System.in);
        String titulo;
        System.out.print("Título: ");
        titulo = tecladoF.nextLine();
        return titulo;
    }
    
    //Pide el coste de la licencia de una película y lo retorna
    private static float pedirCosteLicencia(){
        Scanner tecladoF = new Scanner(System.in);
        float licencia;
        System.out.print("Coste licencia: ");
        licencia = tecladoF.nextFloat();
        return licencia;
    }
    
    //Rellena la información de todas las películas (y sus socios)
    public static void rellenarPeliculas(Pelicula[] vPeliculas){
        String titulo;
        float licencia;
        for(int i = 0;i < vPeliculas.length;i++){
            titulo = pedirTitulo();
            vPeliculas[i].setTitulo(titulo);
            licencia = pedirCosteLicencia();
            vPeliculas[i].setCosteLicencia(licencia);
            vPeliculas[i].rellenarSocios();
        }
    }
    
    //Muestra la información de todas las películas del vector
    public static void mostrarTodasLasPeliculas(Pelicula[] vPeliculas){
        for(int i = 0;i < vPeliculas.length;i++){
            if  (!vPeliculas[i].getTitulo().equalsIgnoreCase("")){  //Si no hay título (si no hemos introducido la prlícula)
                vPeliculas[i].mostrarPelicula();
            }
            else{
                System.out.println("Película no introducida en la celda "+i);
            }
        }
    }
    
    //Calcula la película más rentable (suponemos que no hay dos películas más rentables)
    public static void calcularPeliculaMasRentable(Pelicula[] vPeliculas){
        float rentabilidadAct, rentabilidadMax = vPeliculas[0].getRentabilidad();
        String titulo = vPeliculas[0].getTitulo();
        for(int i = 0;i < vPeliculas.length;i++){
            rentabilidadAct = vPeliculas[i].getRentabilidad();
            if  (rentabilidadAct > rentabilidadMax){
                rentabilidadMax = rentabilidadAct;
                titulo = vPeliculas[i].getTitulo();
            }
        }
        System.out.println("La películas más rentable es "+titulo+" con una rentabilidad de "+rentabilidadMax);
    }
    
    //Calcula la película menos rentable (suponemos que no hay dos películas menos rentables)
    public static void calcularPeliculaMenosRentable(Pelicula[] vPeliculas){
        float rentabilidadAct, rentabilidadMin = vPeliculas[0].getRentabilidad();
        String titulo = vPeliculas[0].getTitulo();
        for(int i = 0;i < vPeliculas.length;i++){
            rentabilidadAct = vPeliculas[i].getRentabilidad();
            if  (rentabilidadAct < rentabilidadMin){
                rentabilidadMin = rentabilidadAct;
                titulo = vPeliculas[i].getTitulo();
            }
        }
        System.out.println("La películas más rentable es "+titulo+" con una rentabilidad de "+rentabilidadMin);
    }
    
    //Busca una película por su nombre. SI la encuentra, muestra su información (beneficios y socios)
    public static void buscarPelicula(Pelicula[] vPeliculas, String titulo){
        int i = 0;
        boolean enc = false;
        while((i < vPeliculas.length)&&(!enc)){
            if  (vPeliculas[i].getTitulo().equalsIgnoreCase(titulo)){
                enc = true;
            }
            else{
                i++;
            }
        }
        if  (enc){
            vPeliculas[i].mostrarbeneficioYSocios();
        }
        else{
            System.out.println("La película "+titulo+" no se ha proyectado en nuestras pantallas.");
        }
    }
    
    //Calcula el número de socios que han abonado más de "cantidad"
    public static int cuantosSocios(Pelicula[] vPeliculas, float cantidad){
        int cuantos = 0;
        for(int i = 0;i < vPeliculas.length;i++){
            cuantos = cuantos + vPeliculas[i].getNumeroSociosPorCantidad(cantidad);
        }
        return cuantos;
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        Pelicula[] vPeliculas = new Pelicula[3];
        float precio;
        String titulo;
        int opc;
        inicializarPeliculas(vPeliculas);
        do{
            System.out.println("1. Rellenar peliculas");
            System.out.println("2. Mostrar peliculas");
            System.out.println("3. Mostrar pelicula más rentable");
            System.out.println("4. Mostrar pelicula menos rentable");
            System.out.println("5. Mostrar beneficio dada una película");
            System.out.println("6. Contar socios por precio abonado");
            System.out.println("7. Salir");
            System.out.print("   Opcion: ");
            opc = teclado.nextInt();
            switch(opc){
                case 1:
                    rellenarPeliculas(vPeliculas);
                    break;
                case 2:
                    mostrarTodasLasPeliculas(vPeliculas);
                    break;
                case 3:
                    calcularPeliculaMasRentable(vPeliculas);
                    break;
                case 4:
                    calcularPeliculaMenosRentable(vPeliculas);
                    break;
                case 5:
                    titulo = pedirTitulo();
                    buscarPelicula(vPeliculas, titulo);
                    break;
                case 6:
                    precio = pedirCosteLicencia();
                    System.out.println("Hay "+cuantosSocios(vPeliculas, precio)+" socios que han pagado más de "+precio+" euros.");
                    break;
                case 7:
                    System.out.println("Hasta la próxima");
                    break;
                default:
                    System.out.println("Opción incorrecta");
            }
        }while(opc != 7);
    }
    
}
