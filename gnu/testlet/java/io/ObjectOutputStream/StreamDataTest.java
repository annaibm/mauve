/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.io.ObjectOutputStream;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class StreamDataTest
implements Testlet {
    static int offset = 0;
    static byte[] streamData;

    static boolean compare(int[] expectedData) {
        try {
            for (int i = 0; i < expectedData.length; ++i) {
                if (streamData[offset + i] == (byte)(expectedData[i] & 0xFF)) continue;
                boolean bl = false;
                return bl;
            }
        }
        finally {
            offset += expectedData.length;
        }
        return true;
    }

    @Override
    public void test(TestHarness harness) {
        try {
            this.checkStream(harness);
        }
        catch (IOException x) {
            harness.fail(x.toString());
        }
    }

    public void checkStream(TestHarness harness) throws IOException {
        ByteArrayOutputStream os = new ByteArrayOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream(os);
        oos.useProtocolVersion(2);
        oos.writeInt(1);
        oos.writeShort(7);
        oos.writeFloat(9.96601f);
        oos.writeLong(-900000000000001L);
        oos.writeShort(-1);
        oos.writeDouble(Math.PI);
        oos.writeByte(122);
        oos.writeDouble(Double.NaN);
        byte[] bytes = new byte[]{-1, 2, -3, 4, -5};
        oos.writeObject(bytes);
        oos.writeByte(100);
        oos.writeChar(88);
        oos.close();
        streamData = os.toByteArray();
        harness.check(streamData.length, 76, "Stream length");
        int[] data = new int[]{172, 237};
        harness.check(StreamDataTest.compare(data), "magic");
        data = new int[]{0, 5};
        harness.check(StreamDataTest.compare(data), "version");
        data = new int[]{119, 37};
        harness.check(StreamDataTest.compare(data), "TC_BLOCKDATA");
        data = new int[]{0, 0, 0, 1};
        harness.check(StreamDataTest.compare(data), "(int) 1");
        data = new int[]{0, 7};
        harness.check(StreamDataTest.compare(data), "(short) 7");
        data = new int[]{65, 31, 116, 199};
        harness.check(StreamDataTest.compare(data), "(float)");
        data = new int[]{255, 252, 205, 116, 107, 179, 191, 255};
        harness.check(StreamDataTest.compare(data), "(long)");
        data = new int[]{255, 255};
        harness.check(StreamDataTest.compare(data), "(short) -1");
        data = new int[]{64, 9, 33, 251, 84, 68, 45, 24};
        harness.check(StreamDataTest.compare(data), "(double) Math.PI");
        data = new int[]{122};
        harness.check(StreamDataTest.compare(data), "(byte) 'z'");
        data = new int[]{127, 248, 0, 0, 0, 0, 0, 0};
        harness.check(StreamDataTest.compare(data), "(double) Double.NaN");
        data = new int[]{117};
        harness.check(StreamDataTest.compare(data), "TC_NEWARRAY");
        data = new int[]{114};
        harness.check(StreamDataTest.compare(data), "TC_CLASSDESC");
        data = new int[]{0, 2, 91, 66};
        harness.check(StreamDataTest.compare(data), "[B");
        data = new int[]{172, 243, 23, 248, 6, 8, 84, 224};
        harness.check(StreamDataTest.compare(data), "SerialVersionUID");
        data = new int[]{2, 0, 0, 120};
        harness.check(StreamDataTest.compare(data), "Handle");
        data = new int[]{112};
        harness.check(StreamDataTest.compare(data), "ClassDescInfo");
        data = new int[]{0, 0, 0, 5};
        harness.check(StreamDataTest.compare(data), "array size (int) 5");
        data = new int[]{255, 2, 253, 4, 251};
        harness.check(StreamDataTest.compare(data), "int[] array data");
        data = new int[]{119, 3};
        harness.check(StreamDataTest.compare(data), "TC_BLOCKDATA");
        data = new int[]{100};
        harness.check(StreamDataTest.compare(data), "(byte) 100");
        data = new int[]{0, 88};
        harness.check(StreamDataTest.compare(data), "(char) 'X'");
    }
}

