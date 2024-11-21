/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.awt.font.TextHitInfo;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.awt.font.TextHitInfo;

public class toString
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        TextHitInfo info = TextHitInfo.leading(0);
        harness.check(info.toString(), (Object)"TextHitInfo[0L]");
        info = TextHitInfo.trailing(5);
        harness.check(info.toString(), (Object)"TextHitInfo[5T]");
    }
}

