package org.example;

public class TupleOfDouble {
    private double first;
    private double second;

    public TupleOfDouble(double first, double second) {
        this.first = first;
        this.second = second;
    }

    public double getFirst() {
        return this.first;
    }

    public double getSecond() {
        return this.second;
    }

    public void print() {
        System.out.print(this.first);
        System.out.print(", " + this.second);
        System.out.println("");
    }
}