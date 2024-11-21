/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.swing.text.SimpleAttributeSet;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import javax.swing.text.SimpleAttributeSet;

public class setResolveParent
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        harness.checkPoint("setResolveParent()");
        SimpleAttributeSet s = new SimpleAttributeSet();
        harness.check(s.getResolveParent(), null);
        SimpleAttributeSet sParent = new SimpleAttributeSet();
        s.setResolveParent(sParent);
        harness.check(s.getResolveParent(), sParent);
        boolean pass = false;
        try {
            s.setResolveParent(null);
        }
        catch (NullPointerException e) {
            pass = true;
        }
        harness.check(pass);
    }
}

