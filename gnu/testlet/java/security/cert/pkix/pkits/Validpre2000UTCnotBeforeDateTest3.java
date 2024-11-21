/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.security.cert.pkix.pkits;

import gnu.testlet.java.security.cert.pkix.pkits.BaseValidTest;

public class Validpre2000UTCnotBeforeDateTest3
extends BaseValidTest {
    public Validpre2000UTCnotBeforeDateTest3() {
        super(new String[]{"data/certs/Validpre2000UTCnotBeforeDateTest3EE.crt", "data/certs/GoodCACert.crt"}, new String[]{"data/crls/GoodCACRL.crl"});
    }
}

