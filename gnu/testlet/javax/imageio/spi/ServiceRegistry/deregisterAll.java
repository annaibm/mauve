/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.imageio.spi.ServiceRegistry;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import gnu.testlet.javax.imageio.spi.ServiceRegistry.TestService;
import java.util.LinkedList;
import javax.imageio.spi.RegisterableService;
import javax.imageio.spi.ServiceRegistry;

public class deregisterAll
implements Testlet {
    @Override
    public void test(TestHarness h) {
        SomeService s1 = new SomeService();
        TestService s2 = new TestService();
        LinkedList<Class> categories = new LinkedList<Class>();
        categories.add(SomeService.class);
        categories.add(RegisterableService.class);
        ServiceRegistry registry = new ServiceRegistry(categories.iterator());
        registry.registerServiceProvider(s1);
        registry.registerServiceProvider(s2);
        Exception caught = null;
        try {
            registry.deregisterAll(null);
        }
        catch (Exception ex) {
            caught = ex;
        }
        h.check(caught instanceof IllegalArgumentException);
        caught = null;
        try {
            registry.deregisterAll(String.class);
        }
        catch (Exception ex) {
            caught = ex;
        }
        h.check(caught instanceof IllegalArgumentException);
        registry.deregisterAll(SomeService.class);
        h.check(!registry.contains(s1));
        h.check(registry.contains(s2) && s2.numRegistrations == 1);
    }

    private static class SomeService {
        private SomeService() {
        }
    }
}

