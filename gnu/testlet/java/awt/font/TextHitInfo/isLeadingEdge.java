/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.awt.font.TextHitInfo;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.awt.font.TextHitInfo;

public class isLeadingEdge
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        TextHitInfo info = TextHitInfo.leading(-2);
        harness.check(info.isLeadingEdge(), true);
        info = TextHitInfo.leading(0);
        harness.check(info.isLeadingEdge(), true);
        info = TextHitInfo.leading(4);
        harness.check(info.isLeadingEdge(), true);
        info = TextHitInfo.trailing(-2);
        harness.check(info.isLeadingEdge(), false);
        info = TextHitInfo.trailing(0);
        harness.check(info.isLeadingEdge(), false);
        info = TextHitInfo.trailing(4);
        harness.check(info.isLeadingEdge(), false);
        harness.check(TextHitInfo.leading(1).isLeadingEdge(), true);
        harness.check(TextHitInfo.trailing(1).isLeadingEdge(), false);
    }
}

