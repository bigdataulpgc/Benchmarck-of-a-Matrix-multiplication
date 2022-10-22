package benchmarking;

import com.model.MatrixMultiplication;
import com.model.builders.DenseMatrixBuilder;
import com.model.matrixes.DenseMatrix;
import com.model.operations.RowMatrixMultiplication;
import com.model.operations.StandardMultiplication;
import com.model.operations.TransposedMultiplication;
import org.openjdk.jmh.annotations.*;

import java.util.Random;

@BenchmarkMode(Mode.AverageTime)
@Fork(value = 2)
@Warmup(iterations = 3, time = 2)
@Measurement(iterations = 3, time = 2)
public class DenseBenchMark {
    private static final int SIZE = 118;
    private static final Random random = new Random();

    @Benchmark
    public void standardMatrixMultiplication() {
        executeWith(new StandardMultiplication());
    }

    @Benchmark
    public void rowMultiplication() {
        executeWith(new RowMatrixMultiplication());
    }

    @Benchmark
    public void transposedMultiplication() {
        executeWith(new TransposedMultiplication());
    }


    private void executeWith(MatrixMultiplication matrixMultiplication) {
        matrixMultiplication.multiply(createRandomMatrix(SIZE), createRandomMatrix(SIZE));
    }

    private DenseMatrix createRandomMatrix(int size) {
        DenseMatrixBuilder builder = new DenseMatrixBuilder(size, size);
        Random random = new Random();
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                builder.set(i, j, random.nextDouble());
            }
        }
        return builder.toMatrix();
    }


}
