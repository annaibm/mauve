/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.awt.font.TextHitInfo;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.awt.font.TextHitInfo;

public class getOffsetHit
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        TextHitInfo info = TextHitInfo.leading(0);
        harness.check(info.getOffsetHit(0).toString(), (Object)"TextHitInfo[0L]");
        harness.check(info.isLeadingEdge(), true);
        info = TextHitInfo.leading(0);
        harness.check(info.getOffsetHit(-2).toString(), (Object)"TextHitInfo[-2L]");
        harness.check(info.isLeadingEdge(), true);
        info = TextHitInfo.leading(0);
        harness.check(info.getOffsetHit(2).toString(), (Object)"TextHitInfo[2L]");
        harness.check(info.isLeadingEdge(), true);
        info = TextHitInfo.trailing(0);
        harness.check(info.getOffsetHit(0).toString(), (Object)"TextHitInfo[0T]");
        harness.check(info.isLeadingEdge(), false);
        info = TextHitInfo.trailing(0);
        harness.check(info.getOffsetHit(-2).toString(), (Object)"TextHitInfo[-2T]");
        harness.check(info.isLeadingEdge(), false);
        info = TextHitInfo.trailing(0);
        harness.check(info.getOffsetHit(2).toString(), (Object)"TextHitInfo[2T]");
        harness.check(info.isLeadingEdge(), false);
    }
}

