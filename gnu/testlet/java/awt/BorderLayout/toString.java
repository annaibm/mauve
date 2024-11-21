/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.awt.BorderLayout;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.awt.BorderLayout;

public class toString
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        BorderLayout borderLayout1 = new BorderLayout();
        borderLayout1.toString();
        harness.check(borderLayout1.toString() != null);
        harness.check(borderLayout1.toString(), (Object)"java.awt.BorderLayout[hgap=0,vgap=0]");
        BorderLayout borderLayout2 = new BorderLayout(50, 50);
        borderLayout2.toString();
        harness.check(borderLayout1.toString() != null);
        harness.check(borderLayout2.toString(), (Object)"java.awt.BorderLayout[hgap=50,vgap=50]");
    }
}

