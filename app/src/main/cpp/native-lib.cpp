#include <jni.h>
#include <string>
#include "json.hpp"

using json = nlohmann::json;
extern "C" JNIEXPORT jstring JNICALL
Java_com_kondaurov_ndktest_MainActivity_stringFromJNI(
        JNIEnv* env,
        jobject /* this */) {
    std::string hello = "Hello from C++";
    return env->NewStringUTF(hello.c_str());
}