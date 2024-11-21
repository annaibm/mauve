/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.security.cert.pkix.pkits;

import gnu.testlet.java.security.cert.pkix.pkits.BaseInvalidTest;

public class InvalidMissingbasicConstraintsTest1
extends BaseInvalidTest {
    public InvalidMissingbasicConstraintsTest1() {
        super(new String[]{"data/certs/InvalidMissingbasicConstraintsTest1EE.crt", "data/certs/MissingbasicConstraintsCACert.crt"}, new String[]{"data/crls/MissingbasicConstraintsCACRL.crl"});
    }
}

