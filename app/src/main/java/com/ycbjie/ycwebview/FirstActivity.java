package com.ycbjie.ycwebview;

import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.KeyEvent;

import com.ycbjie.webviewlib.X5WebView;

public class FirstActivity extends AppCompatActivity {

    private X5WebView webView;

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            if (webView.canGoBack()) {
                webView.goBack();
                return true;
                //退出网页
            } else {
                handleFinish();
            }
        }
        return false;
    }

    public void handleFinish() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            finishAfterTransition();
        } else {
            finish();
        }
    }


    @Override
    protected void onDestroy() {
        try {
            if (webView != null) {
                webView.destroy();
                webView = null;
            }
        } catch (Exception e) {
            Log.e("X5WebViewActivity", e.getMessage());
        }
        super.onDestroy();
    }



    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);
        webView = findViewById(R.id.web_view);
//        String url = "https://github.com/yangchong211";
        String url = "https://mobile.yangkeduo.com/duo_coupon_landing.html?goods_id=54692045397&pid=9283978_120621399&customParameters=100123350538&cpsSign=CC_191120_9283978_120621399_c60cc9ffe8bbba684dd0abf1d27d4896&duoduo_type=2";
        webView.loadUrl(url);
    }
}
