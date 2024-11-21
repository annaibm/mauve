/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet;

import gnu.testlet.TestResult;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;

public class TestReport {
    private Properties systemProperties;
    private List<TestResult> testResults;
    private static final String ENCODING = "UTF-8";

    public TestReport(Properties systemProperties) {
        this.systemProperties = systemProperties;
        this.testResults = new ArrayList<TestResult>();
    }

    public void addTestResult(TestResult result) {
        this.testResults.add(result);
    }

    public void writeXml(File f) throws IOException {
        OutputStreamWriter out = new OutputStreamWriter((OutputStream)new FileOutputStream(f), ENCODING);
        out.write("<?xml version='1.0' encoding='UTF-8'?>\n");
        out.write("<testreport version='0.1'>\n  <jvm name='" + this.escAttrib(this.systemProperties.get("java.vm.vendor")) + "'\n    version='" + this.escAttrib(this.systemProperties.get("java.vm.version")) + "' \n    os='" + this.escAttrib(this.systemProperties.get("os.name")) + " " + this.escAttrib(this.systemProperties.get("os.version")) + " " + this.escAttrib(this.systemProperties.get("os.arch")) + "' />\n");
        Collections.sort(this.testResults);
        Iterator<TestResult> results = this.testResults.iterator();
        while (results.hasNext()) {
            int i;
            System.out.println("RunnerProcess:restart-timer");
            TestResult tr = results.next();
            String[] failures = tr.getFailMessags();
            String[] passes = tr.getPassMessages();
            out.write("  <testresult testlet='" + this.escAttrib(tr.getTestletName()));
            if (failures.length > 0 || passes.length > 0 || tr.getException() != null) {
                out.write("'>\n");
            } else {
                out.write("'/>\n");
            }
            for (i = 0; i < failures.length; ++i) {
                System.out.println("RunnerProcess:restart-timer");
                out.write("    <failure>" + this.esc(failures[i]) + "</failure>\n");
            }
            if (tr.getException() != null) {
                Throwable t = tr.getException();
                out.write("    <failure>\n      <exception class='" + this.escAttrib(t.getClass().getName()) + "'>\n        <reason>" + this.esc(tr.getExceptionMessage()) + "</reason>\n        <message>\n" + this.esc(tr.getExceptionReason()) + "\n        </message>\n      </exception>\n    </failure>\n");
            }
            for (i = 0; i < passes.length; ++i) {
                System.out.println("RunnerProcess:restart-timer");
                out.write("    <pass>" + this.esc(passes[i]) + "</pass>\n");
            }
            if (failures.length <= 0 && passes.length <= 0 && tr.getException() == null) continue;
            out.write("  </testresult>\n");
        }
        out.write("</testreport>\n");
        ((Writer)out).close();
    }

    private String esc(String str) {
        if (str == null) {
            return null;
        }
        str = str.replaceAll("&", "&amp;");
        str = str.replaceAll("<", "&lt;");
        str = str.replaceAll(">", "&gt;");
        str = str.replace('\u000b', '?');
        return str;
    }

    private String escAttrib(Object obj) {
        if (obj == null) {
            return null;
        }
        String str = (String)obj;
        str = str.replaceAll("'", "\\'");
        return str;
    }
}

