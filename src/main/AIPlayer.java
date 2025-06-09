/**Clase que cra la IA con el algoritmo MiniMax */
class AIPlayer extends Player{
    HumanPlayer Opponent;
    /**
     * Inicializa el simbolo de la IA en base al caracter de un jugador
     * @param P1
     */
    AIPlayer(HumanPlayer P1){
        super((P1.GetSymbol()=='X')?'O':'X');
        this.Opponent=P1;
    }/**
        Se le pasa el simbolo que representará a la IA
        @param S
    */
    AIPlayer(char S){
        super(S);
       
    }
    /**
     * Requiere State y Player y retorna un booleano
     * Determina quien es el ganador en base al simbolo del jugador
     * @param State
     * @param Player
     * @return
     */
    private boolean IsWinner(char[][]State, char Player){
        for(int i=0;i<3; i++){
            if(State[i][0]==Player &&State[i][0]==State[i][1] && State[i][0]==State[i][2]) return true;
            if(State[0][i]==Player &&State[0][i]==State[1][i] && State[0][i]==State[2][i]) return true;
        }
        if(State[0][0]==Player &&State[0][0]==State[1][1] && State[0][0]==State[2][2]) return true;
        if(State[0][2]==Player &&State[0][2]==State[1][1] && State[0][2]==State[2][0]) return true;
        return false;
    }
    /**
     * Recibe un State del tipo char[][], y retorna un booleano
     * @param State
     * @return 
     * Determina si una partida quedo en empate
     */
    private boolean IsDraw(char[][] State){
        for (int i = 0; i < 3; i++) 
            for (int j = 0; j < 3; j++) 
                if(State[i][j]==' ')
                    return false;
        return true;
    }
    /**
     * Recibe los estados y a quiene está maximizando
     * Retonra un entero
     * @param board
     * @param IsMaximizingPlayer
     * @return
     * 
     * Genera un arbol de decisiones del tipo backtraciking, para determinar cual fue la jugada
     * maxima o mejor para un estado inicial
     */
    private int MiniMax(char[][] board,boolean IsMaximizingPlayer){
        char OpponentSymbol=this.Opponent.GetSymbol();
        if (IsWinner(board, OpponentSymbol))return -1;
        if (IsWinner(board, this.Symbol))return 1;
        if (IsDraw(board))return 0;
        int BestScore=IsMaximizingPlayer?Integer.MIN_VALUE:Integer.MAX_VALUE;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if(board[i][j]==' '){
                    board[i][j]=IsMaximizingPlayer?this.Symbol:OpponentSymbol;
                    int score=MiniMax(board, !IsMaximizingPlayer);
                    board[i][j]=' ';
                    BestScore=IsMaximizingPlayer?Math.max(score, BestScore):Math.min(score, BestScore);
                }
            }
        }
        return BestScore;
    }
    /**
     * Clase que sobreescrbe a la clase Abstracta Player
     * Realize el movimiento en base al valor retornado por MiniMax y el mejro score
     * que ha obtenido a lo largo de la partida simulada
     * @param Board
     *  @return
     */
    @Override
    public  byte[] MakeMove(Board Board){
        char[][] CurrentState=Board.GetBoardState();
        byte[]BestMove=null;
        int BestScore=Integer.MIN_VALUE;
        for (byte i = 0; i < 3; i++) {
            for (byte j = 0; j <3; j++) {
                if (CurrentState[i][j]==' ') {
                    CurrentState[i][j]=this.Symbol;
                    int Score=MiniMax(CurrentState,false);
                    CurrentState[i][j]=' ';
                    if(Score>BestScore){
                        BestScore=Score;
                        BestMove=new byte[]{i,j};
                    }
                }
            }
        }
        return BestMove;
    }
    /**Es solo la implementación vacía del inicializador
     * @return
     */
    protected char Initializer(){
        return ' ';
    }
}