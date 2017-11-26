package Conway;

import java.awt.Color;
import java.awt.Dimension;
import matrixprinter.Configuration;

public class ConwayMatrixPrinterConfiguration implements Configuration {

    private static final int NUMBER_OF_ITERATIONS = 100;
    private static final String TITLE = "Conway's game of life";
    private static final int START_DELAY = 0;
    private static final int REFRESH_RATE = 250;
    private static final Dimension WORLD_DIMENSION = new Dimension(600, 600);
    private static final Dimension CELL_DIMENSION = new Dimension(5, 5);
    private static final Color ALIVE_CELL_COLOR = Color.BLACK;
    private static final Color DEAD_CELL_COLOR = Color.WHITE;
    private static final double INITIAL_RANDOM_CHANCE = 0.1;

    private final World world = new World(WORLD_DIMENSION, CELL_DIMENSION, ConwayMatrixPrinterConfiguration::initialStateSupplier);
    
    static boolean initialStateSupplier() {
        return Math.random() < INITIAL_RANDOM_CHANCE;
    }

    @Override
    public Dimension getCanvasDimension() {
        return WORLD_DIMENSION;
    }

    @Override
    public Dimension getRectDimension() {
        return CELL_DIMENSION;
    }

    @Override
    public int getNumberOfIterations() {
        return NUMBER_OF_ITERATIONS;
    }

    @Override
    public String getCanvasTitle() {
        return TITLE;
    }

    @Override
    public int getStartDelay() {
        return START_DELAY;
    }

    @Override
    public int getRefreshRate() {
        return REFRESH_RATE;
    }

    @Override
    public boolean[][] getMatrix() {
        return world.getState();
    }

    @Override
    public Color getTrueColor() {
        return ALIVE_CELL_COLOR;
    }

    @Override
    public Color getFalseColor() {
        return DEAD_CELL_COLOR;
    }

    @Override
    public void updateMatrix() {
        world.updateState();
    }
}
