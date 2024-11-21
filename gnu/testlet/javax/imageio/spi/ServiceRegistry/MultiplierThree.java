/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.imageio.spi.ServiceRegistry;

import gnu.testlet.javax.imageio.spi.ServiceRegistry.MultiplicationService;

public class MultiplierThree
implements MultiplicationService {
    @Override
    public String getName() {
        return "MultiplierThree";
    }

    @Override
    public int multiply(int op1, int op2) {
        return op1 * op2;
    }
}

