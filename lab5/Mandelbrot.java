import java.awt.geom.Rectangle2D;

public class Mandelbrot extends FractalGenerator{

    public static final int MAX_ITERATIONS = 2000;

    @Override
    public void getInitialRange(Rectangle2D.Double range) {
        range.x = -2;
        range.y = -1.5;
        range.height = 3;
        range.width = 3;
    }

    @Override
    public int numIterations(double x, double y) {
        double currentY = 0;
        double currentX = 0;
        int numIters = 0;
        for(int i=0; i<MAX_ITERATIONS; i++){
            numIters++;

            double newX = currentX*currentX - currentY*currentY + x;
            double newY = 2*currentX*currentY + y;

            currentX = newX;
            currentY = newY;

            if(currentX*currentX + currentY*currentY > 4) {
                break;
            }
        }
        if(numIters == MAX_ITERATIONS){
            return -1;
        }
        else {
            return numIters;
        }
    }

    @Override
    public String toString() {
        return "Mandelbrot";
    }
}
