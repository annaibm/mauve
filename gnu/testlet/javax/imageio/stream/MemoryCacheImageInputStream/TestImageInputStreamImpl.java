/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.imageio.stream.MemoryCacheImageInputStream;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.nio.ByteOrder;
import java.util.Arrays;
import javax.imageio.stream.MemoryCacheImageInputStream;

public class TestImageInputStreamImpl
implements Testlet {
    @Override
    public void test(TestHarness h) {
        int k = 0;
        try {
            byte[] b = new byte[]{114, 112, 5, 119, -84, -14, 59, 103};
            ByteArrayInputStream bs = new ByteArrayInputStream(b);
            MemoryCacheImageInputStream i = new MemoryCacheImageInputStream(bs);
            h.check(i.getByteOrder() == ByteOrder.BIG_ENDIAN);
            h.check(i.read() == 114);
            i.seek(0L);
            h.check(i.readBoolean());
            i.seek(0L);
            h.check(i.readByte() == 114);
            i.seek(0L);
            h.check(i.readChar() == '\u7270');
            i.seek(0L);
            h.check(Double.compare(i.readDouble(), 1.709290273164385E243) == 0);
            i.seek(0L);
            h.check(Float.compare(i.readFloat(), 4.7541126E30f) == 0);
            i.seek(0L);
            h.check(i.readInt() == 1919944055);
            i.seek(0L);
            h.check(i.readLong() == 8246096929276181351L);
            i.seek(0L);
            h.check(i.readShort() == 29296);
            i.seek(0L);
            h.check(i.readUnsignedByte() == 114);
            i.seek(0L);
            h.check(i.readUnsignedInt() == 1919944055L);
            i.seek(0L);
            h.check(i.readUnsignedShort() == 29296);
            i.setByteOrder(ByteOrder.LITTLE_ENDIAN);
            h.check(i.getByteOrder() == ByteOrder.LITTLE_ENDIAN);
            i.seek(0L);
            h.check(i.read() == 114);
            i.seek(0L);
            h.check(i.readBoolean());
            i.seek(0L);
            h.check(i.readByte() == 114);
            i.seek(0L);
            h.check(i.readChar() == '\u7072');
            i.seek(0L);
            h.check(Double.compare(i.readDouble(), 1.9456609400629563E189) == 0);
            i.seek(0L);
            h.check(Float.compare(i.readFloat(), 2.7064693E33f) == 0);
            i.seek(0L);
            h.check(i.readInt() == 1996845170);
            i.seek(0L);
            h.check(i.readLong() == 7438806032077647986L);
            i.seek(0L);
            h.check(i.readShort() == 28786);
            i.seek(0L);
            h.check(i.readUnsignedByte() == 114);
            i.seek(0L);
            h.check(i.readUnsignedInt() == 1996845170L);
            i.seek(0L);
            h.check(i.readUnsignedShort() == 28786);
            b = new byte[]{-110, -128, 5, 119, -84, -14, -117, -89};
            bs = new ByteArrayInputStream(b);
            i = new MemoryCacheImageInputStream(bs);
            h.check(i.read() == 146);
            i.seek(0L);
            h.check(i.readBoolean());
            i.seek(0L);
            h.check(i.readByte() == -110);
            i.seek(0L);
            h.check(i.readChar() == '\u9280');
            i.seek(0L);
            h.check(Double.compare(i.readDouble(), -1.4183142849706364E-219) == 0);
            i.seek(0L);
            h.check(Float.compare(i.readFloat(), -8.079283E-28f) == 0);
            i.seek(0L);
            h.check(i.readInt() == -1837103753);
            i.seek(0L);
            h.check(i.readLong() == -7890300535592285273L);
            i.seek(0L);
            h.check(i.readShort() == -28032);
            i.seek(0L);
            h.check(i.readUnsignedByte() == 146);
            i.seek(0L);
            h.check(i.readUnsignedInt() == 2457863543L);
            i.seek(0L);
            h.check(i.readUnsignedShort() == 37504);
            i.setByteOrder(ByteOrder.LITTLE_ENDIAN);
            i.seek(0L);
            h.check(i.read() == 146);
            i.seek(0L);
            h.check(i.readBoolean());
            i.seek(0L);
            h.check(i.readByte() == -110);
            i.seek(0L);
            h.check(i.readChar() == '\u8092');
            i.seek(0L);
            h.check(Double.compare(i.readDouble(), -3.463391436203922E-118) == 0);
            i.seek(0L);
            h.check(Float.compare(i.readFloat(), 2.707747E33f) == 0);
            i.seek(0L);
            h.check(i.readInt() == 1996849298);
            i.seek(0L);
            h.check(i.readLong() == -6373734025067659118L);
            i.seek(0L);
            h.check(i.readShort() == -32622);
            i.seek(0L);
            h.check(i.readUnsignedByte() == 146);
            i.seek(0L);
            h.check(i.readUnsignedInt() == 1996849298L);
            i.seek(0L);
            h.check(i.readUnsignedShort() == 32914);
            i.seek(4L);
            h.check(i.getStreamPosition() == 4L);
            i.flush();
            h.check(i.getFlushedPosition() == 4L);
            boolean exceptionThrown = false;
            try {
                i.flushBefore(3L);
            }
            catch (IndexOutOfBoundsException e) {
                exceptionThrown = true;
            }
            h.check(exceptionThrown);
            exceptionThrown = false;
            try {
                i.flushBefore(5L);
            }
            catch (IndexOutOfBoundsException e) {
                exceptionThrown = true;
            }
            h.check(exceptionThrown);
            exceptionThrown = false;
            try {
                i.seek(2L);
            }
            catch (IndexOutOfBoundsException e) {
                exceptionThrown = true;
            }
            h.check(exceptionThrown);
            exceptionThrown = false;
            try {
                i.seek(3L);
            }
            catch (IndexOutOfBoundsException e) {
                exceptionThrown = true;
            }
            h.check(exceptionThrown);
            exceptionThrown = false;
            try {
                i.setBitOffset(-1);
            }
            catch (IllegalArgumentException e) {
                exceptionThrown = true;
            }
            h.check(exceptionThrown);
            exceptionThrown = false;
            try {
                i.setBitOffset(8);
            }
            catch (IllegalArgumentException e) {
                exceptionThrown = true;
            }
            h.check(exceptionThrown);
            i.setBitOffset(4);
            h.check(i.getBitOffset() == 4);
            h.check(i.isCached());
            h.check(!i.isCachedFile());
            h.check(i.isCachedMemory());
            h.check(i.length() == -1L);
            i.seek(4L);
            i.mark();
            i.read();
            i.read();
            i.reset();
            h.check(i.getStreamPosition() == 4L);
            h.check(i.readBit() == 1);
            h.check(i.readBit() == 0);
            h.check(i.readBit() == 1);
            h.check(i.readBit() == 0);
            h.check(i.readBit() == 1);
            h.check(i.readBit() == 1);
            h.check(i.readBit() == 0);
            h.check(i.getBitOffset() == 7);
            i.setBitOffset(2);
            h.check(i.readBit() == 1);
            h.check(i.readBit() == 0);
            h.check(i.readBit() == 1);
            h.check(i.readBit() == 1);
            h.check(i.readBit() == 0);
            h.check(i.getStreamPosition() == 4L);
            h.check(i.readBit() == 0);
            h.check(i.getStreamPosition() == 5L);
            h.check(i.readBit() == 1);
            h.check(i.readBit() == 1);
            h.check(i.readBit() == 1);
            h.check(i.readBit() == 1);
            h.check(i.getBitOffset() == 4);
            h.check(i.readBit() == 0);
            h.check(i.readBit() == 0);
            h.check(i.readBit() == 1);
            h.check(i.readBit() == 0);
            h.check(i.getBitOffset() == 0);
            h.check(i.getStreamPosition() == 6L);
            h.check(i.length() == -1L);
            i.close();
            exceptionThrown = false;
            try {
                i.close();
            }
            catch (IOException e) {
                exceptionThrown = true;
            }
            h.check(exceptionThrown);
            b = new byte[]{-110, -128, 5, 119, -84, -14, -117, -89, 92, -48, -86, 15, -119, 0, 18, -15, -95, -17, -126, 0, -110, -128, 5, 119, -84, -14, -117, -89, 92, -48, -86, 15, -119, 0, 18, -15, -95, -17, -126, 0, -110, -128, 5, 119, -84, -14, -117, -89, 92, -48, -86, 15, -119, 0, 18, -15, -95, -17, -126, 0, -110, -128, 5, 119};
            bs = new ByteArrayInputStream(b);
            i = new MemoryCacheImageInputStream(bs);
            i.seek(5L);
            i.setBitOffset(6);
            exceptionThrown = false;
            try {
                i.readBits(-1);
            }
            catch (IllegalArgumentException e) {
                exceptionThrown = true;
            }
            h.check(exceptionThrown);
            exceptionThrown = false;
            try {
                i.readBits(65);
            }
            catch (IllegalArgumentException e) {
                exceptionThrown = true;
            }
            h.check(exceptionThrown);
            h.check(i.readBits(59) == 366848453836545810L);
            i.seek(5L);
            i.setBitOffset(6);
            h.check(i.readBits(58) == 183424226918272905L);
            b = new byte[]{-94, -23, -41, 52, 42, -125, -30, 64};
            bs = new ByteArrayInputStream(b);
            i = new MemoryCacheImageInputStream(bs);
            h.check(i.readBits(59) == 366848453836545810L);
            b = new byte[]{-94, 2};
            bs = new ByteArrayInputStream(b);
            i = new MemoryCacheImageInputStream(bs);
            long[] res = new long[8];
            i.seek(0L);
            h.check(i.readBits(0) == 0L);
            i.seek(0L);
            for (k = 0; k < 8; ++k) {
                i.setBitOffset(k);
                res[k] = i.readBits(8);
                i.seek(0L);
            }
            i.seek(0L);
            h.check(Arrays.equals(res, new long[]{162L, 68L, 136L, 16L, 32L, 64L, 128L, 1L}));
            b = new byte[]{-110, -128, 5, 119, -84, -14, -117, -89, 92, -48, -86, 15, 0, 2, 18, 33, -95, -17, -126, 0, -110, -128, 5, 119, -84, -14, -117, -89, 92, -48, -86, 15, -119, 0, 18, -15, -95, -17, -126, 0, -110, -128, 5, 119, -84, -14, -117, -89, 92, -48, -86, 15, -119, 0, 18, -15, -95, -17, -126, 0, -110, -128, 5, 119};
            bs = new ByteArrayInputStream(b);
            i = new MemoryCacheImageInputStream(bs);
            i.seek(17L);
            h.check(i.getStreamPosition() == 17L);
            i.mark();
            i.seek(49L);
            h.check(i.getStreamPosition() == 49L);
            i.reset();
            h.check(i.getStreamPosition() == 17L);
            i.setBitOffset(3);
            i.skipBytes(20);
            h.check(i.getStreamPosition() == 37L);
            h.check(i.getBitOffset() == 0);
            i.seek(12L);
            String str = i.readUTF();
            h.check(str.codePointAt(0) == 18);
            h.check(str.codePointAt(1) == 33);
            b = new byte[]{71, 78, 85, 13, 67, 108, 97, 115, 115, 112, 97, 116, 104, 13, 10, 82, 117, 108, 101, 122, 10, 68, 117, 100, 101, 122, 33, 13};
            bs = new ByteArrayInputStream(b);
            i = new MemoryCacheImageInputStream(bs);
            h.check(i.readLine().equals("GNU"));
            h.check(i.readLine().equals("Classpath"));
            h.check(i.readLine().equals("Rulez"));
            h.check(i.readLine().equals("Dudez!"));
            h.check(i.readLine() == null);
            b = new byte[]{-110, -128, 5, 119, -84, -14, -117, -89, 92, -48, -86, 15, -119, 0, 18, -15, -95, -17, -126, 0, -110, -128, 5, 119, -84, -14, -117, -89, 92, -48, -86, 15, -119, 0, 18, -15, -95, -17, -126, 0, -110, -128, 5, 119, -84, -14, -117, -89, 92, -48, -86, 15, -119, 0, 18, -15, -95, -17, -126, 0, -110, -128, 5, 119};
            bs = new ByteArrayInputStream(b);
            i = new MemoryCacheImageInputStream(bs);
            byte[] fullB = new byte[26];
            i.seek(0L);
            i.readFully(fullB);
            h.check(Arrays.equals(fullB, new byte[]{-110, -128, 5, 119, -84, -14, -117, -89, 92, -48, -86, 15, -119, 0, 18, -15, -95, -17, -126, 0, -110, -128, 5, 119, -84, -14}));
            for (k = 0; k < fullB.length; ++k) {
                fullB[k] = 0;
            }
            i.seek(0L);
            i.readFully(fullB, 5, 13);
            h.check(Arrays.equals(fullB, new byte[]{0, 0, 0, 0, 0, -110, -128, 5, 119, -84, -14, -117, -89, 92, -48, -86, 15, -119, 0, 0, 0, 0, 0, 0, 0, 0}));
            char[] fullC = new char[15];
            i.seek(0L);
            i.readFully(fullC, 0, 15);
            h.check(Arrays.equals(fullC, new char[]{'\u9280', '\u0577', '\uacf2', '\u8ba7', '\u5cd0', '\uaa0f', '\u8900', '\u12f1', '\ua1ef', '\u8200', '\u9280', '\u0577', '\uacf2', '\u8ba7', '\u5cd0'}));
            double[] fullD = new double[8];
            i.seek(0L);
            i.readFully(fullD, 0, 8);
            h.check(Arrays.equals(fullD, new double[]{-1.4183142849706364E-219, 1.2402952421911034E139, -3.154063812740471E-145, -3.556316535750171E-92, -2.4925149951304603E-265, -1.4183142849706364E-219, 1.2402952421911034E139, -3.154063812740471E-145}));
            float[] fullF = new float[16];
            i.seek(0L);
            i.readFully(fullF, 0, 16);
            h.check(Arrays.equals(fullF, new float[]{-8.079283E-28f, -6.893558E-12f, 4.698702E17f, -1.5416346E-33f, -1.6229681E-18f, -8.079283E-28f, -6.893558E-12f, 4.698702E17f, -1.5416346E-33f, -1.6229681E-18f, -8.079283E-28f, -6.893558E-12f, 4.698702E17f, -1.5416346E-33f, -1.6229681E-18f, -8.079283E-28f}));
            int[] fullI = new int[16];
            i.seek(0L);
            i.readFully(fullI, 0, 16);
            h.check(Arrays.equals(fullI, new int[]{-1837103753, -1393390681, 1557178895, -1996483855, -1578139136, -1837103753, -1393390681, 1557178895, -1996483855, -1578139136, -1837103753, -1393390681, 1557178895, -1996483855, -1578139136, -1837103753}));
            long[] fullL = new long[8];
            i.seek(0L);
            i.readFully(fullL, 0, 8);
            h.check(Arrays.equals(fullL, new long[]{-7890300535592285273L, 6688032430344901361L, -6778055975199832713L, -5984567403888989681L, -8574832861500177920L, -7890300535592285273L, 6688032430344901361L, -6778055975199832713L}));
            short[] fullS = new short[32];
            i.seek(0L);
            i.readFully(fullS, 0, 32);
            h.check(Arrays.equals(fullS, new short[]{-28032, 1399, -21262, -29785, 23760, -22001, -30464, 4849, -24081, -32256, -28032, 1399, -21262, -29785, 23760, -22001, -30464, 4849, -24081, -32256, -28032, 1399, -21262, -29785, 23760, -22001, -30464, 4849, -24081, -32256, -28032, 1399}));
        }
        catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

