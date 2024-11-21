/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.imageio.spi.ServiceRegistry;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.util.LinkedList;
import javax.imageio.spi.RegisterableService;
import javax.imageio.spi.ServiceRegistry;

public class setOrdering
implements Testlet {
    @Override
    public void test(TestHarness h) {
        LinkedList<Class> categories = new LinkedList<Class>();
        categories.add(String.class);
        categories.add(RegisterableService.class);
        ServiceRegistry registry = new ServiceRegistry(categories.iterator());
        registry.registerServiceProvider("sheep", String.class);
        registry.registerServiceProvider("goat", String.class);
        registry.registerServiceProvider("cow", String.class);
        Exception caught = null;
        try {
            registry.setOrdering(String.class, "foo", null);
        }
        catch (Exception ex) {
            caught = ex;
        }
        h.check(caught instanceof IllegalArgumentException);
        caught = null;
        try {
            registry.setOrdering(String.class, "sheep", "sheep");
        }
        catch (Exception ex) {
            caught = ex;
        }
        h.check(caught instanceof IllegalArgumentException);
        h.check(registry.setOrdering(String.class, "cow", "sheep"));
        h.check(registry.setOrdering(String.class, "sheep", "goat"));
        h.check(!registry.setOrdering(String.class, "sheep", "goat"));
        h.check(!registry.setOrdering(String.class, "cow", "sheep"));
        h.check(registry.unsetOrdering(String.class, "cow", "sheep"));
        h.check(!registry.unsetOrdering(String.class, "cow", "sheep"));
        h.check(registry.setOrdering(String.class, "cow", "sheep"));
    }
}

