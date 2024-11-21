/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.swing.SizeRequirements;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import javax.swing.SizeRequirements;

public class calculateAlignedPositions
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        this.test1(harness);
    }

    private void test1(TestHarness harness) {
        SizeRequirements req1 = new SizeRequirements(282, 282, 282, 0.5f);
        SizeRequirements req2 = new SizeRequirements(599, 599, Integer.MAX_VALUE, 0.5f);
        SizeRequirements[] els = new SizeRequirements[]{req1, req2};
        SizeRequirements total = SizeRequirements.getAlignedSizeRequirements(els);
        int[] offsets = new int[2];
        int[] spans2 = new int[2];
        SizeRequirements.calculateAlignedPositions(112, total, els, offsets, spans2);
        harness.check(offsets[0], 0);
        harness.check(offsets[1], 0);
        harness.check(spans2[0], 112);
        harness.check(spans2[1], 112);
    }
}

