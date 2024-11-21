/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.util.regex.Matcher;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Regions
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        String s = "food bar fool";
        Matcher m = Pattern.compile("^foo.").matcher(s);
        harness.check(m.lookingAt(), "Match foo at start of " + s);
        harness.check(m.group(), (Object)"food");
        m.reset();
        m.region(9, s.length());
        harness.check(m.lookingAt(), "Match foo at start of " + s.substring(9));
        harness.check(m.group(), (Object)"fool");
        m.reset();
        m.region(9, 10);
        harness.check(m.lookingAt(), false, "Match foo at start of " + s.substring(9, 10));
    }
}

