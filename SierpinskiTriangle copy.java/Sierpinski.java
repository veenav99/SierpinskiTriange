/*************************************************************************
 *  Compilation:  javac Sierpinski.java
 *  Execution:    java Sierpinski
 *
 *  @author: Veena Vrushi, vv274@scarletmail.rutgers.ed, vv274
 *
 *************************************************************************/

public class Sierpinski {

    // Height of an equilateral triangle whose sides are of the specified length. 
    public static double height(double length) {
        // formula = length*sqrt(3)/2

        double v = (length * Math.sqrt(3)) / 2.0;

        return v;
    }

    // Draws a filled equilateral triangle whose bottom vertex is (x, y) 
    // of the specified side length. 
    public static void filledTriangle(double x, double y, double length) {
        double v = height(length);
        StdDraw.filledPolygon(new double[] { x, x - (length / 2.0),
            x + (length / 2.0) }, new double[] { y, y + v, y + v });
    }
    

    public static void sierpinski(int n, double x, double y, double length) {
        if (n > 0) {
            filledTriangle(x, y, length);
            sierpinski(n - 1, x, y + height(length), length / 2);
            sierpinski(n - 1, x - (length / 2.0), y, length / 2);
            sierpinski(n - 1, x + (length / 2.0), y, length / 2);
      }
    }

    public static void main(String[] args) { 
        int n = Integer.parseInt(args[0]);
        double length = 1;
        double v = height(length);
        StdDraw.polygon(new double[] { 0, length / 2, length }, new double[] {0, v, 0 });
        sierpinski(n, length / 2, 0, length / 2);
      }
    }

