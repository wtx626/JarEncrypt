package com.wtx;

import org.xeustechnologies.jcl.JarClassLoader;

import java.io.FileInputStream;
import java.lang.reflect.Method;

public class JCLMainTest {

    public static void main(String[] args) throws Exception {
        JarClassLoader jcl = new JarClassLoader();
        jcl.add(new FileInputStream(System.getProperty("user.dir")+"\\Example\\jardemo.jar"));

        Class clasz=jcl.loadClass("com.monkey.demo.App");
        Class mainArgs[] = { (new java.lang.String[1]).getClass() };
        Method main = clasz.getMethod("main", mainArgs);
        // 创建一个包含main()方法参数的数组
        Object argsArray[] = { args };
        // 调用main()
        main.invoke(null, argsArray);

    }
}
