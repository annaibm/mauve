/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.text.MessageFormat;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.text.MessageFormat;
import java.text.ParsePosition;
import java.util.Locale;

public class parse
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        ParsePosition pp = new ParsePosition(0);
        Locale loc = Locale.US;
        Locale.setDefault(loc);
        MessageFormat mf = new MessageFormat("no variables");
        mf.setLocale(loc);
        harness.checkPoint("no variables");
        pp.setIndex(0);
        Object[] val = mf.parse("no zardoz", pp);
        harness.check(val, null);
        pp.setIndex(0);
        val = mf.parse("no variables", pp);
        harness.check(val.length, 0);
        harness.checkPoint("one variable");
        mf.applyPattern("I have seen zardoz number {0}.");
        pp.setIndex(0);
        val = mf.parse("I have seen zardoz number 23.", pp);
        harness.check(val.length, 1);
        harness.check(val[0] instanceof String);
        harness.check((String)val[0], (Object)"23");
        harness.checkPoint("number format");
        mf.applyPattern("I have seen zardoz number {0,number}!");
        pp.setIndex(0);
        val = mf.parse("I have seen zardoz number 23!", pp);
        harness.check(val.length, 1);
        harness.check(val[0] instanceof Number);
        harness.check(((Number)val[0]).longValue(), 23L);
        harness.checkPoint("greedy string matching at end");
        mf.applyPattern("/foo/{0}");
        pp.setIndex(0);
        val = mf.parse("/foo/bar", pp);
        harness.check(val.length, 1);
        harness.check(val[0] instanceof String);
        harness.check(val[0], (Object)"bar");
    }
}

