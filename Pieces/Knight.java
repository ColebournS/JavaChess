package Pieces;

import Board.Board;

public class Knight extends Piece{

    private static String name = " k ";

    public Knight(int p, Boolean b) {
        super(b, p, name);
    }
    public boolean isMoveValid(int initialX, int initialY, int endX, int endY, Board b){
        if(endY == initialY +2 || endY == initialY -2){
            if(endX == initialX - 1 || endX == initialX +1) return true;
        }
        else if(endX == initialX +2 || endX == initialX -2){
            if(endY == initialY - 1 || endY == initialY +1) return true;
        }
        return false;
    }  
    
}
