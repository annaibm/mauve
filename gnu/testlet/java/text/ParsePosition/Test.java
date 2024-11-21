/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.text.ParsePosition;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.text.ParsePosition;

public class Test
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        ParsePosition pp = new ParsePosition(69);
        harness.check(pp.getIndex(), 69, "getIndex() post-create");
        pp.setIndex(666);
        harness.check(pp.getIndex(), 666, "set/getIndex()");
        harness.check(pp.getErrorIndex(), -1, "getErrorIndex() no error");
        pp.setErrorIndex(65536);
        harness.check(pp.getErrorIndex(), 65536, "set/getErrorIndex()");
        harness.debug(pp.toString());
    }
}

