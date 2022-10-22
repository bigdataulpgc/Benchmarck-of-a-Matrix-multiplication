package com.model.operations;

import com.model.MatrixMultiplication;
import com.model.matrixes.DenseMatrix;
import com.model.builders.DenseMatrixBuilder;

public class RowMatrixMultiplication implements MatrixMultiplication<DenseMatrix, DenseMatrix, DenseMatrix> {

    @Override
    public DenseMatrix multiply(DenseMatrix a, DenseMatrix b) {
        DenseMatrixBuilder matrixBuilder = new DenseMatrixBuilder(a.size(), b.size());

        for (int i = 0; i < a.size(); i++) {
            for (int k = 0; k < a.size(); k++) {
                double sum_value = 0;
                for (int j = 0; j < a.size(); j++) {
                    sum_value += a.get(i, j) * b.get(j, k);
                }
                matrixBuilder.set(i, k, sum_value);
            }
        }
        return matrixBuilder.toMatrix();
    }
}
