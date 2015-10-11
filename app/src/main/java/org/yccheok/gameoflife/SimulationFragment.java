package org.yccheok.gameoflife;

import android.os.Bundle;
import android.support.v4.app.Fragment;

/**
 * Created by yccheok on 11/10/2015.
 */
public class SimulationFragment extends Fragment {
    public static SimulationFragment newInstance() {
        return new SimulationFragment();
    }

    public SimulationFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Retain this instance so it isn't destroyed when MainActivity and
        // MainFragment change configuration.
        setRetainInstance(true);
    }

    public void start() {
        flag = true;

        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                while (flag) {
                    cells = engine.nextGen(cells);

                    Fragment fragment = SimulationFragment.this.getTargetFragment();
                    if (fragment instanceof CellsListener) {
                        ((CellsListener)fragment).update(cells);
                    }

                    try {
                        Thread.sleep(2000);
                    } catch (InterruptedException exp) {
                        break;
                    }
                }
            }
        });

        thread.start();
        this.thread = thread;
    }

    public void stop() {
        flag = false;
        Thread t = this.thread;
        if (t != null) {
            t.interrupt();
            this.thread = null;
        }
    }

    public boolean isStart() {
        return flag;
    }

    public Cells getCells() {
        return this.cells;
    }

    @Override
    public void onDestroy() {
        // Will be triggered during back button pressed.
        super.onDestroy();
        stop();
    }

    private volatile boolean flag = false;
    private Thread thread = null;
    private Engine engine = new BasicEngine();
    private Cells cells = new Cells(20, 20);
}
