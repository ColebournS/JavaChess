package Board;

import Pieces.Bishop;
import Pieces.EmptySpace;
import Pieces.King;
import Pieces.Knight;
import Pieces.Pawn;
import Pieces.Piece;
import Pieces.Queen;
import Pieces.Rook;

public class Board {
    public Piece[][] arr = new Piece[8][8];

    public Board(){
        for(int i = 0; i< 8; i++){
            for(int j = 0;j < 8; j++){
                arr[i][j] = new EmptySpace(getColor(i, j));
            }
        }

    }

    public void initializeBoard() {
        for(int i = 0; i < 8; i++){
            arr[1][i] = new Pawn(1, getColor(1, i));
            arr[6][i] = new Pawn(2, getColor(6, i));
            arr[2][i] = new EmptySpace(getColor(2, i));
            arr[3][i] = new EmptySpace(getColor(3, i));
            arr[4][i] = new EmptySpace(getColor(4, i));
            arr[5][i] = new EmptySpace(getColor(5, i));
        }

        arr[0][0]= new Rook(1, getColor(0, 0));
        arr[0][7]= new Rook(1, getColor(0, 7));
        arr[0][1]= new Knight(1, getColor(0, 1));
        arr[0][6]= new Knight(1, getColor(0, 6));
        arr[0][2]= new Bishop(1, getColor(0, 2));
        arr[0][5]= new Bishop(1, getColor(0, 5));
        arr[0][4]= new Queen(1, getColor(0, 4));
        arr[0][3]= new King(1, getColor(0, 3));  

        arr[7][0]= new Rook(2, getColor(7, 0));
        arr[7][7]= new Rook(2, getColor(7, 7));
        arr[7][1]= new Knight(2, getColor(7, 1));
        arr[7][6]= new Knight(2, getColor(7, 6));
        arr[7][2]= new Bishop(2, getColor(7, 2));
        arr[7][5]= new Bishop(2, getColor(7, 5));
        arr[7][4]= new Queen(2, getColor(7, 4));
        arr[7][3]= new King(2, getColor(7, 3));  

    }
    public void printBoard(){
        final String ANSI_RESET = "\u001B[0m";
        final String ANSI_WHITE_BACKGROUND  = "\u001B[47m";
        String printString;
        System.out.println("     0     1     2     3     4     5     6     7");
        for(int i= 0; i <8; i++){
            System.out.print(i + " ");
            for(int j= 0; j <8; j++){
                if(arr[i][j].player != -1) printString = " "+ arr[i][j].name+arr[i][j].player + " ";
                else printString = " "+ arr[i][j].name + "   ";
                if(arr[i][j].isBlack) System.out.print(printString);
                 else System.out.print(ANSI_WHITE_BACKGROUND+ printString + ANSI_RESET);
            }
            System.out.print("\n");
        }
    }
    private Boolean getColor(int x, int y){
        if(x % 2 == 0){
            if(y % 2 == 0) return false;
            else return true;
        }
        else{
            if(y % 2 == 0) return true ;
            else return false ;
        }
    }

    public void movePiece(String movePiece, String moveWhere) {
        int initialX = Integer.parseInt(movePiece.substring(1,2));
        int initialY = Integer.parseInt(movePiece.substring(3,4));
        int endX = Integer.parseInt(moveWhere.substring(1,2));
        int endY = Integer.parseInt(moveWhere.substring(3,4));
        
        arr[endX][endY] = arr[initialX][initialY];
        arr[endX][endY].newColor(getColor(endX, endY));
        arr[initialX][initialY] = new EmptySpace(getColor(initialX, initialY));
    
    }

}
