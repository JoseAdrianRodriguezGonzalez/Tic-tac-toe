public abstract class Player {
    /**
    * Clase abstracta que representa a un jugador en el juego Tic Tac Toe.
    * Proporciona la estructura base para jugadores humanos e IA.
    */
    protected char symbol; // 'X' o 'O'

    /**
     * Constructor del jugador.
     * @param symbol El símbolo del jugador ('X' o 'O').
     */
    public Player(char symbol) {
        this.symbol = Character.toUpperCase(symbol);
    }

    /**
     * Obtiene el símbolo del jugador.
     * @return El símbolo del jugador.
     */
    public char getSymbol() {
        return symbol;
    }

    /**
     * Método abstracto que define la jugada del jugador.
     * Debe ser implementado por clases concretas (HumanPlayer, AIPlayer).
     *
     * @param board El tablero actual del juego.
     * @return Un arreglo de dos bytes [fila, columna] indicando la jugada.
     */
    public abstract byte[] makeMove(Board board);
}
