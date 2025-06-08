import java.util.Scanner; 
public class Game {
    private Menu gameMenu; 
    private Board gameBoard;
    private Scanner scanner; 
    private short playerAmount; 
    private HumanPlayer playerOne, playerTwo; 
    private AIPlayer sysPlayer; 

    private char[][] gameState = {{' ', ' ', ' '}, {' ', ' ', ' '}, {' ', ' ', ' '}}; 
    
    /*
     * El constructor de la clase es el encargado crear los objetos que va a necesitar 
     * a lo largo del juego. 
     */
    public Game() {
        this.gameBoard = new Board(); 
        this.gameMenu = new Menu(); 
        this.scanner = new Scanner(System.in); 
        this.playerAmount = 0;  
    }
    /*
     *  Verificar de esta forma redcuce la complejidad
     */
    public boolean isWinner(char[][] currState) {
        char one, two, three; 

        // Verificación de todas las filas y columnas.
        for (int i = 0; i < 3; i++) {
            one = currState[i][0];
            two = currState[i][1];
            three = currState[i][2]; 

            if (one != ' ' && one == two && two == three) return true; 

            one = currState[0][i];
            two = currState[1][i];
            three = currState[2][i];

            if (one != ' ' && one == two && two == three) return true;
        } 
        // Verificar la diagonal
        one = currState[0][0];
        two = currState[1][1];
        three = currState[2][2];
        if (one != ' ' && one == two && two == three) return true;

        // Verificar la otra diagonal 
        one = currState[0][2];
        two = currState[1][1];
        three = currState[2][0];
        if (one != ' ' && one == two && two == three) return true;


        return false;

    }

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

    public void onePlayerGame(){        
        while (true) {
            byte[] move = new byte[2]; 
            System.out.println("Turno del jugador 1:");
            move = askMove(); 
            this.gameBoard.SetCell(move[0], move[1],Character.toString( this.playerOne.GetSymbol())); 
            gameState[(int)move[0]][(int)move[1]] = playerOne.GetSymbol();  
            this.gameBoard.PrintBoard();
            if (isWinner(gameState)) {
                System.out.println("Victoria de " + playerOne.GetSymbol());
                break; 
            }

            System.out.println("Turno del jugador 2: ");
            move = askMove(); 
            this.gameBoard.SetCell(move[0], move[1],Character.toString(this.playerTwo.GetSymbol()));
            gameState[(int)move[0]][(int)move[1]] = playerTwo.GetSymbol();
            this.gameBoard.PrintBoard();
            if (isWinner(gameState)) {
                System.out.println("Victoria de " + playerOne.GetSymbol());
                break; 
            }
        }
    }

    public void twoPlayerGame() {
         while (true) {
            byte[] move = new byte[2]; 
            System.out.println("Turno del jugador 1:");
            move = askMove(); 
            this.gameBoard.SetCell(move[0], move[1],Character.toString(this.playerOne.GetSymbol())); 
            gameState[(int)move[0]][(int)move[1]] = playerOne.GetSymbol();  
            this.gameBoard.PrintBoard();
            if (isWinner(gameState)) {
                System.out.println("Victoria de " + playerOne.GetSymbol());
                break; 
            }

            System.out.println("Turno del jugador IA: ");
            move = sysPlayer.MakeMove(this.gameBoard);  
            this.gameBoard.SetCell(move[0], move[1], this.playerTwo.GetSymbol());
            gameState[(int)move[0]][(int)move[1]] = playerTwo.GetSymbol();
            this.gameBoard.PrintBoard();
            if (isWinner(gameState)) {
                System.out.println("Victoria de " + playerOne.GetSymbol());
                break; 
            }
        }
    }

    public void play() {
        int option;
        gameMenu.PrintTitle();
        option = gameMenu.RunMenu(); 
        if (option == 0) {
            onePlayerGame();
        } else if (option == 1) {
            twoPlayerGame(); 
        }

    }
    
}