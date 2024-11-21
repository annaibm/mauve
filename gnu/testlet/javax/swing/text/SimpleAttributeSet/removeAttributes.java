/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.swing.text.SimpleAttributeSet;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.util.Enumeration;
import java.util.Vector;
import javax.swing.text.AttributeSet;
import javax.swing.text.SimpleAttributeSet;

public class removeAttributes
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        this.test1(harness);
        this.test2(harness);
    }

    public void test1(TestHarness harness) {
        harness.checkPoint("(AttributeSet)");
        SimpleAttributeSet s = new SimpleAttributeSet();
        s.addAttribute("A", "1");
        s.addAttribute("B", "2");
        s.addAttribute("C", "3");
        s.addAttribute("D", "4");
        s.addAttribute("E", "5");
        s.addAttribute("F", "6");
        harness.check(s.getAttributeCount(), 6);
        SimpleAttributeSet ss = new SimpleAttributeSet();
        ss.addAttribute("A", "1");
        ss.addAttribute("C", "3");
        ss.addAttribute("E", "5");
        s.removeAttributes(ss);
        harness.check(s.getAttributeCount(), 3);
        harness.check(s.getAttribute("B"), (Object)"2");
        harness.check(s.getAttribute("D"), (Object)"4");
        harness.check(s.getAttribute("F"), (Object)"6");
        SimpleAttributeSet sss = new SimpleAttributeSet();
        ss.addAttribute("B", "XXX");
        s.removeAttributes(sss);
        harness.check(s.getAttributeCount(), 3);
        harness.check(s.getAttribute("B"), (Object)"2");
        harness.check(s.getAttribute("D"), (Object)"4");
        harness.check(s.getAttribute("F"), (Object)"6");
        SimpleAttributeSet s2 = new SimpleAttributeSet();
        SimpleAttributeSet sParent = new SimpleAttributeSet();
        s2.setResolveParent(sParent);
        harness.check(s2.getResolveParent(), sParent);
        SimpleAttributeSet s3 = new SimpleAttributeSet();
        s3.setResolveParent(sParent);
        s2.removeAttributes(s3);
        harness.check(s2.getResolveParent(), null);
        boolean pass = false;
        try {
            s.removeAttributes((AttributeSet)null);
        }
        catch (NullPointerException ex) {
            pass = true;
        }
        harness.check(pass);
    }

    public void test2(TestHarness harness) {
        harness.checkPoint("(Enumeration)");
        SimpleAttributeSet s = new SimpleAttributeSet();
        s.addAttribute("A", "1");
        s.addAttribute("B", "2");
        s.addAttribute("C", "3");
        s.addAttribute("D", "4");
        s.addAttribute("E", "5");
        s.addAttribute("F", "6");
        harness.check(s.getAttributeCount(), 6);
        Vector<String> v = new Vector<String>();
        v.add("B");
        v.add("D");
        v.add("F");
        Enumeration e = v.elements();
        s.removeAttributes(e);
        harness.check(s.getAttributeCount(), 3);
        harness.check(s.getAttribute("A"), (Object)"1");
        harness.check(s.getAttribute("C"), (Object)"3");
        harness.check(s.getAttribute("E"), (Object)"5");
        boolean pass = false;
        try {
            v.clear();
            v.add(null);
            e = v.elements();
            s.removeAttributes(e);
        }
        catch (NullPointerException ex) {
            pass = true;
        }
        harness.check(pass);
        pass = false;
        try {
            s.removeAttributes((Enumeration)null);
        }
        catch (NullPointerException ex) {
            pass = true;
        }
        harness.check(pass);
    }
}

