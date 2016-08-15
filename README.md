# WebView
It is a guidline for how to use WebView and gif-drawable

Especially, gif-drawable is provided for this project in form of aar, which needs to make modification on build.gradle as follows.

repositories {  
    flatDir {  
        dirs 'libs'  
    }  
}  

dependencies {  
    compile fileTree(dir: 'libs', include: ['*.jar'])  
    testCompile 'junit:junit:4.12'  
    compile 'com.android.support:appcompat-v7:23.4.0'  
    compile(name:'android-gif-drawable-master-release', ext:'aar')  
}  
