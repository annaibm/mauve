/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.nio.ByteBuffer;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

public class GetPut
implements Testlet {
    private static final byte[] TEST_ARRAY = new byte[116];

    @Override
    public void test(TestHarness h) {
        this.relativePut(h);
        this.relativeGet(h);
        this.bulkPut(h);
        this.bulkGet(h);
        this.bufferPut(h);
        this.absolutePut(h);
        this.absoluteGet(h);
        this.specialValues(h);
    }

    private void relativePut(TestHarness h) {
        ByteBuffer buf = null;
        byte[] arr = new byte[200];
        buf = ByteBuffer.wrap(arr);
        buf.order(ByteOrder.BIG_ENDIAN).put((byte)1);
        buf.order(ByteOrder.LITTLE_ENDIAN).put((byte)2);
        buf.order(ByteOrder.BIG_ENDIAN).putShort((short)3);
        buf.order(ByteOrder.LITTLE_ENDIAN).putShort((short)4);
        buf.order(ByteOrder.BIG_ENDIAN).putInt(5);
        buf.order(ByteOrder.LITTLE_ENDIAN).putInt(6);
        buf.order(ByteOrder.BIG_ENDIAN).putLong(7L);
        buf.order(ByteOrder.LITTLE_ENDIAN).putLong(8L);
        buf.order(ByteOrder.BIG_ENDIAN).putFloat(9.0f);
        buf.order(ByteOrder.LITTLE_ENDIAN).putFloat(10.0f);
        buf.order(ByteOrder.BIG_ENDIAN).putDouble(11.0);
        buf.order(ByteOrder.LITTLE_ENDIAN).putDouble(12.0);
        buf.order(ByteOrder.BIG_ENDIAN).putChar('a');
        buf.order(ByteOrder.LITTLE_ENDIAN).putChar('b');
        buf.order(ByteOrder.BIG_ENDIAN).put((byte)-15);
        buf.order(ByteOrder.LITTLE_ENDIAN).put((byte)-14);
        buf.order(ByteOrder.BIG_ENDIAN).putShort((short)-13);
        buf.order(ByteOrder.LITTLE_ENDIAN).putShort((short)-12);
        buf.order(ByteOrder.BIG_ENDIAN).putInt(-11);
        buf.order(ByteOrder.LITTLE_ENDIAN).putInt(-10);
        buf.order(ByteOrder.BIG_ENDIAN).putLong(-9L);
        buf.order(ByteOrder.LITTLE_ENDIAN).putLong(-8L);
        buf.order(ByteOrder.BIG_ENDIAN).putFloat(Float.NEGATIVE_INFINITY);
        buf.order(ByteOrder.LITTLE_ENDIAN).putFloat(Float.NEGATIVE_INFINITY);
        buf.order(ByteOrder.BIG_ENDIAN).putDouble(Double.NEGATIVE_INFINITY);
        buf.order(ByteOrder.LITTLE_ENDIAN).putDouble(Double.NEGATIVE_INFINITY);
        buf.order(ByteOrder.BIG_ENDIAN).putChar('\ufffd');
        buf.order(ByteOrder.LITTLE_ENDIAN).putChar('\ufffe');
        h.checkPoint("relative put");
        this.checkArray(h, TEST_ARRAY, arr);
    }

    private void relativeGet(TestHarness h) {
        ByteBuffer buf = null;
        byte[] arr = new byte[200];
        for (int i = 0; i < TEST_ARRAY.length; ++i) {
            arr[i] = TEST_ARRAY[i];
        }
        buf = ByteBuffer.wrap(arr);
        h.checkPoint("relative get");
        h.check(buf.order(ByteOrder.BIG_ENDIAN).get(), 1);
        h.check(buf.order(ByteOrder.LITTLE_ENDIAN).get(), 2);
        h.check(buf.order(ByteOrder.BIG_ENDIAN).getShort(), 3);
        h.check(buf.order(ByteOrder.LITTLE_ENDIAN).getShort(), 4);
        h.check(buf.order(ByteOrder.BIG_ENDIAN).getInt(), 5);
        h.check(buf.order(ByteOrder.LITTLE_ENDIAN).getInt(), 6);
        h.check(buf.order(ByteOrder.BIG_ENDIAN).getLong(), 7L);
        h.check(buf.order(ByteOrder.LITTLE_ENDIAN).getLong(), 8L);
        h.check(Float.floatToIntBits(buf.order(ByteOrder.BIG_ENDIAN).getFloat()), Float.floatToIntBits(9.0f));
        h.check(Float.floatToIntBits(buf.order(ByteOrder.LITTLE_ENDIAN).getFloat()), Float.floatToIntBits(10.0f));
        h.check(Double.doubleToLongBits(buf.order(ByteOrder.BIG_ENDIAN).getDouble()), Double.doubleToLongBits(11.0));
        h.check(Double.doubleToLongBits(buf.order(ByteOrder.LITTLE_ENDIAN).getDouble()), Double.doubleToLongBits(12.0));
        h.check(buf.order(ByteOrder.BIG_ENDIAN).getChar(), 97);
        h.check(buf.order(ByteOrder.LITTLE_ENDIAN).getChar(), 98);
        h.check(buf.order(ByteOrder.BIG_ENDIAN).get(), -15);
        h.check(buf.order(ByteOrder.LITTLE_ENDIAN).get(), -14);
        h.check(buf.order(ByteOrder.BIG_ENDIAN).getShort(), -13);
        h.check(buf.order(ByteOrder.LITTLE_ENDIAN).getShort(), -12);
        h.check(buf.order(ByteOrder.BIG_ENDIAN).getInt(), -11);
        h.check(buf.order(ByteOrder.LITTLE_ENDIAN).getInt(), -10);
        h.check(buf.order(ByteOrder.BIG_ENDIAN).getLong(), -9L);
        h.check(buf.order(ByteOrder.LITTLE_ENDIAN).getLong(), -8L);
        h.check(Float.floatToIntBits(buf.order(ByteOrder.BIG_ENDIAN).getFloat()), Float.floatToIntBits(Float.NEGATIVE_INFINITY));
        h.check(Float.floatToIntBits(buf.order(ByteOrder.LITTLE_ENDIAN).getFloat()), Float.floatToIntBits(Float.NEGATIVE_INFINITY));
        h.check(Double.doubleToLongBits(buf.order(ByteOrder.BIG_ENDIAN).getDouble()), Double.doubleToLongBits(Double.NEGATIVE_INFINITY));
        h.check(Double.doubleToLongBits(buf.order(ByteOrder.LITTLE_ENDIAN).getDouble()), Double.doubleToLongBits(Double.NEGATIVE_INFINITY));
        h.check(buf.order(ByteOrder.BIG_ENDIAN).getChar(), 65533);
        h.check(buf.order(ByteOrder.LITTLE_ENDIAN).getChar(), 65534);
    }

    private void bulkPut(TestHarness h) {
        ByteBuffer buf = null;
        byte[] arr = new byte[6];
        buf = ByteBuffer.wrap(arr);
        buf.order(ByteOrder.BIG_ENDIAN);
        buf.put(new byte[]{1, 2, 0, 0, 5, 6});
        buf.position(2);
        buf.order(ByteOrder.LITTLE_ENDIAN);
        buf.put(new byte[]{0, 0, 3, 4, 0, 0}, 2, 2);
        h.checkPoint("bulk put");
        this.checkArray(h, arr, new byte[]{1, 2, 3, 4, 5, 6});
    }

    private void bulkGet(TestHarness h) {
        ByteBuffer buf = null;
        byte[] arr = new byte[]{1, 2, 0, 0, 5, 6, 3, 4};
        buf = ByteBuffer.wrap(arr);
        byte[] readArr = new byte[6];
        buf.order(ByteOrder.BIG_ENDIAN);
        buf.get(readArr);
        buf.position(6);
        buf.order(ByteOrder.LITTLE_ENDIAN);
        buf.get(readArr, 2, 2);
        h.checkPoint("bulk get");
        this.checkArray(h, readArr, new byte[]{1, 2, 3, 4, 5, 6});
    }

    private void bufferPut(TestHarness h) {
        ByteBuffer buf = null;
        byte[] arr = new byte[6];
        buf = ByteBuffer.wrap(arr);
        buf.order(ByteOrder.BIG_ENDIAN);
        buf.put(ByteBuffer.wrap(new byte[]{1, 2, 0, 0, 5, 6}));
        buf.position(2);
        buf.order(ByteOrder.LITTLE_ENDIAN);
        buf.put(ByteBuffer.wrap(new byte[]{3, 4}));
        h.checkPoint("buffer put");
        this.checkArray(h, arr, new byte[]{1, 2, 3, 4, 5, 6});
    }

    private void absolutePut(TestHarness h) {
        ByteBuffer buf = null;
        byte[] arr = new byte[200];
        buf = ByteBuffer.wrap(arr);
        buf.order(ByteOrder.BIG_ENDIAN);
        buf.putChar(54, 'a');
        buf.putDouble(38, 11.0);
        buf.putFloat(30, 9.0f);
        buf.putLong(14, 7L);
        buf.putInt(6, 5);
        buf.putShort(2, (short)3);
        buf.put(0, (byte)1);
        buf.putChar(112, '\ufffd');
        buf.putDouble(96, Double.NEGATIVE_INFINITY);
        buf.putFloat(88, Float.NEGATIVE_INFINITY);
        buf.putLong(72, -9L);
        buf.putInt(64, -11);
        buf.putShort(60, (short)-13);
        buf.put(58, (byte)-15);
        buf.order(ByteOrder.LITTLE_ENDIAN);
        buf.put(1, (byte)2);
        buf.putShort(4, (short)4);
        buf.putInt(10, 6);
        buf.putLong(22, 8L);
        buf.putFloat(34, 10.0f);
        buf.putDouble(46, 12.0);
        buf.putChar(56, 'b');
        buf.putLong(80, -8L);
        buf.putInt(68, -10);
        buf.putShort(62, (short)-12);
        buf.put(59, (byte)-14);
        buf.putFloat(92, Float.NEGATIVE_INFINITY);
        buf.putDouble(104, Double.NEGATIVE_INFINITY);
        buf.putChar(114, '\ufffe');
        h.checkPoint("absolute put");
        this.checkArray(h, TEST_ARRAY, arr);
    }

    private void absoluteGet(TestHarness h) {
        ByteBuffer buf = null;
        byte[] arr = new byte[200];
        for (int i = 0; i < TEST_ARRAY.length; ++i) {
            arr[i] = TEST_ARRAY[i];
        }
        buf = ByteBuffer.wrap(arr);
        h.checkPoint("absolute get");
        buf.order(ByteOrder.BIG_ENDIAN);
        h.check(buf.getChar(54), 97);
        h.check(Double.doubleToLongBits(buf.getDouble(38)), Double.doubleToLongBits(11.0));
        h.check(Float.floatToIntBits(buf.getFloat(30)), Float.floatToIntBits(9.0f));
        h.check(buf.getLong(14), 7L);
        h.check(buf.getInt(6), 5);
        h.check(buf.getShort(2), 3);
        h.check(buf.get(0), 1);
        h.check(buf.getChar(112), 65533);
        h.check(Double.doubleToLongBits(buf.getDouble(96)), Double.doubleToLongBits(Double.NEGATIVE_INFINITY));
        h.check(Float.floatToIntBits(buf.getFloat(88)), Float.floatToIntBits(Float.NEGATIVE_INFINITY));
        h.check(buf.getLong(72), -9L);
        h.check(buf.getInt(64), -11);
        h.check(buf.getShort(60), -13);
        h.check(buf.get(58), -15);
        buf.order(ByteOrder.LITTLE_ENDIAN);
        h.check(buf.get(1), 2);
        h.check(buf.getShort(4), 4);
        h.check(buf.getInt(10), 6);
        h.check(buf.getLong(22), 8L);
        h.check(Float.floatToIntBits(buf.getFloat(34)), Float.floatToIntBits(10.0f));
        h.check(Double.doubleToLongBits(buf.getDouble(46)), Double.doubleToLongBits(12.0));
        h.check(buf.getChar(56), 98);
        h.check(buf.get(59), -14);
        h.check(buf.getShort(62), -12);
        h.check(buf.getInt(68), -10);
        h.check(buf.getLong(80), -8L);
        h.check(Float.floatToIntBits(buf.getFloat(92)), Float.floatToIntBits(Float.NEGATIVE_INFINITY));
        h.check(Double.doubleToLongBits(buf.getDouble(104)), Double.doubleToLongBits(Double.NEGATIVE_INFINITY));
        h.check(buf.getChar(114), 65534);
    }

    private void specialValues(TestHarness h) {
        ByteBuffer buf = null;
        byte[] arr = new byte[200];
        buf = ByteBuffer.wrap(arr);
        h.checkPoint("special values");
        buf.order(ByteOrder.BIG_ENDIAN);
        buf.put((byte)-128);
        buf.put((byte)127);
        buf.putShort((short)Short.MIN_VALUE);
        buf.putShort((short)Short.MAX_VALUE);
        buf.putInt(Integer.MIN_VALUE);
        buf.putInt(Integer.MAX_VALUE);
        buf.putLong(Long.MIN_VALUE);
        buf.putLong(Long.MAX_VALUE);
        buf.putFloat(Float.MIN_VALUE);
        buf.putFloat(Float.MAX_VALUE);
        buf.putFloat(Float.NaN);
        buf.putFloat(Float.NEGATIVE_INFINITY);
        buf.putFloat(Float.POSITIVE_INFINITY);
        buf.putDouble(Double.MIN_VALUE);
        buf.putDouble(Double.MAX_VALUE);
        buf.putDouble(Double.NaN);
        buf.putDouble(Double.NEGATIVE_INFINITY);
        buf.putDouble(Double.POSITIVE_INFINITY);
        buf.order(ByteOrder.LITTLE_ENDIAN);
        buf.put((byte)-128);
        buf.put((byte)127);
        buf.putShort((short)Short.MIN_VALUE);
        buf.putShort((short)Short.MAX_VALUE);
        buf.putInt(Integer.MIN_VALUE);
        buf.putInt(Integer.MAX_VALUE);
        buf.putLong(Long.MIN_VALUE);
        buf.putLong(Long.MAX_VALUE);
        buf.putFloat(Float.MIN_VALUE);
        buf.putFloat(Float.MAX_VALUE);
        buf.putFloat(Float.NaN);
        buf.putFloat(Float.NEGATIVE_INFINITY);
        buf.putFloat(Float.POSITIVE_INFINITY);
        buf.putDouble(Double.MIN_VALUE);
        buf.putDouble(Double.MAX_VALUE);
        buf.putDouble(Double.NaN);
        buf.putDouble(Double.NEGATIVE_INFINITY);
        buf.putDouble(Double.POSITIVE_INFINITY);
        buf.rewind();
        buf.order(ByteOrder.BIG_ENDIAN);
        h.check(buf.get(), -128);
        h.check(buf.get(), 127);
        h.check(buf.getShort(), Short.MIN_VALUE);
        h.check(buf.getShort(), Short.MAX_VALUE);
        h.check(buf.getInt(), Integer.MIN_VALUE);
        h.check(buf.getInt(), Integer.MAX_VALUE);
        h.check(buf.getLong(), Long.MIN_VALUE);
        h.check(buf.getLong(), Long.MAX_VALUE);
        h.check(buf.getFloat(), 1.4E-45f);
        h.check(buf.getFloat(), 3.4028234663852886E38);
        h.check(buf.getFloat(), Double.NaN);
        h.check(buf.getFloat(), Double.NEGATIVE_INFINITY);
        h.check(buf.getFloat(), Double.POSITIVE_INFINITY);
        h.check(buf.getDouble(), Double.MIN_VALUE);
        h.check(buf.getDouble(), Double.MAX_VALUE);
        h.check(buf.getDouble(), Double.NaN);
        h.check(buf.getDouble(), Double.NEGATIVE_INFINITY);
        h.check(buf.getDouble(), Double.POSITIVE_INFINITY);
        buf.order(ByteOrder.LITTLE_ENDIAN);
        h.check(buf.get(), -128);
        h.check(buf.get(), 127);
        h.check(buf.getShort(), Short.MIN_VALUE);
        h.check(buf.getShort(), Short.MAX_VALUE);
        h.check(buf.getInt(), Integer.MIN_VALUE);
        h.check(buf.getInt(), Integer.MAX_VALUE);
        h.check(buf.getLong(), Long.MIN_VALUE);
        h.check(buf.getLong(), Long.MAX_VALUE);
        h.check(buf.getFloat(), 1.4E-45f);
        h.check(buf.getFloat(), 3.4028234663852886E38);
        h.check(buf.getFloat(), Double.NaN);
        h.check(buf.getFloat(), Double.NEGATIVE_INFINITY);
        h.check(buf.getFloat(), Double.POSITIVE_INFINITY);
        h.check(buf.getDouble(), Double.MIN_VALUE);
        h.check(buf.getDouble(), Double.MAX_VALUE);
        h.check(buf.getDouble(), Double.NaN);
        h.check(buf.getDouble(), Double.NEGATIVE_INFINITY);
        h.check(buf.getDouble(), Double.POSITIVE_INFINITY);
    }

    private void checkArray(TestHarness h, byte[] arr0, byte[] arr1) {
        for (int i = 0; i < arr0.length; ++i) {
            h.check(arr0[i], arr1[i]);
        }
    }

    static {
        GetPut.TEST_ARRAY[0] = 1;
        GetPut.TEST_ARRAY[1] = 2;
        GetPut.TEST_ARRAY[2] = 0;
        GetPut.TEST_ARRAY[3] = 3;
        GetPut.TEST_ARRAY[4] = 4;
        GetPut.TEST_ARRAY[5] = 0;
        GetPut.TEST_ARRAY[6] = 0;
        GetPut.TEST_ARRAY[7] = 0;
        GetPut.TEST_ARRAY[8] = 0;
        GetPut.TEST_ARRAY[9] = 5;
        GetPut.TEST_ARRAY[10] = 6;
        GetPut.TEST_ARRAY[11] = 0;
        GetPut.TEST_ARRAY[12] = 0;
        GetPut.TEST_ARRAY[13] = 0;
        GetPut.TEST_ARRAY[14] = 0;
        GetPut.TEST_ARRAY[15] = 0;
        GetPut.TEST_ARRAY[16] = 0;
        GetPut.TEST_ARRAY[17] = 0;
        GetPut.TEST_ARRAY[18] = 0;
        GetPut.TEST_ARRAY[19] = 0;
        GetPut.TEST_ARRAY[20] = 0;
        GetPut.TEST_ARRAY[21] = 7;
        GetPut.TEST_ARRAY[22] = 8;
        GetPut.TEST_ARRAY[23] = 0;
        GetPut.TEST_ARRAY[24] = 0;
        GetPut.TEST_ARRAY[25] = 0;
        GetPut.TEST_ARRAY[26] = 0;
        GetPut.TEST_ARRAY[27] = 0;
        GetPut.TEST_ARRAY[28] = 0;
        GetPut.TEST_ARRAY[29] = 0;
        int f9 = Float.floatToIntBits(9.0f);
        GetPut.TEST_ARRAY[30] = (byte)(f9 >> 24 & 0xFF);
        GetPut.TEST_ARRAY[31] = (byte)(f9 >> 16 & 0xFF);
        GetPut.TEST_ARRAY[32] = (byte)(f9 >> 8 & 0xFF);
        GetPut.TEST_ARRAY[33] = (byte)(f9 & 0xFF);
        int f10 = Float.floatToIntBits(10.0f);
        GetPut.TEST_ARRAY[34] = (byte)(f10 & 0xFF);
        GetPut.TEST_ARRAY[35] = (byte)(f10 >> 8 & 0xFF);
        GetPut.TEST_ARRAY[36] = (byte)(f10 >> 16 & 0xFF);
        GetPut.TEST_ARRAY[37] = (byte)(f10 >> 24 & 0xFF);
        long d11 = Double.doubleToLongBits(11.0);
        GetPut.TEST_ARRAY[38] = (byte)(d11 >> 56 & 0xFFL);
        GetPut.TEST_ARRAY[39] = (byte)(d11 >> 48 & 0xFFL);
        GetPut.TEST_ARRAY[40] = (byte)(d11 >> 40 & 0xFFL);
        GetPut.TEST_ARRAY[41] = (byte)(d11 >> 32 & 0xFFL);
        GetPut.TEST_ARRAY[42] = (byte)(d11 >> 24 & 0xFFL);
        GetPut.TEST_ARRAY[43] = (byte)(d11 >> 16 & 0xFFL);
        GetPut.TEST_ARRAY[44] = (byte)(d11 >> 8 & 0xFFL);
        GetPut.TEST_ARRAY[45] = (byte)(d11 & 0xFFL);
        long d12 = Double.doubleToLongBits(12.0);
        GetPut.TEST_ARRAY[46] = (byte)(d12 & 0xFFL);
        GetPut.TEST_ARRAY[47] = (byte)(d12 >> 8 & 0xFFL);
        GetPut.TEST_ARRAY[48] = (byte)(d12 >> 16 & 0xFFL);
        GetPut.TEST_ARRAY[49] = (byte)(d12 >> 24 & 0xFFL);
        GetPut.TEST_ARRAY[50] = (byte)(d12 >> 32 & 0xFFL);
        GetPut.TEST_ARRAY[51] = (byte)(d12 >> 40 & 0xFFL);
        GetPut.TEST_ARRAY[52] = (byte)(d12 >> 48 & 0xFFL);
        GetPut.TEST_ARRAY[53] = (byte)(d12 >> 56 & 0xFFL);
        GetPut.TEST_ARRAY[54] = 0;
        GetPut.TEST_ARRAY[55] = 97;
        GetPut.TEST_ARRAY[56] = 98;
        GetPut.TEST_ARRAY[57] = 0;
        GetPut.TEST_ARRAY[58] = -15;
        GetPut.TEST_ARRAY[59] = -14;
        GetPut.TEST_ARRAY[60] = -1;
        GetPut.TEST_ARRAY[61] = -13;
        GetPut.TEST_ARRAY[62] = -12;
        GetPut.TEST_ARRAY[63] = -1;
        GetPut.TEST_ARRAY[64] = -1;
        GetPut.TEST_ARRAY[65] = -1;
        GetPut.TEST_ARRAY[66] = -1;
        GetPut.TEST_ARRAY[67] = -11;
        GetPut.TEST_ARRAY[68] = -10;
        GetPut.TEST_ARRAY[69] = -1;
        GetPut.TEST_ARRAY[70] = -1;
        GetPut.TEST_ARRAY[71] = -1;
        GetPut.TEST_ARRAY[72] = -1;
        GetPut.TEST_ARRAY[73] = -1;
        GetPut.TEST_ARRAY[74] = -1;
        GetPut.TEST_ARRAY[75] = -1;
        GetPut.TEST_ARRAY[76] = -1;
        GetPut.TEST_ARRAY[77] = -1;
        GetPut.TEST_ARRAY[78] = -1;
        GetPut.TEST_ARRAY[79] = -9;
        GetPut.TEST_ARRAY[80] = -8;
        GetPut.TEST_ARRAY[81] = -1;
        GetPut.TEST_ARRAY[82] = -1;
        GetPut.TEST_ARRAY[83] = -1;
        GetPut.TEST_ARRAY[84] = -1;
        GetPut.TEST_ARRAY[85] = -1;
        GetPut.TEST_ARRAY[86] = -1;
        GetPut.TEST_ARRAY[87] = -1;
        int fNI = Float.floatToIntBits(Float.NEGATIVE_INFINITY);
        GetPut.TEST_ARRAY[88] = (byte)(fNI >> 24 & 0xFF);
        GetPut.TEST_ARRAY[89] = (byte)(fNI >> 16 & 0x80);
        GetPut.TEST_ARRAY[90] = (byte)(fNI >> 8 & 0);
        GetPut.TEST_ARRAY[91] = (byte)(fNI & 0);
        GetPut.TEST_ARRAY[92] = (byte)(fNI & 0);
        GetPut.TEST_ARRAY[93] = (byte)(fNI >> 8 & 0);
        GetPut.TEST_ARRAY[94] = (byte)(fNI >> 16 & 0x80);
        GetPut.TEST_ARRAY[95] = (byte)(fNI >> 24 & 0xFF);
        long dNI = Double.doubleToLongBits(Double.NEGATIVE_INFINITY);
        GetPut.TEST_ARRAY[96] = (byte)(dNI >> 56 & 0xFFL);
        GetPut.TEST_ARRAY[97] = (byte)(dNI >> 48 & 0xF0L);
        GetPut.TEST_ARRAY[98] = (byte)(dNI >> 40 & 0L);
        GetPut.TEST_ARRAY[99] = (byte)(dNI >> 32 & 0L);
        GetPut.TEST_ARRAY[100] = (byte)(dNI >> 24 & 0L);
        GetPut.TEST_ARRAY[101] = (byte)(dNI >> 16 & 0L);
        GetPut.TEST_ARRAY[102] = (byte)(dNI >> 8 & 0L);
        GetPut.TEST_ARRAY[103] = (byte)(dNI & 0L);
        GetPut.TEST_ARRAY[104] = (byte)(dNI & 0L);
        GetPut.TEST_ARRAY[105] = (byte)(dNI >> 8 & 0L);
        GetPut.TEST_ARRAY[106] = (byte)(dNI >> 16 & 0L);
        GetPut.TEST_ARRAY[107] = (byte)(dNI >> 24 & 0L);
        GetPut.TEST_ARRAY[108] = (byte)(dNI >> 32 & 0L);
        GetPut.TEST_ARRAY[109] = (byte)(dNI >> 40 & 0L);
        GetPut.TEST_ARRAY[110] = (byte)(dNI >> 48 & 0xF0L);
        GetPut.TEST_ARRAY[111] = (byte)(dNI >> 56 & 0xFFL);
        GetPut.TEST_ARRAY[112] = -1;
        GetPut.TEST_ARRAY[113] = -3;
        GetPut.TEST_ARRAY[114] = -2;
        GetPut.TEST_ARRAY[115] = -1;
    }
}

