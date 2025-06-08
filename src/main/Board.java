public class Board{
    //matriz 3x3
    private Cell[][] Cells = new Cell[3][3];
    
    //constructor del tablero, inicializa cada celda 
    public Board(){
        for(Byte Row =0; Row < 3; Row++){
            for(byte Column=0; Column < 3; Column++){
                Cells[Row][Column] = new Cell();
            }
        }
    }
    /*La función PrintBoard no recibe ningún párametro, ni devuelve algun valor
     * Imprime el tablero junto con el valor dentro de la matriz Cells('X'/'O')
     */
    public void PrintBoard() {
        System.out.println();
        for (byte Rows = 0; Rows < 3; Rows++) { 
            for (byte Columns = 0; Columns < 3; Columns++) { 
                System.out.print(" " + Cells[Rows][Columns].GetValue() +" ");
                if (Columns < 2){ 
                    System.out.print("|");
                }
            }
            System.out.println();
            System.out.println(((Rows<2)?"___|___|___":"   |   |   "));
        }
    }
    
    /* Requiere la fila y la columna en donde se ingresará el dato,(de 0 a 2) y el valor del string 
    metodo para asignar el valor de cada jugador(X /O) dentro de la matriz Cells
    No retorna nada*/
    public void SetCell(byte Row, byte Col, String Value){
        Value=Value.toUpperCase();
        if(!Value.equals("X")&&!Value.equals("O")){
            System.out.println("No se permite ese tipo de valor.");
            return;
        }
        Cells[Row][Col].SetValue(Value);
    }
    /*Recibe el indice de fila y columna que se desee verficar si está vacía
     * Retorna un valor booleano
    */
    public boolean IsCellEmpty(int Row, int Col){
        return Cells[Row][Col].GetValue().equals(" ");
    }

}// fin clase Board


class Cell{
    //valor de X / O
    private String Value = " ";

    //recupera value actual de la celda
    public String GetValue(){
        return Value;
    }
    //establece el nuevo value de la celda
    public void SetValue(String Aux){
        Value = Aux;
    }
}// fin clase Cell

