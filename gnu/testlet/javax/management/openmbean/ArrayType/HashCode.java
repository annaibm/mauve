/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.management.openmbean.ArrayType;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import javax.management.openmbean.ArrayType;
import javax.management.openmbean.OpenDataException;
import javax.management.openmbean.SimpleType;

public class HashCode
implements Testlet {
    @Override
    public void test(TestHarness h) {
        ArrayType<int[]> type = ArrayType.getPrimitiveArrayType(int[].class);
        h.check(type.hashCode(), type.hashCode(), "Reflection test");
        h.check(type.hashCode(), type.hashCode(), "Consistency test");
        ArrayType<int[]> type2 = ArrayType.getPrimitiveArrayType(int[].class);
        h.check(type.hashCode(), type2.hashCode(), "Equality over creation test");
        ArrayType type3 = null;
        try {
            type3 = new ArrayType(SimpleType.INTEGER, true);
        }
        catch (OpenDataException e) {
            h.debug(e);
        }
        h.check(type3.hashCode(), type2.hashCode(), "Equality over different creation test");
        h.check(type.hashCode(), type3.hashCode(), "Transitivity test");
    }
}

