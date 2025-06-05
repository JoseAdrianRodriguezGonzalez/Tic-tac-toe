public class Board{
    //matriz 3x3
    private Cell[][] cells = new Cell[3][3];

    //constructor del tablero, inicializa cada celda 
    public Board(){
        for(int i =0; i < 3; i++){
            for(int j=0; j < 3; j++){
                cells[i][j] = new Cell();
            }
        }
    }
    
    public void printBoard() {
        System.out.println("\n");
        for (int i = 0; i < 3; i++) { //recorremos las filas
            for (int j = 0; j < 3; j++) { //ahora las columnas
                System.out.print(" " + cells[i][j].getValue() +" ");
                if (j < 2){ // imprime en cada columna,pero en la ultima col no
                    System.out.print("|");
                }
            }
            System.out.println();
            if(i<2){ // imprime en cada columna,pero en la ultima col no
                System.out.println("___|___|___");
            }
        }
    }
    //metodo para asignar el valor de cada jugador(X /O)
    public void SetCell(int row, int col, String value){
        cells[row][col].setValue(value);
    }
}// fin clase Board


class Cell{
    //valor de X / O
    private String value = " ";

    //recupera value actual de la celda
    public String getValue(){
        return value;
    }
    //establece el nuevo value de la celda
    public void setValue(String aux){
        value =aux;
    }
}// fin clase Cell

