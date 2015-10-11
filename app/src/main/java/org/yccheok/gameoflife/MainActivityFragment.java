package org.yccheok.gameoflife;

import android.app.Activity;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.GridView;

/**
 * A placeholder fragment containing a simple view.
 */
public class MainActivityFragment extends Fragment implements CellsListener {

    public MainActivityFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        cells.getCell(4, 5).setAlive(true);
        cells.getCell(4, 6).setAlive(true);
        cells.getCell(5, 6).setAlive(true);
        cells.getCell(5, 7).setAlive(true);
        cells.getCell(5, 8).setAlive(true);
        cells.getCell(6, 7).setAlive(true);

        final FragmentManager fm = getFragmentManager();

        // Check to see if we have retained the worker fragment.
        simulationFragment = (SimulationFragment)fm.findFragmentByTag(SIMULATION_FRAGMENT);

        // If not retained (or first time running), we need to create it.
        if (simulationFragment == null) {
            simulationFragment = SimulationFragment.newInstance();
            // Tell it who it is working with.
            simulationFragment.setTargetFragment(this, 0);
            fm.beginTransaction().add(simulationFragment, SIMULATION_FRAGMENT).commitAllowingStateLoss();
        } else {
            simulationFragment.setTargetFragment(this, 0);
        }

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.fragment_main, container, false);
        this.gridView = (GridView)view.findViewById(R.id.grid_view);

        this.cellAdapter = new CellAdapter(this.getActivity(), cells.getList());
        this.cellAdapter.setNotifyOnChange(false);
        gridView.setAdapter(cellAdapter);

        final Button button = (Button)view.findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (button.getText().equals("START")) {
                    button.setText("STOP");
                    simulationFragment.start(cells);
                } else {
                    button.setText("START");
                    simulationFragment.stop();
                }
            }
        });

        return view;
    }

    @Override
    public void update(final Cells cells) {
        Activity activity = getActivity();
        if (activity != null) {
            activity.runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    cellAdapter.clear();
                    cellAdapter.addAll(cells.getList());
                    cellAdapter.notifyDataSetChanged();
                }
            });
        }
    }

    private Cells cells = new Cells(20, 20);
    private GridView gridView;
    private CellAdapter cellAdapter;
    private static final String SIMULATION_FRAGMENT = "SIMULATION_FRAGMENT";
    private SimulationFragment simulationFragment;
}
