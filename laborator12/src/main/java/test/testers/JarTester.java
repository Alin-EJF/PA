package test.testers;


import annotations.Efficiency;
import annotations.Reliability;
import annotations.Test;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.*;
import java.util.concurrent.ThreadLocalRandom;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;
import java.lang.reflect.*;

import org.apache.commons.lang3.RandomStringUtils;

public class JarTester {
    static public int NO_OF_RELIABILITY_TESTS = 100;
    static public int MAX_RUNTIME_NANOSECONDS = (int)1e9;
    private List<Class<?>> classes = new ArrayList<>();
    private ClassLoader classLoader;
    private String classPath;
    private int passedTests = 0;
    private int failedTests = 0;


     // Checks if the input is a folder (containing .class files) or a .jar

    public JarTester(String classPath) throws IOException, ClassNotFoundException {
        this.classPath = classPath;
        if (classPath.endsWith(".jar"))
            loadClassesFromJar();
        else {
            if (!classPath.endsWith("\\"))
                this.classPath = classPath + "\\";
            loadClassesFromFolder();
        }
    }


    private void loadClassesFromFolder() throws MalformedURLException, ClassNotFoundException {
        URL url = new File(classPath).toURI().toURL();
        classLoader = new URLClassLoader(new URL[]{url});

        File directory = new File(classPath);
        //Returns an array of abstract pathnames denoting the files in the directory denoted by this abstract pathname
        getClasses(directory.listFiles());
    }

    private void loadClassesFromJar() throws IOException, ClassNotFoundException {
        JarFile jarFile = new JarFile(classPath);
        //Returns an enumeration of the jar file entries
        Enumeration<JarEntry> entries = jarFile.entries();

        URL[] urls = {new URL("jar:file:" + classPath + "!/")};
        classLoader = URLClassLoader.newInstance(urls);

        List<File> files = new ArrayList<>();
        while (entries.hasMoreElements()) {
            JarEntry jarEntry = entries.nextElement();
            if (jarEntry.isDirectory() || !jarEntry.getName().endsWith(".class"))
                continue;

            classes.add(classLoader.loadClass(jarEntry.getName()
                    .replace(".class", "").replace("/", ".")));
        }
    }

    private void getClasses(File[] files) throws ClassNotFoundException {
        if (files == null)
            return;

        for (File file : files) {
            if (file.isDirectory())
                getClasses(file.listFiles());
            else if (file.getName().endsWith(".class")) {
                String className = file.getAbsolutePath().replace(classPath, "")
                        .replace("\\", ".").replace(".class", "");
                classes.add(classLoader.loadClass(className));
            }
        }
    }
    // General Information (file structure, classpath, how classes are found, changes)
    public void createPrototype() {
        for (Class<?> testedClass : classes) {
            //Returns true if this Class object represents an annotation interface.
            if (testedClass.isAnnotation())
                System.out.print("public @interface ");
            else {
                // access modifier of the class
                int modifiers = testedClass.getModifiers();
                switch (modifiers) {
                    case Modifier.PRIVATE:
                        System.out.print("private ");
                        break;

                    case Modifier.PUBLIC:
                        System.out.print("public ");
                        break;

                    case Modifier.PROTECTED:
                        System.out.print("protected ");
                        break;

                    default:
                        System.out.print("other access modifier ");
                }

                switch (modifiers) {
                    case Modifier.ABSTRACT:
                        System.out.print("abstract class ");
                        break;

                    case Modifier.INTERFACE:
                        System.out.println("interface ");
                        break;

                    default:
                        System.out.println("class ");
                }
            }

            // get information about the class, like name, fields, methods and their modifiers
            System.out.println(testedClass.getName());
            for (Field field : testedClass.getFields())
                System.out.println(field);
            for (Method method : testedClass.getMethods()) {
                if (!Modifier.isNative(method.getModifiers()))
                    System.out.println(method);
            }
            System.out.println();
        }
    }


    public void test() {
        for (Class<?> testedClass : classes) {
            // just classes with @Test annotation
            if (!testedClass.isAnnotationPresent(Test.class)) {
                continue;
            }

            System.out.println("========Testing class " + testedClass.getName() + "========");

            for (Method method : testedClass.getMethods()) {
                // just methods with @Test annotation
                if (!method.isAnnotationPresent(Test.class))
                    continue;

                System.out.println("Testing " + method.getName());

                //mock values
                Optional<Object[]> optionalParameterValues = randomizeParameters(method);
                if (!optionalParameterValues.isPresent())
                    continue;
                Object[] parameterValues = optionalParameterValues.get();

                try {
                    Object instance = Modifier.isStatic(method.getModifiers()) ? null : testedClass.getDeclaredConstructor().newInstance();

                    // verify if the method is efficient
                    long start = System.nanoTime();
                    method.invoke(instance, parameterValues);
                    long end = System.nanoTime();

                    if (method.isAnnotationPresent(Efficiency.class) && (end - start) >= MAX_RUNTIME_NANOSECONDS)
                        throw new Exception("Method execution time > " + MAX_RUNTIME_NANOSECONDS/1e9 + " second(s)!");

                    // verify if the method is reliable
                    if (method.isAnnotationPresent(Reliability.class)) {
                        for (int i = 0; i < NO_OF_RELIABILITY_TESTS; i++) {
                            parameterValues = randomizeParameters(method).orElseThrow(IllegalArgumentException::new);
                            method.invoke(instance, parameterValues);
                        }
                    }

                    System.out.println("Passed!");
                    passedTests++;
                } catch (Exception e) {
                    System.out.println("Failed! Cause: " + (e.getCause() != null ? e.getCause() : e.getMessage()));
                    failedTests++;
                }
            }
        }

        System.out.println("Done!");
        System.out.println("Passed " + passedTests + " and failed " + failedTests);
    }


     // Generate mock values for method

    private Optional<Object[]> randomizeParameters(Method method) {
        Class<?>[] parameterTypes = method.getParameterTypes();
        Object[] parameterValues = new Object[parameterTypes.length];

        for (int i = 0; i < parameterTypes.length; i++) {
            if (parameterTypes[i] == int.class || parameterTypes[i] == Integer.class)
                parameterValues[i] = ThreadLocalRandom.current().nextInt();
            else if (parameterTypes[i] == String.class)
                parameterValues[i] = RandomStringUtils.randomAlphanumeric(10);
            else {
                System.out.println("Error testing " + method.getName() + ": unsupported parameter type " + parameterTypes[i].getName());
                return Optional.empty();
            }
        }

        return Optional.of(parameterValues);
    }
}
