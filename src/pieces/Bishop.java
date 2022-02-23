package pieces;

import java.util.ArrayList;
import shared.Move;

/**
 * The Bishop
 * 
 * @author Chase Hult
 * @author Siwen Wang
 * @author Valeria Garcia
 * @author Fatimah Aldhamen
 */
public class Bishop extends Piece {
	
	/**
	 * Serial ID
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Constructor
	 * 
	 * @param white		Whether this piece is white or not
	 * @param r			The row of this piece
	 * @param c			The column of this piece
	 */
	public Bishop(boolean white, int r, int c) {super(white, r, c);}

	/**
	 * Get all the valid moves that this piece can make on the 
	 * given board
	 * 
	 * @param board	The board this piece is on
	 * @return		All the valid moves this piece can make
	 */
	@Override
	public ArrayList<Move> validMoves(Piece[][] board) {
		ArrayList<Move> moves = new ArrayList<>();

		boolean[] dirs = new boolean[] {true, true, true, true};
		for (int offset = 1; offset < 8; offset++) {
			if (dirs[0] && row - offset >= 0 && col - offset >= 0) {  // Down Left
				if (board[row - offset][col - offset] == null)
					moves.add(new Move(row, col, row-offset, col-offset));
				else if (!board[row - offset][col - offset].getColor().equals(color)) {
					moves.add(new Move(row, col, row-offset, col-offset));
					dirs[0] = false;
				} else {dirs[0] = false;}

			}
			if (dirs[1] && row + offset < 8 && col - offset >= 0) {  // Up Left
				if (board[row + offset][col - offset] == null)
					moves.add(new Move(row, col, row+offset, col-offset));
				else if (!board[row + offset][col - offset].getColor().equals(color)) {
					moves.add(new Move(row, col, row+offset, col-offset));
					dirs[1] = false;
				} else {dirs[1] = false;}

			}
			if (dirs[2] && row - offset >= 0 && col + offset < 8) {  // Down Right
			 	if (board[row - offset][col + offset] == null)
			 		moves.add(new Move(row, col, row-offset, col+offset));
			 	else if (!board[row - offset][col + offset].getColor().equals(color)) {
					moves.add(new Move(row, col, row-offset, col+offset));
					dirs[2] = false;
				} else {dirs[2] = false;}

			}
			if (dirs[3] && row + offset < 8 && col + offset < 8) {  // Up Right
				if (board[row + offset][col + offset] == null)
					moves.add(new Move(row, col, row+offset, col+offset));
				else if (!board[row + offset][col + offset].getColor().equals(color)) {
					moves.add(new Move(row, col, row+offset, col+offset));
					dirs[3] = false;
				} else {dirs[3] = false;}
			}
		}
		return moves;
	}

	/**
	 * Get the type of this piece
	 */
	@Override
	public String getPieceName() {
		return "bishop";
	}
}
