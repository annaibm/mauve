/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.util.Objects;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.util.Comparator;
import java.util.Objects;

public class compare
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        int result = Objects.compare(null, null, null);
        harness.debug("Objects.compare(null,null,null) = " + result);
        harness.check(result, 0, "compare(null,null,null) == 0");
        harness.checkPoint("Objects.compare(null,\"Potato\",c) throws NPE");
        try {
            result = Objects.compare(null, "Potato", new StringComparator());
            harness.debug("Objects.compare(null,\"Potato\",c) = " + result);
            harness.verbose("NullPointerException not propagated from Comparator");
            harness.check(false);
        }
        catch (NullPointerException e) {
            harness.check(true);
        }
        harness.checkPoint("Objects.compare(\"Potato\",null,c) throws NPE");
        try {
            result = Objects.compare("Potato", null, new StringComparator());
            harness.debug("Objects.compare(\"Potato\",null,c) = " + result);
            harness.verbose("NullPointerException not propagated from Comparator");
            harness.check(false);
        }
        catch (NullPointerException e) {
            harness.check(true);
        }
        result = Objects.compare("Potato", "Onion", new StringComparator());
        harness.debug("Objects.compare(\"Potato\", \"Onion\", c) = " + result);
        harness.check(result, 1, "\"Potato\" > \"Onion\"");
        result = Objects.compare("Onion", "Potato", new StringComparator());
        harness.debug("Objects.compare(\"Onion\", \"Potato\", c) = " + result);
        harness.check(result, -1, "\"Onion\" < \"Potato\"");
        result = Objects.compare("Potato", "Potato", new StringComparator());
        harness.debug("Objects.compare(\"Potato\", \"Potato\", c) = " + result);
        harness.check(result, 0, "\"Potato\" == \"Potato\"");
    }

    private static class StringComparator
    implements Comparator<String> {
        private StringComparator() {
        }

        @Override
        public int compare(String a, String b) {
            return a.compareTo(b);
        }

        @Override
        public boolean equals(Object o) {
            return o == this;
        }
    }
}

