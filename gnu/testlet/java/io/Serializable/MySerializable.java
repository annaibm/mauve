/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.io.Serializable;

import java.io.ObjectStreamException;
import java.io.Serializable;

public class MySerializable
implements Serializable {
    private boolean resolved = false;

    public boolean isResolved() {
        return this.resolved;
    }

    private Object readResolve() throws ObjectStreamException {
        this.resolved = true;
        return this;
    }
}

