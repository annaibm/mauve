/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.awt.font.TextHitInfo;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.awt.font.TextHitInfo;

public class afterOffset
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        harness.check(TextHitInfo.afterOffset(-6).toString(), (Object)"TextHitInfo[-6L]");
        harness.check(TextHitInfo.afterOffset(0).toString(), (Object)"TextHitInfo[0L]");
        harness.check(TextHitInfo.afterOffset(2).toString(), (Object)"TextHitInfo[2L]");
    }
}

