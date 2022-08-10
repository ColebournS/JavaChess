package Pieces;

import Board.Board;

public class Pawn extends Piece{

    private static String name = " p ";

    public Pawn(int p, Boolean b) {
        super(b, p, name);
    }
    public boolean isMoveValid(int initialX, int initialY, int endX, int endY, Board b){
        //If the piece is moving linearly
        if(initialY == endY){
            //if the piece is should be moving down
            if(super.player == 1){
                if(initialX == endX -1 || ( initialX == 1 && initialX == endX -2) ) return true;
            }
            //else pawn should be moving up
            else{
                if(endX == initialX -1 || ( initialX == 6 && initialX == endX + 2) ) return true;
            }

        }
        //if the piece is not moving in a straight line
        //can only do this when capturing.
        else{
            //if the piece is should be moving down
            if(super.player == 1){
                if(initialX == endX -1 && 
                  (initialY == endY - 1 || initialY == endY +1) && 
                  (b.arr[endX][endY].player != super.player && b.arr[endX][endY].player != -1)) return true;
            }
            //else pawn should be moving up
            else{
                if(endX == initialX -1 && 
                (initialY == endY - 1 || initialY == endY +1) && 
                (b.arr[endX][endY].player != super.player && b.arr[endX][endY].player != -1)) return true;
            }
        }
        return false;
    }   
}
