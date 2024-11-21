/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.io.ObjectInputStream;

import java.io.InvalidObjectException;
import java.io.ObjectStreamException;
import java.io.Serializable;

public class ReadResolveHelper
implements Serializable {
    public int value;

    public ReadResolveHelper(int value2) {
        this.value = value2;
    }

    protected Object readResolve() throws ObjectStreamException {
        switch (this.value) {
            case 1: {
                throw new Error();
            }
            case 2: {
                throw new RuntimeException("RuntimeException");
            }
            case 3: {
                throw new InvalidObjectException("InvalidObjectException");
            }
        }
        return new ReadResolveHelper(4);
    }
}

