/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.runner;

import gnu.testlet.runner.ClassResult;
import gnu.testlet.runner.Result;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class PackageResult
implements Comparable,
Result {
    private String name;
    private List classResults;
    private boolean sorted = true;

    PackageResult(String name2) {
        this.name = name2;
        this.classResults = new ArrayList();
    }

    @Override
    public String getName() {
        return this.name;
    }

    void setName(String name2) {
        this.name = name2;
    }

    public void add(ClassResult result) {
        this.classResults.add(result);
        this.sorted = false;
    }

    public Iterator getClassIterator() {
        this.sortClasses();
        return this.classResults.iterator();
    }

    public ClassResult getClassResult(String name2) {
        this.sortClasses();
        for (int i = 0; i < this.classResults.size(); ++i) {
            ClassResult cr = (ClassResult)this.classResults.get(i);
            if (!cr.getName().equals(name2)) continue;
            return cr;
        }
        return null;
    }

    public int getCheckCount() {
        int result = 0;
        Iterator iterator = this.getClassIterator();
        while (iterator.hasNext()) {
            ClassResult cr = (ClassResult)iterator.next();
            result += cr.getCheckCount();
        }
        return result;
    }

    public int getCheckCount(boolean passed) {
        int result = 0;
        Iterator iterator = this.getClassIterator();
        while (iterator.hasNext()) {
            ClassResult cr = (ClassResult)iterator.next();
            result += cr.getCheckCount(passed);
        }
        return result;
    }

    public int indexOf(ClassResult result) {
        this.sortClasses();
        return this.classResults.indexOf(result);
    }

    public int compareTo(Object obj) {
        PackageResult that = (PackageResult)obj;
        return this.getName().compareTo(that.getName());
    }

    private void sortClasses() {
        if (this.sorted) {
            return;
        }
        Collections.sort(this.classResults);
        this.sorted = true;
    }
}

