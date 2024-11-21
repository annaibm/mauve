/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.util.AbstractMap;

import gnu.testlet.java.util.AbstractMap.AcuniaAbstractMapTest;
import gnu.testlet.java.util.AbstractMap.EIterator;
import java.util.AbstractSet;
import java.util.Iterator;

class ESet
extends AbstractSet {
    private AcuniaAbstractMapTest map;

    ESet(AcuniaAbstractMapTest map2) {
        this.map = map2;
    }

    @Override
    public Iterator iterator() {
        return new EIterator(this.map);
    }

    @Override
    public int size() {
        return this.map.keys.size();
    }
}

