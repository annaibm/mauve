/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.text.FieldPosition;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.text.FieldPosition;

public class Test
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        FieldPosition fp = new FieldPosition(21);
        harness.check(fp.getField(), 21, "getField()");
        harness.check(fp.getBeginIndex(), 0, "getBeginIndex on create");
        harness.check(fp.getEndIndex(), 0, "getEndIndex on create");
        fp.setBeginIndex(1999);
        harness.check(fp.getBeginIndex(), 1999, "set/getBeginIndex");
        fp.setEndIndex(2001);
        harness.check(fp.getEndIndex(), 2001, "set/getEndIndex");
        FieldPosition fp2 = new FieldPosition(21);
        fp2.setBeginIndex(1999);
        fp2.setEndIndex(2001);
        harness.check(fp.equals(fp2), "equals (true)");
        FieldPosition fp3 = new FieldPosition(1984);
        fp3.setBeginIndex(1999);
        fp3.setEndIndex(2001);
        harness.check(!fp.equals(fp3), "equals (false (pos diff))");
        fp3 = new FieldPosition(21);
        fp3.setBeginIndex(3000);
        fp3.setEndIndex(2001);
        harness.check(!fp.equals(fp3), "equals (false (beg diff))");
        fp3 = new FieldPosition(21);
        fp3.setBeginIndex(1999);
        fp3.setEndIndex(1984);
        harness.check(!fp.equals(fp3), "equals (false (end diff))");
        harness.debug(fp.toString());
    }
}

