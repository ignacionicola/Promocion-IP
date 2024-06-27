package Adivinanza.juego;


import java.util.Scanner;
import java.util.Random;

public class JuegoAdivinanza {
    
    private int numeroAdivinar;
    private int intentosRestantes;
    private Scanner scanner;

    public JuegoAdivinanza(int rango, int intentos) {
        Random random = new Random();
        this.numeroAdivinar = random.nextInt(rango) + 1;
        this.intentosRestantes = intentos;
        this.scanner = new Scanner(System.in);
    }

    public void iniciarJuego() {
        System.out.println("¡Bienvenido al juego de adivinanza!");
        System.out.println("He generado un número aleatorio entre 1 y 100.");
        System.out.println("Tienes " + intentosRestantes + " intentos para adivinarlo.");
        
        while (intentosRestantes > 0) {
            System.out.print("Introduce tu intento: ");
            int intento = scanner.nextInt();
            
            if (intento == numeroAdivinar) {
                System.out.println("¡Felicidades! ¡Has adivinado el número!");
                return;
            } else if (intento < numeroAdivinar) {
                System.out.println("Tu intento es demasiado bajo.");
            } else {
                System.out.println("Tu intento es demasiado alto.");
            }
            intentosRestantes--;
            System.out.println("Te quedan " + intentosRestantes + " intentos.");
        }
        
        System.out.println("Lo siento, no has adivinado el número. El número era " + numeroAdivinar);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int opcion;
        
        do {
            System.out.println("\nMenú de Opciones:");
            System.out.println("1. Iniciar Juego");
            System.out.println("2. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = scanner.nextInt();
            
            switch (opcion) {
                case 1:
                    JuegoAdivinanza juego = new JuegoAdivinanza(100, 10);
                    juego.iniciarJuego();
                    break;
                case 2:
                    System.out.println("Saliendo del juego. ¡Hasta la próxima!");
                    break;
                default:
                    System.out.println("Opción no válida. Intente nuevamente.");
                    break;
            }
        } while (opcion != 2);
        
        scanner.close();
    }
}
