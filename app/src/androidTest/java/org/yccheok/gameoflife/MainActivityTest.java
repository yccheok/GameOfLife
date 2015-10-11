package org.yccheok.gameoflife;

import android.support.test.InstrumentationRegistry;
import android.support.test.runner.AndroidJUnit4;
import android.support.v4.app.Fragment;
import android.test.ActivityInstrumentationTestCase2;
import android.test.suitebuilder.annotation.SmallTest;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

@RunWith(AndroidJUnit4.class)
@SmallTest
public class MainActivityTest
        extends ActivityInstrumentationTestCase2<MainActivity> {
    private MainActivity activity;

    public MainActivityTest() {
        super(MainActivity.class);
    }

    @Before
    public void setUp() throws Exception {
        super.setUp();
        injectInstrumentation(InstrumentationRegistry.getInstrumentation());
        activity = getActivity();
    }

    @After
    public void tearDown() throws Exception {
        super.tearDown();
    }

    @Test
    public void loadStringResource() throws Exception {
        String appName = activity.getResources().getString(R.string.app_name);
        assertThat(appName, is("GameOfLife"));
    }

    @Test
    public void simulationFragment() throws Exception {
        Fragment fragment = activity.getSupportFragmentManager().findFragmentById(R.id.fragment);
        SimulationFragment simulationFragment = (SimulationFragment)fragment.getFragmentManager().findFragmentByTag("SIMULATION_FRAGMENT");
        simulationFragment.start();
        assertThat(simulationFragment.isStart(), is(true));
        activity.finish();
        getInstrumentation().waitForIdleSync();
        assertThat(simulationFragment.isStart(), is(false));
    }
}