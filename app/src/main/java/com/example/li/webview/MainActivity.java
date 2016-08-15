package com.example.li.webview;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.webkit.JavascriptInterface;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.Toast;

import java.io.ByteArrayOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;

public class MainActivity extends AppCompatActivity {
    private WebView webview;
    private String url = "file:///android_asset/login.html";//这是你要访问你html文件的存放地址，我这个是放在appache中的word文件夹下的login.html文件
    private String datafromHTML;
    private Context mcontext;
    private Button button;
    public JsObject jsObject;
    private URL ADDR;
    private InputStream in;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mcontext = this;
        webview = (WebView) findViewById(R.id.webView);
        button = (Button) findViewById(R.id.button);
        jsObject = new JsObject();


        WebSettings webset = webview.getSettings();
        webset.setJavaScriptEnabled(true);// 表示webview可以执行服务器端的js代码
        webview.setWebChromeClient(new WebChromeClient() {        });
        webview.addJavascriptInterface(jsObject, "jsObject");
        webview.loadUrl(url);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                webview.loadUrl("javascript:document.getElementById('Edit').innerHTML='Changed!';alert('hello');");
//                webview.loadUrl("javascript:document.getElementById('user').value='Changed!';alert('hello');");
//               Toast.makeText(mcontext,"From Javascript",Toast.LENGTH_SHORT).show();
//               jsObject.getMessage("name","password");
                Intent intent = new Intent(MainActivity.this,Gitdrawable.class);
                startActivity(intent);
            }
        });
    }


    public void onJavaScriptClick(){
        Toast.makeText(mcontext,"From Javascript",Toast.LENGTH_SHORT).show();
        webview.loadUrl("javascript:document.getElementById('Edit').innerHTML='Changed!'");
    }

    public class JsObject {
        String string = "alert('Controlhtml')";

        @JavascriptInterface
        public void getMessage(String name, String pwd) {
            // TODO Auto-generated method stub
            datafromHTML = name;
//            Toast.makeText(mcontext,"From Javascript",Toast.LENGTH_SHORT).show();
//            button.performClick();
//            webview.loadUrl("javascript:" + string);
            onJavaScriptClick();
        }
    }

}
