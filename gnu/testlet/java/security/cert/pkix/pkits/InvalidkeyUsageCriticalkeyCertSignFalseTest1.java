/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.security.cert.pkix.pkits;

import gnu.testlet.java.security.cert.pkix.pkits.BaseInvalidTest;

public class InvalidkeyUsageCriticalkeyCertSignFalseTest1
extends BaseInvalidTest {
    public InvalidkeyUsageCriticalkeyCertSignFalseTest1() {
        super(new String[]{"data/certs/InvalidkeyUsageCriticalkeyCertSignFalseTest1EE.crt", "data/certs/keyUsageCriticalkeyCertSignFalseCACert.crt"}, new String[]{"data/crls/keyUsageCriticalkeyCertSignFalseCACRL.crl"});
    }
}

