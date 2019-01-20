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
    public void whenPointA_5_10AndPointB_12_28ThenDistance() {
        Point pointA = new Point(5, 10);
        Point pointB = new Point(12, 28);
        double result = pointA.distanceTo(pointB);
        assertThat( result, closeTo(19.3132, 0.0001));
    }
}
