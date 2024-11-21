/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.swing.text.StyleConstants;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import javax.swing.Icon;
import javax.swing.plaf.metal.MetalIconFactory;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;

public class setIcon
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        SimpleAttributeSet s = new SimpleAttributeSet();
        Icon icon1 = MetalIconFactory.getTreeComputerIcon();
        StyleConstants.setIcon(s, icon1);
        harness.check(StyleConstants.getIcon(s), icon1);
        boolean pass = false;
        try {
            StyleConstants.setIcon(s, null);
        }
        catch (NullPointerException e) {
            pass = true;
        }
        harness.check(pass);
        pass = false;
        try {
            StyleConstants.setIcon(null, icon1);
        }
        catch (NullPointerException e) {
            pass = true;
        }
        harness.check(pass);
    }
}

