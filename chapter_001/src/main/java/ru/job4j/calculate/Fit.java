package ru.job4j.calculate;
/**
 * Программа расчета идеального веса.
 */
public class Fit {
    /**
     * Идеальный вес для мужщины.
     * @param height Рост.
     * @return идеальный вес.
     */
    public double manWeight(double height) {
        double result = (height - 100) * 1.15;
        return result;
    }

    /**
     * Идеальный вес для женщины.
     * @param height Рост.
     * @return идеальный вес.
     */
    public double womanWeight(double height) {
        double result = (height - 110) * 1.15;
        return result;
    }
}

