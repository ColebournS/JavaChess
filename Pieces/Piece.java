package Pieces;

import Board.Board;

public class Piece {
    public Boolean isBlack;
    public int player;
    public String name;

    public Piece(Boolean b, int p, String s){
        isBlack = b;
        player = p;
        name = s;
    }

    public void newColor(Boolean color) {
        isBlack = color;
    }

    public boolean isMoveValid(int initialX, int initialY, int endX, int endY, Board b){
        return false;
    }

}
