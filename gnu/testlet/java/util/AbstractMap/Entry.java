/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.util.AbstractMap;

import java.util.Map;

class Entry
implements Map.Entry {
    private Object key;
    private Object value;

    public Entry(Object k, Object v) {
        this.key = k;
        this.value = v;
    }

    public Object getKey() {
        return this.key;
    }

    public Object getValue() {
        return this.value;
    }

    public Object setValue(Object nv) {
        Object ov = this.value;
        this.value = nv;
        return ov;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Map.Entry)) {
            return false;
        }
        Map.Entry e = (Map.Entry)o;
        if (e == null) {
            return false;
        }
        return (this.key == null ? e.getKey() == null : this.key.equals(e.getKey())) && (this.value == null ? e.getValue() == null : this.key.equals(e.getValue()));
    }
}

