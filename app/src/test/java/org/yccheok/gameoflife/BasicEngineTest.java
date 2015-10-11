package org.yccheok.gameoflife;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by yccheok on 11/10/2015.
 */
public class BasicEngineTest {

    Engine engine;

    @Before
    public void setUp() {
        engine = new BasicEngine();
    }

    @Test
    public void testNextGen() throws Exception {
        Cells cells = new Cells(5, 5);

        /*
         . . . . .
         . . X . .
         . . X . .
         . . X . .
         . . . . .
         */
        cells.getCell(1, 2).setAlive(true);
        cells.getCell(2, 2).setAlive(true);
        cells.getCell(3, 2).setAlive(true);

        cells = engine.nextGen(cells);

        assertEquals(false, cells.getCell(0, 0).isAlive());
        assertEquals(false, cells.getCell(0, 1).isAlive());
        assertEquals(false, cells.getCell(0, 2).isAlive());
        assertEquals(false, cells.getCell(0, 3).isAlive());
        assertEquals(false, cells.getCell(0, 4).isAlive());

        assertEquals(false, cells.getCell(1, 0).isAlive());
        assertEquals(false, cells.getCell(1, 1).isAlive());
        assertEquals(false, cells.getCell(1, 2).isAlive());
        assertEquals(false, cells.getCell(1, 3).isAlive());
        assertEquals(false, cells.getCell(1, 4).isAlive());

        assertEquals(false, cells.getCell(2, 0).isAlive());
        assertEquals(true, cells.getCell(2, 1).isAlive());
        assertEquals(true, cells.getCell(2, 2).isAlive());
        assertEquals(true, cells.getCell(2, 3).isAlive());
        assertEquals(false, cells.getCell(2, 0).isAlive());

        assertEquals(false, cells.getCell(3, 0).isAlive());
        assertEquals(false, cells.getCell(3, 1).isAlive());
        assertEquals(false, cells.getCell(3, 2).isAlive());
        assertEquals(false, cells.getCell(3, 3).isAlive());
        assertEquals(false, cells.getCell(3, 4).isAlive());

        assertEquals(false, cells.getCell(4, 0).isAlive());
        assertEquals(false, cells.getCell(4, 1).isAlive());
        assertEquals(false, cells.getCell(4, 2).isAlive());
        assertEquals(false, cells.getCell(4, 3).isAlive());
        assertEquals(false, cells.getCell(4, 4).isAlive());


        cells = new Cells(5, 5);

        /*
         . . . . .
         . X X . .
         . X X . .
         . . . . .
         . . . . .
         */
        cells.getCell(1, 1).setAlive(true);
        cells.getCell(1, 2).setAlive(true);
        cells.getCell(2, 1).setAlive(true);
        cells.getCell(2, 2).setAlive(true);

        cells = engine.nextGen(cells);

        assertEquals(false, cells.getCell(0, 0).isAlive());
        assertEquals(false, cells.getCell(0, 1).isAlive());
        assertEquals(false, cells.getCell(0, 2).isAlive());
        assertEquals(false, cells.getCell(0, 3).isAlive());
        assertEquals(false, cells.getCell(0, 4).isAlive());

        assertEquals(false, cells.getCell(1, 0).isAlive());
        assertEquals(true, cells.getCell(1, 1).isAlive());
        assertEquals(true, cells.getCell(1, 2).isAlive());
        assertEquals(false, cells.getCell(1, 3).isAlive());
        assertEquals(false, cells.getCell(1, 4).isAlive());

        assertEquals(false, cells.getCell(2, 0).isAlive());
        assertEquals(true, cells.getCell(2, 1).isAlive());
        assertEquals(true, cells.getCell(2, 2).isAlive());
        assertEquals(false, cells.getCell(2, 3).isAlive());
        assertEquals(false, cells.getCell(2, 4).isAlive());

        assertEquals(false, cells.getCell(3, 0).isAlive());
        assertEquals(false, cells.getCell(3, 1).isAlive());
        assertEquals(false, cells.getCell(3, 2).isAlive());
        assertEquals(false, cells.getCell(3, 3).isAlive());
        assertEquals(false, cells.getCell(3, 4).isAlive());

        assertEquals(false, cells.getCell(4, 0).isAlive());
        assertEquals(false, cells.getCell(4, 1).isAlive());
        assertEquals(false, cells.getCell(4, 2).isAlive());
        assertEquals(false, cells.getCell(4, 3).isAlive());
        assertEquals(false, cells.getCell(4, 4).isAlive());

        cells = new Cells(6, 6);
        /*
         . . . . . .
         . X X . . .
         . X X . . .
         . . . X X .
         . . . X X .
         . . . . . .
         */
        cells.getCell(1, 1).setAlive(true);
        cells.getCell(1, 2).setAlive(true);
        cells.getCell(2, 1).setAlive(true);
        cells.getCell(2, 2).setAlive(true);
        cells.getCell(3, 3).setAlive(true);
        cells.getCell(3, 4).setAlive(true);
        cells.getCell(4, 3).setAlive(true);
        cells.getCell(4, 4).setAlive(true);

        cells = engine.nextGen(cells);

        assertEquals(false, cells.getCell(0, 0).isAlive());
        assertEquals(false, cells.getCell(0, 1).isAlive());
        assertEquals(false, cells.getCell(0, 2).isAlive());
        assertEquals(false, cells.getCell(0, 3).isAlive());
        assertEquals(false, cells.getCell(0, 4).isAlive());
        assertEquals(false, cells.getCell(0, 5).isAlive());

        assertEquals(false, cells.getCell(1, 0).isAlive());
        assertEquals(true, cells.getCell(1, 1).isAlive());
        assertEquals(true, cells.getCell(1, 2).isAlive());
        assertEquals(false, cells.getCell(1, 3).isAlive());
        assertEquals(false, cells.getCell(1, 4).isAlive());
        assertEquals(false, cells.getCell(1, 5).isAlive());

        assertEquals(false, cells.getCell(2, 0).isAlive());
        assertEquals(true, cells.getCell(2, 1).isAlive());
        assertEquals(false, cells.getCell(2, 2).isAlive());
        assertEquals(false, cells.getCell(2, 3).isAlive());
        assertEquals(false, cells.getCell(2, 4).isAlive());
        assertEquals(false, cells.getCell(2, 5).isAlive());

        assertEquals(false, cells.getCell(3, 0).isAlive());
        assertEquals(false, cells.getCell(3, 1).isAlive());
        assertEquals(false, cells.getCell(3, 2).isAlive());
        assertEquals(false, cells.getCell(3, 3).isAlive());
        assertEquals(true, cells.getCell(3, 4).isAlive());
        assertEquals(false, cells.getCell(3, 5).isAlive());

        assertEquals(false, cells.getCell(4, 0).isAlive());
        assertEquals(false, cells.getCell(4, 1).isAlive());
        assertEquals(false, cells.getCell(4, 2).isAlive());
        assertEquals(true, cells.getCell(4, 3).isAlive());
        assertEquals(true, cells.getCell(4, 4).isAlive());
        assertEquals(false, cells.getCell(4, 5).isAlive());

        assertEquals(false, cells.getCell(5, 0).isAlive());
        assertEquals(false, cells.getCell(5, 1).isAlive());
        assertEquals(false, cells.getCell(5, 2).isAlive());
        assertEquals(false, cells.getCell(5, 3).isAlive());
        assertEquals(false, cells.getCell(5, 4).isAlive());
        assertEquals(false, cells.getCell(5, 5).isAlive());

        cells = new Cells(6, 6);
        /*
         . . . . . .
         . . . . . .
         . . X X X .
         . X X X . .
         . . . . . .
         . . . . . .
         */
        cells.getCell(2, 2).setAlive(true);
        cells.getCell(2, 3).setAlive(true);
        cells.getCell(2, 4).setAlive(true);
        cells.getCell(3, 1).setAlive(true);
        cells.getCell(3, 2).setAlive(true);
        cells.getCell(3, 3).setAlive(true);

        cells = engine.nextGen(cells);

        assertEquals(false, cells.getCell(0, 0).isAlive());
        assertEquals(false, cells.getCell(0, 1).isAlive());
        assertEquals(false, cells.getCell(0, 2).isAlive());
        assertEquals(false, cells.getCell(0, 3).isAlive());
        assertEquals(false, cells.getCell(0, 4).isAlive());
        assertEquals(false, cells.getCell(0, 5).isAlive());

        assertEquals(false, cells.getCell(1, 0).isAlive());
        assertEquals(false, cells.getCell(1, 1).isAlive());
        assertEquals(false, cells.getCell(1, 2).isAlive());
        assertEquals(true, cells.getCell(1, 3).isAlive());
        assertEquals(false, cells.getCell(1, 4).isAlive());
        assertEquals(false, cells.getCell(1, 5).isAlive());

        assertEquals(false, cells.getCell(2, 0).isAlive());
        assertEquals(true, cells.getCell(2, 1).isAlive());
        assertEquals(false, cells.getCell(2, 2).isAlive());
        assertEquals(false, cells.getCell(2, 3).isAlive());
        assertEquals(true, cells.getCell(2, 4).isAlive());
        assertEquals(false, cells.getCell(2, 5).isAlive());

        assertEquals(false, cells.getCell(3, 0).isAlive());
        assertEquals(true, cells.getCell(3, 1).isAlive());
        assertEquals(false, cells.getCell(3, 2).isAlive());
        assertEquals(false, cells.getCell(3, 3).isAlive());
        assertEquals(true, cells.getCell(3, 4).isAlive());
        assertEquals(false, cells.getCell(3, 5).isAlive());

        assertEquals(false, cells.getCell(4, 0).isAlive());
        assertEquals(false, cells.getCell(4, 1).isAlive());
        assertEquals(true, cells.getCell(4, 2).isAlive());
        assertEquals(false, cells.getCell(4, 3).isAlive());
        assertEquals(false, cells.getCell(4, 4).isAlive());
        assertEquals(false, cells.getCell(4, 5).isAlive());

        assertEquals(false, cells.getCell(5, 0).isAlive());
        assertEquals(false, cells.getCell(5, 1).isAlive());
        assertEquals(false, cells.getCell(5, 2).isAlive());
        assertEquals(false, cells.getCell(5, 3).isAlive());
        assertEquals(false, cells.getCell(5, 4).isAlive());
        assertEquals(false, cells.getCell(5, 5).isAlive());
    }

