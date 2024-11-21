/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.awt.font.TextHitInfo;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.awt.font.TextHitInfo;

public class trailing
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        harness.check(TextHitInfo.trailing(-1).toString(), (Object)"TextHitInfo[-1T]");
        harness.check(TextHitInfo.trailing(0).toString(), (Object)"TextHitInfo[0T]");
        harness.check(TextHitInfo.trailing(1).toString(), (Object)"TextHitInfo[1T]");
    }
}

