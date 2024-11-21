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

public class WriteRead
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        try {
            FileOutputStream fos = new FileOutputStream("dataoutput.out");
            DataOutputStream dos = new DataOutputStream(fos);
            dos.writeBoolean(true);
            dos.writeBoolean(false);
            dos.writeByte(8);
            dos.writeByte(-122);
            dos.writeChar(97);
            dos.writeChar(58066);
            dos.writeShort(32000);
            dos.writeInt(8675309);
            dos.writeLong(696969696969L);
            dos.writeFloat(3.1415f);
            dos.writeDouble(9.99999999999E8);
            dos.writeUTF("Testing code is such a boring activity but it must be done");
            dos.writeUTF("a-->\u01ff\ua000\u6666\u0200RRR");
            dos.close();
            harness.check(true, "DataOutputStream write (conditionally");
        }
        catch (Exception e) {
            harness.debug(e);
            harness.check(false, "DataOutputStream write");
            return;
        }
        try {
            FileInputStream is = new FileInputStream("dataoutput.out");
            DataInputStream dis = new DataInputStream(is);
            harness.debug("Reading data written during write phase.");
            WriteRead.runReadTest(dis, harness);
            dis.close();
        }
        catch (Exception e) {
            harness.debug(e);
            harness.check(false, "Read data written during write phase");
        }
    }

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

