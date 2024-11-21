/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.sql.Blob;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.Blob;
import java.sql.SQLException;

public class BlobTest
implements Blob,
Testlet {
    @Override
    public void test(TestHarness harness) {
        harness.check(true, "java.sql.Blob");
    }

    @Override
    public void free() throws SQLException {
    }

    @Override
    public InputStream getBinaryStream(long a, long b) throws SQLException {
        return null;
    }

    @Override
    public long length() throws SQLException {
        return 0L;
    }

    @Override
    public byte[] getBytes(long offset2, int length2) throws SQLException {
        return null;
    }

    @Override
    public InputStream getBinaryStream() throws SQLException {
        return null;
    }

    @Override
    public long position(byte[] pattern, long offset2) throws SQLException {
        return 0L;
    }

    @Override
    public long position(Blob pattern, long offset2) throws SQLException {
        return 0L;
    }

    @Override
    public int setBytes(long l, byte[] bs) {
        return 0;
    }

    @Override
    public int setBytes(long l, byte[] bs, int i1, int i2) {
        return 0;
    }

    @Override
    public void truncate(long l) {
    }

    @Override
    public OutputStream setBinaryStream(long l) {
        return null;
    }
}

