/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.swing.plaf.basic.BasicIconFactory;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import javax.swing.Icon;
import javax.swing.plaf.basic.BasicIconFactory;

public class getMenuArrowIcon
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        Icon icon = BasicIconFactory.getMenuArrowIcon();
        harness.check(icon.getIconWidth(), 4);
        harness.check(icon.getIconHeight(), 8);
    }
}

