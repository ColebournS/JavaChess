package Tests;
import Board.Board;
import Pieces.Bishop;
import Pieces.King;
import Pieces.Knight;
import Pieces.Pawn;
import Pieces.Queen;
import Pieces.Rook;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class PieceTests {
   @Test
	
   public void movePawn() {
      Board b = new Board();
      Pawn p = new Pawn(1, true);
      assertEquals(p.isMoveValid(0, 0, 1, 1, b),false);
      assertEquals(p.isMoveValid(0, 0, 1, 0, b),true);
      assertEquals(p.isMoveValid(1, 0, 2, 0, b),true);
      assertEquals(p.isMoveValid(4, 4, 3, 4, b),false);
      assertEquals(p.isMoveValid(4, 4, 3, 3, b),false);
      assertEquals(p.isMoveValid(4, 4, 5, 5, b),false);
   }

   @Test
   public void moveRook() {
      Board b = new Board();
      Rook r = new Rook(1, true);
      assertEquals(r.isMoveValid(0, 0, 1, 1, b),false);
      assertEquals(r.isMoveValid(0, 0, 1, 0, b),true);
      assertEquals(r.isMoveValid(0, 0, 7, 0, b),true);
      assertEquals(r.isMoveValid(0, 0, 0, 7, b),true);
      assertEquals(r.isMoveValid(0, 0, 7, 7, b),false);
    }
    @Test
    public void moveBishop() {
       Board b = new Board();
       Bishop r = new Bishop(1, true);
       assertEquals(r.isMoveValid(0, 0, 1, 1, b),true);
       assertEquals(r.isMoveValid(0, 0, 1, 0, b),false);
       assertEquals(r.isMoveValid(0, 0, 7, 0, b),false);
       assertEquals(r.isMoveValid(0, 0, 0, 7, b),false);
       assertEquals(r.isMoveValid(0, 0, 7, 7, b),true);
 
    }
    @Test
    public void moveQueen() {
       Board b = new Board();
       Queen r = new Queen(1, true);
       assertEquals(r.isMoveValid(0, 0, 1, 1, b),true);
       assertEquals(r.isMoveValid(0, 0, 1, 0, b),true);
       assertEquals(r.isMoveValid(0, 0, 7, 0, b),true);
       assertEquals(r.isMoveValid(0, 0, 0, 7, b),true);
       assertEquals(r.isMoveValid(0, 0, 7, 7, b),true);
       assertEquals(r.isMoveValid(0, 0, 4, 2, b),false);
 
    }
    @Test
    public void moveKing() {
       Board b = new Board();
       King r = new King(1, true);
       assertEquals(r.isMoveValid(0, 0, 1, 1, b),true);
       assertEquals(r.isMoveValid(0, 0, 1, 0, b),true);
       assertEquals(r.isMoveValid(0, 0, 7, 0, b),false);
       assertEquals(r.isMoveValid(0, 0, 0, 7, b),false);
       assertEquals(r.isMoveValid(0, 0, 7, 7, b),false);
       assertEquals(r.isMoveValid(0, 0, 4, 2, b),false);
       assertEquals(r.isMoveValid(4, 1, 4, 2, b),true);
 
    }

    @Test
    public void moveKnight() {
      Board b = new Board();
      Knight r = new Knight(1, true);
      assertEquals(r.isMoveValid(0, 0, 2, 1, b),true);
      assertEquals(r.isMoveValid(0, 0, 1, 0, b),false);
      assertEquals(r.isMoveValid(0, 0, 7, 0, b),false);
      assertEquals(r.isMoveValid(0, 0, 0, 7, b),false);
      assertEquals(r.isMoveValid(0, 0, 7, 7, b),false);
      assertEquals(r.isMoveValid(0, 0, 4, 2, b),false);
      assertEquals(r.isMoveValid(4, 1, 4, 2, b),false);
      assertEquals(r.isMoveValid(4, 4, 3, 2, b),true);
      assertEquals(r.isMoveValid(4, 4, 2, 3, b),true);
      assertEquals(r.isMoveValid(4, 4, 6, 5, b),true);
      assertEquals(r.isMoveValid(4, 4, 6, 3, b),true);
   }
}
