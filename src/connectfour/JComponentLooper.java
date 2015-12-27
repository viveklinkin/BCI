/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package connectfour;

import java.awt.Color;
import java.awt.Window;
import java.util.List;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JComponent;

/**
 *
 * @author VIVEK
 */
public class JComponentLooper extends Looper {

    private Color hoverColor = new Color(100, 100, 100);
    private Color selectedColor = new Color(80, 80, 80);

    public JComponentLooper() {
    }

    public void addComponentToIterableList() {

        if (getIterableList() == null) {
        }
    }

    @Override
    public void deselect(Object obj) {
        if (obj instanceof JComponent) {
        }
    }

    @Override
    public void select(Object obj) {
        if (obj instanceof JComponent) {
            JComponent component = (JComponent) obj;

        } else if (obj instanceof Window) {
        }
    }

    @Override
    public void onEventTrigger() {
    }

    @Override
    public void startIterating() {
        Runnable jComponentLooper = new JComponentLooper();
        Thread LooperThread = new Thread(jComponentLooper);

    }
}
