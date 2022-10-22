import com.model.deserializer.COOfromMTXtoSparseMatrixCCSObjectDeserializer;
import com.model.deserializer.COOfromMTXtoSparseMatrixCRSObjectDeserializer;
import com.model.matrixes.SparseMatrixCCS;
import com.model.matrixes.SparseMatrixCOO;
import com.model.matrixes.SparseMatrixCRS;
import com.model.operations.SparseMatrixMultiplication;
import org.junit.Test;

import java.io.IOException;


public class BigSparseMultiplicationTest {
    public int size;


    @Test
    public void multiply_two_MTX_Compressed_Matrix() throws IOException {

        COOfromMTXtoSparseMatrixCRSObjectDeserializer deserializer2 = new COOfromMTXtoSparseMatrixCRSObjectDeserializer();
        SparseMatrixCRS m2 = deserializer2.deserialize(System.getProperty("user.dir") + "/src/test/mtx/pdb1HYS.mtx");

        COOfromMTXtoSparseMatrixCCSObjectDeserializer deserializer3 = new COOfromMTXtoSparseMatrixCCSObjectDeserializer();
        SparseMatrixCCS m3 = deserializer3.deserialize(System.getProperty("user.dir") + "/src/test/mtx/pdb1HYS.mtx");

        SparseMatrixMultiplication sparseMatrixMultiplication = new SparseMatrixMultiplication();
        SparseMatrixCOO m4 = sparseMatrixMultiplication.multiply(m2, m3);

    }
}