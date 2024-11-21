/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.awt.AWTPermission;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.awt.AWTPermission;

public class constructor
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        AWTPermission permission = new AWTPermission("String");
        harness.check(permission.getActions(), (Object)"");
        harness.check(permission.getName(), (Object)"String");
        if (constructor.conformToJDK17()) {
            harness.check(permission.toString(), (Object)"(\"java.awt.AWTPermission\" \"String\")");
        } else {
            harness.check(permission.toString(), (Object)"(java.awt.AWTPermission String)");
        }
        boolean fail = false;
        try {
            permission = new AWTPermission("");
        }
        catch (IllegalArgumentException e) {
            fail = true;
        }
        harness.check(fail);
        fail = false;
        try {
            permission = new AWTPermission(null);
        }
        catch (NullPointerException e) {
            fail = true;
        }
        harness.check(fail);
    }

    private static boolean conformToJDK17() {
        String[] javaVersion = System.getProperty("java.version").split("\\.");
        String vendorID = System.getProperty("java.vendor");
        if ("Sun Microsystems Inc.".equals(vendorID)) {
            return Long.parseLong(javaVersion[1]) >= 7L;
        }
        return true;
    }
}

