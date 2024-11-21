/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.security.Security;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.security.Provider;
import java.security.Security;
import java.util.Iterator;
import java.util.Set;

public class getAlgorithms
extends Provider
implements Testlet {
    public getAlgorithms() {
        super("getAlgorithms", 1.0, "");
        this.put("Coffee.Foo", "whatever");
        this.put("Tea.Bar", "whatever");
        this.put("Tea.Bar ImplementedIn", "Vapourware");
        this.put("Tea.Bar MinCapacity", "100");
        this.put("Tea.Baz", "whatever");
        this.put("Tea.Baz ImplementedIn", "Vapourware");
        this.put("Tea.Baz MinCapacity", "100");
    }

    @Override
    public void test(TestHarness harness) {
        harness.checkPoint("getAlgorithms");
        Set<String> set2 = null;
        Security.addProvider(this);
        String signature = "getAlgorithms(\"foo\")";
        set2 = Security.getAlgorithms("foo");
        harness.check(set2 != null && set2.size() == 0, signature);
        signature = "getAlgorithms(\"Coffee\")";
        set2 = Security.getAlgorithms("Coffee");
        String key = "Foo";
        if (set2 != null && set2.size() >= 1) {
            harness.check(getAlgorithms.containsKey(set2, key), signature + ": " + key);
        } else {
            harness.check(false, signature + ": set.size() < 1");
        }
        signature = "getAlgorithms(\"Tea\")";
        set2 = Security.getAlgorithms("Tea");
        if (set2 != null && set2.size() >= 2) {
            key = "Bar";
            harness.check(getAlgorithms.containsKey(set2, key), signature + ": " + key);
            key = "Baz";
            harness.check(getAlgorithms.containsKey(set2, key), signature + ": " + key);
        } else {
            harness.check(false, signature + ": set.size() < 2");
        }
    }

    private static final boolean containsKey(Set set2, String key) {
        boolean result = false;
        Iterator it = set2.iterator();
        while (it.hasNext() && !(result = key.trim().equalsIgnoreCase(String.valueOf(it.next()).trim()))) {
        }
        return result;
    }
}

