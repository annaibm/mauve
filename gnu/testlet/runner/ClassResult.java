/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.runner;

import gnu.testlet.runner.Result;
import gnu.testlet.runner.TestResult;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class ClassResult
implements Comparable,
Result {
    private String name;
    private List testResults;
    private boolean sorted = true;

    ClassResult(String name2) {
        this.name = name2;
        this.testResults = new ArrayList();
    }

    @Override
    public String getName() {
        return this.name;
    }

    void setName(String name2) {
        this.name = name2;
    }

    public void add(TestResult result) {
        this.testResults.add(result);
        this.sorted = false;
    }

    public Iterator getTestIterator() {
        if (!this.sorted) {
            Collections.sort(this.testResults);
            this.sorted = true;
        }
        return this.testResults.iterator();
    }

    public int getCheckCount() {
        int result = 0;
        for (TestResult test : this.testResults) {
            result += test.getCheckCount();
        }
        return result;
    }

    public int getCheckCount(boolean passed) {
        int result = 0;
        for (TestResult test : this.testResults) {
            result += test.getCheckCount(passed);
        }
        return result;
    }

    public int compareTo(Object obj) {
        ClassResult that = (ClassResult)obj;
        return this.getName().compareTo(that.getName());
    }
}

