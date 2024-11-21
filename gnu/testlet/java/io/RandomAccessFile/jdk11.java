/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.io.RandomAccessFile;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.io.EOFException;
import java.io.File;
import java.io.FileDescriptor;
import java.io.IOException;
import java.io.RandomAccessFile;

public class jdk11
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        RandomAccessFile raf;
        String fname = "raftmpfile";
        byte[] buf = new byte[]{0, 0, 0, 0};
        File f = new File(fname);
        if (f.exists()) {
            f.delete();
        }
        try {
            raf = new RandomAccessFile(fname, "rw");
        }
        catch (IOException e) {
            harness.fail("new RandomAccessFile(Filename, mode): Can't open file " + fname);
            return;
        }
        try {
            FileDescriptor e = raf.getFD();
        }
        catch (IOException e) {
            harness.fail("getFD(): Can't get FileDescriptor");
            return;
        }
        String teststr = "foobar";
        int testlength = teststr.length();
        byte[] testbytes = new byte[testlength];
        for (int i = 0; i < teststr.length(); ++i) {
            testbytes[i] = (byte)teststr.charAt(i);
        }
        try {
            raf.write(testbytes);
            harness.check((long)testlength, raf.length(), "write(b[])/length()");
            harness.debug("File size = " + raf.length() + "; should = " + testlength);
            raf.seek(0L);
            int skipped = 0;
            for (int i = 0; i < testbytes.length + 1; ++i) {
                int offset2 = raf.skipBytes(1);
                harness.debug("skipped " + offset2 + " bytes");
                skipped += offset2;
            }
            harness.check(skipped, testlength, "skipBytes() did not skip past EOF");
            raf.seek(0L);
            char ch1 = (char)raf.read();
            char ch2 = teststr.charAt(0);
            harness.check(ch1, ch2, "read()");
            harness.debug("Read " + ch1 + "; should be " + ch2);
            harness.check(raf.getFilePointer(), 1L, "getFilePointer()");
            raf.seek(0L);
            int rdcnt = raf.read(buf, 0, 3);
            harness.check(rdcnt, 3, "read(b[], off, len):Reading correct number of bytes");
            harness.debug("Read " + rdcnt + " bytes; should have been 3.");
            String str = new String(buf);
            harness.check(str.substring(0, 3).equals(teststr.substring(0, 3)), "read(b[], off, len):Reading at correct offset");
            harness.debug("array read: read " + str + "; expected " + teststr.substring(0, 3));
            raf.seek(0L);
            rdcnt = raf.read(buf);
            harness.check(rdcnt, buf.length, "read(b[])");
            harness.debug("buffer fill: read " + str + "; expected " + teststr.substring(0, 3));
            int buf2ln = teststr.length() + 5;
            byte[] buf2 = new byte[buf2ln];
            for (int i = 0; i < buf2ln; ++i) {
                buf2[i] = 0;
            }
            raf.seek(0L);
            try {
                raf.readFully(buf2);
            }
            catch (EOFException eofe) {
                harness.check(buf2[testlength - 1], teststr.charAt(teststr.length() - 1), "readFully(b[]):Enough bytes read");
                harness.check(buf2[testlength], 0, "readFully(b[]):Too many bytes");
            }
            for (int i = 0; i < buf2ln; ++i) {
                buf2[i] = 0;
            }
            raf.seek(0L);
            try {
                raf.readFully(buf2, 0, testlength + 2);
            }
            catch (EOFException eofe) {
                harness.check(buf2[testlength - 1], teststr.charAt(teststr.length() - 1), "readFully(b[],off,len):Enough bytes read");
                harness.check(buf2[testlength], 0, "readFully(b[],off,len):Too many bytes");
            }
            raf.seek(0L);
            raf.write(testbytes, 2, 3);
            raf.seek(0L);
            raf.read(buf2, 0, 3);
            String t1 = new String(testbytes, 2, 3);
            String b1 = new String(buf2, 0, 3);
            harness.check(t1, b1, "write(b[], off, len");
            harness.debug("write(b[], off, len):Wrote " + t1 + ", read " + b1);
            raf.seek(0L);
            raf.write(12);
            raf.seek(0L);
            harness.check(raf.readByte(), 12, "write(byte)/readByte(), positive");
            raf.seek(0L);
            raf.writeByte(-12);
            raf.seek(0L);
            harness.check(raf.readByte(), -12, "writeByte(byte)/readByte(), negative");
            raf.seek(0L);
            raf.writeBoolean(true);
            raf.writeBoolean(false);
            raf.seek(0L);
            harness.check(raf.readBoolean(), "writeBoolean(T)/readBoolean()");
            harness.check(!raf.readBoolean(), "writeBoolean(F)/readBoolean()");
            raf.seek(0L);
            raf.writeShort(527);
            raf.seek(0L);
            harness.check(raf.readShort(), 527, "writeShort(n)/readShort()");
            raf.seek(0L);
            raf.writeUTF(teststr);
            raf.seek(0L);
            harness.check(raf.readShort(), testlength, "writeUTF(s): length encoding");
            raf.seek(0L);
            harness.check(raf.readUTF(), teststr, "writeUTF(s)/readUTF: string recovery");
            raf.seek(0L);
            raf.writeBytes("foobar\n");
            raf.seek(0L);
            harness.check(raf.readLine(), "foobar", "writeBytes(s)/readLine()");
            raf.seek(0L);
            raf.writeChar(102);
            raf.writeChars("oobar");
            raf.seek(0L);
            String s = "";
            for (int i = 0; i < 6; ++i) {
                s = s + raf.readChar();
            }
            harness.check(s, "foobar", "writeChar/writeChars/readChar()");
            raf.seek(0L);
            raf.writeLong(123456L);
            raf.seek(0L);
            harness.check(raf.readLong(), 123456L, "writeLong(l)/readLong()");
            raf.seek(0L);
            raf.writeFloat(123.45f);
            raf.seek(0L);
            harness.check((double)raf.readFloat(), (double)123.45f, "writeFloat(l)/readFloat()");
            raf.seek(0L);
            raf.writeDouble(123.45);
            raf.seek(0L);
            harness.check(raf.readDouble(), 123.45, "writeDouble(l)/readDouble()");
            raf.seek(0L);
            raf.writeInt(12345);
            raf.seek(0L);
            harness.check(raf.readInt(), 12345, "writeInt(l)/readInt()");
            raf.seek(2L);
            harness.check(raf.readUnsignedByte(), 48, "readUnsignedByte()");
            raf.seek(2L);
            harness.check(raf.readUnsignedShort(), 12345, "readUnsignedShort()");
        }
        catch (IOException e) {
            harness.debug(e);
            harness.fail("IOException after opening file");
        }
        try {
            raf.close();
        }
        catch (IOException e) {
            harness.check(false, "close()");
        }
    }
}

