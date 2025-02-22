/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package tema8ej8;

import java.util.Scanner;

/**
 *
 * @author guill
 */
import java.util.Scanner;

public class Tema8ej8 {

    static Scanner entrada = new Scanner(System.in);
    public static final Producto[] listaProductos = new Producto[pedirLongitud()];
    public static int unidadesCompradas;
    public static int precioTotal; 

    public static void main(String[] args) {
        crearLista(listaProductos); 
        menuPrincipal(listaProductos); 

    }

    public static void menuPrincipal(Producto[] listaProductos) {
        boolean cerrar = true;
        boolean cerrarPrograma = false; 
        for (int i = 0; i < listaProductos.length; i++) {
            int numLista = (i + 1);
            System.out.println("Pulse " + numLista + " para comprar " + listaProductos[i].getNombre()
                    + " cuyo precio es de " + listaProductos[i].getPrecio() + " euros y cuyo stock es de "
                    + listaProductos[i].getStock() + " unidades.");
        }

        do {
            try {
                System.out.println("Pulse 0 para salir.");
                int opcion = escaner();
                if (opcion == 0) {
                    cerrar = false; // Salimos del menú
                    cerrarPrograma = true; // Indicamos que el programa debe terminar
                } else if (opcion > 0 && opcion <= listaProductos.length) {
                    Producto productoSeleccionado = listaProductos[opcion - 1];
                    procesarCompra(productoSeleccionado, precioTotal, unidadesCompradas); // Procesamos la compra del producto seleccionado
                    comprarMas(listaProductos);
                } else {
                    System.out.println("Opción no válida. Inténtelo de nuevo.");
                }
            } catch (Exception e) {
                System.out.println("Error: Entrada no válida.");
            }
        } while (cerrar);
    }

    public static void procesarCompra(Producto producto, int precioTotal, int unidades) {
        System.out.println("¿Cuántas unidades de " + producto.getNombre() + " desea comprar?");
        unidades = entrada.nextInt();

        if (unidades > producto.getStock()) {
            System.out.println("Lo sentimos. No tenemos tantas unidades en stock. Nuestro stock actual es de " + producto.getStock() + ".");
        } else {
            actualizarStock(producto, unidades);
        }

    }

    public static void actualizarStock(Producto producto, int unidades) {
        producto.setStock(producto.getStock() - unidades); // Actualizamos el stock
        precioTotal += producto.getPrecio() * unidades; // Acumulamos el precio total
        System.out.println("Venta de " + unidades + " unidades realizada con éxito.");
    }

    public static void comprarMas(Producto[] listaProductos) {
        System.out.println("¿Desea comprar otro producto? (Si/No)");
        String respuesta = entrada.next();
        if (respuesta.equalsIgnoreCase("Si")) {
            menuPrincipal(listaProductos); // Volvemos al menú principal
        } else if (respuesta.equalsIgnoreCase("No")) {
            importeTotal(precioTotal);
        }
    }

    public static void importeTotal(int precioTotal) {
        System.out.println("El importe total de la compra es " + precioTotal + " euros.");
    }

    public static void crearLista(Producto[] listaProductos) {
        for (int i = 0; i < listaProductos.length; i++) {
            listaProductos[i] = new Producto(pedirNombre(), pedirPrecio(), pedirStock());
            System.out.println("PRODUCTO " + (i + 1) + " ALMACENADO CON ÉXITO");
        }
    }

    public static int pedirLongitud() {
        System.out.println("--Bienvenido a mi Tienda de Deportes--\n\nAcceso al menú de Administración:\n\n¿Cuántos productos le gustaría dar de alta?");
        return entrada.nextInt();
    }

    public static String pedirNombre() {
        System.out.println("Introduzca el nombre del producto:");
        return entrada.next();
    }

    public static int pedirPrecio() {
        System.out.println("Introduzca el precio del producto:");
        return entrada.nextInt();
    }

    public static int pedirStock() {
        System.out.println("Introduzca el stock del producto:");
        return entrada.nextInt();
    }

    public static int escaner() {
        return entrada.nextInt();
    }
}
