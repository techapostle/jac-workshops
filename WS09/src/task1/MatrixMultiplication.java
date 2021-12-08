package task1;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MatrixMultiplication {
    static long startTime, endTime;
    static int size = 2000;
    static double[][] matrix1 = new double[size][size];
    static double[][] matrix2 = new double[size][size];
    static double[][] result;

    public static void main(String[] args) throws InterruptedException {
        for (int i = 0; i < matrix1.length; i++) {
            for (int j = 0; j < matrix2[i].length; j++) {
                matrix1[i][j] = Math.random();
                matrix2[i][j] = Math.random();
            }
        }
        // parallel
        result = parallelMultiplyMatrix(matrix1, matrix2);
        // sequence
        result = sequentialMultiplyMatrix(matrix1, matrix2);
    }

    public static double[][] parallelMultiplyMatrix(double[][] a, double[][] b) {
        System.out.println("Parallel thread begin:");
        double[][] result = new double[a.length][a.length];
        startTime = System.currentTimeMillis();
        ExecutorService executorService = Executors.newCachedThreadPool();
        executorService.execute(new MatrixUtil(a, b, 0, 500, result));
        executorService.execute(new MatrixUtil(a, b, 500, 1000, result));
        executorService.execute(new MatrixUtil(a, b, 1000, 1500, result));
        executorService.execute(new MatrixUtil(a, b, 1500, 2000, result));
        executorService.shutdown();
        endTime = System.currentTimeMillis();
        System.out.println("Parallel processor time: " + (endTime - startTime) + " millisecond");
        System.out.println("Parallel processor stopped.");
        return result;
    }

    public static double[][] sequentialMultiplyMatrix(double[][] a, double[][] b) {
        double[][] result = new double[a.length][a.length];
        System.out.println("Sequential thread begin:");
        startTime = System.currentTimeMillis();
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[i].length; j++) {
                result[i][j] = a[i][j] * b[i][j];
            }
        }
        endTime = System.currentTimeMillis();
        System.out.println("Sequential processor time: " + (endTime - startTime) + " millisecond");
        System.out.println("Sequential processor stopped.");
        return result;
    }
}