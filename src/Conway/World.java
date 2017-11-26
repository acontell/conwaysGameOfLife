package Conway;

import static Conway.Utils.goOverMatrix;
import java.awt.Dimension;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

class World {

    private final boolean[][] state;
    private final List<Cell> cells;

    World(Dimension worldDimension, Dimension cellDimension, Supplier<Boolean> initialValueSupplier) {
        cells = new ArrayList<>();
        state = new boolean[worldDimension.height / cellDimension.height][worldDimension.width / cellDimension.width];
        goOverMatrix(state, (x, y) -> cells.add(buildCell(x, y, initialValueSupplier)));
    }

    boolean[][] getState() {
        return state;
    }

    void updateState() {
        cells.stream().forEach(Cell::updateState);
    }

    private Cell buildCell(int x, int y, Supplier<Boolean> initialValueSupplier) {
        return new Cell(new Position(x, y), initialValueSupplier.get(), state);
    }
}
