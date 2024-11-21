/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.runner;

import gnu.testlet.runner.Result;

public class CheckResult
implements Result {
    private int number;
    private String checkPoint;
    private boolean passed;
    private String expected;
    private String actual;
    private StringBuffer log;

    public CheckResult(int number, boolean passed) {
        this.number = number;
        this.passed = passed;
    }

    public int getNumber() {
        return this.number;
    }

    void setNumber(int number) {
        this.number = number;
    }

    public boolean getPassed() {
        return this.passed;
    }

    void setPassed(boolean passed) {
        this.passed = passed;
    }

    public String getCheckPoint() {
        return this.checkPoint;
    }

    void setCheckPoint(String checkPoint) {
        this.checkPoint = checkPoint;
    }

    public String getActual() {
        if (this.actual == null) {
            return "n/a";
        }
        return this.actual;
    }

    void setActual(String actual) {
        this.actual = actual;
    }

    public String getExpected() {
        if (this.expected == null) {
            return "n/a";
        }
        return this.expected;
    }

    void setExpected(String expected) {
        this.expected = expected;
    }

    public String getLog() {
        if (this.log == null) {
            return "";
        }
        return this.log.toString();
    }

    void appendToLog(String message) {
        if (this.log == null) {
            this.log = new StringBuffer();
        }
        this.log.append(message);
    }

    @Override
    public String getName() {
        return Integer.toString(this.number);
    }
}

