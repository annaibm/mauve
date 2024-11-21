/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.runner;

import gnu.testlet.runner.CheckResult;
import gnu.testlet.runner.ClassResult;
import gnu.testlet.runner.PackageResult;
import gnu.testlet.runner.RunResult;
import gnu.testlet.runner.TestResult;
import gnu.testlet.runner.XMLReportConstants;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.Iterator;

public class XMLReportWriter
implements XMLReportConstants {
    private static final String INDENT = "  ";
    private static final String NOT_APPLIABLE = "n/a";
    private final boolean compactMode;

    public XMLReportWriter() {
        this(false);
    }

    public XMLReportWriter(boolean compactMode) {
        this.compactMode = compactMode;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void write(RunResult result, File output) throws FileNotFoundException {
        try (PrintWriter ps = null;){
            ps = new PrintWriter(new FileOutputStream(output));
            this.write(result, ps);
        }
    }

    public void write(RunResult result, PrintWriter ps) {
        int level = 0;
        this.runResult(ps, level, result);
        ++level;
        Iterator itPackage = result.getPackageIterator();
        while (itPackage.hasNext()) {
            PackageResult pkg = (PackageResult)itPackage.next();
            this.packageResult(ps, level, pkg);
            ++level;
            Iterator itClass = pkg.getClassIterator();
            while (itClass.hasNext()) {
                ClassResult cls = (ClassResult)itClass.next();
                this.classResult(ps, level, cls);
                ++level;
                Iterator itTest = cls.getTestIterator();
                while (itTest.hasNext()) {
                    TestResult test = (TestResult)itTest.next();
                    this.test(ps, level, test);
                    ++level;
                    Iterator itCheck = test.getCheckIterator();
                    while (itCheck.hasNext()) {
                        CheckResult check2 = (CheckResult)itCheck.next();
                        this.check(ps, level, check2);
                    }
                    this.endTag(ps, --level, "test");
                }
                this.endTag(ps, --level, "class");
            }
            this.endTag(ps, --level, "package");
        }
        this.endTag(ps, --level, "run");
        ps.flush();
    }

    private void check(PrintWriter ps, int level, CheckResult check2) {
        String log = this.getNullIfBlank(check2.getLog());
        boolean closeTag = log == null;
        this.beginTag(ps, level, "check", closeTag, new Object[]{"number", check2.getNumber(), "check-point", check2.getCheckPoint(), "passed", check2.getPassed(), "expected", check2.getExpected(), "actual", check2.getActual()});
        if (!closeTag) {
            this.text(ps, level + 1, "log", log);
            this.endTag(ps, level, "check");
        }
    }

    private void test(PrintWriter ps, int level, TestResult test) {
        this.beginTag(ps, level, "test", false, new Object[]{"name", test.getName()});
        this.text(ps, level + 1, "error", test.getFailedMessage());
    }

    private void classResult(PrintWriter ps, int level, ClassResult cr) {
        this.beginTag(ps, level, "class", false, new Object[]{"name", cr.getName()});
    }

    private void packageResult(PrintWriter ps, int level, PackageResult pr) {
        this.beginTag(ps, level, "package", false, new Object[]{"name", pr.getName()});
    }

    private void runResult(PrintWriter ps, int level, RunResult rr) {
        this.beginTag(ps, level, "run", false, new Object[]{"name", rr.getName()});
        String[] propertyNames = rr.getSystemPropertyNames();
        int subLevel = level + 1;
        for (int i = 0; i < propertyNames.length; ++i) {
            String name2 = propertyNames[i];
            String value2 = rr.getSystemProperty(name2);
            this.beginTag(ps, subLevel, "property", true, new Object[]{"name", name2, "value", value2});
        }
    }

    private PrintWriter text(PrintWriter ps, int level, String tag, String text2) {
        if ((text2 = this.getNullIfBlank(text2)) != null) {
            this.beginTag(ps, level, tag, false, new Object[0]);
            ps.append(XMLReportWriter.protect(text2));
            this.appendCarriageReturn(ps);
            this.endTag(ps, level, tag);
        }
        return ps;
    }

    private PrintWriter beginTag(PrintWriter ps, int level, String tag, boolean closeTag, Object[] attributes) {
        this.tag(ps, level, tag, true);
        for (int i = 0; i < attributes.length; i += 2) {
            String value2 = this.getNullIfBlank(attributes[i + 1]);
            if (value2 == null) continue;
            ps.append(' ').append(String.valueOf(attributes[i]));
            ps.append("=\"").append(XMLReportWriter.protect(value2)).append('\"');
        }
        ps.append(closeTag ? "/>" : ">");
        this.appendCarriageReturn(ps);
        return ps;
    }

    public static String protect(String text2) {
        if (text2 == null) {
            return text2;
        }
        int size2 = text2.length();
        StringBuilder sb = new StringBuilder(size2);
        boolean changed = false;
        block7: for (int i = 0; i < size2; ++i) {
            char c = text2.charAt(i);
            switch (c) {
                case '&': {
                    sb.append("&amp;");
                    changed = true;
                    continue block7;
                }
                case '<': {
                    sb.append("&lt;");
                    changed = true;
                    continue block7;
                }
                case '>': {
                    sb.append("&gt;");
                    changed = true;
                    continue block7;
                }
                case '\'': {
                    sb.append("&apos;");
                    changed = true;
                    continue block7;
                }
                case '\"': {
                    sb.append("&quot;");
                    changed = true;
                    continue block7;
                }
                default: {
                    sb.append(c);
                }
            }
        }
        return changed ? sb.toString() : text2;
    }

    private PrintWriter endTag(PrintWriter ps, int level, String tag) {
        return this.tag(ps, level, tag, false);
    }

    private PrintWriter tag(PrintWriter ps, int level, String tag, boolean begin) {
        this.indent(ps, level).append(begin ? "<" : "</").append(tag);
        if (!begin) {
            ps.append('>');
            this.appendCarriageReturn(ps);
        }
        return ps;
    }

    private PrintWriter appendCarriageReturn(PrintWriter pw) {
        if (!this.compactMode) {
            pw.append('\n');
        }
        return pw;
    }

    private PrintWriter indent(PrintWriter ps, int level) {
        if (!this.compactMode) {
            for (int i = 0; i < level; ++i) {
                ps.print(INDENT);
            }
        }
        return ps;
    }

    private String getNullIfBlank(Object text2) {
        String result = null;
        if (text2 != null && ((result = text2.toString().trim()).isEmpty() || NOT_APPLIABLE.equals(result))) {
            result = null;
        }
        return result;
    }
}

