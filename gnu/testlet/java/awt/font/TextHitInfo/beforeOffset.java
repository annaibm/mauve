/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.awt.font.TextHitInfo;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.awt.font.TextHitInfo;

public class beforeOffset
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        harness.check(TextHitInfo.beforeOffset(-6).toString(), (Object)"TextHitInfo[-7T]");
        harness.check(TextHitInfo.beforeOffset(0).toString(), (Object)"TextHitInfo[-1T]");
        harness.check(TextHitInfo.beforeOffset(2).toString(), (Object)"TextHitInfo[1T]");
    }
}

