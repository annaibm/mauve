/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.security.auth.login;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.io.File;
import java.io.FileWriter;
import javax.security.auth.callback.Callback;
import javax.security.auth.callback.CallbackHandler;
import javax.security.auth.login.LoginContext;

public class TestOfPR25202
implements Testlet {
    private static final String CONFIG = "DBLogin {\n        gnu.testlet.javax.security.auth.login.DBLoginModule required;\n};";
    private TestHarness harness;

    @Override
    public void test(TestHarness harness) {
        this.harness = harness;
        this.setUp();
        this.pr25202();
        this.teardown();
    }

    private void pr25202() {
        this.harness.checkPoint("pr25202");
        try {
            LoginContext lc = new LoginContext("DBLogin", new DefaultLoginHandler("", "", ""));
            lc.login();
            this.harness.check(true, "MUST be able to login");
            lc.logout();
            this.harness.check(true, "MUST be able to logout");
        }
        catch (Exception x) {
            this.harness.debug(x);
            this.harness.fail("pr25202");
        }
    }

    private void setUp() {
        this.harness.checkPoint("setUp");
        try {
            File cf = File.createTempFile("auth", ".login");
            cf.deleteOnExit();
            FileWriter fw = new FileWriter(cf);
            fw.write(CONFIG);
            fw.close();
            String cfPath = cf.getCanonicalPath();
            System.setProperty("java.security.auth.login.config", cfPath);
        }
        catch (Exception x) {
            this.harness.debug(x);
            this.harness.fail("setUp");
        }
    }

    private void teardown() {
    }

    public class DefaultLoginHandler
    implements CallbackHandler {
        public DefaultLoginHandler(String username, String password, String domain) {
        }

        @Override
        public void handle(Callback[] callbacks) {
        }
    }
}

