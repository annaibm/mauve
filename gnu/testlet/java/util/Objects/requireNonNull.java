/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.util.Objects;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.util.Objects;

public class requireNonNull
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        String result;
        String veg = "Potato";
        harness.checkPoint("Objects.requireNonNull(null) throws NPE");
        try {
            result = Objects.requireNonNull(null);
            harness.debug("Objects.requireNonNull(null) = " + result);
            harness.check(false);
        }
        catch (NullPointerException e) {
            harness.debug("Objects.requireNonNull(null) threw NPE");
            harness.check(true);
        }
        harness.checkPoint("Objects.requireNonNull(\"" + veg + "\") doesn't throw NPE");
        try {
            result = Objects.requireNonNull(veg);
            harness.debug("Objects.requireNonNull(\"" + veg + "\") = " + result);
            harness.check(true);
            harness.check(result, veg, "Objects.requireNonNull(\"" + veg + "\") returns \"" + veg + "\"");
        }
        catch (NullPointerException e) {
            harness.debug("Objects.requireNonNull(" + veg + ") threw NPE");
            harness.check(false);
        }
        harness.checkPoint("Objects.requireNonNull(null,\"Oops\") throws NPE");
        try {
            result = Objects.requireNonNull(null, "Oops");
            harness.debug("Objects.requireNonNull(null,\"Oops\") = " + result);
            harness.check(false);
        }
        catch (NullPointerException e) {
            harness.debug("Objects.requireNonNull(null.\"Oops\") threw NPE");
            harness.check(true);
            harness.check(e.getMessage().contains("Oops"), "Specified message is used in NPE");
        }
        harness.checkPoint("Objects.requireNonNull(\"" + veg + "\", \"Oops\") doesn't throw NPE");
        try {
            result = Objects.requireNonNull(veg, "Oops");
            harness.debug("Objects.requireNonNull(\"" + veg + "\", \"Oops\") = " + result);
            harness.check(true);
            harness.check(result, veg, "Objects.requireNonNull(\"" + veg + "\", \"Oops\") returns \"" + veg + "\"");
        }
        catch (NullPointerException e) {
            harness.debug("Objects.requireNonNull(" + veg + ") threw NPE");
            harness.check(false);
        }
    }
}

