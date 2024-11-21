/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.lang.Class;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.awt.Graphics2D;
import java.awt.LayoutManager;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.geom.Arc2D;
import java.awt.geom.Line2D;
import java.awt.geom.Rectangle2D;
import java.awt.geom.RoundRectangle2D;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.ObjectStreamClass;
import java.io.Serializable;
import java.lang.reflect.Array;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Set;
import java.util.SortedSet;
import java.util.Vector;
import javax.swing.table.DefaultTableModel;

public class serialization
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        this.testClass(Cloneable.class, harness);
        this.testClass(Comparable.class, harness);
        this.testClass(Serializable.class, harness);
        this.testClass(Externalizable.class, harness);
        this.testClass(String.class, harness);
        this.testClass(Number.class, harness);
        this.testClass(Boolean.class, harness);
        this.testClass(Integer.class, harness);
        this.testClass(Float.class, harness);
        this.testClass(Double.class, harness);
        this.testClass(Vector.class, harness);
        this.testClass(ArrayList.class, harness);
        this.testClass(DateFormat.class, harness);
        this.testClass(Point.class, harness);
        this.testClass(Rectangle.class, harness);
        this.testClass(Rectangle2D.class, harness);
        this.testClass(Rectangle2D.Double.class, harness);
        this.testClass(Line2D.class, harness);
        this.testClass(Arc2D.class, harness);
        this.testClass(RoundRectangle2D.class, harness);
        this.testClass(Graphics2D.class, harness);
        this.testClass(DefaultTableModel.class, harness);
        this.testClass(LayoutManager.class, harness);
        this.testClass(Array.class, harness);
        this.testClass(Object.class, harness);
        this.testClass(Class.class, harness);
        this.testClass(Throwable.class, harness);
        this.testClass(IOException.class, harness);
        this.testClass(Void.class, harness);
        this.testClass(ObjectStreamClass.class, harness);
        this.testClass(Collection.class, harness);
        this.testClass(Set.class, harness);
        this.testClass(SortedSet.class, harness);
        this.testClass(Boolean.TYPE, harness);
        this.testClass(Byte.TYPE, harness);
        this.testClass(Short.TYPE, harness);
        this.testClass(Character.TYPE, harness);
        this.testClass(Integer.TYPE, harness);
        this.testClass(Long.TYPE, harness);
        this.testClass(Float.TYPE, harness);
        this.testClass(Double.TYPE, harness);
        this.testClass(Void.TYPE, harness);
    }

    private void testClass(Class c1, TestHarness harness) {
        Class c2 = null;
        try {
            ByteArrayOutputStream buffer = new ByteArrayOutputStream();
            ObjectOutputStream out = new ObjectOutputStream(buffer);
            out.writeObject(c1);
            out.close();
            ObjectInputStream in = new ObjectInputStream(new ByteArrayInputStream(buffer.toByteArray()));
            c2 = (Class)in.readObject();
            in.close();
        }
        catch (Exception e) {
            harness.debug(e);
        }
        harness.check(c1.equals(c2), c1.toString());
    }
}

