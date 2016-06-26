/**
 * @copyright Copyright 1999-2015 © 99.com All rights reserved.
 * @license http://www.99.com/about
 */
package com.spring.common.utils;

import java.beans.BeanInfo;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class ObjectUtil {

    /**
     * @param o
     * @return
     * @throws IllegalArgumentException
     */
    public static boolean isEmpty(Object o) throws IllegalArgumentException {
        if (o == null) return true;
        if (o instanceof String) {
            return (o.toString().trim().length() == 0) || "null".equalsIgnoreCase(o.toString());
        } else if (o instanceof Collection) {
            if (((Collection) o).isEmpty()) {
                return true;
            }
        } else if (o.getClass().isArray()) {
            if (Array.getLength(o) == 0) {
                return true;
            }
        } else if (o instanceof Map) {
            if (((Map) o).isEmpty()) {
                return true;
            }
        } else {
            return false;
        }

        return false;
    }

    /**
     * Map,Collection,String,Array
     *
     * @param o
     * @return
     */
    public static boolean isNotEmpty(Object o) {
        return !isEmpty(o);
    }

    /**
     * @param list
     * @return
     */
    public static Object mergeObject(List<?> list) {
        if (list == null) return null;
        Object object = null;
        try {
            object = list.get(0).getClass().newInstance();
            Field[] fs = object.getClass().getDeclaredFields();
            for (Object o : list) {
                for (int i = 0; i < fs.length; i++) {
                    fs[i].setAccessible(true);
                    if (fs[i].getType().isAssignableFrom(int.class) || fs[i].getType().isAssignableFrom(Integer.class)) {
                        if ((Integer) fs[i].get(object) == null) {
                            fs[i].set(object, (Integer) fs[i].get(o));
                        } else if ((Integer) fs[i].get(o) == null) {
                            fs[i].set(object, (Integer) fs[i].get(object));
                        } else {
                            fs[i].set(object, (Integer) fs[i].get(object) + (Integer) fs[i].get(o));
                        }
                    } else if (fs[i].getType().isAssignableFrom(String.class)) {
                        if ((String) fs[i].get(object) == null) {
                            fs[i].set(object, (String) fs[i].get(o));
                        } else if ((String) fs[i].get(o) == null) {
                            fs[i].set(object, (String) fs[i].get(object));
                        } else {
                            fs[i].set(object, (String) fs[i].get(object) + (String) fs[i].get(o));
                        }
                    } else if (fs[i].getType().isAssignableFrom(Byte.class)) {
                        if ((Byte) fs[i].get(object) == null) {
                            fs[i].set(object, (Byte) fs[i].get(o));
                        } else if ((Byte) fs[i].get(o) == null) {
                            fs[i].set(object, (Byte) fs[i].get(object));
                        } else {
                            fs[i].set(object, (byte) ((Integer) ((Byte) fs[i].get(object) & 0xff) + (Integer) ((Byte) fs[i].get(o) & 0xff)));
                        }
                    } else {
                        //System.out.println("璇峰畾涔夊悎骞剁被鍨嬬殑鍚堝苟鏂规硶:"+fs[i].getType());
                    }
                    fs[i].setAccessible(false);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return object;
    }

    public static Object deepCopyObject(Object that) throws Exception {
        // 将该对象序列化成流,因为写在流里的是对象的一个拷贝，而原对象仍然存在于JVM里面。所以利用这个特性可以实现对象的深拷贝
        ByteArrayOutputStream bos = new ByteArrayOutputStream();

        ObjectOutputStream oos = new ObjectOutputStream(bos);

        oos.writeObject(that);

        // 将流序列化成对象
        ByteArrayInputStream bis = new ByteArrayInputStream(bos.toByteArray());

        ObjectInputStream ois = new ObjectInputStream(bis);

        return ois.readObject();
    }

    /**
     * Bean --> Map 1: 利用Introspector和PropertyDescriptor 将Bean --> Map
     *
     * @param obj
     * @return
     */
    public static Map<String, Object> transBean2Map(Object obj) {

        if (obj == null) {
            return null;
        }
        Map<String, Object> map = new HashMap<String, Object>();
        try {
            BeanInfo beanInfo = Introspector.getBeanInfo(obj.getClass());
            PropertyDescriptor[] propertyDescriptors = beanInfo.getPropertyDescriptors();
            for (PropertyDescriptor property : propertyDescriptors) {
                String key = property.getName();

                // 过滤class属性
                if (!key.equals("class")) {
                    // 得到property对应的getter方法
                    Method getter = property.getReadMethod();
                    Object value = getter.invoke(obj);

                    map.put(camelToUnderline(key), value);
                }
            }
        } catch (Exception e) {
            System.out.println("transBean2Map Error " + e);
        }

        return map;
    }

    /**
     * Map --> Bean 1: 利用Introspector,PropertyDescriptor实现 Map --> Bean
     *
     * @param map
     * @param obj
     */
    public static void transMap2Bean(Map<String, Object> map, Object obj) {
        try {
            BeanInfo beanInfo = Introspector.getBeanInfo(obj.getClass());
            PropertyDescriptor[] propertyDescriptors = beanInfo.getPropertyDescriptors();

            for (PropertyDescriptor property : propertyDescriptors) {
                String key = camelToUnderline(property.getName());

                if (map.containsKey(key)) {
                    Object value = map.get(key);
                    // 得到property对应的setter方法
                    Method setter = property.getWriteMethod();
                    setter.invoke(obj, value);
                }
            }
        } catch (Exception e) {
            System.out.println("transMap2Bean Error " + e);
        }
        return;
    }

    /**
     * java对象转Map
     *
     * @param obj
     * @return
     */
    public static Map convertObject2Map(Object obj) {
        Map<String, Object> reMap = new HashMap<>();
        if (obj == null)
            return null;
        Field[] fields = obj.getClass().getDeclaredFields();
        try {
            for (int i = 0; i < fields.length; i++) {
                try {
                    Field f = obj.getClass().getDeclaredField(fields[i].getName());
                    f.setAccessible(true);
                    Object o = f.get(obj);
                    reMap.put(fields[i].getName(), o);
                } catch (NoSuchFieldException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                } catch (IllegalArgumentException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                } catch (IllegalAccessException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        } catch (SecurityException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return reMap;
    }

    public static String camelToUnderline(String param) {
        if (param == null || "".equals(param.trim())) {
            return "";
        }
        int len = param.length();
        StringBuilder sb = new StringBuilder(len);
        for (int i = 0; i < len; i++) {
            char c = param.charAt(i);
            if (Character.isUpperCase(c)) {
                sb.append('_');
                sb.append(Character.toLowerCase(c));
            } else {
                sb.append(c);
            }
        }
        return sb.toString();
    }

    public static String underlineToCamel(String param) {
        if (param == null || "".equals(param.trim())) {
            return "";
        }
        int len = param.length();
        StringBuilder sb = new StringBuilder(len);
        for (int i = 0; i < len; i++) {
            char c = param.charAt(i);
            if (c == '_') {
                if (++i < len) {
                    sb.append(Character.toUpperCase(param.charAt(i)));
                }
            } else {
                sb.append(c);
            }
        }
        return sb.toString();
    }
}
