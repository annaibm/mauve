/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.awt.image.SampleModel;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.awt.image.SampleModel;
import java.awt.image.SinglePixelPackedSampleModel;

public class getSampleSize
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        this.test1(harness);
        this.test2(harness);
    }

    public void test1(TestHarness harness) {
        harness.checkPoint("()");
        SinglePixelPackedSampleModel m = new SinglePixelPackedSampleModel(0, 10, 20, new int[]{224, 28, 3});
        int[] s = ((SampleModel)m).getSampleSize();
        harness.check(s.length, 3);
        harness.check(s[0], 3);
        harness.check(s[1], 3);
        harness.check(s[2], 2);
    }

    public void test2(TestHarness harness) {
        harness.checkPoint("(int)");
        SinglePixelPackedSampleModel m = new SinglePixelPackedSampleModel(0, 10, 20, new int[]{224, 28, 3});
        harness.check(((SampleModel)m).getSampleSize(0), 3);
        harness.check(((SampleModel)m).getSampleSize(1), 3);
        harness.check(((SampleModel)m).getSampleSize(2), 2);
        boolean pass = false;
        try {
            ((SampleModel)m).getSampleSize(-1);
        }
        catch (ArrayIndexOutOfBoundsException e) {
            pass = true;
        }
        harness.check(pass);
        pass = false;
        try {
            ((SampleModel)m).getSampleSize(3);
        }
        catch (ArrayIndexOutOfBoundsException e) {
            pass = true;
        }
        harness.check(pass);
    }
}

