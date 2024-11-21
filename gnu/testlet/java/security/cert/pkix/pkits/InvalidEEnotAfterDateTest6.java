/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.security.cert.pkix.pkits;

import gnu.testlet.java.security.cert.pkix.pkits.BaseInvalidTest;

public class InvalidEEnotAfterDateTest6
extends BaseInvalidTest {
    public InvalidEEnotAfterDateTest6() {
        super(new String[]{"data/certs/InvalidEEnotAfterDateTest6EE.crt", "data/certs/GoodCACert.crt"}, new String[]{"data/crls/GoodCACRL.crl"});
    }
}

