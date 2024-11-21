/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.swing.text.SimpleAttributeSet;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import javax.swing.text.SimpleAttributeSet;

public class containsAttributes
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        harness.checkPoint("containsAttributes()");
        SimpleAttributeSet s = new SimpleAttributeSet();
        SimpleAttributeSet atts = new SimpleAttributeSet();
        harness.check(s.containsAttributes(atts), true);
        atts.addAttribute("E", "5");
        harness.check(s.containsAttributes(atts), false);
        s.addAttribute("A", "1");
        s.addAttribute("B", "2");
        s.addAttribute("C", "3");
        s.addAttribute("D", "4");
        s.addAttribute("E", "5");
        s.addAttribute("F", "6");
        harness.check(s.containsAttributes(atts), true);
        atts.addAttribute("E", "XXX");
        harness.check(s.containsAttributes(atts), false);
        atts.removeAttribute("E");
        harness.check(s.containsAttributes(atts), true);
        atts.addAttribute("A", "1");
        atts.addAttribute("D", "4");
        atts.addAttribute("E", "5");
        harness.check(s.containsAttributes(atts), true);
        atts.addAttribute("D", "XXX");
        harness.check(s.containsAttributes(atts), false);
        s = new SimpleAttributeSet();
        SimpleAttributeSet sParent = new SimpleAttributeSet();
        s.setResolveParent(sParent);
        atts = new SimpleAttributeSet();
        harness.check(s.containsAttributes(atts), true);
        atts.setResolveParent(sParent);
        harness.check(s.containsAttributes(atts), true);
        sParent.addAttribute("X", "1");
        atts.addAttribute("X", "1");
        harness.check(s.containsAttributes(atts));
        boolean pass = false;
        try {
            s.containsAttributes(null);
        }
        catch (NullPointerException e) {
            pass = true;
        }
        harness.check(pass);
    }
}

