package pl.html5videofail;

import pl.onet.video.R;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.FrameLayout;

public class WideoActivity extends Activity {

	private FrameLayout customComponenet;

	@Override
	protected void onSaveInstanceState(Bundle outState) {
		((WebView) findViewById(R.id.webView)).saveState(outState);
		super.onSaveInstanceState(outState);
	}

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);

		customComponenet = (FrameLayout) findViewById(R.id.custom);

		WebView webView = (WebView) findViewById(R.id.webView);
		webView.getSettings().setDefaultZoom(WebSettings.ZoomDensity.MEDIUM);
		webView.getSettings().setJavaScriptEnabled(true);
		webView.getSettings().setDomStorageEnabled(false);
		webView.getSettings().setSupportMultipleWindows(false);
		webView.getSettings().setAllowFileAccess(false);
		webView.getSettings().setAppCacheEnabled(false);
		webView.getSettings().setNeedInitialFocus(false);
		webView.getSettings().setSupportZoom(false);

		webView.setWebChromeClient(new WebChromeClient() {

			@Override
			public void onShowCustomView(View view, CustomViewCallback callback) {
				customComponenet.addView(view);
			}
		});

		webView.loadUrl("file:///android_asset/index.html");
	}
}
