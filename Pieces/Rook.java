package Pieces;

import Board.Board;

public class Rook extends Piece{
    
    private static String name = " r ";

    public Rook(int p, Boolean b) {
        super(b, p, name);
    }
    public boolean isMoveValid(int initialX, int initialY, int endX, int endY, Board b){
        //if moving side to side
        outer:
        if(initialX == endX){
            //make sure there are no pieces between
            for(int i = initialY + 1; i < endY; i++){
                if(b.arr[initialX][i].player != -1) break outer;
            }
            
            return true;
        }
        //if moving up down 
        outer:
        if(initialY == endY){
            //make sure there are no pieces between
            for(int i = initialX + 1; i < endX; i++){
                if(b.arr[i][initialY].player != -1) break outer;
            }
            return true;
        }
        return false;
    }   
}
