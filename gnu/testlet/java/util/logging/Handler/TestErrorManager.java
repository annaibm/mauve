/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.util.logging.Handler;

import java.util.logging.ErrorManager;

public class TestErrorManager
extends ErrorManager {
    private String lastMessage;
    private Exception lastException;
    private int lastErrorCode;

    @Override
    public void error(String s, Exception ex, int code) {
        this.lastMessage = s;
        this.lastException = ex;
        this.lastErrorCode = code;
    }

    public String getLastMessage() {
        return this.lastMessage;
    }

    public Exception getLastException() {
        return this.lastException;
    }

    public int getLastErrorCode() {
        return this.lastErrorCode;
    }
}

