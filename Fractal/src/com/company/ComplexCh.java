package com.company;

public class ComplexCh {
    public ComplexCh() {
        this(0, 0);
    }
    public ComplexCh(final double realPart, final double imagePart) {
        this.real = realPart;
        this.image = imagePart;
    }
    public final ComplexCh multiply(final ComplexCh other) {
        return new ComplexCh(real * other.real - image * other.image, real
                * other.image + other.real * image);
    }
    public final ComplexCh sqr() {
        return this.multiply(this);
    }
    public final ComplexCh add(final ComplexCh other) {
        return new ComplexCh(real + other.real, image + other.image);
    }
    public static double absSqr(final ComplexCh complex) {
        return complex.real * complex.real + complex.image * complex.image;
    }
    public static ComplexCh compSpr(ComplexCh fir){
        return new ComplexCh(fir.real, -fir.image);
    }
    public static ComplexCh absComplex(ComplexCh other) {
        return new ComplexCh(Math.abs(other.real),Math.abs(other.image));
    }
    private double real;
    private final double image;
}