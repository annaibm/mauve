/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.runner;

import gnu.testlet.runner.CheckResult;
import gnu.testlet.runner.Result;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class TestResult
implements Comparable,
Result {
    private String name;
    private List checkResults;
    private String error = null;

    TestResult(String name2) {
        this.name = name2;
        this.checkResults = new ArrayList();
    }

    @Override
    public String getName() {
        return this.name;
    }

    void setName(String name2) {
        this.name = name2;
    }

    void add(CheckResult result) {
        this.checkResults.add(result);
    }

    public Iterator getCheckIterator() {
        return this.checkResults.iterator();
    }

    public int getCheckCount() {
        return this.checkResults.size();
    }

    public int getCheckCount(boolean passed) {
        int result = 0;
        for (CheckResult check2 : this.checkResults) {
            if (check2.getPassed() != passed) continue;
            ++result;
        }
        if (!passed && this.error != null) {
            ++result;
        }
        return result;
    }

    public int compareTo(Object obj) {
        TestResult that = (TestResult)obj;
        return this.getName().compareTo(that.getName());
    }

    void failed(Throwable t) {
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        PrintWriter w = new PrintWriter(out, false);
        t.printStackTrace(w);
        w.close();
        try {
            out.close();
            this.error = out.toString();
        }
        catch (IOException iOException) {
            // empty catch block
        }
    }

    public boolean isFailed() {
        return this.error != null;
    }

    public String getFailedMessage() {
        return this.error;
    }

    public void setFailedMessage(String error) {
        this.error = error;
    }
}

