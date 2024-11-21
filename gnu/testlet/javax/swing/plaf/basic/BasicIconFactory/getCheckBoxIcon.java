/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.swing.plaf.basic.BasicIconFactory;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import javax.swing.Icon;
import javax.swing.plaf.basic.BasicIconFactory;

public class getCheckBoxIcon
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        Icon icon = BasicIconFactory.getCheckBoxIcon();
        harness.check(icon.getIconWidth(), 13);
        harness.check(icon.getIconHeight(), 13);
    }
}

