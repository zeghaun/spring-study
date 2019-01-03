package com.spring.common.hotswap;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Method;
import java.util.HashSet;
import java.util.concurrent.TimeUnit;

/**
 * @author zhenghuan (zhenghuan@duiba.com.cn)
 * @date 2019/1/3 0003 14:32
 */
public class HotswapCL extends ClassLoader {
    // 需要该类加载器直接加载的类文件的基目录
    private String basedir;
    // 需要由该类加载器直接加载的类名
    private HashSet dynaclazns;

    public HotswapCL(String basedir, String[] clazns) {
        super(null); // 指定父类加载器为 null
        this.basedir = basedir;
        dynaclazns = new HashSet();
        loadClassByMe(clazns);
    }

    private void loadClassByMe(String[] clazns) {
        for (int i = 0; i < clazns.length; i++) {
            loadDirectly(clazns[i]);
            dynaclazns.add(clazns[i]);
        }
    }

    private Class loadDirectly(String name) {
        Class cls = null;
        StringBuffer sb = new StringBuffer(basedir);
        String classname = name.replace('.', File.separatorChar) + ".class";
        sb.append(File.separator).append(classname);
        File classF = new File(sb.toString());
        try {
            cls = instantiateClass(name, new FileInputStream(classF),
                    classF.length());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return cls;
    }

    private Class instantiateClass(String name, InputStream fin, long len) {
        byte[] raw = new byte[(int) len];
        try {
            fin.read(raw);
            fin.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return defineClass(name, raw, 0, raw.length);
    }

    @Override
    protected Class loadClass(String name, boolean resolve)
            throws ClassNotFoundException {
        Class cls = null;
        cls = findLoadedClass(name);
        if (!this.dynaclazns.contains(name) && cls == null) {
            cls = getSystemClassLoader().loadClass(name);
        }
        if (cls == null) {
            throw new ClassNotFoundException(name);
        }
        if (resolve) {
            resolveClass(cls);
        }
        return cls;
    }
    public static void main(String[] args) {
        new Thread(() -> {
            while (true) {
                try {
                    // 每次都创建出一个新的类加载器
                    HotswapCL cl = new HotswapCL("D:\\ideaspace\\spring-study\\target\\classes", new String[]{"com.spring.common.hotswap.Foo"});

                    Class cls = cl.loadClass("com.spring.common.hotswap.Foo");
                    Object foo = cls.newInstance();

                    Method m = foo.getClass().getMethod("sayHello", new Class[]{});
                    m.invoke(foo);

                } catch (Exception ex) {
                    ex.printStackTrace();
                }

                try {
                    TimeUnit.SECONDS.sleep(6L);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

        }).start();
    }
}