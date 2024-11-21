/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.swing.text.StyleConstants;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.text.TabSet;
import javax.swing.text.TabStop;

public class setTabSet
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        SimpleAttributeSet s = new SimpleAttributeSet();
        TabStop[] tabs1 = new TabStop[]{new TabStop(8.0f)};
        TabSet ts1 = new TabSet(tabs1);
        StyleConstants.setTabSet(s, ts1);
        harness.check(StyleConstants.getTabSet(s), ts1);
        boolean pass = false;
        try {
            StyleConstants.setTabSet(s, null);
        }
        catch (NullPointerException e) {
            pass = true;
        }
        harness.check(pass);
        pass = false;
        try {
            StyleConstants.setTabSet(null, ts1);
        }
        catch (NullPointerException e) {
            pass = true;
        }
        harness.check(pass);
    }
}

