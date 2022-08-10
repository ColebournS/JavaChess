package Pieces;

import Board.Board;

public class Bishop extends Piece{

    private static String name = " b ";
 
    public Bishop(int p, Boolean b) {
        super(b, p, name);
    }
    public boolean isMoveValid(int initialX, int initialY, int endX, int endY, Board b){
        System.out.print("Trying to move bishop...\n");
        System.out.print(Math.abs(initialX-endX));
        System.out.print(Math.abs( initialY-endY));
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
