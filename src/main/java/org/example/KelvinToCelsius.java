package org.example;

public class KelvinToCelsius{

    public int convert(Number kelvin) {
        return (int) (kelvin.doubleValue() - 275.15);
    }
}
