/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.text.ParseException;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.text.ParseException;

public class Test
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        ParseException pe = new ParseException("My Parse Exception", 13);
        harness.check(pe.getErrorOffset(), 13, "getErrorOffset");
        harness.debug("Dumping exception info.  This is NOT an error");
        harness.debug(pe);
    }
}

