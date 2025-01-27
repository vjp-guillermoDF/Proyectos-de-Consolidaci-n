/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tema6ej12;

/**
 *
 * @author alumno
 */
public final class Videojuego extends Contenido {
    
    private int horasEstimadas;
    
    private String estudio;

    public Videojuego(int horasEstimadas, String estudio) {
        super();
        this.horasEstimadas = horasEstimadas;
        this.estudio = estudio;
        
    }
    
    public Videojuego(){
        super();
        this.horasEstimadas = 0;
        this.estudio = "";
        
    }

    public Videojuego(int horasEstimadas, String estudio, String titulo, String genero) {
        super(titulo, genero);
        this.horasEstimadas = horasEstimadas;
        this.estudio = estudio;
    }

    public int getHorasEstimadas() {
        return horasEstimadas;
    }

    public void setHorasEstimadas(int horasEstimadas) {
        this.horasEstimadas = horasEstimadas;
    }

    public String getEstudio() {
        return estudio;
    }

    public void setEstudio(String estudio) {
        this.estudio = estudio;
    }

    @Override
    public String toString() {
        return super.toString() + "Videojuego{" + "horasEstimadas=" + horasEstimadas + ", estudio=" + estudio + '}';
    }
    
    
    
    public int valorar() {
        int a = 0, b = 0, c = 0;

        System.out.println("Por favor, valore del 1 al 5 las categorias guion, interpretacion y fotografia. Introduzca tres numeros con cada respectiva valoracion");
        super.scanner(a);
        super.scanner(b);
        super.scanner(c);
        int media = (a + b + c) / 3;
        System.out.println("La valoracion media es " + media + ".¡Muchas gracias!");

        return media;

    }

    public void entregar() {
        if (!super.esEntregado()) {
            super.entregar();
            System.out.println("Has alquilado " + getTitulo() + "de " + creador);

        } else {
            System.out.println(getTitulo() + "no disponible");
        }
    }

    public void devolver() {
        if (super.esEntregado()) {
            super.devolver();
            System.out.println(getTitulo() + " de" + creador + " devuelto correctamente");
        } else {
            System.out.println("No se puede devolver");
        }
    }
    

 
    
    
    
}
