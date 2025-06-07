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

    public void hasWon(Board currState) {}

    public byte[] askMove(){
        byte[] move = new byte[2];   
        System.out.println("~~~Jugada~~~: "); 
        System.out.println("Fila: "); 
        move[0] = scanner.nextByte();  
        System.out.println("Columna: "); 
        move[1] = scanner.nextByte(); 

        while (!this.gameBoard.IsCellEmpty(move[0], move[1])) {
            System.out.println("ERROR\n ¡Celda ya ocupada!");
            System.out.println("~~~Jugada~~~: "); 
            System.out.println("Fila: "); 
            move[0] = scanner.nextByte();  
            System.out.println("Columna: "); 
            move[1] = scanner.nextByte();
        }
        return move; 
    }

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
        byte[] move; 
        setPlayerSymb(); 
        System.out.println("Inicia el jugador 1"); 
        /*
         * Main game loop
         */
        while (true) {
            System.out.println("Turno del jugador 1:");
            move = askMove(); 
            this.gameBoard.SetCell(move[0], move[1], this.playerOne.GetSymbol()); 
            

            System.out.println("Turno del jugador 2: ");
            move = askMove(); 
            this.gameBoard.SetCell(move[0], movd][1], this.playerTwo.GetSymbol());
            
        }
    }
    
}