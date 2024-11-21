/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.swing.plaf.metal.DefaultMetalTheme;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import javax.swing.plaf.metal.DefaultMetalTheme;

public class getName
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        DefaultMetalTheme t = new DefaultMetalTheme();
        harness.check(t.getName(), (Object)"Steel");
    }
}

