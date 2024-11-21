/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.awt.FontClass;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.awt.Font;

public class decode
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        Font f1 = Font.decode("Dialog-PLAIN-18");
        harness.check(f1.getFamily(), (Object)"Dialog");
        harness.check(f1.getStyle(), 0);
        harness.check(f1.getSize(), 18);
        f1 = Font.decode("Dialog BOLD 16");
        harness.check(f1.getFamily(), (Object)"Dialog");
        harness.check(f1.getStyle(), 1);
        harness.check(f1.getSize(), 16);
        f1 = Font.decode("123-PLAIN-18");
        harness.check(f1.getFamily(), (Object)"Dialog");
        harness.check(f1.getStyle(), 0);
        harness.check(f1.getSize(), 18);
        f1 = Font.decode("Dialog-BoLd-17");
        harness.check(f1.getFamily(), (Object)"Dialog");
        harness.check(f1.getStyle(), 1);
        harness.check(f1.getSize(), 17);
        f1 = Font.decode("Dialog-NotAStyle-18");
        harness.check(f1.getFamily(), (Object)"Dialog");
        harness.check(f1.getStyle(), 0);
        harness.check(f1.getSize(), 18);
        f1 = Font.decode("Dialog-BOLDITALIC-ZZ");
        harness.check(f1.getFamily(), (Object)"Dialog");
        harness.check(f1.getStyle(), 3);
        harness.check(f1.getSize(), 12);
        f1 = Font.decode("Dialog");
        harness.check(f1.getFamily(), (Object)"Dialog");
        harness.check(f1.getStyle(), 0);
        harness.check(f1.getSize(), 12);
        f1 = Font.decode(null);
        harness.check(f1.getFamily(), (Object)"Dialog");
        harness.check(f1.getStyle(), 0);
        harness.check(f1.getSize(), 12);
    }
}

