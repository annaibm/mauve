/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.management.openmbean.ArrayType;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import javax.management.openmbean.ArrayType;
import javax.management.openmbean.CompositeType;
import javax.management.openmbean.OpenDataException;
import javax.management.openmbean.OpenType;
import javax.management.openmbean.SimpleType;
import javax.management.openmbean.TabularType;

public class IsPrimitiveArray
implements Testlet {
    @Override
    public void test(TestHarness h) {
        ArrayType<int[]> type1 = ArrayType.getPrimitiveArrayType(int[].class);
        h.check(type1.isPrimitiveArray(), "int[] true check");
        try {
            ArrayType type2 = new ArrayType(SimpleType.INTEGER, true);
            h.check(type2.isPrimitiveArray(), "Wrapped masked true check");
            ArrayType type3 = new ArrayType(SimpleType.INTEGER, false);
            h.check(!type3.isPrimitiveArray(), "Wrapped not masked false check");
            ArrayType type4 = new ArrayType(1, SimpleType.INTEGER);
            h.check(!type4.isPrimitiveArray(), "Normal wrapped false check");
            ArrayType type5 = new ArrayType(1, SimpleType.STRING);
            h.check(!type5.isPrimitiveArray(), "String false check");
            CompositeType ctype = new CompositeType("Test", "Test", new String[]{"name"}, new String[]{"Name"}, new OpenType[]{SimpleType.STRING});
            ArrayType type6 = new ArrayType(1, ctype);
            h.check(!type6.isPrimitiveArray(), "Composite type false check");
            TabularType ttype = new TabularType("Test", "Test", ctype, new String[]{"name"});
            ArrayType type7 = new ArrayType(1, ttype);
            h.check(!type7.isPrimitiveArray(), "Tabular type false check");
            ArrayType type8 = new ArrayType(1, type1);
            h.check(type8.isPrimitiveArray(), "Carry through true check");
            ArrayType type9 = new ArrayType(1, type2);
            h.check(type9.isPrimitiveArray());
            ArrayType type10 = new ArrayType(1, type3);
            h.check(!type10.isPrimitiveArray(), "Carry through false check");
        }
        catch (OpenDataException e) {
            h.debug(e);
        }
    }
}

