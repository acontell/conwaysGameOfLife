package matrixprinter;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.util.stream.IntStream;
import javax.swing.JPanel;

// For simplicity, expects squares that fit in x and y
class MatrixDrawer extends JPanel {

    private final Configuration conf;
    private Graphics graphics;

    MatrixDrawer(Configuration conf) {
        this.conf = conf;
    }

    private boolean getMatrixValue(Point p) {
        return conf.getMatrix()[p.y / conf.getRectDimension().height][p.x / conf.getRectDimension().width];
    }

    private Color getColor(Point p) {
        return getMatrixValue(p) ? conf.getTrueColor() : conf.getFalseColor();
    }

    private void printRect(Point p) {
        this.graphics.setColor(getColor(p));
        this.graphics.fillRect(p.x, p.y, conf.getRectDimension().width, conf.getRectDimension().height);
    }

    private IntStream getIntStream(int limit) {
        return IntStream.iterate(0, prev -> prev + 1)
                .limit(limit);
    }

    private void printRectangleLine(int y) {
        getIntStream(conf.getCanvasDimension().width / conf.getRectDimension().width)
                .mapToObj(x -> new Point(x * conf.getRectDimension().width, y * conf.getRectDimension().height))
                .forEach(this::printRect);
    }

    @Override
    public void paintComponent(Graphics g) {
        this.graphics = g;
        getIntStream(conf.getCanvasDimension().height / conf.getRectDimension().height)
                .forEach(this::printRectangleLine);
    }
}
