package com.swordy.demo.java.lang;

public class HashCode1
{
    private static final String TAG = "JavaDemos.HashCode1";
    
    public static void main(String[] args)
    {
        System.out.println("Objetc的hashCode都不一样");
        System.out.println("obj1 hashCode = " + new Object().hashCode());
        System.out.println("obj2 hashCode = " + new Object().hashCode());
        
        System.out.println("其他数据类得hashCode跟内容有关");
        System.out.println("1 hashCode = " + new Integer(1).hashCode());
        System.out.println("-1 hashCode = " + new Integer(-1).hashCode());
        System.out.println("1.01 hashCode = " + new Float(1.01).hashCode());
        System.out.println("hello hashCode = " + "hello".hashCode());
        System.out.println("hello hashCode = " + "hello".hashCode());
    }
}
