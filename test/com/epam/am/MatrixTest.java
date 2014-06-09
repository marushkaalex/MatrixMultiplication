package com.epam.am;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by Alexander on 09.06.14.
 */
public class MatrixTest {
    @Test
    public void testMultiply() throws Exception {
        Matrix matrix1 = new Matrix();
        Matrix matrix2 = new Matrix();
        matrix1.fillAndAddRow(2d, -2d);
        matrix1.fillAndAddRow(4d, 3d);
        matrix1.fillAndAddRow(5d, 0d);

        matrix2.fillAndAddRow(4d, 5d, -3d);
        matrix2.fillAndAddRow(-2d, 3d, 2d);
        Matrix matrix3 = matrix1.multiply(matrix2);
        Matrix testMatrix = new Matrix();
        testMatrix.fillAndAddRow(12d, 4d, -10d);
        testMatrix.fillAndAddRow(10d, 29d, -6d);
        testMatrix.fillAndAddRow(20d, 25d, -15d);
        Assert.assertEquals(testMatrix, matrix3);
        System.out.println(matrix3);
        System.out.println(testMatrix);
    }
}
