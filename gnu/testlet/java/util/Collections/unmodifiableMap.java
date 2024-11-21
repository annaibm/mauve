/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.util.Collections;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class unmodifiableMap
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        harness.checkPoint("Empty map");
        HashMap<String, String> map2 = new HashMap<String, String>();
        this.testMap(map2, harness);
        harness.checkPoint("Non-empty map");
        map2.put("A", "AA");
        map2.put("B", "BB");
        map2.put("C", "CC");
        this.testMap(map2, harness);
        harness.checkPoint("Null map");
        boolean pass = false;
        try {
            Collections.unmodifiableMap(null);
        }
        catch (NullPointerException e) {
            pass = true;
        }
        harness.check(pass);
    }

    private void testMap(Map map2, TestHarness harness) {
        Map<String, String> umap = Collections.unmodifiableMap(map2);
        boolean pass = false;
        try {
            umap.clear();
        }
        catch (UnsupportedOperationException e) {
            pass = true;
        }
        harness.check(pass);
        pass = false;
        try {
            umap.put("X", "Y");
        }
        catch (UnsupportedOperationException e) {
            pass = true;
        }
        harness.check(pass);
        HashMap<String, Integer> map22 = new HashMap<String, Integer>();
        map22.put("ONE", new Integer(1));
        pass = false;
        try {
            umap.putAll(map22);
        }
        catch (UnsupportedOperationException e) {
            pass = true;
        }
        harness.check(pass);
        pass = false;
        Iterator iterator = umap.entrySet().iterator();
        if (iterator.hasNext()) {
            Map.Entry entry = iterator.next();
            try {
                entry.setValue("XYZ");
            }
            catch (UnsupportedOperationException e) {
                pass = true;
            }
            harness.check(pass);
        }
        pass = false;
        Object[] entries = umap.entrySet().toArray();
        if (entries.length > 0) {
            try {
                ((Map.Entry)entries[0]).setValue("XYZ");
            }
            catch (UnsupportedOperationException e) {
                pass = true;
            }
            harness.check(pass);
        }
        pass = false;
        Object[] entries2 = new Object[umap.size()];
        umap.entrySet().toArray(entries2);
        if (entries2.length > 0) {
            try {
                ((Map.Entry)entries2[0]).setValue("XYZ");
            }
            catch (UnsupportedOperationException e) {
                pass = true;
            }
            harness.check(pass);
        }
    }
}

