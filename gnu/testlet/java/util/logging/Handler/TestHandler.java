/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.util.logging.Handler;

import java.util.logging.Handler;
import java.util.logging.LogRecord;

public class TestHandler
extends Handler {
    @Override
    public void flush() {
    }

    @Override
    public void close() {
    }

    @Override
    public void publish(LogRecord record) {
    }

    public void invokeReportError(String msg, Exception ex, int code) {
        this.reportError(msg, ex, code);
    }
}

