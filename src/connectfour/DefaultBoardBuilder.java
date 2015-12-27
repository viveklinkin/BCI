/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package connectfour;

import java.awt.Color;

/**
 *
 * @author VIVEK
 */
public class DefaultBoardBuilder extends BoardBuilder {

    public DefaultBoardBuilder() {
        super.p1 = Configs.PLAYER_ONE;
        p2 = Configs.PLAYER_TWO;
        empty = Configs.EMPTY;
        rows = Configs.NO_OF_ROWS;
        cols = Configs.NO_OF_COLS;
    }
}
