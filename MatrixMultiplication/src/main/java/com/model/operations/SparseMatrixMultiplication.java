package com.model.operations;
import com.model.MatrixMultiplication;
import com.model.matrixes.DenseMatrix;
import com.model.matrixes.SparseMatrixCOO;
import com.model.builders.SparseMatrixCOOBuilder;
import com.model.matrixes.SparseMatrixCCS;
import com.model.matrixes.SparseMatrixCRS;

public class SparseMatrixMultiplication implements MatrixMultiplication<SparseMatrixCOO, SparseMatrixCRS, SparseMatrixCCS> {

    @Override
    public SparseMatrixCOO multiply(SparseMatrixCRS a, SparseMatrixCCS b) {
            SparseMatrixCOOBuilder builder = new SparseMatrixCOOBuilder(a.size());
            for (int i = 0; i < a.size(); i++) {
                for (int j = 0; j < b.size(); j++) {
                    int ii = a.getPointers_to_the_first_non_null_elements_of_each_row_pointers().get(i);
                    int iEnd = a.getPointers_to_the_first_non_null_elements_of_each_row_pointers().get(i + 1);
                    int jj = b.getPointers_to_the_first_non_null_elements_of_each_column_pointers().get(j);
                    int jEnd = b.getPointers_to_the_first_non_null_elements_of_each_column_pointers().get(j + 1);
                    double value = 0;
                    while (ii < iEnd && jj < jEnd) {
                        int aa = a.getColumn_indexes().get(ii);
                        int bb = b.getRow_indexes().get(jj);
                        if (aa == bb) {
                            value += a.getValues().get(ii) * b.getValues().get(jj);
                            ii++;
                            jj++;
                        }
                        else if (aa < bb) ii++;
                        else jj++;

                    }
                    if (value != 0) builder.set(i, j, value);
                }
            }

            return builder.toMatrix();
        }

}
