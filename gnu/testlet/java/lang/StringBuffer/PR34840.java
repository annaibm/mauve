/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.lang.StringBuffer;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;

public class PR34840
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        StringBuffer sb = new StringBuffer();
        sb.append("He");
        sb.append((CharSequence)null, 2, 4);
        sb.append("o, wor");
        sb.append((CharSequence)null, 2, 3);
        sb.append("d!");
        harness.check(sb.toString(), "Hello, world!", "Appendable PR34840 check");
    }
}

