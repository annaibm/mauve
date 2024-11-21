/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.beans.beancontext;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.beans.beancontext.BeanContextChild;
import java.beans.beancontext.BeanContextChildSupport;
import java.beans.beancontext.BeanContextSupport;

public class Array
implements Testlet {
    private static BeanContextSupport context = new BeanContextSupport();

    @Override
    public void test(TestHarness h) {
        BeanContextChild[] children2 = new BeanContextChild[5];
        for (int a = 0; a < 5; ++a) {
            children2[a] = new BeanContextChildSupport();
            context.add(children2[a]);
            h.check(context.contains(children2[a]), "Child " + a + " present.");
        }
        h.check(context.size() == 5, "Size of 5 check");
        Object[] addedChildren = context.toArray();
        for (int a = 0; a < 5; ++a) {
            boolean flag = false;
            for (int b = 0; b < 5; ++b) {
                if (addedChildren[b] != children2[a]) continue;
                flag = true;
            }
            h.check(flag, "Check for child " + a + " in array.");
        }
    }
}

