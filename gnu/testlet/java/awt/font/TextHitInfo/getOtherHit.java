/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.awt.font.TextHitInfo;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.awt.font.TextHitInfo;

public class getOtherHit
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        TextHitInfo info = TextHitInfo.leading(0);
        harness.check(info.getOtherHit().toString(), (Object)"TextHitInfo[-1T]");
        info = TextHitInfo.trailing(0);
        harness.check(info.getOtherHit().toString(), (Object)"TextHitInfo[1L]");
    }
}

