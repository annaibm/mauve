/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.runner.compare;

class EvolutionType {
    public static final EvolutionType REGRESSION = new EvolutionType("REGRESSION", 0);
    public static final EvolutionType PROGRESSION = new EvolutionType("PROGRESSION", 1);
    public static final EvolutionType STAGNATION = new EvolutionType("STAGNATION", 2);
    private static final EvolutionType[] VALUES = new EvolutionType[]{REGRESSION, PROGRESSION, STAGNATION};
    private final int ordinal;
    private final String name;

    public static final EvolutionType[] values() {
        return VALUES;
    }

    private EvolutionType(String name2, int ordinal) {
        this.name = name2;
        this.ordinal = ordinal;
    }

    public final int ordinal() {
        return this.ordinal;
    }

    public String toString() {
        return this.name;
    }
}

