/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.io.ObjectInputOutput;

import gnu.testlet.java.io.ObjectInputOutput.SerializableLoopA;
import java.io.Serializable;

public class SerializableLoopB
implements Serializable {
    private static final long serialVersionUID = 3033857304110309388L;
    SerializableLoopA a;
    int value = -1;

    public SerializableLoopA getA() {
        return this.a;
    }

    public void setA(SerializableLoopA a) {
        this.a = a;
    }

    public int getValue() {
        return this.value;
    }

    public void setValue(int value2) {
        this.value = value2;
    }

    public boolean equals(Object obj) {
        if (obj instanceof SerializableLoopB) {
            return this.getValue() == ((SerializableLoopB)obj).getValue();
        }
        return false;
    }

    public int hashCode() {
        return new Integer(this.getValue()).hashCode();
    }
}

