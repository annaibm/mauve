/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.io.ObjectStreamClass;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import gnu.testlet.java.io.ObjectStreamClass.A;
import gnu.testlet.java.io.ObjectStreamClass.B;
import gnu.testlet.java.io.ObjectStreamClass.C;
import gnu.testlet.java.io.ObjectStreamClass.Defined;
import gnu.testlet.java.io.ObjectStreamClass.DefinedNotFinal;
import gnu.testlet.java.io.ObjectStreamClass.DefinedNotStatic;
import gnu.testlet.java.io.ObjectStreamClass.NotSerial;
import gnu.testlet.java.io.ObjectStreamClass.Serial;
import java.io.ObjectStreamClass;
import java.util.Hashtable;
import java.util.Vector;

public class Test
implements Testlet {
    TestHarness harness;

    public void testLookup(Class cl, boolean is_null) {
        ObjectStreamClass osc = ObjectStreamClass.lookup(cl);
        this.harness.check(is_null ? osc == null : osc != null);
    }

    public void testGetName(Class cl, String name2) {
        this.harness.check(ObjectStreamClass.lookup(cl).getName(), (Object)name2);
    }

    public void testToString(Class cl, String str, long uid) {
        String s = ObjectStreamClass.lookup(cl).toString();
        this.harness.check(s.indexOf(str) != -1 || s.indexOf(Long.toString(uid)) != -1, "Should contain '" + str + "' or '" + uid + "'");
    }

    public void testForClass(Class cl, Class clazz) {
        this.harness.check(ObjectStreamClass.lookup(cl).forClass(), clazz);
    }

    public void testSUID(Class cl, long suid) {
        this.harness.check(ObjectStreamClass.lookup(cl).getSerialVersionUID(), suid);
    }

    @Override
    public void test(TestHarness harness) {
        this.harness = harness;
        harness.checkPoint("lookup");
        this.testLookup(Serial.class, false);
        this.testLookup(NotSerial.class, true);
        harness.checkPoint("getName");
        this.testGetName(String.class, "java.lang.String");
        this.testGetName(Hashtable.class, "java.util.Hashtable");
        harness.checkPoint("toString");
        this.testToString(String.class, "java.lang.String", -6849794470754667710L);
        harness.checkPoint("forClass");
        this.testForClass(String.class, String.class);
        this.testForClass(Vector.class, new Vector().getClass());
        harness.checkPoint("getSerialVersionUID");
        this.testSUID(A.class, -4758524860474883287L);
        this.testSUID(B.class, -5709768504584827290L);
        this.testSUID(C.class, 7295418696978364872L);
        this.testSUID(Defined.class, 17L);
        this.testSUID(DefinedNotStatic.class, -4424277244062554359L);
        this.testSUID(DefinedNotFinal.class, -1176535035944461302L);
        this.testSUID(A[].class, 3317986791243421446L);
    }
}

