/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package connectfour;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JComponent;

/**
 *
 * @author VIVEK
 */
public abstract class Looper implements Runnable {

    private List<Object> iterableList;
    private long timeoutPeriod = DEFAULT_TIMEOUT_PERIOD;
    public static final long DEFAULT_TIMEOUT_PERIOD = 1000;
    private int select = 0;
    private boolean runningFlag = false;

    public abstract void startIterating();

    public abstract void deselect(Object obj);

    public abstract void select(Object obj);

    public abstract void onEventTrigger();

    @Override
    public void run() {
        runningFlag = true;
        while (runningFlag) {
            for (int i = 0; i < iterableList.size(); i++) {
                if (i == select) {
                    this.select(iterableList.get(i));
                } else {
                    this.deselect(iterableList.get(i));
                }
            }
        }
    }

    public void stopThread() {
        runningFlag = false;
    }

    public boolean isRunning() {
        return runningFlag;
    }

    public void moveToNext() {
        if (iterableList == null) {
            throw new RuntimeException("Looper.iterableList is unset");
        }

        select = (++select) % iterableList.size();
    }

    public void setIterableList(List<Object> iterableList) {
        this.iterableList = iterableList;
    }

    public List<Object> getIterableList() {
        return iterableList;
    }

    public void setTimeout(long timeoutPeriod) {
        this.timeoutPeriod = timeoutPeriod;
    }
}
