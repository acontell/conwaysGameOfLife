package matrixprinter;

import java.awt.Dimension;
import javax.swing.JFrame;

class MatrixCanvas extends JFrame {

    private final MatrixDrawer matrixDrawer;

    MatrixCanvas(Configuration conf) {
        super(conf.getCanvasTitle());
        matrixDrawer = new MatrixDrawer(conf);
        start(conf.getCanvasDimension());
    }

    private void start(Dimension canvasDimension) {
        getContentPane().add(matrixDrawer);
        setSize(canvasDimension);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
    }

    void refreshCanvas() {
        matrixDrawer.repaint();
    }
}
