package com.androidarchitecturecomponents;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.net.UrlQuerySanitizer;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;

/**
 * Created by Ashutosh Ojha on 1/30/19.
 */
public class WebviewActivity extends AppCompatActivity {
    private String url = "https://test-public-3024.yelo.red/authorizeAddCard.html?language=en&vendor_id=" +
            "10141&payment_method=16384&access_token=6d06f9f9dad269fc49bbf6d6ab08" +
            "d6ab42ffc535244c21da3b6b8e022d43168b02c489dbbb8e55a586dcc5e5029cb1a7&serv" +
            "er_url=https%3A%2F%2Ftest-payment-gateway.yelo.red&marketplace_user_id=55138&" +
            "user_id=55138&google_map_key=AIzaSyCx_xRaB_xQwbwxk89CuP_6qArT2E5Uun4&email=test@yopmail.com";
//    private String url = "https://public.monhapp.com/payfort_merchant_2.0.html?access_code=uYvFORGoI0xhYventf89&app_device_type=0&merchant_identifier=VfARjlJv&paraphrase=TEST12345&access_token=c8548142ef3e51a3f555ee8d54dcb70b7e428dca8d58597e526ba109952e539a6092af60f68125210533715ef9714ee3&marketplace_user_id=30074&vendor_id=53177&SERVER_URL=https://api.monhapp.com&addCardFormUrl=https://sbcheckout.PayFort.com/FortAPI/paymentPage", headerString = "";
    private boolean isTNC;
    private Activity mActivity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web);
        mActivity = this;




        WebView wvWebsite = findViewById(R.id.wvWebsite);
        wvWebsite.setWebViewClient(new MyWebViewClient());
        wvWebsite.setWebChromeClient(new WebChromeClient());
        wvWebsite.getSettings().setLoadsImagesAutomatically(true);
        wvWebsite.getSettings().setJavaScriptEnabled(true);
        wvWebsite.getSettings().setDomStorageEnabled(true);
        wvWebsite.setScrollBarStyle(View.SCROLLBARS_INSIDE_OVERLAY);

        if (url != null)
            if (isTNC) {
                wvWebsite.loadDataWithBaseURL(null, url, "text/html", "utf-8", null);
            } else {
                wvWebsite.loadUrl(url);
            }
    }



    @Override
    public void onBackPressed() {
//        super.onBackPressed();
        Bundle extras = new Bundle();
        extras.putBoolean("hitFetchMerchantCard", false);
        Intent intent = new Intent();
        intent.putExtras(extras);
        setResult(RESULT_OK, intent);
        finish();
    }

    private class MyWebViewClient extends WebViewClient {
        @Override
        public boolean shouldOverrideUrlLoading(WebView view, WebResourceRequest request) {
            return onOverrideUrlLoading(view, request.getUrl().toString());
        }

        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            return onOverrideUrlLoading(view, url);
        }

        @Override
        public void onPageFinished(WebView view, String url) {
            UrlQuerySanitizer sanitizer = new UrlQuerySanitizer(url);
            String transactionId = sanitizer.getValue("transactionId");
            String jobPaymentDetailId = sanitizer.getValue("job_payment_detail_id");

            if (url.startsWith("http:") || url.startsWith("https:")) {
                if (url.toLowerCase().contains("success")&& (transactionId != null && !transactionId.isEmpty())) {
                    Bundle extras = new Bundle();
                    extras.putBoolean("hitFetchMerchantCard", true);
                    if (transactionId != null && !transactionId.isEmpty()) {
                        extras.putString("transactionId", transactionId);
                        extras.putString("jobPaymentDetailId", jobPaymentDetailId);
                    }
                    Intent intent = new Intent();
                    intent.putExtras(extras);
                    setResult(RESULT_OK, intent);
                    finish();
                } else if (url.toLowerCase().contains("error")) {
//                    new AlertDialog.Builder(mActivity).message(getStrings(R.string.card_cannot_be_added)).listener(new AlertDialog.Listener() {
//                        @Override
//                        public void performPostAlertAction(int purpose, Bundle backpack) {
//                            Bundle extras = new Bundle();
//                            extras.putBoolean("hitFetchMerchantCard", false);
//                            Intent intent = new Intent();
//                            intent.putExtras(extras);
//                            setBanner(RESULT_OK, intent);
//                            finish();
//                        }
//                    }).build().show();
                }
            }
            super.onPageFinished(view, url);
        }

        @Override
        public void onPageStarted(WebView view, String url, Bitmap favicon) {
            super.onPageStarted(view, url, favicon);
        }
    }

    private boolean onOverrideUrlLoading(WebView view, String url) {
        Log.e("URL", url + "");
        UrlQuerySanitizer sanitizer = new UrlQuerySanitizer(url);
        String transactionId = sanitizer.getValue("transactionId");
        String jobPaymentDetailId = sanitizer.getValue("job_payment_detail_id");

        if (url.startsWith("http:") || url.startsWith("https:")) {
            view.loadUrl(url);
            if (url.toLowerCase().contains("success") && (transactionId != null && !transactionId.isEmpty())) {

                Bundle extras = new Bundle();
                extras.putBoolean("hitFetchMerchantCard", true);
                if (transactionId != null && !transactionId.isEmpty()) {
                    extras.putString("transactionId", transactionId);
                    extras.putString("jobPaymentDetailId", jobPaymentDetailId);
                }
                Intent intent = new Intent();
                intent.putExtras(extras);
                setResult(RESULT_OK, intent);
                finish();
            } else if (url.toLowerCase().contains("error")) {
//                new AlertDialog.Builder(mActivity).message(getStrings(R.string.card_cannot_be_added)).listener(new AlertDialog.Listener() {
//                    @Override
//                    public void performPostAlertAction(int purpose, Bundle backpack) {
//                        Bundle extras = new Bundle();
//                        extras.putBoolean("hitFetchMerchantCard", false);
//                        Intent intent = new Intent();
//                        intent.putExtras(extras);
//                        setBanner(RESULT_OK, intent);
//                        finish();
//                    }
//                }).build().show();
            }
        } else if (url.startsWith(WebView.SCHEME_TEL) ||
                url.startsWith("sms:") ||
                url.startsWith(WebView.SCHEME_MAILTO) ||
                url.startsWith(WebView.SCHEME_GEO) ||
                url.startsWith("maps:")) {
            try {
                Log.d("WEbview", "loading in external app");
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse(url.replace("Not Available", "")));
                startActivity(intent);
            } catch (android.content.ActivityNotFoundException e) {
                Log.e("WEbview", "Error opening external app " + url + ": " + e.toString());
            }
        } else if (url.startsWith("intent:")) {
        } else {
            return true;
        }
        return true;
    }
}
