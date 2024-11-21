/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.util.logging.Logger;

import java.util.logging.Filter;
import java.util.logging.LogRecord;

public class TestFilter
implements Filter {
    private LogRecord lastRecord;

    @Override
    public boolean isLoggable(LogRecord record) {
        this.lastRecord = record;
        return true;
    }

    public LogRecord getLastRecord() {
        return this.lastRecord;
    }
}

