import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Scanner;

public class programaPracticaObligatoria2 {
    public static void main(String[] args) {
        //definir variables
        var s = new Scanner(System.in);
        String adminUser = "canela", adminPass = "1961", passIntro, userIntro, opcion, opcionAdmin, checkOutFechaSalida,
                /*estado           nombre            apellido            ID*/
                estadoIndividual1, habINombre1 = "", habIApellido1 = "", habIId1 = "",
                estadoIndividual2, habINombre2 = "", habIApellido2 = "", habIId2 = "",
                estadoDoble1, habDNombre1 = "", habDApellido1 = "", habDId1 = "",
                estadoDoble2, habDNombre2 = "", habDApellido2 = "", habDId2 = "",
                estadoDoble3, habDNombre3 = "", habDApellido3 = "", habDId3 = "",
                estadoDoble4, habDNombre4 = "", habDApellido4 = "", habDId4 = "",
                estadoDoble5, habDNombre5 = "", habDApellido5 = "", habDId5 = "",
                estadoDoble6, habDNombre6 = "", habDApellido6 = "", habDId6 = "",
                estadoDoble7, habDNombre7 = "", habDApellido7 = "", habDId7 = "",
                estadoDoble8, habDNombre8 = "", habDApellido8 = "", habDId8 = "",
                nombreHuesped, apellidoHuesped, numConfirm = "", numerosStr,
                listaLetras = "TRWAGMYFPDXBNJZSQVHLCKE", idCompleto, entradaFactura, salidaFactura, habitaciones = "";
        //pondremos un usuario y contraseña predeterminada

        int noches = 0, numId, restoId, dni, teclaSalir = 0, tarifaFactura = 0, apagarMenuAdmin, contReserva = 0,
                billete500e = 100, monedas2e = 100, billete500eDevolver = 0, monedas2eDevolver = 0,
                billete200e = 100, monedas1e = 100, billete200eDevolver = 0, monedas1eDevolver = 0,
                billete100e = 100, monedas50cent = 100, billete100eDevolver = 0, monedas50centDevolver = 0,
                billete50e = 100, monedas20cent = 100, billete50eDevolver = 0, monedas20centDevolver = 0,
                billete20e = 100, monedas10cent = 100, billete20eDevolver = 0, monedas10centDevolver = 0,
                billete10e = 100, monedas5cent = 100, billete10eDevolver = 1, monedas5centDevolver = 0,
                billete5e = 100, monedas2cent = 100, billete5eDevolver = 0, monedas2centDevolver = 0,
                monedas1cent = 100, monedas1centDevolver = 0;
        char letra, dniLetra, euro = '€', porcentaje = '%';
        final int tarifaDoble = 45, tarifaIndividual = 60;
        final float IVAporcentaje = 0.21f;
        float total = 0, monto = 0, subtotal = 0, dineroIntro, cambio, ingresosTotales;
        LocalDate fechaSalida = null, fechaInicio = null;

        boolean off = true, factura = false, idValido = false,
                habitacionIndividual1 = false, habitacionIndividual2 = false,
                habitacionDoble1 = false, habitacionDoble2 = false, habitacionDoble3 = false,
                habitacionDoble4 = false, habitacionDoble5 = false, habitacionDoble6 = false,
                habitacionDoble7 = false, habitacionDoble8 = false;

        //cartel del hotel
        System.out.println("""
                                                                                                                                                                          \s
                 ▀████▀  ▀████▀▀ ▄▄█▀▀██▄ ███▀▀██▀▀██████▀▀▀███▀████▀       ▀███▀▀▀██▄ ▀███▀▀▀███    ▀████▄     ▄███▀     ██     ▀███▀▀▀██▄ ███▀▀██▀▀███ ▄▄█▀▀██▄  ▄█▀▀▀█▄█
                   ██      ██  ▄██▀    ▀██▄▀   ██   ▀█ ██    ▀█  ██           ██    ▀██▄ ██    ▀█      ████    ████      ▄██▄      ██   ▀██▄█▀   ██   ▀███▀    ▀██▄██    ▀█
                   ██      ██  ██▀      ▀██    ██      ██   █    ██           ██     ▀██ ██   █        █ ██   ▄█ ██     ▄█▀██▄     ██   ▄██      ██    ██▀      ▀█████▄   \s
                   ██████████  ██        ██    ██      ██████    ██           ██      ██ ██████        █  ██  █▀ ██    ▄█  ▀██     ███████       ██    ██        ██ ▀█████▄
                   ██      ██  ██▄      ▄██    ██      ██   █  ▄ ██     ▄     ██     ▄██ ██   █  ▄     █  ██▄█▀  ██    ████████    ██  ██▄       ██    ██▄      ▄██     ▀██
                   ██      ██  ▀██▄    ▄██▀    ██      ██     ▄█ ██    ▄█     ██    ▄██▀ ██     ▄█     █  ▀██▀   ██   █▀      ██   ██   ▀██▄     ██    ▀██▄    ▄██▀█     ██
                 ▄████▄  ▄████▄▄ ▀▀████▀▀    ▄████▄  ▄███████████████████   ▄████████▀ ▄██████████   ▄███▄ ▀▀  ▄████▄███▄   ▄████▄████▄ ▄███▄  ▄████▄    ▀▀████▀▀ █▀█████▀\s
                                                                                                                                                                          \s
                """);

        do { //estructura principal
            //menú pricipal
            System.out.print("""
                    .-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-.
                    |                    MENÚ PRINCIPAL                     |
                    !                                                       !
                    :   a. Ver el estado de ocupación de las habitaciones.  :
                    .   b. Reservar una habitación.                         .
                    :   c. Realizar el checkout de una habitación.          :
                    ¡   d. Menú de Administrador.                           ¡
                    |                                                       |
                    `-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-'
                    """);
            System.out.print("Selecione la opción deseada: ");
            opcion = s.nextLine(); //para elegir la opción del menú
            opcion = opcion.toLowerCase(); //pasamos los datos por teclado a minusculas

            switch (opcion) { //opciones del menú principal

                case "a": //ver el estado de ocupacíón de las habitaciones

                    //hacemos un loading
                    System.out.print("\nEspere un momento ");
                    for (int i = 0; i < 3; i++) {
                        try {
                            Thread.sleep(500);
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                        System.out.print(". ");
                    }
                    System.out.println(); //da un salto de línea para que los puntos del loading no se pequen con lo demás

                    /*los if comprueban si la habitación está ocupada, si están en false la habitación
                    la habitación quedará "libre" y si están en true, cambiará su valor a "ocupada"*/

                    if (habitacionIndividual1 == true) estadoIndividual1 = "OCUPADA"; //si es true se pone ocupada
                    else estadoIndividual1 = "LIBRE"; //si es false se pone libre

                    if (habitacionIndividual2 == true) estadoIndividual2 = "OCUPADA";
                    else estadoIndividual2 = "LIBRE";

                    if (habitacionDoble1 == true) estadoDoble1 = "OCUPADA";
                    else estadoDoble1 = "LIBRE";

                    if (habitacionDoble2 == true) estadoDoble2 = "OCUPADA";
                    else estadoDoble2 = "LIBRE";

                    if (habitacionDoble3 == true) estadoDoble3 = "OCUPADA";
                    else estadoDoble3 = "LIBRE";

                    if (habitacionDoble4 == true) estadoDoble4 = "OCUPADA";
                    else estadoDoble4 = "LIBRE";

                    if (habitacionDoble5 == true) estadoDoble5 = "OCUPADA";
                    else estadoDoble5 = "LIBRE";

                    if (habitacionDoble6 == true) estadoDoble6 = "OCUPADA";
                    else estadoDoble6 = "LIBRE";

                    if (habitacionDoble7 == true) estadoDoble7 = "OCUPADA";
                    else estadoDoble7 = "LIBRE";

                    if (habitacionDoble8 == true) estadoDoble8 = "OCUPADA";
                    else estadoDoble8 = "LIBRE";


                    System.out.printf("""
                                    .-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-.
                                    |               ESTADO DE LAS HABITACIONES            \t|
                                    |                                                     \t|
                                    |          HABITACIONES                    ESTADO     \t|
                                    |                                                     \t|
                                    |           Individuales                              \t|
                                    !         •Habitación 101.                  %s\t\t!
                                    :         •Habitación 102.                  %s\t\t:
                                    :                                                     \t:
                                    .             Dobles                                  \t.
                                    .         •Habitación 201.                  %s\t\t.
                                    :         •Habitación 202.                  %s\t\t:
                                    :         •Habitación 203.                  %s\t\t:
                                    !         •Habitación 204.                  %s\t\t!
                                    |         •Habitación 301.                  %s\t\t|
                                    |         •Habitación 302.                  %s\t\t|
                                    |         •Habitación 303.                  %s\t\t|
                                    |         •Habitación 304.                  %s\t\t|
                                    |                                                     \t|
                                    |    Pulse una tecla para volver al menú principal.   \t|
                                    `-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-'
                                    """, estadoIndividual1, estadoIndividual2, estadoDoble1, estadoDoble2, estadoDoble3,
                            estadoDoble4, estadoDoble5, estadoDoble6, estadoDoble7, estadoDoble8);
                    s.nextLine();
                    //hacemos un loading
                    System.out.print("\n Espere un momento ");
                    for (int i = 0; i < 3; i++) {
                        try {
                            Thread.sleep(500);
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                        System.out.print(". ");
                    }
                    System.out.println();
                    break;

                case "b": //Reservar una habitación

                    //hacemos un loading
                    System.out.print("\n Espere un momento ");
                    for (int i = 0; i < 3; i++) {
                        try {
                            Thread.sleep(500);
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                        System.out.print(". ");
                    }
                    System.out.println();

                    do { //para confirmar los huespedes

                        System.out.println("""
                                +----------------------------------+
                                | ·¿Qué tipo de habitación busca?  |
                                +----------------------------------+
                                | 1. Individual.                   |
                                | 2. Doble.                        |
                                +----------------------------------+
                                """);
                        System.out.print("Seleccione la opción deseada: ");
                        habitaciones = s.nextLine();

                        switch (habitaciones) {

                            case "1": //para las habitaciones individuales
                                //hacemos un loading
                                System.out.print("\n Espere un momento ");
                                for (int i = 0; i < 3; i++) {
                                    try {
                                        Thread.sleep(500);
                                    } catch (InterruptedException e) {
                                        throw new RuntimeException(e);
                                    }
                                    System.out.print(". ");
                                }
                                System.out.println();

                                System.out.print("\n·Introduzca su nombre: ");
                                nombreHuesped = s.nextLine();
                                nombreHuesped = nombreHuesped.toUpperCase().charAt(0) + nombreHuesped.substring(1, nombreHuesped.length()).toLowerCase();

                                System.out.print("·Introduzca su apellido: ");
                                apellidoHuesped = s.nextLine();
                                apellidoHuesped = apellidoHuesped.toUpperCase().charAt(0) + apellidoHuesped.substring(1, apellidoHuesped.length()).toLowerCase();

                                do { //proceso de validación del ID

                                    System.out.print("Introduce tu número de identificación completo: ");
                                    idCompleto = s.nextLine();

                                    numerosStr = idCompleto.substring(0, 8); //obtener los primeros 8 digitos
                                    letra = idCompleto.charAt(8); //obtener la letra

                                    numId = Integer.parseInt(numerosStr);
                                    restoId = numId % 23;
                                    dniLetra = listaLetras.charAt(restoId);

                                    if (letra != dniLetra || idCompleto.length() != 9)
                                        System.out.println("\n     ✗ Número de ID no válido. Vuelve a intentar.");
                                    else
                                        idValido = true; //si el id es correcto, le codigo sigue y no me muestra ningún mensaje
                                } while (!idValido);

                                if (habitacionIndividual2 == true) { //las habitaciones se llenan en orde, si la última está llena, todas están llenas
                                    System.out.println("\n ✗ No quedan habitaciones individuales disponibles.");
                                    System.out.print("Pulse una tecla para volver a elegir tipo de habitación: ");
                                    s.nextLine();
                                    //hacemos un loading
                                    System.out.print("\n Espere un momento ");
                                    for (int i = 0; i < 3; i++) {
                                        try {
                                            Thread.sleep(500);
                                        } catch (InterruptedException e) {
                                            throw new RuntimeException(e);
                                        }
                                        System.out.print(". ");
                                    }
                                    System.out.println();

                                } else if (habitacionIndividual1 == false) { //Si no esta ocupada la hab1 la ponemos a ocupada hacemos lo mismo con las siguientes habitaciones
                                    habitacionIndividual1 = true; //la ponemos como ocupada
                                    contReserva++;
                                    habINombre1 = nombreHuesped; //guardamos el nombre es una nueva variable
                                    habIApellido1 = apellidoHuesped;
                                    habIId1 = idCompleto;
                                    System.out.println("\n·Habitación 101: RESERVADA.");
                                    System.out.print("  Muchas gracias por su reservación. Introduzca el número 3 para salir al menú principal: ");
                                    teclaSalir = Integer.parseInt(s.nextLine());

                                } else if (habitacionIndividual2 == false) {
                                    habitacionIndividual2 = true; //la ponemos como ocupada
                                    contReserva++;
                                    habINombre2 = nombreHuesped;
                                    habIApellido2 = apellidoHuesped;
                                    habIId2 = idCompleto;
                                    System.out.println("\n·Habitación 102: RESERVADA.");
                                    System.out.print("  Muchas gracias por su reservación. Introduzca el número 3 para salir al menú principal: ");
                                    teclaSalir = Integer.parseInt(s.nextLine());
                                }
                                break;

                            case "2": //para las habitaciones dobles
                                //hacemos un loading
                                System.out.print("\n Espere un momento ");
                                for (int i = 0; i < 3; i++) {
                                    try {
                                        Thread.sleep(500);
                                    } catch (InterruptedException e) {
                                        throw new RuntimeException(e);
                                    }
                                    System.out.print(". ");
                                }
                                System.out.println();

                                System.out.print("\n·Introduzca su nombre: ");
                                nombreHuesped = s.nextLine();
                                nombreHuesped = nombreHuesped.toUpperCase().charAt(0) + nombreHuesped.substring(1, nombreHuesped.length()).toLowerCase();

                                System.out.print("·Introduzca su apellido: ");
                                apellidoHuesped = s.nextLine();
                                apellidoHuesped = apellidoHuesped.toUpperCase().charAt(0) + apellidoHuesped.substring(1, apellidoHuesped.length()).toLowerCase();

                                do { //proceso de validación del ID

                                    System.out.print("Introduce tu número de identificación completo: ");
                                    idCompleto = s.nextLine();

                                    numerosStr = idCompleto.substring(0, 8); //obtener los primeros 8 digitos
                                    letra = idCompleto.charAt(8); //obtener la letra

                                    numId = Integer.parseInt(numerosStr);
                                    restoId = numId % 23;
                                    dniLetra = listaLetras.charAt(restoId);

                                    if (letra != dniLetra || idCompleto.length() != 9)
                                        System.out.println("\n     ✗ Número de ID no válido. Vuelve a intentar.");
                                    else
                                        idValido = true; //si el id es correcto, le codigo sigue y no me muestra ningún mensaje
                                } while (!idValido);

                                if (habitacionDoble8 == true) {
                                    System.out.println("\n ✗ No quedan habitaciones dobles disponibles.");
                                    System.out.print("  Pulse una tecla para volver a elegir tipo de habitación: ");
                                    s.nextLine();
                                    //hacemos un loading
                                    System.out.print("\n Espere un momento ");
                                    for (int i = 0; i < 3; i++) {
                                        try {
                                            Thread.sleep(500);
                                        } catch (InterruptedException e) {
                                            throw new RuntimeException(e);
                                        }
                                        System.out.print(". ");
                                    }
                                    System.out.println();

                                    //hacemos un loading
                                    System.out.print("\n Espere un momento ");
                                    for (int i = 0; i < 3; i++) {
                                        try {
                                            Thread.sleep(500);
                                        } catch (InterruptedException e) {
                                            throw new RuntimeException(e);
                                        }
                                        System.out.print(". ");
                                    }
                                    System.out.println();

                                } else if (habitacionDoble1 == false) {
                                    habitacionDoble1 = true; //la ponemos como ocupada
                                    contReserva++;
                                    habDNombre1 = nombreHuesped;
                                    habDApellido1 = apellidoHuesped;
                                    habDId1 = idCompleto;
                                    System.out.println("\n·Habitación 201: RESERVADA.");
                                    System.out.print("  Muchas gracias por su reservación. Introduzca el número 3 para salir al menú principal: ");
                                    teclaSalir = Integer.parseInt(s.nextLine());

                                    //hacemos un loading
                                    System.out.print("\n Espere un momento ");
                                    for (int i = 0; i < 3; i++) {
                                        try {
                                            Thread.sleep(500);
                                        } catch (InterruptedException e) {
                                            throw new RuntimeException(e);
                                        }
                                        System.out.print(". ");
                                    }
                                    System.out.println();

                                } else if (habitacionDoble2 == false) {
                                    habitacionDoble2 = true; //la ponemos como ocupada
                                    contReserva++;
                                    habDNombre2 = nombreHuesped;
                                    habDApellido2 = apellidoHuesped;
                                    habDId2 = idCompleto;
                                    System.out.println("\n·Habitación 202: RESERVADA.");
                                    System.out.print("  Muchas gracias por su reservación. Introduzca el número 3 para salir al menú principal: ");
                                    teclaSalir = Integer.parseInt(s.nextLine());

                                    //hacemos un loading
                                    System.out.print("\n Espere un momento ");
                                    for (int i = 0; i < 3; i++) {
                                        try {
                                            Thread.sleep(500);
                                        } catch (InterruptedException e) {
                                            throw new RuntimeException(e);
                                        }
                                        System.out.print(". ");
                                    }
                                    System.out.println();

                                } else if (habitacionDoble3 == false) {
                                    habitacionDoble3 = true; //la ponemos como ocupada
                                    contReserva++;
                                    habDNombre3 = nombreHuesped;
                                    habDApellido3 = apellidoHuesped;
                                    habDId3 = idCompleto;
                                    System.out.println("\n·Habitación 203: RESERVADA.");
                                    System.out.print("  Muchas gracias por su reservación. Introduzca el número 3 para salir al menú principal: ");
                                    teclaSalir = Integer.parseInt(s.nextLine());

                                    //hacemos un loading
                                    System.out.print("\n Espere un momento ");
                                    for (int i = 0; i < 3; i++) {
                                        try {
                                            Thread.sleep(500);
                                        } catch (InterruptedException e) {
                                            throw new RuntimeException(e);
                                        }
                                        System.out.print(". ");
                                    }
                                    System.out.println();

                                } else if (habitacionDoble4 == false) {
                                    habitacionDoble4 = true; //la ponemos como ocupada
                                    contReserva++;
                                    habDNombre4 = nombreHuesped;
                                    habDApellido4 = apellidoHuesped;
                                    habDId4 = idCompleto;
                                    System.out.println("\n·Habitación 204: RESERVADA.");
                                    System.out.print("  Muchas gracias por su reservación. Introduzca el número 3 para salir al menú principal: ");
                                    teclaSalir = Integer.parseInt(s.nextLine());

                                    //hacemos un loading
                                    System.out.print("\n Espere un momento ");
                                    for (int i = 0; i < 3; i++) {
                                        try {
                                            Thread.sleep(500);
                                        } catch (InterruptedException e) {
                                            throw new RuntimeException(e);
                                        }
                                        System.out.print(". ");
                                    }
                                    System.out.println();

                                } else if (habitacionDoble5 == false) {
                                    habitacionDoble5 = true; //la ponemos como ocupada
                                    contReserva++;
                                    habDNombre5 = nombreHuesped;
                                    habDApellido5 = apellidoHuesped;
                                    habDId5 = idCompleto;
                                    System.out.println("\n·Habitación 301: RESERVADA.");
                                    System.out.print("  Muchas gracias por su reservación. Introduzca el número 3 para salir al menú principal: ");
                                    teclaSalir = Integer.parseInt(s.nextLine());

                                    //hacemos un loading
                                    System.out.print("\n Espere un momento ");
                                    for (int i = 0; i < 3; i++) {
                                        try {
                                            Thread.sleep(500);
                                        } catch (InterruptedException e) {
                                            throw new RuntimeException(e);
                                        }
                                        System.out.print(". ");
                                    }
                                    System.out.println();

                                } else if (habitacionDoble6 == false) {
                                    habitacionDoble6 = true; //la ponemos como ocupada
                                    contReserva++;
                                    habDNombre6 = nombreHuesped;
                                    habDApellido6 = apellidoHuesped;
                                    habDId6 = idCompleto;
                                    System.out.println("\n·Habitación 302: RESERVADA.");
                                    System.out.print("  Muchas gracias por su reservación. Introduzca el número 3 para salir al menú principal: ");
                                    teclaSalir = Integer.parseInt(s.nextLine());

                                    //hacemos un loading
                                    System.out.print("\n Espere un momento ");
                                    for (int i = 0; i < 3; i++) {
                                        try {
                                            Thread.sleep(500);
                                        } catch (InterruptedException e) {
                                            throw new RuntimeException(e);
                                        }
                                        System.out.print(". ");
                                    }
                                    System.out.println();

                                } else if (habitacionDoble7 == false) {
                                    habitacionDoble7 = true; //la ponemos como ocupada
                                    contReserva++;
                                    habDNombre7 = nombreHuesped;
                                    habDApellido7 = apellidoHuesped;
                                    habDId7 = idCompleto;
                                    System.out.println("\n·Habitación 303: RESERVADA.");
                                    System.out.print("  Muchas gracias por su reservación. Introduzca el número 3 para salir al menú principal: ");
                                    teclaSalir = Integer.parseInt(s.nextLine());

                                    //hacemos un loading
                                    System.out.print("\n Espere un momento ");
                                    for (int i = 0; i < 3; i++) {
                                        try {
                                            Thread.sleep(500);
                                        } catch (InterruptedException e) {
                                            throw new RuntimeException(e);
                                        }
                                        System.out.print(". ");
                                    }
                                    System.out.println();

                                } else if (habitacionDoble8 == false) {
                                    habitacionDoble8 = true; //la ponemos como ocupada
                                    contReserva++;
                                    habDNombre8 = nombreHuesped;
                                    habDApellido8 = apellidoHuesped;
                                    habDId8 = idCompleto;
                                    System.out.println("\n·Habitación 304: RESERVADA.");
                                    System.out.print("  Muchas gracias por su reservación. Introduzca el número 3 para salir al menú principal: ");
                                    teclaSalir = Integer.parseInt(s.nextLine());

                                    //hacemos un loading
                                    System.out.print("\n Espere un momento ");
                                    for (int i = 0; i < 3; i++) {
                                        try {
                                            Thread.sleep(500);
                                        } catch (InterruptedException e) {
                                            throw new RuntimeException(e);
                                        }
                                        System.out.print(". ");
                                    }
                                    System.out.println();
                                }
                                break;
                            default:
                                System.out.println("\n ✗ Opción introducida incorrecta.");
                                System.out.println("Pulse una tecla para volver elegir tipo de habitación.");
                                s.nextLine();
                        }

                    } while (teclaSalir != 3); //si los huespedes son menos o más de lo indicado el bucle sigue, y cuando no, se rompe.

                    break;

                case "c": //realizar el checkout de una habitación, la factura y el cambio a monedas

                    factura = false;

                    //hacemos un loading
                    System.out.print("\n Espere un momento ");
                    for (int i = 0; i < 3; i++) {
                        try {
                            Thread.sleep(500);
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                        System.out.print(". ");
                    }
                    System.out.println();

                    System.out.print("\n·Introduzca su nombre: ");
                    nombreHuesped = s.nextLine(); //para poner la primera letra en mayúscula y las demás en minúsculas
                    nombreHuesped = nombreHuesped.toUpperCase().charAt(0) + nombreHuesped.substring(1, nombreHuesped.length()).toLowerCase();

                    System.out.print("·Introduzca su apellido: ");
                    apellidoHuesped = s.nextLine();
                    apellidoHuesped = apellidoHuesped.toUpperCase().charAt(0) + apellidoHuesped.substring(1, apellidoHuesped.length()).toLowerCase();

                    do { //proceso de validación del ID
                        System.out.print("Introduce tu número de identificación completo: ");
                        idCompleto = s.nextLine();

                        numerosStr = idCompleto.substring(0, 8); //obtener los primeros 8 digitos
                        letra = idCompleto.charAt(8); //obtener la letra

                        numId = Integer.parseInt(numerosStr);
                        restoId = numId % 23;
                        dniLetra = listaLetras.charAt(restoId);

                        if (letra != dniLetra || idCompleto.length() != 9)
                            System.out.println("\n     ✗ Número de ID no válido. Vuelve a intentar.");
                        else idValido = true; //si el id es correcto, le codigo sigue y no me muestra ningún mensaje
                    } while (!idValido);

                    //saca los primero 4 numeros de id para volverlos el numero de confirmación
                    if (idCompleto.length() == 9) numConfirm = idCompleto.substring(0, 4);

                    if ((nombreHuesped.equals(habINombre1) && (idCompleto.equals(habIId1) ||
                            (nombreHuesped.equals(habINombre2) && (idCompleto.equals(habIId2)))))){
                        System.out.print("¿Hasta qué día se quedará? (YYYY-MM-DD): ");
                        checkOutFechaSalida = s.nextLine();

                        fechaInicio = LocalDate.now(); //hacemos una variable general para la fecha actual
                        fechaSalida = LocalDate.parse(checkOutFechaSalida); //parseamos la fecha para que sea admitida por la librería
                        noches = (int) fechaInicio.until(fechaSalida, ChronoUnit.DAYS);

                        apellidoHuesped = habIApellido1;
                        tarifaFactura = tarifaIndividual;
                        monto = tarifaIndividual * noches;
                        subtotal = (int) (monto * IVAporcentaje);
                        total = monto + subtotal;
                        habitacionIndividual2 = false; //para que se ponga libre
                        factura = true;

                    }
                    if ((nombreHuesped.equals(habDNombre1) && (idCompleto.equals(habDId1) || (nombreHuesped.equals(habDNombre2) && (idCompleto.equals(habDId2) ||
                            (nombreHuesped.equals(habDNombre3) && (idCompleto.equals(habDId3) || (nombreHuesped.equals(habDNombre4) && (idCompleto.equals(habDId4) ||
                                    (nombreHuesped.equals(habDNombre5) && (idCompleto.equals(habDId5) || (nombreHuesped.equals(habDNombre6) && (idCompleto.equals(habDId6) ||
                                            (nombreHuesped.equals(habDNombre7) && (idCompleto.equals(habDId7) || (nombreHuesped.equals(habDNombre8) && (idCompleto.equals(habDId8)))))))))))))))))){

                        System.out.print("¿Hasta qué día se quedará? (YYYY-MM-DD): ");
                        checkOutFechaSalida = s.nextLine();
                        System.out.println(); //salto de línea
                        fechaInicio = LocalDate.now(); //hacemos una variable general para la fecha actual
                        fechaSalida = LocalDate.parse(checkOutFechaSalida); //parseamos la fecha para que sea admitida por la librería
                        noches = (int) fechaInicio.until(fechaSalida, ChronoUnit.DAYS);

                        apellidoHuesped = habDApellido1;
                        tarifaFactura = tarifaIndividual;
                        monto = tarifaIndividual * noches;
                        subtotal = (int) (monto * IVAporcentaje);
                        total = monto + subtotal;
                        habitacionDoble8 = false;
                        factura = true;
                    }

                    //convierto las fechas a string para que puedan mostrarse en el prinf
                    entradaFactura = fechaInicio.toString();
                    salidaFactura = fechaSalida.toString();

                    if (factura == true) {
                        System.out.printf("""
                               +---------------------------------------------------------+
                               |                        FACTURA                          |
                               +---------------------------------------------------------+
                                 DESCRIPCIÓN: %s %s
                               +---------------------------+-------------+---------------+
                                 CONFIRMACIÓN: %s          | PAX: %s     |NOCHES: %d%n
                               +-------------+-------------+-------------+---------------+
                                 ENTRADA: %s%n                                           
                               +---------------------------------------------------------+
                                 SALIDA: %s%n
                               +----------------------------+----------------------------+
                                 TARIFA: %d                 | MONTO: %.2f
                               +----------------------------+----------------------------+
                               
                                                            +----------------------------+
                                                            |  IVA: 0.21 %c%n
                                                            +----------------------------+
                                                            |  TOTAL: %.2f
                                                            +----------------------------+                                                       
                               """, nombreHuesped, apellidoHuesped, numConfirm, habitaciones, noches,
                                            entradaFactura, salidaFactura, tarifaFactura, monto, porcentaje, total);

                        //máquina de cambio
                        do {
                            System.out.print("Introduzca el dinero para pagar la factura (solo se admite efectivo): ");
                            dineroIntro = Float.parseFloat(s.nextLine());
                            if (total > dineroIntro) System.out.println("Cantidad insuficiente");
                        } while (dineroIntro < total);

                        cambio = dineroIntro - total;

                        System.out.print("Calculando su cambio ");
                        for (int i = 0; i < 3; i++) {
                            try {
                                Thread.sleep(500);
                            } catch (InterruptedException e) {
                                throw new RuntimeException(e);
                            }
                            System.out.print(". ");
                        }
                        System.out.println();

                        System.out.println("Su cambio total: " + cambio);
                        System.out.println("Pulse una tecla para volver al menú principal.");
                        s.nextLine();

                        // Calculo los billetes de 500 euros
                        while (cambio >= 500) {
                            billete500e++;
                            billete500e -= 1;
                            cambio -= 500;
                        }
                        // Calculo los billetes de 200 euros
                        while (cambio >= 200) {
                            billete200e++;
                            billete200e -= billete200eDevolver;
                            cambio -= 200;
                        }
                        // Calculo los billetes de 100 euros
                        while (cambio >= 100) {
                            billete100e++;
                            billete100e-= billete100eDevolver;
                            cambio -= 100;
                        }
                        // Calculo los billetes de 50 euros
                        while (cambio >= 50) {
                            billete50e++;
                            billete50e -= billete50eDevolver;
                            cambio -= 50;
                        }
                        // Calculo los billetes de 20 euros
                        while (cambio >= 20) {
                            billete20e++;
                            billete20e -= billete20eDevolver;
                            cambio -= 20;
                        }
                        // Calculo los billetes de 10 euros
                        while (cambio >= 10) {
                            billete10e++;
                            billete10e -= billete10eDevolver;
                            cambio -= 10;
                        }
                        // Calculo los billetes de 5 euros
                        while (cambio >= 5) {
                            billete5e++;
                            billete5e -= billete5eDevolver;
                            cambio -= 5;
                        }
                        // Calculo las monedas de 2 euros
                        while (cambio >= 2) {
                            monedas2e++;
                            monedas2e -= monedas2eDevolver;
                            cambio -= 2;
                        }
                        // Calculo las monedas de 1 euros
                        while (cambio >= 1) {
                            monedas1e++;
                            monedas1e -= monedas1eDevolver;
                            cambio -= 1;
                        }
                        // Calculo las monedas de 50 centimos
                        while (cambio >= 0.50) {
                            monedas50cent++;
                            monedas50cent -= monedas50centDevolver;
                            cambio -= 0.50F;
                            cambio = (float) Math.round(cambio * 100) / 100;
                        }
                        // Calculo las monedas de 20 centimos
                        while (cambio >= 0.20) {
                            monedas20cent++;
                            monedas20cent -= monedas20centDevolver;
                            cambio -= 0.20F;
                            cambio = (float) Math.round(cambio * 100) / 100;
                        }
                        // Calculo las monedas de 10 centimos
                        while (cambio >= 0.10) {
                            monedas10cent++;
                            monedas10cent -= monedas10centDevolver;
                            cambio -= 0.10F;
                            cambio = (float) Math.round(cambio * 100) / 100;
                        }
                        // Calculo las monedas de 5 centimos
                        while (cambio >= 0.05) {
                            monedas5cent++;
                            monedas5cent -= monedas5centDevolver;
                            cambio -= 0.05F;
                            cambio = (float) Math.round(cambio * 100) / 100;
                        }
                        // Calculo las monedas de 2 centimos
                        while (cambio > 0.01) {
                            monedas2cent++;
                            monedas2cent -= monedas2centDevolver;
                            cambio -= 0.02F;
                            cambio = (float) Math.round(cambio * 100) / 100;
                        }
                        // Calculo las monedas de 1 centimos
                        while (cambio > 0) {
                            monedas1cent++;
                            monedas1cent = monedas1cent - monedas1centDevolver;
                            cambio -= 0.01F;
                            cambio = (float) Math.round(cambio * 100) / 100;

                                }
                            }
                            break;

                            case "d": //menú de administrador
                                System.out.print("Introduce el nombre de usuario: ");
                                userIntro = s.nextLine();

                                System.out.print("Introduce la contraseña: ");
                                passIntro = s.nextLine();

                                if (userIntro.equals(adminUser) && passIntro.equals(adminPass)) {
                                    System.out.println("""
                                            .-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=.
                                            |                    MENÚ DE ADMINISTRACIÓN                  |
                                            !                                                            !
                                            :   a. Consultar los ingresos totales y número de reservas.  :
                                            .   b. Consultar monedas restantes para el cambio.           .
                                            :   c. Apagar el software.                                   :
                                            |                                                            |
                                            `-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-='
                                            """);
                                    System.out.print("Selecione la opción deseada: ");
                                    opcionAdmin = s.nextLine();

                                    switch (opcionAdmin) {
                                        case "a": // ingresos totales y reservas
                                            ingresosTotales = contReserva + total;
                                            System.out.printf("""
                                                    +--------------------------------+
                                                     INGRESOS TOTALES: %.2f
                                                    +--------------------------------+
                                                                                            
                                                    +--------------------------------+
                                                     NÚMERO DE RESERVAS: %d
                                                    +--------------------------------+
                                                    """,ingresosTotales , contReserva);
                                            System.out.println("Pulse una tecla para volver al menú principal.");
                                            s.nextLine();

                                            //hacemos un loading
                                            System.out.print("\n Espere un momento ");
                                            for (int i = 0; i < 3; i++) {
                                                try {
                                                    Thread.sleep(500);
                                                } catch (InterruptedException e) {
                                                    throw new RuntimeException(e);
                                                }
                                                System.out.print(". ");
                                            }
                                            System.out.println();

                                            break;

                                        case "b": //consultar monedas
                                            System.out.printf("""
                                                            +------------------------------------------------------+
                                                            | MONEDAS Y BILLETES RESTANTES EN LA MÁQUINA DE CAMBIO |
                                                            +-----------------------+------------------------------+
                                                            | 500€: %d%n
                                                            | 200€: %d%n
                                                            | 100€: %d%n
                                                            | 50€: %d%n
                                                            | 10€: %d%n
                                                            | 5€: %d%n
                                                            | 2€: %d%n
                                                            | 1€: %d%n
                                                            | 0.50€: %d%n
                                                            | 0.20€: %d%n
                                                            | 0.10€: %d%n
                                                            | 0.05€: %d%n
                                                            | 0.02€: %d%n
                                                            | 0.01€: %d%n
                                                            """, billete500e, billete200e, billete100e, billete50e,
                                                    billete20e, billete10e, billete5e, monedas2e, monedas1e,
                                                    monedas50cent, monedas20cent, monedas10cent, monedas5cent,
                                                    monedas2cent, monedas1cent);

                                            System.out.println("Pulse una tecla para volver la menú principal.");
                                            s.nextLine();

                                            /*if (billete500e == 0) billete500e += 100;*/
                                            break;

                                        case "c": //apagar el software
                                                off = false;

                                                System.out.print("\n Apagando sistema ");
                                                for (int i = 0; i < 3; i++) {
                                                    try {
                                                        Thread.sleep(500);
                                                    } catch (InterruptedException e) {
                                                        throw new RuntimeException(e);
                                                    }
                                                    System.out.print(". ");
                                                }
                                                System.out.println();
                                            break;
                                    }
                                }
                                break;

                            default:
                                System.out.println("\n ✗ Opción introducida incorrecta.");
                                System.out.println("Pulse una tecla para volver la menú principal.");
                                s.nextLine();
                        } //fin del switch de las opciones principales

                    } while (off); //fin del do para la estructura principal
                }
            }