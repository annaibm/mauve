/*
 * Decompiled with CFR 0.152.
 */
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

public class Harness {
    private static Method ecjMethod = null;
    private static String compileString = null;
    private static String compileStringBase = "-proceedOnError -nowarn -1.5 -d @BUILDDIR@";
    private static String compileOptions = "";
    private static PrintWriter ecjWriterOut = null;
    private static PrintWriter ecjWriterErr = null;
    private static String lastFailingCompile = "";
    private static int numCompileFailsInFolder = 0;
    private static Constructor<?> ecjConstructor = null;
    private static String classpathInstallDir = null;
    private static String ecjJarLocation = null;
    private static long runner_timeout = 60000L;
    private static String vmCommand = null;
    private static String vmPrefix = null;
    private static String vmArgs = "";
    private static boolean recursion = true;
    private static boolean verbose = false;
    private static boolean showPasses = false;
    private static boolean compileTests = true;
    private static int total_tests = 0;
    private static int total_test_fails = 0;
    private static int total_check_fails = 0;
    private static List<String> commandLineTests = null;
    private static String inputFile = null;
    private static List<String> excludeTests = new ArrayList<String>();
    private static PrintWriter runner_out = null;
    private static BufferedReader runner_in = null;
    private static ErrorStreamPrinter runner_esp = null;
    private static boolean restartESP = false;
    private static Process runnerProcess = null;
    private static TimeoutWatcher runner_watcher = null;
    private static String[] harnessArgs = null;
    private static final String gnuTestletHeader1 = "gnu" + File.separatorChar + "testlet";
    private static final String gnuTestletHeader2 = gnuTestletHeader1 + File.separatorChar;
    private static final String MAUVE = File.separator + System.getenv("MAUVE_PROJECT_NAME") + File.separator;
    private static final String MAUVE_GNU_TESTLET = MAUVE + gnuTestletHeader2;

    public static void main(String[] args) throws Exception {
        Harness harness = new Harness();
        harness.setupHarness(args);
        Harness.initProcess(args);
        Harness.runAllTests();
        if (total_tests > 0) {
            System.out.println("\nTEST RESULTS:\n" + total_test_fails + " of " + total_tests + " tests failed.  " + total_check_fails + " total calls to harness.check() failed.");
        } else {
            System.out.println("No tests were run.  Possible reasons may be listed below.");
            if (!compileTests) {
                System.out.println("Autocompilation is not enabled, so the tests need to be compiled manually.  You can enable autocompilation via configure, see the README for more info.\n");
            } else if (!recursion) {
                System.out.println("-norecursion was specified, did you specify a folder that had no tests in it?\n");
            } else if (excludeTests != null && excludeTests.size() > 0) {
                System.out.println("Some tests were excluded.\nDid you use -exclude and exclude all tests (or all specified tests)? \n");
            } else {
                System.out.println("Did you specify a test that doesn't exist or a folder that contains no tests? \n");
            }
        }
        harness.finalize();
        System.exit(total_test_fails > 0 ? 1 : 0);
    }

