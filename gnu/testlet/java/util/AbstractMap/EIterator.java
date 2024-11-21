/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.util.AbstractMap;

import gnu.testlet.java.util.AbstractMap.AcuniaAbstractMapTest;
import gnu.testlet.java.util.AbstractMap.Entry;
import java.util.Iterator;
import java.util.NoSuchElementException;

class EIterator
implements Iterator {
    int pos = 0;
    int status = 0;
    private AcuniaAbstractMapTest map;

    public EIterator(AcuniaAbstractMapTest map2) {
        this.map = map2;
    }

    @Override
    public boolean hasNext() {
        return this.pos < this.map.size();
    }

    public Object next() {
        this.status = 1;
        if (this.pos >= this.map.size()) {
            throw new NoSuchElementException("no elements left");
        }
        ++this.pos;
        return new Entry(this.map.keys.get(this.pos - 1), this.map.values.get(this.pos - 1));
    }

    @Override
    public void remove() {
        if (this.status != 1) {
            throw new IllegalStateException("do a next() operation before remove()");
        }
        this.map.deleteInAM(this.map.keys.get(this.pos - 1));
        --this.pos;
        this.status = -1;
    }
}

