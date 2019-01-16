package ru.job4j.calculate;

public class Calculate {

    public String echo(String value) {
        return String.format("%s %s %s", value, value, value);
    }
    public static void main(String[] args) {
        Calculate calculate = new Calculate();
        System.out.println(calculate.echo("Hi"));
    }
}