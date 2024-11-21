/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.runner;

import gnu.testlet.ResourceNotFoundException;
import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import gnu.testlet.runner.CheckResult;
import gnu.testlet.runner.ClassResult;
import gnu.testlet.runner.HTMLGenerator;
import gnu.testlet.runner.PackageResult;
import gnu.testlet.runner.RunResult;
import gnu.testlet.runner.TestResult;
import gnu.testlet.runner.XMLReportWriter;
import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.LineNumberReader;
import java.io.PrintWriter;
import java.io.Reader;
import java.util.Locale;

public class Mauve
extends TestHarness {
    protected String lastCheckPoint;
    protected int checksSinceLastCheckPoint;
    protected ClassResult classResult;
    protected TestResult currentTest;
    protected CheckResult currentCheck;
    protected RunResult result;

    public synchronized void execute(String file, String prefix, String output) {
        Locale savedLocale = Locale.getDefault();
        File out = new File(output);
        if (out.exists() && !out.isDirectory()) {
            throw new IllegalArgumentException("Output should be a directory");
        }
        if (!out.exists()) {
            out.mkdirs();
        }
        this.result = new RunResult("Mauve Test Run");
        this.addSystemProperties(this.result);
        this.currentCheck = new CheckResult(0, false);
        File f = new File(file);
        try {
            FileReader testsToRun = new FileReader(f);
            LineNumberReader r = new LineNumberReader(testsToRun);
            while (r.ready()) {
                String line = r.readLine();
                this.executeLine(prefix, line);
            }
        }
        catch (FileNotFoundException e) {
            throw new IllegalArgumentException(e.getMessage());
        }
        catch (IOException e) {
            e.printStackTrace(System.out);
        }
        Locale.setDefault(savedLocale);
        this.writeHTMLReport(out);
        this.writeXMLReport(out);
        System.out.println("DONE!");
    }

    protected void addSystemProperties(RunResult runResult) {
        runResult.setSystemProperty("java.version", System.getProperty("java.version"));
        runResult.setSystemProperty("java.vendor", System.getProperty("java.vendor"));
        runResult.setSystemProperty("java.vendor.url", System.getProperty("java.vendor.url"));
        runResult.setSystemProperty("os.name", System.getProperty("os.name"));
        runResult.setSystemProperty("os.arch", System.getProperty("os.arch"));
        runResult.setSystemProperty("os.version", System.getProperty("os.version"));
        runResult.setSystemProperty("java.vm.specification.version", System.getProperty("java.vm.specification.version"));
        runResult.setSystemProperty("java.vm.specification.vendor", System.getProperty("java.vm.specification.vendor"));
        runResult.setSystemProperty("java.vm.specification.name", System.getProperty("java.vm.specification.name"));
        runResult.setSystemProperty("java.vm.version", System.getProperty("java.vm.version"));
        runResult.setSystemProperty("java.vm.vendor", System.getProperty("java.vm.vendor"));
        runResult.setSystemProperty("java.vm.name", System.getProperty("java.vm.name"));
        runResult.setSystemProperty("java.specification.version", System.getProperty("java.specification.version"));
        runResult.setSystemProperty("java.specification.vendor", System.getProperty("java.specification.vendor"));
        runResult.setSystemProperty("java.specification.name", System.getProperty("java.specification.name"));
        runResult.setSystemProperty("java.class.version", System.getProperty("java.class.version"));
    }

    protected void executeLine(String prefix, String line) {
        if (line == null || line.trim().length() == 0) {
            return;
        }
        System.out.println(line);
        try {
            Testlet testlet;
            PackageResult pr;
            Class<?> c = Class.forName(line);
            String temp = line.substring(prefix.length());
            String testName2 = temp.substring(temp.lastIndexOf(46) + 1);
            temp = temp.substring(0, temp.lastIndexOf(46));
            String className = temp.substring(temp.lastIndexOf(46) + 1);
            if ((className.equals("Double") || className.equals("Float") || className.equals("Key")) && !temp.startsWith("java.lang.")) {
                temp = temp.substring(0, temp.lastIndexOf(46));
                className = temp.substring(temp.lastIndexOf(46) + 1) + '.' + className;
            }
            String packageName = "default package";
            int index = temp.lastIndexOf(46);
            if (index >= 0) {
                packageName = temp.substring(0, temp.lastIndexOf(46));
            }
            if ((pr = this.result.getPackageResult(packageName)) == null) {
                pr = new PackageResult(packageName);
            }
            this.classResult = pr.getClassResult(className);
            if (this.classResult == null) {
                this.classResult = new ClassResult(className);
            }
            if ((testlet = this.createTestlet(c, line)) != null) {
                this.runTestlet(testlet, pr, testName2);
            }
        }
        catch (ClassNotFoundException e) {
            System.err.println("Could not load test: " + line);
            this.result.addMissingTest(line);
        }
    }

    protected void runTestlet(Testlet testlet, PackageResult pr, String testName2) {
        this.currentTest = new TestResult(testName2);
        this.checksSinceLastCheckPoint = 0;
        this.lastCheckPoint = "-";
        try {
            testlet.test(this);
        }
        catch (Throwable t) {
            t.printStackTrace(System.out);
            this.currentTest.failed(t);
        }
        this.classResult.add(this.currentTest);
        if (pr.indexOf(this.classResult) < 0) {
            pr.add(this.classResult);
        }
        if (this.result.indexOf(pr) == -1) {
            this.result.add(pr);
        }
    }

    protected RunResult getResult() {
        return this.result;
    }

    protected Testlet createTestlet(Class c, String line) {
        Testlet testlet = null;
        try {
            testlet = (Testlet)c.newInstance();
        }
        catch (ClassCastException e) {
            System.err.println("Not a test (does not implement Testlet): " + line);
            this.result.addFaultyTest(line, "Does not implement Testlet");
        }
        catch (Throwable t) {
            t.printStackTrace(System.out);
            this.result.addFaultyTest(line, t.getMessage());
        }
        return testlet;
    }

    protected void writeHTMLReport(File outputDir) {
        System.out.println("Creating HTML report...");
        try {
            HTMLGenerator.createReport(this.result, outputDir);
        }
        catch (IOException e) {
            System.out.println("failed to write HTML due to following error:");
            e.printStackTrace(System.out);
        }
    }

    protected void writeXMLReport(File outputDir) {
        System.out.println("Creating XML report...");
        try {
            File fx = new File(outputDir, "results.xml");
            new XMLReportWriter(true).write(this.result, fx);
            System.out.println("XML file written to " + fx.getAbsolutePath());
        }
        catch (IOException e) {
            System.out.println("failed to write XML due to following error:");
            e.printStackTrace(System.out);
        }
    }

    @Override
    public void check(boolean result) {
        this.currentCheck.setPassed(result);
        this.checkDone();
    }

    @Override
    public void check(Object result, Object expected) {
        this.currentCheck.setPassed(result != null ? result.equals(expected) : expected == null);
        this.currentCheck.setActual(result != null ? result.toString() : "null");
        this.currentCheck.setExpected(expected != null ? expected.toString() : "null");
        this.checkDone();
    }

    @Override
    public void check(boolean result, boolean expected) {
        this.currentCheck.setPassed(result == expected);
        this.currentCheck.setActual(String.valueOf(result));
        this.currentCheck.setExpected(String.valueOf(expected));
        this.checkDone();
    }

    @Override
    public void check(int result, int expected) {
        this.currentCheck.setPassed(result == expected);
        this.currentCheck.setActual(String.valueOf(result));
        this.currentCheck.setExpected(String.valueOf(expected));
        this.checkDone();
    }

    @Override
    public void check(long result, long expected) {
        this.currentCheck.setPassed(result == expected);
        this.currentCheck.setActual(String.valueOf(result));
        this.currentCheck.setExpected(String.valueOf(expected));
        this.checkDone();
    }

    @Override
    public void check(double result, double expected) {
        this.currentCheck.setPassed(result == expected ? result != 0.0 || 1.0 / result == 1.0 / expected : result != result && expected != expected);
        this.currentCheck.setActual(String.valueOf(result));
        this.currentCheck.setExpected(String.valueOf(expected));
        this.checkDone();
    }

    @Override
    public void checkPoint(String name2) {
        this.lastCheckPoint = name2;
        this.checksSinceLastCheckPoint = 0;
    }

    private void checkDone() {
        this.currentCheck.setNumber(++this.checksSinceLastCheckPoint);
        this.currentCheck.setCheckPoint(this.lastCheckPoint);
        this.currentTest.add(this.currentCheck);
        this.currentCheck = new CheckResult(0, false);
        this.currentCheck.setCheckPoint(this.lastCheckPoint);
    }

    @Override
    public void debug(String message) {
        this.debug(message, true);
    }

    @Override
    public void debug(String message, boolean newline) {
        this.currentCheck.appendToLog(message);
        if (newline) {
            this.currentCheck.appendToLog("\n");
        }
    }

    @Override
    public void debug(Object[] o, String desc) {
        StringBuffer logMessage = new StringBuffer();
        logMessage.append("Object array: ");
        logMessage.append(desc);
        if (o == null) {
            logMessage.append("null");
        } else {
            this.expand(o, logMessage);
        }
        this.currentCheck.appendToLog(logMessage.toString());
        this.currentCheck.appendToLog("\n");
    }

    private void expand(Object[] array, StringBuffer buf) {
        for (int i = 0; i < array.length; ++i) {
            buf.append("obj[" + i + "]: ");
            if (array[i] instanceof Object[]) {
                this.expand((Object[])array[i], buf);
            } else if (array[i] != null) {
                buf.append(array[i].toString());
            } else {
                buf.append("null");
            }
            if (i >= array.length) continue;
            buf.append(", ");
        }
    }

    @Override
    public void debug(Throwable ex) {
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        PrintWriter w = new PrintWriter(out, false);
        ex.printStackTrace(w);
        w.close();
        try {
            out.close();
            this.debug(out.toString(), true);
        }
        catch (IOException iOException) {
            // empty catch block
        }
    }

    @Override
    public void verbose(String message) {
        this.debug(message, true);
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
    public String getSourceDirectory() {
        return null;
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
    public String getTempDirectory() {
        return "/tmp";
    }

    public static void main(String[] args) {
        String file = "tests";
        String prefix = "gnu.testlet.";
        String output = "results";
        for (int i = 0; i < args.length; ++i) {
            String a = args[i];
            if (a.equals("--prefix") || a.equals("-p")) {
                if (i < args.length) {
                    prefix = args[i + 1];
                    ++i;
                    continue;
                }
                System.err.println("prefix: value missing");
                return;
            }
            if (a.equals("--output") || a.equals("-o")) {
                if (i < args.length) {
                    output = args[i + 1];
                    ++i;
                    continue;
                }
                System.err.println("output: value missing");
                return;
            }
            if (a.equals("--help") || a.equals("-h")) {
                System.out.println("Usage:  Mauve [options] [inputfile]");
                System.out.println("reads test-class names from inputfile and executes them;");
                System.out.println("If no inputfile is passed, then tests.txt will be used");
                System.out.println(" options:");
                System.out.println("   --help    -h   this help");
                System.out.println("   --output  -o   the output directory [results]");
                System.out.println("   --prefix  -p   package prefix [gnu.testlet]");
                return;
            }
            file = a;
        }
        try {
            new Mauve().execute(file, prefix, output);
        }
        catch (IllegalArgumentException e) {
            System.err.println(e.getMessage());
            System.err.println("Try --help for more info");
        }
        System.exit(0);
    }
}

