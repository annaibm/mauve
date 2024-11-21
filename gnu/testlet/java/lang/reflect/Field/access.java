/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.lang.reflect.Field;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.lang.reflect.Field;

public class access
implements Testlet {
    int value;

    @Override
    public void test(TestHarness harness) {
        try {
            Field field = access.class.getDeclaredField("value");
            field.setInt(this, 777);
        }
        catch (Exception exception) {
            // empty catch block
        }
        harness.check(this.value, 777);
    }
}

