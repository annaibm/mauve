/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.runner;

import gnu.testlet.runner.PackageResult;
import gnu.testlet.runner.Result;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class RunResult
implements Result {
    private String name;
    private List packageResults;
    private List missingTests = new ArrayList();
    private List faultyTests = new ArrayList();
    private boolean sorted = true;
    private final List systemProperties;

    public RunResult(String name2) {
        this.name = name2;
        this.packageResults = new ArrayList();
        this.systemProperties = new ArrayList();
    }

    public void setSystemProperty(String name2, String value2) {
        boolean found = false;
        for (int i = 0; i < this.systemProperties.size(); i += 2) {
            if (!name2.equals((String)this.systemProperties.get(i))) continue;
            this.systemProperties.set(i + 1, value2);
            found = true;
            break;
        }
        if (!found) {
            this.systemProperties.add(name2);
            this.systemProperties.add(value2);
        }
    }

    public String getSystemProperty(String name2) {
        String value2 = "";
        for (int i = 0; i < this.systemProperties.size(); i += 2) {
            if (!name2.equals((String)this.systemProperties.get(i))) continue;
            value2 = (String)this.systemProperties.get(i + 1);
            break;
        }
        return value2;
    }

    public String[] getSystemPropertyNames() {
        String[] names = new String[this.systemProperties.size() / 2];
        int j = 0;
        for (int i = 0; i < this.systemProperties.size(); i += 2) {
            names[j++] = (String)this.systemProperties.get(i);
        }
        return names;
    }

    @Override
    public String getName() {
        return this.name;
    }

    void setName(String name2) {
        this.name = name2;
    }

    public void add(PackageResult result) {
        this.packageResults.add(result);
        this.sorted = false;
    }

    public Iterator getPackageIterator() {
        this.sortPackages();
        return this.packageResults.iterator();
    }

    public Iterator getMissingTestsIterator() {
        return this.missingTests.iterator();
    }

    public Iterator getFaultyTestsIterator() {
        return this.faultyTests.iterator();
    }

    public int getCheckCount() {
        int result = 0;
        Iterator iterator = this.getPackageIterator();
        while (iterator.hasNext()) {
            PackageResult pr = (PackageResult)iterator.next();
            result += pr.getCheckCount();
        }
        return result;
    }

    public int getCheckCount(boolean passed) {
        int result = 0;
        Iterator iterator = this.getPackageIterator();
        while (iterator.hasNext()) {
            PackageResult pr = (PackageResult)iterator.next();
            result += pr.getCheckCount(passed);
        }
        return result;
    }

    public int indexOf(PackageResult pr) {
        this.sortPackages();
        return this.packageResults.indexOf(pr);
    }

    public PackageResult getPackageResult(String name2) {
        this.sortPackages();
        for (int i = 0; i < this.packageResults.size(); ++i) {
            PackageResult rr = (PackageResult)this.packageResults.get(i);
            if (!rr.getName().equals(name2)) continue;
            return rr;
        }
        return null;
    }

    void addMissingTest(String line) {
        this.missingTests.add(line);
    }

    void addFaultyTest(String line, String failure) {
        this.faultyTests.add(new String[]{line, failure});
    }

    private void sortPackages() {
        if (this.sorted) {
            return;
        }
        Collections.sort(this.packageResults);
        this.sorted = true;
    }
}

