import java.io.*;
import java.util.Scanner;

public class matrix {

    public static double[][] multiply(double[][] firstMatrix,
                                      double[][] secondMatrix) throws IllegalArgumentException {
        if(firstMatrix[0].length != secondMatrix.length)
            throw new IllegalArgumentException("matrices are incompatible");

        double[][] result = new double[firstMatrix.length][secondMatrix[0].length];

        for (int row = 0; row < result.length; row++) {
            for (int col = 0; col < result[row].length; col++) {
                result[row][col] = multiplyMatricesCell(firstMatrix, secondMatrix, row, col);
            }
        }
        return result;
    }

    private static double multiplyMatricesCell(double[][] firstMatrix,
                                               double[][] secondMatrix,
                                               int row, int col) {
        double cell = 0;
        for (int i = 0; i < secondMatrix.length; i++) {
            cell += firstMatrix[row][i] * secondMatrix[i][col];
        }
        return cell;
    }

    public static void print(double[][] matrix) {
        int cols=matrix[0].length;
        for(double[] row : matrix) {
            for(int j=0;j<cols;j++)
                System.out.print(row[j]+" ");
            System.out.println();
        }
    }

    public static double[][] addition(double[][] firstMatrix,
                                      double[][] secondMatrix)
            throws IllegalArgumentException {
        if (firstMatrix.length != secondMatrix.length ||
                firstMatrix[0].length != secondMatrix[0].length)
            throw new IllegalArgumentException("matrices are incompatible");
        double[][] result = new double[firstMatrix.length][firstMatrix[0].length];
        for (int row = 0; row < result.length; row++) {
            for (int col = 0; col < result[0].length; col++) {
                result[row][col] = firstMatrix[row][col] + secondMatrix[row][col];
            }
        }
        return result;
    }

    public static double[][] subtraction(double[][] firstMatrix,
                                         double[][] secondMatrix)
            throws IllegalArgumentException {
        if (firstMatrix.length != secondMatrix.length ||
                firstMatrix[0].length != secondMatrix[0].length)
            throw new IllegalArgumentException("matrices are incompatible");
        double[][] result = new double[firstMatrix.length][firstMatrix[0].length];
        for (int row = 0; row < result.length; row++) {
            for (int col = 0; col < result[0].length; col++) {
                result[row][col] = firstMatrix[row][col] - secondMatrix[row][col];
            }
        }
        return result;
    }

    public static void multiplyByScalar(double[][] matrix, double scalar)
            throws IllegalArgumentException {
        if (matrix.length == 0 || matrix[0].length == 0)
            throw new IllegalArgumentException("matrix is empty");

        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[0].length; col++) {
                matrix[row][col] *= scalar;
            }
        }
    }

    public static double[][] transpose(double[][] matrix)
            throws IllegalArgumentException {
        if (matrix.length == 0 || matrix[0].length == 0)
            throw new IllegalArgumentException("matrix is empty");
        double[][] result = new double[matrix.length][matrix[0].length];
        for (int row = 0; row < result.length; row++) {
            for (int col = 0; col < result[0].length; col++) {
                result[col][row] = matrix[row][col];
            }
        }
        return result;
    }

    public static double[][] getMatrixFromFile(String path) throws IOException {
        double[][] res_matrix = null;

        BufferedReader buffer = new BufferedReader(new FileReader(path));

        String line;
        int row = 0;
        int size = 0;

        while ((line = buffer.readLine()) != null) {
            String[] vals = line.trim().split("\\s+");

            if (res_matrix == null) {
                size = vals.length;
                res_matrix = new double[size][size];
            }

            for (int col = 0; col < size; col++) {
               res_matrix[row][col] = Integer.parseInt(vals[col]);
            }
            row++;
        }

        return res_matrix;
    }
}