/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.management.ObjectName;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import javax.management.MalformedObjectNameException;
import javax.management.ObjectName;

public class applyJDK6
implements Testlet {
    private String[] domains = new String[]{"mauve", "m?uve", "*ve", "*au*", "m?*e", "mauv?", "m*v*", "*"};
    private String[] properties = new String[]{"foo=b?r", "foo=b?r,spam=eggs", "spam=eggs,foo=b?r", "foo=b?r,*", "foo=b*", "foo=b*,spam=eggs", "spam=eggs,foo=b*", "foo=b*,*", "foo=\"b?r\"", "foo=\"b?r\",spam=eggs", "spam=eggs,foo=\"b?r\"", "foo=\"b?r\",*", "foo=\"b*\"", "foo=\"b*\",spam=eggs", "spam=eggs,foo=\"b*\"", "foo=\"b*\",*"};

    private boolean domainMatches(String a, String b) {
        return !b.contains("?") && !b.contains("*");
    }

    private boolean propertyMatches(String a, String b) {
        if (b.contains("*") || b.contains("?")) {
            return false;
        }
        if (a.contains("*") || a.contains("?")) {
            return true;
        }
        return a.length() == b.length();
    }

    @Override
    public void test(TestHarness harness) {
        for (int ida = 0; ida < this.domains.length; ++ida) {
            for (int idb = 0; idb < this.domains.length; ++idb) {
                for (int ipa = 0; ipa < this.properties.length; ++ipa) {
                    for (int ipb = 0; ipb < this.properties.length; ++ipb) {
                        String da = this.domains[ida];
                        String db = this.domains[idb];
                        boolean dm = this.domainMatches(da, db);
                        String pa = this.properties[ipa];
                        String pb = this.properties[ipb];
                        boolean pm = this.propertyMatches(pa, pb);
                        String sa = da + ":" + pa;
                        String sb = db + ":" + pb;
                        boolean expect = dm && pm;
                        try {
                            ObjectName ona = new ObjectName(sa);
                            ObjectName onb = new ObjectName(sb);
                            harness.check(ona.apply(onb) == expect, sa + " should" + (expect ? "" : " not") + " match " + sb);
                            continue;
                        }
                        catch (MalformedObjectNameException e) {
                            harness.check(false);
                            harness.debug(e);
                        }
                    }
                }
            }
        }
    }
}

