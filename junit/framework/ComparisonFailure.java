/*
 * Decompiled with CFR 0.152.
 */
package junit.framework;

import junit.framework.AssertionFailedError;

public class ComparisonFailure
extends AssertionFailedError {
    private static final long serialVersionUID = 2747813684729318422L;

    public ComparisonFailure(String message, String expected, String value2) {
        super(message);
    }
}

