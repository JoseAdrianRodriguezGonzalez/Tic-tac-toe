import java.util.Scanner;

/**
 * Clase que representa a un jugador humano en el juego Tic Tac Toe.
 * Hereda de la clase abstracta Player y permite ingresar jugadas por consola.
 */
public class HumanPlayer extends Player {

    private Scanner Scanner;
    
    /**
     * Constructor: del jugador humano.
     * Parametro (symbol) El símbolo que representará al jugador ('X' o 'O').
     */
    @Override 
    protected char Initializer(){
        char CharObtained;
        do{
            this.Scanner = new Scanner(System.in);
            System.out.println("Que turno deseas tener? (X/O)");
            CharObtained=Scanner.next().charAt(0);
            CharObtained=Character.toUpperCase(CharObtained);
        }while(CharObtained!='X' && CharObtained!='O');
        return CharObtained;
    }
    /*Constructor que llamar al constructor de Player */
    public HumanPlayer(){
        super();
    }
    /**
     * Recibe el parametro Symbol, e inicializa el Scanner, a su vez de inicializar el valor de Symbol
     * @param Symbol
     */
    public HumanPlayer(char Symbol){
        super(Symbol);
        this.Scanner=new Scanner(System.in);
    }
    /**
     * Permite al jugador humano ingresar una jugada mediante consola.
     * Se asegura de que la celda esté vacía antes de aceptar la jugada.
     *
     * Parametro: (board) El estado actual del tablero.
     * return: Un arreglo de dos bytes que representa la jugada [fila, columna].
     */
    @Override
    public byte[] MakeMove(Board board) {
        byte[] Move = new byte[2];
        boolean Valid = false;

        while (!Valid) {
            try {
                //Quiero que el menu sea más fácil de entender, prefiero que tenga un mapa de caracteres
                System.out.println(" --- Turno del jugador (" + Symbol + ") ---");
                System.out.print("Fila (0-2): ");
                Move[0] = Scanner.nextByte();
                System.out.print("Columna (0-2): ");
                Move[1] = Scanner.nextByte();

                if (Move[0] < 0 || Move[0] > 2 || Move[1] < 0 || Move[1] > 2) {
                    System.out.println("  Índices fuera de rango. Intenta de nuevo.");
                } else if (!board.IsCellEmpty(Move[0], Move[1])) {
                    System.out.println("  La celda ya está ocupada. Elige otra.");
                } else {
                    Valid = true;
                }

            } catch (Exception e) {
                System.out.println("  Entrada inválida. Usa números enteros.");
                Scanner.nextLine(); // Limpiar buffer
            }
        }

        return Move;
    }
}//Fin de la clase HumanPlayer
