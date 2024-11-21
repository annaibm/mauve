/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.runner;

import gnu.testlet.runner.CheckResult;
import gnu.testlet.runner.ClassResult;
import gnu.testlet.runner.PackageResult;
import gnu.testlet.runner.RunResult;
import gnu.testlet.runner.TestResult;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.util.Date;
import java.util.Iterator;

public class HTMLGenerator {
    public static void createReport(RunResult run, File rootDirectory) throws IOException {
        File summaryFile = new File(rootDirectory, "index.html");
        OutputStreamWriter out = new OutputStreamWriter((OutputStream)new FileOutputStream(summaryFile), "UTF-8");
        PrintWriter writer = new PrintWriter(out);
        writer.println("<HTML>");
        writer.println("<HEAD><TITLE>Mauve Run: " + run.getName() + "</TITLE>");
        writer.println("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\" /></HEAD>");
        writer.println("<BODY>");
        writer.println("<h1>Mauve Run</h1>");
        writer.println("<h2>Summary:</h2>");
        int checkCount = run.getCheckCount();
        int passed = run.getCheckCount(true);
        int failed = checkCount - passed;
        writer.println("Run Date: " + DateFormat.getDateTimeInstance(1, 1).format(new Date()) + "<br>");
        writer.println("Passed: " + passed + "<br>");
        writer.println("Failed: " + failed + "<p>");
        writer.println("<h2>Environment:</h2>");
        writer.println("<table BORDER=\"0\" CELLPADDING=\"0\">");
        writer.println("<tr>");
        writer.println("<td bgcolor=\"black\" VALIGN=\"TOP\">");
        writer.println("<table BORDER=\"0\" WIDTH=\"100%\" CELLSPACING=\"1\" CELLPADDING=\"3\">");
        writer.println("<tr>");
        writer.println("<td bgcolor=\"lightGray\">Property:</td>");
        writer.println("<td bgcolor=\"lightGray\">Value:</td>");
        writer.println("</tr>");
        String[] propertyNames = run.getSystemPropertyNames();
        for (int i = 0; i < propertyNames.length; ++i) {
            String name2 = propertyNames[i];
            HTMLGenerator.writePropertyRow(name2, run.getSystemProperty(name2), writer);
        }
        writer.println("</table>");
        writer.println("</td>");
        writer.println("</tr>");
        writer.println("</table><p>");
        writer.println("<h2>Results:</h2>");
        writer.println("<table BORDER=\"0\" width=\"100%\" CELLPADDING=\"0\">");
        writer.println("<tr>");
        writer.println("<td bgcolor=\"black\" VALIGN=\"TOP\">");
        writer.println("<table BORDER=\"0\" WIDTH=\"100%\" CELLSPACING=\"1\" CELLPADDING=\"3\">");
        writer.println("<tr>");
        writer.println("<td bgcolor=\"lightGray\">Package:</td>");
        writer.println("<td bgcolor=\"lightGray\">Passed:</td>");
        writer.println("<td bgcolor=\"lightGray\">Failed:</td>");
        writer.println("<td bgcolor=\"lightGray\">Total:</td>");
        writer.println("</tr>");
        String top = null;
        Iterator iterator = run.getPackageIterator();
        while (iterator.hasNext()) {
            String name3;
            PackageResult packageResult = (PackageResult)iterator.next();
            String packageName = packageResult.getName().replace('.', '/');
            System.out.println("Generating " + packageName);
            if (top != null && packageName.startsWith(top)) {
                name3 = "&nbsp;&nbsp;&nbsp;+&nbsp;" + packageName.substring(top.length() + 1);
            } else {
                top = packageName;
                name3 = packageName;
            }
            writer.println("<tr>");
            writer.println("<td bgcolor=\"white\"><a href=\"" + packageName + "/package_index.html\">" + name3 + "</a></td>");
            writer.println("<td bgcolor=\"white\">" + packageResult.getCheckCount(true) + "</td>");
            writer.println("<td bgcolor=\"white\">" + packageResult.getCheckCount(false) + "</td>");
            writer.println("<td bgcolor=\"white\">" + packageResult.getCheckCount() + "</td>");
            writer.println("</tr>");
            try {
                HTMLGenerator.createPackageReport(packageResult, rootDirectory);
            }
            catch (Exception e) {
                String temp = packageResult.getName().replace('.', '/');
                System.err.println("Couldn't create package report for " + temp);
                File tempDir = new File(rootDirectory, packageName);
                tempDir.mkdirs();
                File tempFile = new File(tempDir, "package_index.html");
                tempFile.createNewFile();
            }
        }
        writer.println("</table>");
        writer.println("</td>");
        writer.println("</tr>");
        writer.println("</table>");
        writer.println("<p>");
        Iterator missing = run.getMissingTestsIterator();
        Iterator failures = run.getFaultyTestsIterator();
        if (missing.hasNext() || failures.hasNext()) {
            writer.println("<h2>Unrunnable tests:</h2>");
            writer.println("<table BORDER=\"0\" width=\"100%\" CELLPADDING=\"0\">");
            writer.println("<tr>");
            writer.println("<td bgcolor=\"black\" VALIGN=\"TOP\">");
            writer.println("<table BORDER=\"0\" WIDTH=\"100%\" CELLSPACING=\"1\" CELLPADDING=\"3\">");
            writer.println("<tr>");
            writer.println("<td bgcolor=\"lightGray\">name:</td>");
            writer.println("<td bgcolor=\"lightGray\">problem:</td>");
            writer.println("</tr>");
            while (missing.hasNext()) {
                writer.println("<tr><td bgcolor=\"white\">" + (String)missing.next() + "</td><td bgcolor=\"white\">Class not found</td></tr>");
            }
            while (failures.hasNext()) {
                String[] fail = (String[])failures.next();
                writer.println("<tr><td bgcolor=\"white\">" + fail[0] + "</td><td bgcolor=\"white\">" + fail[1] + "</td></tr>");
            }
            writer.println("</table>");
            writer.println("</td>");
            writer.println("</tr>");
            writer.println("</table>");
        }
        writer.println("</BODY>");
        writer.println("</HTML>");
        writer.close();
    }

