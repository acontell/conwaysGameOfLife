package Conway;

import static Conway.Utils.goOverMatrix;

class Cell {

    private final Position p;
    private final boolean[][] worldState;
    private int aliveNeighbours;

    Cell(Position p, boolean isAlive, boolean[][] worldState) {
        this.p = p;
        this.worldState = worldState;
        this.worldState[p.x][p.y] = isAlive;
    }

    void updateState() {
        updateAliveNeighbours();
        worldState[p.x][p.y] = isAlive(worldState[p.x][p.y]);
    }

    /*
        Any live cell with fewer than two live neighbours dies, as if caused by underpopulation.
        Any live cell with two or three live neighbours lives on to the next generation.
        Any live cell with more than three live neighbours dies, as if by overpopulation.
        Any dead cell with exactly three live neighbours becomes a live cell, as if by reproduction.
     */
    private boolean isAlive(boolean isAlive) {
        return isAlive ? aliveNeighbours == 2 || aliveNeighbours == 3 : aliveNeighbours == 3;
    }

    private void updateAliveNeighbours() {
        aliveNeighbours = 0;
        goOverMatrix(worldState, -1, 2, (x, y) -> {
            if (x != 0 || y != 0) {
                aliveNeighbours += isNeighbourAlive(x + p.x, y + p.y) ? 1 : 0;
            }
        });
    }

    private boolean isNeighbourAlive(int x, int y) {
        return isValidCell(x, y) ? worldState[x][y] : false;
    }

    private boolean isValidCell(int x, int y) {
        return x >= 0 && y >= 0 && x < worldState.length && y < worldState[x].length;
    }
}
