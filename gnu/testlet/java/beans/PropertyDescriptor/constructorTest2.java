/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.beans.PropertyDescriptor;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.beans.IntrospectionException;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Method;

public class constructorTest2
implements Testlet {
    public int getProp1() {
        return 0;
    }

    public void setProp1(int val) {
    }

    public boolean getProp2() {
        return false;
    }

    public void setProp2(boolean val) {
    }

    public boolean isProp3() {
        return false;
    }

    public void setProp3(boolean val) {
    }

    public int isProp4() {
        return 0;
    }

    public void setProp4(int val) {
    }

    public boolean isProp5() {
        return false;
    }

    public boolean getProp5() {
        return false;
    }

    public void setProp5(boolean val) {
    }

    public boolean getProp6() {
        return false;
    }

    public boolean isProp6() {
        return false;
    }

    public void setProp6(boolean val) {
    }

    public boolean getProp7() {
        return false;
    }

    public void setProp7(boolean val) {
    }

    public void setProp7(int val) {
    }

    public boolean getError1() {
        return false;
    }

    public boolean isError2() {
        return false;
    }

    public void setError3(boolean val) {
    }

    public void getError4() {
    }

    public void setError4(int val) {
    }

    public void isError5() {
    }

    public void setError5(int val) {
    }

    public int getError6() {
        return 0;
    }

    public void setError6(boolean val) {
    }

    public boolean isError7() {
        return false;
    }

    public void setError7(int val) {
    }

    public Object getError8() {
        return null;
    }

    public void setError8(String val) {
    }

    public String getError9() {
        return null;
    }

    public void setError9(Object val) {
    }

    public boolean isError10() {
        return false;
    }

    public void setError10() {
    }

    public boolean getError11(int arg) {
        return false;
    }

    public void setError11(boolean val) {
    }

    public boolean isError12(int arg) {
        return false;
    }

    public void setError12(boolean val) {
    }

    public boolean isError13() {
        return false;
    }

    public void setError13(boolean val, int arg) {
    }

    public Object get() {
        return null;
    }

    public void set(Object val) {
    }

    public Object getknotted() {
        return null;
    }

    public void setknotted(Object val) {
    }

    private void constructor1Tests(TestHarness harness) {
        String[] goodProperties = new String[]{"prop1", "prop2", "prop3", "prop4", "prop5", "prop6", "prop7"};
        for (int i = 0; i < goodProperties.length; ++i) {
            PropertyDescriptor pd;
            harness.checkPoint("new PropertyDescriptor(" + goodProperties[i] + ") (should succeed)");
            try {
                pd = new PropertyDescriptor(goodProperties[i], constructorTest2.class);
                harness.check(true);
            }
            catch (IntrospectionException e) {
                harness.debug(e);
                harness.check(false);
                continue;
            }
            harness.check(pd.getReadMethod() != null);
            harness.check(pd.getWriteMethod() != null);
        }
        harness.checkPoint("string constructor - binding");
        String[] bindProperties = new String[]{"prop5", "prop6"};
        for (int i = 0; i < bindProperties.length; ++i) {
            harness.checkPoint("new PropertyDescriptor(" + bindProperties[i] + ") (check bindings)");
            try {
                PropertyDescriptor pd = new PropertyDescriptor(bindProperties[i], constructorTest2.class);
                Class<?> propType = pd.getPropertyType();
                Method readMethod = pd.getReadMethod();
                harness.check(readMethod != null);
                if (readMethod == null) continue;
                harness.check(readMethod.getName().startsWith("is"));
                Class<?> resType = readMethod.getReturnType();
                harness.check(resType.equals(propType));
                Method writeMethod = pd.getWriteMethod();
                harness.check(writeMethod != null);
                if (writeMethod == null) continue;
                Class<?> argType = writeMethod.getParameterTypes()[0];
                harness.check(argType.equals(propType));
                continue;
            }
            catch (IntrospectionException pd) {
                // empty catch block
            }
        }
        String[] badProperties = new String[]{"", "foo", "knotted", "???", "error1", "error2", "error3", "error4", "error5", "error6", "error7", "error8", "error9", "error10", "error11", "error12", "error13"};
        for (int i = 0; i < badProperties.length; ++i) {
            harness.checkPoint("new PropertyDescriptor(" + badProperties[i] + ") (should fail)");
            boolean ok = false;
            try {
                new PropertyDescriptor(badProperties[i], constructorTest2.class);
            }
            catch (IntrospectionException e) {
                ok = true;
            }
            harness.check(ok);
        }
    }

    private void constructor2Tests(TestHarness harness) {
        String[][] goodProperties = new String[][]{{"prop1", "getProp1", "setProp1"}, {"prop2", "getProp2", "setProp2"}, {"prop3", "isProp3", "setProp3"}, {"prop4", "isProp4", "setProp4"}, {"prop5", "isProp5", "setProp5"}, {"prop5", "getProp5", "setProp5"}, {"prop6", "isProp6", "setProp6"}, {"prop6", "getProp6", "setProp6"}, {"prop7", "getProp7", "setProp7"}, {"prop7", "getProp7", null}, {"prop7", null, "setProp7"}, {"prop7", null, null}};
        for (int i = 0; i < goodProperties.length; ++i) {
            harness.checkPoint("new PropertyDescriptor(" + goodProperties[i][0] + ", " + goodProperties[i][1] + ", " + goodProperties[i][2] + ") (should succeed)");
            boolean ok = true;
            try {
                new PropertyDescriptor(goodProperties[i][0], constructorTest2.class, goodProperties[i][1], goodProperties[i][2]);
            }
            catch (IntrospectionException e) {
                harness.debug(e);
                ok = false;
            }
            harness.check(ok);
        }
        String[][] badProperties = new String[][]{{"foo", "getFoo", "setFoo"}, {"foo2", null, "setFoo2"}, {"foo3", "getFoo3", null}, {"bar", "", ""}, {"error4", "getError4", "setError4"}, {"error5", "isError5", "setError5"}, {"error6", "getError6", "setError6"}, {"error7", "isError7", "setError7"}, {"error8", "getError8", "setError8"}, {"error9", "getError9", "setError9"}, {"error10", "isError10", "setError10"}, {"error11", "getError11", "setError11"}, {"error12", "isError12", "setError12"}, {"error13", "isError13", "setError13"}};
        for (int i = 0; i < badProperties.length; ++i) {
            harness.checkPoint("new PropertyDescriptor(" + badProperties[i][0] + ", " + badProperties[i][1] + ", " + badProperties[i][2] + ") (should fail)");
            boolean ok = false;
            try {
                new PropertyDescriptor(badProperties[i][0], constructorTest2.class, badProperties[i][1], badProperties[i][2]);
            }
            catch (IntrospectionException e) {
                ok = true;
            }
            harness.check(ok);
        }
    }

    @Override
    public void test(TestHarness harness) {
        this.constructor1Tests(harness);
        this.constructor2Tests(harness);
    }
}

