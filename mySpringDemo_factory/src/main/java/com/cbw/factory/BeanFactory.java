package com.cbw.factory;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/**
 * 创建bean对象的工厂
 * Bean：在计算机英语中，有可重用组件的含义
 * JavaBean：使用java语言编写的可重用组件
 *
 */
public class BeanFactory {
    /**
     * 定义一个properties对象
     */
    private static Properties props;
    /**
     * 定义一个map对象，用于存放我们要创建的对象， 我们称之为容器
     */
    private static Map<String,Object> beans;

    static {
       try {
           //实例化对象
           props = new Properties();
           //获取properties文件的流对象
           InputStream in = BeanFactory.class.getClassLoader().getResourceAsStream("bean.properties");
           props.load(in);
           //实例化容器
           beans = new HashMap<String, Object>();
           //取出配置文件中所有的key
           Enumeration<Object> keys = props.keys();
           //遍历枚举
           while (keys.hasMoreElements()){
               //取出每个key
               String key = keys.nextElement().toString();
               //根据key获取value
               String beanPath = props.getProperty(key);
               //反射创建对象
               Object value = Class.forName(beanPath).newInstance();
               //将key和value存入容器
               beans.put(key,value);
           }
       }catch (Exception e){
               throw new ExceptionInInitializerError("初始化Properties失败");
       }
    }

    /**
     * 根据bean的名称获取对象， 这个是直接从容器中获取
     * @param beanName
     * @return
     */
    public static Object getBean(String beanName){
        return beans.get(beanName);
    }
    /**
     * 根据bean的名称，获取bean对象
     * @param beanName
     * @return
     */
    /*public static Object getBean(String beanName){
            Object bean = null;

            String beanPath = props.getProperty(beanName);
        try {
            bean = Class.forName(beanPath).newInstance();//每次都通过调用类的默认构造方法实例化一个新对象
        } catch (Exception e) {
            e.printStackTrace();
        }

        return bean;
    }*/
}