    @Test
    public void testNextGenWithEdge() throws Exception {
        Cells cells = new Cells(5, 5);

        /*
         . . X . .
         . . X . .
         . . . . .
         . . . . .
         . . X . .
         */
        cells.getCell(0, 2).setAlive(true);
        cells.getCell(1, 2).setAlive(true);
        cells.getCell(4, 2).setAlive(true);

        cells = engine.nextGen(cells);

        assertEquals(false, cells.getCell(0, 0).isAlive());
        assertEquals(true, cells.getCell(0, 1).isAlive());
        assertEquals(true, cells.getCell(0, 2).isAlive());
        assertEquals(true, cells.getCell(0, 3).isAlive());
        assertEquals(false, cells.getCell(0, 4).isAlive());

        assertEquals(false, cells.getCell(1, 0).isAlive());
        assertEquals(false, cells.getCell(1, 1).isAlive());
        assertEquals(false, cells.getCell(1, 2).isAlive());
        assertEquals(false, cells.getCell(1, 3).isAlive());
        assertEquals(false, cells.getCell(1, 4).isAlive());

        assertEquals(false, cells.getCell(2, 0).isAlive());
        assertEquals(false, cells.getCell(2, 1).isAlive());
        assertEquals(false, cells.getCell(2, 2).isAlive());
        assertEquals(false, cells.getCell(2, 3).isAlive());
        assertEquals(false, cells.getCell(2, 0).isAlive());

        assertEquals(false, cells.getCell(3, 0).isAlive());
        assertEquals(false, cells.getCell(3, 1).isAlive());
        assertEquals(false, cells.getCell(3, 2).isAlive());
        assertEquals(false, cells.getCell(3, 3).isAlive());
        assertEquals(false, cells.getCell(3, 4).isAlive());

        assertEquals(false, cells.getCell(4, 0).isAlive());
        assertEquals(false, cells.getCell(4, 1).isAlive());
        assertEquals(false, cells.getCell(4, 2).isAlive());
        assertEquals(false, cells.getCell(4, 3).isAlive());
        assertEquals(false, cells.getCell(4, 4).isAlive());


        cells = new Cells(5, 5);

        /*
         . . . . .
         X . . . X
         X . . . X
         . . . . .
         . . . . .
         */
        cells.getCell(1, 0).setAlive(true);
        cells.getCell(1, 4).setAlive(true);
        cells.getCell(2, 0).setAlive(true);
        cells.getCell(2, 4).setAlive(true);

        cells = engine.nextGen(cells);

        assertEquals(false, cells.getCell(0, 0).isAlive());
        assertEquals(false, cells.getCell(0, 1).isAlive());
        assertEquals(false, cells.getCell(0, 2).isAlive());
        assertEquals(false, cells.getCell(0, 3).isAlive());
        assertEquals(false, cells.getCell(0, 4).isAlive());

        assertEquals(true, cells.getCell(1, 0).isAlive());
        assertEquals(false, cells.getCell(1, 1).isAlive());
        assertEquals(false, cells.getCell(1, 2).isAlive());
        assertEquals(false, cells.getCell(1, 3).isAlive());
        assertEquals(true, cells.getCell(1, 4).isAlive());

        assertEquals(true, cells.getCell(2, 0).isAlive());
        assertEquals(false, cells.getCell(2, 1).isAlive());
        assertEquals(false, cells.getCell(2, 2).isAlive());
        assertEquals(false, cells.getCell(2, 3).isAlive());
        assertEquals(true, cells.getCell(2, 4).isAlive());

        assertEquals(false, cells.getCell(3, 0).isAlive());
        assertEquals(false, cells.getCell(3, 1).isAlive());
        assertEquals(false, cells.getCell(3, 2).isAlive());
        assertEquals(false, cells.getCell(3, 3).isAlive());
        assertEquals(false, cells.getCell(3, 4).isAlive());

        assertEquals(false, cells.getCell(4, 0).isAlive());
        assertEquals(false, cells.getCell(4, 1).isAlive());
        assertEquals(false, cells.getCell(4, 2).isAlive());
        assertEquals(false, cells.getCell(4, 3).isAlive());
        assertEquals(false, cells.getCell(4, 4).isAlive());

        cells = new Cells(6, 6);
        /*
         . . . . . .
         . X X . . .
         . X X . . .
         . . . X X .
         . . . X X .
         . . . . . .
         */
        cells.getCell(1, 1).setAlive(true);
        cells.getCell(1, 2).setAlive(true);
        cells.getCell(2, 1).setAlive(true);
        cells.getCell(2, 2).setAlive(true);
        cells.getCell(3, 3).setAlive(true);
        cells.getCell(3, 4).setAlive(true);
        cells.getCell(4, 3).setAlive(true);
        cells.getCell(4, 4).setAlive(true);

        cells = engine.nextGen(cells);

        assertEquals(false, cells.getCell(0, 0).isAlive());
        assertEquals(false, cells.getCell(0, 1).isAlive());
        assertEquals(false, cells.getCell(0, 2).isAlive());
        assertEquals(false, cells.getCell(0, 3).isAlive());
        assertEquals(false, cells.getCell(0, 4).isAlive());
        assertEquals(false, cells.getCell(0, 5).isAlive());

        assertEquals(false, cells.getCell(1, 0).isAlive());
        assertEquals(true, cells.getCell(1, 1).isAlive());
        assertEquals(true, cells.getCell(1, 2).isAlive());
        assertEquals(false, cells.getCell(1, 3).isAlive());
        assertEquals(false, cells.getCell(1, 4).isAlive());
        assertEquals(false, cells.getCell(1, 5).isAlive());

        assertEquals(false, cells.getCell(2, 0).isAlive());
        assertEquals(true, cells.getCell(2, 1).isAlive());
        assertEquals(false, cells.getCell(2, 2).isAlive());
        assertEquals(false, cells.getCell(2, 3).isAlive());
        assertEquals(false, cells.getCell(2, 4).isAlive());
        assertEquals(false, cells.getCell(2, 5).isAlive());

        assertEquals(false, cells.getCell(3, 0).isAlive());
        assertEquals(false, cells.getCell(3, 1).isAlive());
        assertEquals(false, cells.getCell(3, 2).isAlive());
        assertEquals(false, cells.getCell(3, 3).isAlive());
        assertEquals(true, cells.getCell(3, 4).isAlive());
        assertEquals(false, cells.getCell(3, 5).isAlive());

        assertEquals(false, cells.getCell(4, 0).isAlive());
        assertEquals(false, cells.getCell(4, 1).isAlive());
        assertEquals(false, cells.getCell(4, 2).isAlive());
        assertEquals(true, cells.getCell(4, 3).isAlive());
        assertEquals(true, cells.getCell(4, 4).isAlive());
        assertEquals(false, cells.getCell(4, 5).isAlive());

        assertEquals(false, cells.getCell(5, 0).isAlive());
        assertEquals(false, cells.getCell(5, 1).isAlive());
        assertEquals(false, cells.getCell(5, 2).isAlive());
        assertEquals(false, cells.getCell(5, 3).isAlive());
        assertEquals(false, cells.getCell(5, 4).isAlive());
        assertEquals(false, cells.getCell(5, 5).isAlive());

        cells = new Cells(6, 6);
        /*
         . . . . . .
         . . . . . .
         . . X X X .
         . X X X . .
         . . . . . .
         . . . . . .
         */
        cells.getCell(2, 2).setAlive(true);
        cells.getCell(2, 3).setAlive(true);
        cells.getCell(2, 4).setAlive(true);
        cells.getCell(3, 1).setAlive(true);
        cells.getCell(3, 2).setAlive(true);
        cells.getCell(3, 3).setAlive(true);

        cells = engine.nextGen(cells);

        assertEquals(false, cells.getCell(0, 0).isAlive());
        assertEquals(false, cells.getCell(0, 1).isAlive());
        assertEquals(false, cells.getCell(0, 2).isAlive());
        assertEquals(false, cells.getCell(0, 3).isAlive());
        assertEquals(false, cells.getCell(0, 4).isAlive());
        assertEquals(false, cells.getCell(0, 5).isAlive());

        assertEquals(false, cells.getCell(1, 0).isAlive());
        assertEquals(false, cells.getCell(1, 1).isAlive());
        assertEquals(false, cells.getCell(1, 2).isAlive());
        assertEquals(true, cells.getCell(1, 3).isAlive());
        assertEquals(false, cells.getCell(1, 4).isAlive());
        assertEquals(false, cells.getCell(1, 5).isAlive());

        assertEquals(false, cells.getCell(2, 0).isAlive());
        assertEquals(true, cells.getCell(2, 1).isAlive());
        assertEquals(false, cells.getCell(2, 2).isAlive());
        assertEquals(false, cells.getCell(2, 3).isAlive());
        assertEquals(true, cells.getCell(2, 4).isAlive());
        assertEquals(false, cells.getCell(2, 5).isAlive());

        assertEquals(false, cells.getCell(3, 0).isAlive());
        assertEquals(true, cells.getCell(3, 1).isAlive());
        assertEquals(false, cells.getCell(3, 2).isAlive());
        assertEquals(false, cells.getCell(3, 3).isAlive());
        assertEquals(true, cells.getCell(3, 4).isAlive());
        assertEquals(false, cells.getCell(3, 5).isAlive());

        assertEquals(false, cells.getCell(4, 0).isAlive());
        assertEquals(false, cells.getCell(4, 1).isAlive());
        assertEquals(true, cells.getCell(4, 2).isAlive());
        assertEquals(false, cells.getCell(4, 3).isAlive());
        assertEquals(false, cells.getCell(4, 4).isAlive());
        assertEquals(false, cells.getCell(4, 5).isAlive());

        assertEquals(false, cells.getCell(5, 0).isAlive());
        assertEquals(false, cells.getCell(5, 1).isAlive());
        assertEquals(false, cells.getCell(5, 2).isAlive());
        assertEquals(false, cells.getCell(5, 3).isAlive());
        assertEquals(false, cells.getCell(5, 4).isAlive());
        assertEquals(false, cells.getCell(5, 5).isAlive());
    }
}
