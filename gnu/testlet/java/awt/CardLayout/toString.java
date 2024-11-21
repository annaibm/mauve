/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.awt.CardLayout;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.awt.CardLayout;

public class toString
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        CardLayout cardLayout1 = new CardLayout();
        cardLayout1.toString();
        harness.check(cardLayout1.toString() != null);
        harness.check(cardLayout1.toString(), (Object)"java.awt.CardLayout[hgap=0,vgap=0]");
        CardLayout cardLayout2 = new CardLayout(50, 50);
        cardLayout2.toString();
        harness.check(cardLayout1.toString() != null);
        harness.check(cardLayout2.toString(), (Object)"java.awt.CardLayout[hgap=50,vgap=50]");
    }
}

