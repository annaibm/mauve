/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.swing.text.Segment;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import javax.swing.text.Segment;

public class setIndex
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        char[] ch = new char[]{'A', 'B', 'C', 'D', 'E', 'F', 'G'};
        Segment s = new Segment(ch, 0, 7);
        s.setIndex(2);
        harness.check(s.current(), 67);
        s.setIndex(6);
        harness.check(s.current(), 71);
        boolean pass = false;
        try {
            s.setIndex(-1);
        }
        catch (IllegalArgumentException e) {
            pass = true;
        }
        harness.check(pass);
        pass = false;
        try {
            s.setIndex(99);
        }
        catch (IllegalArgumentException e) {
            pass = true;
        }
        harness.check(pass);
        s = new Segment(ch, 3, 3);
        s.setIndex(4);
        harness.check(s.current(), 69);
        s.setIndex(5);
        harness.check(s.current(), 70);
        pass = false;
        try {
            s.setIndex(-1);
        }
        catch (IllegalArgumentException e) {
            pass = true;
        }
        harness.check(pass);
        pass = false;
        try {
            s.setIndex(1);
        }
        catch (IllegalArgumentException e) {
            pass = true;
        }
        harness.check(pass);
        pass = false;
        try {
            s.setIndex(7);
        }
        catch (IllegalArgumentException e) {
            pass = true;
        }
        harness.check(pass);
        pass = false;
        try {
            s.setIndex(99);
        }
        catch (IllegalArgumentException e) {
            pass = true;
        }
        harness.check(pass);
    }
}

