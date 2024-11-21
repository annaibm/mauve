/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.swing.plaf.metal.DefaultMetalTheme;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import javax.swing.UIManager;
import javax.swing.plaf.FontUIResource;
import javax.swing.plaf.metal.DefaultMetalTheme;

public class getSubTextFont
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        DefaultMetalTheme t = new DefaultMetalTheme();
        FontUIResource f = t.getSubTextFont();
        harness.check(f, new FontUIResource("Dialog", 0, 10));
        FontUIResource f2 = t.getSubTextFont();
        harness.check(f == f2);
        UIManager.put("swing.boldMetal", Boolean.TRUE);
        f = t.getSubTextFont();
        harness.check(f, new FontUIResource("Dialog", 0, 10));
        DefaultMetalTheme t2 = new DefaultMetalTheme();
        f = t2.getSubTextFont();
        harness.check(f, new FontUIResource("Dialog", 0, 10));
        UIManager.put("swing.boldMetal", Boolean.FALSE);
        DefaultMetalTheme t3 = new DefaultMetalTheme();
        f = t3.getSubTextFont();
        harness.check(f, new FontUIResource("Dialog", 0, 10));
        UIManager.put("swing.boldMetal", null);
        DefaultMetalTheme t4 = new DefaultMetalTheme();
        f = t4.getSubTextFont();
        harness.check(f, new FontUIResource("Dialog", 0, 10));
    }
}

