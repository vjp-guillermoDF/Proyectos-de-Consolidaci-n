/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package tema6ej13;

/**
 *
 * @author guill
 */
public class Test {

    public static void mostrarTodo(Robot objeto, Microondas objeto2) {
        System.out.println(objeto.toString());
        objeto.activar();
        System.out.println(objeto.revisarEstado());
        objeto.desactivar();
        System.out.println(objeto2.toString());
        objeto2.activar();
        System.out.println(objeto2.revisarEstado());
        objeto2.desactivar();
    }

    public static void revisableUoperable(Revisable objeto, Operable objeto2) {
        System.out.println(objeto.toString());
        System.out.println(objeto.revisarEstado());
        System.out.println(objeto2.toString());
        objeto2.activar();
        objeto2.desactivar();

    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here

        Robot robot = new Robot(false, true, 15);
        Microondas microondas = new Microondas(true, true, false);
        Operable robot2 = new Robot(true, true, 50);
        Revisable microondas2 = new Microondas(false, true, true);

        mostrarTodo(robot, microondas);
        revisableUoperable(microondas2, robot2);
    }

}
