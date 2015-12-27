/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package connectfour;

/**
 *
 * @author VIVEK
 */
public final class BoardMoves {

    public static int[][] drop(int[][] board, int pos, int turn) {
        for (int i = board.length - 1; i >= 0; i--) {
            if (board[i][pos] == 0) {
                board[i][pos] = turn;
                break;
            }
        }
        return board;
    }
}
