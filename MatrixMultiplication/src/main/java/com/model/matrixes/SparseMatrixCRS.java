package com.model.matrixes;
import com.model.Matrix;
import java.util.List;

public class SparseMatrixCRS implements Matrix {

    private List<Integer> pointers_to_the_first_non_null_elements_of_each_row_pointers;
    private List<Integer> column_indexes;
    private List<Double> values;

    int size;
    public SparseMatrixCRS(int size) {
        this.size = size;
    }

    public SparseMatrixCRS setPointers_to_the_first_non_null_elements_of_each_row_pointers(List<Integer> pointers_to_the_first_non_null_elements_of_each_row_pointers) {
        this.pointers_to_the_first_non_null_elements_of_each_row_pointers = pointers_to_the_first_non_null_elements_of_each_row_pointers;
        return this;
    }

    public SparseMatrixCRS setColumn_indexes(List<Integer> column_indexes) {
        this.column_indexes = column_indexes;
        return this;
    }

    public SparseMatrixCRS setValues(List<Double> values) {
        this.values = values;
        return this;
    }

    public List<Integer> getPointers_to_the_first_non_null_elements_of_each_row_pointers() {
        return pointers_to_the_first_non_null_elements_of_each_row_pointers;
    }

    public List<Integer> getColumn_indexes() {
        return column_indexes;
    }

    public List<Double> getValues() {
        return values;
    }

    @Override
    public int size() {
        return this.size;
    }
}
