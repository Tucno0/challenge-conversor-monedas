import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ConsultaTipoCambio consulta = new ConsultaTipoCambio();

        int opcion = 0;
        double valor;

        while (opcion != 9) {
            mostrarMenu();

            try {
                opcion = Integer.valueOf(scanner.nextLine());

                if (opcion == 9) {
                    System.out.println("Saliendo del programa...");
                    break;
                }

                if (opcion < 1 || opcion > 8) {
                    System.out.println("Debe elegir una opción entre 1 y 9.");
                    continue;
                }

                System.out.println("Por favor, ingrese el valor a convertir: ");
                String input = scanner.nextLine();
                valor = Double.parseDouble(input);

                switch (opcion) {
                    case 1 -> mostrarResultadoConversion(consulta, "USD", "PEN", valor);
                    case 2 -> mostrarResultadoConversion(consulta, "PEN", "USD", valor);
                    case 3 -> mostrarResultadoConversion(consulta, "USD", "ARS", valor);
                    case 4 -> mostrarResultadoConversion(consulta, "ARS", "USD", valor);
                    case 5 -> mostrarResultadoConversion(consulta, "USD", "BRL", valor);
                    case 6 -> mostrarResultadoConversion(consulta, "BRL", "USD", valor);
                    case 7 -> mostrarResultadoConversion(consulta, "USD", "COP", valor);
                    case 8 -> mostrarResultadoConversion(consulta, "COP", "USD", valor);

                    default -> System.out.println("Opción no válida. Por favor, elija una opción entre 1 y 9.");
                }

            } catch (NumberFormatException e) {
                System.out.println("Debe ingresar un número válido!!!\n");
                continue;
            }

        }
    }

    public static void mostrarMenu() {
        System.out.print(""" 
            ****************************************************************
            Sea bienvenido/a al Conversor de Moneda =] 
            
            1) Dolar            =>>     Sol peruano
            2) Sol peruano      =>>     Dólar
            3) Dólar            =>>     Peso argentino 
            4) Peso argentino   =>>     Dólar 
            5) Dólar            =>>     Real brasileño 
            6) Real brasileño   =>>     Dólar 
            7) Dólar            =>>     Peso colombiano 
            8) Peso colombiano  =>>     Dólar
            
            9) Salir 
            ****************************************************************
            
            Elija una opción válida: 
            """);

    }

    public static void mostrarResultadoConversion(ConsultaTipoCambio consulta, String codigoBase, String codigoObjetivo, double valor) {
        try {
            ExchangeRateResponse response = consulta.obtenerTasasDeConversion(codigoBase);

            double tipoCambio = response.conversion_rates().get(codigoObjetivo);
            double valorResultado = valor * tipoCambio;

            System.out.println("\nEl valor " + valor + " [" + codigoBase + "] corresponde al valor final de ==> " + valorResultado + " [" + codigoObjetivo + "]\n");

        } catch (RuntimeException e) {
            System.out.println("Error al consultar el tipo de cambio: " + e.getMessage());
        }
    }
}
