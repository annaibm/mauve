/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.awt.datatransfer.DataFlavor;

import java.awt.datatransfer.DataFlavor;
import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectOutput;
import java.util.ArrayList;
import junit.framework.Assert;
import junit.framework.TestCase;

public class writeExternal
extends TestCase {
    private TestObjectOutput output;
    private ArrayList writtenObjects;
    private ArrayList writtenStrings;

    @Override
    public void setUp() {
        this.writtenObjects = new ArrayList();
        this.writtenStrings = new ArrayList();
        this.output = new TestObjectOutput();
    }

    @Override
    public void tearDown() {
        this.writtenObjects = null;
        this.writtenStrings = null;
        this.output = null;
    }

    public void testWriteBasic() {
        DataFlavor f = new DataFlavor("application/text; param1=xyz", "Plain Text");
        try {
            f.writeExternal(this.output);
        }
        catch (IOException ex) {
            writeExternal.fail();
        }
        writeExternal.assertEquals(2, this.writtenObjects.size());
        writeExternal.assertEquals(0, this.writtenStrings.size());
        writeExternal.assertEquals("java.awt.datatransfer.MimeType", this.writtenObjects.get(0).getClass().getName());
        writeExternal.assertEquals("java.lang.Class", this.writtenObjects.get(1).getClass().getName());
        writeExternal.assertSame(f.getRepresentationClass(), this.writtenObjects.get(1));
        Object o = this.writtenObjects.get(0);
        this.writtenObjects.clear();
        writeExternal.assertTrue(o instanceof Externalizable);
        try {
            ((Externalizable)o).writeExternal(this.output);
        }
        catch (IOException ex) {
            writeExternal.fail();
        }
        writeExternal.assertEquals(0, this.writtenObjects.size());
        writeExternal.assertEquals(1, this.writtenStrings.size());
        writeExternal.assertEquals((Object)"application/text; class=java.io.InputStream; param1=xyz", this.writtenStrings.get(0));
    }

    private class TestObjectOutput
    implements ObjectOutput {
        private TestObjectOutput() {
        }

        @Override
        public void close() throws IOException {
            Assert.fail();
        }

        @Override
        public void flush() throws IOException {
            Assert.fail();
        }

        @Override
        public void write(int b) throws IOException {
            Assert.fail();
        }

        @Override
        public void write(byte[] buf) throws IOException {
            Assert.fail();
        }

        @Override
        public void write(byte[] buf, int offset2, int len) throws IOException {
            Assert.fail();
        }

        @Override
        public void writeObject(Object obj) throws IOException {
            writeExternal.this.writtenObjects.add(obj);
        }

        @Override
        public void writeBoolean(boolean value2) throws IOException {
            Assert.fail();
        }

        @Override
        public void writeByte(int value2) throws IOException {
            Assert.fail();
        }

        @Override
        public void writeBytes(String value2) throws IOException {
            Assert.fail();
        }

        @Override
        public void writeChar(int value2) throws IOException {
            Assert.fail();
        }

        @Override
        public void writeChars(String value2) throws IOException {
            Assert.fail();
        }

        @Override
        public void writeDouble(double value2) throws IOException {
            Assert.fail();
        }

        @Override
        public void writeFloat(float value2) throws IOException {
            Assert.fail();
        }

        @Override
        public void writeInt(int value2) throws IOException {
            Assert.fail();
        }

        @Override
        public void writeLong(long value2) throws IOException {
            Assert.fail();
        }

        @Override
        public void writeShort(int value2) throws IOException {
            Assert.fail();
        }

        @Override
        public void writeUTF(String value2) throws IOException {
            writeExternal.this.writtenStrings.add(value2);
        }
    }
}

