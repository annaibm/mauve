/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.awt.FlowLayout;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.awt.FlowLayout;

public class toString
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        this.testConstructorNoParams(harness);
        this.testConstructorOneParam(harness);
        this.testConstructorThreeParams(harness);
    }

    private void testConstructorNoParams(TestHarness harness) {
        harness.checkPoint("()");
        FlowLayout flowLayout1 = new FlowLayout();
        flowLayout1.toString();
        harness.check(flowLayout1.toString() != null);
        harness.check(flowLayout1.toString(), (Object)"java.awt.FlowLayout[hgap=5,vgap=5,align=center]");
    }

    private void testConstructorOneParam(TestHarness harness) {
        harness.checkPoint("(int align)");
        FlowLayout flowLayout2 = new FlowLayout(1);
        flowLayout2.toString();
        harness.check(flowLayout2.toString() != null);
        harness.check(flowLayout2.toString(), (Object)"java.awt.FlowLayout[hgap=5,vgap=5,align=center]");
        flowLayout2 = new FlowLayout(0);
        flowLayout2.toString();
        harness.check(flowLayout2.toString() != null);
        harness.check(flowLayout2.toString(), (Object)"java.awt.FlowLayout[hgap=5,vgap=5,align=left]");
        flowLayout2 = new FlowLayout(2);
        flowLayout2.toString();
        harness.check(flowLayout2.toString() != null);
        harness.check(flowLayout2.toString(), (Object)"java.awt.FlowLayout[hgap=5,vgap=5,align=right]");
    }

    private void testConstructorThreeParams(TestHarness harness) {
        harness.checkPoint("(int align, int hgap, int vgap)");
        FlowLayout flowLayout3 = new FlowLayout(1, 50, 50);
        flowLayout3.toString();
        harness.check(flowLayout3.toString() != null);
        harness.check(flowLayout3.toString(), (Object)"java.awt.FlowLayout[hgap=50,vgap=50,align=center]");
    }
}

