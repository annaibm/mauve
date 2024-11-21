/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.swing.JList;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import javax.swing.JList;
import javax.swing.text.Position;

public class getNextMatch
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        JList<Object> list2 = new JList<Object>(new Object[]{"A", "B", "C", "a1", "b1", "c1", "AA", "BB", "CC"});
        harness.check(list2.getNextMatch("A", 0, Position.Bias.Forward), 0);
        harness.check(list2.getNextMatch("A", 1, Position.Bias.Forward), 3);
        harness.check(list2.getNextMatch("A", 2, Position.Bias.Forward), 3);
        harness.check(list2.getNextMatch("A", 3, Position.Bias.Forward), 3);
        harness.check(list2.getNextMatch("A", 4, Position.Bias.Forward), 6);
        harness.check(list2.getNextMatch("A", 5, Position.Bias.Forward), 6);
        harness.check(list2.getNextMatch("A", 6, Position.Bias.Forward), 6);
        harness.check(list2.getNextMatch("A", 7, Position.Bias.Forward), 0);
        harness.check(list2.getNextMatch("A", 8, Position.Bias.Forward), 0);
        harness.check(list2.getNextMatch("a", 0, Position.Bias.Backward), 0);
        harness.check(list2.getNextMatch("a", 1, Position.Bias.Backward), 0);
        harness.check(list2.getNextMatch("a", 2, Position.Bias.Backward), 0);
        harness.check(list2.getNextMatch("a", 3, Position.Bias.Backward), 3);
        harness.check(list2.getNextMatch("a", 4, Position.Bias.Backward), 3);
        harness.check(list2.getNextMatch("a", 5, Position.Bias.Backward), 3);
        harness.check(list2.getNextMatch("a", 6, Position.Bias.Backward), 6);
        harness.check(list2.getNextMatch("a", 7, Position.Bias.Backward), 6);
        harness.check(list2.getNextMatch("a", 8, Position.Bias.Backward), 6);
        harness.check(list2.getNextMatch("A", 0, null), 0);
        harness.check(list2.getNextMatch("A", 1, null), 0);
        harness.check(list2.getNextMatch("A", 2, null), 0);
        harness.check(list2.getNextMatch("A", 3, null), 3);
        harness.check(list2.getNextMatch("A", 4, null), 3);
        harness.check(list2.getNextMatch("A", 5, null), 3);
        harness.check(list2.getNextMatch("A", 6, null), 6);
        harness.check(list2.getNextMatch("A", 7, null), 6);
        harness.check(list2.getNextMatch("A", 8, null), 6);
        harness.check(list2.getNextMatch("Aa", 0, Position.Bias.Forward), 6);
        harness.check(list2.getNextMatch("Aa", 1, Position.Bias.Forward), 6);
        harness.check(list2.getNextMatch("Aa", 2, Position.Bias.Forward), 6);
        harness.check(list2.getNextMatch("Aa", 3, Position.Bias.Forward), 6);
        harness.check(list2.getNextMatch("Aa", 4, Position.Bias.Forward), 6);
        harness.check(list2.getNextMatch("Aa", 5, Position.Bias.Forward), 6);
        harness.check(list2.getNextMatch("Aa", 6, Position.Bias.Forward), 6);
        harness.check(list2.getNextMatch("Aa", 7, Position.Bias.Forward), 6);
        harness.check(list2.getNextMatch("Aa", 8, Position.Bias.Forward), 6);
        harness.check(list2.getNextMatch("", 0, Position.Bias.Forward), 0);
        harness.check(list2.getNextMatch("", 1, Position.Bias.Forward), 1);
        harness.check(list2.getNextMatch("", 2, Position.Bias.Forward), 2);
        harness.check(list2.getNextMatch("", 3, Position.Bias.Forward), 3);
        harness.check(list2.getNextMatch("", 4, Position.Bias.Forward), 4);
        harness.check(list2.getNextMatch("", 5, Position.Bias.Forward), 5);
        harness.check(list2.getNextMatch("", 6, Position.Bias.Forward), 6);
        harness.check(list2.getNextMatch("", 7, Position.Bias.Forward), 7);
        harness.check(list2.getNextMatch("D", 0, Position.Bias.Forward), -1);
        boolean pass = false;
        try {
            list2.getNextMatch(null, 0, Position.Bias.Forward);
        }
        catch (IllegalArgumentException e) {
            pass = true;
        }
        harness.check(pass);
        pass = false;
        try {
            list2.getNextMatch("A", -1, Position.Bias.Forward);
        }
        catch (IllegalArgumentException e) {
            pass = true;
        }
        harness.check(pass);
        pass = false;
        try {
            list2.getNextMatch("A", 9, Position.Bias.Forward);
        }
        catch (IllegalArgumentException e) {
            pass = true;
        }
        harness.check(pass);
    }
}

