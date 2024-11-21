/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.imageio.spi.ServiceRegistry;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import javax.imageio.spi.RegisterableService;
import javax.imageio.spi.ServiceRegistry;

public class getCategories
implements Testlet {
    @Override
    public void test(TestHarness h) {
        ServiceRegistry registry = new ServiceRegistry(Collections.EMPTY_LIST.iterator());
        h.check(!registry.getCategories().hasNext());
        LinkedList<Class> categories = new LinkedList<Class>();
        categories.add(String.class);
        categories.add(RegisterableService.class);
        registry = new ServiceRegistry(categories.iterator());
        HashSet cats = new HashSet();
        Iterator<Class<?>> iter2 = registry.getCategories();
        while (iter2.hasNext()) {
            cats.add(iter2.next());
        }
        h.check(cats.size(), 2);
        h.check(cats.contains(String.class));
        h.check(cats.contains(RegisterableService.class));
    }
}

