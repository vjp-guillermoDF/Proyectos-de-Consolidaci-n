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
public interface Disparable {   //Interfaz Disparable.

    public void apuntar(Personajes enemigo);    //Método que recibe una variable de tipo Personajes por Parámetro.

    public void cargarArma();

    public int obtenerNumeroBlas();

    public void eliminarBala();

}
