/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.swing.text.SimpleAttributeSet;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import javax.swing.text.AttributeSet;
import javax.swing.text.SimpleAttributeSet;

public class getResolveParent
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        harness.checkPoint("getResolveParent()");
        SimpleAttributeSet s = new SimpleAttributeSet();
        harness.check(s.getResolveParent(), null);
        SimpleAttributeSet sParent = new SimpleAttributeSet();
        s.setResolveParent(sParent);
        harness.check(s.getResolveParent(), sParent);
        s.removeAttribute(AttributeSet.ResolveAttribute);
        harness.check(s.getResolveParent(), null);
    }
}

