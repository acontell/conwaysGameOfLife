package matrixprinter;

import java.awt.Color;
import java.awt.Dimension;

public interface Configuration {

    Dimension getCanvasDimension();

    Dimension getRectDimension();

    int getNumberOfIterations();

    String getCanvasTitle();

    int getStartDelay();

    int getRefreshRate();

    boolean[][] getMatrix();
    
    void updateMatrix();
    
    Color getTrueColor();
    
    Color getFalseColor();
}