    private static void writePropertyRow(String property2, String value2, PrintWriter writer) {
        writer.println("<tr>");
        writer.println("<td bgcolor=\"white\">" + property2 + "</td>");
        writer.println("<td bgcolor=\"white\">" + value2 + "</td>");
        writer.println("</tr>");
    }

    private static int countLevels(String name2) {
        int result = 1;
        for (int i = 0; i < name2.length(); ++i) {
            if (name2.charAt(i) != '/') continue;
            ++result;
        }
        return result;
    }

    public static void createPackageReport(PackageResult packageResult, File rootDirectory) throws IOException {
        String packageName = packageResult.getName().replace('.', '/');
        String prefix = "";
        int levels = HTMLGenerator.countLevels(packageName);
        for (int i = 0; i < levels; ++i) {
            prefix = prefix + "../";
        }
        File packageDirectory = new File(rootDirectory, packageName);
        packageDirectory.mkdirs();
        File summaryFile = new File(packageDirectory, "package_index.html");
        BufferedOutputStream out = new BufferedOutputStream(new FileOutputStream(summaryFile));
        PrintWriter writer = new PrintWriter(out);
        writer.println("<HTML>");
        writer.println("<HEAD><TITLE>Package Summary: " + packageResult.getName() + "</TITLE></HEAD>");
        writer.println("<BODY>");
        writer.println("<h2>Package: " + packageResult.getName() + "</h2>");
        writer.println("<a href=\"" + prefix + "index.html\">Summary page</a><p>");
        int checkCount = packageResult.getCheckCount();
        int passed = packageResult.getCheckCount(true);
        int failed = checkCount - passed;
        writer.println("Passed: " + passed + "<br>");
        writer.println("Failed: " + failed + "<p>");
        writer.println("<table BORDER=\"0\" width=\"100%\" CELLPADDING=\"0\">");
        writer.println("<tr>");
        writer.println("<td bgcolor=\"black\" VALIGN=\"TOP\">");
        writer.println("<table BORDER=\"0\" WIDTH=\"100%\" CELLSPACING=\"1\" CELLPADDING=\"3\">");
        writer.println("<tr>");
        writer.println("<td bgcolor=\"lightGray\">Class:</td>");
        writer.println("<td bgcolor=\"lightGray\">Passed:</td>");
        writer.println("<td bgcolor=\"lightGray\">Failed:</td>");
        writer.println("<td bgcolor=\"lightGray\">Total:</td>");
        writer.println("</tr>");
        Iterator iterator = packageResult.getClassIterator();
        while (iterator.hasNext()) {
            ClassResult classResult = (ClassResult)iterator.next();
            writer.println("<tr>");
            writer.println("<td bgcolor=\"white\"><a href=\"" + classResult.getName() + "/class_index.html\">" + classResult.getName() + "</a></td>");
            writer.println("<td bgcolor=\"white\">" + classResult.getCheckCount(true) + "</td>");
            writer.println("<td bgcolor=\"white\">" + classResult.getCheckCount(false) + "</td>");
            writer.println("<td bgcolor=\"white\">" + classResult.getCheckCount() + "</td>");
            writer.println("</tr>");
            HTMLGenerator.createClassReport(classResult, packageResult.getName(), packageDirectory);
        }
        writer.println("</table>");
        writer.println("</td>");
        writer.println("</tr>");
        writer.println("</table>");
        writer.println("</BODY>");
        writer.println("</HTML>");
        writer.close();
    }

