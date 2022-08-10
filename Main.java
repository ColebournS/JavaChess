import java.util.Scanner;
import Board.Board;

public class Main {

    public static void main(String[] args){
        playGame();
    }

    private static void playGame() {
        try (Scanner myObj = new Scanner(System.in)) {
            System.out.print("\033[H\033[2J");
            Board b = new Board();
            b.initializeBoard();
            b.printBoard();
            System.out.println("Welcome to new chess Game!\n Would you like to be Black[2] or White[1]?");
            int player = myObj.nextInt();
            while(true) {
                playerTurn(b, player);
                if(player == 1) playerTurn(b, 2);
                else playerTurn(b, 1);
            }

        }
    }


    private static void playerTurn(Board b, int p) {
        String movePiece = choosePiece(b,p);
        int initialY =  movePiece.charAt(0) - 'a';
        int initialX = Integer.parseInt(movePiece.substring(1));

        String moveWhere = movePiece(b,p,initialX,initialY);
        int endY = moveWhere.charAt(0) - 'a';
        int endX = Integer.parseInt(moveWhere.substring(1));

        if(b.arr[initialX][initialY].isMoveValid(initialX, initialY, endX, endY, b)) {
            b.movePiece(movePiece,moveWhere);
            newConsole(b);
        }
        else{
            System.out.println("That is not a valid move please Try Again");
            playerTurn(b, p);
        }
    } 

    private static String movePiece(Board b, int p, int initialX, int initialY) {
        Scanner myObj = new Scanner(System.in);
        System.out.println("Where would you like to move it to?");
        String moveWhere = myObj.nextLine();
        int endY = moveWhere.charAt(0) - 'a';
        int endX = Integer.parseInt(moveWhere.substring(1));
        if(b.arr[endX][endY].player == p && (b.arr[endX][endY].name != " r " && b.arr[initialX][initialY].name != " K ")) {
            System.out.println("You have a piece at that location!\n Choose a new place to move to");
            return movePiece(b, p,initialX, initialY);
        }
        else return moveWhere;
    }

    private static String choosePiece(Board b, int p) {
        Scanner myObj = new Scanner(System.in);
        System.out.println("Player " + p + "'s Turn:\nWhich Piece would you like to move?");
        String movePiece = myObj.nextLine();
        int initialY = movePiece.charAt(0) - 'a';
        int initialX = Integer.parseInt(movePiece.substring(1));
        if(b.arr[initialX][initialY].player != p){
            System.out.println("That is not your piece!\n Please Choose Again");
            return choosePiece(b,p);
        } 
        else return movePiece;
    }
    private static void newConsole(Board b){
        System.out.print("\033[H\033[2J");
        b.printBoard();
    }
}