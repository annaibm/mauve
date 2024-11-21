/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.rmi.CORBA.Tie;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

public class Externa
implements Externalizable {
    private static final long serialVersionUID = 1L;
    public int a;
    public int b;
    String sx;

    public String toString() {
        return this.sx;
    }

    @Override
    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
        this.a = in.readInt();
        this.b = in.readInt();
        this.sx = "(ex " + this.a + ":" + this.b + ")";
    }

    @Override
    public void writeExternal(ObjectOutput out) throws IOException {
        out.writeInt(this.a);
        out.writeInt(this.b);
    }
}

