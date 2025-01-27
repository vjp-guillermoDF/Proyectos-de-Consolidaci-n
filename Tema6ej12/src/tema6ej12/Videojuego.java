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

    private int horasEstimadas = 10;

    private Estudio estudio;

    public Videojuego(int horasEstimadas, Estudio estudio) {
        super();
        this.horasEstimadas = horasEstimadas;
        this.estudio = estudio;

    }

    public Videojuego() {
        super();
        this.estudio = new Estudio();

    }

    public Videojuego(int horasEstimadas, Estudio estudio, String titulo, String genero) {
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

    public Estudio getEstudio() {
        return estudio;
    }

    public void setEstudio(Estudio estudio) {
        this.estudio = estudio;
    }

    @Override
    public String toString() {
        return super.toString() + "Videojuego{" + "horasEstimadas=" + horasEstimadas + ", estudio=" + estudio + '}';
    }

    public int valorar() {
        int a, b, c;
        do {
            System.out.println("Por favor, valore del 1 al 5 las categorias de contenido exclusivo, gameplay e innovacion. Introduzca tres numeros con cada respectiva valoracion");
            a = super.scanner();
            b = super.scanner();
            c = super.scanner();
            if (a < 1 || a > 5 || b < 1 || b > 5 || c < 1 || c > 5) {
                System.out.println("Por favor, introduzca numeros entre 1 y 5");
            }
        } while (a < 1 || a > 5 || b < 1 || b > 5 || c < 1 || c > 5);

        int media = (a + b + c) / 3;
        System.out.println("La valoracion media es " + media + ".¡Muchas gracias!");

        return media;

    }

    /**
     *
     */
    @Override
    public void entregar() {
        if (!super.esEntregado()) {
            super.entregar();
            System.out.println("Has alquilado " + getTitulo() + " de " + estudio);

        } else {
            System.out.println(getTitulo() + "no disponible");
        }
    }

    /**
     *
     */
    @Override
    public void devolver() {
        if (super.esEntregado()) {
            super.devolver();
            System.out.println(getTitulo() + " de " + estudio + " devuelto correctamente. Si te ha gustado, puedes probar el último lanzamiento de " + estudio + ": Jara y Sedal 2");
        } else {
            System.out.println("No se puede devolver");
        }
    }

}
