package ru.job4j.poly;

public class Bus implements Transport {
    @Override
    public void go() {
        System.out.println("Bus go!");
    }

    @Override
    public void passengers(int count) {
        System.out.println("there are " + count + " passengers on the bus");
    }

    @Override
    public double fillUp(double numberOfLiters) {
        double fuelCost = 10.25;
        return numberOfLiters * fuelCost;
    }
}
