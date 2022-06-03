import test.testers.JarTester;
import test.testers.SimpleTester;
import test.testers.SourceFileTester;


public class Main {
    public static void main(String[] args) {
        try {
            //Compulsory
          SimpleTester tester = new SimpleTester("C:\\Users\\Alin\\Desktop\\lab12\\src\\main\\java", "test.testables.SimpleClass");
          tester.extractInformation();
          tester.invokeStaticMethods();



            JarTester jarTester = new JarTester("C:\\Users\\Alin\\Desktop\\lab12\\out\\artifacts\\lab12_jar\\lab12.jar");
            jarTester.createPrototype();
            jarTester.test();




            //  BONUS .java file

//            SourceFileTester sourceFileTester = new SourceFileTester(
//                    "C:\\Users\\Alin\\Desktop\\lab12\\src\\main\\java",
//                    "test\\testables\\SimpleClass.java");
//
//            sourceFileTester.extractInformation();



        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
