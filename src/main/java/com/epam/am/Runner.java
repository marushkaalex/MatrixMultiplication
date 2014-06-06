package com.epam.am;

/**
 * Created by Alexander on 06.06.14.
 */
public class Runner {
    public static void main(String[] args) {

        Matrix matrix = new Matrix();
        matrix.fillAndAddRow(1d, 2d, 3d);
        matrix.fillAndAddRow(4d, 5d, 6d);
        //matrix.fillAndAddRow(7d, 8d, 9d);
        matrix.printMatrix();

    }
}