    private void setupHarness(String[] args) throws Exception {
        harnessArgs = args;
        compileTests = "@AUTO_COMPILE@".equals("yes");
        vmCommand = "@TEST_JAVA@";
        for (int i = 0; i < args.length; ++i) {
            if (args[i].equals("-norecursion")) {
                recursion = false;
                continue;
            }
            if (args[i].equals("-verbose")) {
                verbose = true;
                continue;
            }
            if (args[i].equals("-showpasses")) {
                showPasses = true;
                continue;
            }
            if (args[i].equals("-compile")) {
                if (++i >= args.length) {
                    throw new RuntimeException("No file path after '-file'.  Exit");
                }
                if (args[i].equals("yes") || args[i].equals("true")) {
                    compileTests = true;
                    continue;
                }
                if (!args[i].equals("no") && !args[i].equals("false")) continue;
                compileTests = false;
                continue;
            }
            if (args[i].equals("-help") || args[i].equals("--help") || args[i].equals("-h")) {
                Harness.printHelpMessage();
                continue;
            }
            if (args[i].equalsIgnoreCase("-file")) {
                if (++i >= args.length) {
                    throw new RuntimeException("No file path after '-file'.  Exit");
                }
                inputFile = args[i];
                continue;
            }
            if (args[i].equalsIgnoreCase("-bootclasspath")) {
                if (++i >= args.length) {
                    throw new RuntimeException("No file path after '-bootclasspath'.  Exit");
                }
                classpathInstallDir = args[i];
                continue;
            }
            if (args[i].equalsIgnoreCase("-vmarg")) {
                if (++i >= args.length) {
                    throw new RuntimeException("No argument after -vmarg.  Exit");
                }
                vmArgs = vmArgs + " " + args[i];
                continue;
            }
            if (args[i].equalsIgnoreCase("-ecj-jar")) {
                if (++i >= args.length) {
                    throw new RuntimeException("No file path after '-ecj-jar'.  Exit");
                }
                ecjJarLocation = args[i];
                continue;
            }
            if (args[i].equals("-exclude")) {
                if (++i >= args.length) {
                    throw new RuntimeException("No test or directory given after '-exclude'.  Exit");
                }
                excludeTests.add(Harness.startingFormat(args[i]));
                continue;
            }
            if (args[i].equals("-vm")) {
                if (++i >= args.length) {
                    throw new RuntimeException("No VMPATHgiven after '-vm'.  Exit");
                }
                vmCommand = args[i];
                continue;
            }
            if (args[i].equals("-vmprefix")) {
                if (++i >= args.length) {
                    throw new RuntimeException("No filegiven after '-vmprefix'.  Exit");
                }
                vmPrefix = args[i] + " ";
                continue;
            }
            if (args[i].equals("-timeout")) {
                if (++i >= args.length) {
                    throw new RuntimeException("No timeout value given after '-timeout'.  Exit");
                }
                runner_timeout = Long.parseLong(args[i]);
                continue;
            }
            if (args[i].equals("-xmlout")) {
                if (++i < args.length) continue;
                throw new RuntimeException("No file given after '-xmlout'.  Exit");
            }
            if (args[i].equals("-autoxml")) {
                if (++i < args.length) continue;
                throw new RuntimeException("No path specified after '-autoxml'.  Exit");
            }
            if (args[i].charAt(0) == '-' || args[i] == null) continue;
            if (commandLineTests == null) {
                commandLineTests = new ArrayList<String>();
            }
            commandLineTests.add(Harness.startingFormat(args[i]));
        }
        if (ecjJarLocation == null) {
            ecjJarLocation = "@ECJ_JAR@";
        }
        if (compileTests) {
            if (ecjJarLocation == null || ecjJarLocation.equals("")) {
                compileTests = false;
            } else {
                File testECJ = new File(ecjJarLocation);
                if (!testECJ.exists()) {
                    compileTests = false;
                }
            }
        }
        if (compileTests) {
            this.setupCompiler();
        }
        if (vmCommand.equals("java")) {
            System.out.println("WARNING: running tests on 'java'.  To set the test VM, use --with-vm when\nconfiguring or specify -vm when running the Harness.\n");
        }
    }

    private void setupCompiler() throws Exception {
        String classname = "org.eclipse.jdt.internal.compiler.batch.Main";
        Class<?> klass = null;
        try {
            klass = Class.forName(classname);
        }
        catch (ClassNotFoundException e) {
            File jar = new File(ecjJarLocation);
            if (!jar.exists() || !jar.canRead()) {
                throw e;
            }
            URLClassLoader loader = new URLClassLoader(new URL[]{jar.toURL()});
            try {
                klass = loader.loadClass(classname);
            }
            catch (ClassNotFoundException f) {
                throw e;
            }
        }
        ecjConstructor = klass.getConstructor(PrintWriter.class, PrintWriter.class, Boolean.TYPE);
        ecjMethod = klass.getMethod("compile", String.class, PrintWriter.class, PrintWriter.class);
        ecjWriterErr = new CompilerErrorWriter(System.out);
        ecjWriterOut = new PrintWriter(System.out);
        compileStringBase = compileStringBase + Harness.getClasspathInstallString();
    }

    private static String stripSourcePath(String val) {
        if (val.startsWith("@SRCDIR@" + File.separatorChar) || val.startsWith("@SRCDIR@".replace('/', '.') + ".")) {
            val = val.substring("@SRCDIR@".length() + ".".length());
        }
        return val;
    }

    private static String stripPrefix(String val) {
        if (val.startsWith("gnu" + File.separatorChar + "testlet") || val.startsWith("gnu.testlet.")) {
            val = val.substring("gnu.testlet.".length());
        }
        return val;
    }

