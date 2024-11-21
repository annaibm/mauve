/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.util.StringTokenizer;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.util.NoSuchElementException;
import java.util.StringTokenizer;

public class nextToken
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        this.test1(harness);
        this.test2(harness);
    }

    private void test1(TestHarness harness) {
        harness.checkPoint("nextToken()");
        StringTokenizer t = new StringTokenizer("one two three");
        harness.check(t.nextToken(), (Object)"one");
        harness.check(t.nextToken(), (Object)"two");
        harness.check(t.nextToken(), (Object)"three");
        boolean pass = false;
        try {
            t.nextToken();
        }
        catch (NoSuchElementException e) {
            pass = true;
        }
        harness.check(pass);
        t = new StringTokenizer("one two-three", "- ");
        harness.check(t.nextToken(), (Object)"one");
        harness.check(t.nextToken(), (Object)"two");
        harness.check(t.nextToken(), (Object)"three");
        pass = false;
        try {
            t.nextToken();
        }
        catch (NoSuchElementException e) {
            pass = true;
        }
        harness.check(pass);
    }

    private void test2(TestHarness harness) {
        harness.checkPoint("nextToken(String)");
        StringTokenizer t = new StringTokenizer("A BC-DEF GHI-JKL", " ");
        harness.check(t.nextToken(), (Object)"A");
        harness.check(t.nextToken("-"), (Object)" BC");
        harness.check(t.nextToken(), (Object)"DEF GHI");
        boolean pass = false;
        try {
            t.nextToken(null);
        }
        catch (NullPointerException e) {
            pass = true;
        }
        harness.check(pass);
    }
}

