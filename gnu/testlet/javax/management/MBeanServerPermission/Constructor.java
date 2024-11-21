/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.management.MBeanServerPermission;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import javax.management.MBeanServerPermission;

public class Constructor
implements Testlet {
    @Override
    public void test(TestHarness h) {
        int a;
        Exception caught = null;
        try {
            new MBeanServerPermission(null);
        }
        catch (Exception ex) {
            caught = ex;
        }
        h.check(caught instanceof NullPointerException, "Null name");
        caught = null;
        try {
            new MBeanServerPermission("*");
        }
        catch (Exception ex) {
            caught = ex;
        }
        h.check(caught, null, "* is valid");
        String[] valid = new String[]{"createMBeanServer", "newMBeanServer", "findMBeanServer", "releaseMBeanServer"};
        for (a = 0; a < valid.length; ++a) {
            caught = null;
            try {
                new MBeanServerPermission(valid[a]);
            }
            catch (Exception ex) {
                caught = ex;
            }
            h.check(caught, null, valid[a] + " is valid");
        }
        for (a = 0; a < valid.length; ++a) {
            for (int b = 0; b < valid.length; ++b) {
                caught = null;
                String permit = valid[a] + "," + valid[b];
                try {
                    new MBeanServerPermission(permit);
                }
                catch (Exception ex) {
                    caught = ex;
                }
                h.check(caught, null, permit + " is valid");
            }
        }
        for (a = 0; a < valid.length; ++a) {
            for (int b = 0; b < valid.length; ++b) {
                for (int c = 0; c < valid.length; ++c) {
                    caught = null;
                    String permit = valid[a] + "," + valid[b] + "," + valid[c];
                    try {
                        new MBeanServerPermission(permit);
                    }
                    catch (Exception ex) {
                        caught = ex;
                    }
                    h.check(caught, null, permit + " is valid");
                }
            }
        }
        for (a = 0; a < valid.length; ++a) {
            for (int b = 0; b < valid.length; ++b) {
                for (int c = 0; c < valid.length; ++c) {
                    for (int d = 0; d < valid.length; ++d) {
                        caught = null;
                        String permit = valid[a] + "," + valid[b] + "," + valid[c] + "," + valid[d];
                        try {
                            new MBeanServerPermission(permit);
                        }
                        catch (Exception ex) {
                            caught = ex;
                        }
                        h.check(caught, null, permit + " is valid");
                    }
                }
            }
        }
        caught = null;
        try {
            new MBeanServerPermission("     createMBeanServer   , newMBeanServer  ");
        }
        catch (Exception ex) {
            caught = ex;
        }
        h.check(caught, null, "spaces are valid");
        caught = null;
        try {
            new MBeanServerPermission("fjafjlskjflka");
        }
        catch (Exception ex) {
            caught = ex;
        }
        h.check(caught instanceof IllegalArgumentException, "other names are invalid");
        caught = null;
        try {
            new MBeanServerPermission("*", "fishcakes");
        }
        catch (Exception ex) {
            caught = ex;
        }
        h.check(caught instanceof IllegalArgumentException, "non-null non-empty actions are invalid");
    }
}

