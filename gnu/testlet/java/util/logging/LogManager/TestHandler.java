/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.util.logging.LogManager;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Handler;
import java.util.logging.LogRecord;

public class TestHandler
extends Handler {
    private List records = new ArrayList();
    boolean isClosed = false;

    public Iterator records() {
        return this.records.iterator();
    }

    @Override
    public void close() {
        this.isClosed = true;
    }

    @Override
    public void flush() {
        this.records.clear();
    }

    @Override
    public void publish(LogRecord record) {
        this.records.add(record);
    }
}

