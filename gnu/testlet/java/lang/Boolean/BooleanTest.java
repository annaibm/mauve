/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.lang.Boolean;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.util.Properties;

public class BooleanTest
implements Testlet {
    public void test_Basics(TestHarness harness) {
        harness.checkPoint("Basics");
        harness.check(Boolean.TRUE.equals(new Boolean(true)) && Boolean.FALSE.equals(new Boolean(false)));
        Boolean b1 = new Boolean(true);
        Boolean b2 = new Boolean(false);
        harness.check(b1 == true && b2 == false);
        Boolean bs1 = new Boolean("True");
        Boolean bs2 = new Boolean("False");
        Boolean bs3 = new Boolean("true");
        Boolean bs4 = new Boolean("hi");
        Boolean bs5 = new Boolean("");
        harness.check(bs1 == true && bs2 == false && bs3 == true && bs4 == false && bs5 == false);
        harness.check(bs1.toString().equals("true") && bs2.toString().equals("false"));
    }

    public void test_equals(TestHarness harness) {
        harness.checkPoint("equals");
        Boolean b1 = new Boolean(true);
        Boolean b2 = new Boolean(false);
        harness.check(!b1.equals(new Integer(4)));
        harness.check(!b1.equals(null));
        harness.check(!b1.equals(b2));
        harness.check(b1.equals(new Boolean(true)));
    }

    public void test_hashCode(TestHarness harness) {
        harness.checkPoint("hashCode");
        Boolean b1 = new Boolean(true);
        Boolean b2 = new Boolean(false);
        harness.check(b1.hashCode() == 1231 && b2.hashCode() == 1237);
    }

    public void test_booleanValue(TestHarness harness) {
        harness.checkPoint("booleanValue");
        Boolean b1 = new Boolean(true);
        Boolean b2 = new Boolean(false);
        harness.check(b1 == true && b2 == false);
    }

    public void test_valueOf(TestHarness harness) {
        harness.checkPoint("valueOf");
        harness.check(Boolean.valueOf("True") != false && Boolean.valueOf("true") != false && Boolean.valueOf("anc") == false);
    }

    public void test_getBoolean(TestHarness harness) {
        harness.checkPoint("getBoolean");
        Properties prop = System.getProperties();
        prop.put("booleankey1", "true");
        prop.put("booleankey2", "false");
        prop.put("booleankey3", "hi");
        System.setProperties(prop);
        harness.check(Boolean.getBoolean("booleankey1") && !Boolean.getBoolean("booleankey2") && !Boolean.getBoolean("booleankey3"));
    }

    @Override
    public void test(TestHarness harness) {
        this.test_Basics(harness);
        this.test_equals(harness);
        this.test_hashCode(harness);
        this.test_booleanValue(harness);
        this.test_valueOf(harness);
        this.test_getBoolean(harness);
    }
}

