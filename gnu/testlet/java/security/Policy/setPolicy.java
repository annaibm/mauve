/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.security.Policy;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.security.Permission;
import java.security.Policy;
import java.security.ProtectionDomain;

public class setPolicy
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        TestSecurityManager sm = new TestSecurityManager();
        sm.install();
        sm.checkRead("/tmp");
        harness.check(sm.isCalled(), "Policy was checked");
    }

    private class TestSecurityManager
    extends SecurityManager {
        private boolean called = false;

        private TestSecurityManager() {
        }

        public void install() {
            Policy.setPolicy(new Policy(){

                @Override
                public boolean implies(ProtectionDomain domain, Permission permission) {
                    TestSecurityManager.this.called = true;
                    return true;
                }
            });
            System.setSecurityManager(this);
        }

        public boolean isCalled() {
            return this.called;
        }
    }
}

