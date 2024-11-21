/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.awt.font.TextHitInfo;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.awt.font.TextHitInfo;

public class leading
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        harness.check(TextHitInfo.leading(-1).toString(), (Object)"TextHitInfo[-1L]");
        harness.check(TextHitInfo.leading(0).toString(), (Object)"TextHitInfo[0L]");
        harness.check(TextHitInfo.leading(1).toString(), (Object)"TextHitInfo[1L]");
    }
}

