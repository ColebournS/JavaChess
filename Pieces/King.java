package Pieces;

import Board.Board;

public class King extends Piece{

    private static String name = " K ";

    public King(int p, Boolean b) {
        super(b, p, name);
    }
    public boolean isMoveValid(int initialX, int initialY, int endX, int endY, Board b){
        if(Math.abs(initialX - endX) <= 1 && Math.abs(initialY - endY) <= 1) return true;
        //if king is moving to the right or left two
        else if(Math.abs(initialX - endX) == 2 && Math.abs(initialY - endY) == 0){
            //make sure that the king is in its original space
            if(initialX == 3 && (initialY == 0 || initialY == 7)) return true;
        }
        return false;
    }   
}
