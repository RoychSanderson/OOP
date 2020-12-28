package com.company;

import java.awt.geom.Rectangle2D;

public class Mandelbrot extends FractalGenerator {
    @Override
    public final void getInitialRange(final Rectangle2D.Double range) {
        range.x = -2;
        range.y = -1.5;
        range.width = 3;
        range.height = 3;
    }
    @Override
    public final int numIterations(final double x, final double y) {
        ComplexCh z = new ComplexCh(0, 0);
        ComplexCh c = new ComplexCh(x, y);
        int i = 0;
        for (; i < MAX_ITERATIONS; ++i) {
            ComplexCh z1 = z.sqr().add(c);
            if (ComplexCh.absSqr(z1) > CONST_VAL) {
                break;
            }

            z = z1;
        }
        if (i == MAX_ITERATIONS) {
            return -1;
        } else {
            return i;
        }
    }
    public String toString(){
        return "Mandelbrot";
    }
    public static final int MAX_ITERATIONS = 2000;
    private static final int CONST_VAL = 4;
}
