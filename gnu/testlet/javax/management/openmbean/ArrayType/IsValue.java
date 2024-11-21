/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.management.openmbean.ArrayType;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.util.HashMap;
import javax.management.openmbean.ArrayType;
import javax.management.openmbean.CompositeData;
import javax.management.openmbean.CompositeDataSupport;
import javax.management.openmbean.CompositeType;
import javax.management.openmbean.OpenDataException;
import javax.management.openmbean.OpenType;
import javax.management.openmbean.SimpleType;
import javax.management.openmbean.TabularData;
import javax.management.openmbean.TabularDataSupport;
import javax.management.openmbean.TabularType;

public class IsValue
implements Testlet {
    @Override
    public void test(TestHarness h) {
        ArrayType<int[]> type = ArrayType.getPrimitiveArrayType(int[].class);
        h.check(!type.isValue(null), "Null value check");
        h.check(!type.isValue(3), "Non-array value check");
        h.check(type.isValue(new int[]{3}), "Primitive int array value check");
        h.check(!type.isValue(new Integer[]{3}), "Integer array value check");
        try {
            CompositeType ctype = new CompositeType("Test", "Test", new String[]{"name"}, new String[]{"Name"}, new OpenType[]{SimpleType.STRING});
            HashMap<String, String> data = new HashMap<String, String>();
            data.put("name", "Bob");
            CompositeDataSupport cdata = new CompositeDataSupport(ctype, data);
            CompositeData[] cdataarr = new CompositeData[]{cdata};
            ArrayType type2 = new ArrayType(1, ctype);
            h.check(type2.isValue(cdataarr), "Composite data check");
            TabularType ttype = new TabularType("Test", "Test", ctype, new String[]{"name"});
            TabularDataSupport tdata = new TabularDataSupport(ttype);
            tdata.put(cdata);
            TabularData[] tdataarr = new TabularData[]{tdata};
            ArrayType type3 = new ArrayType(1, ttype);
            h.check(type3.isValue(tdataarr), "Tabular data check");
        }
        catch (OpenDataException e) {
            h.debug(e);
        }
    }
}

