package com.swordy.demo.java.jni;

/**
 * 通过JNI调用使得Java访问C代码
 * 
 * <li><b>1. 编写native方法，暂不做任何调用;</b></li></br>
 * <li><b>2. 编译出class文件;</b></li></br>
 * <li><b>3. 使用javah生成对应的*.h头文件：</b></li></br>
 * 	javah com.swordy.demo.java.jni.JNI1$JNI1_Native</br>
 * <li><b>4. 创建对应的*.c文件，并使用gcc进行编译：</b></li></br>
 * 		gcc -I%JAVA_HOME%\include -I%JAVA_HOME%\include\win32\ -shared -Wl,-kill-at -o jni1.dll 
 * 			com_swordy_demo_java_jni_JNI1_JNI1_Native.c<br>
 * 		error: unknown type name ‘__int64’ : <br>
 * 		resolution: typedef long long jlong;
 * 
 * <li><b>5. jni基本类型对照表</b></li></br>
 * <table border="1" cellpadding="2" >
 * 		<tr><th>Java类型</th><th>本地C类型</th><th>实际表示的C类型Win32</th><th>说明</th></tr>
 * 		<tr><td>boolean</td><td>jboolean</td><td>unsigned char</td><td>无符号，8 位</td></tr>
 * 		<tr><td>byte</td><td>jbyte</td><td>signed char</td><td>有符号，8 位</td></tr>
 *	 	<tr><td>char</td><td>jchar</td><td>unsigned short</td><td>无符号，16 位</td></tr>
 *	 	<tr><td>short</td><td>jshort</td><td>short</td><td>有符号，16 位</td></tr>
 * 	 	<tr><td>int</td><td>jint</td><td>long</td><td>有符号，32 位</td></tr>
 *	 	<tr><td>long</td><td>jlong</td><td>__int64</td><td>有符号，64 位</td></tr>
 *	 	<tr><td>float</td><td>jfloat</td><td>float</td><td>32 位</td></tr>
 *	 	<tr><td>double</td><td>jdouble</td><td>double</td><td>64 位</td></tr>
 *	 	<tr><td>void</td><td>void</td><td>N/A</td><td>N/A</td></tr>
 *	 </table>
 * 
 * 
 * @author swordy
 *
 */
public class HelloJni {
	
	static {
		System.loadLibrary("hello-jni");
		System.out.println("load finish");
	}
	
	public native void sayHello();
}
