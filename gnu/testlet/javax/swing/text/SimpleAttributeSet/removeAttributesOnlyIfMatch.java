/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.swing.text.SimpleAttributeSet;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import javax.swing.text.SimpleAttributeSet;

public class removeAttributesOnlyIfMatch
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        SimpleAttributeSet set1 = new SimpleAttributeSet();
        SimpleAttributeSet set2 = new SimpleAttributeSet();
        set1.addAttribute("hello", "hello");
        set2.addAttribute("hello", "goodbye");
        set1.removeAttributes(set2);
        harness.check(set1.containsAttribute("hello", "hello"));
    }
}

