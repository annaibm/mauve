/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.util.logging.Logger;

import java.security.AccessControlException;
import java.security.Permission;
import java.util.logging.LogManager;
import java.util.logging.LoggingPermission;

public class TestSecurityManager
extends SecurityManager {
    private boolean grantLogging = false;
    private final Permission controlPermission = new LoggingPermission("control", null);
    private SecurityManager oldManager;

    @Override
    public void checkPermission(Permission perm) {
        if (this.controlPermission.implies(perm) && !this.grantLogging) {
            throw new AccessControlException("access denied: " + perm, perm);
        }
    }

    public void setGrantLoggingControl(boolean grant) {
        this.grantLogging = grant;
    }

    public void install() {
        LogManager lm = LogManager.getLogManager();
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

