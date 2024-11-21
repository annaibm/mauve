/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.beans.beancontext.BeanContextSupport;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import gnu.testlet.java.beans.beancontext.BeanContextSupport.MyBeanContextSupport;
import java.awt.Color;
import java.awt.GradientPaint;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.HashSet;

public class serialize
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        HashSet<String> c2;
        ObjectInputStream in;
        ObjectOutputStream out;
        MyBeanContextSupport bcs = new MyBeanContextSupport();
        ByteArrayOutputStream buffer = new ByteArrayOutputStream();
        boolean pass = false;
        try {
            ObjectOutputStream out2 = new ObjectOutputStream(buffer);
            bcs.serializeX(out2, null);
        }
        catch (NullPointerException e) {
            pass = true;
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        harness.check(pass);
        ArrayList<Object> c1 = new ArrayList<Object>();
        buffer = new ByteArrayOutputStream();
        try {
            out = new ObjectOutputStream(buffer);
            bcs.serializeX(out, c1);
            out.close();
            in = new ObjectInputStream(new ByteArrayInputStream(buffer.toByteArray()));
            c2 = new HashSet<String>();
            bcs.deserializeX(in, c2);
            in.close();
            harness.check(c2.isEmpty());
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        c1 = new ArrayList();
        c1.add(new Integer(99));
        buffer = new ByteArrayOutputStream();
        try {
            out = new ObjectOutputStream(buffer);
            bcs.serializeX(out, c1);
            out.close();
            in = new ObjectInputStream(new ByteArrayInputStream(buffer.toByteArray()));
            c2 = new HashSet();
            bcs.deserializeX(in, c2);
            in.close();
            harness.check(c2.contains(new Integer(99)));
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        c1 = new ArrayList();
        c1.add(new Integer(99));
        c1.add("Item 2");
        buffer = new ByteArrayOutputStream();
        try {
            out = new ObjectOutputStream(buffer);
            bcs.serializeX(out, c1);
            out.close();
            in = new ObjectInputStream(new ByteArrayInputStream(buffer.toByteArray()));
            c2 = new HashSet();
            bcs.deserializeX(in, c2);
            in.close();
            harness.check(c2.contains(new Integer(99)));
            harness.check(c2.contains("Item 2"));
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        c1 = new ArrayList();
        c1.add(new GradientPaint(1.0f, 2.0f, Color.red, 3.0f, 4.0f, Color.blue));
        buffer = new ByteArrayOutputStream();
        try {
            out = new ObjectOutputStream(buffer);
            bcs.serializeX(out, c1);
            out.close();
            in = new ObjectInputStream(new ByteArrayInputStream(buffer.toByteArray()));
            c2 = new HashSet();
            bcs.deserializeX(in, c2);
            in.close();
            harness.check(c2.isEmpty());
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        pass = false;
        try {
            bcs.serializeX(null, new ArrayList());
        }
        catch (NullPointerException e) {
            pass = true;
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        harness.check(pass);
        c1 = new ArrayList();
        c1.add("XYZ");
        buffer = new ByteArrayOutputStream();
        try {
            out = new ObjectOutputStream(buffer);
            bcs.serializeX(out, c1);
            out.close();
            in = new ObjectInputStream(new ByteArrayInputStream(buffer.toByteArray()));
            c2 = new HashSet();
            c2.add("ABC");
            bcs.deserializeX(in, c2);
            in.close();
            harness.check(c2.size(), 2);
            harness.check(c2.contains("XYZ"));
            harness.check(c2.contains("ABC"));
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        c1 = new ArrayList();
        c1.add("XYZ");
        c1.add(null);
        buffer = new ByteArrayOutputStream();
        try {
            out = new ObjectOutputStream(buffer);
            bcs.serializeX(out, c1);
            out.close();
            in = new ObjectInputStream(new ByteArrayInputStream(buffer.toByteArray()));
            c2 = new HashSet();
            bcs.deserializeX(in, c2);
            in.close();
            harness.check(c2.size(), 1);
            harness.check(c2.contains("XYZ"));
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}

