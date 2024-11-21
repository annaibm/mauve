/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet;

import gnu.testlet.TestHarness;
import java.security.CodeSource;
import java.security.Permission;
import java.security.PermissionCollection;
import java.security.Policy;
import java.security.ProtectionDomain;

public class TestSecurityManager
extends SecurityManager {
    private SecurityManager oldManager;
    private Policy oldPolicy;
    private Permission[] mustCheck;
    private Permission[] mayCheck;
    private boolean enabled;
    private boolean[] checked;
    private final TestHarness harness;
    private boolean isHalting;
    private final SuccessException successException = new SuccessException();
    private int compare;
    public static final int EQUALS = 1;
    public static final int IMPLIES = 2;
    private final Permission[] noChecks = new Permission[0];

    public TestSecurityManager(TestHarness harness) {
        this.harness = harness;
    }

    public void install() {
        SecurityManager oldsm = System.getSecurityManager();
        if (oldsm == this) {
            throw new IllegalStateException("already installed");
        }
        this.oldManager = oldsm;
        this.enabled = false;
        this.oldPolicy = Policy.getPolicy();
        Policy.setPolicy(new Policy(){

            @Override
            public PermissionCollection getPermissions(CodeSource codesource) {
                return null;
            }

            @Override
            public boolean implies(ProtectionDomain domain, Permission perm) {
                int i;
                boolean matched;
                if (!TestSecurityManager.this.enabled) {
                    return true;
                }
                if (TestSecurityManager.this.harness != null) {
                    TestSecurityManager.this.harness.debug("checkPermission(" + perm + ")");
                }
                if (!(matched = false)) {
                    for (i = 0; i < TestSecurityManager.this.mustCheck.length; ++i) {
                        if (!TestSecurityManager.this.permissionsMatch(TestSecurityManager.this.mustCheck[i], perm)) continue;
                        ((TestSecurityManager)TestSecurityManager.this).checked[i] = true;
                        matched = true;
                    }
                }
                if (!matched) {
                    for (i = 0; i < TestSecurityManager.this.mayCheck.length; ++i) {
                        if (!TestSecurityManager.this.permissionsMatch(TestSecurityManager.this.mayCheck[i], perm)) continue;
                        matched = true;
                    }
                }
                if (!matched) {
                    int i2;
                    TestSecurityManager.this.enabled = false;
                    TestSecurityManager.this.harness.debug("unexpected check: " + perm);
                    if (TestSecurityManager.this.mustCheck.length != 0) {
                        StringBuffer expected = new StringBuffer();
                        for (i2 = 0; i2 < TestSecurityManager.this.mustCheck.length; ++i2) {
                            expected.append(' ').append(TestSecurityManager.this.mustCheck[i2]);
                        }
                        TestSecurityManager.this.harness.debug("expected: mustCheck:" + expected.toString());
                    }
                    if (TestSecurityManager.this.mayCheck.length != 0) {
                        StringBuffer expected = new StringBuffer();
                        for (i2 = 0; i2 < TestSecurityManager.this.mayCheck.length; ++i2) {
                            expected.append(' ').append(TestSecurityManager.this.mayCheck[i2]);
                        }
                        TestSecurityManager.this.harness.debug("expected: mayCheck:" + expected.toString());
                    }
                    return false;
                }
                if (TestSecurityManager.this.isHalting) {
                    boolean allChecked = true;
                    for (int i3 = 0; i3 < TestSecurityManager.this.checked.length; ++i3) {
                        if (TestSecurityManager.this.checked[i3]) continue;
                        allChecked = false;
                    }
                    if (allChecked) {
                        TestSecurityManager.this.enabled = false;
                        throw TestSecurityManager.this.successException;
                    }
                }
                return true;
            }

            @Override
            public void refresh() {
            }
        });
        System.setSecurityManager(this);
    }

    public void uninstall() {
        SecurityManager oldsm = System.getSecurityManager();
        if (oldsm != this) {
            throw new IllegalStateException("not installed");
        }
        this.enabled = false;
        System.setSecurityManager(this.oldManager);
        Policy.setPolicy(this.oldPolicy);
    }

    public void prepareChecks(Permission[] mustCheck) {
        this.prepareChecks(mustCheck, this.noChecks);
    }

    public void prepareChecks(Permission[] mustCheck, Permission[] mayCheck) {
        this.prepareChecks(mustCheck, mayCheck, false);
    }

    public void prepareHaltingChecks(Permission[] mustCheck) {
        this.prepareHaltingChecks(mustCheck, this.noChecks);
    }

    public void prepareHaltingChecks(Permission[] mustCheck, Permission[] mayCheck) {
        this.prepareChecks(mustCheck, mayCheck, true);
    }

    protected void prepareChecks(Permission[] mustCheck, Permission[] mayCheck, boolean isHalting) {
        this.mayCheck = mayCheck;
        this.mustCheck = mustCheck;
        this.isHalting = isHalting;
        this.checked = new boolean[mustCheck.length];
        this.enabled = true;
        this.compare = 1;
    }

    public void setComparisonStyle(int style) {
        this.compare = style;
    }

    private boolean permissionsMatch(Permission p1, Permission p2) {
        switch (this.compare) {
            case 1: {
                return p1.equals(p2);
            }
            case 2: {
                return p1.implies(p2);
            }
        }
        throw new IllegalArgumentException();
    }

    public void checkAllChecked() {
        this.enabled = false;
        boolean allChecked = true;
        for (int i = 0; i < this.checked.length; ++i) {
            if (this.checked[i]) continue;
            this.harness.debug("Unchecked permission: " + this.mustCheck[i]);
            allChecked = false;
        }
        this.harness.check(allChecked);
    }

    public static class SuccessException
    extends SecurityException {
        private static final long serialVersionUID = 23L;
    }
}

