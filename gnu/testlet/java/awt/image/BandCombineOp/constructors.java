/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.awt.image.BandCombineOp;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.awt.image.BandCombineOp;
import java.awt.image.ImagingOpException;
import java.util.Arrays;

public class constructors
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        this.basicTest(harness);
        this.emptyMatrix(harness);
        this.invalidMatrix(harness);
    }

    private void basicTest(TestHarness harness) {
        int i;
        harness.checkPoint("(constructor)");
        float[][] matrix = new float[][]{{1.0f, 2.0f, 3.0f}, {4.0f, 5.0f, 6.0f}, {7.0f, 8.0f, 9.0f}};
        BandCombineOp op = new BandCombineOp(matrix, null);
        float[][] resultMatrix = op.getMatrix();
        float[][] expectedMatrix = new float[][]{{1.0f, 2.0f, 3.0f, 0.0f}, {4.0f, 5.0f, 6.0f, 0.0f}, {7.0f, 8.0f, 9.0f, 0.0f}};
        if (expectedMatrix.length != resultMatrix.length) {
            harness.check(false);
        } else {
            for (i = 0; i < expectedMatrix.length; ++i) {
                harness.check(Arrays.equals(expectedMatrix[i], resultMatrix[i]));
            }
        }
        matrix = new float[][]{{1.0f, 2.0f, 3.0f, 4.0f}, {4.0f, 5.0f, 6.0f, 7.0f}, {7.0f, 8.0f, 9.0f, 1.0f}};
        op = new BandCombineOp(matrix, null);
        resultMatrix = op.getMatrix();
        expectedMatrix = new float[][]{{1.0f, 2.0f, 3.0f, 4.0f, 0.0f}, {4.0f, 5.0f, 6.0f, 7.0f, 0.0f}, {7.0f, 8.0f, 9.0f, 1.0f, 0.0f}};
        if (expectedMatrix.length != resultMatrix.length) {
            harness.check(false);
        } else {
            for (i = 0; i < expectedMatrix.length; ++i) {
                harness.check(Arrays.equals(expectedMatrix[i], resultMatrix[i]));
            }
        }
    }

    private void emptyMatrix(TestHarness harness) {
        float[][] matrix = new float[][]{new float[0], new float[0]};
        try {
            new BandCombineOp(matrix, null);
            harness.check(true);
        }
        catch (ImagingOpException e) {
            harness.check(false);
        }
        BandCombineOp op = new BandCombineOp(matrix, null);
        float[][] resultMatrix = op.getMatrix();
        float[][] expectedMatrix = new float[][]{{0.0f}, {0.0f}};
        if (expectedMatrix.length != resultMatrix.length) {
            harness.check(false);
        } else {
            for (int i = 0; i < expectedMatrix.length; ++i) {
                harness.check(Arrays.equals(expectedMatrix[i], resultMatrix[i]));
            }
        }
        matrix = new float[][]{null, null};
        try {
            new BandCombineOp(matrix, null);
            harness.check(false);
        }
        catch (NullPointerException e) {
            harness.check(true);
        }
        try {
            new BandCombineOp(null, null);
            harness.check(false);
        }
        catch (NullPointerException e) {
            harness.check(true);
        }
    }

    private void invalidMatrix(TestHarness harness) {
        float[][] matrix = new float[][]{{1.0f, 2.0f, 3.0f, 4.0f}, {4.0f, 5.0f}, {7.0f, 8.0f, 9.0f}};
        try {
            new BandCombineOp(matrix, null);
            harness.check(false);
        }
        catch (ArrayIndexOutOfBoundsException e) {
            harness.check(true);
        }
        matrix = new float[][]{{1.0f, 2.0f}, {4.0f, 5.0f, 6.0f}, {7.0f, 8.0f, 9.0f, 1.0f}};
        BandCombineOp op = new BandCombineOp(matrix, null);
        float[][] resultMatrix = op.getMatrix();
        float[][] expectedMatrix = new float[][]{{1.0f, 2.0f, 0.0f}, {4.0f, 5.0f, 0.0f}, {7.0f, 8.0f, 0.0f}};
        if (expectedMatrix.length != resultMatrix.length) {
            harness.check(false);
        } else {
            for (int i = 0; i < expectedMatrix.length; ++i) {
                harness.check(Arrays.equals(expectedMatrix[i], resultMatrix[i]));
            }
        }
    }
}

