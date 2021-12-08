package task1;

public class MatrixUtil implements Runnable {
    int size = 2000;
    double[][] matrix1;
    double[][] matrix2;
    final double[][] result;
    int start;
    int end;

    MatrixUtil(double[][] a, double[][] b, int start, int end, double[][] result) {
        this.matrix1 = a;
        this.matrix2 = b;
        this.result = result;
        this.start = start;
        this.end = end;
    }

    @Override
    public void run() {
        for (int i = this.start; i < this.end; i++) {
            for (int j = 0; j < matrix1[i].length; j++) {
                result[i][j] = matrix1[i][j] * matrix2[i][j];
            }
        }
    }
}