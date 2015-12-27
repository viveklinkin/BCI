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
public class BoardBuilder {

    protected int p1, p2;
    protected int empty;
    protected int rows, cols;

    public BoardBuilder setP1(int p1) {
        this.p1 = p1;
        return this;
    }

    public int getP1() {
        return p1;
    }

    public BoardBuilder setP2(int p2) {
        this.p2 = p2;
        return this;
    }

    public int getP2() {
        return p1;
    }

    public int getRows() {
        return p1;
    }

    public int getCols() {
        return p1;
    }

    public BoardBuilder setEmpty(int empty) {
        this.empty = empty;
        return this;
    }

    public int getEmpty() {
        return p1;
    }
}
