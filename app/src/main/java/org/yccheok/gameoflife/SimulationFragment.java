package org.yccheok.gameoflife;

import android.os.Bundle;
import android.support.v4.app.Fragment;

import java.util.Random;

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
                        Thread.sleep(1500);
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
    public void onPause() {
        // Will be triggered during rotation, home button and back button pressed.
        super.onDestroy();
        stop();
    }


    public void clear() {
        cells = new Cells(20, 20);
        Fragment fragment = SimulationFragment.this.getTargetFragment();
        if (fragment instanceof CellsListener) {
            ((CellsListener) fragment).update(cells);
        }
    }

    public void random() {
        Random r = new Random();

        cells = new Cells(20, 20);
        for (int i = 0; i < 60; i++) {
            int row = r.nextInt(20 - 0) + 0;
            int col = r.nextInt(20 - 0) + 0;
            cells.getCell(row, col).setAlive(true);
        }
        Fragment fragment = SimulationFragment.this.getTargetFragment();
        if (fragment instanceof CellsListener) {
            ((CellsListener) fragment).update(cells);
        }
    }

    private volatile boolean flag = false;
    private Thread thread = null;
    private Engine engine = new BasicEngine();
    private Cells cells = new Cells(20, 20);
}
