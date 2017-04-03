#include <jni.h>
#include "ClientImpl.h"
#include <stdio.h>
#include <stdlib.h>
#include <time.h>


/*
* Class:     ClientImpl
* Method:    CGetLocalTime
* Signature: (Ljava/lang/Object;)Ljava/lang/Object;
*/
JNIEXPORT jobject JNICALL Java_ClientImpl_CGetLocalTime(JNIEnv *env, jobject obj, jobject CmdObj) {

    jclass cmdclass = (*env)->GetObjectClass(env,CmdObj);
    jfieldID fid_t = (*env)->GetFieldID(env, cmdclass,"time","I");
    jfieldID fid_c = (*env)->GetFieldID(env,cmdclass,"valid","C");
    
    if(fid_t == 0 || fid_c == 0)
        return CmdObj;
    else
    {
        jint t = time(NULL);
        if(t<0)
        {
            return CmdObj;
        }
        else
        {
            jchar v= 'T';
            (*env)->SetCharField(env,CmdObj,fid_c, v);
            (*env)->SetIntField(env, CmdObj, fid_t, t);
        }	 	
    }
    return CmdObj;
}

/*
* Class:     ClientImpl
* Method:    CGetVersion
* Signature: (Ljava/lang/Object;)Ljava/lang/Object;
*/
JNIEXPORT jobject JNICALL Java_ClientImpl_CGetVersion(JNIEnv *env, jobject obj, jobject CmdObj) {
  jclass cmdclass = (*env)->GetObjectClass(env, CmdObj);
  jfieldID fid;
    fid = (*env)->GetFieldID(env,cmdclass,"version","I");
    if(fid == NULL)
    {
        return CmdObj;
    }
    else
    {
        jint Ver = 10086;
        (*env)->SetIntField(env,CmdObj,fid,Ver);
    }
   
  return CmdObj;
}
