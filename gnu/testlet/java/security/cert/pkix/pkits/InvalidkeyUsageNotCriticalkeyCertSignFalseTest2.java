/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.security.cert.pkix.pkits;

import gnu.testlet.java.security.cert.pkix.pkits.BaseInvalidTest;

public class InvalidkeyUsageNotCriticalkeyCertSignFalseTest2
extends BaseInvalidTest {
    public InvalidkeyUsageNotCriticalkeyCertSignFalseTest2() {
        super(new String[]{"data/certs/InvalidkeyUsageNotCriticalkeyCertSignFalseTest2EE.crt", "data/certs/keyUsageNotCriticalkeyCertSignFalseCACert.crt"}, new String[]{"data/crls/keyUsageNotCriticalkeyCertSignFalseCACRL.crl"});
    }
}

