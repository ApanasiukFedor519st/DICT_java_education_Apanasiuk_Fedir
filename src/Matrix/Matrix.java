package Matrix;
import java.util.Scanner;
public class Matrix {
    private int rows;
    private int cols;
    private double[][] matrix;

    Matrix(int rows, int cols) {
        this.rows = rows;
        this.cols = cols;
        matrix = new double[rows][cols];
    }

    public void readMatrix(Scanner input) {
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                matrix[row][col] = input.nextDouble();
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

    public Matrix multiply(Matrix factor) {
        Matrix product = new Matrix(this.rows, factor.getCols());
        for (int rowA = 0; rowA < this.rows; rowA++) {
            for (int colB = 0; colB < factor.getCols(); colB++) {
                for (int colA = 0; colA < this.cols; colA++) {
                    product.matrix[rowA][colB] += this.matrix[rowA][colA] * factor.matrix[colA][colB];
                }
            }
        }
        return product;
    }
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        menu(input);
    }

    private static void menu(Scanner input) {
        int choice;

        do {
            System.out.println("1. Add matrices");
            System.out.println("2. Multiply matrix to a constant");
            System.out.println("3. Multiply matrices");
            System.out.println("0. Exit");
            System.out.print("Your choice: ");
            choice = input.nextInt();

            switch (choice) {
                case 1:
                    addMatrices(input);
                    break;
                case 2:
                    multiplyMatrixByConstant(input);
                    break;
                case 3:
                    multiplyMatrixByMatrix(input);
                    break;
                case 0:
                    return;
                default:
                    System.out.println("Unknown entry.");
                    break;
            }
        } while(true);
    }

    private static Matrix getMatrix(Scanner input, String number) {
        System.out.printf("Enter size of %s matrix: ", number);
        Matrix matrix = new Matrix(input.nextInt(), input.nextInt());
        System.out.printf("Enter %s matrix:\n", number);
        matrix.readMatrix(input);
        return matrix;
    }

    private static void addMatrices(Scanner input) {
        Matrix matrixA = getMatrix(input, "first");
        Matrix matrixB = getMatrix(input, "second");

        if (matrixA.getRows() == matrixB.getRows() && matrixA.getCols() == matrixB.getCols()) {
            System.out.println("The addition result is:");
            matrixA.add(matrixB).print();
        } else {
            System.out.println("ERROR");
        }
    }

    private static void multiplyMatrixByConstant(Scanner input) {
        Matrix matrixA = getMatrix(input, "first");
        System.out.print("Enter the constant: ");
        Matrix result = matrixA.multiply(input.nextInt());
        System.out.println("The multiplication result is:");
        result.print();
    }

    private static void multiplyMatrixByMatrix(Scanner input) {
        Matrix matrixA = getMatrix(input, "first");
        Matrix matrixB = getMatrix(input, "second");
        if (matrixA.getCols() == matrixB.getRows()) {
            System.out.println("The multiplication result is:");
            matrixA.multiply(matrixB).print();
        } else {
            System.out.println("ERROR: First matrix rows must equal second matrix columns!");
        }
    }
}