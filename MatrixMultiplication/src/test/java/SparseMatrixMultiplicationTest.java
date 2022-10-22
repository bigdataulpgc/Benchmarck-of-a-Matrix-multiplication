import com.model.deserializer.COOfromMTXtoDenseMatrixObjectDeserializer;
import com.model.deserializer.COOfromMTXtoSparseMatrixCRSObjectDeserializer;
import com.model.matrixes.DenseMatrix;
import com.model.matrixes.SparseMatrixCOO;
import com.model.matrixes.SparseMatrixCRS;
import com.model.deserializer.COOfromMTXtoSparseMatrixCCSObjectDeserializer;
import com.model.matrixes.SparseMatrixCCS;
import com.model.operations.RowMatrixMultiplication;
import com.model.operations.SparseMatrixMultiplication;
import org.assertj.core.api.Assertions;
import org.junit.Test;
import com.model.builders.DenseMatrixBuilder;

import java.io.IOException;

public class SparseMatrixMultiplicationTest {


    @Test
    public void multiply_two_sparse_matrix() throws IOException {
        COOfromMTXtoSparseMatrixCRSObjectDeserializer deserializer = new COOfromMTXtoSparseMatrixCRSObjectDeserializer();
        COOfromMTXtoSparseMatrixCCSObjectDeserializer deserializer2 = new COOfromMTXtoSparseMatrixCCSObjectDeserializer();
        COOfromMTXtoDenseMatrixObjectDeserializer deserializer3 = new COOfromMTXtoDenseMatrixObjectDeserializer();


        String filename = System.getProperty("user.dir") + "/src/test/mtx/paper.mtx";

        SparseMatrixCRS a = deserializer.deserialize(filename);
        SparseMatrixCCS b = deserializer2.deserialize(filename);


        SparseMatrixMultiplication sparseMatrixMultiplication = new SparseMatrixMultiplication();
        SparseMatrixCOO c = sparseMatrixMultiplication.multiply(a,b);

        DenseMatrix a1 = deserializer3.deserialize(filename);
        DenseMatrix c1 = sparseMatrixCOOtoDenseMatrix(c);

        Vector vector = new Vector(c1.size());
        Assertions.assertThat(vector.multiply(c1)).isEqualTo(vector.multiply(a1).multiply(a1));

    }

    @Test
    public void multiply_two_big_sparse_matrix() throws IOException {
        COOfromMTXtoSparseMatrixCRSObjectDeserializer deserializer = new COOfromMTXtoSparseMatrixCRSObjectDeserializer();
        COOfromMTXtoSparseMatrixCCSObjectDeserializer deserializer2 = new COOfromMTXtoSparseMatrixCCSObjectDeserializer();
        COOfromMTXtoDenseMatrixObjectDeserializer deserializer3 = new COOfromMTXtoDenseMatrixObjectDeserializer();


        String filename = System.getProperty("user.dir") + "/src/test/mtx/pdb1HYS.mtx";

        SparseMatrixCRS a = deserializer.deserialize(filename);
        SparseMatrixCCS b = deserializer2.deserialize(filename);


        SparseMatrixMultiplication sparseMatrixMultiplication = new SparseMatrixMultiplication();
        SparseMatrixCOO c = sparseMatrixMultiplication.multiply(a,b);

        DenseMatrix a1 = deserializer3.deserialize(filename);
        DenseMatrix c1 = sparseMatrixCOOtoDenseMatrix(c);

        Vector vector = new Vector(c1.size());
        Assertions.assertThat(vector.multiply(c1)).isEqualTo(vector.multiply(a1).multiply(a1));



    }

    public DenseMatrix sparseMatrixCOOtoDenseMatrix(SparseMatrixCOO matrix) {

        DenseMatrixBuilder new_matrix = new DenseMatrixBuilder(matrix.size(), matrix.size());
        for (int i = 0; i < matrix.getValues().size(); i++) {
            new_matrix.set(matrix.getRow_indexes().get(i), matrix.getColumn_indexes().get(i), matrix.getValues().get(i));
        }

        return new_matrix.toMatrix();
    }

}
