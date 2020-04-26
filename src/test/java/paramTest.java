import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import static org.junit.jupiter.api.Assertions.assertThrows;

@RunWith(Parameterized.class)
public class paramTest {

    private double[][] m1 = new double[1][1];
    private double[][] m2 = new double[1][1];
    private double[][] expected = new double[1][1];

    public paramTest(double m1, double m2, double expected) {
        this.m1[0][0] = m1;
        this.m2[0][0] = m2;
        this.expected[0][0] = expected;
    }

    @Parameterized.Parameters()
    public static Iterable<Object[]> dataForTest() {
        return Arrays.asList(new Object[][] {
                {0, 0, 0},
                {-5, 5, 0},
                {-5, 4, -1},
                {-5, 9, 4}
        });
    }

    @org.junit.Test
    public void can_add_when_matrices_are_scalar() {

        assertArrayEquals(expected, matrix.addition(m1, m2));
    }
}