/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.awt.FlowLayout;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.awt.FlowLayout;

public class constructors
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        this.testConstructorNoParams(harness);
        this.testConstructorOneParam(harness);
        this.testConstructorThreeParams(harness);
        this.testConstructorThreeParamsNegativeGaps(harness);
    }

    private void doCheck(TestHarness harness, FlowLayout flowLayout, int alignment, int hgap, int vgap) {
        harness.check(flowLayout.getAlignment(), alignment);
        harness.check(flowLayout.getHgap(), hgap);
        harness.check(flowLayout.getVgap(), vgap);
    }

    private void testConstructorNoParams(TestHarness harness) {
        harness.checkPoint("()");
        FlowLayout flowLayout1 = new FlowLayout();
        this.doCheck(harness, flowLayout1, 1, 5, 5);
    }

    private void testConstructorOneParam(TestHarness harness) {
        harness.checkPoint("(int align)");
        FlowLayout flowLayout2 = new FlowLayout(1);
        this.doCheck(harness, flowLayout2, 1, 5, 5);
        flowLayout2 = new FlowLayout(0);
        this.doCheck(harness, flowLayout2, 0, 5, 5);
        flowLayout2 = new FlowLayout(2);
        harness.check(flowLayout2.getAlignment(), 2);
        this.doCheck(harness, flowLayout2, 2, 5, 5);
    }

    private void testConstructorThreeParams(TestHarness harness) {
        harness.checkPoint("(int align, int hgap, int vgap)");
        FlowLayout flowLayout3 = new FlowLayout(1, 50, 50);
        this.doCheck(harness, flowLayout3, 1, 50, 50);
    }

    private void testConstructorThreeParamsNegativeGaps(TestHarness harness) {
        harness.checkPoint("(int align, int -hgap, int -vgap)");
        FlowLayout flowLayout4 = new FlowLayout(1, -50, 50);
        this.doCheck(harness, flowLayout4, 1, -50, 50);
        flowLayout4 = new FlowLayout(1, 50, -50);
        this.doCheck(harness, flowLayout4, 1, 50, -50);
        flowLayout4 = new FlowLayout(1, -50, -50);
        this.doCheck(harness, flowLayout4, 1, -50, -50);
    }
}

