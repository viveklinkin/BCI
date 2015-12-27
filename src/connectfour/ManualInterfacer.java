/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package connectfour;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import connection.*;

/**
 *
 * @author VIVEK
 */
public class ManualInterfacer extends JFrame implements WindowListener, ActionListener, OnBlinkEvent {

    private Selection s;
    private Board b;

    public ManualInterfacer(BoardBuilder builder) {
        JPanel container = new JPanel();
        container.setLayout(new BoxLayout(container, BoxLayout.Y_AXIS));
        s = new Selection(builder);
        b = new Board(builder);
        setSize(builder.getCols() * 100, (1 + builder.getRows()) * 100);
        addWindowListener(this);
        container.add(s);
        container.add(b);
        setResizable(false);
        setLocationRelativeTo(null);
        add(container);
        b.Repaint();
    }

    public static void main(String args[]) {
        /*try {
         for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
         if ("Nimbus".equals(info.getName())) {
         javax.swing.UIManager.setLookAndFeel(info.getClassName());
         break;
         }
         }
         } catch (ClassNotFoundException ex) {
         java.util.logging.Logger.getLogger(OpeningPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
         } catch (InstantiationException ex) {
         java.util.logging.Logger.getLogger(OpeningPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
         } catch (IllegalAccessException ex) {
         java.util.logging.Logger.getLogger(OpeningPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
         } catch (javax.swing.UnsupportedLookAndFeelException ex) {
         java.util.logging.Logger.getLogger(OpeningPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
         }*/

        new ManualInterfacer(new BoardBuilder()).setVisible(true);
    }

    public void windowClosing(WindowEvent e) {
        System.exit(0);
    }

    public void windowOpened(WindowEvent e) {
    }

    public void windowClosed(WindowEvent e) {
    }

    public void windowIconified(WindowEvent e) {
    }

    public void windowDeiconified(WindowEvent e) {
    }

    public void windowActivated(WindowEvent e) {
    }

    public void windowDeactivated(WindowEvent e) {
    }

    public void actionPerformed(ActionEvent e) {
    }

    @Override
    public void BlinkAction() {
    }
}
