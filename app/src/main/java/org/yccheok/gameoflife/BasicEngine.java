package org.yccheok.gameoflife;

/**
 * Created by yccheok on 11/10/2015.
 */
public class BasicEngine implements Engine {

    @Override
    public Cells nextGen(Cells cells) {
        final int row = cells.getRow();
        final int col = cells.getCol();

        for (int r = 0; r < row; r++) {
            for (int c = 0; c < col; c++) {
                Cell cell = cells.getCell(r, c);
                // Determine alive neighbour size.

                int aliveNeighbourSize = 0;

                // TOP ROW
                int _r = r - 1;
                _r = _r >= 0 ? _r : row - 1;

                int _c = c - 1;
                _c = _c >= 0 ? _c : col - 1;
                if (cells.getCell(_r, _c).isAlive()) {
                    aliveNeighbourSize++;
                }

                _c = c;
                if (cells.getCell(_r, _c).isAlive()) {
                    aliveNeighbourSize++;
                }

                _c = c + 1;
                _c = _c < col ? _c : 0;
                if (cells.getCell(_r, _c).isAlive()) {
                    aliveNeighbourSize++;
                }

                // SAME ROW
                _r = r;

                _c = c - 1;
                _c = _c >= 0 ? _c : col - 1;
                if (cells.getCell(_r, _c).isAlive()) {
                    aliveNeighbourSize++;
                }

                _c = c + 1;
                _c = _c < col ? _c : 0;
                if (cells.getCell(_r, _c).isAlive()) {
                    aliveNeighbourSize++;
                }

                // BOTTOM ROW
                _r = r + 1;
                _r = _r < row ? _r : 0;

                _c = c - 1;
                _c = _c >= 0 ? _c : col - 1;
                if (cells.getCell(_r, _c).isAlive()) {
                    aliveNeighbourSize++;
                }

                _c = c;
                if (cells.getCell(_r, _c).isAlive()) {
                    aliveNeighbourSize++;
                }

                _c = c + 1;
                _c = _c < col ? _c : 0;
                if (cells.getCell(_r, _c).isAlive()) {
                    aliveNeighbourSize++;
                }

                cell.setAliveNeighbourSize(aliveNeighbourSize);
            }
        }

        // Determine dead or alive.
        Cells result = new Cells(cells.getRow(), cells.getCol());
        for (int r = 0; r < row; r++) {
            for (int c = 0; c < col; c++) {
                final Cell cell = cells.getCell(r, c);
                final int aliveNeighbourSize = cell.getAliveNeighbourSize();
                final boolean alive = cell.isAlive();

                final boolean shouldAlive;
                if (alive) {
                    if (aliveNeighbourSize < 2) {
                        // Any live cell with fewer than two live neighbours dies, as if caused by under-population.
                        shouldAlive = false;
                    } else if (aliveNeighbourSize == 2 || aliveNeighbourSize == 3) {
                        // Any live cell with two or three live neighbours lives on to the next generation.
                        shouldAlive = true;
                    } else {
                        // Any live cell with more than three live neighbours dies, as if by over-population.
                        shouldAlive = false;
                    }
                } else {
                    if (aliveNeighbourSize == 3) {
                        // Any dead cell with exactly three live neighbours becomes a live cell, as if by reproduction.
                        shouldAlive = true;
                    } else {
                        shouldAlive = false;
                    }
                }
                result.getCell(r, c).setAlive(shouldAlive);
            }
        }

        return result;
    }
}
