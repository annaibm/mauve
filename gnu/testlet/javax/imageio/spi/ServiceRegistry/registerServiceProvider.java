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

public class registerServiceProvider
implements Testlet {
    @Override
    public void test(TestHarness h) {
        SomeService s1 = new SomeService();
        TestService s2 = new TestService();
        LinkedList<Class> categories = new LinkedList<Class>();
        categories.add(SomeService.class);
        categories.add(RegisterableService.class);
        ServiceRegistry registry = new ServiceRegistry(categories.iterator());
        Exception caught = null;
        try {
            registry.registerServiceProvider(null);
        }
        catch (Exception ex) {
            caught = ex;
        }
        h.check(caught instanceof IllegalArgumentException);
        registry.registerServiceProvider(s1);
        h.check(registry.contains(s1));
        registry.registerServiceProvider(s2);
        h.check(registry.contains(s2));
        h.check(s2.numRegistrations, 1);
        h.check(s2.lastRegisteredRegistry, registry);
        h.check(s2.lastRegisteredCategory, RegisterableService.class);
    }

    private static class SomeService {
        private SomeService() {
        }
    }
}

