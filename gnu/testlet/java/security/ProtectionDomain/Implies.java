/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.security.ProtectionDomain;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.security.AllPermission;
import java.security.CodeSource;
import java.security.Permission;
import java.security.PermissionCollection;
import java.security.Permissions;
import java.security.Policy;
import java.security.ProtectionDomain;
import java.security.SecurityPermission;

public class Implies
implements Testlet {
    private boolean called = false;

    @Override
    public void test(TestHarness harness) {
        Policy.setPolicy(new Policy(){

            @Override
            public boolean implies(ProtectionDomain domain, Permission perm) {
                if (perm.getName().equals("TestPermission")) {
                    Implies.this.called = true;
                }
                return true;
            }

            @Override
            public void refresh() {
            }

            @Override
            public PermissionCollection getPermissions(CodeSource codesource) {
                return null;
            }
        });
        System.setSecurityManager(new SecurityManager());
        Permissions coll = new Permissions();
        ((PermissionCollection)coll).add(new AllPermission());
        ProtectionDomain pd = new ProtectionDomain(null, coll, Implies.class.getClassLoader(), null);
        pd.implies(new SecurityPermission("TestPermission"));
        harness.check(!this.called, "Policy was not checked due to AllPermission");
    }
}

