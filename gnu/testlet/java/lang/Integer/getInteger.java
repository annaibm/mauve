/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.lang.Integer;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.security.Permission;
import java.security.SecurityPermission;
import java.util.Properties;
import java.util.PropertyPermission;

public class getInteger
extends SecurityManager
implements Testlet {
    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void test(TestHarness harness) {
        Properties p = System.getProperties();
        p.put("e1", Integer.toString(Integer.MIN_VALUE));
        p.put("e2", Integer.toString(Integer.MAX_VALUE));
        p.put("e3", "0" + Integer.toOctalString(Integer.MIN_VALUE));
        p.put("e4", "0" + Integer.toOctalString(Integer.MAX_VALUE));
        p.put("e5", "0x" + Integer.toHexString(Integer.MIN_VALUE));
        p.put("e6", "0x" + Integer.toHexString(Integer.MAX_VALUE));
        p.put("e7", "0" + Integer.toString(Integer.MAX_VALUE, 8));
        p.put("e8", "#" + Integer.toString(Integer.MAX_VALUE, 16));
        p.put("e9", "");
        p.put("e10", " ");
        p.put("e11", "foo");
        p.put("e12", "-#1");
        harness.check(Integer.getInteger("e1").toString(), (Object)"-2147483648");
        harness.check(Integer.getInteger("e2").toString(), (Object)"2147483647");
        harness.check(Integer.getInteger("e3"), null);
        harness.check(Integer.getInteger("e4").toString(), (Object)"2147483647");
        harness.check(Integer.getInteger("e5", 12345).toString(), (Object)"12345");
        harness.check(Integer.getInteger("e6", new Integer(56789)).toString(), (Object)"2147483647");
        harness.check(Integer.getInteger("e7", null).toString(), (Object)"2147483647");
        harness.check(Integer.getInteger("e8", 12345).toString(), (Object)"2147483647");
        harness.check(Integer.getInteger("e9", new Integer(56789)).toString(), (Object)"56789");
        harness.check(Integer.getInteger("e10", null), null);
        harness.check(Integer.getInteger("e11"), null);
        harness.check(Integer.getInteger("e12"), new Integer(-1));
        harness.check(Integer.getInteger("junk", 12345).toString(), (Object)"12345");
        harness.check(Integer.getInteger("junk", new Integer(56789)).toString(), (Object)"56789");
        harness.check(Integer.getInteger("junk", null), null);
        harness.check(Integer.getInteger("junk"), null);
        try {
            harness.check(Integer.getInteger(null), null);
        }
        catch (NullPointerException npe) {
            harness.check(false);
        }
        harness.check(Integer.getInteger(""), null);
        boolean ok = true;
        SecurityManager old_security_manager = System.getSecurityManager();
        try {
            try {
                System.setSecurityManager(this);
            }
            catch (Throwable e) {
                harness.debug(e);
                ok = false;
            }
            if (ok) {
                try {
                    Integer.getInteger("secure");
                    ok = false;
                }
                catch (SecurityException securityException) {
                    // empty catch block
                }
            }
        }
        finally {
            System.setSecurityManager(old_security_manager);
        }
        harness.check(ok);
    }

    @Override
    public void checkPropertyAccess(String s) {
        if ("secure".equals(s)) {
            throw new SecurityException("'Croak'");
        }
        super.checkPropertyAccess(s);
    }

    @Override
    public void checkPermission(Permission p) {
        if (new RuntimePermission("setSecurityManager").implies(p)) {
            return;
        }
        if (new SecurityPermission("getProperty.networkaddress.*").implies(p)) {
            return;
        }
        if (new PropertyPermission("sun.net.inetaddr.ttl", "read").implies(p)) {
            return;
        }
        super.checkPermission(p);
    }
}

