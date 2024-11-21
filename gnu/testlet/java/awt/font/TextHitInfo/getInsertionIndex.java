/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.awt.font.TextHitInfo;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.awt.font.TextHitInfo;

public class getInsertionIndex
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        TextHitInfo info = TextHitInfo.leading(-2);
        harness.check(info.getInsertionIndex(), -2);
        info = TextHitInfo.leading(0);
        harness.check(info.getInsertionIndex(), 0);
        info = TextHitInfo.leading(4);
        harness.check(info.getInsertionIndex(), 4);
        info = TextHitInfo.trailing(-2);
        harness.check(info.getInsertionIndex(), -1);
        info = TextHitInfo.trailing(0);
        harness.check(info.getInsertionIndex(), 1);
        info = TextHitInfo.trailing(4);
        harness.check(info.getInsertionIndex(), 5);
        harness.check(TextHitInfo.leading(1).getInsertionIndex(), 1);
        harness.check(TextHitInfo.trailing(1).getInsertionIndex(), 2);
    }
}

