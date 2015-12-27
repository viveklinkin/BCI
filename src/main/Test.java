/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Window;
import javax.swing.JFrame;

/**
 *
 * @author VIVEK
 */
public class Test {

    public static void main(String args[]) {
        JFrame frame = new JFrame();
        frame.setSize(500, 500);
        Window w = new Window(null) {
            @Override
            public void paint(Graphics g) {
                final Font font = getFont().deriveFont(48f);
                g.setFont(font);
                g.setColor(Color.RED);
                g.fillRect(50, 50, 50, 50);
            }

            @Override
            public void update(Graphics g) {
                paint(g);
            }
        };
        w.setAlwaysOnTop(true);
        w.setBounds(w.getGraphicsConfiguration().getBounds());
        w.setOpacity((float) 0.6);
        w.setBackground(new Color(0, true));
        w.setVisible(true);
    }
}
