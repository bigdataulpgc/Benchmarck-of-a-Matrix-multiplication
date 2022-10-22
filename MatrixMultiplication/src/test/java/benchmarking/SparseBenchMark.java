package benchmarking;
import com.model.deserializer.COOfromMTXtoSparseMatrixCCSObjectDeserializer;
import com.model.deserializer.COOfromMTXtoSparseMatrixCRSObjectDeserializer;
import com.model.matrixes.SparseMatrixCCS;
import com.model.matrixes.SparseMatrixCOO;
import com.model.matrixes.SparseMatrixCRS;
import com.model.operations.SparseMatrixMultiplication;
import org.openjdk.jmh.annotations.*;

import java.io.IOException;

@BenchmarkMode(Mode.AverageTime)
@Fork(value = 2)
@Warmup(iterations = 3, time = 2)
@Measurement(iterations = 3, time = 2)
public class SparseBenchMark {

    public static COOfromMTXtoSparseMatrixCRSObjectDeserializer deserializer2 = new COOfromMTXtoSparseMatrixCRSObjectDeserializer();

    public static SparseMatrixCRS m2;

    static {
        //String filename = System.getProperty("user.dir") + "/src/test/mtx/mc2depi.mtx";
        String filename = System.getProperty("user.dir") + "/src/test/mtx/pdb1HYS.mtx";
        try {
            m2 = deserializer2.deserialize(filename);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static COOfromMTXtoSparseMatrixCCSObjectDeserializer deserializer3 = new COOfromMTXtoSparseMatrixCCSObjectDeserializer();

    public static SparseMatrixCCS m3;

    static {
        String filename = System.getProperty("user.dir") + "/src/test/mtx/pdb1HYS.mtx";
        try {
            m3 = deserializer3.deserialize(filename);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Benchmark
    public static void BigCompressedSparseMatrixMultiplication() {
        SparseMatrixMultiplication sparseMatrixMultiplication = new SparseMatrixMultiplication();
        SparseMatrixCOO matrix5 = sparseMatrixMultiplication.multiply(m2, m3);
    }
}