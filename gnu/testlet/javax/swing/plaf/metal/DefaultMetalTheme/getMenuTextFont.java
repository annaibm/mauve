/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.swing.plaf.metal.DefaultMetalTheme;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import javax.swing.UIManager;
import javax.swing.plaf.FontUIResource;
import javax.swing.plaf.metal.DefaultMetalTheme;

public class getMenuTextFont
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        DefaultMetalTheme t = new DefaultMetalTheme();
        FontUIResource f = t.getMenuTextFont();
        harness.check(f, new FontUIResource("Dialog", 1, 12));
        FontUIResource f2 = t.getMenuTextFont();
        harness.check(f == f2);
        UIManager.put("swing.boldMetal", Boolean.FALSE);
        f = t.getMenuTextFont();
        harness.check(f, new FontUIResource("Dialog", 1, 12));
        DefaultMetalTheme t2 = new DefaultMetalTheme();
        f = t2.getMenuTextFont();
        harness.check(f, new FontUIResource("Dialog", 0, 12));
        UIManager.put("swing.boldMetal", Boolean.TRUE);
        DefaultMetalTheme t3 = new DefaultMetalTheme();
        f = t3.getMenuTextFont();
        harness.check(f, new FontUIResource("Dialog", 1, 12));
        UIManager.put("swing.boldMetal", null);
        DefaultMetalTheme t4 = new DefaultMetalTheme();
        f = t4.getMenuTextFont();
        harness.check(f, new FontUIResource("Dialog", 1, 12));
    }
}

