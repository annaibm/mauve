/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.io.DataInputStream;

import gnu.testlet.TestHarness;
import java.io.DataInputStream;
import java.io.IOException;

public class ReadStream {
    public static void runReadTest(DataInputStream dis, TestHarness harness) {
        try {
            harness.check(dis.readBoolean(), "readBoolean() true");
            harness.check(!dis.readBoolean(), "readBoolean() false");
            harness.check(dis.readByte(), 8, "readByte()");
            harness.check(dis.readByte(), -122, "readByte()");
            harness.check(dis.readChar(), 97, "readChar()");
            harness.check(dis.readChar(), 58066, "readChar()");
            harness.check(dis.readShort(), 32000, "readShort()");
            harness.check(dis.readInt(), 8675309, "readInt()");
            harness.check(dis.readLong(), 696969696969L, "readLong()");
            harness.check(Float.toString(dis.readFloat()), "3.1415", "readFloat()");
            harness.check(dis.readDouble(), 9.99999999999E8, "readDouble");
            harness.check(dis.readUTF(), "Testing code is such a boring activity but it must be done", "readUTF()");
            harness.check(dis.readUTF(), "a-->\u01ff\ua000\u6666\u0200RRR", "readUTF()");
        }
        catch (IOException e) {
            harness.debug(e);
            harness.check(false, "Reading DataInputStream");
        }
    }
}

