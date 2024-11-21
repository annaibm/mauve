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

public class getIcon
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        SimpleAttributeSet s = new SimpleAttributeSet();
        harness.check(StyleConstants.getIcon(s), null);
        Icon icon1 = MetalIconFactory.getFileChooserHomeFolderIcon();
        StyleConstants.setIcon(s, icon1);
        harness.check(StyleConstants.getIcon(s), icon1);
        s.removeAttribute(StyleConstants.IconAttribute);
        SimpleAttributeSet parent = new SimpleAttributeSet();
        s.setResolveParent(parent);
        Icon icon2 = MetalIconFactory.getFileChooserNewFolderIcon();
        StyleConstants.setIcon(parent, icon2);
        harness.check(StyleConstants.getIcon(s), icon2);
        boolean pass = false;
        try {
            StyleConstants.getIcon(null);
        }
        catch (NullPointerException e) {
            pass = true;
        }
        harness.check(pass);
    }
}

