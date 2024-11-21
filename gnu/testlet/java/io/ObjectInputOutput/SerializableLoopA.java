/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.io.ObjectInputOutput;

import gnu.testlet.java.io.ObjectInputOutput.SerializableLoopB;
import java.io.Serializable;

public class SerializableLoopA
implements Serializable {
    private static final long serialVersionUID = -8099761309283286991L;
    SerializableLoopB b;

    public SerializableLoopB getB() {
        return this.b;
    }

    public void setB(SerializableLoopB b) {
        this.b = b;
    }
}

