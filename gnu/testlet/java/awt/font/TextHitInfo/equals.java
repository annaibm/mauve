/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.awt.font.TextHitInfo;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.awt.font.TextHitInfo;

public class equals
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        this.equalsObject(harness);
        this.equalsTextHitInfo(harness);
    }

    public void equalsObject(TestHarness harness) {
        TextHitInfo info = TextHitInfo.trailing(0);
        harness.check(info.equals((Object)null), false);
        harness.check(info.equals((Object)TextHitInfo.trailing(0)), true);
        String a = "Some String";
        harness.check(info.equals(a), false);
    }

    public void equalsTextHitInfo(TestHarness harness) {
        TextHitInfo info = TextHitInfo.trailing(0);
        harness.check(info.equals(null), false);
        harness.check(info.equals(TextHitInfo.trailing(0)), true);
        harness.check(info.equals(TextHitInfo.trailing(1)), false);
        harness.check(info.equals(TextHitInfo.leading(0)), false);
        harness.check(info.equals(TextHitInfo.leading(1)), false);
    }
}

