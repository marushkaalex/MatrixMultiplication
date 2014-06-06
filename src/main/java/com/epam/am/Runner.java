package com.epam.am;

/**
 * Created by Alexander on 06.06.14.
 */
public class Runner {
    public static void main(String[] args) {

        Matrix matrix1 = new Matrix();
        Matrix matrix2 = new Matrix();

        matrix1.fillAndAddRow(2d, -2d);
        matrix1.fillAndAddRow(4d, 3d);
        matrix1.fillAndAddRow(5d, 0d);

        matrix2.fillAndAddRow(4d, 5d, -3d);
        matrix2.fillAndAddRow(-2d, 3d, 2d);

        Matrix matrix3 = matrix1.multiply(matrix2);
        matrix3.printMatrix();

    }
}
