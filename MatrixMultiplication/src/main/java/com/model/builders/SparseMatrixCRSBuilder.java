package com.model.builders;
import com.model.Builder;
import com.model.matrixes.SparseMatrixCRS;
import java.util.ArrayList;
import java.util.List;

public class SparseMatrixCRSBuilder implements Builder {

    private final List<Integer> pointers_to_the_first_non_null_elements_of_each_row_pointers = new ArrayList<>();
    private final List<Integer> column_indexes = new ArrayList<>();
    private final List<Double> values = new ArrayList<>();

    int size;
    public SparseMatrixCRSBuilder(int size) {
        this.size = size;
    }

    public void addRowPrt(int row_prt) {
        pointers_to_the_first_non_null_elements_of_each_row_pointers.add(row_prt);
    }

    public void addColumnIndex(int column_ind) {
        column_indexes.add(column_ind);
    }

    public void addValue(double value) {
        values.add(value);
    }

    @Override
    public SparseMatrixCRS toMatrix() {
        return new SparseMatrixCRS(this.size)
                .setPointers_to_the_first_non_null_elements_of_each_row_pointers(pointers_to_the_first_non_null_elements_of_each_row_pointers)
                .setColumn_indexes(column_indexes)
                .setValues(values);
    }
}


