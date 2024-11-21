/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.awt.GridLayout;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.awt.GridLayout;

public class toString
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        GridLayout gridLayout1 = new GridLayout();
        gridLayout1.toString();
        harness.check(gridLayout1.toString(), (Object)"java.awt.GridLayout[hgap=0,vgap=0,rows=1,cols=0]");
        GridLayout gridLayout2 = new GridLayout(50, 50);
        gridLayout2.toString();
        harness.check(gridLayout2.toString(), (Object)"java.awt.GridLayout[hgap=0,vgap=0,rows=50,cols=50]");
        GridLayout gridLayout3 = new GridLayout(50, 50, 10, 20);
        gridLayout3.toString();
        harness.check(gridLayout3.toString(), (Object)"java.awt.GridLayout[hgap=10,vgap=20,rows=50,cols=50]");
    }
}

