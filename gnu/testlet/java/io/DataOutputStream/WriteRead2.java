/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.io.DataOutputStream;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class WriteRead2
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        try {
            FileOutputStream fos = new FileOutputStream("dataoutput2.out");
            DataOutputStream dos = new DataOutputStream(fos);
            byte[] b = new byte[]{97, 98, 99, 100, 101, 102};
            dos.writeChars("Random String One");
            dos.writeBytes("Random String Two");
            dos.write(88);
            dos.write(b, 0, b.length);
            dos.writeByte(12);
            dos.writeShort(1234);
            dos.flush();
            harness.check(true, "flush()");
            harness.check(dos.size(), 61, "size()");
            dos.close();
            harness.check(true, "DataOutputStream write (2, conditionally");
        }
        catch (Exception e) {
            harness.debug(e);
            harness.check(false, "DataOutputStream write(2)");
            return;
        }
        try {
            FileInputStream is = new FileInputStream("dataoutput2.out");
            DataInputStream dis = new DataInputStream(is);
            harness.debug("Reading data written during write phase.");
            WriteRead2.runReadTest(dis, harness);
            dis.close();
        }
        catch (Exception e) {
            harness.debug(e);
            harness.check(false, "Read data written during write phase");
        }
    }

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

