/*
 * Decompiled with CFR 0.152.
 */
import gnu.testlet.ResourceNotFoundException;
import gnu.testlet.TestHarness;
import gnu.testlet.TestReport;
import gnu.testlet.TestResult;
import gnu.testlet.TestSecurityManager;
import gnu.testlet.Testlet;
import gnu.testlet.VisualTestlet;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.Vector;

public class RunnerProcess
extends TestHarness {
    private static final String NOT_A_TEST_DESCRIPTION = "not-a-test";
    private static final String FAIL_TO_LOAD_DESCRIPTION = "failed-to-load";
    private static final String UNCAUGHT_EXCEPTION_DESCRIPTION = "uncaught-exception";
    private int count = 0;
    private static String emmaJarLocation = null;
    private static boolean useEMMA = true;
    private int failures = 0;
    private static Vector<String> expectedXfails = new Vector();
    private int xfailures = 0;
    private int xpasses = 0;
    private int total = 0;
    private static boolean verbose = false;
    private static boolean debug = false;
    private static boolean exceptions = true;
    private String description;
    private String last_check;
    private static TestReport report = null;
    private static String xmlfile = null;
    private TestResult currentResult = null;
    private static Method emmaMethod = null;
    private String lastFailureMessage = null;
    private static boolean interactive;
    private static boolean isAutoXml;
    private static String autoXmlDir;

    protected RunnerProcess() {
        try {
            String str;
            BufferedReader xfile = new BufferedReader(new FileReader("xfails"));
            while ((str = xfile.readLine()) != null) {
                expectedXfails.addElement(str);
            }
        }
        catch (FileNotFoundException fileNotFoundException) {
        }
        catch (IOException iOException) {
            // empty catch block
        }
    }

    public static void main(String[] args) {
        String testname = null;
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        for (int i = 0; i < args.length; ++i) {
            if (args[i].equals("-verbose")) {
                verbose = true;
                continue;
            }
            if (args[i].equals("-debug")) {
                debug = true;
                continue;
            }
            if (args[i].equals("-noexceptions")) {
                exceptions = false;
                continue;
            }
            if (args[i].equals("-xmlout")) {
                if (++i >= args.length) {
                    throw new RuntimeException("No file path after '-xmlout'.");
                }
                xmlfile = args[i];
                continue;
            }
            if (args[i].equalsIgnoreCase("-emma")) {
                if (++i >= args.length) {
                    throw new RuntimeException("No file path after '-emma'.  Exit");
                }
                emmaJarLocation = args[i];
                continue;
            }
            if (args[i].equals("-interactive")) {
                interactive = true;
                continue;
            }
            if (!args[i].equals("-autoxml") || xmlfile != null) continue;
            isAutoXml = true;
            if (++i >= args.length) {
                throw new RuntimeException("No file path after '-autoxml'.");
            }
            autoXmlDir = args[i];
        }
        if (xmlfile != null) {
            report = new TestReport(System.getProperties());
        }
        if (emmaJarLocation == null) {
            emmaJarLocation = "@EMMA@";
        }
        try {
            RunnerProcess.setupEMMA(!emmaJarLocation.equals("_auto_detect_emma_"));
        }
        catch (Exception emmaException) {
            useEMMA = false;
        }
        while (true) {
            File f;
            block31: {
                try {
                    testname = in.readLine();
                    if (testname == null) {
                        System.exit(0);
                    }
                    if (isAutoXml && !testname.equals("_dump_data_") && !testname.equals("_confirm_startup_")) {
                        report = null;
                        xmlfile = RunnerProcess.getReportFileReady(testname);
                        report = new TestReport(System.getProperties());
                    }
                    if (testname.equals("_dump_data_")) {
                        if (report != null) {
                            f = new File(xmlfile);
                            try {
                                report.writeXml(f);
                            }
                            catch (IOException e) {
                                throw new Error("Failed to write data to xml file: " + e.getMessage());
                            }
                        }
                        if (useEMMA) {
                            RunnerProcess.dumpCoverageData();
                        } else {
                            System.out.println("_data_dump_okay_");
                        }
                        break block31;
                    }
                    if (testname.equals("_confirm_startup_")) {
                        System.out.println("_startup_okay_");
                    } else {
                        RunnerProcess harness = new RunnerProcess();
                        RunnerProcess.runAndReport(harness, testname);
                    }
                }
                catch (IOException ioe) {
                    String shortName = RunnerProcess.stripPrefix(testname);
                    if (verbose) {
                        System.out.println("TEST: " + shortName + "\n  FAIL: failed to load\nTEST FAILED: failed to load " + shortName);
                    } else {
                        System.out.println("FAIL: " + RunnerProcess.stripPrefix(testname) + "\n  failed to load");
                    }
                    System.out.println("RunnerProcess:fail-0");
                }
            }
            if (report == null || !isAutoXml) continue;
            f = new File(xmlfile);
            try {
                report.writeXml(f);
            }
            catch (IOException e) {
                throw new Error("Failed to write data to xml file: " + e.getMessage());
            }
        }
    }

    protected void runtest(String name2) {
        System.gc();
        System.runFinalization();
        this.currentResult = new TestResult(name2.substring(12));
        this.description = name2;
        this.checkPoint(null);
        Testlet t = null;
        try {
            Class<?> k = Class.forName(name2);
            int mods = k.getModifiers();
            if (Modifier.isAbstract(mods)) {
                this.description = NOT_A_TEST_DESCRIPTION;
                return;
            }
            Object o = k.newInstance();
            if (!(o instanceof Testlet)) {
                this.description = NOT_A_TEST_DESCRIPTION;
                return;
            }
            if (o instanceof VisualTestlet) {
                if (!interactive) {
                    this.description = NOT_A_TEST_DESCRIPTION;
                    return;
                }
            } else if (interactive) {
                this.description = NOT_A_TEST_DESCRIPTION;
                return;
            }
            t = (Testlet)o;
        }
        catch (Throwable ex) {
            this.description = FAIL_TO_LOAD_DESCRIPTION;
            try {
                File f = new File(name2.replace('.', File.separatorChar) + ".java");
                BufferedReader r = new BufferedReader(new FileReader(f));
                String firstLine = r.readLine();
                while (firstLine != null) {
                    if (firstLine.indexOf(NOT_A_TEST_DESCRIPTION) != -1) {
                        this.description = NOT_A_TEST_DESCRIPTION;
                        return;
                    }
                    firstLine = r.readLine();
                }
            }
            catch (FileNotFoundException f) {
            }
            catch (IOException f) {
                // empty catch block
            }
            String r = RunnerProcess.getStackTraceString(ex, "          ");
            this.currentResult.addException(ex, "failed loading class ", r);
            this.debug(ex);
            if (ex instanceof InstantiationException || ex instanceof IllegalAccessException) {
                this.debug("Hint: is the code we just loaded a public non-abstract class with a public nullary constructor???");
            }
            if (!verbose) {
                System.out.println("FAIL: " + RunnerProcess.stripPrefix(name2) + "\n  exception when loading:");
            } else {
                System.out.println("TEST: " + RunnerProcess.stripPrefix(name2));
                System.out.println("  FAIL: exception when loading");
            }
            if (exceptions) {
                System.out.println(RunnerProcess.getStackTraceString(ex, "   "));
            }
            if (verbose) {
                System.out.println("TEST FAILED: exception when loading " + RunnerProcess.stripPrefix(name2));
            }
            if (report != null) {
                report.addTestResult(this.currentResult);
            }
            return;
        }
        if (t != null) {
            try {
                if (verbose) {
                    System.out.println("TEST: " + RunnerProcess.stripPrefix(name2));
                }
                t.test(this);
                this.removeSecurityManager();
            }
            catch (Throwable ex) {
                String d = this.exceptionDetails(ex, name2, exceptions);
                String r = RunnerProcess.getStackTraceString(ex, "          ");
                if (this.failures == 0 && !verbose) {
                    System.out.println("FAIL: " + RunnerProcess.stripPrefix(name2));
                }
                System.out.println(d);
                this.removeSecurityManager();
                this.currentResult.addException(ex, d, r);
                if (exceptions) {
                    System.out.println(RunnerProcess.getStackTraceString(ex, "   "));
                }
                this.debug(ex);
                if (verbose) {
                    System.out.println("TEST FAILED: uncaught exception " + RunnerProcess.stripPrefix(this.description));
                }
                this.description = UNCAUGHT_EXCEPTION_DESCRIPTION;
            }
        }
        if (report != null) {
            report.addTestResult(this.currentResult);
        }
    }

    private static String getStackTraceString(Throwable ex, String pad) {
        StackTraceElement[] st = ex.getStackTrace();
        StringBuffer sb = new StringBuffer(pad + ex.toString() + "\n");
        for (int i = 0; i < st.length; ++i) {
            sb.append(pad + "at " + st[i].toString() + "\n");
        }
        sb.setLength(sb.length() - 1);
        return sb.toString();
    }

    static void runAndReport(RunnerProcess harness, String testName2) {
        harness.runtest(testName2.replace(File.separatorChar, '.'));
        if (harness.description.equals(NOT_A_TEST_DESCRIPTION)) {
            System.out.println("RunnerProcess:not-a-test");
            return;
        }
        if (harness.description.equals(FAIL_TO_LOAD_DESCRIPTION)) {
            System.out.println("RunnerProcess:fail-0");
            return;
        }
        if (harness.description.equals(UNCAUGHT_EXCEPTION_DESCRIPTION)) {
            System.out.println("RunnerProcess:fail-0");
            return;
        }
        int temp = harness.done();
        if (temp == 0) {
            System.out.println("RunnerProcess:pass");
        } else {
            System.out.println("RunnerProcess:fail-" + temp);
        }
    }

    private final String getDescription(StackTraceElement[] st) {
        int line = -1;
        String fileName = this.description.substring(this.description.lastIndexOf(46) + 1);
        fileName = fileName + ".java";
        for (int i = 0; i < st.length; ++i) {
            if (!st[i].getClassName().startsWith(this.description) || !st[i].getFileName().equals(fileName)) continue;
            line = st[i].getLineNumber();
            break;
        }
        return "  line " + line + ": " + (this.last_check == null ? "" : this.last_check) + " [" + (this.count + 1) + "]";
    }

    protected int getFailures() {
        return this.failures;
    }

    private static String stripPrefix(String val) {
        if (val.startsWith("gnu.testlet.")) {
            val = val.substring(12);
        }
        return val;
    }

    @Override
    public void fail(String name2) {
        this.checkPoint(name2);
        String desc = this.check2(false);
        this.lastFailureMessage = "forced fail";
        this.currentResult.addFail(desc + " -- " + this.lastFailureMessage);
        System.out.println(this.lastFailureMessage);
    }

    @Override
    public void check(Object result, Object expected) {
        boolean ok = result == null ? expected == null : result.equals(expected);
        String desc = this.check2(ok);
        if (!ok) {
            String expString;
            String gotString = result == null ? "null" : result.getClass().getName();
            String string = expString = expected == null ? "null" : expected.getClass().getName();
            if (gotString.equals(expString)) {
                if (debug) {
                    gotString = result.toString();
                    expString = expected.toString();
                    this.lastFailureMessage = "\n           got " + gotString + "\n\n           but expected " + expString + "\n\n";
                } else {
                    this.lastFailureMessage = "Objects were not equal.  Use -debug for more information.";
                }
            } else {
                this.lastFailureMessage = "got " + gotString + " but expected " + expString;
            }
            this.currentResult.addFail(desc + " -- " + this.lastFailureMessage);
            System.out.println(this.lastFailureMessage);
        }
    }

    @Override
    public void check(boolean result, boolean expected) {
        boolean ok = result == expected;
        String desc = this.check2(ok);
        if (!ok) {
            this.lastFailureMessage = "got " + result + " but expected " + expected;
            this.currentResult.addFail(desc + " -- " + this.lastFailureMessage);
            System.out.println(this.lastFailureMessage);
        }
    }

    @Override
    public void check(int result, int expected) {
        boolean ok = result == expected;
        String desc = this.check2(ok);
        if (!ok) {
            this.lastFailureMessage = "got " + result + " but expected " + expected;
            this.currentResult.addFail(desc + " -- " + this.lastFailureMessage);
            System.out.println(this.lastFailureMessage);
        }
    }

    @Override
    public void check(long result, long expected) {
        boolean ok = result == expected;
        String desc = this.check2(ok);
        if (!ok) {
            this.lastFailureMessage = "got " + result + " but expected " + expected;
            this.currentResult.addFail(desc + " -- " + this.lastFailureMessage);
            System.out.println(this.lastFailureMessage);
        }
    }

    @Override
    public void check(double result, double expected) {
        boolean ok = result == expected ? result != 0.0 || 1.0 / result == 1.0 / expected : result != result && expected != expected;
        String desc = this.check2(ok);
        if (!ok) {
            this.lastFailureMessage = "got " + result + " but expected " + expected;
            this.currentResult.addFail(desc + " -- " + this.lastFailureMessage);
            System.out.println(this.lastFailureMessage);
        }
    }

    @Override
    public void check(boolean result) {
        String desc = this.check2(result);
        if (!result) {
            this.lastFailureMessage = "boolean passed to check was false";
            this.currentResult.addFail(desc + " -- " + this.lastFailureMessage);
            System.out.println(this.lastFailureMessage);
        }
    }

    private String check2(boolean result) {
        System.out.println("RunnerProcess:restart-timer");
        StackTraceElement[] st = new Throwable().getStackTrace();
        String desc = this.getDescription(st);
        if (!result) {
            if (!expectedXfails.contains(desc)) {
                if (this.failures == 0 && !verbose) {
                    System.out.println("FAIL: " + RunnerProcess.stripPrefix(this.description));
                }
                if (verbose) {
                    System.out.print("  FAIL:");
                }
                System.out.print(desc + " -- ");
                ++this.failures;
            } else if (verbose) {
                System.out.println("X" + desc + " -- ");
                ++this.xfailures;
            }
        } else {
            this.currentResult.addPass(desc);
            if (verbose) {
                if (expectedXfails.contains(desc)) {
                    System.out.println("XPASS: " + desc);
                    ++this.xpasses;
                } else {
                    System.out.println("  pass:" + desc);
                }
            }
        }
        ++this.count;
        ++this.total;
        return desc;
    }

    @Override
    public Reader getResourceReader(String name2) throws ResourceNotFoundException {
        return new BufferedReader(new InputStreamReader(this.getResourceStream(name2)));
    }

    @Override
    public InputStream getResourceStream(String name2) throws ResourceNotFoundException {
        if (File.separator.length() > 1) {
            throw new Error("File.separator length is greater than 1");
        }
        String realName = name2.replace('#', File.separator.charAt(0));
        try {
            return new FileInputStream(this.getSourceDirectory() + File.separator + realName);
        }
        catch (FileNotFoundException ex) {
            throw new ResourceNotFoundException(ex.getLocalizedMessage() + ": " + this.getSourceDirectory() + File.separator + realName);
        }
    }

    @Override
    public File getResourceFile(String name2) throws ResourceNotFoundException {
        if (File.separator.length() > 1) {
            throw new Error("File.separator length is greater than 1");
        }
        String realName = name2.replace('#', File.separator.charAt(0));
        File f = new File(this.getSourceDirectory() + File.separator + realName);
        if (!f.exists()) {
            throw new ResourceNotFoundException("cannot find mauve resource file: " + this.getSourceDirectory() + File.separator + realName);
        }
        return f;
    }

    @Override
    public void checkPoint(String name2) {
        this.last_check = name2;
        this.count = 0;
    }

    @Override
    public void verbose(String message) {
        if (verbose) {
            System.out.println(message);
        }
    }

    @Override
    public void debug(String message) {
        this.debug(message, true);
    }

    @Override
    public void debug(String message, boolean newline) {
        if (debug) {
            if (newline) {
                System.out.println(message);
            } else {
                System.out.print(message);
            }
        }
    }

    @Override
    public void debug(Throwable ex) {
        if (debug) {
            ex.printStackTrace(System.out);
        }
    }

    @Override
    public void debug(Object[] o, String desc) {
        this.debug("Dumping Object Array: " + desc);
        if (o == null) {
            this.debug("null");
            return;
        }
        for (int i = 0; i < o.length; ++i) {
            if (o[i] instanceof Object[]) {
                this.debug((Object[])o[i], desc + " element " + i);
                continue;
            }
            this.debug("  Element " + i + ": " + o[i]);
        }
    }

    private void removeSecurityManager() {
        SecurityManager sm;
        while ((sm = System.getSecurityManager()) instanceof TestSecurityManager) {
            this.debug("warning: TestSecurityManager was not uninstalled");
            ((TestSecurityManager)sm).uninstall();
        }
    }

    private String exceptionDetails(Throwable ex, String name2, boolean exceptions) {
        StackTraceElement[] st = ex.getStackTrace();
        if (st == null || st.length == 0) {
            return "  uncaught exception:";
        }
        int lineOrigin = -1;
        String fileName = name2.substring(name2.lastIndexOf(46) + 1);
        fileName = fileName + ".java";
        for (int i = 0; i < st.length; ++i) {
            if (!st[i].getClassName().startsWith(name2) || !st[i].getFileName().equals(fileName)) continue;
            lineOrigin = st[i].getLineNumber();
            break;
        }
        StringBuffer sb = new StringBuffer("  " + (verbose ? "FAIL: " : "") + "line " + lineOrigin + ": " + (this.last_check == null ? "" : this.last_check) + " [" + (this.count + 1) + "] -- uncaught exception:");
        if (exceptions) {
            return sb.toString();
        }
        sb.append("\n  " + ex.getClass().getName() + " in ");
        sb.append(RunnerProcess.stripPrefix(st[0].getClassName()) + "." + st[0].getMethodName() + " (line " + st[0].getLineNumber() + ")");
        sb.append("\n  Run tests with -exceptions to print exception stack traces.");
        return sb.toString();
    }

    protected int done() {
        if (this.failures > 0 && verbose) {
            System.out.print("TEST FAILED: ");
            System.out.println(this.failures + " of " + this.total + " checks failed " + RunnerProcess.stripPrefix(this.description));
        } else if (verbose) {
            System.out.println("TEST PASSED (" + this.total + " checks) " + RunnerProcess.stripPrefix(this.description));
        }
        if (this.xpasses > 0) {
            System.out.println(this.xpasses + " of " + this.total + " tests unexpectedly passed");
        }
        if (this.xfailures > 0) {
            System.out.println(this.xfailures + " of " + this.total + " tests expectedly failed");
        }
        return this.failures;
    }

    private static void setupEMMA(boolean useJar) throws Exception {
        ClassNotFoundException cnfe = null;
        Class<?> klass = null;
        String classname = "com.vladium.emma.rt.RT";
        if (!useJar) {
            try {
                klass = Class.forName(classname);
            }
            catch (ClassNotFoundException e) {
                cnfe = e;
                useJar = true;
            }
        }
        if (useJar) {
            File jar = new File(emmaJarLocation);
            if (!jar.exists() || !jar.canRead()) {
                throw cnfe;
            }
            URLClassLoader loader = new URLClassLoader(new URL[]{jar.toURL()});
            try {
                klass = loader.loadClass(classname);
            }
            catch (ClassNotFoundException f) {
                throw cnfe;
            }
        }
        emmaMethod = klass.getMethod("dumpCoverageData", File.class, Boolean.TYPE, Boolean.TYPE);
    }

    private static void dumpCoverageData() {
        try {
            emmaMethod.invoke(null, new File("coverage.ec"), Boolean.TRUE, Boolean.TRUE);
        }
        catch (Exception exception) {
            // empty catch block
        }
        System.out.println("_data_dump_okay_");
    }

    private static String getReportFileReady(String testcase) {
        testcase = testcase.replace("gnu/testlet", autoXmlDir);
        try {
            new File(testcase.substring(0, testcase.lastIndexOf("/"))).mkdirs();
        }
        catch (Exception ex) {
            System.err.println("Unable to create XML file path: " + ex);
            System.exit(1);
        }
        return testcase + ".xml";
    }

    static {
        autoXmlDir = null;
    }
}

