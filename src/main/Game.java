import java.util.Scanner; 
public class Game {
    private Board GameBoard;
    private Scanner Scanner; 
    private short PlayerAmount; 
    //private AIPlayer SysPlayer; 

    private char[][] GameState = {{' ', ' ', ' '}, {' ', ' ', ' '}, {' ', ' ', ' '}}; 
    
    /*
     * El constructor de la clase es el encargado crear los objetos que va a necesitar 
     * a lo largo del juego. 
     */
    public Game() {
        this.GameBoard = new Board(); 
        this.Scanner = new Scanner(System.in); 
        this.PlayerAmount = 0;  
    }
    /*
     * Función que recibe un char[][] y devuelve un booleano
     * Detecta si el juego termino en empate
    */
    public boolean IsDraw(char[][] CurrState){
        byte TotalLength=0;
        for (int rows = 0; rows < CurrState.length; rows++)
            for (int columns = 0; columns < CurrState[0].length; columns++) 
                if(CurrState[rows][columns]!=' ')
                    TotalLength++;
        if(TotalLength==9 && !IsWinner(CurrState))
            return true;
        return false;
        
    }
        /*
     * Función que recibe un char[][] y devuelve un booleano
     * Detecta si alguien gano
    */
    public boolean IsWinner(char[][] CurrState) {
        char One, Two, Three; 

        // Verificación de todas las filas y columnas.
        for (int i = 0; i < 3; i++) {
            One = CurrState[i][0];
            Two = CurrState[i][1];
            Three = CurrState[i][2]; 

            if (One != ' ' && One == Two && Two == Three) return true; 

            One = CurrState[0][i];
            Two = CurrState[1][i];
            Three = CurrState[2][i];

            if (One != ' ' && One == Two && Two == Three) return true;
        } 
        // Verificar la diagonal
        One = CurrState[0][0];
        Two = CurrState[1][1];
        Three = CurrState[2][2];
        if (One != ' ' && One == Two && Two == Three) return true;

        // Verificar la otra diagonal 
        One = CurrState[0][2];
        Two = CurrState[1][1];
        Three = CurrState[2][0];
        if (One != ' ' && One == Two && Two == Three) return true;


        return false;

    }
    /*
     * Función que le pasa la referencia Player y devuelve un booelano
     * Realiza las acciones por turno de un jugador
     */
    private boolean TurnPlayer(Player Player){
        byte[] Move = new byte[2];
        Move=Player.MakeMove(GameBoard);
        MakeMovement(Player, Move);
        if (IsWinner(GameState)) {
            System.out.println("Victoria de " + Player.GetSymbol());
            CleanStates();
            return true;
        }
        if (IsDraw(GameState)) {
            System.out.println("El juego termino en empate ");
            CleanStates();
            return true;
        }
        return false;
    }
    /*
     * Fnción que no devuelve ni recibe ningún parametro
     * Limpia el atributo GameState
    */
    private void CleanStates(){
        for (int i = 0; i < GameState.length; i++) {
            for (int j = 0; j < GameState[0].length; j++) {
                GameState[i][j]=' ';
            }
        }
    }
    /*
     * Función que recibe la referencia de Player y el arreglo Move, que contiene la posición de la jugada. 
     * No devuelve nada, realiza el movimiento,lo guarda en el tablero y en el estado y se imprime el tablero principal
     * Como el tablero de ayuda
     */
    private void MakeMovement(Player Player, byte[] Move){
        this.GameBoard.SetCell(Move[0], Move[1], Character.toString(Player.GetSymbol()));
        GameState[(int)Move[0] ][(int)Move[1] ]=Player.GetSymbol();
        this.GameBoard.HelpPrintBoard();
        this.GameBoard.PrintBoard();
    }
/*Función que no devuelve ni recibe parametros.
 * Es el juego para dos jugadores
  */
    public void TwoPlayerGame(){        
        HumanPlayer Player1,Player2;
        Player1=new HumanPlayer();
        Player2 = new HumanPlayer((Player1.GetSymbol()=='X')?'O':'X') ;
        while (true) {
           if(TurnPlayer(Player1)) break;
           if(TurnPlayer(Player2)) break;
        }
        GameBoard.ClearBoard();
    }
    /* 
    public void TwoPlayerGame() {
         while (true) {
            byte[] Move = new byte[2]; 
            System.out.println("Turno del jugador 1:");
            Move = AskMove(); 
            this.GameBoard.SetCell(Move[0], Move[1],Character.toString(this.PlayerOne.GetSymbol())); 
            GameState[(int)Move[0]][(int)Move[1]] = PlayerOne.GetSymbol();  
            this.GameBoard.PrintBoard();
            if (IsWinner(GameState)) {
                System.out.println("Victoria de " + PlayerOne.GetSymbol());
                break; 
            }

            System.out.println("Turno del jugador IA: ");
            Move = SysPlayer.MakeMove(this.GameBoard);  
            this.GameBoard.SetCell(Move[0], Move[1], this.PlayerTwo.GetSymbol());
            GameState[(int)Move[0]][(int)Move[1]] = PlayerTwo.GetSymbol();
            this.GameBoard.PrintBoard();
            if (IsWinner(GameState)) {
                System.out.println("Victoria de " + PlayerOne.GetSymbol());
                break; 
            }
        }
    }

    */
   
    
}