    public static void createClassReport(ClassResult classResult, String packageName, File packageDirectory) throws IOException {
        File classDirectory = new File(packageDirectory, classResult.getName());
        classDirectory.mkdirs();
        File testFile = new File(classDirectory, "class_index.html");
        BufferedOutputStream out = new BufferedOutputStream(new FileOutputStream(testFile));
        PrintWriter writer = new PrintWriter(out);
        writer.println("<HTML>");
        writer.println("<HEAD><TITLE>Class Summary: " + packageName + "." + classResult.getName() + "</TITLE></HEAD>");
        writer.println("<BODY>");
        writer.println("<h2>Class: <a href=\"../package_index.html\">" + packageName + "</a>." + classResult.getName() + "</h2>");
        int checkCount = classResult.getCheckCount();
        int passed = classResult.getCheckCount(true);
        int failed = checkCount - passed;
        writer.println("Passed: " + passed + "<br>");
        writer.println("Failed: " + failed + "<p>");
        writer.println("<table BORDER=\"0\" width=\"100%\" CELLPADDING=\"0\">");
        writer.println("<tr>");
        writer.println("<td bgcolor=\"black\" VALIGN=\"TOP\">");
        writer.println("<table BORDER=\"0\" WIDTH=\"100%\" CELLSPACING=\"1\" CELLPADDING=\"3\">");
        writer.println("<tr>");
        writer.println("<td bgcolor=\"lightGray\">Test:</td>");
        writer.println("<td bgcolor=\"lightGray\">Passed:</td>");
        writer.println("<td bgcolor=\"lightGray\">Failed:</td>");
        writer.println("<td bgcolor=\"lightGray\">Total:</td>");
        writer.println("</tr>");
        Iterator iterator = classResult.getTestIterator();
        while (iterator.hasNext()) {
            TestResult testResult = (TestResult)iterator.next();
            writer.println("<tr>");
            writer.println("<td bgcolor=\"white\"><a href=\"" + testResult.getName() + ".html\">" + testResult.getName() + "</a></td>");
            writer.println("<td bgcolor=\"white\">" + testResult.getCheckCount(true) + "</td>");
            writer.println("<td bgcolor=\"white\">" + testResult.getCheckCount(false) + "</td>");
            writer.println("<td bgcolor=\"white\">" + testResult.getCheckCount() + "</td>");
            writer.println("</tr>");
            HTMLGenerator.createTestReport(testResult, classResult.getName(), classDirectory);
        }
        writer.println("</table>");
        writer.println("</td>");
        writer.println("</tr>");
        writer.println("</table>");
        writer.println("</BODY>");
        writer.println("</HTML>");
        writer.close();
    }

