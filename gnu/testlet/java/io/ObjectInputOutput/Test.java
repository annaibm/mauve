/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.io.ObjectInputOutput;

import java.io.Externalizable;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.io.ObjectStreamException;
import java.io.Serializable;
import java.lang.reflect.Field;

public abstract class Test {
    public static void main(String[] args) throws IOException {
        int i;
        Test[] tests = Test.getValidTests();
        for (i = 0; i < tests.length; ++i) {
            Test.writeRefData(tests[i], false);
        }
        tests = Test.getErrorTests();
        for (i = 0; i < tests.length; ++i) {
            Test.writeRefData(tests[i], true);
        }
    }

    static void writeRefData(Test t, boolean throwsOSE) throws IOException {
        String file = t.getClass().getName();
        int idx = file.lastIndexOf(46);
        if (idx != -1) {
            file = file.substring(idx + 1);
        }
        file = file + ".data";
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file));
        Object[] objs = t.getTestObjs();
        for (int i = 0; i < objs.length; ++i) {
            Test.writeData(oos, objs[i], throwsOSE);
        }
        oos.close();
    }

    static void writeData(ObjectOutputStream oos, Object obj, boolean throwsOSE) throws IOException {
        block2: {
            try {
                oos.writeObject(obj);
            }
            catch (ObjectStreamException nse) {
                if (throwsOSE) break block2;
                throw nse;
            }
        }
    }

    static Test[] getValidTests() {
        return new Test[]{new CallDefault(), new Extern(), new NoCallDefault(), new HairyGraph(), new GetPutField(), new FinalField()};
    }

    static Test[] getErrorTests() {
        return new Test[]{new NotSerial(), new BadField()};
    }

    Test() {
    }

    abstract Object[] getTestObjs();

    public String toString() {
        try {
            Class<?> clazz = this.getClass();
            StringBuffer buf = new StringBuffer(clazz.getName());
            buf.append(" (");
            Field[] fields = clazz.getDeclaredFields();
            for (int i = 0; i < fields.length; ++i) {
                Field f = fields[i];
                buf.append(f.getName());
                buf.append(" = ");
                Class<?> f_type = f.getType();
                if (f_type == Boolean.TYPE) {
                    buf.append(f.getBoolean(this));
                } else if (f_type == Byte.TYPE) {
                    buf.append(f.getByte(this));
                } else if (f_type == Character.TYPE) {
                    buf.append(f.getChar(this));
                } else if (f_type == Double.TYPE) {
                    buf.append(f.getDouble(this));
                } else if (f_type == Float.TYPE) {
                    buf.append(f.getFloat(this));
                } else if (f_type == Long.TYPE) {
                    buf.append(f.getLong(this));
                } else if (f_type == Short.TYPE) {
                    buf.append(f.getShort(this));
                } else if (f_type == String.class) {
                    String s = (String)f.get(this);
                    if (s != null) {
                        buf.append('\"');
                    }
                    buf.append(s);
                    if (s != null) {
                        buf.append('\"');
                    }
                } else {
                    buf.append(f.get(this));
                }
                if (i == fields.length - 1) continue;
                buf.append(", ");
            }
            buf.append(')');
            return buf.toString();
        }
        catch (IllegalAccessException iae) {
            return super.toString();
        }
    }

    static class FinalField
    extends Test
    implements Serializable {
        final int a;
        final String s;

        FinalField() {
            this.s = "C";
            this.a = 2;
        }

        @Override
        Object[] getTestObjs() {
            return new Object[]{new FinalField()};
        }

        public boolean equals(Object o) {
            FinalField oo = (FinalField)o;
            return oo.a == this.a && oo.s.equals(this.s);
        }
    }

    static class BadField
    extends Test
    implements Serializable {
        int x;
        int y;
        NotSerial o;

        BadField(int X2, int Y, NotSerial O) {
            this.x = X2;
            this.y = Y;
            this.o = O;
        }

        BadField() {
        }

        @Override
        Object[] getTestObjs() {
            return new Object[]{new BadField(1, 2, new NotSerial())};
        }
    }

    static class NotSerial
    extends Test {
        NotSerial() {
        }

        @Override
        Object[] getTestObjs() {
            return new Object[]{new NotSerial()};
        }
    }

    static class GetPutField
    extends Test
    implements Serializable {
        private static final String WRONG_STR_VAL = "wrong-o";
        private static final int WRONG_X_VAL = -17;
        private String str;
        private int x;

        @Override
        Object[] getTestObjs() {
            return new Object[]{new GetPutField("test123", 123), new GetPutField("", 0), new GetPutField(null, -1)};
        }

        GetPutField() {
        }

        GetPutField(String str, int x) {
            this.str = str;
            this.x = x;
        }

        public boolean equals(Object o) {
            if (!(o instanceof GetPutField)) {
                return false;
            }
            GetPutField other = (GetPutField)o;
            return (other.str == this.str || other.str.equals(this.str)) && other.x == this.x;
        }

        @Override
        public String toString() {
            return "test(str=" + this.str + ", x=" + this.x + ")";
        }

        private void writeObject(ObjectOutputStream oo) throws IOException {
            ObjectOutputStream.PutField pf = oo.putFields();
            pf.put("str", this.str);
            pf.put("x", this.x);
            oo.writeFields();
        }

        private void readObject(ObjectInputStream oi) throws ClassNotFoundException, IOException {
            ObjectInputStream.GetField gf = oi.readFields();
            this.str = (String)gf.get("str", WRONG_STR_VAL);
            this.x = gf.get("x", -17);
        }
    }

    static class HairyGraph
    extends Test
    implements Serializable {
        GraphNode A = new GraphNode("A");
        GraphNode B = new GraphNode("B");
        GraphNode C = new GraphNode("C");
        GraphNode D = new GraphNode("D");

        HairyGraph() {
            this.A.a = this.B;
            this.A.b = this.C;
            this.A.c = this.D;
            this.A.d = this.A;
            this.B.a = this.C;
            this.B.b = this.D;
            this.B.c = this.A;
            this.B.d = this.B;
            this.C.a = this.D;
            this.C.b = this.A;
            this.C.c = this.B;
            this.C.d = this.C;
            this.D.a = this.A;
            this.D.b = this.B;
            this.D.c = this.C;
            this.D.d = this.D;
        }

        public boolean equals(Object o) {
            HairyGraph hg = (HairyGraph)o;
            return this.A.a == this.B.d && this.A.a == this.C.c && this.A.a == this.D.b && this.A.b == this.B.a && this.A.b == this.C.d && this.A.b == this.D.c && this.A.c == this.B.b && this.A.c == this.C.a && this.A.c == this.D.d && this.A.d == this.B.c && this.A.d == this.C.b && this.A.d == this.D.a;
        }

        @Override
        Object[] getTestObjs() {
            return new Object[]{new HairyGraph()};
        }

        void printOneLevel(GraphNode gn) {
            System.out.println("GraphNode( " + gn + ": " + gn.a + ", " + gn.b + ", " + gn.c + ", " + gn.d + " )");
        }
    }

    static class GraphNode
    implements Serializable {
        String s;
        GraphNode a;
        GraphNode b;
        GraphNode c;
        GraphNode d;

        GraphNode(String s) {
            this.s = s;
        }

        public String toString() {
            return this.s;
        }
    }

    static class NoCallDefault
    extends Test
    implements Serializable {
        int x;
        String s;
        boolean b;

        NoCallDefault() {
        }

        NoCallDefault(int X2, String S, boolean B2) {
            this.x = X2;
            this.s = S;
            this.b = B2;
        }

        public boolean equals(Object o) {
            NoCallDefault oo = (NoCallDefault)o;
            return oo.x == this.x && oo.b == this.b && oo.s.equals(this.s);
        }

        @Override
        Object[] getTestObjs() {
            return new Object[]{new NoCallDefault(17, "no\ncalldefaults", false)};
        }

        private void writeObject(ObjectOutputStream oos) throws IOException {
            oos.writeInt(this.x);
            oos.writeObject(this.s);
            oos.writeBoolean(this.b);
        }

        private void readObject(ObjectInputStream ois) throws ClassNotFoundException, IOException {
            this.x = ois.readInt();
            this.s = (String)ois.readObject();
            this.b = ois.readBoolean();
        }
    }

    static class Extern
    extends NoCallDefault
    implements Externalizable {
        public Extern() {
        }

        Extern(int X2, String S, boolean B2) {
            super(X2, S, B2);
        }

        @Override
        public void writeExternal(ObjectOutput oo) throws IOException {
            oo.writeInt(this.x);
            oo.writeObject(this.s);
            oo.writeBoolean(this.b);
        }

        @Override
        public void readExternal(ObjectInput oi) throws ClassNotFoundException, IOException {
            this.x = oi.readInt();
            this.s = (String)oi.readObject();
            this.b = oi.readBoolean();
        }

        @Override
        public boolean equals(Object o) {
            Extern e = (Extern)o;
            return e.x == this.x && e.s.equals(this.s) && e.b == this.b;
        }

        @Override
        Object[] getTestObjs() {
            return new Object[]{new Extern(-1, "", true)};
        }
    }

    static class CallDefault
    extends Test
    implements Serializable {
        int x;
        double y;
        String s;

        CallDefault() {
        }

        CallDefault(int X2, double Y, String S) {
            this.x = X2;
            this.y = Y;
            this.s = S;
        }

        public boolean equals(Object o) {
            CallDefault oo = (CallDefault)o;
            return oo.x == this.x && oo.y == this.y && oo.s.equals(this.s);
        }

        @Override
        Object[] getTestObjs() {
            return new Object[]{new CallDefault(1, 3.14, "test")};
        }

        private void writeObject(ObjectOutputStream oos) throws IOException {
            oos.defaultWriteObject();
        }

        private void readObject(ObjectInputStream ois) throws ClassNotFoundException, IOException {
            ois.defaultReadObject();
        }
    }
}

