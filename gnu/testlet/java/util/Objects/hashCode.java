/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.util.Objects;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.util.Objects;

public class hashCode
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        String veg = "Potato";
        int result = Objects.hashCode(null);
        harness.debug("Objects.hashCode(null) = " + result);
        harness.check(result, 0, "Objects.hashCode(null) == 0");
        result = Objects.hashCode(veg);
        int compResult = veg.hashCode();
        harness.debug("Objects.hashCode(\"" + veg + "\") = " + result + ", \"" + veg + "\".hashCode() = " + compResult);
        harness.check(result, compResult, "Objects.hashCode(\"" + veg + "\") == \"" + veg + "\".hashCode()");
    }
}

