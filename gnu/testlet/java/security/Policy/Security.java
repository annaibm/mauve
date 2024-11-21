/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.security.Policy;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.security.Permission;
import java.security.PermissionCollection;
import java.security.Permissions;
import java.security.Policy;
import java.security.ProtectionDomain;
import java.security.SecurityPermission;

public class Security
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        Policy.setPolicy(new Policy(){

            @Override
            public PermissionCollection getPermissions(ProtectionDomain domain) {
                Permissions perms = new Permissions();
                perms.add(new TestPermission());
                return perms;
            }
        });
        ProtectionDomain pd = Security.class.getProtectionDomain();
        System.setSecurityManager(new SecurityManager(){

            @Override
            public void checkPermission(Permission perm) {
                if (perm instanceof SecurityPermission && perm.getName().equals("getPolicy")) {
                    throw new SecurityException("Policy retrieval disallowed.");
                }
            }
        });
        String testPermString = new TestPermission().toString();
        harness.check(!pd.toString().contains(testPermString), "Policy permissions should not be visible");
    }

    private static class TestPermission
    extends Permission {
        public TestPermission() {
            super("test");
        }

        @Override
        public String getActions() {
            return "test";
        }

        @Override
        public int hashCode() {
            return "test".hashCode();
        }

        @Override
        public boolean equals(Object other) {
            if (other == null) {
                return false;
            }
            if (other == this) {
                return true;
            }
            return other.getClass().equals(this.getClass());
        }

        @Override
        public boolean implies(Permission permission) {
            return permission instanceof TestPermission;
        }
    }
}

