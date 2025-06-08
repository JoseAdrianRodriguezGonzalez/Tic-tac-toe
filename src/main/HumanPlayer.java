import java.util.Scanner;

/**
 * Clase que representa a un jugador humano en el juego Tic Tac Toe.
 * Hereda de la clase abstracta Player y permite ingresar jugadas por consola.
 */
public class HumanPlayer extends Player {

    private Scanner scanner;

    /**
     * Constructor: del jugador humano.
     * Parametro (symbol) El símbolo que representará al jugador ('X' o 'O').
     */
    public HumanPlayer(char symbol) {
        super(symbol);
        this.scanner = new Scanner(System.in);
    }

    /**
     * Permite al jugador humano ingresar una jugada mediante consola.
     * Se asegura de que la celda esté vacía antes de aceptar la jugada.
     *
     * Parametro: (board) El estado actual del tablero.
     * return: Un arreglo de dos bytes que representa la jugada [fila, columna].
     */
    @Override
    public byte[] makeMove(Board board) {
        byte[] move = new byte[2];
        boolean valid = false;

        while (!valid) {
            try {
                System.out.println(" --- Turno del jugador (" + symbol + ") ---");
                System.out.print("Fila (0-2): ");
                move[0] = scanner.nextByte();
                System.out.print("Columna (0-2): ");
                move[1] = scanner.nextByte();

                if (move[0] < 0 || move[0] > 2 || move[1] < 0 || move[1] > 2) {
                    System.out.println("  Índices fuera de rango. Intenta de nuevo.");
                } else if (!board.IsCellEmpty(move[0], move[1])) {
                    System.out.println("  La celda ya está ocupada. Elige otra.");
                } else {
                    valid = true;
                }

            } catch (Exception e) {
                System.out.println("  Entrada inválida. Usa números enteros.");
                scanner.nextLine(); // Limpiar buffer
            }
        }

        return move;
    }
}//Fin de la clase HumanPlayer
