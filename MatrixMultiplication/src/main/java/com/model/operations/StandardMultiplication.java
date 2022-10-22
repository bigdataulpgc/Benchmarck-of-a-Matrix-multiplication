package com.model.operations;

import com.model.MatrixMultiplication;
import com.model.builders.DenseMatrixBuilder;
import com.model.matrixes.DenseMatrix;

public class StandardMultiplication implements MatrixMultiplication<DenseMatrix, DenseMatrix, DenseMatrix> {


    public DenseMatrix multiply(DenseMatrix matrix1, DenseMatrix matrix2) {
        DenseMatrixBuilder builder = new DenseMatrixBuilder(matrix1.size(), matrix1.size());
        for (int m1_row = 0; m1_row < matrix1.size(); m1_row++) {
            for (int m2_col = 0; m2_col < matrix1.size(); m2_col++) {
                double sum_value = 0;
                for (int m1_col = 0; m1_col < matrix1.size(); m1_col++) {
                    sum_value += matrix1.get(m1_row, m1_col) * matrix2.get(m1_col, m2_col);
                }
                builder.set(m1_row, m2_col, sum_value);
            }
        }
        return builder.toMatrix();
    }
}
