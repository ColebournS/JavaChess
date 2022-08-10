package Pieces;

import Board.Board;

public class Queen extends Piece{

    private static String name = " Q ";

    public Queen(int p, Boolean b) {
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
        //If diagonal
        outer:
        if(Math.abs(initialX-endX) == Math.abs( initialY-endY)){
            //make sure there are no pieces on diagonal between
                if(initialX > endX){
                    int y = initialY + 1;
                    for(int i = initialX + 1; i < endX; i++){
                        if(b.arr[i][y].player != -1) break outer;
                        y++;
                    }
                    return true;
                }
                else{
                    int y = initialY - 1;
                    for(int i = initialX -1; i > endX; i--){
                        if(b.arr[i][y].player != -1) {
                            System.out.print("trying: " + i + ", " + y);
                            break outer;
                        }
                        y--;
                    }
                    return true;
                }
        }
        return false;
    }   
}
