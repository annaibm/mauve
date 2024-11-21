/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.security.cert.pkix.pkits;

import gnu.testlet.java.security.cert.pkix.pkits.BaseInvalidTest;

public class InvalidEEnotBeforeDateTest2
extends BaseInvalidTest {
    public InvalidEEnotBeforeDateTest2() {
        super(new String[]{"data/certs/InvalidEEnotBeforeDateTest2EE.crt", "data/certs/GoodCACert.crt"}, new String[]{"data/crls/GoodCACRL.crl"});
    }
}

