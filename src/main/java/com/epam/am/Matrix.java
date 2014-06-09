package com.epam.am;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by Alexander on 06.06.14.
 */
public class Matrix {

    private static final double RANDOM_MAX = 100d;
    private static final double RANDOM_MIN = -100d;
    private List<List<Double>> values;

    public Matrix(List<Double>... rows) throws MatrixException {
        values = new ArrayList<List<Double>>();
        for (List<Double> row : rows) {
            addRow(row);
        }
    }

    public Matrix() {
        values = new ArrayList<List<Double>>();
    }

    public void randomFilling(int rows, int columns) throws MatrixException {
        if (values.size() != 0) {
            throw new MatrixException("you can not use randomFilling: the values have been filled");
        } else {
            List<Double> row;
            Random random = new Random();
            for (int i = 0; i < rows; i++) {
                row = new ArrayList<Double>();
                for (int j = 0; j < columns; j++) {
                    row.add(random.nextDouble() * (RANDOM_MAX - RANDOM_MIN + 1) + RANDOM_MIN);
                }
                addRow(row);
            }
        }
    }

    public List<List<Double>> getMatrixAsList() {
        return values;
    }

    /**
     * @param index starts from 1
     */
    public List<Double> getRow(int index) {
        if ((index > this.getRowCount() || (index < 1))) {
            System.err.println("row index is out of bound");
            return null;
        } else {
            return values.get(index - 1);
        }
    }

    /**
     * @param index starts from 1
     */
    public List<Double> getColumn(int index) throws MatrixException {
        if ((index > values.get(0).size()) || (index < 1)) {
            throw new MatrixException("column index is out of bound");
        } else {
            List<Double> column = new ArrayList<Double>();
            for (List<Double> row : values) {
                column.add(row.get(index - 1));
            }
            return column;
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("{");
        List<Double> row;
        for (int i = 0; i < values.size(); i++) {
            sb.append("{");
            row = values.get(i);
            for (int j = 0; j < row.size(); j++) {
                sb.append(row.get(j));
                if (j != row.size() - 1) {
                    sb.append(", ");
                }
            }
            sb.append("}");
            if (i != values.size() - 1) {
                sb.append(", ");
            }
        }
        sb.append("}");
        return sb.toString();
    }

    public void fillAndAddRow(Double... rowValues) throws MatrixException {
        if ((values.size() == 0) || (values.get(0).size() == rowValues.length)) {
            ArrayList<Double> row = new ArrayList<Double>();
            for (Double value : rowValues) {
                row.add(value);
            }
            this.values.add(row);
        } else {
            throw new MatrixException("You should add a column with the same length as you have added before");
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Matrix matrix = (Matrix) o;

        if (values != null ? !values.equals(matrix.values) : matrix.values != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return values != null ? values.hashCode() : 0;
    }

    private void addRow(List<Double> row) throws MatrixException {
        if ((values.size() == 0) || (values.get(0).size() == row.size())) {
            values.add(row);
        } else {
            throw new MatrixException("You should add a column with the same length as you have added before (row with values:"
                    + row.toString() + ")");
        }
    }

    public int getRowCount() {
        return values.size();
    }

    public Matrix multiply(Matrix factor) throws MatrixException {
        if (values.get(0).size() != factor.getRowCount()) {
            throw new MatrixException("cannot multiply values: rows != columns");
        } else {
            Matrix result = new Matrix();
            List<Double> resRow;
            for (int i = 0; i < values.size(); i++) {
                resRow = new ArrayList<Double>();
                for (int j = 0; j < factor.getColumnCount(); j++) {
                    resRow.add(rowXcolumn(this.getRow(i + 1), factor.getColumn(j + 1)));
                }
                result.addRow(resRow);
            }
            return result;
        }
    }

    public int getColumnCount() {
        return values.get(0).size();
    }

    private Double rowXcolumn(List<Double> row, List<Double> column) {
        double result = 0d;
        for (int i = 0; i < row.size(); i++) {
            result += row.get(i) * column.get(i);
        }
        return new Double(result);
    }

}

