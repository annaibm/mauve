/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet;

import java.util.ArrayList;
import java.util.List;

public class TestResult
implements Comparable<TestResult> {
    private String testletName = null;
    private List<String> failMessages = new ArrayList<String>();
    private List<String> passMessages = new ArrayList<String>();
    private Throwable exception = null;
    private String exceptionReason = null;
    private String exceptionMessage = null;

    public TestResult(String testletName) {
        if (testletName == null) {
            throw new IllegalArgumentException("testletName can not be null");
        }
        this.testletName = testletName;
    }

    public void addPass(String message) {
        this.passMessages.add(message);
    }

    public void addFail(String message) {
        this.failMessages.add(message);
    }

    public void addException(Throwable exception, String message, String reason) {
        if (this.exception != null) {
            throw new IllegalArgumentException("trying to add more than one exception to TestResult");
        }
        this.exception = exception;
        this.exceptionMessage = message;
        this.exceptionReason = reason;
    }

    public int getPassCount() {
        return this.passMessages.size();
    }

    public String[] getFailMessags() {
        return this.failMessages.toArray(new String[this.failMessages.size()]);
    }

    public String[] getPassMessages() {
        return this.passMessages.toArray(new String[this.passMessages.size()]);
    }

    public String getTestletName() {
        return this.testletName;
    }

    public Throwable getException() {
        return this.exception;
    }

    public String getExceptionMessage() {
        return this.exceptionMessage;
    }

    public String getExceptionReason() {
        return this.exceptionReason;
    }

    @Override
    public int compareTo(TestResult other) {
        return this.testletName.compareTo(other.testletName);
    }
}

