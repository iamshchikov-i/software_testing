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

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Arrays;


public class matrixTest {

    @org.junit.Test
    public void can_addition() {
        double[][] m1 = { {1,2}, {4,5} }, m2 = { {3,6}, {8,5} }, res = {{4, 8}, {12, 10}};

        assertArrayEquals(matrix.addition(m1, m2), res);
    }

    @org.junit.Test
    public void throw_when_matrices_are_incompatible_1() {
        double[][] m1 = { {1, 2, 9}, {4, 5, 3 } }, m2 = { {3, 6}, {8, 5} };

        assertThrows(IllegalArgumentException.class, () -> matrix.addition(m1, m2));
    }

    @org.junit.Test
    public void can_subtraction() {
        double[][] m1 = { {1,2}, {4,5} }, m2 = { {3,6}, {8,5} }, res = {{-2, -4}, {-4, 0}};

        assertArrayEquals(matrix.subtraction(m1, m2), res);
    }

    @org.junit.Test
    public void throw_when_matrices_are_incompatible_2() {
        double[][] m1 = { {1, 2, 9}, {4, 5, 3 } }, m2 = { {3, 6}, {8, 5} };

        assertThrows(IllegalArgumentException.class, () -> matrix.subtraction(m1, m2));
    }

    @org.junit.Test
    public void can_multiply_by_zero() {
        double[][] m1 = { {1,2}, {4,5} },  res = {{0, 0}, {0, 0}};
        double scalar = 0.0;
        matrix.multiplyByScalar(m1, scalar);

        assertArrayEquals(m1, res);
    }

    @org.junit.Test
    public void can_multiply_by_scalar() {
        double[][] m1 = {{-4, 2}, {9, -11} },  res = {{-12, 6}, {27, -33}};
        double scalar = 3.0;
        matrix.multiplyByScalar(m1, scalar);

        assertArrayEquals(m1, res);
    }

    @org.junit.Test
    public void throw_when_matrix_is_empty_1()  {
        double[][] m1 = { {}, {} };
        double scalar = 3.0;

        assertThrows(IllegalArgumentException.class, () -> matrix.multiplyByScalar(m1, scalar));
    }

    @org.junit.Test
    public void can_transpose_matrix() {
        double[][] m1 = { {-4, 2}, {9, -11} },  res = { {-4, 9}, {2, -11} };

        assertArrayEquals(matrix.transpose(m1), res);
    }

    @org.junit.Test
    public void throw_when_matrix_is_empty_2() {
        double[][] m1 = { {}, {} };

        assertThrows(IllegalArgumentException.class, () -> matrix.transpose(m1));
    }

    @org.junit.Test
    public void can_multiplyMatrices() {
        double[][] m1 = { {-4, 2}, {9, -11} }, m2 = { {3, 6}, {8, 5} }, res = { {4, -14}, {-61, -1} };

        assertArrayEquals(matrix.multiply(m1, m2), res);
    }

    @org.junit.Test
    public void throw_when_matrix_are_incompatible() {
        double[][] m1 = { {-4, 2, 5}, {9, -11, 0} }, m2 = { {3, 6}, {8, 5} };

        assertThrows(IllegalArgumentException.class, () -> matrix.multiply(m1, m2));
    }

    @org.junit.Test
    public void print_not_changes_matrix() {
        double[][] m1 = { {-4, 2}, {9, -11} }, m2 = { {-4, 2}, {9, -11} };
        matrix.print(m1);

        assertArrayEquals(m1, m2);
    }

    @org.junit.Test
    public  void throw_when_read_matrix_from_wrong_path() throws IOException {

        assertThrows(IOException.class, () -> matrix.getMatrixFromFile("src/main/resources/m.txt"));
    }

    @org.junit.Test
    public  void can_read_matrix_from_file() throws IOException {
        double[][] m = {{0, 1, 1}, {2, 3, 5}, {8, 13, 21}};
        double[][] matrix_from_file = matrix.getMatrixFromFile("src/main/resources/m1.txt");

        assertArrayEquals(matrix_from_file, m);
    }

    @org.junit.Test
    public  void multiply_matrices_from_file() throws IOException {
        double[][] m1 = matrix.getMatrixFromFile("src/main/resources/m1.txt");
        double[][] m2 = matrix.getMatrixFromFile("src/main/resources/m2.txt");
        double[][] actual_res = matrix.getMatrixFromFile("src/main/resources/res.txt");

        assertArrayEquals(actual_res, matrix.multiply(m1, m2));
    }

}