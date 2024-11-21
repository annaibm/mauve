/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.util.StringTokenizer;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.util.NoSuchElementException;
import java.util.StringTokenizer;

public class constructors
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        this.testConstructor1(harness);
        this.testConstructor2(harness);
        this.testConstructor3(harness);
    }

    private void testConstructor1(TestHarness harness) {
        harness.checkPoint("StringTokenizer(String)");
        StringTokenizer st = new StringTokenizer("one two\tthree\nfour\rfive\fsix");
        harness.check(st.nextToken(), (Object)"one");
        harness.check(st.nextToken(), (Object)"two");
        harness.check(st.nextToken(), (Object)"three");
        harness.check(st.nextToken(), (Object)"four");
        harness.check(st.nextToken(), (Object)"five");
        harness.check(st.nextToken(), (Object)"six");
        boolean pass = false;
        try {
            st.nextToken();
        }
        catch (NoSuchElementException e) {
            pass = true;
        }
        harness.check(pass);
        pass = false;
        try {
            st = new StringTokenizer(null);
        }
        catch (NullPointerException e) {
            pass = true;
        }
        harness.check(pass);
        st = new StringTokenizer("");
        harness.check(!st.hasMoreElements());
    }

    private void testConstructor2(TestHarness harness) {
        harness.checkPoint("StringTokenizer(String, String)");
        StringTokenizer st = new StringTokenizer("one twoXthreeYfour", " XY");
        harness.check(st.nextToken(), (Object)"one");
        harness.check(st.nextToken(), (Object)"two");
        harness.check(st.nextToken(), (Object)"three");
        harness.check(st.nextToken(), (Object)"four");
        boolean pass = false;
        try {
            st.nextToken();
        }
        catch (NoSuchElementException e) {
            pass = true;
        }
        harness.check(pass);
        pass = false;
        try {
            st = new StringTokenizer(null, " ");
        }
        catch (NullPointerException e) {
            pass = true;
        }
        harness.check(pass);
        pass = false;
        try {
            st = new StringTokenizer("ABC DEFG", null);
            try {
                st.nextToken();
            }
            catch (NullPointerException e) {
                pass = true;
            }
        }
        catch (NullPointerException nullPointerException2) {
            // empty catch block
        }
        harness.check(pass);
    }

    private void testConstructor3(TestHarness harness) {
        harness.checkPoint("StringTokenizer(String, String, boolean)");
        StringTokenizer st = new StringTokenizer("A BCXDEFYYGHI", " XY", true);
        harness.check(st.nextToken(), (Object)"A");
        harness.check(st.nextToken(), (Object)" ");
        harness.check(st.nextToken(), (Object)"BC");
        harness.check(st.nextToken(), (Object)"X");
        harness.check(st.nextToken(), (Object)"DEF");
        harness.check(st.nextToken(), (Object)"Y");
        harness.check(st.nextToken(), (Object)"Y");
        harness.check(st.nextToken(), (Object)"GHI");
        harness.check(!st.hasMoreElements());
        st = new StringTokenizer("A BCXDEFYYGHI", " XY", false);
        harness.check(st.nextToken(), (Object)"A");
        harness.check(st.nextToken(), (Object)"BC");
        harness.check(st.nextToken(), (Object)"DEF");
        harness.check(st.nextToken(), (Object)"GHI");
        harness.check(!st.hasMoreElements());
        boolean pass = false;
        try {
            st = new StringTokenizer(null, " ", true);
        }
        catch (NullPointerException e) {
            pass = true;
        }
        harness.check(pass);
    }
}

