/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.awt.GridBagLayout;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.awt.Button;
import java.awt.GridBagLayout;

public class toString
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        GridBagLayout gbl = new GridBagLayout();
        harness.check(gbl.toString(), (Object)"java.awt.GridBagLayout");
        gbl.addLayoutComponent("String", new Button("Button"));
        harness.check(gbl.toString(), (Object)"java.awt.GridBagLayout");
    }
}

