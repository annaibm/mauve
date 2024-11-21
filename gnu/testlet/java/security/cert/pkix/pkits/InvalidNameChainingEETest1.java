/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.security.cert.pkix.pkits;

import gnu.testlet.java.security.cert.pkix.pkits.BaseInvalidTest;

public class InvalidNameChainingEETest1
extends BaseInvalidTest {
    public InvalidNameChainingEETest1() {
        super(new String[]{"data/certs/InvalidNameChainingTest1EE.crt", "data/certs/GoodCACert.crt"}, new String[]{"data/crls/GoodCACRL.crl"});
    }
}

