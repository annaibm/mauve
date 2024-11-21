/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.swing.text.SimpleAttributeSet;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import javax.swing.text.SimpleAttributeSet;

public class clone
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        harness.checkPoint("clone()");
        SimpleAttributeSet s1 = new SimpleAttributeSet();
        SimpleAttributeSet s2 = (SimpleAttributeSet)s1.clone();
        harness.check(s1.equals(s2));
        s1.addAttribute("X1", "Y1");
        harness.check(!s1.equals(s2));
        s2 = (SimpleAttributeSet)s1.clone();
        harness.check(s1.equals(s2));
        s1.addAttribute("X2", "Y2");
        harness.check(!s1.equals(s2));
        SimpleAttributeSet s3 = new SimpleAttributeSet();
        s3.addAttribute("A1", "B1");
        s1.setResolveParent(s3);
        s2 = (SimpleAttributeSet)s1.clone();
        harness.check(s1.equals(s2));
        s3.addAttribute("A1", "BB");
        harness.check(s1.equals(s2));
        s1.addAttribute("Y1", "-");
        harness.check(!s1.equals(s2));
    }
}

