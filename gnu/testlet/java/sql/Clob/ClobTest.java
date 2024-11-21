/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.sql.Clob;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Reader;
import java.io.Writer;
import java.sql.Clob;
import java.sql.SQLException;

public class ClobTest
implements Clob,
Testlet {
    @Override
    public void test(TestHarness harness) {
        harness.check(true, "java.sql.Clob");
    }

    @Override
    public long length() throws SQLException {
        return 0L;
    }

    @Override
    public void free() throws SQLException {
    }

    @Override
    public Reader getCharacterStream(long a, long b) throws SQLException {
        return null;
    }

    @Override
    public String getSubString(long offset2, int length2) throws SQLException {
        return null;
    }

    @Override
    public InputStream getAsciiStream() throws SQLException {
        return null;
    }

    @Override
    public Reader getCharacterStream() throws SQLException {
        return null;
    }

    @Override
    public long position(String pattern, long offset2) throws SQLException {
        return 0L;
    }

    @Override
    public long position(Clob pattern, long offset2) throws SQLException {
        return 0L;
    }

    @Override
    public int setString(long l, String s) throws SQLException {
        return 0;
    }

    @Override
    public int setString(long l, String s, int i1, int i2) throws SQLException {
        return 0;
    }

    @Override
    public OutputStream setAsciiStream(long l) throws SQLException {
        return null;
    }

    @Override
    public Writer setCharacterStream(long l) throws SQLException {
        return null;
    }

    @Override
    public void truncate(long l) throws SQLException {
    }
}

