/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package testsam;

import java.util.Scanner;

/**
 *
 * @author guill
 */
public class TestsAM {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Selecciona un test (1-15): ");
        int testSeleccionado = scanner.nextInt();
        scanner.nextLine(); // Consumir salto de línea

        if (testSeleccionado < 1 || testSeleccionado > 15) {
            System.out.println("Test inválido. Debes elegir un número entre 1 y 15.");
        } else {
            ejecutarTest(testSeleccionado, scanner);
        }

        scanner.close();
    }

    public static void ejecutarTest(int numTest, Scanner scanner) {
        int respuestasCorrectas = 0;

        System.out.println("\n=== Iniciando Test " + numTest + " ===\n");

        for (int i = 1; i <= 15; i++) {
            if (hacerPregunta(numTest, i, scanner)) {
                respuestasCorrectas++;
            }
        }

        System.out.println("\nTest finalizado. Respuestas correctas: " + respuestasCorrectas + "/15\n");
    }

    public static boolean hacerPregunta(int numTest, int numPregunta, Scanner scanner) {
        String pregunta = "";
        String[] opciones = new String[3];
        char respuestaCorrecta = ' ';

        // Switch para seleccionar las preguntas según el test
        switch (numTest) {
            case 1:
                switch (numPregunta) {
                    case 1:
                        pregunta = "¿Que cilindrada máxima puede tener el motor de combustion interna de un ciclomotor?";
                        opciones = new String[]{"a) 74cc", "b) 50cc", "c) 40cc"};
                        respuestaCorrecta = 'b';
                        break;
                    case 2:
                        pregunta = "Ademas del permiso de conduccion, ¿que documentos debe llevar en el vehiculo cuando circule con su ciclomotor?";
                        opciones = new String[]{"a) El permiso de circulacion y la tarjeta ITV", "b) El permiso de circulacion unicamente", "c) El permiso de circulacion y el recibo del seguro, unicamente"};
                        respuestaCorrecta = 'a';
                        break;
                    case 3:
                        pregunta = "De los documentos que debe llevar cuando circule con su ciclomotor, ¿lee esta permitido llevar fotocopias en lugar del original?";
                        opciones = new String[]{"a) Sí, siempre y cuando las fotocopias esten debidamente autentificadas", "b) Si, excepto del permiso de conducir que debera ser siempre original", "c) No"};
                        respuestaCorrecta = 'a';
                        break;
                    case 4:
                        pregunta = "De los documentos que debe llevar cuando circule con su ciclomotor, ¿lee esta permitido llevar fotocopias en lugar del original?";
                        opciones = new String[]{"a) Sí, siempre y cuando las fotocopias esten debidamente autentificadas", "b) Si, excepto del permiso de conducir que debera ser siempre original", "c) No"};
                        respuestaCorrecta = 'a';

                        break;
                    case 5:

                        pregunta = "De los documentos que debe llevar cuando circule con su ciclomotor, ¿lee esta permitido llevar fotocopias en lugar del original?";
                        opciones = new String[]{"a) Sí, siempre y cuando las fotocopias esten debidamente autentificadas", "b) Si, excepto del permiso de conducir que debera ser siempre original", "c) No"};
                        respuestaCorrecta = 'a';
                        break;
                    case 6:

                        pregunta = "De los documentos que debe llevar cuando circule con su ciclomotor, ¿lee esta permitido llevar fotocopias en lugar del original?";
                        opciones = new String[]{"a) Sí, siempre y cuando las fotocopias esten debidamente autentificadas", "b) Si, excepto del permiso de conducir que debera ser siempre original", "c) No"};
                        respuestaCorrecta = 'a';
                        break;
                    case 7:

                        pregunta = "De los documentos que debe llevar cuando circule con su ciclomotor, ¿lee esta permitido llevar fotocopias en lugar del original?";
                        opciones = new String[]{"a) Sí, siempre y cuando las fotocopias esten debidamente autentificadas", "b) Si, excepto del permiso de conducir que debera ser siempre original", "c) No"};
                        respuestaCorrecta = 'a';
                        break;
                    case 8:

                        pregunta = "De los documentos que debe llevar cuando circule con su ciclomotor, ¿lee esta permitido llevar fotocopias en lugar del original?";
                        opciones = new String[]{"a) Sí, siempre y cuando las fotocopias esten debidamente autentificadas", "b) Si, excepto del permiso de conducir que debera ser siempre original", "c) No"};
                        respuestaCorrecta = 'a';

                        break;
                    case 9:

                        pregunta = "De los documentos que debe llevar cuando circule con su ciclomotor, ¿lee esta permitido llevar fotocopias en lugar del original?";
                        opciones = new String[]{"a) Sí, siempre y cuando las fotocopias esten debidamente autentificadas", "b) Si, excepto del permiso de conducir que debera ser siempre original", "c) No"};
                        respuestaCorrecta = 'a';

                        break;
                    case 10:

                        pregunta = "De los documentos que debe llevar cuando circule con su ciclomotor, ¿lee esta permitido llevar fotocopias en lugar del original?";
                        opciones = new String[]{"a) Sí, siempre y cuando las fotocopias esten debidamente autentificadas", "b) Si, excepto del permiso de conducir que debera ser siempre original", "c) No"};
                        respuestaCorrecta = 'a';

                        break;
                    case 11:

                        pregunta = "De los documentos que debe llevar cuando circule con su ciclomotor, ¿lee esta permitido llevar fotocopias en lugar del original?";
                        opciones = new String[]{"a) Sí, siempre y cuando las fotocopias esten debidamente autentificadas", "b) Si, excepto del permiso de conducir que debera ser siempre original", "c) No"};
                        respuestaCorrecta = 'a';

                        break;
                    case 12:

                        pregunta = "De los documentos que debe llevar cuando circule con su ciclomotor, ¿lee esta permitido llevar fotocopias en lugar del original?";
                        opciones = new String[]{"a) Sí, siempre y cuando las fotocopias esten debidamente autentificadas", "b) Si, excepto del permiso de conducir que debera ser siempre original", "c) No"};
                        respuestaCorrecta = 'a';
                        break;
                    case 13:

                        pregunta = "De los documentos que debe llevar cuando circule con su ciclomotor, ¿lee esta permitido llevar fotocopias en lugar del original?";
                        opciones = new String[]{"a) Sí, siempre y cuando las fotocopias esten debidamente autentificadas", "b) Si, excepto del permiso de conducir que debera ser siempre original", "c) No"};
                        respuestaCorrecta = 'a';
                        break;
                    case 14:

                        pregunta = "De los documentos que debe llevar cuando circule con su ciclomotor, ¿lee esta permitido llevar fotocopias en lugar del original?";
                        opciones = new String[]{"a) Sí, siempre y cuando las fotocopias esten debidamente autentificadas", "b) Si, excepto del permiso de conducir que debera ser siempre original", "c) No"};
                        respuestaCorrecta = 'a';
                        break;
                    case 15:

                        pregunta = "De los documentos que debe llevar cuando circule con su ciclomotor, ¿lee esta permitido llevar fotocopias en lugar del original?";
                        opciones = new String[]{"a) Sí, siempre y cuando las fotocopias esten debidamente autentificadas", "b) Si, excepto del permiso de conducir que debera ser siempre original", "c) No"};
                        respuestaCorrecta = 'a';
                        break;

                    default:
                        System.out.println("Opcion no valida");

                }
                break;

            case 2:
                switch (numPregunta) {
                    case 1:
                        pregunta = "¿Cuál es el océano más grande del mundo?";
                        opciones = new String[]{"a) Atlántico", "b) Índico", "c) Pacífico"};
                        respuestaCorrecta = 'c';
                        break;
                    case 2:
                        pregunta = "¿Cuántos continentes hay en la Tierra?";
                        opciones = new String[]{"a) 5", "b) 6", "c) 7"};
                        respuestaCorrecta = 'c';
                        break;
                    case 3:
                        pregunta = "¿Quién pintó la Mona Lisa?";
                        opciones = new String[]{"a) Van Gogh", "b) Leonardo da Vinci", "c) Picasso"};
                        respuestaCorrecta = 'b';
                        break;
                    // ... Más preguntas hasta la 15 ...
                    default:
                        pregunta = "Pregunta de prueba " + numPregunta;
                        opciones = new String[]{"a) Opción 1", "b) Opción 2", "c) Opción 3"};
                        respuestaCorrecta = 'b';
                        break;
                }
                break;

            // ... Agregar más tests hasta el 15 ...
            default:
                pregunta = "Pregunta de prueba " + numPregunta;
                opciones = new String[]{"a) Opción 1", "b) Opción 2", "c) Opción 3"};
                respuestaCorrecta = 'a';
                break;
        }

        // Mostrar la pregunta y opciones
        System.out.println(pregunta);
        for (String opcion : opciones) {
            System.out.println(opcion);
        }

        // Capturar respuesta del usuario
        System.out.print("Tu respuesta: ");
        char respuestaUsuario = scanner.nextLine().toLowerCase().charAt(0);

        // Evaluar respuesta
        if (respuestaUsuario == respuestaCorrecta) {
            System.out.println("? Correcto!\n");
            return true;
        } else {
            System.out.println("? Incorrecto. La respuesta correcta era: " + respuestaCorrecta + "\n");
            return false;
        }
    }
}
