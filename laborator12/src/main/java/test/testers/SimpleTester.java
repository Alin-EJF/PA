package test.testers;

import annotations.Test;

import java.io.File;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;

//compulsory

public class SimpleTester {
    private final Class<?> testedClass;

     //The input will be a .class file, located anywhere in the file system.
     //Load the specified class in memory, identifying dynamically its package.

    public SimpleTester(String classPath, String className) throws MalformedURLException, ClassNotFoundException {
        File file = new File(classPath);
        //Constructs a URL from this URI
        URL url = file.toURI().toURL();

        ClassLoader classLoader = new URLClassLoader(new URL[]{url});
        testedClass = classLoader.loadClass(className);
    }


      //Using reflection, extract as many information about the class (at least its methods).


    public void extractInformation() {
        System.out.println("Name: " + testedClass.getName());
        System.out.println("Package: " + testedClass.getPackage());

        Method[] methods = testedClass.getDeclaredMethods();
        System.out.print("Methods: ");
        for (Method method : methods)
            System.out.print(method.getName() + " ");
        System.out.println();

        Field[] fields = testedClass.getDeclaredFields();
        System.out.print("Fields: ");
        for (Field field : fields)
            System.out.print(field.getName() + " ");
        System.out.println();
    }


     //Using reflection, invoke the static methods, with no arguments, annotated with @Test


    public void invokeStaticMethods() throws InvocationTargetException, IllegalAccessException {
        for (Method method : testedClass.getMethods()) {
            if (method.isAnnotationPresent(Test.class)) {
                if (Modifier.isStatic(method.getModifiers())) {
                    method.invoke(null);
                }
            }
        }
    }
}
