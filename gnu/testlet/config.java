/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet;

public interface config {
    public static final String cpInstallDir = "@CP_INSTALL_DIR@";
    public static final String autoCompile = "@AUTO_COMPILE@";
    public static final String testJava = "@TEST_JAVA@";
    public static final String ecjJar = "@ECJ_JAR@";
    public static final String emmaString = "@EMMA@";
    public static final String srcdir = "@SRCDIR@";
    public static final String builddir = "@BUILDDIR@";
    public static final String tmpdir = "@TMPDIR@";
    public static final String pathSeparator = "@CHECK_PATH_SEPARATOR@";
    public static final String separator = "@CHECK_FILE_SEPARATOR@";
    public static final String mailHost = "@MAIL_HOST@";

    public String getCpInstallDir();

    public String getAutoCompile();

    public String getTestJava();

    public String getEcjJar();

    public String getEmmaString();

    public String getSourceDirectory();

    public String getBuildDirectory();

    public String getTempDirectory();

    public String getPathSeparator();

    public String getSeparator();

    public String getMailHost();
}

