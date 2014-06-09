package com.epam.am;

import java.util.List;

/**
 * Created by Alexander on 09.06.14.
 */
public class MatrixPrinter {

    private MatrixPrinter() {
    }

    public static void printMatrix(Matrix matrix) {
        List<List<Double>> values = matrix.getMatrixAsList();
        for (List<Double> doubles : values) {
            for (Double aDouble : doubles) {
                System.out.print(aDouble + " ");
            }
            System.out.println("");
        }
    }

}