    public static void createTestReport(TestResult testResult, String className, File classDirectory) throws IOException {
        File testFile = new File(classDirectory, testResult.getName() + ".html");
        OutputStreamWriter out = new OutputStreamWriter((OutputStream)new FileOutputStream(testFile), "UTF-8");
        PrintWriter writer = new PrintWriter(out);
        writer.println("<HTML>");
        writer.println("<HEAD><TITLE>Test Summary: " + className + "." + testResult.getName() + "</TITLE>\n");
        writer.println("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\" /></HEAD>");
        writer.println("<BODY>");
        writer.println("<h2>Test: <a href=\"class_index.html\">" + className + "</a>." + testResult.getName() + "</h2>");
        int checkCount = testResult.getCheckCount();
        int passed = testResult.getCheckCount(true);
        int failed = checkCount - passed;
        writer.println("Passed: " + passed + "<br>");
        writer.println("Failed: " + failed + "<p>");
        writer.println("<table BORDER=\"0\" width=\"100%\" CELLPADDING=\"0\">");
        writer.println("<tr>");
        writer.println("<td bgcolor=\"black\" VALIGN=\"TOP\">");
        writer.println("<table BORDER=\"0\" WIDTH=\"100%\" CELLSPACING=\"1\" CELLPADDING=\"3\">");
        writer.println("<tr>");
        writer.println("<td bgcolor=\"lightGray\">Check Number:</td>");
        writer.println("<td bgcolor=\"lightGray\">Check Point:</td>");
        writer.println("<td bgcolor=\"lightGray\">Passed?:</td>");
        writer.println("<td bgcolor=\"lightGray\">Expected:</td>");
        writer.println("<td bgcolor=\"lightGray\">Actual:</td>");
        writer.println("</tr>");
        Iterator iterator = testResult.getCheckIterator();
        while (iterator.hasNext()) {
            CheckResult check2 = (CheckResult)iterator.next();
            writer.println("<tr><td bgcolor=\"white\">" + check2.getNumber() + "</td><td bgcolor=\"white\">" + check2.getCheckPoint() + "</td><td bgcolor=\"" + (check2.getPassed() ? "white" : "red") + "\">" + check2.getPassed() + "</td><td bgcolor=\"white\">" + check2.getExpected() + "</td><td bgcolor=\"white\">" + check2.getActual() + "</td>");
            if (!check2.getPassed()) {
                try {
                    HTMLGenerator.createLogReport(check2, className, testResult.getName(), classDirectory);
                }
                catch (Exception e) {
                    System.err.println("Couldn't write report for class " + className);
                    File temp = new File(classDirectory, testResult.getName() + "_log.html");
                    temp.createNewFile();
                }
            }
            writer.println("</td>");
            writer.println("</tr>");
        }
        writer.println("</table>");
        writer.println("</td>");
        writer.println("</tr>");
        writer.println("</table>");
        if (testResult.isFailed()) {
            writer.println("<h2>Run aborted due to exception</h2>");
            writer.println("<pre>" + testResult.getFailedMessage() + "</pre>");
        }
        writer.println("</BODY>");
        writer.println("</HTML>");
        writer.close();
    }

    public static void createLogReport(CheckResult checkResult, String className, String testName2, File classDirectory) throws IOException {
        File logFile = new File(classDirectory, testName2 + "_log.html");
        BufferedOutputStream out = new BufferedOutputStream(new FileOutputStream(logFile));
        PrintWriter writer = new PrintWriter(out);
        writer.println("<HTML>");
        writer.println("<HEAD><TITLE>Log: " + testName2 + "</TITLE>");
        writer.println("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\" /></HEAD>");
        writer.println("<BODY>");
        writer.println(checkResult.getLog());
        writer.println("</BODY>");
        writer.println("</HTML>");
        writer.close();
    }
}

