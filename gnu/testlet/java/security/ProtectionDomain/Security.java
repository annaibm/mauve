/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.security.ProtectionDomain;

import gnu.testlet.TestHarness;
import gnu.testlet.TestSecurityManager;
import gnu.testlet.Testlet;
import java.security.Permission;
import java.security.ProtectionDomain;
import java.security.SecurityPermission;

public class Security
implements Testlet {
    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void test(TestHarness harness) {
        try {
            Permission[] noPerms = new Permission[]{};
            Permission[] gpPerms = new Permission[]{new SecurityPermission("getPolicy")};
            String debug = System.getProperty("java.security.debug");
            ProtectionDomain pd = new ProtectionDomain(null, null, null, null);
            TestSecurityManager sm = new TestSecurityManager(harness);
            try {
                sm.install();
                harness.checkPoint("toString");
                try {
                    if (debug != null && (debug.contains("domain") || debug.contains("all"))) {
                        sm.prepareChecks(noPerms);
                    } else {
                        sm.prepareChecks(gpPerms);
                    }
                    harness.debug(pd.toString());
                    sm.checkAllChecked();
                }
                catch (SecurityException ex) {
                    harness.debug(ex);
                    harness.check(false, "unexpected check");
                }
            }
            finally {
                sm.uninstall();
            }
        }
        catch (Exception ex) {
            harness.debug(ex);
            harness.check(false, "Unexpected exception");
        }
    }
}

