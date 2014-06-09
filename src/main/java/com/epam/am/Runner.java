package com.epam.am;

/**
 * Created by Alexander on 06.06.14.
 */
public class Runner {
    public static void main(String[] args) throws MatrixException {

        Matrix matrix1 = new Matrix();
        Matrix matrix2 = new Matrix();

        matrix1.randomFilling(3, 3);
        matrix2.randomFilling(3, 3);
        Matrix matrix3 = matrix1.multiply(matrix2);
        MatrixPrinter.printMatrix(matrix3);
    }
}
