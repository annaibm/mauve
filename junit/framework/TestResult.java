/*
 * Decompiled with CFR 0.152.
 */
package junit.framework;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Enumeration;
import java.util.List;
import junit.framework.AssertionFailedError;
import junit.framework.Protectable;
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestFailure;
import junit.framework.TestListener;

public class TestResult {
    protected List<TestFailure> fErrors = new ArrayList<TestFailure>();
    protected List<TestFailure> fFailures = new ArrayList<TestFailure>();
    protected List<TestListener> fListeners = new ArrayList<TestListener>();
    protected int fRunTests = 0;
    private boolean fStop = false;

    protected void run(final TestCase test) {
        this.startTest(test);
        Protectable protectable = new Protectable(){

            @Override
            public void protect() throws Throwable {
                test.runBare();
            }
        };
        this.runProtected(test, protectable);
        this.endTest(test);
    }

    public void runProtected(TestCase test, Protectable p) {
        try {
            p.protect();
        }
        catch (AssertionFailedError e) {
            this.addFailure(test, e);
        }
        catch (ThreadDeath e) {
            throw e;
        }
        catch (Throwable e) {
            this.addError(test, e);
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void startTest(Test test) {
        int count = test.countTestCases();
        TestResult testResult = this;
        synchronized (testResult) {
            this.fRunTests += count;
        }
        for (TestListener l : this.cloneListeners()) {
            l.startTest(test);
        }
    }

    public void endTest(Test test) {
        for (TestListener l : this.cloneListeners()) {
            l.endTest(test);
        }
    }

    public synchronized void addFailure(Test test, AssertionFailedError failure) {
        this.fFailures.add(new TestFailure(test, failure));
        for (TestListener l : this.cloneListeners()) {
            l.addFailure(test, failure);
        }
    }

    public synchronized void addError(Test test, Throwable failure) {
        this.fErrors.add(new TestFailure(test, failure));
        for (TestListener l : this.cloneListeners()) {
            l.addError(test, failure);
        }
    }

    public synchronized void addListener(TestListener l) {
        this.fListeners.add(l);
    }

    public synchronized void removeListener(TestListener l) {
        this.fListeners.remove(l);
    }

    public synchronized int errorCount() {
        return this.fErrors.size();
    }

    public synchronized Enumeration<TestFailure> errors() {
        return Collections.enumeration(this.fErrors);
    }

    public synchronized int failureCount() {
        return this.fFailures.size();
    }

    public synchronized Enumeration<TestFailure> failures() {
        return Collections.enumeration(this.fFailures);
    }

    public synchronized int runCount() {
        return this.fRunTests;
    }

    public synchronized boolean shouldStop() {
        return this.fStop;
    }

    public synchronized void stop() {
        this.fStop = true;
    }

    public synchronized boolean wasSuccessful() {
        return this.failureCount() == 0 && this.errorCount() == 0;
    }

    private synchronized List<TestListener> cloneListeners() {
        ArrayList<TestListener> copy2 = new ArrayList<TestListener>();
        copy2.addAll(this.fListeners);
        return copy2;
    }
}

