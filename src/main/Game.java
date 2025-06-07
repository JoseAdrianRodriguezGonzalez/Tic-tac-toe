import java.util.Scanner; 
public class Game {
    public boolean turn; 
    private Menu gameMenu; 
    private Board gameBoard;
    private Scanner scanner; 
    private short playerAmount; 
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

    public void getWinner() {}

    public void play(){
        this.gameMenu.PrintTitle(); 

        System.out.println("\n"); 
         
        while (this.playerAmount != 1 || this.playerAmount != 2) { 
            System.out.println("ERROR"); 
            System.out.println("Los modos de juego disponibles son:\n 1: para un jugador\n 2: para dos jugadores\n\n");    
            scanner.nextShort(); 
        }

        
    }

    
}