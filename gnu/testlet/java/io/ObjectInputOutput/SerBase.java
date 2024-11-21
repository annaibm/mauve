/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.io.ObjectInputOutput;

import java.io.Serializable;

class SerBase
implements Serializable {
    private int a;

    SerBase(int a) {
        this.a = a;
    }

    int getA() {
        return this.a;
    }
}

