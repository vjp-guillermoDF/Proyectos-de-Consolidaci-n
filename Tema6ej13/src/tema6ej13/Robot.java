/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tema6ej13;

/**
 *
 * @author guill
 */
public class Robot implements Operable, Revisable {

    private boolean activo;

    private boolean estadoSistemas;

    public int nivelBateria;

    //activo(boolean), estadoSistemas (boolean) y nivelBateria (int)
    public Robot(boolean activo, boolean estadoSistemas, int nivelBateria) {
        this.activo = activo;
        this.estadoSistemas = estadoSistemas;
        this.nivelBateria = nivelBateria;
    }

    public Robot() {
        this.activo = false;
        this.estadoSistemas = false;
        this.nivelBateria = 0;
    }

    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }

    public boolean isEstadoSistemas() {
        return estadoSistemas;
    }

    public void setEstadoSistemas(boolean estadoSistemas) {
        this.estadoSistemas = estadoSistemas;
    }

    public int getNivelBateria() {
        return nivelBateria;
    }

    public void setNivelBateria(int nivelBateria) {
        this.nivelBateria = nivelBateria;
    }

    @Override
    public String toString() {
        return "Robot{" + "activo = " + activo + ", estadoSistemas = " + estadoSistemas + ", nivelBateria = " + nivelBateria + '}';
    }

    @Override
    public void activar() {
        if (activo) {
            System.out.println("El robot ya esta activo");
        } else if (!activo) {
            if (!estadoSistemas || nivelBateria < 20) {
                System.out.println("Se han encontrado problemas. Estado de los sistemas " + estadoSistemas + ". Nivel de bateria: " + nivelBateria + "%.");
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
            System.out.println("El robot esta desactivado");
        } else if (activo = false) {
            System.out.println("El robot ya estaba desactivado");
        }
    }

    @Override
    public String revisarEstado() {
        if (estadoSistemas = false) {
            return "Fallos detectados en los sistemas del robot";
        } else {
            if (nivelBateria < 20) {
                return "La bateria del robot está baja. Nivel de batería: " + nivelBateria + "%";
            } else {
                return "Todos los sistemas están operativos y el nivel de batería es adecuado";
            }
        }
    }

}


