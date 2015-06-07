package com.comicenglish.app.beta;

import android.annotation.TargetApi;
import android.app.Activity;
// import android.support.v7.app.ActionBarActivity;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.webkit.CookieManager;
import android.webkit.WebSettings;
import android.webkit.WebView;


public class MainActivity extends Activity {

    // change to your apps URL
    public static String appUrl = null;

    private WebView mWebView;

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        appUrl = getString(R.string.app_url);

        mWebView = (WebView) findViewById(R.id.activity_main_webview);

        // Enable Javascript
        WebSettings webSettings = mWebView.getSettings();
        webSettings.setJavaScriptEnabled(true);

        mWebView.loadUrl(appUrl);
        // Force links and redirects to open in the WebView instead of in a browser
        mWebView.setWebViewClient(new WrapWebView());

        webSettings.setAppCacheEnabled(true);
        webSettings.setDatabaseEnabled(true);
        webSettings.setDomStorageEnabled(true);
        webSettings.setAllowUniversalAccessFromFileURLs(true);

        // http://stackoverflow.com/questions/1652850/android-webview-cookie-problem?rq=1
        Log.v("comwrap", "build.version: " + Build.VERSION.SDK_INT);
        Log.v("comwrap", "comwrap appUrl: " + appUrl);
        CookieManager cookieManager;
        cookieManager = CookieManager.getInstance();
        cookieManager.setAcceptCookie(true);

        if (Build.VERSION.SDK_INT >= 21) {
            // AppRTC requires third party cookies to work
            cookieManager.setAcceptThirdPartyCookies(mWebView, true);
        }

    }

    @Override
    public void onBackPressed() {
        if(mWebView.canGoBack()) {
            mWebView.goBack();
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
