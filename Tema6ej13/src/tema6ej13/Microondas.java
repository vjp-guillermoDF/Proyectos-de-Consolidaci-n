/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tema6ej13;

/**
 *
 * @author guill
 */
public class Microondas implements Revisable, Operable {

    private boolean activo;

    public boolean estadoCalentador;

    public boolean puertaCerrada;

    public Microondas(boolean activo, boolean estadoCalentador, boolean puertaCerrada) {
        this.activo = activo;
        this.estadoCalentador = estadoCalentador;
        this.puertaCerrada = puertaCerrada;
    }

    public Microondas() {
        this.activo = false;
        this.estadoCalentador = false;
        this.puertaCerrada = false;
    }

    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }

    public boolean isEstadoCalentador() {
        return estadoCalentador;
    }

    public void setEstadoCalentador(boolean estadoCalentador) {
        this.estadoCalentador = estadoCalentador;
    }

    public boolean isPuertaCerrada() {
        return puertaCerrada;
    }

    public void setPuertaCerrada(boolean puertaCerrada) {
        this.puertaCerrada = puertaCerrada;
    }

    @Override
    public String toString() {
        return "Microondas{" + "activo=" + activo + ", estadoCalentador=" + estadoCalentador + ", puertaCerrada=" + puertaCerrada + '}';
    }

    @Override
    public String revisarEstado() {
        if (!estadoCalentador) {
            return "Fallos detectados en el calentador del microondas";
        } else {
            if (!puertaCerrada) {
                return "La puerta esta abierta. Por favor, cierrela";
            } else {
                return "?El calentador funciona correctamente y la puerta está cerrada";
            }
        }
    }

    @Override
    public void activar() {
        if (activo) {
            System.out.println("El microondas ya estaba activo");
        } else if (!activo) {
            if (!puertaCerrada || !estadoCalentador) {
                System.out.println("Se han detectado fallos. Puerta cerrada " + puertaCerrada + ". Estado del calentador " + estadoCalentador);
            } else {
                activo = true;
                System.out.println("El robot está activado.");
            }
        }
    }

    @Override
    public void desactivar() {
        if (activo = true) {
            activo = false;
            System.out.println("El microondas esta desactivado");
        } else if (activo = false) {
            System.out.println("El microondas ya estaba desactivado");
        }
    }

}
