package test.testables;

import annotations.Test;

@Test
public class SimpleClass2 {
    public Integer field1;
    private static String field2;

    public void methodThatShouldNotBeTested() throws Exception {
        throw new Exception("Don't test me!");
    }

    @Test
    public String methodWithUnsupportedParameters(Float arg1, int arg2) {
        return Float.toString(arg1 + arg2);
    }

}
