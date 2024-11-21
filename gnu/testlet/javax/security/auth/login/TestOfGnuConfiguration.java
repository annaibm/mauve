/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.security.auth.login;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.channels.FileChannel;
import java.nio.channels.spi.AbstractInterruptibleChannel;
import java.security.Security;
import javax.security.auth.callback.Callback;
import javax.security.auth.callback.CallbackHandler;
import javax.security.auth.login.Configuration;
import javax.security.auth.login.LoginContext;
import javax.security.auth.login.LoginException;

public class TestOfGnuConfiguration
implements Testlet {
    private static final String CONFIG = "DBLogin {\n        gnu.testlet.javax.security.auth.login.DBLoginModule required;\n};";
    private TestHarness harness;
    private String cfPath;

    @Override
    public void test(TestHarness harness) {
        this.harness = harness;
        this.setUp();
        this.parseFromSecurityProperty();
        this.parseFromSystemProperty();
        this.parseFromUserHome();
        this.nullConfiguration();
        this.teardown();
    }

    private void setUp() {
        this.harness.checkPoint("setUp");
        try {
            File cf = File.createTempFile("auth", ".login");
            cf.deleteOnExit();
            FileWriter fw = new FileWriter(cf);
            fw.write(CONFIG);
            fw.close();
            this.cfPath = cf.getCanonicalPath();
        }
        catch (Exception x) {
            this.harness.debug(x);
            this.harness.fail("setUp");
        }
    }

    private void parseFromSecurityProperty() {
        this.harness.checkPoint("parseFromSecurityProperty");
        try {
            Security.setProperty("java.security.auth.login.config.url.1", this.cfPath);
            LoginContext lc = new LoginContext("DBLogin", new DefaultLoginHandler("", "", ""));
            lc.login();
            this.harness.check(true, "MUST be able to login");
            lc.logout();
            this.harness.check(true, "MUST be able to logout");
        }
        catch (Exception x) {
            this.harness.debug(x);
            this.harness.fail("parseFromSecurityProperty");
        }
    }

    private void parseFromSystemProperty() {
        this.harness.checkPoint("parseFromSystemProperty");
        try {
            Security.setProperty("java.security.auth.login.config.url.1", "");
            System.setProperty("java.security.auth.login.config", this.cfPath);
            Configuration.getConfiguration().refresh();
            LoginContext lc = new LoginContext("DBLogin", new DefaultLoginHandler("", "", ""));
            lc.login();
            this.harness.check(true, "MUST be able to login");
            lc.logout();
            this.harness.check(true, "MUST be able to logout");
        }
        catch (Exception x) {
            this.harness.debug(x);
            this.harness.fail("parseFromSystemProperty");
        }
    }

    private void parseFromUserHome() {
        this.harness.checkPoint("parseFromUserHome");
        File myConfig = null;
        try {
            Security.setProperty("java.security.auth.login.config.url.1", "");
            System.setProperty("java.security.auth.login.config", "");
            myConfig = new File(System.getProperty("user.home"), ".java.login.config");
            myConfig.deleteOnExit();
            this.copy(new File(this.cfPath), myConfig);
            Configuration.getConfiguration().refresh();
            LoginContext lc = new LoginContext("DBLogin", new DefaultLoginHandler("", "", ""));
            lc.login();
            this.harness.check(true, "MUST be able to login");
            lc.logout();
            this.harness.check(true, "MUST be able to logout");
        }
        catch (Exception x) {
            this.harness.debug(x);
            this.harness.fail("parseFromUserHome");
        }
        finally {
            if (myConfig != null) {
                myConfig.delete();
            }
        }
    }

    private void nullConfiguration() {
        this.harness.checkPoint("nullConfiguration");
        try {
            Security.setProperty("java.security.auth.login.config.url.1", "");
            System.setProperty("java.security.auth.login.config", "");
            Configuration.getConfiguration().refresh();
            try {
                new LoginContext("DBLogin", new DefaultLoginHandler("", "", ""));
                this.harness.fail("MUST NOT be able to create context");
            }
            catch (LoginException x) {
                this.harness.check(true, "MUST NOT be able to create context");
            }
        }
        catch (Exception x) {
            this.harness.debug(x);
            this.harness.fail("nullConfiguration");
        }
    }

    private void teardown() {
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private void copy(File src, File dst) throws IOException {
        if (!dst.exists()) {
            dst.createNewFile();
        }
        FileChannel source = null;
        AbstractInterruptibleChannel destination = null;
        try {
            source = new FileInputStream(src).getChannel();
            destination = new FileOutputStream(dst).getChannel();
            ((FileChannel)destination).transferFrom(source, 0L, source.size());
        }
        finally {
            if (source != null) {
                source.close();
            }
            if (destination != null) {
                destination.close();
            }
        }
    }

    class DefaultLoginHandler
    implements CallbackHandler {
        public DefaultLoginHandler(String u, String p, String d) {
        }

        @Override
        public void handle(Callback[] callbacks) {
        }
    }
}

