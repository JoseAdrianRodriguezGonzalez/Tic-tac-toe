public abstract class Player {
    /**
    * Clase abstracta que representa a un jugador en el juego Tic Tac Toe.
    * Proporciona la estructura base para jugadores humanos e IA.
    */
    protected char Symbol; // 'X' o 'O'
    /**
     * Constructor del jugador.
     * no recibe parametros
     */
    public Player() {
        this.Symbol=this.Initializer();
    

    }
    /**
     * Constructor del jugador
     * @param Symbol
     */
    public Player(char Symbol){
        this.Symbol = Character.toUpperCase(Symbol);
    }
    
    /**
     * Obtiene el símbolo del jugador.
     * @return El símbolo del jugador.
     */
    public char GetSymbol() {
        return Symbol;
    }

    /**
     * Método abstracto que define la jugada del jugador.
     * Debe ser implementado por clases concretas (HumanPlayer, AIPlayer).
     *
     * @param board El tablero actual del juego.
     * @return Un arreglo de dos bytes [fila, columna] indicando la jugada.
     */

    public abstract byte[] MakeMove(Board Board);
    /**
     * Método abstracto que define los párametros iniciales del objeto
     * @return un elemento del tipo caracter
     */
    protected abstract char Initializer();
}
