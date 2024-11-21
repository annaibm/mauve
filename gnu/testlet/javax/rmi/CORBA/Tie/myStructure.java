/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.rmi.CORBA.Tie;

import java.io.Serializable;

public class myStructure
implements Serializable {
    public int a = 1;
    private int b = 2;
    public String c = "three";

    public String toString() {
        return this.a + " " + this.b + " " + this.c;
    }
}

