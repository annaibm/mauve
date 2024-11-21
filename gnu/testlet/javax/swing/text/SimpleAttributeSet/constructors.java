/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.swing.text.SimpleAttributeSet;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import javax.swing.text.SimpleAttributeSet;

public class constructors
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        this.testConstructor1(harness);
        this.testConstructor2(harness);
    }

    public void testConstructor1(TestHarness harness) {
        harness.checkPoint("SimpleAttributeSet()");
        SimpleAttributeSet s = new SimpleAttributeSet();
        harness.check(s.isEmpty(), true);
        harness.check(s.getResolveParent(), null);
    }

    public void testConstructor2(TestHarness harness) {
        harness.checkPoint("SimpleAttributeSet(AttributeSet)");
        SimpleAttributeSet s = new SimpleAttributeSet();
        SimpleAttributeSet s1 = new SimpleAttributeSet(s);
        harness.check(s1.isEmpty(), true);
        harness.check(s1.getResolveParent(), null);
        s.addAttribute("X1", "Y1");
        harness.check(s1.isEmpty());
        harness.check(s1.getResolveParent(), null);
        SimpleAttributeSet s2 = new SimpleAttributeSet(s);
        harness.check(s2.isEmpty(), false);
        harness.check(s2.getResolveParent(), null);
        harness.check(s2.getAttribute("X1"), (Object)"Y1");
        SimpleAttributeSet ss = new SimpleAttributeSet();
        ss.setResolveParent(s);
        ss.addAttribute("X2", "Y2");
        SimpleAttributeSet s3 = new SimpleAttributeSet(ss);
        harness.check(s3.isEmpty(), false);
        harness.check(s3.getResolveParent(), s);
        harness.check(s3.getAttribute("X1"), (Object)"Y1");
        harness.check(s3.getAttribute("X2"), (Object)"Y2");
        boolean pass = false;
        try {
            new SimpleAttributeSet(null);
        }
        catch (NullPointerException e) {
            pass = true;
        }
        harness.check(pass);
    }
}