    private static String getClasspathInstallString() {
        File f;
        String temp = classpathInstallDir;
        if (temp == null) {
            temp = Harness.getBootClassPath();
            if (temp != null) {
                return " -bootclasspath " + temp;
            }
            return "";
        }
        temp = " -bootclasspath " + temp;
        if (!temp.endsWith(File.separator)) {
            temp = temp + File.separator;
        }
        if ((f = new File((temp = temp + "share" + File.separator + "classpath").substring(16) + File.separator + "glibj.zip")).exists()) {
            temp = temp + File.separator + "glibj.zip";
        }
        return temp;
    }

    private static String getBootClassPath() {
        try {
            String c = vmCommand + vmArgs + " Harness$DetectBootclasspath";
            Process p = Runtime.getRuntime().exec(c);
            BufferedReader br = new BufferedReader(new InputStreamReader(p.getInputStream()));
            String bcpOutput = null;
            while (true) {
                if ((bcpOutput = br.readLine()).equals("BCP_FINDER:can't_find_bcp_")) {
                    return null;
                }
                if (bcpOutput.startsWith("BCP_FINDER:")) {
                    return bcpOutput.substring(11);
                }
                System.out.println(bcpOutput);
            }
        }
        catch (IOException ioe) {
            return null;
        }
    }

    private static String startingFormat(String val) {
        if (val != null) {
            if (val.endsWith(".class")) {
                val = val.substring(0, val.length() - 6);
            }
            if (val.endsWith(".java")) {
                val = val.substring(0, val.length() - 5);
            }
            if ((val = val.replace('.', File.separatorChar)).endsWith("" + File.separatorChar)) {
                val = val.substring(0, val.length() - 1);
            }
            if (val.startsWith(MAUVE_GNU_TESTLET)) {
                val = val.substring(MAUVE.length());
            } else if (!val.startsWith(gnuTestletHeader1)) {
                val = gnuTestletHeader2 + val;
            }
        }
        return val;
    }

    static void printHelpMessage() {
        String align = "\n                           ";
        String message = "This is the Mauve Harness.  Usage:\n\n JAVA Harness <options> <testcase | folder>\n  If no testcase or folder is given, all the tests will be run. \n\nExample: 'jamvm Harness -vm jamvm -showpasses javax.swing'\n  will use jamvm (located in your path) to run all the tests in the\n  gnu.testlet.javax.swing folder and will display PASSES\n  as well as FAILS.\n\nOPTIONS:\n\nTest Run Options:\n  -vm [vmpath]:            specify the vm on which to run the tests.It is strongly recommended" + align + "that you use this option or use the --with-vm option when running" + align + "configure.  See the README file for more details.\n  -compile [yes|no]:       specify whether or not to compile the tests before running them.  This" + align + "overrides the configureoption --disable-auto-compilation but requires an ecj jar" + align + "to be in /usr/share/java/eclipse-ecj.jar or specified via the --with-ecj-jar" + align + "option to configure.  See the README file for more details.\n  -timeout [millis]:       specifies a timeout value for the tests (default is 60000 milliseconds)\n\nTestcase Selection Options:\n  -exclude [test|folder]:  specifies a test or a folder to exclude from the run\n  -norecursion:            if a folder is specified to be run, don't run the tests in its subfolders\n  -file [filename]:        specifies a file that contains the names of tests to be run (one per line)\n  -interactive:            only run interactive tests, if not set, only run non-interactive tests\n\n\nOutput Options:\n  -showpasses:             display passing tests as well as failing ones\n  -hidecompilefails:       hide errors from the compiler when tests fail to compile\n  -noexceptions:           suppress stack traces for uncaught exceptions\n  -verbose:                run in noisy mode, displaying extra information\n  -debug:                  displays some extra information for failing tests that use the" + align + "harness.check(Object, Object) method\n  -xmlout [filename]:      specifies a file to use for xml output\n  -autoxml [folder]:       generate individual xml output, for each test case \n\nOther Options:\n  -help:                   display this help message\n";
        System.out.println(message);
        System.exit(0);
    }

    protected void finalize() {
        try {
            Harness.runTest("_dump_data_");
            runnerProcess.destroy();
            runner_in.close();
            runner_out.close();
        }
        catch (IOException e) {
            System.err.println("Could not close the interprocess pipes.");
            System.exit(-1);
        }
    }

