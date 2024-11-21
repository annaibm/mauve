/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.io.Serializable;

import gnu.testlet.java.io.Serializable.BreakMe;
import java.io.Serializable;

public class MyBreakMe
implements Serializable {
    static {
        BreakMe.broken = new MyBreakMe();
        if (!BreakMe.generating) {
            throw new IndexOutOfBoundsException("Darn!");
        }
    }
}

