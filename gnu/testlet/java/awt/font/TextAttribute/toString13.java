/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.awt.font.TextAttribute;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.awt.font.TextAttribute;

public class toString13
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        harness.check(TextAttribute.INPUT_METHOD_UNDERLINE.toString(), (Object)"java.awt.font.TextAttribute(input method underline)");
    }
}

