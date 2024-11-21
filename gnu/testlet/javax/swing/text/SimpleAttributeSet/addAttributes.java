/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.swing.text.SimpleAttributeSet;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import javax.swing.text.SimpleAttributeSet;

public class addAttributes
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        harness.checkPoint("addAttributes()");
        SimpleAttributeSet s = new SimpleAttributeSet();
        s.addAttributes(SimpleAttributeSet.EMPTY);
        harness.check(s.isEmpty());
        SimpleAttributeSet atts1 = new SimpleAttributeSet();
        atts1.addAttribute("A1", "B1");
        atts1.addAttribute("A2", "B2");
        s.addAttributes(atts1);
        harness.check(s.getAttributeCount(), 2);
        harness.check(s.containsAttribute("A1", "B1"));
        harness.check(s.containsAttribute("A2", "B2"));
        SimpleAttributeSet atts2 = new SimpleAttributeSet();
        atts2.addAttribute("C1", "D1");
        atts1.addAttribute("A1", "BB1");
        atts1.addAttribute("A2", "BB2");
        atts1.setResolveParent(atts2);
        s.addAttributes(atts1);
        harness.check(s.getResolveParent(), atts2);
        harness.check(s.getAttributeCount(), 3);
        harness.check(s.containsAttribute("A1", "BB1"));
        harness.check(s.containsAttribute("A2", "BB2"));
        harness.check(s.containsAttribute("C1", "D1"));
        boolean pass = false;
        try {
            s.addAttributes(null);
        }
        catch (NullPointerException e) {
            pass = true;
        }
        harness.check(pass);
    }
}

