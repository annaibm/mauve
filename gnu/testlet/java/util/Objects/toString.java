/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.util.Objects;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.util.Objects;

public class toString
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        String veg = "Potato";
        String result = Objects.toString(null);
        harness.debug("Objects.toString(null) = " + result);
        harness.check(result, "null", "Objects.toString(null) == \"null\"");
        result = Objects.toString(veg);
        String compResult = veg.toString();
        harness.debug("Objects.toString(\"" + veg + "\") = " + result + ", \"" + veg + "\".toString() = " + compResult);
        harness.check(result, compResult, "Objects.toString(\"" + veg + "\") == \"" + veg + "\".toString()");
        result = Objects.toString(null, "Apricot");
        harness.debug("Objects.toString(null,\"Apricot\") = " + result);
        harness.check(result, "Apricot", "Objects.toString(null,\"Apricot\") == \"Apricot\"");
        result = Objects.toString(veg, "Apricot");
        harness.debug("Objects.toString(\"" + veg + "\",\"Apricot\") = " + result + ", \"" + veg + "\".toString() = " + compResult);
        harness.check(result, compResult, "Objects.toString(\"" + veg + "\",\"Apricot\") == \"" + veg + "\".toString()");
    }
}

