/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.swing.plaf.metal.MetalIconFactory.TreeFolderIcon;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import javax.swing.plaf.metal.MetalIconFactory;

public class getAdditionalHeight
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        MetalIconFactory.TreeFolderIcon icon = new MetalIconFactory.TreeFolderIcon();
        harness.check(icon.getAdditionalHeight(), 2);
    }
}

