package test.testers;

import javax.tools.JavaCompiler;
import javax.tools.ToolProvider;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;

public class SourceFileTester {
    private final Class<?> clazz;

    public SourceFileTester(String classPath, String className) throws MalformedURLException, ClassNotFoundException {
        File root = new File(classPath);
        File sourceFile = new File(root, className);

        JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();
        compiler.run(null, null, null, sourceFile.getPath()); //use system default

        URLClassLoader classLoader = URLClassLoader.newInstance(new URL[]{root.toURI().toURL()});
        clazz = classLoader.loadClass(className.replace(".java", "").replace("\\", "."));
    }

    public void extractInformation() {
        System.out.println(clazz.getName());
        System.out.println(clazz.getPackage());
    }
}
