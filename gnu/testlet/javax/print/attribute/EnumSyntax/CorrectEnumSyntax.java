/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.print.attribute.EnumSyntax;

import javax.print.attribute.EnumSyntax;

public class CorrectEnumSyntax
extends EnumSyntax {
    public static final CorrectEnumSyntax TEST1 = new CorrectEnumSyntax(3);
    public static final CorrectEnumSyntax TEST2 = new CorrectEnumSyntax(4);
    public static final CorrectEnumSyntax TEST3 = new CorrectEnumSyntax(5);
    private static final String[] stringTable = new String[]{"test1", "test2", "test3"};
    private static final CorrectEnumSyntax[] enumValueTable = new CorrectEnumSyntax[]{TEST1, TEST2, TEST3};

    protected CorrectEnumSyntax(int value2) {
        super(value2);
    }

    @Override
    protected int getOffset() {
        return 3;
    }

    @Override
    protected String[] getStringTable() {
        return stringTable;
    }

    @Override
    protected EnumSyntax[] getEnumValueTable() {
        return enumValueTable;
    }
}

