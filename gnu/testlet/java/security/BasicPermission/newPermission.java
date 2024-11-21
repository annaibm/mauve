/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.security.BasicPermission;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.security.BasicPermission;
import java.security.Permission;

public class newPermission
extends BasicPermission
implements Testlet {
    private String actions;

    @Override
    public void test(TestHarness harness) {
        boolean exception_thrown;
        newPermission p = new newPermission("a");
        harness.check("a", (Object)p.getName());
        p = new newPermission("a", "b");
        harness.check("a", (Object)p.getName());
        harness.check("b", (Object)((Permission)p).getActions());
        try {
            p = new newPermission("");
            exception_thrown = false;
        }
        catch (IllegalArgumentException iae) {
            exception_thrown = true;
        }
        harness.check(exception_thrown);
        try {
            p = new newPermission(null);
            exception_thrown = false;
        }
        catch (NullPointerException npe) {
            exception_thrown = true;
        }
        harness.check(exception_thrown);
        try {
            p = new newPermission("", "");
            exception_thrown = false;
        }
        catch (IllegalArgumentException iae) {
            exception_thrown = true;
        }
        harness.check(exception_thrown);
        try {
            p = new newPermission(null, "");
            exception_thrown = false;
        }
        catch (NullPointerException npe) {
            exception_thrown = true;
        }
        harness.check(exception_thrown);
        try {
            p = new newPermission(null, null);
            exception_thrown = false;
        }
        catch (NullPointerException npe) {
            exception_thrown = true;
        }
        harness.check(exception_thrown);
    }

    public newPermission() {
        super("newPermission");
    }

    public newPermission(String n) {
        super(n);
    }

    public newPermission(String n, String a) {
        super(n, a);
        this.actions = a;
    }

    @Override
    public String getActions() {
        return super.getActions() + this.actions;
    }
}