    private static void initProcess(String[] args) {
        StringBuffer sb = new StringBuffer(" RunnerProcess");
        for (int i = 0; i < args.length; ++i) {
            sb.append(" " + args[i]);
        }
        if (vmPrefix != null) {
            sb.insert(0, vmPrefix + vmCommand + vmArgs);
        } else {
            sb.insert(0, vmCommand + vmArgs);
        }
        try {
            runnerProcess = Runtime.getRuntime().exec(sb.toString());
            runner_out = new PrintWriter(runnerProcess.getOutputStream(), true);
            runner_in = new BufferedReader(new InputStreamReader(runnerProcess.getInputStream()));
            runner_esp = new ErrorStreamPrinter(runnerProcess.getErrorStream());
            InputPiperThread pipe = new InputPiperThread(System.in, runnerProcess.getOutputStream());
            pipe.start();
            runner_esp.start();
        }
        catch (IOException e) {
            System.err.println("Problems invoking RunnerProcess: " + e);
            System.exit(1);
        }
        if (runner_watcher != null) {
            runner_watcher.stop();
        }
        runner_watcher = new TimeoutWatcher(runner_timeout, runnerProcess);
        Harness.runTest("_confirm_startup_");
        runner_watcher.stop();
        runner_watcher = new TimeoutWatcher(runner_timeout, runnerProcess);
    }

    private static void runAllTests() {
        String cname;
        if (commandLineTests != null) {
            for (int i = 0; i < commandLineTests.size(); ++i) {
                cname = null;
                cname = commandLineTests.get(i);
                if (cname == null) break;
                Harness.processTest(cname);
            }
        }
        BufferedReader r = null;
        if (inputFile != null) {
            try {
                r = new BufferedReader(new FileReader(inputFile));
            }
            catch (FileNotFoundException x) {
                throw new RuntimeException("Cannot find \"" + inputFile + "\".  Exit");
            }
        }
        r = new BufferedReader(new InputStreamReader(System.in));
        try {
            if (!r.ready()) {
                if (commandLineTests == null || commandLineTests.size() == 0) {
                    Harness.processTest("gnu/testlet");
                }
                return;
            }
        }
        catch (IOException x) {
            // empty catch block
        }
        while (true) {
            cname = null;
            try {
                cname = r.readLine();
                if (cname == null) {
                    break;
                }
            }
            catch (IOException iOException) {
                // empty catch block
            }
            Harness.processTest(Harness.startingFormat(cname));
        }
    }

    private static void runTest(String testName2) {
        int temp;
        String tn = Harness.stripPrefix(testName2.replace(File.separatorChar, '.'));
        boolean invalidTest = false;
        if (restartESP) {
            restartESP = false;
            runner_esp = new ErrorStreamPrinter(runnerProcess.getErrorStream());
        }
        runner_watcher.reset();
        runner_out.println(testName2);
        try {
            while (true) {
                String outputFromTest;
                if ((outputFromTest = runner_in.readLine()) == null) {
                    Harness.initProcess(harnessArgs);
                    temp = -1;
                    break;
                }
                if (outputFromTest.startsWith("RunnerProcess:")) {
                    invalidTest = false;
                    if (outputFromTest.endsWith("restart-timer")) {
                        runner_watcher.reset();
                        continue;
                    }
                    if (outputFromTest.endsWith("pass")) {
                        temp = 0;
                    } else {
                        if (outputFromTest.indexOf("fail-loading") != -1) {
                            temp = 1;
                            System.out.println(outputFromTest.substring(27));
                            continue;
                        }
                        if (outputFromTest.indexOf("fail-") != -1) {
                            total_check_fails += Integer.parseInt(outputFromTest.substring(19));
                            temp = 1;
                        } else {
                            if (!outputFromTest.endsWith("not-a-test")) continue;
                            invalidTest = true;
                            --total_tests;
                            temp = 0;
                        }
                    }
                    break;
                }
                if (outputFromTest.equals("_startup_okay_") || outputFromTest.equals("_data_dump_okay_")) {
                    return;
                }
                System.out.println(outputFromTest);
            }
        }
        catch (IOException e) {
            Harness.initProcess(harnessArgs);
            temp = -1;
        }
        if (temp == -1) {
            if (verbose) {
                System.out.println("  FAIL: timed out. \nTEST FAILED: timeout " + tn);
            } else {
                System.out.println("FAIL: " + tn + "\n  Test timed out.  Use -timeout [millis] option to change the timeout value.");
            }
            ++total_test_fails;
        } else {
            total_test_fails += temp;
        }
        ++total_tests;
        if (showPasses && temp == 0 && !verbose && !invalidTest) {
            System.out.println("PASS: " + tn);
        }
    }

