/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.util.StringTokenizer;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.util.NoSuchElementException;
import java.util.StringTokenizer;

public class nextElement
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        StringTokenizer t = new StringTokenizer("one two three");
        harness.check(t.nextElement(), (Object)"one");
        harness.check(t.nextElement(), (Object)"two");
        harness.check(t.nextElement(), (Object)"three");
        boolean pass = false;
        try {
            t.nextElement();
        }
        catch (NoSuchElementException e) {
            pass = true;
        }
        harness.check(pass);
        t = new StringTokenizer("one two-three", "- ");
        harness.check(t.nextElement(), (Object)"one");
        harness.check(t.nextElement(), (Object)"two");
        harness.check(t.nextElement(), (Object)"three");
        pass = false;
        try {
            t.nextToken();
        }
        catch (NoSuchElementException e) {
            pass = true;
        }
        harness.check(pass);
    }
}

