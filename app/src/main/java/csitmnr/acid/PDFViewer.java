package csitmnr.acid;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebView;

public class PDFViewer extends AppCompatActivity {
    WebView wv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pdfviewer);
        wv = (WebView) findViewById(R.id.wv);
        wv.getSettings().setJavaScriptEnabled(true);
        String url = "http://kmmc.in/wp-content/upload/2014/01/lesson2.pdf";
        wv.loadUrl("http://drive.google.com/viewerng/viewer?embedded=true&url="+url);
    }
}
