/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.text.Bidi;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.text.Bidi;

public class Basic
implements Testlet {
    public void testOne(TestHarness harness, Bidi bidi, String expected) {
        StringBuffer buf = new StringBuffer();
        for (int i = 0; i < bidi.getLength(); ++i) {
            buf.append(bidi.getLevelAt(i));
        }
        harness.check(buf.toString(), (Object)expected);
    }

    @Override
    public void test(TestHarness harness) {
        harness.checkPoint("simple");
        Bidi b = new Bidi("hi bob", -2);
        this.testOne(harness, b, "000000");
        harness.check(b.baseIsLeftToRight());
        harness.check(b.isLeftToRight());
        harness.check(b.getRunCount(), 1);
        harness.checkPoint("one embedding");
        b = new Bidi("hi \u202bbob", -2);
        this.testOne(harness, b, "0002222");
        harness.checkPoint("override");
        b = new Bidi("hi \u202ebob", -2);
        this.testOne(harness, b, "0001111");
        harness.checkPoint("override and pop");
        b = new Bidi("car means \u202eCAR\u202c.", -2);
        this.testOne(harness, b, "0000000000111100");
        b = new Bidi("car \u202eMEANS CAR\u202c.", 1);
        this.testOne(harness, b, "2221333333333311");
    }
}

