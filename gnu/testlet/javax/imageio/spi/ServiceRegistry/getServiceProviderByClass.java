/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.imageio.spi.ServiceRegistry;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.util.LinkedList;
import javax.imageio.spi.RegisterableService;
import javax.imageio.spi.ServiceRegistry;

public class getServiceProviderByClass
implements Testlet {
    @Override
    public void test(TestHarness h) {
        LinkedList<Class> categories = new LinkedList<Class>();
        categories.add(String.class);
        categories.add(RegisterableService.class);
        ServiceRegistry registry = new ServiceRegistry(categories.iterator());
        registry.registerServiceProvider("foo", String.class);
        registry.registerServiceProvider("bar", String.class);
        Exception caught = null;
        try {
            registry.getServiceProviderByClass(null);
        }
        catch (Exception ex) {
            caught = ex;
        }
        h.check(caught instanceof IllegalArgumentException);
        h.check(registry.getServiceProviderByClass(RegisterableService.class), null);
        String sp = registry.getServiceProviderByClass(String.class);
        h.check(sp == "foo" || sp == "bar");
    }
}

