/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.awt.image.PixelInterleavedSampleModel;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.awt.image.PixelInterleavedSampleModel;
import java.awt.image.SampleModel;

public class createSubsetSampleModel
implements Testlet {
    @Override
    public void test(TestHarness h) {
        PixelInterleavedSampleModel psm = new PixelInterleavedSampleModel(0, 5, 2, 4, 20, new int[]{3, 0, 1});
        SampleModel sm = psm.createSubsetSampleModel(new int[]{0, 2});
        if (!(sm instanceof PixelInterleavedSampleModel)) {
            h.check(false);
            h.debug(String.valueOf(sm));
            return;
        }
        h.check(true);
        PixelInterleavedSampleModel sub = (PixelInterleavedSampleModel)sm;
        h.check(sub.getDataType(), 0);
        h.check(sub.getWidth(), 5);
        h.check(sub.getHeight(), 2);
        h.check(sub.getPixelStride(), 4);
        h.check(sub.getScanlineStride(), 20);
        int[] subBands = sub.getBandOffsets();
        h.check(subBands.length, 2);
        h.check(subBands[0], 3);
        h.check(subBands[1], 1);
    }
}

