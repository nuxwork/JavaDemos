package com.swordy.demo.java.lang;

/**
 * 1. 代码中所有的常量值运算都会在编译的时候计算成最终值。
 * 
 * @author swordy
 * @email mryangjian@live.com
 * @since Jan 20, 2014
 * @version 1.0
 */
public class Javac1
{
	public static void main(String[] args)
	{
		/*
		 * 代码中所有的常量值运算都会在编译的时候计算成最终值。
		 * 即a=2*2和b=4的执行效率是一样的。
		 */
		
		int a = 2 * 2;
		int b = 4;
		int c = a + b;
		
		String str1 = "hello";
		String str2 = ",world";
		String str3 = "hello" + ", world";
		String str4 = str1 + str2;
	}
}


/*
 * 以下是反编译Javac1.class后的代码：
 
public class Javac1
{
  public static void main(String[] args)
  {
    int a = 4;
    int b = 4;
    int c = a + b;

    String str1 = "hello";
    String str2 = ",world";
    String str3 = "hello, world";
    String str4 = str1 + str2;
  }
}

*/
