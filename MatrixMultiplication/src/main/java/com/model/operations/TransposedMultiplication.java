package com.model.operations;

import com.model.MatrixMultiplication;
import com.model.builders.DenseMatrixBuilder;
import com.model.matrixes.DenseMatrix;

public class TransposedMultiplication implements MatrixMultiplication<DenseMatrix, DenseMatrix, DenseMatrix> {
    @Override
    public DenseMatrix multiply(DenseMatrix a, DenseMatrix b) {

        DenseMatrixBuilder matrixBuilder = new DenseMatrixBuilder(a.size(), b.size());

        double[][] transposed = transpose(b);


        for (int i = 0; i < a.size(); i++) {
            for (int j = 0; j < a.size(); j++) {
                double sum_value = 0;
                for (int k = 0; k < a.size(); k++) {
                    sum_value += a.get(i,k) * b.get(j,k);
                }
            }
        }
        return matrixBuilder.toMatrix();
    }

    private static double[][] transpose(DenseMatrix b) {
        double[][] transposed = new double[b.size()][b.size()];
        for (int i = 0; i < b.size(); i++) {
            for (int j = 0; j < b.size(); j++) {
                transposed[j][i] = b.get(i,j);
            }
        }
        return transposed;
    }
}