/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.nio.ByteBuffer;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import gnu.testlet.java.nio.ByteBuffer.ByteBufferFactory;
import java.nio.BufferOverflowException;
import java.nio.BufferUnderflowException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.InvalidMarkException;

public class Allocating
implements Testlet {
    @Override
    public void test(TestHarness h) {
        h.checkPoint("allocate(int)");
        h.check(true);
        ByteBufferFactory allocateFactory = new ByteBufferFactory(){

            @Override
            public ByteBuffer newInstance() {
                return ByteBuffer.allocate(10);
            }
        };
        ByteBuffer bufAll = ByteBuffer.allocate(10);
        h.check(bufAll.isDirect(), false, "isDirect()");
        h.check(bufAll.hasArray(), "hasArray()");
        h.check(bufAll.arrayOffset(), 0, "arrayOffset()");
        h.check(bufAll.array() != null, "array()");
        this.overflow(h, allocateFactory, 10);
        this.underflow(h, allocateFactory, 10);
        this.compact(h, allocateFactory, 10);
        h.checkPoint("allocateDirect(int)");
        h.check(true);
        ByteBufferFactory allocateDirectFactory = new ByteBufferFactory(){

            @Override
            public ByteBuffer newInstance() {
                return ByteBuffer.allocateDirect(10);
            }
        };
        ByteBuffer bufAllDir = ByteBuffer.allocateDirect(10);
        h.check(bufAllDir.isDirect(), true, "isDirect()");
        if (bufAllDir.hasArray()) {
            h.check(bufAllDir.arrayOffset(), 0, "arrayOffset()");
            h.check(bufAllDir.array() != null, "array()");
        }
        this.overflow(h, allocateDirectFactory, 10);
        this.underflow(h, allocateDirectFactory, 10);
        this.compact(h, allocateDirectFactory, 10);
        h.checkPoint("wrap(byte[])");
        h.check(true);
        ByteBufferFactory wrapFactory = new ByteBufferFactory(){

            @Override
            public ByteBuffer newInstance() {
                return ByteBuffer.wrap(new byte[10]);
            }
        };
        byte[] arrWrap = new byte[10];
        ByteBuffer bufWrap = ByteBuffer.wrap(arrWrap);
        h.check(bufWrap.isDirect(), false, "isDirect()");
        h.check(bufWrap.hasArray(), true, "hasArray()");
        h.check(bufWrap.arrayOffset(), 0, "arrayOffset()");
        h.check(bufWrap.array(), arrWrap, "array()");
        this.overflow(h, wrapFactory, 10);
        this.underflow(h, wrapFactory, 10);
        this.compact(h, wrapFactory, 10);
        h.checkPoint("wrap(byte[], int, int)");
        h.check(true);
        ByteBufferFactory wrapWithOffsetFactory = new ByteBufferFactory(){

            @Override
            public ByteBuffer newInstance() {
                return ByteBuffer.wrap(new byte[20], 5, 10);
            }
        };
        byte[] arrWrapOff = new byte[10];
        ByteBuffer bufWrapOff = ByteBuffer.wrap(arrWrapOff, 1, 1);
        h.check(bufWrapOff.isDirect(), false, "isDirect()");
        h.check(bufWrapOff.hasArray(), true, "hasArray()");
        h.check(bufWrapOff.arrayOffset(), 0, "arrayOffset()");
        h.check(bufWrapOff.array(), arrWrapOff, "array()");
        this.overflow(h, wrapWithOffsetFactory, 15);
        this.underflow(h, wrapWithOffsetFactory, 15);
        this.compact(h, wrapWithOffsetFactory, 20);
        this.array(h);
        this.synchWrappedBufferWithArray(h);
    }

    private void overflow(TestHarness h, ByteBufferFactory factory, int limit) {
        ByteBuffer buf = null;
        buf = factory.newInstance();
        buf.position(limit - 1);
        buf.put((byte)1);
        try {
            buf.put((byte)1);
            h.check(false, "byte overflow");
        }
        catch (BufferOverflowException boe) {
            h.check(true, "byte overflow");
        }
        buf = factory.newInstance();
        buf.position(limit - 3);
        buf.putShort((short)257);
        try {
            buf.putShort((short)257);
            h.check(false, "short overflow");
        }
        catch (BufferOverflowException boe) {
            h.check(true, "short overflow");
        }
        buf = factory.newInstance();
        buf.position(limit - 6);
        buf.putInt(0x1010101);
        try {
            buf.putInt(0x1010101);
            h.check(false, "int overflow");
        }
        catch (BufferOverflowException boe) {
            h.check(true, "int overflow");
        }
        buf = factory.newInstance();
        buf.position(limit - 9);
        buf.putLong(0x101010101010101L);
        try {
            buf.putLong(0x101010101010101L);
            h.check(false, "long overflow");
        }
        catch (BufferOverflowException boe) {
            h.check(true, "long overflow");
        }
        buf = factory.newInstance();
        buf.position(limit - 6);
        buf.putFloat(1.0f);
        try {
            buf.putFloat(1.0f);
            h.check(false, "float overflow");
        }
        catch (BufferOverflowException boe) {
            h.check(true, "float overflow");
        }
        buf = factory.newInstance();
        buf.position(limit - 9);
        buf.putDouble(1.0);
        try {
            buf.putDouble(1.0);
            h.check(false, "double overflow");
        }
        catch (BufferOverflowException boe) {
            h.check(true, "double overflow");
        }
        buf = factory.newInstance();
        buf.position(limit - 3);
        buf.putChar('\u0101');
        try {
            buf.putChar('\u0101');
            h.check(false, "char overflow");
        }
        catch (BufferOverflowException boe) {
            h.check(true, "char overflow");
        }
    }

    private void underflow(TestHarness h, ByteBufferFactory factory, int limit) {
        ByteBuffer buf = null;
        buf = factory.newInstance();
        buf.position(limit - 1);
        buf.get();
        try {
            buf.get();
            h.check(false, "byte underflow");
        }
        catch (BufferUnderflowException boe) {
            h.check(true, "byte underflow");
        }
        buf = factory.newInstance();
        buf.position(limit - 3);
        buf.getShort();
        try {
            buf.getShort();
            h.check(false, "short underflow");
        }
        catch (BufferUnderflowException boe) {
            h.check(true, "short underflow");
        }
        buf = factory.newInstance();
        buf.position(limit - 6);
        buf.getInt();
        try {
            buf.getInt();
            h.check(false, "int underflow");
        }
        catch (BufferUnderflowException boe) {
            h.check(true, "int underflow");
        }
        buf = factory.newInstance();
        buf.position(limit - 9);
        buf.getLong();
        try {
            buf.getLong();
            h.check(false, "long underflow");
        }
        catch (BufferUnderflowException boe) {
            h.check(true, "long underflow");
        }
        buf = factory.newInstance();
        buf.position(limit - 6);
        buf.getFloat();
        try {
            buf.getFloat();
            h.check(false, "float underflow");
        }
        catch (BufferUnderflowException boe) {
            h.check(true, "float underflow");
        }
        buf = factory.newInstance();
        buf.position(limit - 9);
        buf.getDouble();
        try {
            buf.getDouble();
            h.check(false, "double underflow");
        }
        catch (BufferUnderflowException boe) {
            h.check(true, "double underflow");
        }
        buf = factory.newInstance();
        buf.position(limit - 3);
        buf.getChar();
        try {
            buf.getChar();
            h.check(false, "char underflow");
        }
        catch (BufferUnderflowException boe) {
            h.check(true, "char underflow");
        }
    }

    private void compact(TestHarness h, ByteBufferFactory factory, int size2) {
        h.checkPoint("compact()");
        ByteBuffer buf = null;
        buf = factory.newInstance();
        buf.rewind();
        for (int i = 0; i < 10; ++i) {
            buf.put((byte)(i + 1));
        }
        buf.limit(6);
        buf.position(1);
        buf.mark();
        buf.get();
        h.check(buf.compact(), buf, "compact() return value");
        h.check(buf.position(), 4, "compact()/position");
        h.check(buf.limit(), size2, "compact()/limit");
        try {
            buf.reset();
            h.check(false, "mark: mark not invalidated");
        }
        catch (InvalidMarkException ime) {
            h.check(true, "mark: invalidated mark");
        }
        h.checkPoint("compact()/contents");
        buf.rewind();
        h.check(buf.get(), 3);
        h.check(buf.get(), 4);
        h.check(buf.get(), 5);
        h.check(buf.get(), 6);
    }

    private void array(TestHarness h) {
        byte[] arr = null;
        ByteBuffer buf = null;
        h.checkPoint("array");
        arr = new byte[]{1, 2, 3};
        buf = ByteBuffer.wrap(arr);
        h.check(buf.array(), arr, "array");
    }

    private void synchWrappedBufferWithArray(TestHarness h) {
        int i;
        byte[] arr = null;
        ByteBuffer buf = null;
        h.checkPoint("synchWrappedBufferWithArray/wrap(byte[])");
        arr = new byte[10];
        buf = ByteBuffer.wrap(arr);
        for (i = 0; i < arr.length; ++i) {
            arr[i] = (byte)(i + 1);
        }
        buf.order(ByteOrder.BIG_ENDIAN);
        h.check(buf.getShort(), 258);
        buf.putShort((short)2828);
        buf.order(ByteOrder.LITTLE_ENDIAN);
        h.check(buf.getShort(), 1541);
        buf.putShort((short)3342);
        h.check(arr[2], 11);
        h.check(arr[3], 12);
        h.check(arr[6], 14);
        h.check(arr[7], 13);
        h.checkPoint("synchWrappedBufferWithArray/wrap(byte[], int, int)");
        arr = new byte[10];
        buf = ByteBuffer.wrap(arr, 2, 8);
        for (i = 0; i < arr.length; ++i) {
            arr[i] = (byte)(i + 1);
        }
        buf.order(ByteOrder.BIG_ENDIAN);
        h.check(buf.getShort(), 772);
        buf.putShort((short)2828);
        buf.order(ByteOrder.LITTLE_ENDIAN);
        h.check(buf.getShort(), 2055);
        buf.putShort((short)3342);
        h.check(arr[4], 11);
        h.check(arr[5], 12);
        h.check(arr[8], 14);
        h.check(arr[9], 13);
    }
}

