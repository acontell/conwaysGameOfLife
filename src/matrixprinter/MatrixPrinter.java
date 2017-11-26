package matrixprinter;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

public class MatrixPrinter {

    private static final ScheduledExecutorService SCHEDULER = Executors.newScheduledThreadPool(1);

    public MatrixPrinter(Configuration configuration) {
        startScheduler(new MatrixCanvas(configuration), configuration);
    }

    private void startScheduler(MatrixCanvas canvas, Configuration conf) {
        final ScheduledFuture<?> f = SCHEDULER.scheduleAtFixedRate(updateAndRepaint(canvas, conf), conf.getStartDelay(), conf.getRefreshRate(), TimeUnit.MILLISECONDS);
        SCHEDULER.schedule(() -> f.cancel(true), conf.getNumberOfIterations() * conf.getRefreshRate(), TimeUnit.MILLISECONDS);
    }

    private Runnable updateAndRepaint(MatrixCanvas canvas, Configuration conf) {
        return () -> {
            conf.updateMatrix();
            canvas.refreshCanvas();
        };
    }
}
