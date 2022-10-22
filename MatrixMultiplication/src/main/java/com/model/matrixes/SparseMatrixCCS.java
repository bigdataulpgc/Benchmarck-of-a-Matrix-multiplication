package com.model.matrixes;
import com.model.Matrix;

import java.util.List;

public class SparseMatrixCCS implements Matrix {

    private List<Integer> row_indexes;
    private List<Integer> pointers_to_the_first_non_null_elements_of_each_column_pointers;
    private List<Double> values;

    int size;
    public SparseMatrixCCS(int size) {
        this.size = size;
    }

    public SparseMatrixCCS setRow_indexes(List<Integer> row_indexes) {
        this.row_indexes = row_indexes;
        return this;
    }

    public SparseMatrixCCS setPointers_to_the_first_non_null_elements_of_each_column_pointers(List<Integer> pointers_to_the_first_non_null_elements_of_each_column_pointers) {
        this.pointers_to_the_first_non_null_elements_of_each_column_pointers = pointers_to_the_first_non_null_elements_of_each_column_pointers;
        return this;
    }

    public SparseMatrixCCS setValues(List<Double> values) {
        this.values = values;
        return this;
    }

    public List<Integer> getRow_indexes() {
        return row_indexes;
    }

    public List<Integer> getPointers_to_the_first_non_null_elements_of_each_column_pointers() {
        return pointers_to_the_first_non_null_elements_of_each_column_pointers;
    }

    public List<Double> getValues() {
        return values;
    }

    @Override
    public int size() {
        return this.size;
    }
}
