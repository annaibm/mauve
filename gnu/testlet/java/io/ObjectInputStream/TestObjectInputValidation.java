/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.io.ObjectInputStream;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectInputValidation;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;

class TestObjectInputValidation
implements ObjectInputValidation,
Serializable {
    ArrayList validated;
    private String name;
    private int priority;
    TestObjectInputValidation object;

    public TestObjectInputValidation(String name2) {
        this.name = name2;
        this.priority = 10;
        this.object = this;
    }

    public TestObjectInputValidation(int priority2, TestObjectInputValidation object) {
        this.priority = priority2;
        this.object = object;
    }

    @Override
    public void validateObject() {
        if (this.object.validated == null) {
            this.object.validated = new ArrayList();
        }
        this.object.validated.add(new Integer(this.priority));
    }

    private void writeObject(ObjectOutputStream stream) throws IOException {
        stream.defaultWriteObject();
    }

    private void readObject(ObjectInputStream stream) throws IOException, ClassNotFoundException {
        stream.registerValidation(this, 10);
        stream.registerValidation(new TestObjectInputValidation(-10, this), -10);
        stream.defaultReadObject();
        stream.registerValidation(this, 12);
        stream.registerValidation(new TestObjectInputValidation(-12, this), -12);
        stream.registerValidation(new TestObjectInputValidation(11, this), 11);
    }

    public boolean equals(Object o) {
        if (o instanceof TestObjectInputValidation) {
            TestObjectInputValidation other = (TestObjectInputValidation)o;
            return this.name.equals(other.name) && this.priority == other.priority;
        }
        return false;
    }
}

