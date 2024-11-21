/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.swing.text.html.parser.Entity;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import javax.swing.text.html.parser.Element;
import javax.swing.text.html.parser.Entity;

public class Entity_Test
implements Testlet {
    private Element element;
    TestHarness harness;

    @Override
    public void test(TestHarness a_harness) {
        this.harness = a_harness;
        try {
            this.testName2type();
            this.testPublicSystemGeneralParameter();
            this.element = null;
        }
        catch (Throwable exc) {
            exc.printStackTrace();
            if (exc != null) {
                this.harness.fail(exc.getClass().getName() + ":" + exc.getMessage());
            }
            this.harness.fail("exception");
        }
    }

    public void testName2type() {
        this.harness.check(Entity.name2type("PUBLIC"), 10, "PUBLIC");
        this.harness.check(Entity.name2type("SDATA"), 11, "SDATA");
        this.harness.check(Entity.name2type("PI"), 12, "PI");
        this.harness.check(Entity.name2type("STARTTAG"), 13, "STARTTAG");
        this.harness.check(Entity.name2type("ENDTAG"), 14, "ENDTAG");
        this.harness.check(Entity.name2type("MS"), 15, "MS");
        this.harness.check(Entity.name2type("MD"), 16, "MD");
        this.harness.check(Entity.name2type("SYSTEM"), 17, "SYSTEM");
        this.harness.check(Entity.name2type("audrius"), 1, "surely unknown ");
    }

    public void testPublicSystemGeneralParameter() {
        int[] pu_sy = new int[]{10, 17, 0};
        int[] gen_par = new int[]{65536, 262144, 0};
        for (int ps = 0; ps < pu_sy.length; ++ps) {
            for (int gp = 0; gp < gen_par.length; ++gp) {
                Entity e = new Entity(null, 0, null);
                e.type = pu_sy[ps] | gen_par[gp];
                this.harness.check(e.isGeneral(), gen_par[gp] == 65536);
                this.harness.check(e.isParameter(), gen_par[gp] == 262144);
                this.harness.check((e.type & 0x11) != 0, pu_sy[ps] == 17);
                this.harness.check((e.type & 0xA) != 0, pu_sy[ps] == 10);
                this.harness.check((e.type & 0x10000) != 0, gen_par[gp] == 65536);
                this.harness.check((e.type & 0x40000) != 0, gen_par[gp] == 262144);
            }
        }
    }
}

