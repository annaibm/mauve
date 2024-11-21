/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.management.openmbean.ArrayType;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import javax.management.openmbean.ArrayType;
import javax.management.openmbean.OpenDataException;
import javax.management.openmbean.SimpleType;

public class Equals
implements Testlet {
    @Override
    public void test(TestHarness h) {
        ArrayType<int[]> type = ArrayType.getPrimitiveArrayType(int[].class);
        h.check(type.equals(type), "Reflection test");
        h.check(type.equals(type), "Consistency test");
        ArrayType<int[]> type2 = ArrayType.getPrimitiveArrayType(int[].class);
        h.check(type.equals(type2), "Equality over creation test");
        h.check(type2.equals(type), "Symmetric test");
        ArrayType type3 = null;
        try {
            type3 = new ArrayType(SimpleType.INTEGER, true);
        }
        catch (OpenDataException e) {
            h.debug(e);
        }
        h.check(type2.equals(type3), "Equality over different creation test");
        h.check(type.equals(type3), "Transitivity test");
        h.check(!type.equals(null), "Null test");
    }
}

