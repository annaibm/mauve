/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet;

import gnu.testlet.ResourceNotFoundException;
import gnu.testlet.config;
import java.awt.AWTException;
import java.awt.Robot;
import java.io.File;
import java.io.InputStream;
import java.io.Reader;

public abstract class TestHarness
implements config {
    public abstract void check(boolean var1);

    public void check(Object result, Object expected) {
        boolean ok = result == null ? expected == null : result.equals(expected);
        this.check(ok);
        if (!ok) {
            this.debug("got " + result + " but expected " + expected);
        }
    }

    public void check(boolean result, boolean expected) {
        boolean ok = result == expected;
        this.check(ok);
        if (!ok) {
            this.debug("got " + result + " but expected " + expected);
        }
    }

    public void check(int result, int expected) {
        boolean ok = result == expected;
        this.check(ok);
        if (!ok) {
            this.debug("got " + result + " but expected " + expected);
        }
    }

    public void check(long result, long expected) {
        boolean ok = result == expected;
        this.check(ok);
        if (!ok) {
            this.debug("got " + result + " but expected " + expected);
        }
    }

    public void check(double result, double expected) {
        boolean ok = result == expected ? result != 0.0 || 1.0 / result == 1.0 / expected : result != result && expected != expected;
        this.check(ok);
        if (!ok) {
            this.debug("got " + result + " but expected " + expected);
        }
    }

    public void check(double result, double expected, double delta) {
        boolean ok = true;
        if (Double.isInfinite(expected)) {
            if (result != expected) {
                ok = false;
            }
        } else if (!(Math.abs(expected - result) <= delta)) {
            ok = false;
        }
        this.check(ok);
        if (!ok) {
            this.debug("got " + result + " but expected " + expected);
        }
    }

    public void check(boolean result, String name2) {
        this.checkPoint(name2);
        this.check(result);
    }

    public void check(Object result, Object expected, String name2) {
        this.checkPoint(name2);
        this.check(result, expected);
    }

    public void check(boolean result, boolean expected, String name2) {
        this.checkPoint(name2);
        this.check(result, expected);
    }

    public void check(int result, int expected, String name2) {
        this.checkPoint(name2);
        this.check(result, expected);
    }

    public void check(long result, long expected, String name2) {
        this.checkPoint(name2);
        this.check(result, expected);
    }

    public void check(double result, double expected, String name2) {
        this.checkPoint(name2);
        this.check(result, expected);
    }

    public Robot createRobot() {
        Robot r = null;
        try {
            r = new Robot();
        }
        catch (AWTException e) {
            this.fail("TestHarness: couldn't create Robot: " + e.getMessage());
        }
        return r;
    }

    public void fail(String name2) {
        this.checkPoint(name2);
        this.check(false);
    }

    public abstract Reader getResourceReader(String var1) throws ResourceNotFoundException;

    public abstract InputStream getResourceStream(String var1) throws ResourceNotFoundException;

    public abstract File getResourceFile(String var1) throws ResourceNotFoundException;

    public abstract void checkPoint(String var1);

    public abstract void verbose(String var1);

    public abstract void debug(String var1);

    public abstract void debug(String var1, boolean var2);

    public abstract void debug(Throwable var1);

    public abstract void debug(Object[] var1, String var2);

    @Override
    public String getSourceDirectory() {
        return "@SRCDIR@";
    }

    @Override
    public String getBuildDirectory() {
        return "@BUILDDIR@";
    }

    @Override
    public String getTempDirectory() {
        return "@TMPDIR@";
    }

    @Override
    public String getPathSeparator() {
        return "@CHECK_PATH_SEPARATOR@";
    }

    @Override
    public String getSeparator() {
        return "@CHECK_FILE_SEPARATOR@";
    }

    @Override
    public String getMailHost() {
        return "@MAIL_HOST@";
    }

    @Override
    public String getAutoCompile() {
        return "@AUTO_COMPILE@";
    }

    @Override
    public String getCpInstallDir() {
        return "@CP_INSTALL_DIR@";
    }

    @Override
    public String getEcjJar() {
        return "@ECJ_JAR@";
    }

    @Override
    public String getEmmaString() {
        return "@EMMA@";
    }

    @Override
    public String getTestJava() {
        return "@TEST_JAVA@";
    }
}

