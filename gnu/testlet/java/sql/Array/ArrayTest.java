/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.sql.Array;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.sql.Array;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Map;

public class ArrayTest
implements Array,
Testlet {
    @Override
    public void test(TestHarness harness) {
        harness.check(true, "java.sql.Array");
    }

    @Override
    public String getBaseTypeName() throws SQLException {
        return null;
    }

    @Override
    public void free() throws SQLException {
    }

    @Override
    public int getBaseType() throws SQLException {
        return 0;
    }

    @Override
    public Object getArray() throws SQLException {
        return null;
    }

    public Object getArray(Map map2) throws SQLException {
        return null;
    }

    @Override
    public Object getArray(long offset2, int count) throws SQLException {
        return null;
    }

    public Object getArray(long index, int count, Map map2) throws SQLException {
        return null;
    }

    @Override
    public ResultSet getResultSet() throws SQLException {
        return null;
    }

    public ResultSet getResultSet(Map map2) throws SQLException {
        return null;
    }

    @Override
    public ResultSet getResultSet(long index, int count) throws SQLException {
        return null;
    }

    public ResultSet getResultSet(long index, int count, Map map2) throws SQLException {
        return null;
    }
}

