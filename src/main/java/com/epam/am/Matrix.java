package com.epam.am;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Alexander on 06.06.14.
 */
public class Matrix {

    private List<List<Double>> matrix;
    private int columnCount;

    public Matrix(List<Double>... rows) {
        matrix = new ArrayList<List<Double>>();
        for (List<Double> row : rows) {
            addRow(row);
        }
    }

    public Matrix() {
        matrix = new ArrayList<List<Double>>();
        columnCount = 0;
    }

    public List<List<Double>> getMatrixAsList() {
        return matrix;
    }

    public List<Double> getRow(int index) {
        if ((index > this.getRowCount() || (index < 1))) {
            System.err.println("row index is out of bound");
            return null;
        } else {
            return matrix.get(index - 1);
        }
    }

    public List<Double> getColumn(int index) {
        if ((index > this.getColumnCount()) || (index < 1)) {
            System.err.println("column index is out of bound");
            return null;
        } else {
            List<Double> column = new ArrayList<Double>();
            for (List<Double> row : matrix) {
                column.add(row.get(index - 1));
            }
            return column;
        }
    }

    public void printMatrix() {
        for (List<Double> doubles : matrix) {
            for (Double aDouble : doubles) {
                System.out.print(aDouble + " ");
            }
            System.out.println("");
        }
    }

    public void fillAndAddRow(Double... values) {
        if ((columnCount == 0) || (columnCount == values.length)) {
            ArrayList<Double> row = new ArrayList<Double>();
            for (Double value : values) {
                row.add(value);
            }
            matrix.add(row);
            columnCount = values.length;
        } else {
            System.err.println("You should add a column with the same length as you have added before");
        }
    }

    private void addRow(List<Double> row) {
        if ((columnCount == 0) || (columnCount == row.size())) {
            matrix.add(row);
            columnCount = row.size();
        } else {
            System.err.println("You should add a column with the same length as you have added before (row with values:"
                    + row.toString() + ")");
        }
    }

    public int getColumnCount() {
        return columnCount;
    }

    public int getRowCount() {
        return matrix.size();
    }

//    public Matrix multiply(Matrix factor) {
//        if (this.getRowCount() != factor.getColumnCount()) {
//            System.err.println("row != columns");
//            return null;
//        } else {
//            Matrix result = new Matrix();
//
//        }
//    }
}

