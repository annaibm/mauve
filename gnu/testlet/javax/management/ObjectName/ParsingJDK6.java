/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.management.ObjectName;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import javax.management.MalformedObjectNameException;
import javax.management.ObjectName;

public class ParsingJDK6
implements Testlet {
    @Override
    public void test(TestHarness h) {
        try {
            h.checkPoint("Match the FSF domain with specific keys and ? in value");
            ObjectName name2 = new ObjectName("fsf:library=Classpath,project=?NU");
            h.check(true);
            h.checkPoint("Match the FSF domain with specific keys and * in value");
            name2 = new ObjectName("fsf:library=Classpath,project=*");
            h.check(true);
            h.checkPoint("Match the FSF domain with specific keys and quoted * in value");
            name2 = new ObjectName("fsf:library=Classpath,project=\"*\"");
            h.check(true);
        }
        catch (MalformedObjectNameException e) {
            h.debug(e);
        }
    }
}

