package ken.example.anew;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

public class WebviewActivity2 extends AppCompatActivity {
WebView webView;
Button btn;
TextView text;
EditText edit;
SeekBar seekbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_webview2);

        webView = findViewById(R.id.web);
        btn= findViewById(R.id.search);
        text= findViewById(R.id.text);
        edit= findViewById(R.id.url);
        seekbar= findViewById(R.id.seekbar);

    }
    private void startbrowsing(final String pre){

       // Toast.makeText(WebviewActivity2.this, "welcome", Toast.LENGTH_LONG).show();
        WebSettings settings = webView.getSettings();
        settings.setJavaScriptEnabled(true);

        //settings.setLoadsImagesAutomatically(true);
        //webView.setScrollBarStyle(View.SCROLLBARS_OUTSIDE_OVERLAY);
//        seekbar= new SeekBar(WebviewActivity2.this);
//        seekbar.setOnSeekBarChangeListener(new  );

        webView.setWebViewClient(new WebViewClient()


        {
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                //return super.shouldOverrideUrlLoading(view, url);
                //Toast.makeText(WebviewActivity2.this, url+"pp3", Toast.LENGTH_LONG).show();
                Log.i("first",url);
                view.loadUrl("https://"+pre);
                return false;
            }

            @Override
            public void onPageFinished(WebView view, String url) {

            }

            @Override
            public void onReceivedError(WebView view, int errorCode, String description, String failingUrl) {
               // super.onReceivedError(view, errorCode, description, failingUrl);
                Toast.makeText(WebviewActivity2.this, "Error", Toast.LENGTH_LONG).show();
//                if (url.startsWith("https")){
//                    startbrowsing(url.replace("https"),"http");
//
//                }
            }
        });
    }

    public void search(View view) {
        //webView.setVisibility(View.VISIBLE);
        String Ur =edit.getText().toString();
        if (Ur.startsWith("www")){
            startbrowsing(Ur);
        } else{
           Toast.makeText(WebviewActivity2.this, "Invalid Url", Toast.LENGTH_LONG).show();
        }
    }

    public void back(View view) {
        if (webView.canGoBack()){
            webView.goBack();

        } else{
            Toast.makeText(WebviewActivity2.this, "This is the last page", Toast.LENGTH_LONG).show();
        }

    }

    public void next(View view) {
        if (webView.canGoForward()){
            webView.goForward();

        } else{
            Toast.makeText(WebviewActivity2.this, "This is the last page", Toast.LENGTH_LONG).show();
        }
    }
}