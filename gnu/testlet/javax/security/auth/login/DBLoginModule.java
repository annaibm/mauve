/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.security.auth.login;

import java.util.Map;
import javax.security.auth.Subject;
import javax.security.auth.callback.CallbackHandler;
import javax.security.auth.login.LoginException;
import javax.security.auth.spi.LoginModule;

public class DBLoginModule
implements LoginModule {
    @Override
    public boolean abort() throws LoginException {
        return true;
    }

    @Override
    public boolean commit() throws LoginException {
        return true;
    }

    public void initialize(Subject subject, CallbackHandler handler, Map sharedState, Map options) {
    }

    @Override
    public boolean login() throws LoginException {
        return true;
    }

    @Override
    public boolean logout() throws LoginException {
        return true;
    }
}

