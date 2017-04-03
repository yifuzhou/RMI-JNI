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
//  jclass cls = (*env)->GetObjectClass(env, CmdObj);
//  jfieldID fid;
//  jint t;
//  jchar valid;
//  // get time and valid
//  t = time(NULL);
//  valid = '1';
//
//  // set object fields
//  fid = (*env)->GetFieldID(env, cls, "time", "I");
//  if (fid == 0) return CmdObj;
//  (*env)->SetIntField(env, CmdObj, fid, t);
//  fid = (*env)->GetFieldID(env, cls, "valid", "C");
//  if (fid == 0) return CmdObj;
//  (*env)->SetCharField(env, CmdObj, fid, valid);
//
//  return CmdObj;
    jclass cmdclass = (*env)->GetObjectClass(env,CmdObj);
    jfieldID fid_t = (*env)->GetFieldID(env, cmdclass,"time","I");
    jfieldID fid_c = (*env)->GetFieldID(env,cmdclass,"valid","C");
    
    if(fid1 == 0 || fid2 == 0)
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
            jchar valid= 'T';
            (*env)->SetCharField(env,CmdObj,fid_c, valid);
            (*env)->SetIntField(env, CmdObj, fid_t, t);
        }	 	
    }
    return CmdObj;
}

/*
* Class:     ClientImpl
* Method:    CGetLocalOS
* Signature: (Ljava/lang/Object;)Ljava/lang/Object;
*/
JNIEXPORT jobject JNICALL Java_ClientImpl_CGetLocalOS
(JNIEnv *env, jobject obj, jobject CmdObj) {
  jclass cls = (*env)->GetObjectClass(env, CmdObj);
  jfieldID fid;
  jstring os;
  jchar valid;

  os = (*env)->NewStringUTF(env, "Linux");
  valid = '1';

  fid = (*env)->GetFieldID(env, cls, "OS", "Ljava/lang/String;");
  if (fid == 0) return CmdObj;
  (*env)->SetObjectField(env, CmdObj, fid, os);

  fid = (*env)->GetFieldID(env, cls, "valid", "C");
  if (fid == 0) return CmdObj;
  (*env)->SetCharField(env, CmdObj, fid, valid);

  return CmdObj;
}
