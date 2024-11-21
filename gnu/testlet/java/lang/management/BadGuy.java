/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.lang.management;

import java.lang.management.ManagementPermission;
import java.security.AccessControlException;
import java.security.Permission;
import java.util.PropertyPermission;

public class BadGuy
extends SecurityManager {
    private final Permission propertyPermission = new PropertyPermission("*", "read,write");
    private final Permission monitorPermission = new ManagementPermission("monitor");
    private final Permission controlPermission = new ManagementPermission("control");
    private SecurityManager oldManager;

    @Override
    public void checkPermission(Permission p) {
        if (this.propertyPermission.implies(p)) {
            throw new AccessControlException("Property access disallowed.", p);
        }
        if (this.controlPermission.implies(p)) {
            throw new AccessControlException("Management control disallowed.", p);
        }
        if (this.monitorPermission.implies(p)) {
            throw new AccessControlException("Monitoring disallowed.", p);
        }
    }

    public void install() {
        SecurityManager oldsm = System.getSecurityManager();
        if (oldsm == this) {
            throw new IllegalStateException("already installed");
        }
        this.oldManager = oldsm;
        System.setSecurityManager(this);
    }

    public void uninstall() {
        System.setSecurityManager(this.oldManager);
    }
}

