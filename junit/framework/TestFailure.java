/*
 * Decompiled with CFR 0.152.
 */
package junit.framework;

import java.io.PrintWriter;
import java.io.StringWriter;
import junit.framework.AssertionFailedError;
import junit.framework.Test;

public class TestFailure {
    protected Test fFailedTest;
    protected Throwable fThrownException;

    public TestFailure(Test failedTest, Throwable thrownException) {
        this.fFailedTest = failedTest;
        this.fThrownException = thrownException;
    }

    public String exceptionMessage() {
        return this.fThrownException.getMessage();
    }

    public Test failedTest() {
        return this.fFailedTest;
    }

    public boolean isFailure() {
        return this.fThrownException instanceof AssertionFailedError;
    }

    public String toString() {
        StringBuffer str = new StringBuffer();
        str.append(this.fFailedTest);
        str.append(": ");
        str.append(this.fThrownException.getMessage());
        return str.toString();
    }

    public String trace() {
        StringWriter w = new StringWriter();
        PrintWriter p = new PrintWriter(w);
        this.fThrownException.printStackTrace(p);
        return w.getBuffer().toString();
    }
}

