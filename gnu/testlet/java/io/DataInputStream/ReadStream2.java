/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.io.DataInputStream;

import gnu.testlet.TestHarness;
import java.io.DataInputStream;
import java.io.IOException;

public class ReadStream2 {
    public static void runReadTest(DataInputStream dis, TestHarness harness) {
        String s2 = "Random";
        byte[] b2 = new byte[s2.length()];
        String s3 = " String Two";
        byte[] b3 = new byte[s3.length()];
        try {
            dis.skipBytes(34);
            dis.readFully(b2);
            harness.check(s2, new String(b2), "readFully(buf)");
            dis.readFully(b3, 0, b3.length);
            harness.check(s3, new String(b3), "readFully(buf, off, len)");
            dis.read(b2, 0, 1);
            harness.check(88, b2[0], "read(b[])");
            dis.read(b2, 0, 6);
            String s4 = new String(b2);
            harness.check("abcdef", s4, "read(b, off, len)");
            harness.check(12, dis.readUnsignedByte(), "readUnsignedByte()");
            harness.check(1234, dis.readUnsignedShort(), "readUnsignedShort()");
        }
        catch (IOException e) {
            harness.debug(e);
            harness.check(false, "Reading DataInputStream (2)");
        }
    }
}

