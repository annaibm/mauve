/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.util.Objects;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.util.Arrays;
import java.util.Objects;

public class hash
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        Object[] veg1 = new String[]{"Potato", "Onion", "Carrot"};
        int result = Objects.hash(null);
        harness.debug("Objects.hash(null) = " + result);
        harness.check(result, 0, "Objects.hash(null) == 0");
        harness.debug("veg1(" + veg1 + ") = " + Arrays.toString(veg1));
        result = Objects.hash(veg1[0], veg1[1], veg1[2]);
        int compResult = Arrays.hashCode(veg1);
        harness.debug("Objects.hash(" + (String)veg1[0] + "," + (String)veg1[1] + "," + (String)veg1[2] + ") = " + result + ", Arrays.hashCode(" + veg1 + ") = " + compResult);
        harness.check(result, compResult, "Object.hash(veg1[0],veg1[1],veg1[2]) == Arrays.hashCode(veg1)");
        compResult = Arrays.asList(veg1).hashCode();
        harness.debug("Objects.hash(" + (String)veg1[0] + "," + (String)veg1[1] + "," + (String)veg1[2] + ") = " + result + ", Arrays.asList(" + veg1 + ").hashCode = " + compResult);
        harness.check(result, compResult, "Object.hash(veg1[0],veg1[1],veg1[2]) == Arrays.asList(veg1).hashCode()");
    }
}

