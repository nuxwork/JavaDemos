#include <stdio.h>
#include <jni.h>

void JNICALL Java_com_swordy_demo_java_jni_HelloJni_sayHello
  (JNIEnv *env, jobject obj)
{
	printf("Hello JNI!");
}
