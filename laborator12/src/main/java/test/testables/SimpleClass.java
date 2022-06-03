package test.testables;

import annotations.Efficiency;
import annotations.Reliability;
import annotations.Test;

import java.util.concurrent.ThreadLocalRandom;

@Test
public class SimpleClass {

    private String testString;

    public SimpleClass() {
    }

    public SimpleClass(String testString) {
        this.testString = testString;
    }

    public String getTestString() {
        return testString;
    }

    public void setTestString(String testString) {
        this.testString = testString;
    }

    @Test
    static public int staticIntTestNoArgs() {
        System.out.println("test print");
        return 100;
    }

    @Test
    public int methodWithArgs(int arg1, String arg2, int arg3) {
        return arg1 + arg3 + arg2.length();
    }

    @Test
    public void methodWhichThrows(int arg1, Integer arg2) throws Exception {
        throw new Exception("intentional exception");
    }

    @Test
    @Efficiency
    public void methodThatSleeps(Integer arg1) throws InterruptedException {
        Thread.sleep(1000);
    }

    @Test
    @Reliability
    public int reliableMethod(int arg1, int arg2) {
        return arg1 + arg2;
    }

    @Test
    @Reliability
    public int unreliableMethod(int arg1, int arg2) throws Exception {
        if(ThreadLocalRandom.current().nextInt(0, 10) == 0) //sunt sanse sa declansese exceptia
            throw new Exception("Random crash!");
        return arg1 + arg2;
    }
}
