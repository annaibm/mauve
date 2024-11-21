/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.lang.ClassFormatError.classInfo;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;

public class isAssignableFrom
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        ClassFormatError o = new ClassFormatError("ClassFormatError");
        Class<ClassFormatError> c = o.getClass();
        harness.check(c.isAssignableFrom(ClassFormatError.class));
    }
}

