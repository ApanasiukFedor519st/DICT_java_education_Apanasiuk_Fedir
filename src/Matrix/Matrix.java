package Matrix;
import java.util.Scanner;
public class Matrix {
    private int rows;
    private int cols;
    private int[][] matrix;
    Matrix(int rows, int cols) {
        this.rows = rows;
        this.cols = cols;
        matrix = new int[rows][cols];
    }
    public void readMatrix(Scanner input) {
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                matrix[row][col] = input.nextInt();
            }
        }
    }
    public int getRows() {
        return rows;
    }
    public int getCols() {
        return cols;
    }
    public Matrix add(Matrix addend) {
        Matrix sum = new Matrix(rows, cols);
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                sum.matrix[row][col] = this.matrix[row][col] + addend.matrix[row][col];
            }
        }
        return sum;
    }
    public void print() {
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                System.out.print(this.matrix[row][col] + " ");
            }
            System.out.println();
        }
    }

    public Matrix multiply(int factor) {
        Matrix product = new Matrix(rows, cols);
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                product.matrix[row][col] = this.matrix[row][col] * factor;
            }
        }
        return product;
    }
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

//        addMatrices(input);
        multiplyMatrices(input);
    }

    private static void addMatrices(Scanner input) {
        Matrix matrixA = new Matrix(input.nextInt(), input.nextInt());
        matrixA.readMatrix(input);

        Matrix matrixB = new Matrix(input.nextInt(), input.nextInt());
        matrixB.readMatrix(input);
        if (matrixA.getRows() == matrixB.getRows() && matrixA.getCols() == matrixB.getCols()) {
            Matrix result = matrixA.add(matrixB);
            result.print();
        } else {
            System.out.println("ERROR");
        }
    }

    private static void multiplyMatrices(Scanner input) {
        Matrix matrixA = new Matrix(input.nextInt(), input.nextInt());
        matrixA.readMatrix(input);
        Matrix result = matrixA.multiply(input.nextInt());
        result.print();
    }
}