    private static void processTest(String cname) {
        if (cname.equals("CVS") || cname.endsWith(File.separatorChar + "CVS") || excludeTests.contains(cname) || cname.lastIndexOf("$") > cname.lastIndexOf(File.separator)) {
            return;
        }
        if (Harness.processSingleTest(cname) == 1) {
            Harness.processFolder(cname);
        }
    }

    private static boolean testNeedsToBeCompiled(String testname) {
        String filename = Harness.stripSourcePath(testname);
        if (filename.endsWith(".java")) {
            filename = filename.substring(0, filename.length() - ".java".length());
        }
        String sourcefile = "@SRCDIR@" + File.separatorChar + filename + ".java";
        String classfile = "@BUILDDIR@" + File.separatorChar + filename + ".class";
        File sf = new File(sourcefile);
        File cf = new File(classfile);
        if (!sf.exists()) {
            throw new RuntimeException(sourcefile + " does not exists!");
        }
        if (!cf.exists()) {
            return true;
        }
        return sf.lastModified() > cf.lastModified();
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private static boolean parseTags(String sourcefile, LinkedHashSet<String> filesToCompile, LinkedHashSet<String> filesToCopy, LinkedHashSet<String> testsToRun) {
        File f = new File(sourcefile);
        String base = f.getAbsolutePath();
        base = base.substring(0, base.lastIndexOf(File.separatorChar));
        BufferedReader r = null;
        try {
            r = new BufferedReader(new FileReader(f));
            String line = null;
            line = r.readLine();
            while (line != null) {
                block16: {
                    block14: {
                        block18: {
                            block17: {
                                block15: {
                                    if (!line.contains("//")) break block14;
                                    if (!line.contains("Uses:")) break block15;
                                    Harness.processUsesTag(line, base, filesToCompile, filesToCopy, testsToRun);
                                    break block16;
                                }
                                if (!line.contains("Files:")) break block17;
                                Harness.processFilesTag(line, base, filesToCopy);
                                break block16;
                            }
                            if (!line.contains("CompileOptions:")) break block18;
                            Harness.processCompileOptions(line);
                            break block16;
                        }
                        if (!line.contains("not-a-test")) break block16;
                        testsToRun.remove(sourcefile);
                        break block16;
                    }
                    if (line.contains("implements Testlet")) {
                        break;
                    }
                }
                line = r.readLine();
            }
        }
        catch (IOException ioe) {
            ioe.printStackTrace();
            boolean bl = false;
            return bl;
        }
        finally {
            try {
                r.close();
            }
            catch (IOException ioe) {
                ioe.printStackTrace();
                return false;
            }
        }
        return true;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private static String parseCompileOptions(String sourcefile) {
        String compileOptions = null;
        File f = new File(sourcefile);
        String base = f.getAbsolutePath();
        base = base.substring(0, base.lastIndexOf(File.separatorChar));
        BufferedReader r = null;
        try {
            r = new BufferedReader(new FileReader(f));
            String line = null;
            while ((line = r.readLine()) != null) {
                if (!line.contains("//") || !line.contains("CompileOptions:")) continue;
                compileOptions = line.substring(line.indexOf("CompileOptions:") + "CompileOptions:".length()) + " ";
            }
        }
        catch (IOException ioe) {
            ioe.printStackTrace();
            String string = null;
            return string;
        }
        finally {
            try {
                r.close();
            }
            catch (IOException ioe) {
                ioe.printStackTrace();
                return null;
            }
        }
        return compileOptions;
    }

    private static void processUsesTag(String line, String base, LinkedHashSet<String> filesToCompile, LinkedHashSet<String> filesToCopy, LinkedHashSet<String> testsToRun) {
        StringTokenizer st = new StringTokenizer(line.substring(line.indexOf("Uses:") + 5));
        while (st.hasMoreTokens()) {
            String depend = base;
            String t = st.nextToken();
            while (t.startsWith(".." + File.separator)) {
                t = t.substring(3);
                depend = depend.substring(0, depend.lastIndexOf(File.separatorChar));
            }
            if ((depend = depend + File.separator + t).endsWith(".class")) {
                depend = depend.substring(0, depend.length() - 6);
            }
            if (!depend.endsWith(".java")) {
                depend = depend + ".java";
            }
            if (Harness.testNeedsToBeCompiled(depend)) {
                filesToCompile.add(depend);
            }
            Harness.parseTags(depend, filesToCompile, filesToCopy, testsToRun);
        }
    }

    private static void processCompileOptions(String line) {
        compileOptions = line.substring(line.indexOf("CompileOptions:") + "CompileOptions:".length());
        compileOptions = compileOptions + " ";
    }

    private static void processFilesTag(String line, String base, LinkedHashSet<String> filesToCopy) {
        StringTokenizer st = new StringTokenizer(line.substring(line.indexOf("Files:") + 6));
        while (st.hasMoreTokens()) {
            String src = base;
            String t = st.nextToken();
            while (t.startsWith(".." + File.separator)) {
                t = t.substring(3);
                src = src.substring(0, src.lastIndexOf(File.separatorChar));
            }
            src = src + File.separator + t;
            filesToCopy.add(src);
        }
    }

    private static boolean copyFiles(LinkedHashSet<String> filesToCopy) {
        if (filesToCopy.size() == 0) {
            return true;
        }
        for (String src : filesToCopy) {
            String dest = "@BUILDDIR@" + File.separatorChar + Harness.stripSourcePath(src);
            try {
                File inputFile = new File(src);
                File outputFile = new File(dest);
                if (inputFile.lastModified() <= outputFile.lastModified()) continue;
                outputFile.getParentFile().mkdirs();
                FileInputStream fis = new FileInputStream(inputFile);
                FileOutputStream fos = new FileOutputStream(outputFile);
                byte[] buf = new byte[1024];
                int i = 0;
                while ((i = fis.read(buf)) != -1) {
                    fos.write(buf, 0, i);
                }
                fis.close();
                fos.close();
            }
            catch (IOException ioe) {
                ioe.printStackTrace();
                return false;
            }
        }
        return true;
    }

    private static int processSingleTest(String cname) {
        LinkedHashSet<String> filesToCompile = new LinkedHashSet<String>();
        LinkedHashSet<String> filesToCopy = new LinkedHashSet<String>();
        LinkedHashSet<String> testsToRun = new LinkedHashSet<String>();
        if (excludeTests.contains(cname)) {
            return -1;
        }
        String sourcefile = "@SRCDIR@" + File.separatorChar + cname + ".java";
        File jf = new File(sourcefile);
        if (!jf.exists()) {
            return 1;
        }
        if (!compileTests) {
            if (Harness.testNeedsToBeCompiled(cname)) {
                return -1;
            }
        } else {
            if (Harness.testNeedsToBeCompiled(cname)) {
                filesToCompile.add(sourcefile);
            }
            testsToRun.add(sourcefile);
            if (!Harness.parseTags(sourcefile, filesToCompile, filesToCopy, testsToRun)) {
                return -1;
            }
            if (!Harness.copyFiles(filesToCopy)) {
                return -1;
            }
            if (!Harness.compileFiles(filesToCompile, null)) {
                return -1;
            }
        }
        Harness.runTest(cname);
        return 0;
    }

    private static void processFolder(String folderName) {
        File dir = new File("@SRCDIR@" + File.separatorChar + folderName);
        String dirPath = dir.getPath();
        File[] files = dir.listFiles();
        LinkedHashSet<String> filesToCompile = new LinkedHashSet<String>();
        LinkedHashSet<String> filesToCopy = new LinkedHashSet<String>();
        LinkedHashSet<String> testsToRun = new LinkedHashSet<String>();
        HashMap<String, String> compileOptions = new HashMap<String, String>();
        String fullPath = null;
        boolean compilepassed = true;
        if (files == null) {
            return;
        }
        for (int i = 0; i < files.length; ++i) {
            String name2 = files[i].getName();
            fullPath = dirPath + File.separatorChar + name2;
            String testName2 = Harness.stripSourcePath(fullPath);
            if (name2.equals("CVS") || excludeTests.contains(testName2)) continue;
            if (name2.endsWith(".java") && !excludeTests.contains(testName2.substring(0, testName2.length() - 5))) {
                if (Harness.testNeedsToBeCompiled(testName2)) {
                    filesToCompile.add(fullPath);
                    String options = Harness.parseCompileOptions(fullPath);
                    if (options != null) {
                        compileOptions.put(fullPath, options);
                    }
                }
                testsToRun.add(fullPath);
                if (Harness.parseTags(fullPath, filesToCompile, filesToCopy, testsToRun)) continue;
                continue;
            }
            if (!files[i].isDirectory() || !recursion || excludeTests.contains(testName2)) continue;
            Harness.processFolder(testName2);
        }
        if (!Harness.copyFiles(filesToCopy)) {
            return;
        }
        if (testsToRun.size() == 0) {
            return;
        }
        if (dirPath.equals("@SRCDIR@" + File.separatorChar + "gnu" + File.separatorChar + "testlet")) {
            return;
        }
        if (compileTests) {
            compilepassed = Harness.compileFiles(filesToCompile, compileOptions);
        }
        Harness.runFolder(testsToRun, compilepassed);
    }

    private static void runFolder(LinkedHashSet<String> testsToRun, boolean compilepassed) {
        String nextTest2 = null;
        for (String nextTest2 : testsToRun) {
            if (Harness.testNeedsToBeCompiled(nextTest2 = Harness.stripSourcePath(nextTest2)) || !compilepassed && excludeTests.contains(nextTest2)) continue;
            nextTest2 = nextTest2.substring(0, nextTest2.length() - 5);
            Harness.runTest(nextTest2);
        }
    }

    public static int compile() throws Exception {
        Object ecjInstance = ecjConstructor.newInstance(new PrintWriter(System.out), new PrintWriter(System.err), Boolean.FALSE);
        return (Boolean)ecjMethod.invoke(ecjInstance, compileString, ecjWriterOut, ecjWriterErr) != false ? 0 : -1;
    }

    private static boolean compileFiles(LinkedHashSet<String> filesToCompile, Map<String, String> testCompileOptions) {
        if (filesToCompile.size() == 0) {
            return true;
        }
        int result = -1;
        boolean doGroupCompile = false;
        compileString = compileStringBase + compileOptions;
        for (String string : filesToCompile) {
            if (testCompileOptions != null && testCompileOptions.containsKey(string)) continue;
            compileString = compileString + " " + string;
            doGroupCompile = true;
        }
        try {
            if (doGroupCompile) {
                result = Harness.compile();
            }
            if (testCompileOptions != null) {
                for (Map.Entry entry : testCompileOptions.entrySet()) {
                    String oldCompileString = compileStringBase + compileOptions;
                    compileString = compileStringBase + (String)entry.getValue() + " " + (String)entry.getKey();
                    result = result == -1 ? -1 : Harness.compile();
                    compileString = oldCompileString;
                }
            }
        }
        catch (Exception e) {
            System.err.println("compilation exception");
            e.printStackTrace();
            result = -1;
        }
        return result == 0;
    }

    private static boolean isCompileSummary(String x) {
        if (numCompileFailsInFolder == 1) {
            return x.startsWith("1 problem (1 error)");
        }
        String s = "" + numCompileFailsInFolder + " problems (";
        s = s + "" + numCompileFailsInFolder + " errors)";
        return x.startsWith(s);
    }

    private static class InputPiperThread
    extends Thread {
        InputStream in;
        OutputStream out;

        InputPiperThread(InputStream i, OutputStream o) {
            this.in = i;
            this.out = o;
        }

        @Override
        public void run() {
            int ch = 0;
            do {
                try {
                    if (this.in.available() > 0) {
                        ch = this.in.read();
                        if (ch != 10) {
                            this.out.write(ch);
                        }
                        this.out.flush();
                        continue;
                    }
                    Thread.sleep(200L);
                }
                catch (IOException ex) {
                    ex.printStackTrace();
                }
                catch (InterruptedException ex) {
                    ch = -1;
                }
            } while (ch != -1);
        }
    }

    private class CompilerErrorWriter
    extends PrintWriter {
        public CompilerErrorWriter(OutputStream out) {
            super(out);
        }

        @Override
        public void println(String x) {
            if (x.startsWith("incorrect classpath:") || x.startsWith("----------")) {
                return;
            }
            int loc = x.indexOf("gnu/testlet");
            if (loc != -1) {
                String temp = x.substring(loc);
                String shortName = Harness.stripPrefix(temp).replace(File.separatorChar, '.');
                if (shortName.endsWith(".java")) {
                    shortName = shortName.substring(0, shortName.length() - 5);
                }
                if (!lastFailingCompile.equals(shortName)) {
                    if (verbose) {
                        super.println("TEST: " + shortName + "\n  FAIL: compilation errors:");
                    } else {
                        super.println("FAIL: " + shortName + "\n  compilation errors:");
                    }
                    numCompileFailsInFolder = 1;
                    excludeTests.add(temp);
                    total_test_fails++;
                    total_tests++;
                    lastFailingCompile = shortName;
                } else {
                    numCompileFailsInFolder++;
                }
                return;
            }
            loc = x.indexOf("(at line ");
            if (loc != -1) {
                int endBracket = x.indexOf(41, loc);
                String line = x.substring(loc + 4, endBracket) + ":";
                if (verbose) {
                    super.println("    " + line);
                } else {
                    super.println("  " + line);
                }
                super.println(x.substring(endBracket + 2));
                return;
            }
            if (verbose) {
                super.println("    " + x);
            } else {
                super.println("  " + x);
            }
        }

        @Override
        public void print(String x) {
            if (Harness.isCompileSummary(x)) {
                if (verbose) {
                    super.println("TEST FAILED: compile failed for " + lastFailingCompile);
                }
            } else {
                super.print(x);
            }
        }
    }

    public static class DetectBootclasspath {
        public static void main(String[] args) {
            String result = "BCP_FINDER:";
            String temp = System.getProperty("sun.boot.class.path");
            if (temp == null) {
                temp = System.getProperty("java.boot.class.path");
            }
            if (temp == null) {
                String[] s = (String[])System.getProperties().keySet().toArray();
                int count = 0;
                String key = null;
                for (int i = 0; i < s.length; ++i) {
                    if (s[i].indexOf("boot.class.path") == -1) continue;
                    ++count;
                    key = s[i];
                }
                if (count == 1) {
                    temp = System.getProperty(key);
                } else {
                    System.err.println("WARNING: Cannot auto-detect the bootclasspath for your VM, please file a bug report specifying which VM you are testing.");
                    temp = "can't_find_bcp_";
                }
            }
            System.out.println(result + temp);
        }
    }

    private static class TimeoutWatcher
    implements Runnable {
        private long millisToWait;
        private Thread watcherThread;
        private boolean started;
        private boolean loop = true;
        private boolean shouldContinue = true;
        private final Process runnerProcess;

        public TimeoutWatcher(long millis, Process runnerProcess) {
            this.millisToWait = millis;
            this.watcherThread = new Thread(this);
            this.started = false;
            this.runnerProcess = runnerProcess;
        }

        public synchronized void stop() {
            this.shouldContinue = false;
            this.notify();
        }

        public synchronized void reset() {
            if (!this.started) {
                this.watcherThread.start();
                this.started = true;
            } else {
                this.loop = true;
                this.notify();
            }
        }

        @Override
        public synchronized void run() {
            Thread.currentThread().setPriority(10);
            while (this.loop && this.shouldContinue) {
                this.loop = false;
                long start = System.currentTimeMillis();
                long waited = 0L;
                while (waited < this.millisToWait) {
                    try {
                        this.wait(this.millisToWait - waited);
                    }
                    catch (InterruptedException interruptedException) {
                        // empty catch block
                    }
                    waited = System.currentTimeMillis() - start;
                }
            }
            if (this.shouldContinue) {
                try {
                    this.runnerProcess.destroy();
                    this.runnerProcess.getInputStream().close();
                    this.runnerProcess.getErrorStream().close();
                    this.runnerProcess.getOutputStream().close();
                }
                catch (IOException e) {
                    System.err.println("Could not close the interprocess pipes.");
                    System.exit(-1);
                }
            }
        }
    }

    private static class ErrorStreamPrinter
    implements Runnable {
        private static BufferedReader in;
        private Thread printerThread;

        public ErrorStreamPrinter(InputStream input) {
            in = new BufferedReader(new InputStreamReader(runnerProcess.getErrorStream()));
            this.printerThread = new Thread(this);
        }

        public void start() {
            this.printerThread.start();
        }

        @Override
        public void run() {
            try {
                while (true) {
                    String temp;
                    if ((temp = in.readLine()) == null) {
                        restartESP = true;
                        break;
                    }
                    System.err.println(temp);
                }
            }
            catch (IOException ioe) {
                restartESP = true;
            }
        }
    }
}

