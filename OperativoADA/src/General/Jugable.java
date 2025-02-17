/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package General;

import Recursos.personajes.Personajes;  //Clase Personajes importado desde el paquete Recursos.personajes.

/**
 *
 * @author guill
 */
public interface Jugable {   //Interfaz Disparable.

    public void atacar(Personajes enemigo); //Método que recibe una variable de tipo Personajes por Parámetro.

    public void esquivar();

    public void defender();

}
