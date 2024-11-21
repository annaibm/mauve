/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.management.openmbean.ArrayType;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import javax.management.openmbean.ArrayType;
import javax.management.openmbean.CompositeData;
import javax.management.openmbean.CompositeType;
import javax.management.openmbean.OpenDataException;
import javax.management.openmbean.OpenType;
import javax.management.openmbean.SimpleType;
import javax.management.openmbean.TabularData;
import javax.management.openmbean.TabularType;

public class Constructor1
implements Testlet {
    @Override
    public void test(TestHarness h) {
        ArrayType type;
        try {
            type = new ArrayType(0, SimpleType.INTEGER);
            h.fail("Didn't catch dimensions < 1");
        }
        catch (IllegalArgumentException e) {
            h.check(true, "Threw exception for dimensions of 0");
        }
        catch (OpenDataException e) {
            h.debug(e);
        }
        try {
            type = new ArrayType(-1, SimpleType.INTEGER);
            h.fail("Didn't catch dimensions < 1");
        }
        catch (IllegalArgumentException e) {
            h.check(true, "Threw exception for dimensions of -1");
        }
        catch (OpenDataException e) {
            h.debug(e);
        }
        try {
            h.checkPoint("1-dimensional String array");
            type = new ArrayType(1, SimpleType.STRING);
            h.check(type.getClassName(), (Object)"[Ljava.lang.String;");
            h.check(type.getTypeName(), (Object)"[Ljava.lang.String;");
            h.check(type.getElementOpenType().getClassName(), (Object)"java.lang.String");
            h.check(type.getDescription(), (Object)"1-dimension array of java.lang.String");
            h.checkPoint("2-dimensional String array");
            ArrayType type2 = new ArrayType(2, SimpleType.STRING);
            h.check(type2.getClassName(), (Object)"[[Ljava.lang.String;");
            h.check(type2.getTypeName(), (Object)"[[Ljava.lang.String;");
            h.check(type2.getElementOpenType().getClassName(), (Object)"java.lang.String");
            h.check(type2.getDescription(), (Object)"2-dimension array of java.lang.String");
            h.checkPoint("4-dimensional String array (one constructor)");
            ArrayType type3 = new ArrayType(4, SimpleType.STRING);
            h.check(type3.getClassName(), (Object)"[[[[Ljava.lang.String;");
            h.check(type3.getTypeName(), (Object)"[[[[Ljava.lang.String;");
            h.check(type3.getElementOpenType().getClassName(), (Object)"java.lang.String");
            h.check(type3.getDescription(), (Object)"4-dimension array of java.lang.String");
            h.checkPoint("4-dimensional String array (two constructors)");
            ArrayType type4 = new ArrayType(2, type2);
            h.check(type4.getClassName(), (Object)"[[[[Ljava.lang.String;");
            h.check(type4.getTypeName(), (Object)"[[[[Ljava.lang.String;");
            h.check(type4.getElementOpenType().getClassName(), (Object)"java.lang.String");
            h.check(type4.getDescription(), (Object)"4-dimension array of java.lang.String");
            h.checkPoint("Composite Type Array");
            CompositeType ctype = new CompositeType("Test", "Test", new String[]{"name"}, new String[]{"Name"}, new OpenType[]{SimpleType.STRING});
            ArrayType type5 = new ArrayType(1, ctype);
            String className = CompositeData.class.getName();
            h.check(type5.getClassName(), (Object)("[L" + className + ";"));
            h.check(type5.getTypeName(), (Object)("[L" + className + ";"));
            h.check(type5.getElementOpenType().getClassName(), (Object)className);
            h.check(type5.getDescription(), (Object)("1-dimension array of " + className));
            h.checkPoint("Tabular Type Array");
            TabularType ttype = new TabularType("Test", "Test", ctype, new String[]{"name"});
            ArrayType type6 = new ArrayType(1, ttype);
            className = TabularData.class.getName();
            h.check(type6.getClassName(), (Object)("[L" + className + ";"));
            h.check(type6.getTypeName(), (Object)("[L" + className + ";"));
            h.check(type6.getElementOpenType().getClassName(), (Object)className);
            h.check(type6.getDescription(), (Object)("1-dimension array of " + className));
        }
        catch (OpenDataException e) {
            h.debug(e);
        }
        try {
            type = new ArrayType(-1, new OpenType("Mauve", "Mauve", "Mauve"){

                @Override
                public boolean equals(Object obj) {
                    return false;
                }

                @Override
                public int hashCode() {
                    return 42;
                }

                @Override
                public boolean isValue(Object obj) {
                    return false;
                }

                @Override
                public String toString() {
                    return "Mauve";
                }
            });
            h.fail("Didn't catch our own OpenType");
        }
        catch (OpenDataException e) {
            h.check(true, "Threw exception for invalid OpenType");
        }
    }
}

