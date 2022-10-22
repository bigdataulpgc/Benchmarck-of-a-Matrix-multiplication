package com.model.builders;
import com.model.Builder;
import com.model.matrixes.SparseMatrixCCS;
import java.util.ArrayList;
import java.util.List;

public class SparseMatrixCCSBuilder implements Builder {

    private final List<Integer> row_indexes = new ArrayList<>();
    private final List<Integer> pointers_to_the_first_non_null_elements_of_each_column_pointers = new ArrayList<>();
    private final List<Double> values = new ArrayList<>();

    int size;
    public SparseMatrixCCSBuilder(int size) {
        this.size = size;
    }

    public void addRowIndex(int row_ind) {
        row_indexes.add(row_ind);
    }

    public void addColumnPrt(int column_prt) {
        pointers_to_the_first_non_null_elements_of_each_column_pointers.add(column_prt);
    }

    public void addValue(double value) {
        values.add(value);
    }

    @Override
    public SparseMatrixCCS toMatrix() {
        return new SparseMatrixCCS(this.size)
                .setRow_indexes(row_indexes)
                .setPointers_to_the_first_non_null_elements_of_each_column_pointers(pointers_to_the_first_non_null_elements_of_each_column_pointers)
                .setValues(values);
    }
}


