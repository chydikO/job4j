package ru.job4j.condition;

import org.junit.Test;
import static org.hamcrest.number.IsCloseTo.closeTo;
import static org.junit.Assert.assertThat;

/**
 * @author Oleg Chudnovskij (oleg.chudnovskiy@gmail.com)
 * @version $Id$
 * @since 0.1
 */

public class PointTest {

    @Test
    public void whenPointA510AndPointB1228ThenDistance() {
        Point pointA = new Point(5, 10);
        Point pointB = new Point(12, 28);
        double result = pointA.distance(pointB);
        assertThat(result, closeTo(19.3132, 0.0001));
    }

    @Test
    public void whenPoint3dA0510AndPointB102030ThenDistance() {
        Point pointA = new Point(0, 5, 10);
        Point pointB = new Point(10, 20, 30);
        double result = pointA.distance3d(pointB);
        assertThat(result, closeTo(26.9258, 0.0001));
    }
}
