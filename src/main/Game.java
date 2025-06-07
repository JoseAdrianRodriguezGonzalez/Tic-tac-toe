import java.util.Scanner; 
public class Game {
    public boolean turn; 
    private Menu gameMenu; 
    private Board gameBoard;
    private Scanner scanner; 
    private short playerAmount; 
    private HumanPLayer playerOne, playerTwo; 
    private IAPLayer sysPlayer; 
    /*
     * El constructor de la clase es el encargado crear los objetos que va a necesitar 
     * a lo largo del juego. 
     */
    public Game() {
        this.gameBoard = new Board(); 
        this.gameMenu = new Menu(); 
        this.scanner = new Scanner(System.in); 
        this.turn = true;
        this.playerAmount = 0;  
    }

    public void hasWon() {}

    public void setPlayerSymb(){  
        while (this.playerAmount != 1 || this.playerAmount != 2) { 
            System.out.println("ERROR"); 
            System.out.println("""
                               Los modos de juego disponibles son:
                                    1: para un jugador
                                    2: para dos jugadores
                               """);    
            scanner.nextShort(); 
        }
        /*
         * Hacer la asignación de los símbolos que usará cada jugador. 
        */
        if (playerAmount == 1) {
            System.out.println("""
                               Por favor seleccione su simbolo:
                                    X 
                                    O
                               """);
            this.playerOne = new HumanPlayer(scanner.nextLine());
            this.sysPLayer = new IAPlayer(HumanPlayer.GetSymbol() == "O" ? "X" : "O");  
        } else {
            System.out.println("""
                               Jugador 1: Por favor seleccione su simbolo:
                                    X 
                                    O
                               """);
            
            this.playerOne = new HumanPlayer(scanner.nextLine());
            this.sysPLayer = new IAPlayer(HumanPlayer.GetSymbol() == "O" ? "X" : "O");
        }        
    }

    public void play() {
        this.gameMenu.PrintTitle(); 

        setPlayerSymb(); 
        System.out.println("Inicia el jugador 1"); 
        /*
         * Main game loop
         */
        while (true) {
            /*
             * Lógica del juego.
             * El tablero no es accesible. La matriz es privada. 
             */
        }
    }
    
}